
		//修改节假日
		function editInfo() {
			var selSysUser = $('#msgCalendar').datagrid('getSelected');
			if (null == selSysUser || undefined == selSysUser) {
				$.messager.alert('提示', '请选择要修改的节假日');
				return;
			}
			$('#editCalendar').dialog({
				title : '修改节假日',
				width : 600,
				height : 420,
				closed : false,
				cache : false,
				href : 'calendarEdit.html',
				modal : true,
				buttons : [ {
					iconCls : "icon-ok",
					text : '提交',
					handler : function() {
						editCalendarDo();
					}
				}, {
					iconCls : "icon-undo",
					text : '重置',
					handler : function() {
						editInfo();
					}
				}, {
					iconCls : "icon-cancel",
					text : '取消',
					handler : function() {
						$("#editCalendar").dialog("close");
					}
				} ]
			});
		}

		function editCalendarDo() {
			var flag = $("#editCalendarForm").form('enableValidation').form(
					'validate');
			if (!flag) {
				return;
			}
			var postData = JSON.stringify($("#editCalendarForm").serializeJSON());
			$.ajax({
				url : "../../calendar/editInfo",
				method : "POST",
				contentType : "application/json",
				dataType : "json",
				async : false,
				data : postData,
				success : function(data) {
					var ret = eval(data);
					if (ret.success) {
						$.messager.alert("提示", "操作成功！");
						$("#editCalendar").dialog("close");
						searchCalendar();
					} else {
						$.messager.alert('错误', '操作失败');
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					var result = JSON.parse(XMLHttpRequest.responseText);
					$.messager.alert('错误', result.errorMsg);
				}
			});
		}
		function addCalendarDo() {
			var flag = $("#addCalendarForm").form('enableValidation').form(
					'validate');
			if (!flag) {
				return;
			}
			var postData = JSON
					.stringify($("#addCalendarForm").serializeJSON());
			$.ajax({
				url : "../../calendar/add",
				method : "POST",
				contentType : "application/json",
				dataType : "json",
				async : false,
				data : postData,
				success : function(data) {
					var ret = eval(data);
					if (ret.success) {
						$("#addCalendar").dialog("close");
						searchCalendar();
						$.messager.alert("提示", "操作成功！");
					} else {
						$.messager.alert('错误', '操作失败');
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					var result = JSON.parse(XMLHttpRequest.responseText);
					$.messager.alert('错误', result.errorMsg);
				}
			});
		}

		function onSelect(data){
			var s = $('#dayType').combobox('getValue');
			$("#dayTypeVal").val(s);
		}
		function onSelectMonth(data){
			var s = $('#month').combobox('getValue');
			$("#monthVal").val(s);
		}
		function addCalendar() {
			$('#addCalendar').dialog({
				title : '添加节假日',
				width : 600,
				height : 420,
				closed : false,
				cache : false,
				href : 'calendarAdd.html',
				modal : true,
				buttons : [ {
					iconCls : "icon-ok",
					text : '提交',
					handler : function() {
						addCalendarDo();
					}
				}, {
					iconCls : "icon-undo",
					text : '重置',
					handler : function() {
						$("#addCalendarForm").form('clear');
					}
				}, {
					iconCls : "icon-cancel",
					text : '关闭',
					handler : function() {
						$("#addCalendar").dialog("close");
					}
				} ]
			});
		}
		function delInfo() {
			var selinfo = $('#msgCalendar').datagrid('getSelected');
			if (null == selinfo || undefined == selinfo) {
				$.messager.alert('提示', '请选择要删除的节假日');
				return;
			}
			$.messager.confirm('确认', '您确认要删除节假日【' + selinfo.calendarName
					+ '】吗？', function(flag) {
				if (flag) {
					$.ajax({
						url : "../../calendar/delInfo",
						method : "POST",
						dataType : "json",
						async : false,
						data : {
							"id" : selinfo.id
						},
						success : function(data) {
							var ret = eval(data);
							if (ret.success) {
								$.messager.alert('提示', '操作成功！');
								$('#msgCalendar').datagrid('reload');
							} else {
								$.messager.alert('错误', ret.errorMsg);
							}
						},
						error : function(XMLHttpRequest, textStatus,
								errorThrown) {
							var result = JSON
									.parse(XMLHttpRequest.responseText);
							$.messager.alert('错误', result.errorMsg);
						}
					});
				}
			});
		}

		function searchCalendar() {
			var name = $("#condition").val();
			var daytype=$("#dayTypeVal").val();
			var month=$("#monthVal").val();
			$('#msgCalendar').datagrid({
				pageSize : 25,//每页显示的记录条数，默认为10 
				pageList : [ 25, 50, 100 ],//可以设置每页记录条数的列表 
				url : '../../calendar/queryPage',
				pagination : true,
				rownumbers : true,
				singleSelect : true,
				height : '100%',
				queryParams : {
					cName:name,
					daytype:daytype,
					month:month
				},
				loadFilter : function(ret) {
					if (ret.success) {
						return ret;
					} else {
						$.messager.alert("提示", "信息加载失败");
					}
				},
				columns : [ [ {
					field : 'id',
					title : 'ID',
					width : 120
				}, {
					field : 'calendarName',
					title : '节假日名称',
					width : 120
				}, {
					field : 'calendarMonth',
					title : '月',
					width : 120,formatter:formatterMonth
				}, {
					field : 'calendarDay',
					title : '日',
					width : 150,formatter:formatterDay
				},{
					field : 'dayType',
					title : '节假日类型',
					width : 150,formatter:formatterDayType
				},

				] ]

			});
			//设置分页控件 
			var p = $('#msgCalendar').datagrid('getPager');
			$(p).pagination({
				beforePageText : '第',//页数文本框前显示的汉字 
				afterPageText : '页    共 {pages} 页',
				displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',
			});
		}