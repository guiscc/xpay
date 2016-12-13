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
<body>
<form action="/cardbin/validateSection" method="POST">
IP：<input type="text" id="ip" name = "ip"/>
手机号：<input type="text" id="mobileNum" name = "mobileNum"/>
    <input type="submit" value="获取支付工具">
</form>
</body>
</html>