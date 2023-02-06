<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/2/2
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/file/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="img"/>
    <input type="submit" value="提交">
    <!-- 加上/代表从根目录也就是8080开始找 -->
</form>
<img src="${src}"/>


<form action="/file/uploads" method="post" enctype="multipart/form-data">
    file1:<input type="file" name="imgs"/><br>
    file2:<input type="file" name="imgs"/><br>
    file3:<input type="file" name="imgs"/><br>
    <input type="submit" value="提交"/>
</form>
<c:forEach items="${pathList}" var="path">
    <img src="${path}" width="300px">
</c:forEach>
</body>
</html>


</body>
</html>
