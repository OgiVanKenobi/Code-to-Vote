package com.example.android.codetovote.retrofit;

import com.example.android.codetovote.domain.User;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserAPI {


     @GET("user/returnAll")
     Call<List<User>> getUsers();

     @POST("user/login")
     @Headers("Content-Type: application/json")
    Call<User> login(@Body User user);

    @POST("user/register")
    @Headers("Content-Type: application/json")
    Call<User> register(@Body User user);

    @POST("potentialproblems/save")
    @Headers("Content-Type: application/json")
    Call<User> save(@Body User user);



}
