
	//关于
	function showAbount(){
		$('#abount').dialog({    
		    title: '关于',    
		    width: 690,    
		    height: 400,    
		    closed: false,    
		    cache: false,    
		    href: 'page/common/abount.html',    
		    modal: true,
		    buttons:[{
				iconCls:"icon-cancel",
				text:'关闭',
				handler:function(){
					$("#abount").dialog("close");
				}
			}]
		});
	}
	//确认退出
	function doExit(){
		$.messager.confirm("消息","确认要退出系统?",function(data){
			if(data){
				$.ajax({
					url : "sysUser/logout",
					method : "POST",
					dataType:'JSON',
					success : function(data) {
						var ret = eval(data);
//						var casUrl = ret.data.casUrl;
//						var localUrl = ret.data.localUrl;
//						var logoutUrl = casUrl+"/logout?service="+casUrl+"/login?service="+localUrl;
                        if(ret.success){
                            window.location.href="login.html";
                        }else{
                            $.messager.alert('错误',ret.errorMsg);
                        }
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						$.messager.alert('错误','登出失败');
					}
				});
			}else{
				return;
			}
		});
	}

	function uppassdia(){
		$('#uppass').dialog({    
		    title: '密码修改',    
		    width: 430,    
		    height: 250,   
		    cache: false,    
		    href: 'page/common/uppwd.html',    
		    modal: true,
		});
		$(".panel-tool-close").css("display","none");
	}
	function colsedialog(){
		$("#uppass").dialog("close");
	}
	function opendialog(){
		uppassdia();
		$("#uppass").dialog("open");
	}
	function savepass(){
		var flag = $("#upForm").form('enableValidation').form('validate');
		if(!flag){
			return;
		}else if($("#newpass").val()!=$("#newpasst").val()){
			$.messager.alert("提示","再次输入密码内容错误！");
			return;
		}
		var oldpassval=$("#oldpass").val();
		var newpassval=$("#newpass").val();
		var postData = {"oldpass":oldpassval, "newpass":newpassval};
		$.messager.confirm("提示框","确定要执行操作吗?",function(data){
			if(data){
				$.ajax({
					url : "sysUser/updatePass",
					method : "POST",
					dataType : "json",
					async : false,
					data : postData,
					success : function(data) {
						var ret = eval(data);
						if(ret.success){
							$.messager.alert('提示','操作成功');
							colsedialog();
						}else{
							$.messager.alert('错误','操作失败:'+ret.errormsg);
						}
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						var result = JSON.parse(XMLHttpRequest.responseText);
						$.messager.alert('错误',result.errorMsg);
					}
				});
			}else{
				return;
			}
		});
	}