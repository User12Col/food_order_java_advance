package com.example.fastfoodorder.api;

import com.example.fastfoodorder.models.Category;
import com.example.fastfoodorder.models.ResponeObject;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface FoodApiService {
    String baseUrl = "http://192.168.1.146:8082/api/v1/";

    FoodApiService foodApiService = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FoodApiService.class);


    @GET("Foods")
    Observable<ResponeObject> getFoods();

    @POST("Foods/category")
    Observable<ResponeObject> getFoodByCategory(@Body Category category);
}
