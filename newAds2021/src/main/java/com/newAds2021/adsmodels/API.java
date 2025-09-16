package com.newAds2021.adsmodels;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {

    private static <T> T builder(Class<T> endpoint) {

        return new Retrofit.Builder()
                .baseUrl("https://script.google.com/macros/s/AKfycbzlASLFRlVSqYwSboft-5uedsGjhsxoF8sOR4AWuGL_gNPlNz6sn05EvKWx-5ynUly8/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(endpoint);


    }

    public static ApiInterface apiInterface() {
        return builder(ApiInterface.class);
    }

}
