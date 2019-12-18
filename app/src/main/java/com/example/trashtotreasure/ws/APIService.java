package com.example.trashtotreasure.ws;

import com.example.trashtotreasure.pojo.LoginRequest;
import com.example.trashtotreasure.pojo.LoginResponse;
import com.example.trashtotreasure.pojo.RegisterRequest;
import com.example.trashtotreasure.pojo.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {

    @POST("register")
    Call<RegisterResponse> Register(@Body RegisterRequest registerRequest);

    @POST("Login")
    Call<LoginResponse> Login(@Body LoginRequest loginRequest);
}