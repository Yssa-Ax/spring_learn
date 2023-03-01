<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<table>
    <tr>
        <td>编号:</td>
        <td>名称:</td>
        <td>价格:</td>
        <td>操作:</td>
    </tr>

    <c:forEach items="${list}" var="course">
        <tr>
            <td>${course.id}</td>
            <td>${course.name}</td>
            <td>${course.price}</td>
            <td>
                <form action="/course/deleteById/${course.id}" method="post">
                    <input type="hidden" name="_method" value="DELETE">
                    <input type="submit" value="删除">
                </form>
                <a href="/course/findById/${course.id}">修改</a>

            </td>
        </tr>

    </c:forEach>

</table>

</body>
</html>

