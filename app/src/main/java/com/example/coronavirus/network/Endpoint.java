package com.example.coronavirus.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Endpoint {
    @GET("countries/ID")
//    Call<Object> getEndData();
    Call<Object> getEndData();
}
