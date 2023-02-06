<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/2/1
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/converter/date" method="post">
    <input type="text" name="date"/> (2023-02-01)
    <input type="submit" value="提交" />
</form>

<form action="/converter/student" method="post">
    <input type="text" name="student"/>(1-张三-22)<br/>
    <input type="submit" value="提交"/>
</form>

</body>
</html>
