package com.example.dev_2.g2mdx.Retrofit;

import android.content.Context;
import android.util.Log;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;


/**
 * Created by nayir on 5/4/2017.
 */

public class callRetrofitCash {
    static String s = "name";
    static boolean callCreatedReviews = false;
    static callRetrofitCash RetrofitReviews;
    Context con;
    Products count;
int from=0;
    int end=4;
    private callRetrofitCash(Context context) {
        con = context;
    }

    public static callRetrofitCash getInstance(Context conn) {
        if (!callCreatedReviews)
            RetrofitReviews = new callRetrofitCash(conn);
        callCreatedReviews = true;
        return RetrofitReviews;
    }

    public void retrofitCall(final NetworkResponse<Products> reviewsResponse) {
        RetroClient retro = RetroClient.getInstanceRetrofit(con);
        ShalehService api =  retro.getProd();
        Call<Products> call = api.getProduc(from,end);
        call.enqueue(new Callback<Products>() {


            @Override
            public void onResponse(Call<Products> call, Response<Products> response) {
                if (response.isSuccessful()) {
                    count = response.body();
                    reviewsResponse.onSucess(count);
                    Log.e(TAG, "onSucess:_______ " );


                }
            }

            @Override
            public void onFailure(Call <Products> call, Throwable t) {
                Log.e(TAG, "onSucess:_______ " );
            }


        });
    }
}
