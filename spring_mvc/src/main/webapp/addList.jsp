<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/2/1
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/hello/listType" method="post">
    用户1id:<input type="text" name="userList[0].id"><br>
    用户1姓名:<input type="text" name="userList[0].name"><br>
    用户2id:<input type="text" name="userList[1].id"><br>
    用户2姓名:<input type="text" name="userList[1].name"><br>
    用户3id:<input type="text" name="userList[2].id"><br>
    用户3姓名:<input type="text" name="userList[2].name"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
