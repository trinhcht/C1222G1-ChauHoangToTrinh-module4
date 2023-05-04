<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vĩ Trần
  Date: 5/4/2023
  Time: 4:44 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Update</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1>Setting</h1>
<br>
<%--@elvariable id="mailBox" type="ss3"--%>
<form:form action="/index" method="get" modelAttribute="mailBox">
  <div class="row">
    <div class="col-3"><h3>Languages</h3></div>
    <div class="col-6">
      <form:select path="language" cssStyle="width: 32%">
        <form:options items="${languages}"></form:options>
      </form:select>
    </div>
  </div>
  <br>
  <div class="row">
    <div class="col-3"><h3>Page Size:</h3></div>
    <div class="col-6">
      <form:select path="pageSize">
        <form:options items="${pageSizes}"></form:options>
      </form:select>
    </div>
  </div>
  <br>
  <div class="row">
    <div class="col-3"><h3>Spams Filter:</h3></div>
    <div class="col-6">
      <input type="checkbox" name="spamsFilter" value="Enable"> Enable spams filter
    </div>
  </div>
  <br>
  <div class="row">
    <div class="col-3"><h3>Signature</h3></div>
    <div class="col-6">
      <form:textarea path="signature" cols="30" rows="5"></form:textarea>
    </div>
  </div>
  <div class="row">
    <div>
      <button type="submit">Save</button>
    </div>
  </div>
</form:form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
