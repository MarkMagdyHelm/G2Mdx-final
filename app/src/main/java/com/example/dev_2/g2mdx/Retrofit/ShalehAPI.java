package com.example.dev_2.g2mdx.Retrofit;

import com.example.dev_2.g2mdx.Retrofit.Models.ListEX;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Mark on 5/2/2017.
 */
public interface ShalehAPI {
    @GET("get_shaleh.php")
    Call<ListEX> getMyJSON();

}
