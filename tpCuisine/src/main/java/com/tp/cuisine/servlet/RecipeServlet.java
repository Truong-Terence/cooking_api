package com.tp.cuisine.servlet;

import com.google.gson.Gson;
import com.tp.cuisine.model.Recipe;
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
    private static final long serialVersionUID = 1L;
    private RecipeService recipeService = new RecipeService();
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tagName = request.getParameter("tag");
        try {
            List<Recipe> recipes = recipeService.findByTag(tagName);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(gson.toJson(recipes));
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

}