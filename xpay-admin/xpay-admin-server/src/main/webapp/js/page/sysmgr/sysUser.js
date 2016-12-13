function searchSysUser(){
	var conditionVal = $("#condition").val();
	$('#sysUserGrid').datagrid({    
		 pageSize: 25,//每页显示的记录条数，默认为10 
	     pageList: [25,50,100],//可以设置每页记录条数的列表 
	    url:'../../sysUser/querySysUser',
	    pagination:true,
	    rownumbers:true,
	    singleSelect:true,
	    height:'100%',
	    queryParams:{
	    	pageSize:10,
	    	currentPageNum:1,
	    	condition:conditionVal
	    },
	    loadFilter: function(ret){    
	        if (ret.success){    
	            return ret;    
	        } else {    
	            alert("用户加载失败");
	        }    
	    },   
	    columns:[[    
	        {field:'trueName',title:'姓名',width:100}, 
	        {field:'loginName',title:'用户名',width:120}, 
	        {field:'idNo',title:'身份证号',width:150}, 
	        {field:'mobile',title:'联系电话',width:100}, 
	        {field:'address',title:'联系地址',width:200}, 
	        {field:'userMail',title:'邮箱',width:200}, 
	        {field:'userState',title:'状态',width:100,formatter:formatterUSERTYPE}, 
//	        {field:'lastLoginTime',title:'上次登录时间',width:150}
	    ]]

	});  
	//设置分页控件 
    var p = $('#sysUserGrid').datagrid('getPager'); 
    $(p).pagination({ 
        beforePageText: '第',//页数文本框前显示的汉字 
        afterPageText: '页    共 {pages} 页', 
        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
    });
}

//重置用户密码
function resetPass() {
	var selSysUser = $('#sysUserGrid').datagrid('getSelected');
	if (null == selSysUser || undefined == selSysUser) {
		$.messager.alert('提示', '请选择要重置密码的用户');
		return;
	}
	$.messager.confirm('确认','您确认要重置用户【' + selSysUser.trueName + '】密码吗？',function(data) {
		if (data) {
			$.ajax({
				url : "../../sysUser/resetPass",
				method : "POST",
				dataType : "json",
				async : false,
				data : {
					"id" : selSysUser.id
				},
				success : function(data) {
					var ret = eval(data);
					if (ret.success) {
						$.messager.alert('提示', '操作成功,登录密码已下发至您的邮箱，请注意查收！');
						$('#sysUserGrid').datagrid('reload');
					} else {
						$.messager.alert('错误', ret.errorMsg);
					}
				},
				error : function(XMLHttpRequest, textStatus,errorThrown) {
					var result = JSONparse(XMLHttpRequest.responseText);
					$.messager.alert('错误', result.errorMsg);
				}
			});
		}
	});
}
//新增用户
function addSysUser() {
	$('#addSysUser').dialog(
			{
				title : '新增用户',
				width : 600,
				height : 420,
				closed : false,
				cache : false,
				href : 'sysUserAdd.html',
				modal : true,
				buttons : [
						{
							iconCls : "icon-ok",
							text : '提交',
							handler : function() {
								doAddSysUser();
							}
						},
						{
							iconCls : "icon-undo",
							text : '重置',
							handler : function() {
								$.messager.confirm("操作提示",
										"重置只会重置基本信息内容，您确定要执行操作吗？",
										function(data) {
											if (data) {
												$("#addSysUserForm").form('clear');
											} else {
												return;
											}
										});

							}
						}, {
							iconCls : "icon-cancel",
							text : '取消',
							handler : function() {
								$("#addSysUser").dialog("close");
							}
						} ]
			});
}

//删除用户

function delSysUser() {
	var selSysUser = $('#sysUserGrid').datagrid('getSelected');
	if (null == selSysUser || undefined == selSysUser) {
		$.messager.alert('提示', '请选择要删除的用户');
		return;
	}
	if(selSysUser.loginName=='admin'){
		$.messager.alert('提示', '超级管理员用户不允许删除！');
		return;
	}
	$.messager.confirm('确认','您确认要删除用户【' + selSysUser.trueName + '】吗？',function(flag) {
			if (flag) {
				$.ajax({
						url : "../../sysUser/delSysUser",
						method : "POST",
						dataType : "json",
						async : false,
						data : {
							"id" : selSysUser.id
						},
						success : function(data) {
							var ret = eval(data);
							if (ret.success) {
								$.messager.alert('提示', '操作成功！');
								$('#sysUserGrid').datagrid('reload');
							} else {
								$.messager.alert('错误',ret.errorMsg);
							}
						},
						error : function(XMLHttpRequest,textStatus, errorThrown) {
							var result = JSON.parse(XMLHttpRequest.responseText);
							$.messager.alert('错误',result.errorMsg);
						}
					});
			}
		});
}

//修改用户
function updateSysUser() {
	var selSysUser = $('#sysUserGrid').datagrid('getSelected');
	if (null == selSysUser || undefined == selSysUser) {
		$.messager.alert('提示', '请选择要修改的用户');
		return;
	}
	$('#updateSysUser').dialog(
			{
				title : '修改用户',
				width : 600,
				height : 420,
				closed : false,
				cache : false,
				href : 'sysUserUpdate.html',
				modal : true,
				buttons : [
						{
							iconCls : "icon-ok",
							text : '提交',
							handler : function() {
								doUpdateSysUser();
							}
						},
						{
							iconCls : "icon-undo",
							text : '重置',
							handler : function() {
								$.messager.confirm("操作提示",
										"重置将还原填写内容，您确定要执行操作吗？",
										function(data) {
											if (data) {
												updateSysUser();
												//$("#updateSysUserForm").form('clear');
											} else {
												return;
											}
										});

							}
						}, {
							iconCls : "icon-cancel",
							text : '取消',
							handler : function() {
								$("#updateSysUser").dialog("close");
							}
						} ]
			});
}