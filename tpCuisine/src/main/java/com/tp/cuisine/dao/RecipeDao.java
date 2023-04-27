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


    public List<Recipe> findByTag(String tagName) {
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

    public List<Recipe> getAllRecipes() throws SQLException {
        List<Recipe> recipes = new ArrayList<>();
        TagDao tagDao = new TagDao();
        String GET_ALL_RECIPES = "SELECT * FROM recipe";
        Connection conn = DataBase.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(GET_ALL_RECIPES)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Tag tag = tagDao.getTagById(rs.getLong("id_tag"));
                Recipe recipe = new Recipe(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("image_url"),
                        rs.getString("content"),
                        rs.getInt("duration"),
                        rs.getString("level"),
                        tag
                );
                recipes.add(recipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipes;
    }

    public List<Recipe> getRecipesByTag(int tagId) throws SQLException {
        List<Recipe> recipes = new ArrayList<>();

        String sql = "SELECT * FROM recipe WHERE id_tag = ?";
        Connection conn = DataBase.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, tagId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Recipe recipe = new Recipe();
                recipe.setId((long) rs.getInt("id"));
                recipe.setName(rs.getString("name"));
                recipe.setImage_url(rs.getString("image_url"));
                recipe.setContent(rs.getString("content"));
                recipe.setDuration(rs.getInt("duration"));
                recipe.setLevel(rs.getString("level"));

                recipes.add(recipe);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recipes;
    }

    public Recipe getRandomRecipeNotCookedRecently(User user) {
        Recipe recipe = null;

        String GET_RANDOM_NOT_RECENT_RECIPE = "SELECT r.*, t.*\n" +
                "FROM recipe r\n" +
                "LEFT JOIN recipe_tag rt ON r.id = rt.id_recipe\n" +
                "LEFT JOIN tag t ON rt.id_tag = t.id\n" +
                "WHERE NOT EXISTS (\n" +
                "  SELECT 1\n" +
                "  FROM user_recipe ur\n" +
                "  WHERE ur.id_recipe = r.id AND ur.id_user = ? AND ur.last_cooked >= DATE_SUB(CURDATE(), INTERVAL 6 DAY)\n" +
                ")\n" +
                "ORDER BY RAND() LIMIT 1;\n";
        Connection conn = DataBase.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(GET_RANDOM_NOT_RECENT_RECIPE))
        {
            stmt.setLong(1, user.getId());
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

    public List<Tag> getAllTags() throws SQLException {
        List<Tag> tags = new ArrayList<>();
        Connection conn = DataBase.getConnection();
        try ( PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tag ORDER BY name ASC")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Tag tag = new Tag((long) rs.getInt("id"), rs.getString("name"));
                tags.add(tag);
            }
        }
        return tags;
    }

}