package com.example.dev_2.g2mdx.Retrofit;

/**
 * Created by nayir on 5/4/2017.
 */

public interface NetworkResponse<H> {
    void onSucess(H result);

    void onFailure();
}
