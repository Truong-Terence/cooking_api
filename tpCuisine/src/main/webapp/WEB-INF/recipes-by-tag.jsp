<%@ page import="com.tp.cuisine.model.Tag" %>
<%@ page import="com.tp.cuisine.dao.TagDao" %>
<%@ page import="java.util.List" %>
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
  <title>Recipes for ${tag.name}</title>
</head>
<body>
<%@ include file="partials/navbar.jsp" %>
<h1>Recipes for <c:out value="${tag.name}" /></h1>
<div class='container'>
  <div class="row">
    <c:forEach items="${recipes}" var="recipe">
      <div class="col">
        <div class="card" style="width: 18rem;">
          <img src="${recipe.image_url}" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title">${recipe.name}</h5>
            <p class="card-text">${recipe.content}</p>
          </div>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">Duration : ${recipe.duration}mn</li>
            <li class="list-group-item">Difficulty : ${recipe.level}</li>
          </ul>
        </div>
      </div>
    </c:forEach>
  </div>
</div>
<%--<%@ include file="partials/footer.jsp" %>--%>
<script src="https://kit.fontawesome.com/f61a6ddc10.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
