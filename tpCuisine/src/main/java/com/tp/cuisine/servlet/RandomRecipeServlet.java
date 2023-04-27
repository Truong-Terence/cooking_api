package com.tp.cuisine.servlet;

import com.google.gson.Gson;
import com.tp.cuisine.dao.UserDao;
import com.tp.cuisine.model.Recipe;
import com.tp.cuisine.model.User;
import com.tp.cuisine.service.RecipeService;
import com.tp.cuisine.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet("/random-recipe")
public class RandomRecipeServlet extends HttpServlet {

    private RecipeService recipeService = new RecipeService();
    UserDao userDao = new UserDao();
    UserService userService = new UserService(userDao);


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        if (userId == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        User user = userService.getUserById(Long.parseLong(userId));
        Recipe recipe = recipeService.getRandomRecipeNotCookedRecently(user);
        if (recipe == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Random Recipe</h1>");
        response.getWriter().println("<h2>" + recipe.getName() + "</h2>");
        response.getWriter().println("<p>" + recipe.getContent() + "</p>");
        response.getWriter().println("<img src='" + recipe.getImage_url() + "'/>");
        response.getWriter().println("<p>Duration: " + recipe.getDuration() + " min</p>");
        response.getWriter().println("<p>Level: " + recipe.getLevel() + "</p>");
        response.getWriter().println("</body></html>");
    }
}

