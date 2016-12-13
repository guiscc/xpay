
		function loadData(){
			$('#sysMenuTree').tree({    
			    url: "../../sysMenu/getSysMenuTree",
			    method:"post",
			    animate:true,
			    loadFilter: function(ret){    
			        if (ret.success){    
			            return ret.data;    
			        } else {    
			        	$.messager.alert("提示","菜单加载失败");
			        }    
			    },
			    onClick: function(node){
			    	if(null == node.id || undefined == node.id){
			    		return false;
			    	}
			    	loadSysMenu(node.id);
				}
			}); 
			loadSysMenu(null);
		}
		function loadSysMenu(parentId){
			$('#sysMenuGrid').datagrid({ 
				pageSize:25 ,
				pageList: [25,50,100],//可以设置每页记录条数的列表 
				url:'../../sysMenu/querySysMenu',
				pagination:true,
				rownumbers:true,
				singleSelect:true,
				height:'100%',
				onBeforeLoad:function(){
					if(null == parentId || undefined == parentId){
						return false;
					}
				},
				queryParams:{
					condition:parentId
				},
				loadFilter: function(ret){    
					if (ret.success){    
						return ret;    
					} else {    
						$.messager.alert("提示","菜单加载失败");
					}    
				},   
				columns:[[    
				          {field:'menuName',title:'菜单名称',width:100},    
				          {field:'menuKey',title:'菜单KEY',width:100},    
				          {field:'menuUrl',title:'URL',width:150},    
				          {field:'menuState',title:'状态',width:100,formatter:formatterMenuState},
				          {field:'menuLeaf',title:'是否为子菜单',width:100,formatter:function(value,row,index){
				        	  if (value == "1"){
				        		  return "是";
				        	  } else {
				        		  return "否";
				        	  }
				        	  
				          },hidden:true},
				          {field:'menuIndex',title:'排序索引',width:100},
				          {field:'menuIcon',title:'图标',width:150}
				          ]]
				
			});
			//设置分页控件 
			var p = $('#sysMenuGrid').datagrid('getPager'); 
			$(p).pagination({ 
				beforePageText: '第',//页数文本框前显示的汉字 
				afterPageText: '页    共 {pages} 页', 
				displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
			});
		}
		//新增菜单
		function addSysMenu(){
			var sysMenuNode = $('#sysMenuTree').tree('getSelected');
			if(null == sysMenuNode || undefined == sysMenuNode){
				$.messager.alert('提示','请选择菜单');
				return;
			}
			$('#addSysMenu').dialog({    
			    title: '新增菜单',    
			    width: 400,    
			    height: 350,    
			    closed: false,    
			    cache: false,    
			    href: 'sysMenuAdd.html',    
			    modal: true,
			    buttons:[{
			    	iconCls:"icon-ok",
					text:'提交',
					handler:function(){
						doAddSysMenu();
					}
				},{
			    	iconCls:"icon-undo",
					text:'重置',
					handler:function(){
						$("#addSysMenuForm").form('clear');
					}
				},{
					iconCls:"icon-cancel",
					text:'取消',
					handler:function(){
						$("#addSysMenu").dialog("close");
					}
				}]
			});
		}
		
		//删除菜单
		function delSysMenu(){
			var selSysMenu = $('#sysMenuGrid').datagrid('getSelected');
			if(null == selSysMenu || undefined == selSysMenu){
				$.messager.alert('提示','请选择要删除的菜单');
				return;
			}
			$.messager.confirm('确认','您确认要删除菜单【'+selSysMenu.menuName+'】吗？',function(flag){    
			    if (flag){    
			    	$.ajax({
						url : "../../sysMenu/delSysMenu",
						method : "POST",
						dataType : "json",
						async : false,
						data : {"id" : selSysMenu.id},
						success : function(data) {
							var ret = eval(data);
							if(ret.success){
								$('#sysMenuGrid').datagrid('reload');
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
		
		//修改菜单
		function updateSysMenu(){
			var selSysMenu = $('#sysMenuGrid').datagrid('getSelected');
			if(null == selSysMenu || undefined == selSysMenu){
				$.messager.alert('提示','请选择要修改的菜单');
				return;
			}
			$('#updateSysMenu').dialog({    
			    title: '修改菜单',    
			    width: 400,    
			    height: 350,    
			    closed: false,    
			    cache: false,    
			    href: 'sysMenuUpdate.html',    
			    modal: true,
			    buttons:[{
			    	iconCls:"icon-ok",
					text:'提交',
					handler:function(){
						doUpdateSysMenu();
					}
				},{
			    	iconCls:"icon-undo",
					text:'重置',
					handler:function(){
						$("#updateSysMenuForm").form('clear');
					}
				},{
					iconCls:"icon-cancel",
					text:'取消',
					handler:function(){
						$("#updateSysMenu").dialog("close");
					}
				}]
			});
		}
		
		//刷新菜单树
		function reloadSysMenuTree(){
			$('#sysMenuTree').tree('reload');
		}