
		function delSecurityDo() {
			var secInf = $('#secInfGrid').datagrid('getSelected');
			if (null == secInf || undefined == secInf) {
				$.messager.alert('提示', '请选择要删除的控件');
				return;
			}
			$.messager.confirm('确认','您确认要删除控件【' + secInf.btnName + '】吗？',function(flag) {
					if (flag) {
						$.ajax({
								url : "../../sysSecurity/delSecurity",
								method : "POST",
								dataType : "json",
								async : false,
								data : {
									"scsId" : secInf.scsId
								},
								success : function(data) {
									var ret = eval(data);
									if (ret.success) {
										$.messager.alert('提示', '操作成功！');
										$('#secInfGrid').datagrid('reload');
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
		function updateSecurityDo() {
			var securityInfo = $('#secInfGrid').datagrid('getSelected');
			if (null == securityInfo || undefined == securityInfo) {
				$.messager.alert('提示', '请选择要修改的控件');
				return;
			}
			$('#updateSecurity').dialog(
					{
						title : '修改控件',
						width: 400,    
						height: 350,    
						closed : false,
						cache : false,
						href : 'securityUpdate.html',
						modal : true,
						buttons : [
								{
									iconCls : "icon-ok",
									text : '提交',
									handler : function() {
										doUpdateSecurity();
									}
								},
								{
									iconCls : "icon-undo",
									text : '重置',
									handler : function() {
										updateSecurityDo();
									}
								}, {
									iconCls : "icon-cancel",
									text : '取消',
									handler : function() {
										$("#updateSecurity").dialog("close");
									}
								} ]
					});
		}
		//新增菜单
		function addSecurityDo(){
			var sysMenuNode = $('#securityTree').tree('getSelected');
			if(null == sysMenuNode || undefined == sysMenuNode||null==sysMenuNode.id){
				$.messager.alert('提示','请选择页面菜单!');
				return;
			}
			$('#addSecurity').dialog({    
			    title: '新增控件',    
			    width: 400,    
			    height: 350,    
			    closed: false,    
			    cache: false,    
			    href: 'sysSecurityAdd.html',    
			    modal: true,
			    buttons:[{
			    	iconCls:"icon-ok",
					text:'提交',
					handler:function(){
						doAddSecurity();
					}
				},{
			    	iconCls:"icon-undo",
					text:'重置',
					handler:function(){
						addSecurityDo();
					}
				},{
					iconCls:"icon-cancel",
					text:'取消',
					handler:function(){
						$("#addSecurity").dialog("close");
					}
				}]
			});
		}

		//刷新商户菜单树
		function reloadSecurityTree(){
			$('#securityTree').tree('reload');
		}

		function searchSecurityFlow(parentIdVal){
			$('#secInfGrid').datagrid({    
		        pageSize:25,//每页显示的记录条数，默认为10 
		        pageList: [25,50,100],//可以设置每页记录条数的列表 
			    url:'../../sysSecurity/query',
			    pagination:true,
			    rownumbers:true,
			    singleSelect:true,
			    height:'100%',
			    onBeforeLoad:function(){
			    	if(null == parentIdVal || undefined == parentIdVal){
			    		return false;
			    	}
			    },
			    queryParams:{
			    	condition:'',
			    	state:'',
			    	parentId:parentIdVal
			    },
			    loadFilter: function(ret){    
			        if (ret.success){    
			            return ret;    
			        } else {    
			        	$.messager.alert('提示',ret.errorMsg);
			        }    
			    },   
			    columns:[[
					{field:'scsId',title:'编号',width:120,hidden:true},     
			        {field:'mainModule',title:'主模块',width:120},
			        {field:'pageName',title:'所属页面名称',width:200},
			        {field:'pageKey',title:'所属页面KEY',width:200},
			        {field:'btnName',title:'控件名称',width:150},
			        {field:'btnKey',title:'控件KEY',width:150},
			        {field:'slaveModuleMenuid',title:'控件所属菜单ID',width:100,hidden:true},
			        {field:'state',title:'控件状态',width:150,formatter:formatterSecurity},
			        {field:'opeartor',title:'操作人',width:150},
			        {field:'createTime',title:'创建时间',width:250},
			        {field:'updateTime',title:'修改时间',width:250},
			    ]]

			});  
			//设置分页控件 
		    var p = $('#secInfGrid').datagrid('getPager'); 
		    $(p).pagination({ 
		        beforePageText: '第',//页数文本框前显示的汉字 
		        afterPageText: '页    共 {pages} 页', 
		        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
		    });
		}