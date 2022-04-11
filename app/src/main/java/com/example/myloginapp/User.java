package com.example.myloginapp;

public class User {
  private   String username;
    private String password;
    private    String security;

   public  User()
    {
        this.password = "abcd";
        this.username = "vir";
        this.security = "1234";

    }
    public User(String username,String password ,String security)
    {
        this.password = password;
        this.username = username;
        this.security = security;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public static void main(String[] args) {

    }
}
