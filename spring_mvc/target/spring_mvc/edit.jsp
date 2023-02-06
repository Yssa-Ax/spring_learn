<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/course/update" method="post">
    <input type="hidden" name="_method" value="PUT"/>
    <table>
        <tr>
            <td>课程编号:</td>
            <td>
                <input type="text" name="id" value="${courser.id}">
            </td>
        </tr>
        <tr>
            <td>课程名称:</td>
            <td>
                <input type="text" name="name" value="${courser.name}">
            </td>
        </tr>
        <tr>
            <td>课程价格:</td>
            <td>
                <input type="text" name="price" value="${courser.price}">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>


</body>
</html>

