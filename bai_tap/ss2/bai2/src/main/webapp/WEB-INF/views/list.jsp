<%--
  Created by IntelliJ IDEA.
  User: Vĩ Trần
  Date: 4/28/2023
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Calculator</h2>
<form action="/calculator">
    <div class="mb-3">
        <input type="number" name="firstNumber" value="${firstNumber}">
        <input type="number" name="secondNumber" value="${secondNumber}">
    </div>
    <div>
        <input type="submit" value="Addition" name="calculate">
        <input type="submit" value="Subtraction" name="calculate">
        <input type="submit" value="Multiplication" name="calculate">
        <input type="submit" value="Division" name="calculate">
    </div>
</form>
<p>Result: ${result}</p>
</body>
</html>