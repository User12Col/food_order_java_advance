package com.example.fastfoodorder.api;

import com.example.fastfoodorder.models.Cart;
import com.example.fastfoodorder.models.ResponeObject;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CartApiService {
    String baseUrl = "http://192.168.1.146:8082/api/v1/";

    CartApiService cartApiService = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CartApiService.class);

    @GET("Carts")
    Observable<ResponeObject> getCartByID(@Query("userID") String userID);

    @POST("Carts/addToCart")
    Observable<ResponeObject> addToCart(@Body Cart cart);

    @POST("Carts/decreaseQuantity")
    Observable<ResponeObject> decreaseQuantity(@Body Cart cart);

    @GET("Carts/quantity")
    Observable<ResponeObject> getQuantity (@Query("foodID") String foodID, @Query("userID") String userID);

    @DELETE("Carts/delete")
    Observable<ResponeObject> deleteFoodFromCart(@Query("foodID") String foodID, @Query("userID") String userID);

}
