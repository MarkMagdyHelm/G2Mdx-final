package com.example.dev_2.g2mdx.Retrofit;

import android.content.Context;

import com.example.dev_2.g2mdx.Retrofit.Models.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nayir on 5/4/2017.
 */

public class callRetrofit {
    static String s = "name";
    static boolean callCreatedReviews = false;
    static callRetrofit RetrofitReviews;
    Context con;
  Example count;

    private callRetrofit(Context context) {
        con = context;
    }

    public static callRetrofit getInstance(Context conn) {
        if (!callCreatedReviews)
            RetrofitReviews = new callRetrofit(conn);
        callCreatedReviews = true;
        return RetrofitReviews;
    }

    public void retrofitCall(final NetworkResponse<Example> reviewsResponse) {
        RetroClient retro = RetroClient.getInstanceRetrofit(con);
        GerritAPI api = retro.getApiService();
        Call<Example> call = api.getMyJSON();
        call.enqueue(new Callback<Example>() {


            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.isSuccessful()) {
                    count = response.body();
                    reviewsResponse.onSucess(count);


                }
            }

            @Override
            public void onFailure(Call <Example> call, Throwable t) {

            }


        });
    }
}
