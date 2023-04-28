<%--
  Created by IntelliJ IDEA.
  User: Vĩ Trần
  Date: 4/28/2023
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Sandwich Condiments</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<body>
<div class="container" style="width: 55%">
  <h2 style="color: indianred">Sandwich Condiments</h2>
  <form action="/save">
    <div class="mb-3">
      <label for="lettuce" class="form-label" style="color: chartreuse; margin-right: 10px">
        <input type="checkbox" class="form-check-input" name="condiments" id="lettuce" value="lettuce" style="margin-right: 5px">Lettuce
      </label>
      <label class="form-label" for="tomato" style="color: maroon; margin-right: 10px">
        <input type="checkbox" class="form-check-input" name="condiments" id="tomato" value="tomato" style="margin-right: 5px">Tomato
      </label>
      <label class="form-label" for="mustard" style="color: gold; margin-right: 10px">
        <input type="checkbox" class="form-check-input" name="condiments" id="mustard" value="mustard" style="margin-right: 5px">Mustard
      </label>
      <label class="form-label" for="sprouts" style="color: magenta; margin-right: 10px">
        <input type="checkbox" class="form-check-input" name="condiments" id="sprouts" value="sprouts" style="margin-right: 5px">Sprouts
      </label>
    </div>
    <hr>
    <input type="submit" class="btn btn-primary" value="Save">
  </form>
  <p>The condiments in the sandwich</p>
  <p style="color: blue; font-family: SansSerif; font-size: 20px">${condimentsList}</p>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>