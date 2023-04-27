package com.tp.cuisine.servlet;

import com.google.gson.Gson;
import com.tp.cuisine.dao.RecipeDao;
import com.tp.cuisine.dao.TagDao;
import com.tp.cuisine.model.Recipe;
import com.tp.cuisine.model.Tag;
import com.tp.cuisine.service.RecipeService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/recipes-by-tag")
public class RecipesByTagServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int tagId = Integer.parseInt(request.getParameter("tag"));
        TagDao tagDao = new TagDao();
        Tag tag = tagDao.getTagById(tagId);

        RecipeDao recipeDao = new RecipeDao();
        List<Recipe> recipes = null;
        try {
            recipes = recipeDao.getRecipesByTag(tagId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("tag", tag);
        request.setAttribute("recipes", recipes);
        request.getRequestDispatcher("/WEB-INF/recipes-by-tag.jsp").forward(request, response);
    }

}
//public class RecipesByTagServlet extends HttpServlet {
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String tagIdParam = request.getParameter("tag");
//        if (tagIdParam == null || tagIdParam.isEmpty()) {
//            response.sendRedirect(request.getContextPath() + "/tags");
//            return;
//        }
//
//        int tagId = Integer.parseInt(tagIdParam);
//        TagDao tagDao = new TagDao();
//        Tag tag = tagDao.getTagById(tagId);
//
//        RecipeDao recipeDao = new RecipeDao();
//        List<Recipe> recipes = null;
//        try {
//            recipes = recipeDao.getRecipesByTag(tagId);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        request.setAttribute("tag", tag);
//        request.setAttribute("recipes", recipes);
//        request.getRequestDispatcher("/WEB-INF/recipes-by-tag.jsp").forward(request, response);
//    }



