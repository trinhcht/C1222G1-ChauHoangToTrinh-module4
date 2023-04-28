<%--
  Created by IntelliJ IDEA.
  User: Vĩ Trần
  Date: 4/28/2023
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <label>USD: </label>
    <input type="number" name="usd" placeholder="USD" value=""> $<br>

    <label>VND: </label>
    <input type="number"  value="${vnd}" readonly> vnd<br>

    <button type="submit">Change</button>
</form>
</body>
</html>
