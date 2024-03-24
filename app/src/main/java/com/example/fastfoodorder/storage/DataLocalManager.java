package com.example.fastfoodorder.storage;

import android.content.Context;

import com.example.fastfoodorder.models.User;
import com.google.gson.Gson;

public class DataLocalManager {
    private static DataLocalManager instance;
    private DataLocal dataLocal;

    public static void init(Context context){
        instance = new DataLocalManager();
        instance.dataLocal = new DataLocal(context);
    }

    public static DataLocalManager getInstance(){
        if(instance == null){
            instance = new DataLocalManager();
        }
        return instance;
    }

    public static void setUser(User user){
        Gson gson = new Gson();
        String jsonUser = gson.toJson(user);
        DataLocalManager.getInstance().dataLocal.putUser("user", jsonUser);
    }

    public static User getUser(){
        String jsonUser = DataLocalManager.getInstance().dataLocal.getUser("user");
        Gson gson = new Gson();
        User user = gson.fromJson(jsonUser, User.class);
        return user;
    }
}
