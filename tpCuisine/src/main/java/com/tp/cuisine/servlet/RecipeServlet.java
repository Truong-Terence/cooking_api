package com.tp.cuisine.servlet;

import com.tp.cuisine.model.Recipe;
import com.tp.cuisine.service.RecipeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/recipe")
public class RecipeServlet extends HttpServlet {

    private RecipeService recipeService = new RecipeService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recipeIdString = request.getParameter("id");
        if (recipeIdString == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        long recipeId = Long.parseLong(recipeIdString);

        Recipe recipe = recipeService.getRecipeById(recipeId);
        if (recipe == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        request.setAttribute("recipe", recipe);
        request.getRequestDispatcher("/WEB-INF/recipe.jsp").forward(request, response);
    }
}


