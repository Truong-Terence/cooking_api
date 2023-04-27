package com.tp.cuisine.dao;

import com.tp.cuisine.model.Recipe;
import com.tp.cuisine.model.Tag;
import com.tp.cuisine.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecipeDao {


    public List<Recipe> findByTag(String tagName) throws SQLException {
        List<Recipe> recipes = new ArrayList<>();
        String FIND_RECIPES_BY_TAG = "SELECT r.id, r.name, r.image_url, r.content, r.duration, r.level, t.id, t.name "
                + "FROM recipe r INNER JOIN tag t ON r.id_tag = t.id WHERE t.name = ?";
        Connection conn = DataBase.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(FIND_RECIPES_BY_TAG))
        {
            stmt.setString(1, tagName);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Recipe recipe = new Recipe(rs.getLong("r.id"), rs.getString("r.name"), rs.getString("r.image_url"),
                            rs.getString("r.content"), rs.getInt("r.duration"), rs.getString("r.level"),
                            new Tag(rs.getLong("t.id"), rs.getString("t.name")));
                    recipes.add(recipe);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return recipes;
    }

    public Recipe getRandomRecipeNotCookedRecently(User user) {
        Recipe recipe = null;

        String GET_RANDOM_NOT_RECENT_RECIPE = "SELECT r.*, t.* FROM recipe r " +
                "LEFT JOIN user_recipe ur ON r.id = ur.id_recipe AND ur.id_user = ? " +
                "LEFT JOIN recipe_tag rt ON r.id = rt.id_recipe " +
                "LEFT JOIN tag t ON rt.id_tag = t.id " +
                "WHERE ur.last_cooked IS NULL OR ur.last_cooked < DATE_SUB(CURDATE(), INTERVAL ? DAY) " +
                "ORDER BY RAND() LIMIT 1";
        Connection conn = DataBase.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(GET_RANDOM_NOT_RECENT_RECIPE))
        {
            stmt.setLong(1, user.getId());
            stmt.setInt(2, 6);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Tag tag = getTagById(rs.getLong("id_tag"));
                recipe = new Recipe(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("image_url"),
                        rs.getString("content"),
                        rs.getInt("duration"),
                        rs.getString("level"),
                        tag
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipe;
    }


    public Tag getTagById(Long id) throws SQLException {
        Tag tag = null;
        Connection conn = DataBase.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tag WHERE id = ?"))
        {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                tag = new Tag(rs.getLong("id"), rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return tag;
    }

}
