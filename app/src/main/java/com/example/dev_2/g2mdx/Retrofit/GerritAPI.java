package com.example.dev_2.g2mdx.Retrofit;

import com.example.dev_2.g2mdx.Retrofit.Models.Example;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Mark on 5/2/2017.
 */
public interface GerritAPI {
    @GET("get_city.php?gov_id=1")
    Call<Example> getMyJSON();

}
