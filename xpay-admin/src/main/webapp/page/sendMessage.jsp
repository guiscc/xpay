<%--
  Created by IntelliJ IDEA.
  User: wangzhenlei
  Date: 15-1-21
  Time: 下午4:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<script type="text/javascript">
function changeMessage(){
	var message = document.getElementById("message");
	var email = document.getElementById("email");
	var sendType = document.getElementById("sendType");
	sendType.value="2"
	message.style.display = "";
	email.style.display = "none";
}

function changeEmail(){
	var message = document.getElementById("message");
	var email = document.getElementById("email");
	var sendType = document.getElementById("sendType");
	sendType.value="1"
	message.style.display = "none";
	email.style.display = "";
}

</script>
<body>
<form  action="/cardbin/sendMessage" method="POST">
	<a id="sendMessageA" href ="#" onclick="javascript:changeMessage();">发送短信</a>
	<a id="sendEmalA" href ="#" onclick="javascript:changeEmail();">发送邮件</a>
	<input id="sendType" type="hidden" name="sendType">
	<center>
	<table id = "email">
		<tr>
			<td>
				   收件人：
			</td>
			<td>
				  <input type="text" id="sendAddr" name = "sendAddr"/>
			</td>
		</tr>
		<tr>
			<td>
				      抄送：
			</td>
			<td>
				  <input type="text" id="copyAddr" name = "copyAddr"/>
			</td>
		</tr>
		<tr>
			<td>
				       主题：
			</td>
			<td>
				  <input type="text" id="title" name = "title"/>
			</td>
		</tr>
		<tr>
			<td>
				        内容：
			</td>
			<td>
				  <textarea id="emailContent" name = "emailContent"></textarea>
			</td>
		</tr>
	</table>
	<table id = "message" style="display: none;">
		<tr> 
			<td>
				   收信人：
			</td>
			<td>
				  <input type="text" id="mobile" name = "mobile"/>
			</td>
		</tr>
		<tr>
			<td>
				       短信类型：
			</td>
			<td>
				  <select id="type" name = "type"> 
				  	<option value ="1">发送营销类类短信。非验证码，非触发类的普通短信</option>
				  	<option value ="2">发送触发类短信</option>
				  	<option value ="3">发送验证码类的短信,只支持单条发送</option>
				  	<option value ="4">其他</option>
				  </select>
			</td>
		</tr>
		<tr>
			<td>
				       短信内容：
			</td>
			<td>
				  <textarea id="msgContent" name = "msgContent"></textarea>
			</td>
		</tr>
	</table>
 <input type="submit" value="发送">
 </center>
</form>
</body>
</html>