package com.adscomapanion2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.concurrent.Callable;

public class SplashActivity extends BaseActivity {

    Boolean isFirstTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        if (!isFirstTime){
//            loadSplashAd();
//        }
//
//        withDelay(5000, new Callable<Void>() {
//            @Override
//            public Void call() throws Exception {
//                if (isFirstTime){
//                    isFirstTime = false;
//                    showSplashAdFirst(SplashActivity.this, new Callable<Void>() {
//                        @Override
//                        public Void call() throws Exception {
//                            return null;
//                        }
//                    });
//                }else {
//                    showSplashAdSecond(SplashActivity.this, new Callable<Void>() {
//                        @Override
//                        public Void call() throws Exception {
//                            return null;
//                        }
//                    });
//
//                }
//                return null;
//            }
//        });
//    }
//
//    @Override
//    public void onBackPressed() {
//        showInterstitialAd(true,SplashActivity.this, new Callable<Void>() {
//            @Override
//            public Void call() throws Exception {
//
//                return null;
//            }
//        });
//
//        super.onBackPressed();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
//                getBlogMoviesList();
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
            }
        }, 5000);

    }
}