package com.newAds2021.adsmodels;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;

public class ConstantAds {

    //moreapps
//    public static ArrayList<String> category=new ArrayList<>();
//    public static ArrayList<ArrayList<AppsDetails>> arraylist=new ArrayList<>();

    public static int ad_bg_drawable = 0;
    public static int native_ad_bg = 0;
    public static boolean IS_APP_KILLED = false;
    public static Boolean isLightTheme = true;
    public static ProgressDialog pDialog = null;
    public static int adCountDefault = 1;
    public static int app_ad_dialog_default = 0;
    public static int AD_DELAY = 1500;
    public static boolean PRELOAD_INTERSTITIAL = false;
    public static boolean PRELOAD_REWARD = false;
    public static boolean PRELOAD_APPOPEN = false;
    public static String AD_MESSAGE = "Showing Ad...";
//    public static String adUrlId = "AKfycbwWa0oIwNsZ4b7b-aIGi61iyJ98XFCy2kbfXNC-ZhiIkHtlHu2R88r-gzHc7eigJykh7A/exec";
    public static String adUrlId = "";
    public static String ihAdsID = "";
    public static String fbAdsID = "";
    public static String ihInterID = "";
    public static String ihNativeID = "";
    public static String setAdsURL(String url){
        return adUrlId = url;
    }
    public static String setFBAdsID(String url){
        return fbAdsID = url;
    }
    public static String setIHAdsID(String url){
        return ihAdsID = url;
    }
    public static String setIHInterID(String url){
        return ihInterID = url;
    }
    public static String setIHNativeID(String url){
        return ihNativeID = url;
    }
    public static String setAdsUrlID(String url){
        return adUrlId = url;
    }
    public static Boolean preloadInterstitial(Boolean preload){
        return PRELOAD_INTERSTITIAL = preload;
    }
    public static Boolean preloadRewarded(Boolean preload){
        return PRELOAD_REWARD = preload;
    }
    public static Boolean preloadAppopen(Boolean preload){
        return PRELOAD_APPOPEN = preload;
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








