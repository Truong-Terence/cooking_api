package com.tp.cuisine.dao;

import com.tp.cuisine.model.Tag;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TagDao {
    private final String INSERT_TAG = "INSERT INTO tag (name) VALUES (?)";
    private final String GET_TAG_BY_ID = "SELECT * FROM tag WHERE id=?";
    private final String GET_ALL_TAGS = "SELECT * FROM tag";

    public Tag create(Tag tag) {
        Connection conn = DataBase.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(INSERT_TAG, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, tag.getName());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                tag.setId(rs.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tag;
    }

    public Tag getTagById(long id) {
        Connection conn = DataBase.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(GET_TAG_BY_ID))
        {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Tag tag = new Tag(rs.getLong("id"), rs.getString("name"));
                return tag;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Tag> getAllTags() {
        Connection conn = DataBase.getConnection();
        List<Tag> tags = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(GET_ALL_TAGS);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Tag tag = new Tag(rs.getLong("id"), rs.getString("name"));
                tags.add(tag);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tags;
    }
}
