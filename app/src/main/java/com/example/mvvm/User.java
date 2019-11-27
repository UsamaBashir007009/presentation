package com.example.mvvm;

public class User {
    public String name,username,passsword;
    public User()
    {

    }
    public User(String name, String uname, String pass)
    {
        this.name=name;
        this.username=uname;
        this.passsword=pass;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }
}
