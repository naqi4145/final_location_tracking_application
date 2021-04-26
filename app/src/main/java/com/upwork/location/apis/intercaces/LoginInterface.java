package com.upwork.location.apis.intercaces;

import com.upwork.location.apis.modles.LoginModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginInterface {
    @FormUrlEncoded
    @POST("login")
    Call<LoginModel> UserLogIn(@Field("email") String email,
                                @Field("password") String password);
}
