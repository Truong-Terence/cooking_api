package com.tp.cuisine.servlet;

import com.tp.cuisine.dao.RecipeDao;
import com.tp.cuisine.model.Tag;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class HomeServlet extends HttpServlet {

    RecipeDao recipeDao = new RecipeDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Tag> tags = null;
        try {
            tags = recipeDao.getAllTags();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("tags", tags);
        request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }
}

