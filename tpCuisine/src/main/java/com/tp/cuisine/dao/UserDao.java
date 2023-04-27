package com.tp.cuisine.dao;

import com.tp.cuisine.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public User getUserById(long userId) {
        User user = null;
        Connection connection = DataBase.getConnection();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE id = ?"))
        {
            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("picture_url")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
