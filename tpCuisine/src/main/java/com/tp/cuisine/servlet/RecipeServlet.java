package com.tp.cuisine.servlet;

import com.google.gson.Gson;
import com.tp.cuisine.dao.RecipeDao;
import com.tp.cuisine.dao.TagDao;
import com.tp.cuisine.model.Recipe;
import com.tp.cuisine.model.Tag;
import com.tp.cuisine.service.RecipeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/recipes")
public class RecipeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TagDao tagDao = new TagDao();
        List<Tag> tags = null;
        RecipeDao recipeDao = new RecipeDao();
        List<Recipe> recipes = null;
        try {
            recipes = recipeDao.getAllRecipes();
            tags = tagDao.getAllTags();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("tags", tags);
        request.setAttribute("recipes", recipes);
        request.getRequestDispatcher("/WEB-INF/recipes.jsp").forward(request, response);
    }

}