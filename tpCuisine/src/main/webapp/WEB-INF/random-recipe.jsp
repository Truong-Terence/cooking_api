<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <link href="../style/style.css" rel="stylesheet">
  <meta charset="UTF-8">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <title>Recette aléatoire</title>
</head>
<body>
<%@ include file="partials/navbar.jsp" %>
<h1>Your ${recipeTag.name} !</h1>

<div class='container'>
  <div class="row justify-content-center">
      <div class="col-auto">
        <div class="card" style="width: 18rem;">
          <img src="${recipeImageUrl}" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title">${recipeName}</h5>
            <p class="card-text">${recipeContent}</p>
          </div>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">Duration : ${recipeDuration}mn</li>
            <li class="list-group-item">Difficulty : ${recipeLevel}</li>
            <li class="list-group-item">Type : ${recipeTag.name}</li>
          </ul>
        </div>
      </div>
  </div>
</div>
<%@ include file="partials/footer.jsp" %>

<script src="https://kit.fontawesome.com/f61a6ddc10.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>