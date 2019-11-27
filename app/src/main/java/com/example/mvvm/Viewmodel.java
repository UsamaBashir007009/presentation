package com.example.mvvm;

import android.util.Patterns;

import java.util.ArrayList;

public class Viewmodel {
    private ArrayList<User> users;
    public User current;
    private static Viewmodel v;
    private Viewmodel()
    {
        current=null;
        users=new ArrayList<User>();
    }
    public static Viewmodel getInstance()
    {
        if(v==null)
            v= new Viewmodel();

        return v;
    }
    public int login(String Uname, String pass)
    {
        int flag=0;
        for(int i = users.size()-1; i>=0; i--)
        {
            User u=users.get(i);
            if(u.username.equals(Uname) && u.passsword.equals(pass)){
                current=users.get(i);
                flag= 1;
                break;
            }
            if(u.username.equals(Uname) && !u.passsword.equals(pass)){
                flag= 2;
                break;
            }
            if(!u.username.equals(Uname) && u.passsword.equals(pass)){
                flag= 3;
                break;
            }
        }
        return flag;
    }
    public int createaccount(String name, String uname, String pass)
    {
        int flag=1;
        for(int i = users.size()-1; i>=0; i--)
        {
            if(users.get(i).username.equals(uname) && users.get(i).passsword.equals(pass)){
                flag=-1;//already there
            }
        }

        if(flag == -1)
        {
            return flag;
        }
        else {
            User u = new User(name, uname, pass);
            current=u;
            users.add(u);
            return 1;
        }
    }
    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        }
        else {
            return !username.trim().isEmpty();
        }
    }

    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }
}
