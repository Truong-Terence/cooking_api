<%@ page import="com.tp.cuisine.model.Tag" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <link href="../style/style.css" rel="stylesheet">
  <title>Home</title>
</head>
<body>
<%@ include file="partials/navbar.jsp" %>
<section>
  <div class="container">
    <h1>Welcome to <strong>| HM & Rice Cooker|</strong></h1>
    <p>Your Homemade Marmiton </p>
    <div class="row">
      <a class="col" href="recipes"><button type="button" class="btn btn-dark">Voir toutes les recettes</button></a>
      <a class="col" href="random-recipe?userId=1"><button type="button" class="btn btn-dark">Obtenir une recette aléatoire</button></a>
      <div class="col">
        <%
          List<Tag> tags = (List<Tag>) request.getAttribute("tags");
        %>
        <form action="recipes-by-tag" method="GET">
          <button type="submit" class="btn btn-dark my-1">Rechercher</button>
          <select class="form-select" aria-label="Default select example" name="tag">
            <% for (Tag tag : tags) { %>
            <option value="<%= tag.getId() %>"><%= tag.getName() %></option>
            <% } %>
          </select>
        </form>
      <div>
    </div>
</section>
<%@ include file="partials/footer.jsp" %>
<script src="https://kit.fontawesome.com/f61a6ddc10.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
