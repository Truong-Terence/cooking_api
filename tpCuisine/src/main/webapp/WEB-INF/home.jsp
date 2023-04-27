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
  <title>Home</title>
</head>
<body>
<%@ include file="partials/navbar.jsp" %>
<h1>Bienvenue sur notre site de cuisine !</h1>
<p>Retrouvez ici toutes nos recettes, ainsi que des recettes aléatoires pour vous inspirer.</p>
<a href="recipes">Voir toutes les recettes</a>
<br><br>
<a href="random-recipe?userId=1">Obtenir une recette aléatoire</a>
<br><br>
<%
  List<Tag> tags = (List<Tag>) request.getAttribute("tags");
%>
<form action="recipes-by-tag" method="GET">
  <select name="tag">
    <% for (Tag tag : tags) { %>
    <option value="<%= tag.getId() %>"><%= tag.getName() %></option>
    <% } %>
  </select>

  <button type="submit">Rechercher</button>
</form>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
