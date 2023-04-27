<%@ page import="com.tp.cuisine.model.Recipe" %>
<%@ page import="com.tp.cuisine.service.RecipeService" %><%--
  Created by IntelliJ IDEA.
  User: tvnte
  Date: 27/04/2023
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="../style/style.css" rel="stylesheet">
  <meta charset="UTF-8">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <title>${recipe.name}</title>
</head>
<body>
<%@ include file="partials/navbar.jsp" %>
<div class='container my-3'>
  <div class="row">
    <div class="col">
      <div class="card m-1" style="width: 18rem;">
        <img src="${recipe.image_url}" class="card-img-top" alt="...">
        <div class="card-body">
          <h5 class="card-title">${recipe.name}</h5>
          <p class="card-text">${recipe.content}</p>
        </div>
        <ul class="list-group list-group-flush">
          <li class="list-group-item">Duration : ${recipe.duration}mn</li>
          <li class="list-group-item">Difficulty : ${recipe.level}</li>
          <li class="list-group-item">Type : ${recipe.tag.name}</li>
        </ul>
      </div>
    </div>
  </div>
</div>
<%--<%@ include file="partials/footer.jsp" %>--%>
<script src="https://kit.fontawesome.com/f61a6ddc10.js" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/f61a6ddc10.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
