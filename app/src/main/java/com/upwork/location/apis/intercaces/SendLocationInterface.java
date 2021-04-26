package com.upwork.location.apis.intercaces;

import com.upwork.location.apis.modles.SendLocationModel;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface SendLocationInterface {
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @POST("add-daily-location")
    Call<SendLocationModel> SendData(@Body JSONObject jsonBody);
}
