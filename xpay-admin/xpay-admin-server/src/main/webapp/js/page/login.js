document.onkeydown=function(event){ 
			e = event ? event :(window.event ? window.event : null); 
			if(e.keyCode==13){ 
			//执行的方法 
				doLogin();
			} 
		} 

function changeImg() {
    var imgSrc = $("#imgObj");
    var src = imgSrc.attr("src");
    imgSrc.attr("src",chgUrl(src));
}
//时间戳   
//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳   
function chgUrl(url) {
    var timestamp = (new Date()).valueOf();
    url = url.substring(0, 17);
    if ((url.indexOf("&") >= 0)) {
        url = url + "×tamp=" + timestamp;
    } else {
        url = url + "?timestamp=" + timestamp;
    }
    return url;
}
function back(){
	window.location.href = "login.html";
}
//登录
function confimCode() {
	var flag = $("#codeForm").form('enableValidation').form('validate');
	if (!flag) {
		return;
	}
	var code = $("#mobileCode").val();
	$.ajax({
		url : "sysUser/login",
		method : "POST",
		dataType : "json",
		async : false,
		data : {
			"code" : code,
		},
		success : function(data) {
			var ret = eval(data);
			if (ret.success) {
				window.location.href = "index.html";
			} else {
				$.messager.alert('错误', ret.errorMsg);
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			$.messager.alert('错误', '登录失败');
		}
	});
}
function doLogin() {
	var flag = $("#loginForm").form('enableValidation').form('validate');
	if (!flag) {
		return;
	}
	var loginName = $("#loginName").val();
	var loginPwd = $("#loginPwd").val();
	var validateCode = $("#validateCode").val();
	$.ajax({
		url : "sysUser/login",
		method : "POST",
		dataType : "json",
		async : false,
		data : {
			"loginName" : loginName,
			"loginPwd" : loginPwd,
			"validateCode" : validateCode
		},
		success : function(data) {
			var ret = eval(data);
			if (ret.success) {
				if(ret.mocode!=null){
					$("#two").show();
					$("#one").hide();
					$("#mo").append(ret.mocode);
					return;
				}
				window.location.href = "index.html";
			} else {
				$.messager.alert('提示', ret.errorMsg);
				changeImg();
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			$.messager.alert('错误', '登录失败');
		}
	});
}

//忘记密码
function forgetPwd() {
	$.messager.alert('提示', '暂未实现，请联系系统管理员');
}