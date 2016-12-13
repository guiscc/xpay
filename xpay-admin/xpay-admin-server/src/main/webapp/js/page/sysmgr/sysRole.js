
		function searchRole(){
			var rolename = $("#condition").val();
			$('#sysRoleGrid').datagrid({    
			    pageSize:25 ,
		        pageList: [25,50,100],//可以设置每页记录条数的列表 
		       url:'../../sysRole/querySysRole',
			    pagination:true,
			    rownumbers:true,
			    singleSelect:true,
			    height:'100%',
			    queryParams:{
			    	condition:rolename
			    },
			    loadFilter: function(ret){    
			        if (ret.success){    
			            return ret;    
			        } else {    
			        	$.messager.alert("提示","角色/岗位加载失败");
			        }    
			    },   
			    columns:[[    
			        {field:'roleName',title:'名称',width:200},    
			        {field:'memo',title:'描述',width:400}    
			    ]],
			});  
			//设置分页控件 
		    var p = $('#sysRoleGrid').datagrid('getPager'); 
		    $(p).pagination({ 
		         beforePageText: '第',//页数文本框前显示的汉字 
		        afterPageText: '页    共 {pages} 页', 
		        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
		    });
		}
		//修改模块权限
		function updSysModelMenu(){
			var selSysRole = $('#sysRoleGrid').datagrid('getSelected');
			if(null == selSysRole || undefined == selSysRole){
				$.messager.alert('提示','请选择要修改的角色');
				return;
			}
			$('#updateSysRole').dialog({    
				title: '修改角色－模块',    
				width: 400,    
				height: 350,    
				closed: false,    
				cache: false,    
				href: 'sysRoleUpdate4Model.html',    
				modal: true,
				buttons:[{
					iconCls:"icon-ok",
					text:'提交',
					handler:function(){
						doUpdateSysRoleModel();
					}
				},{
					iconCls:"icon-undo",
					text:'重置',
					handler:function(){
						$.messager.confirm("操作提示", "重置将还原修改内容，您确定要执行操作吗？", function (data) {
							if (data) {
								updSysModelMenu();
							}
							else {
								return;
							}
						});
					}
				},{
					iconCls:"icon-cancel",
					text:'取消',
					handler:function(){
						$("#updateSysRole").dialog("close");
					}
				}]
			});
		}
		//修改菜单权限
		function updSysRoleMenu(){
			var selSysRole = $('#sysRoleGrid').datagrid('getSelected');
			if(null == selSysRole || undefined == selSysRole){
				$.messager.alert('提示','请选择要修改的角色');
				return;
			}
			$('#updateSysRole').dialog({    
			    title: '修改角色－菜单',    
			    width: 400,    
			    height: 350,    
			    closed: false,    
			    cache: false,    
			    href: 'sysRoleUpdate4Menu.html',    
			    modal: true,
			    buttons:[{
			    	iconCls:"icon-ok",
					text:'提交',
					handler:function(){
						doUpdateSysRoleMenu();
					}
				},{
			    	iconCls:"icon-undo",
					text:'重置',
					handler:function(){
						$.messager.confirm("操作提示", "重置将还原修改内容，您确定要执行操作吗？", function (data) {
				            if (data) {
				            	updSysRoleMenu();
				            }
				            else {
				            	return;
				            }
				        });
					}
				},{
					iconCls:"icon-cancel",
					text:'取消',
					handler:function(){
						$("#updateSysRole").dialog("close");
					}
				}]
			});
		}
		function updSysRoleBtn(){

			var selSysRole = $('#sysRoleGrid').datagrid('getSelected');
			if(null == selSysRole || undefined == selSysRole){
				$.messager.alert('提示','请选择要修改的角色');
				return;
			}
			$('#updateSysRole').dialog({    
			    title: '修改角色-权限',    
			    width: 400,    
			    height: 350,    
			    closed: false,    
			    cache: false,    
			    href: 'sysRoleUpdate4Btn.html',    
			    modal: true,
			    buttons:[{
			    	iconCls:"icon-ok",
					text:'提交',
					handler:function(){
						updSysRoleBtnDo();
					}
				},{
			    	iconCls:"icon-undo",
					text:'重置',
					handler:function(){
						$.messager.confirm("操作提示", "重置将还原填写内容，您确定要执行操作吗？", function (data) {
				            if (data) {
				            	updSysRoleBtn();
				            }
				            else {
				            	return;
				            }
				        });
					}
				},{
					iconCls:"icon-cancel",
					text:'取消',
					handler:function(){
						$("#updateSysRole").dialog("close");
					}
				}]
			});
		}
		//新增角色/岗位
		function addSysRole(){
			$('#addSysRole').dialog({    
			    title: '新增角色/岗位',    
			    width: 400,    
			    height: 200,    
			    closed: false,    
			    cache: false,    
			    href: 'sysRoleAdd.html',    
			    modal: true,
			    buttons:[{
			    	iconCls:"icon-ok",
					text:'提交',
					handler:function(){
						doAddSysRole();
					}
				},{
			    	iconCls:"icon-undo",
					text:'重置',
					handler:function(){
						$.messager.confirm("操作提示", "重置只会重置基本信息内容，您确定要执行操作吗？", function (data) {
				            if (data) {
				            	$("#addSysRoleForm").form('clear');
				            }
				            else {
				            	return;
				            }
				        });
					}
				},{
					iconCls:"icon-cancel",
					text:'取消',
					handler:function(){
						$("#addSysRole").dialog("close");
					}
				}]
			});
		}
		
		//删除角色/岗位
		function delSysRole(){
			var selSysRole = $('#sysRoleGrid').datagrid('getSelected');
			if(null == selSysRole || undefined == selSysRole){
				$.messager.alert('提示','请选择要删除的角色/岗位');
				return;
			}
			$.messager.confirm('确认','您确认要删除角色/岗位【'+selSysRole.roleName+'】吗？',function(flag){    
			    if (flag){    
			    	$.ajax({
						url : "../../sysRole/delSysRole",
						method : "POST",
						dataType : "json",
						async : false,
						data : {"id" : selSysRole.id},
						success : function(data) {
							var ret = eval(data);
							if(ret.success){
								$('#sysRoleGrid').datagrid('reload');
							}else{
								$.messager.alert('错误','操作失败');
							}
						},
						error : function(XMLHttpRequest, textStatus, errorThrown) {
							var result = JSON.parse(XMLHttpRequest.responseText);
							$.messager.alert('错误',result.errorMsg);
						}
					});
			    }    
			});  
		}
		
		//修改角色/岗位
		function updateSysRole(){
			var selSysRole = $('#sysRoleGrid').datagrid('getSelected');
			if(null == selSysRole || undefined == selSysRole){
				$.messager.alert('提示','请选择要修改的角色');
				return;
			}
			$('#updateSysRole').dialog({    
			    title: '修改角色',    
			    width: 400,    
			    height: 200,    
			    closed: false,    
			    cache: false,    
			    href: 'sysRoleUpdate.html',    
			    modal: true,
			    buttons:[{
			    	iconCls:"icon-ok",
					text:'提交',
					handler:function(){
						doUpdateSysRole();
					}
				},{
			    	iconCls:"icon-undo",
					text:'重置',
					handler:function(){
						$.messager.confirm("操作提示", "重置将还原填写内容，您确定要执行操作吗？", function (data) {
				            if (data) {
				            	updateSysRole();
				            }
				            else {
				            	return;
				            }
				        });
					}
				},{
					iconCls:"icon-cancel",
					text:'取消',
					handler:function(){
						$("#updateSysRole").dialog("close");
					}
				}]
			});
		}