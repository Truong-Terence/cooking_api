package com.tp.cuisine.service;

import com.tp.cuisine.dao.RecipeDao;
import com.tp.cuisine.model.Recipe;
import com.tp.cuisine.model.User;

import java.sql.SQLException;
import java.util.List;

public class RecipeService {

    private RecipeDao recipeDao = new RecipeDao();

    public List<Recipe> findByTag(String tagName) throws SQLException {
        return recipeDao.findByTag(tagName);
    }

    public Recipe getRandomRecipeNotCookedRecently(User user) {
        return recipeDao.getRandomRecipeNotCookedRecently(user);
    }

    public Recipe getRecipeById(long recipeId) {
        return recipeDao.findById(recipeId);
    }

}