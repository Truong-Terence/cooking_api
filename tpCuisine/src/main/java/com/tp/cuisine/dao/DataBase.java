package com.tp.cuisine.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class DataBase {
    private static Connection INSTANCE;
    public static Connection getConnection() {
        if (INSTANCE == null) {
            try {
                String rootPath = Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath();
                String appConfigPath = rootPath + "app.properties";
                Properties appProps = new Properties();
                appProps.load(new FileInputStream(appConfigPath));


                Class.forName("com.mysql.cj.jdbc.Driver");
                INSTANCE = DriverManager.getConnection(appProps.getProperty("bdd_url"), appProps.getProperty("bdd_user"), appProps.getProperty("bdd_password"));
            } catch (SQLException | ClassNotFoundException | IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
        return INSTANCE;
    }


}
