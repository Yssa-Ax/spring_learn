<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/2/1
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
    $(function(){
        var user = {
            "id":1,
            "name":"张三"
        };
        $.ajax({
            url:"/hello/jsonType",
            data:JSON.stringify(user),
            type:"POST",
            contentType:"application/json;charset=UTF-8",
            dataType:"json",
            success:function(data){
                console.log(typeof data)
                alert(data.id)
                alert(data.name)
            }
        })
    })
</script>





</body>
</html>
