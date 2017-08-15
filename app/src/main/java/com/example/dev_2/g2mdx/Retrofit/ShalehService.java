package com.example.dev_2.g2mdx.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Dev-2 on 06/07/2017.
 */

public interface ShalehService {
    @GET("new_products")
    Call<Products> getProduc(
            @Query("from") int language,
            @Query("count") int apiKey

    );
}
