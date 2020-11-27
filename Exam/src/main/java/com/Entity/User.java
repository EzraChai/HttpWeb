package com.Entity;

public class User {
    private int userId;
    private String name;
    private String password;
    private String gender;
    private String email;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public User( String name, String password, String gender, String email) {
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.email = email;
    }

    public User(int userId, String name, String password, String gender, String email) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.email = email;
    }
}
