package com.newAds2021.adsmodels;

import
android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.newAds2021.R;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AdsPrefernce {
    Context context;
    SharedPreferences adsPreference;
    SharedPreferences.Editor editor;


    public AdsPrefernce(Context context) {
        this.context = context;
        adsPreference = context.getSharedPreferences("MyAdsPrefrence", Context.MODE_PRIVATE);
        editor = adsPreference.edit();

    }

    public void setAdsDefaults(Boolean show_ads, Integer ads_count, Boolean show_loading, Boolean allow_access, Integer app_ad_dialog,

                               String g_banner1, String g_banner2, String g_banner3,
                               String g_inter1, String g_inter2, String g_inter3,
                               String g_appopen1, String g_appopen2, String g_appopen3,
                               String g_native1, String g_native2, String g_native3,
                               String g_rewarded1, String g_rewarded2, String g_rewarded3,
                               String g_rewardinter1, String g_rewardinter2, String g_rewardinter3,

                               Boolean show_gbanner1, Boolean show_gbanner2, Boolean show_gbanner3,
                               Boolean show_ginter1, Boolean show_ginter2, Boolean show_ginter3,
                               Boolean show_gappopen1, Boolean show_gappopen2, Boolean show_gappopen3,
                               Boolean show_gnative1, Boolean show_gnative2, Boolean show_gnative3,
                               Boolean show_grewarded1, Boolean show_grewarded2, Boolean show_grewarded3,
                               Boolean show_grewardinter1, Boolean show_grewardinter2, Boolean show_grewardinter3,

                               String extra_para1, String extra_para2, String extra_para3, String extra_para4,

                               Boolean isUpdate, Boolean isAds, Boolean isNotification,

                               String ad_dialog_title, String ad_app_name, String ad_app_short_desc, String ad_message,
                               String ad_app_url, String ad_icon_url, String ad_banner_url, String ad_button_text, Boolean ad_show_cancel,

                               String not_dialog_title, String not_message, Boolean not_show_cancel,

                               String update_dialog_title, String update_title, String update_app_url, String update_message,
                               String update_version_name, Boolean update_show_cancel
    ) {
        if (adsPreference != null) {
            editor = adsPreference.edit();
            editor.putBoolean("show_ads", show_ads);
            editor.putInt("ads_count", ads_count);
            editor.putBoolean("show_loading", show_loading);
            editor.putBoolean("allow_access", allow_access);
            editor.putInt("app_ad_dialog", app_ad_dialog);

            editor.putString("g_banner1", g_banner1);
            editor.putString("g_banner2", g_banner2);
            editor.putString("g_banner3", g_banner3);
            editor.putString("g_inter1", g_inter1);
            editor.putString("g_inter2", g_inter2);
            editor.putString("g_inter3", g_inter3);
            editor.putString("g_appopen1", g_appopen1);
            editor.putString("g_appopen2", g_appopen2);
            editor.putString("g_appopen3", g_appopen3);
            editor.putString("g_native1", g_native1);
            editor.putString("g_native2", g_native2);
            editor.putString("g_native3", g_native3);
            editor.putString("g_rewarded1", g_rewarded1);
            editor.putString("g_rewarded2", g_rewarded2);
            editor.putString("g_rewarded3", g_rewarded3);
            editor.putString("g_rewardinter1", g_rewardinter1);
            editor.putString("g_rewardinter2", g_rewardinter2);
            editor.putString("g_rewardinter3", g_rewardinter3);

            editor.putBoolean("show_gbanner1", show_gbanner1);
            editor.putBoolean("show_gbanner2", show_gbanner2);
            editor.putBoolean("show_gbanner3", show_gbanner3);
            editor.putBoolean("show_ginter1", show_ginter1);
            editor.putBoolean("show_ginter2", show_ginter2);
            editor.putBoolean("show_ginter3", show_ginter3);
            editor.putBoolean("show_gappopen1", show_gappopen1);
            editor.putBoolean("show_gappopen2", show_gappopen2);
            editor.putBoolean("show_gappopen3", show_gappopen3);
            editor.putBoolean("show_gnative1", show_gnative1);
            editor.putBoolean("show_gnative2", show_gnative2);
            editor.putBoolean("show_gnative3", show_gnative3);
            editor.putBoolean("show_grewarded1", show_grewarded1);
            editor.putBoolean("show_grewarded2", show_grewarded2);
            editor.putBoolean("show_grewarded3", show_grewarded3);
            editor.putBoolean("show_grewardinter1", show_grewardinter1);
            editor.putBoolean("show_grewardinter2", show_grewardinter2);
            editor.putBoolean("show_grewardinter3", show_grewardinter3);
            editor.putString("extra_para1", extra_para1);
            editor.putString("extra_para2", extra_para2);
            editor.putString("extra_para3", extra_para3);
            editor.putString("extra_para4", extra_para4);

            editor.putBoolean("isUpdate", isUpdate);
            editor.putBoolean("isAds", isAds);
            editor.putBoolean("isNotification", isNotification);

            editor.putString("ad_dialog_title", ad_dialog_title);
            editor.putString("ad_app_name", ad_app_name);
            editor.putString("ad_app_short_desc", ad_app_short_desc);
            editor.putString("ad_message", ad_message);
            editor.putString("ad_app_url", ad_app_url);
            editor.putString("ad_icon_url", ad_icon_url);
            editor.putString("ad_banner_url", ad_banner_url);
            editor.putString("ad_button_text", ad_button_text);
            editor.putBoolean("ad_show_cancel", ad_show_cancel);

            editor.putString("not_dialog_title", not_dialog_title);
            editor.putString("not_message", not_message);
            editor.putBoolean("not_show_cancel", not_show_cancel);

            editor.putString("update_dialog_title", update_dialog_title);
            editor.putString("update_title", update_title);
            editor.putString("update_app_url", update_app_url);
            editor.putString("update_message", update_message);
            editor.putString("update_version_name", update_version_name);
            editor.putBoolean("update_show_cancel", update_show_cancel);
            editor.apply();
        }
    }
    public void setAdsDefaultsFB(Boolean show_ads, Integer ads_count, Boolean show_loading, Boolean allow_access, Integer app_ad_dialog,

                                 String g_banner1, String g_banner2, String g_banner3,
                                 String g_inter1, String g_inter2, String g_inter3,
                                 String g_appopen1, String g_appopen2, String g_appopen3,
                                 String g_native1, String g_native2, String g_native3,
                                 String g_rewarded1, String g_rewarded2, String g_rewarded3,
                                 String g_rewardinter1, String g_rewardinter2, String g_rewardinter3,

                                 Boolean show_gbanner1, Boolean show_gbanner2, Boolean show_gbanner3,
                                 Boolean show_ginter1, Boolean show_ginter2, Boolean show_ginter3,
                                 Boolean show_gappopen1, Boolean show_gappopen2, Boolean show_gappopen3,
                                 Boolean show_gnative1, Boolean show_gnative2, Boolean show_gnative3,
                                 Boolean show_grewarded1, Boolean show_grewarded2, Boolean show_grewarded3,
                                 Boolean show_grewardinter1, Boolean show_grewardinter2, Boolean show_grewardinter3,

                                 String extra_para1, String extra_para2, String extra_para3, String extra_para4,
                                 Boolean isUpdate, Boolean isAds, Boolean isNotification,

                                 String ad_dialog_title, String ad_app_name, String ad_app_short_desc, String ad_message,
                                 String ad_app_url, String ad_icon_url, String ad_banner_url, String ad_button_text, Boolean ad_show_cancel,

                                 String not_dialog_title, String not_message, Boolean not_show_cancel,

                                 String update_dialog_title, String update_title, String update_app_url, String update_message,
                                 String update_version_name, Boolean update_show_cancel
    ) {
        if (adsPreference != null) {
            editor = adsPreference.edit();
            editor.putBoolean("show_ads_fb", show_ads);
            editor.putInt("ads_count_fb", ads_count);
            editor.putBoolean("show_loading_fb", show_loading);
            editor.putBoolean("allow_access_fb", allow_access);
            editor.putInt("app_ad_dialog_fb", app_ad_dialog);

            editor.putString("g_banner1_fb", g_banner1);
            editor.putString("g_banner2_fb", g_banner2);
            editor.putString("g_banner3_fb", g_banner3);
            editor.putString("g_inter1_fb", g_inter1);
            editor.putString("g_inter2_fb", g_inter2);
            editor.putString("g_inter3_fb", g_inter3);
            editor.putString("g_appopen1_fb", g_appopen1);
            editor.putString("g_appopen2_fb", g_appopen2);
            editor.putString("g_appopen3_fb", g_appopen3);
            editor.putString("g_native1_fb", g_native1);
            editor.putString("g_native2_fb", g_native2);
            editor.putString("g_native3_fb", g_native3);
            editor.putString("g_rewarded1_fb", g_rewarded1);
            editor.putString("g_rewarded2_fb", g_rewarded2);
            editor.putString("g_rewarded3_fb", g_rewarded3);
            editor.putString("g_rewardinter1_fb", g_rewardinter1);
            editor.putString("g_rewardinter2_fb", g_rewardinter2);
            editor.putString("g_rewardinter3_fb", g_rewardinter3);

            editor.putBoolean("show_gbanner1_fb", show_gbanner1);
            editor.putBoolean("show_gbanner2_fb", show_gbanner2);
            editor.putBoolean("show_gbanner3_fb", show_gbanner3);
            editor.putBoolean("show_ginter1_fb", show_ginter1);
            editor.putBoolean("show_ginter2_fb", show_ginter2);
            editor.putBoolean("show_ginter3_fb", show_ginter3);
            editor.putBoolean("show_gappopen1_fb", show_gappopen1);
            editor.putBoolean("show_gappopen2_fb", show_gappopen2);
            editor.putBoolean("show_gappopen3_fb", show_gappopen3);
            editor.putBoolean("show_gnative1_fb", show_gnative1);
            editor.putBoolean("show_gnative2_fb", show_gnative2);
            editor.putBoolean("show_gnative3_fb", show_gnative3);
            editor.putBoolean("show_grewarded1_fb", show_grewarded1);
            editor.putBoolean("show_grewarded2_fb", show_grewarded2);
            editor.putBoolean("show_grewarded3_fb", show_grewarded3);
            editor.putBoolean("show_grewardinter1_fb", show_grewardinter1);
            editor.putBoolean("show_grewardinter2_fb", show_grewardinter2);
            editor.putBoolean("show_grewardinter3_fb", show_grewardinter3);
            editor.putString("extra_para1_fb", extra_para1);
            editor.putString("extra_para2_fb", extra_para2);
            editor.putString("extra_para3_fb", extra_para3);
            editor.putString("extra_para4_fb", extra_para4);

            editor.putBoolean("isUpdate_fb", isUpdate);
            editor.putBoolean("isAds_fb", isAds);
            editor.putBoolean("isNotification_fb", isNotification);

            editor.putString("ad_dialog_title_fb", ad_dialog_title);
            editor.putString("ad_app_name_fb", ad_app_name);
            editor.putString("ad_app_short_desc_fb", ad_app_short_desc);
            editor.putString("ad_message_fb", ad_message);
            editor.putString("ad_app_url_fb", ad_app_url);
            editor.putString("ad_icon_url_fb", ad_icon_url);
            editor.putString("ad_banner_url_fb", ad_banner_url);
            editor.putString("ad_button_text_fb", ad_button_text);
            editor.putBoolean("ad_show_cancel_fb", ad_show_cancel);

            editor.putString("not_dialog_title_fb", not_dialog_title);
            editor.putString("not_message_fb", not_message);
            editor.putBoolean("not_show_cancel_fb", not_show_cancel);

            editor.putString("update_dialog_title_fb", update_dialog_title);
            editor.putString("update_title_fb", update_title);
            editor.putString("update_app_url_fb", update_app_url);
            editor.putString("update_message_fb", update_message);
            editor.putString("update_version_name_fb", update_version_name);
            editor.putBoolean("update_show_cancel_fb", update_show_cancel);
            editor.apply();
        }
    }


    public boolean showAds() {
        boolean output = false;
        if (adsPreference != null) {
            output = adsPreference.getBoolean("show_ads", true);
        }
        return output;
    }

    public void setShowAds(Boolean showAds) {
        if (adsPreference != null) {
            editor = adsPreference.edit();
            editor.putBoolean("show_ads", showAds);
            editor.apply();
        }
    }

    public Integer adCount() {
        int var = 1;
        if (adsPreference != null) {
            var = adsPreference.getInt("ads_count", ConstantAds.adCountDefault);
        }
        return var;
    }

    public boolean showloading() {
        boolean output = false;
        if (adsPreference != null) {
            output = adsPreference.getBoolean("show_loading", true);
        }
        return output;
    }

    public boolean allowAccess() {
        boolean output = false;
        if (adsPreference != null) {
            output = adsPreference.getBoolean("allow_access", true);
        }
        return output;
    }

    public Integer appAdDialogCount() {
        int var = 1;
        if (adsPreference != null) {
            var = adsPreference.getInt("app_ad_dialog", ConstantAds.app_ad_dialog_default);
        }
        return var;
    }


    public String gBanner1() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_banner1", context.getResources().getString(R.string.admob_banner_id1));
        }
        return var;
    }

    public String gBanner2() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_banner2", context.getResources().getString(R.string.admob_banner_id2));
        }
        return var;
    }

    public String gBanner3() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_banner3", context.getResources().getString(R.string.admob_banner_id3));
        }
        return var;
    }

    public String gInter1() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_inter1", context.getResources().getString(R.string.admob_inter_id1));
        }
        return var;
    }

    public String gInter2() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_inter2", context.getResources().getString(R.string.admob_inter_id2));
        }
        return var;
    }

    public String gInter3() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_inter3", context.getResources().getString(R.string.admob_inter_id3));
        }
        return var;
    }

    public String gAppopen1() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_appopen1", context.getResources().getString(R.string.admob_app_open_id1));
        }
        return var;
    }

    public String gAppopen2() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_appopen2", context.getResources().getString(R.string.admob_app_open_id2));
        }
        return var;
    }

    public String gAppopen3() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_appopen3", context.getResources().getString(R.string.admob_app_open_id3));
        }
        return var;
    }

    public String gNative1() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_native1", context.getResources().getString(R.string.admob_native_id1));
        }
        return var;
    }

    public String gNative2() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_native2", context.getResources().getString(R.string.admob_native_id2));
        }
        return var;
    }

    public String gNative3() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_native3", context.getResources().getString(R.string.admob_native_id3));
        }
        return var;
    }

    public String gRewarded1() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_rewarded1", context.getResources().getString(R.string.admob_rewarded_id1));
        }
        return var;
    }

    public String gRewarded2() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_rewarded2", context.getResources().getString(R.string.admob_rewarded_id2));
        }
        return var;
    }

    public String gRewarded3() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_rewarded3", context.getResources().getString(R.string.admob_rewarded_id3));
        }
        return var;
    }

    public String gRewardedInter1() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_rewardinter1", context.getResources().getString(R.string.admob_rewarded_inter_id1));
        }
        return var;
    }

    public String gRewardedInter2() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_rewardinter2", context.getResources().getString(R.string.admob_rewarded_inter_id2));
        }
        return var;
    }

    public String gRewardedInter3() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_rewardinter3", context.getResources().getString(R.string.admob_rewarded_inter_id3));
        }
        return var;
    }

    public boolean showBanner1() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_gbanner1", true);
        }
        return output;
    }

    public boolean showBanner2() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_gbanner2", true);
        }
        return output;
    }

    public boolean showBanner3() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_gbanner3", true);
        }
        return output;
    }

    public boolean showInter1() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_ginter1", true);
        }
        return output;
    }

    public boolean showInter2() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_ginter2", true);
        }
        return output;
    }

    public boolean showInter3() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_ginter3", true);
        }
        return output;
    }

    public boolean showAppopen1() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_gappopen1", true);
        }
        return output;
    }

    public boolean showAppopen2() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_gappopen2", true);
        }
        return output;
    }

    public boolean showAppopen3() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_gappopen3", true);
        }
        return output;
    }

    public boolean showNative1() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_gnative1", true);
        }
        return output;
    }

    public boolean showNative2() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_gnative2", true);
        }
        return output;
    }

    public boolean showNative3() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_gnative3", true);
        }
        return output;
    }

    public boolean showRewarded1() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_grewarded1", true);
        }
        return output;
    }

    public boolean showRewarded2() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_grewarded2", true);
        }
        return output;
    }

    public boolean showRewarded3() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_grewarded3", true);
        }
        return output;
    }

    public boolean showRewardInter1() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_grewardinter1", true);
        }
        return output;
    }

    public boolean showRewardInter2() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_grewardinter2", true);
        }
        return output;
    }

    public boolean showRewardInter3() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_grewardinter3", true);
        }
        return output;
    }

    public String extrapara1() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("extra_para1", "");
        }
        return var;
    }

    public String extrapara2() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("extra_para2", "");
        }
        return var;
    }

    public String extrapara3() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("extra_para3", "");
        }
        return var;
    }

    public String extrapara4() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("extra_para4", "");
        }
        return var;
    }

    public boolean isUpdate() {
        boolean output = false;
        if (adsPreference != null) {
            output = adsPreference.getBoolean("isUpdate", false);
        }
        return output;
    }

    public boolean isAds() {
        boolean output = false;
        if (adsPreference != null) {
            output = adsPreference.getBoolean("isAds", false);
        }
        return output;
    }

    public boolean isNotification() {
        boolean output = false;
        if (adsPreference != null) {
            output = adsPreference.getBoolean("isNotification", false);
        }
        return output;
    }

    public String adDialogTitle() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("ad_dialog_title", "Checkout This");
        }
        return var;
    }

    public String adAppName() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("ad_app_name", "App Name");
        }
        return var;
    }

    public String adShortDesc() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("ad_app_short_desc", "Short Desc");
        }
        return var;
    }

    public String adMessage() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("ad_message", "Message");
        }
        return var;
    }

    public String adAppUrl() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("ad_app_url", "http://");
        }
        return var;
    }

    public String adIconUrl() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("ad_icon_url", "http://");
        }
        return var;
    }

    public String adBannerUrl() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("ad_banner_url", "http://");
        }
        return var;
    }

    public String adButtonText() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("ad_button_text", "Download");
        }
        return var;
    }

    public boolean adShowCancel() {
        boolean output = false;
        if (adsPreference != null) {
            output = adsPreference.getBoolean("ad_show_cancel", true);
        }
        return output;
    }


    public String notDialogTitle() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("not_dialog_title", "Attention!");
        }
        return var;
    }

    public String notMessage() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("not_message", "Maintanence Alert!");
        }
        return var;
    }

    public boolean notShowCancel() {
        boolean output = false;
        if (adsPreference != null) {
            output = adsPreference.getBoolean("not_show_cancel", true);
        }
        return output;
    }

    public String updateDialogTitle() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("update_dialog_title", "Update Available");
        }
        return var;
    }

    public String updateTitle() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("update_title", "Update App to use latest features");
        }
        return var;
    }

    public String updateAppUrl() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("update_app_url", "http://");
        }
        return var;
    }

    public String updateMessage() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("update_message", "Bug Fixed");
        }
        return var;
    }

    public String updateVersionName() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("update_version_name", "1.0");
        }
        return var;
    }

    public boolean updateShowCancel() {
        boolean output = false;
        if (adsPreference != null) {
            output = adsPreference.getBoolean("update_show_cancel", true);
        }
        return output;
    }

    public void setInHouseLoaded(boolean isLoaded) {
        editor.putBoolean("isInHouseAdLoaded", isLoaded);
        editor.apply();
    }

    public void setInHouseAdDetails(ArrayList<IhAdsDetail> arrayList) {
        Gson gson = new Gson();
        String json = gson.toJson(arrayList);
        editor.remove("inHouseAdList");
        editor.apply();
        editor.putString("inHouseAdList", json);
        setInHouseLoaded(true);
        editor.apply();
    }

    public ArrayList<IhAdsDetail> getInHouseAds() {
        Gson gson = new Gson();
        String json = adsPreference.getString("inHouseAdList", "");
        Type type = new TypeToken<ArrayList<IhAdsDetail>>() {
        }.getType();
        ArrayList<IhAdsDetail> ihAdsDetails = gson.fromJson(json, type);
        return ihAdsDetails;
    }

    public void setMoreAppsDetails(ArrayList<AppsDetails> arrayList) {
        Gson gson = new Gson();
        String json = gson.toJson(arrayList);
        editor.remove("moreAppList");
        editor.apply();
        editor.putString("moreAppList", json);
        editor.apply();
    }

    public void clearMoreAppsList() {
        editor.remove("moreAppList");
        editor.apply();
    }

    public ArrayList<AppsDetails> getMoreApps() {
        Gson gson = new Gson();
        String json = adsPreference.getString("moreAppList", "");
        Type type = new TypeToken<ArrayList<AppsDetails>>() {
        }.getType();
        ArrayList<AppsDetails> ihAdsDetails = gson.fromJson(json, type);
        return ihAdsDetails;
    }

    public Boolean isInHouseAdLoaded() {
        return adsPreference.getBoolean("isInHouseAdLoaded", false);
    }


    //////////////

    public boolean showAds_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = adsPreference.getBoolean("show_ads_fb", true);
        }
        return output;
    }

    public void setShowAds_fb(Boolean showAds) {
        if (adsPreference != null) {
            editor = adsPreference.edit();
            editor.putBoolean("show_ads_fb", showAds);
            editor.apply();
        }
    }

    public Integer adCount_fb() {
        int var = 1;
        if (adsPreference != null) {
            var = adsPreference.getInt("ads_count_fb", ConstantAds.adCountDefault);
        }
        return var;
    }

    public boolean showloading_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = adsPreference.getBoolean("show_loading_fb", true);
        }
        return output;
    }

    public boolean allowAccess_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = adsPreference.getBoolean("allow_access_fb", true);
        }
        return output;
    }

    public Integer appAdDialogCount_fb() {
        int var = 1;
        if (adsPreference != null) {
            var = adsPreference.getInt("app_ad_dialog_fb", ConstantAds.app_ad_dialog_default);
        }
        return var;
    }


    public String gBanner1_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_banner1_fb", context.getResources().getString(R.string.admob_banner_id1));
        }
        return var;
    }

    public String gBanner2_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_banner2_fb", context.getResources().getString(R.string.admob_banner_id2));
        }
        return var;
    }

    public String gBanner3_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_banner3_fb", context.getResources().getString(R.string.admob_banner_id3));
        }
        return var;
    }

    public String gInter1_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_inter1_fb", context.getResources().getString(R.string.fb_inter_id1));
        }
        return var;
    }

    public String gInter2_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_inter2_fb", context.getResources().getString(R.string.admob_inter_id2));
        }
        return var;
    }

    public String gInter3_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_inter3_fb", context.getResources().getString(R.string.admob_inter_id3));
        }
        return var;
    }

    public String gAppopen1_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_appopen1_fb", context.getResources().getString(R.string.admob_app_open_id1));
        }
        return var;
    }

    public String gAppopen2_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_appopen2_fb", context.getResources().getString(R.string.admob_app_open_id2));
        }
        return var;
    }

    public String gAppopen3_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_appopen3_fb", context.getResources().getString(R.string.admob_app_open_id3));
        }
        return var;
    }

    public String gNative1_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_native1_fb", context.getResources().getString(R.string.admob_native_id1));
        }
        return var;
    }

    public String gNative2_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_native2_fb", context.getResources().getString(R.string.admob_native_id2));
        }
        return var;
    }

    public String gNative3_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_native3_fb", context.getResources().getString(R.string.admob_native_id3));
        }
        return var;
    }

    public String gRewarded1_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_rewarded1_fb", context.getResources().getString(R.string.admob_rewarded_id1));
        }
        return var;
    }

    public String gRewarded2_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_rewarded2_fb", context.getResources().getString(R.string.admob_rewarded_id2));
        }
        return var;
    }

    public String gRewarded3_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_rewarded3_fb", context.getResources().getString(R.string.admob_rewarded_id3));
        }
        return var;
    }

    public String gRewardedInter1_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_rewardinter1_fb", context.getResources().getString(R.string.admob_rewarded_inter_id1));
        }
        return var;
    }

    public String gRewardedInter2_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_rewardinter2_fb", context.getResources().getString(R.string.admob_rewarded_inter_id2));
        }
        return var;
    }

    public String gRewardedInter3_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("g_rewardinter3_fb", context.getResources().getString(R.string.admob_rewarded_inter_id3));
        }
        return var;
    }

    public boolean showBanner1_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_gbanner1_fb", true);
        }
        return output;
    }

    public boolean showBanner2_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_gbanner2_fb", true);
        }
        return output;
    }

    public boolean showBanner3_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_gbanner3_fb", true);
        }
        return output;
    }

    public boolean showInter1_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_ginter1_fb", true);
        }
        return output;
    }

    public boolean showInter2_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_ginter2_fb", true);
        }
        return output;
    }

    public boolean showInter3_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_ginter3_fb", true);
        }
        return output;
    }

    public boolean showAppopen1_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_gappopen1_fb", true);
        }
        return output;
    }

    public boolean showAppopen2_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_gappopen2_fb", true);
        }
        return output;
    }

    public boolean showAppopen3_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_gappopen3_fb", true);
        }
        return output;
    }

    public boolean showNative1_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_gnative1_fb", true);
        }
        return output;
    }

    public boolean showNative2_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_gnative2_fb", true);
        }
        return output;
    }

    public boolean showNative3_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_gnative3_fb", true);
        }
        return output;
    }

    public boolean showRewarded1_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_grewarded1_fb", true);
        }
        return output;
    }

    public boolean showRewarded2_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_grewarded2_fb", true);
        }
        return output;
    }

    public boolean showRewarded3_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_grewarded3_fb", true);
        }
        return output;
    }

    public boolean showRewardInter1_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_grewardinter1_fb", true);
        }
        return output;
    }

    public boolean showRewardInter2_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_grewardinter2_fb", true);
        }
        return output;
    }

    public boolean showRewardInter3_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = showAds() && adsPreference.getBoolean("show_grewardinter3_fb", true);
        }
        return output;
    }

    public String extrapara1_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("extra_para1_fb", "");
        }
        return var;
    }

    public String extrapara2_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("extra_para2_fb", "");
        }
        return var;
    }

    public String extrapara3_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("extra_para3_fb", "");
        }
        return var;
    }

    public String extrapara4_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("extra_para4_fb", "");
        }
        return var;
    }

    public boolean isUpdate_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = adsPreference.getBoolean("isUpdate_fb", false);
        }
        return output;
    }

    public boolean isAds_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = adsPreference.getBoolean("isAds_fb", false);
        }
        return output;
    }

    public boolean isNotification_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = adsPreference.getBoolean("isNotification_fb", false);
        }
        return output;
    }

    public String adDialogTitle_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("ad_dialog_title_fb", "Checkout This");
        }
        return var;
    }

    public String adAppName_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("ad_app_name_fb", "App Name");
        }
        return var;
    }

    public String adShortDesc_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("ad_app_short_desc_fb", "Short Desc");
        }
        return var;
    }

    public String adMessage_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("ad_message_fb", "Message");
        }
        return var;
    }

    public String adAppUrl_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("ad_app_url_fb", "http://");
        }
        return var;
    }

    public String adIconUrl_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("ad_icon_url_fb", "http://");
        }
        return var;
    }

    public String adBannerUrl_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("ad_banner_url_fb", "http://");
        }
        return var;
    }

    public String adButtonText_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("ad_button_text_fb", "Download");
        }
        return var;
    }

    public boolean adShowCancel_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = adsPreference.getBoolean("ad_show_cancel_fb", true);
        }
        return output;
    }


    public String notDialogTitle_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("not_dialog_title_fb", "Attention!");
        }
        return var;
    }

    public String notMessage_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("not_message_fb", "Maintanence Alert!");
        }
        return var;
    }

    public boolean notShowCancel_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = adsPreference.getBoolean("not_show_cancel_fb", true);
        }
        return output;
    }

    public String updateDialogTitle_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("update_dialog_title_fb", "Update Available");
        }
        return var;
    }

    public String updateTitle_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("update_title_fb", "Update App to use latest features");
        }
        return var;
    }

    public String updateAppUrl_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("update_app_url_fb", "http://");
        }
        return var;
    }

    public String updateMessage_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("update_message_fb", "Bug Fixed");
        }
        return var;
    }

    public String updateVersionName_fb() {
        String var = "";
        if (adsPreference != null) {
            var = adsPreference.getString("update_version_name_fb", "1.0");
        }
        return var;
    }

    public boolean updateShowCancel_fb() {
        boolean output = false;
        if (adsPreference != null) {
            output = adsPreference.getBoolean("update_show_cancel_fb", true);
        }
        return output;
    }

}



