<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/2/1
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- EL 表达式--%>
<%--${user}--%>
<%--${sessionScope.user}--%>
request：${requestScope.user}
session：${sessionScope.user}
</body>
</html>
