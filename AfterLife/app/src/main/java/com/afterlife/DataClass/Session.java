package com.afterlife.DataClass;

public class Session {
    private static User user;
    public Session(){
    }
    public static void Login(User newUser){
        user = newUser;
    }
    public static void Logout(){
        user = null;
    }

    public static User getUser(){
        return user;
    }
}
