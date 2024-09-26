package com.newAds2021.adsmodels;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;

public class ConstantAds {


    public static int ad_bg_drawable = 0;
    public static int native_ad_bg = 0;
    public static boolean IS_APP_KILLED = false;
    public static ProgressDialog pDialog = null;

    public static String adUrlId = "";
    public static String setAdsURL(String url){
        return adUrlId = url;
    }




    public static void showProgress(Context context){
        pDialog = new ProgressDialog(context);
        pDialog.show();
    }
    public static void showProgress(Context context, String text){
        pDialog = new ProgressDialog(context);
        pDialog.setMessage(text);
        pDialog.show();
    }
    public static void dismisProgress(Activity context){
        if (pDialog != null){
            pDialog.dismiss();
        }
    }

    public static int setNativeButtonBg(int drawable){
        return ad_bg_drawable = drawable;
    }
    public static int setIhNativeBg(int drawable){
        return native_ad_bg = drawable;
    }

}








