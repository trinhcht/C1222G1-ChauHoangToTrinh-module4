<%--
  Created by IntelliJ IDEA.
  User: Vĩ Trần
  Date: 4/27/2023
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/dictionary">
<div class="input-group">
    <input type="text" name="english" value="${english}">
        <button type="submit">Result</button>
</div>
</form>
<h1>Result : ${result}</h1>
</body>
</html>
