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
<form  action="../../cardbin/validate" method="POST">
    卡号：<input type="text" id="cardNo" name = "cardNo"/>
    <input type="submit" value="获取卡bin">
</form>
<br/>
<form  action="../../cardBin/cnaps" method="POST">
    城市编码：<input type="text" id="city" name = "city"/>
    银行编码：<input type="text" id="bankCode" name = "bankCode"/>
    <input type="submit" value="获取联行号">
</form>
<br/>
<form  action="/validate/bankCode" method="POST">

    <input type="submit" value="获取银行编码列表">
</form>
</body>
</html>