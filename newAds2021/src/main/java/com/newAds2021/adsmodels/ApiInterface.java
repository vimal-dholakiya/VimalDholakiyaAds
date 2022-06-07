package com.newAds2021.adsmodels;

import com.newAds2021.MoviesData.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("exec?")
    Call<AdsDetails> getAds(@Query("id") String id);

    @GET("exec")
    Call<AdsDetailsFB> getAdsFB();



    @GET("exec")
    Call<IHAdsData> getIHAds();

    @GET("exec?")
    Call<MoviesResponse> getMoviesList(@Query("id") String id, @Query("sheet") String sheet);


}
