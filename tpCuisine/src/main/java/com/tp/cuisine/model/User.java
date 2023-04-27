package com.tp.cuisine.model;

public class User {
    private long id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String picture_url;

    public User(Long id, String email, String password, String firstname, String lastname, String picture_url) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.picture_url = picture_url;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public int getDaysSinceLastCooked() {
        return 1;
    }
}
