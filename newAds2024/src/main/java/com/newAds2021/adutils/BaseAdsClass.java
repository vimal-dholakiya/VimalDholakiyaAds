package com.newAds2021.adutils;

import static com.newAds2021.adsmodels.ConstantAds.dismisProgress;
import static com.newAds2021.adsmodels.ConstantAds.showProgress;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.cardview.widget.CardView;


import com.bumptech.glide.Glide;


import com.newAds2021.Interfaces.InhouseBannerListener;
import com.newAds2021.Interfaces.InhouseInterstitialListener;
import com.newAds2021.Interfaces.InhouseNativeListener;
import com.newAds2021.NetworkListner.NetworkStateReceiver;
import com.newAds2021.R;
import com.newAds2021.adsmodels.API;
import com.newAds2021.adsmodels.AdsDetails;
import com.newAds2021.adsmodels.AdsPrefernce;
import com.newAds2021.adsmodels.IhAdsDetail;
import com.newAds2021.adsmodels.ConstantAds;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Callable;

import retrofit2.Call;
import retrofit2.Response;


public class BaseAdsClass extends AppCompatActivity implements NetworkStateReceiver.NetworkStateReceiverListener {

    private NetworkStateReceiver networkStateReceiver;





    //inhouse
    public static boolean isLoaded_ADS, isLoaded_IH = false;
    public static int currentInter = 0;
    public static int currentBanner = 0;
    public static int currentNative = 0;
    public static boolean isFirstIHInter = true;
    public static boolean isFirstIHBanner = true;
    public static boolean isFirstIHNative = true;
    ArrayList<IhAdsDetail> ihAdsDetails;
    static ArrayList<IhAdsDetail> finalIHAds;


    AdsPrefernce adsPrefernce;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adsPrefernce = new AdsPrefernce(this);
        networkStateReceiver = new NetworkStateReceiver();
        networkStateReceiver.addListener(this);

        this.registerReceiver(networkStateReceiver, new IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));


        withDelay(2000, new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                if (!isLoaded_ADS) {
                    getAdsx();

                }

                return null;
            }
        });






    }

    public void getAdsx() {

        API.apiInterface().getAds(ConstantAds.adUrlId).enqueue(new retrofit2.Callback<AdsDetails>() {
            @Override
            public void onResponse(@NonNull Call<AdsDetails> call, @NonNull Response<AdsDetails> response) {
                AdsDetails adsDetails = response.body();

                ihAdsDetails = new ArrayList<>();

                try {
                    if (adsDetails.getIhAdsDetail() != null) {

                        ihAdsDetails = adsDetails.getIhAdsDetail();

                        if (ihAdsDetails != null && ihAdsDetails.size() > 0) {
                            finalIHAds = new ArrayList<>();
                            for (int i = 0; i < ihAdsDetails.size(); i++) {
                                if (ihAdsDetails.get(i).getShowad()) {
                                        finalIHAds.add(new IhAdsDetail(ihAdsDetails.get(i).getIhads_id(),
                                                ihAdsDetails.get(i).getShowad(),
                                                ihAdsDetails.get(i).getOpenin(),
                                                ihAdsDetails.get(i).getApplink(),
                                                ihAdsDetails.get(i).getShowreview(),
                                                ihAdsDetails.get(i).getReviewcount(),
                                                ihAdsDetails.get(i).getShowrating(),
                                                ihAdsDetails.get(i).getShowdouble(),
                                                ihAdsDetails.get(i).getRatingcount(),
                                                ihAdsDetails.get(i).getTitle(),
                                                ihAdsDetails.get(i).getSubtitle(),
                                                ihAdsDetails.get(i).getIcon(),
                                                ihAdsDetails.get(i).getExtratext(),
                                                ihAdsDetails.get(i).getButtontext(),
                                                ihAdsDetails.get(i).getBigimage(),
                                                ihAdsDetails.get(i).getDesc_title(),
                                                ihAdsDetails.get(i).getDesc_text()));
                                }
                            }
                            adsPrefernce.setInHouseAdDetails(finalIHAds);
                            isLoaded_IH = true;

                        }



                    }

                } catch (Exception e) {
                    e.printStackTrace();


                }



            }

            @Override
            public void onFailure(@NonNull Call<AdsDetails> call, @NonNull Throwable t) {
                Log.e("goggg", t.getLocalizedMessage());
            }
        });
    }

    int getCurrentInterAd(int totalAds) {
        if (!isFirstIHInter) {
            if (currentInter + 1 >= totalAds) {
                currentInter = 0;
            } else {
                currentInter = currentInter + 1;
            }
        } else {
            currentInter = 0;
            isFirstIHInter = false;

        }
        return currentInter;
    }

    int getCurrentBannerAd(int totalAds) {
        if (!isFirstIHBanner) {
            if (currentBanner + 1 >= totalAds) {
                currentBanner = 0;
            } else {
                currentBanner = currentBanner + 1;
            }
        } else {
            currentBanner = 0;
            isFirstIHBanner = false;

        }
        return currentBanner;

    }

    int getCurrentNativeAd(int totalAds) {
        if (!isFirstIHNative) {
            if (currentNative + 1 >= totalAds) {
                currentNative = 0;
            } else {
                currentNative = currentNative + 1;
            }
        } else {
            currentNative = 0;
            isFirstIHNative = false;

        }
        return currentNative;

    }

    public void showInhouseInterAd(Activity context, InhouseInterstitialListener inhouseInterstitialListener) {
        try {
            if (adsPrefernce.isInHouseAdLoaded()) {
                // get Interstitial Data
                ArrayList<IhAdsDetail> savedInterAdDetails = adsPrefernce.getInHouseAds();
                if (savedInterAdDetails.size() != 0) {
                    // ad to show from position
                    int current = getCurrentInterAd(savedInterAdDetails.size());


                    final Dialog interDialog = new Dialog(context);
                    interDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    interDialog.setContentView(R.layout.ad_interstitial);
                    interDialog.getWindow().setBackgroundDrawableResource(android.R.color.white);
                    interDialog.getWindow().setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
                    Objects.requireNonNull(interDialog.getWindow()).getAttributes().windowAnimations = R.style.InterstitialAdAnimation;
                    interDialog.setCancelable(false);

                    ImageView iv_close_ad = interDialog.findViewById(R.id.iv_close_ad);
                    LinearLayout lay_close_ad = interDialog.findViewById(R.id.lay_close_ad);
                    ImageView iv_ad_icon = interDialog.findViewById(R.id.iv_ad_icon);
                    RatingBar iv_inter_star_rating = interDialog.findViewById(R.id.iv_inter_star_rating);
                    TextView tv_inter_ad_title = interDialog.findViewById(R.id.tv_inter_ad_title);
                    TextView tv_inter_ad_subtitle = interDialog.findViewById(R.id.tv_inter_ad_subtitle);
                    TextView tv_inter_review_count = interDialog.findViewById(R.id.tv_inter_review_count);

                    ImageView iv_inter_main_banner = interDialog.findViewById(R.id.iv_inter_main_banner);

                    TextView tv_inter_ad_desc = interDialog.findViewById(R.id.tv_inter_ad_desc);
                    TextView tv_inter_ad_sub_desc = interDialog.findViewById(R.id.tv_inter_ad_sub_desc);

                    ImageView iv_inter_info = interDialog.findViewById(R.id.iv_inter_info);

                    TextView tv_install_btn_inter = interDialog.findViewById(R.id.tv_install_btn_inter);

                    // set Interstitial Data
                    IhAdsDetail interAd = savedInterAdDetails.get(current);

                    if (!context.isFinishing() && !context.isDestroyed()) {
                        // icon
                        Glide.with(context).load(interAd.getIcon()).into(iv_ad_icon);
                        // banner
                        Glide.with(context).load(interAd.getBigimage()).into(iv_inter_main_banner);
                    }
                    // title
                    tv_inter_ad_title.setText(interAd.getTitle());
                    // subtitle
                    tv_inter_ad_subtitle.setText(interAd.getSubtitle());
                    // install button Text
                    tv_install_btn_inter.setText(interAd.getButtontext());

                    // show rating or not and set rating image
                    if (interAd.getShowrating()) {
                        iv_inter_star_rating.setVisibility(View.VISIBLE);
                        iv_inter_star_rating.setRating(Float.parseFloat(interAd.getRatingcount()));
                    } else {
                        iv_inter_star_rating.setVisibility(View.GONE);
                    }

                    // show reviews or not and set review count
                    if (interAd.getShowreview()) {
                        tv_inter_review_count.setVisibility(View.VISIBLE);
                        tv_inter_review_count.setText("  ( " + interAd.getReviewcount() + " )");
                    } else {
                        tv_inter_review_count.setVisibility(View.GONE);
                    }

                    // description title
                    tv_inter_ad_desc.setText(interAd.getDesc_title());

                    // description text
                    tv_inter_ad_sub_desc.setText(interAd.getDesc_text());


                    withDelay(1000, new Callable<Void>() {
                        @Override
                        public Void call() throws Exception {
                            lay_close_ad.setVisibility(View.VISIBLE);
                            return null;
                        }
                    });

                    lay_close_ad.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            interDialog.dismiss();
                            inhouseInterstitialListener.onAdDismissed();
                        }
                    });

                    iv_inter_info.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            showAdsPrivacyDialog();
                        }
                    });

                    tv_install_btn_inter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // open link
                            if (interAd.getOpenin().equals("playstore")) {
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(interAd.getApplink())));
                            } else if (interAd.getOpenin().equals("customtab")) {
                                try {
                                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                                    CustomTabsIntent customTabsIntent = builder.build();
                                    customTabsIntent.intent.setPackage("com.android.chrome");
                                    customTabsIntent.launchUrl(context, Uri.parse(interAd.getApplink()));
                                } catch (ActivityNotFoundException ex) {
                                    // Chrome browser presumably not installed and open Kindle Browser
                                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                                    CustomTabsIntent customTabsIntent = builder.build();
                                    customTabsIntent.launchUrl(context, Uri.parse(interAd.getApplink()));
                                }
                            } else {
                                Uri uri = Uri.parse(interAd.getApplink()); // missing 'http://' will cause crashed
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                startActivity(intent);
                            }
                        }
                    });



                        if (!context.isFinishing() && !context.isDestroyed()) {
                            interDialog.show();
                            inhouseInterstitialListener.onAdShown();
                        } else {
                            inhouseInterstitialListener.onAdDismissed();
                        }

                } else {
                    inhouseInterstitialListener.onAdDismissed();
                }
            } else {
                inhouseInterstitialListener.onAdDismissed();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            inhouseInterstitialListener.onAdDismissed();
        }
    }

    public void showInhouseBannerAd(InhouseBannerListener inhouseBannerListener) {
        try {
            if (adsPrefernce.isInHouseAdLoaded()) {
                ArrayList<IhAdsDetail> savedIhAdsDetails = adsPrefernce.getInHouseAds();
                if (savedIhAdsDetails.size() != 0) {
                    // ad to show from position
                    int current = getCurrentBannerAd(savedIhAdsDetails.size());

                    ImageView iv_banner_info = findViewById(R.id.iv_banner_info);
                    ImageView iv_close_ad_banner = findViewById(R.id.iv_close_ad_banner);
                    ImageView iv_ad_icon_banner = findViewById(R.id.iv_ad_icon_banner);

                    TextView tv_banner_ad_title = findViewById(R.id.tv_banner_ad_title);
                    TextView tv_banner_ad_subtitle = findViewById(R.id.tv_banner_ad_subtitle);

                    RatingBar iv_banner_star_rating = findViewById(R.id.iv_banner_star_rating);
                    TextView tv_banner_review_count = findViewById(R.id.tv_banner_review_count);

                    TextView tv_install_btn_banner = findViewById(R.id.tv_install_btn_banner);
                    TextView tv_banner_extra_text = findViewById(R.id.tv_banner_extra_text);

                    RelativeLayout lay_first = findViewById(R.id.lay_first);
                    RelativeLayout lay_second = findViewById(R.id.lay_second);
                    RelativeLayout lay_banner_ad = findViewById(R.id.lay_banner_ad);

                    lay_banner_ad.setVisibility(View.VISIBLE);


                    // set Banner Data
                    IhAdsDetail bannerAd = savedIhAdsDetails.get(current);


                    //icon
                    if (!this.isFinishing() || !this.isDestroyed()) {
                        Glide.with(this).load(bannerAd.getIcon()).into(iv_ad_icon_banner);
                    }

                    // title
                    tv_banner_ad_title.setText(bannerAd.getTitle());
                    // subtitle
                    tv_banner_ad_subtitle.setText(bannerAd.getSubtitle());
                    // install button Text
                    tv_install_btn_banner.setText(bannerAd.getButtontext());

                    // show rating or not and set rating image
                    if (bannerAd.getShowrating()) {
                        iv_banner_star_rating.setVisibility(View.VISIBLE);
                        iv_banner_star_rating.setRating(Float.parseFloat(bannerAd.getRatingcount()));
                    } else {
                        iv_banner_star_rating.setVisibility(View.GONE);
                    }

                    // show reviews or not and set review count
                    if (bannerAd.getShowreview()) {
                        tv_banner_review_count.setVisibility(View.VISIBLE);
                        tv_banner_review_count.setText("  ( " + bannerAd.getReviewcount() + " )");
                    } else {
                        tv_banner_review_count.setVisibility(View.GONE);
                    }

                    // extra text
                    tv_banner_extra_text.setText(bannerAd.getExtratext());

                    // check if double layout
                    if (bannerAd.getShowdouble()) {
                        Handler handler = new Handler();
                        Runnable run = new Runnable() {
                            @Override
                            public void run() {
                                if (lay_first.getVisibility() == View.VISIBLE) {
                                    lay_first.setVisibility(View.GONE);
                                    lay_second.setVisibility(View.VISIBLE);
                                } else {
                                    lay_first.setVisibility(View.VISIBLE);
                                    lay_second.setVisibility(View.GONE);
                                }
                                handler.postDelayed(this, 3000);
                            }
                        };

                        handler.post(run);

                    } else {
                        lay_first.setVisibility(View.VISIBLE);
                        lay_second.setVisibility(View.GONE);
                    }

                    // set selected
                    tv_banner_ad_title.setSelected(true);
                    tv_banner_ad_subtitle.setSelected(true);
                    tv_banner_extra_text.setSelected(true);


                    iv_banner_info.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            showAdsPrivacyDialog();
                        }
                    });

                    tv_install_btn_banner.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // open link
                            if (bannerAd.getOpenin().equals("playstore")) {
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(bannerAd.getApplink())));
                            } else if (bannerAd.getOpenin().equals("customtab")) {
                                try {
                                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                                    CustomTabsIntent customTabsIntent = builder.build();
                                    customTabsIntent.intent.setPackage("com.android.chrome");
                                    customTabsIntent.launchUrl(view.getContext(), Uri.parse(bannerAd.getApplink()));
                                } catch (ActivityNotFoundException ex) {
                                    // Chrome browser presumably not installed and open Kindle Browser
                                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                                    CustomTabsIntent customTabsIntent = builder.build();
                                    customTabsIntent.launchUrl(view.getContext(), Uri.parse(bannerAd.getApplink()));
                                }
                            } else {
                                Uri uri = Uri.parse(bannerAd.getApplink()); // missing 'http://' will cause crashed
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                startActivity(intent);
                            }
                        }
                    });
                    inhouseBannerListener.onAdLoaded();
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void inflateNativeAdInHouse(Boolean isSmall, CardView cardView) {

        // Add the Ad view into the ad container.
        LayoutInflater inflater = LayoutInflater.from(this);
        RelativeLayout adViews = (RelativeLayout) inflater.inflate(R.layout.ad_native, cardView, false);
        cardView.removeAllViews();

//            cardView.setBackground(getResources().getDrawable(R.drawable.gnt_rounded_corners_shape));
        cardView.addView(adViews);

        // get Interstitial Data
        ArrayList<IhAdsDetail> nativeDetails = adsPrefernce.getInHouseAds();

        try {
            if (nativeDetails.size() != 0) {
                // ad to show from position
                int current = getCurrentNativeAd(nativeDetails.size());

                ImageView iv_native_info = adViews.findViewById(R.id.iv_native_info);
                ImageView iv_ad_icon_native = adViews.findViewById(R.id.iv_ad_icon_native);
                ImageView iv_native_main_banner = adViews.findViewById(R.id.iv_native_main_banner);

                TextView tv_native_ad_title = adViews.findViewById(R.id.tv_native_ad_title);
                TextView tv_native_ad_subtitle = adViews.findViewById(R.id.tv_native_ad_subtitle);

                RatingBar native_ad_rating = adViews.findViewById(R.id.native_ad_rating);
                TextView tv_native_review_count = adViews.findViewById(R.id.tv_native_review_count);

                TextView btn_ad_install_native = adViews.findViewById(R.id.btn_ad_install_native);
                TextView tv_native_extra_text = adViews.findViewById(R.id.tv_native_extra_text);

                RelativeLayout lay_native_ad = adViews.findViewById(R.id.lay_native_ad);
                RelativeLayout bottom_view = adViews.findViewById(R.id.bottom_view);

                lay_native_ad.setVisibility(View.VISIBLE);


                // set Interstitial Data
                IhAdsDetail nativeAd = nativeDetails.get(current);


                if (!this.isFinishing() || !this.isDestroyed()) {
                    // icon
                    Glide.with(this).load(nativeAd.getIcon()).into(iv_ad_icon_native);
                    // banner
                    if (isSmall) {
                        iv_native_main_banner.setVisibility(View.GONE);
                    } else {
                        iv_native_main_banner.setVisibility(View.VISIBLE);
                        Glide.with(this).load(nativeAd.getBigimage()).into(iv_native_main_banner);

                    }

                }

                // title
                tv_native_ad_title.setText(nativeAd.getTitle());
                // subtitle
                tv_native_ad_subtitle.setText(nativeAd.getSubtitle());
                // install button Text
                btn_ad_install_native.setText(nativeAd.getButtontext());
                if (ConstantAds.ad_bg_drawable != 0) {
                    btn_ad_install_native.setBackgroundResource(ConstantAds.ad_bg_drawable);
                }

                // show rating or not and set rating image
                if (nativeAd.getShowrating()) {
                    native_ad_rating.setVisibility(View.VISIBLE);
                    native_ad_rating.setRating(Float.parseFloat(nativeAd.getRatingcount()));
                } else {
                    native_ad_rating.setVisibility(View.GONE);
                }

                // show reviews or not and set review count
                if (nativeAd.getShowreview().equals("1")) {
                    tv_native_review_count.setVisibility(View.VISIBLE);
                    tv_native_review_count.setText("  ( " + nativeAd.getReviewcount() + " )");
                } else {
                    tv_native_review_count.setVisibility(View.GONE);
                }

                // extra text
                tv_native_extra_text.setText(nativeAd.getExtratext());

                // set selected
                tv_native_ad_title.setSelected(true);
                tv_native_ad_subtitle.setSelected(true);
                tv_native_extra_text.setSelected(true);

                iv_native_info.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showAdsPrivacyDialog();
                    }
                });

                btn_ad_install_native.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // open link
                        if (nativeAd.getOpenin().equals("playstore")) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(nativeAd.getApplink())));
                        } else if (nativeAd.getOpenin().equals("customtab")) {
                            try {
                                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                                CustomTabsIntent customTabsIntent = builder.build();
                                customTabsIntent.intent.setPackage("com.android.chrome");
                                customTabsIntent.launchUrl(view.getContext(), Uri.parse(nativeAd.getApplink()));
                            } catch (ActivityNotFoundException ex) {
                                // Chrome browser presumably not installed and open Kindle Browser
                                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                                CustomTabsIntent customTabsIntent = builder.build();
                                customTabsIntent.launchUrl(view.getContext(), Uri.parse(nativeAd.getApplink()));
                            }
                        } else {
                            Uri uri = Uri.parse(nativeAd.getApplink()); // missing 'http://' will cause crashed
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    }
                });

                if (ConstantAds.native_ad_bg != 0) {
                    lay_native_ad.setBackgroundResource(ConstantAds.native_ad_bg);
                }

            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


    }

    void showAdsPrivacyDialog() {
        Dialog privacyDialog = new Dialog(BaseAdsClass.this);
        privacyDialog.setContentView(R.layout.ads_privacy_dialog);
        Objects.requireNonNull(privacyDialog.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        privacyDialog.setCancelable(false);
        TextView tv_ok_btn_ad_privacy = privacyDialog.findViewById(R.id.tv_ok_btn_ad_privacy);
        tv_ok_btn_ad_privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                privacyDialog.dismiss();
            }
        });
        privacyDialog.show();

    }

    public void showBannerAd() {
        showInhouseBannerAd(new InhouseBannerListener() {
            @Override
            public void onAdLoaded() {
            }

            @Override
            public void onAdShowFailed() {
            }
        });

    }

    public void showBannerAd(View bannerView) {
        showInhouseBannerAd(new InhouseBannerListener() {
            @Override
            public void onAdLoaded() {
                bannerView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAdShowFailed() {
                bannerView.setVisibility(View.GONE);
            }
        });

    }

    public void showNativeAd(boolean isSmall, View nativeView) {
        if (isSmall){
            showInhouseNativeAd(isSmall, findViewById(R.id.native_ad_container_small), new InhouseNativeListener() {
                @Override
                public void onAdLoaded() {
                    nativeView.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAdShowFailed() {
                    nativeView.setVisibility(View.GONE);
                }
            });
        }else {
            showInhouseNativeAd(isSmall, findViewById(R.id.native_ad_container), new InhouseNativeListener() {
                @Override
                public void onAdLoaded() {
                    nativeView.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAdShowFailed() {
                    nativeView.setVisibility(View.GONE);
                }
            });
        }




    }

    public void showNativeAd(boolean isSmall) {

            if (isSmall){
                showInhouseNativeAd(isSmall, findViewById(R.id.native_ad_container_small), new InhouseNativeListener() {
                    @Override
                    public void onAdLoaded() {

                    }

                    @Override
                    public void onAdShowFailed() {

                    }
                });
            }else {
                showInhouseNativeAd(isSmall, findViewById(R.id.native_ad_container), new InhouseNativeListener() {
                    @Override
                    public void onAdLoaded() {

                    }

                    @Override
                    public void onAdShowFailed() {

                    }
                });
            }






    }

    public void showInterstitialAd(Activity context, Callable<Void> callable) {

        showInhouseInterAd(context, new InhouseInterstitialListener() {
            @Override
            public void onAdShown() {

            }

            @Override
            public void onAdDismissed() {
                try {
                    callable.call();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void showInhouseNativeAd(Boolean isSmall, CardView cardView, InhouseNativeListener
            inhouseNativeListener) {
        try {
            if (adsPrefernce.isInHouseAdLoaded()) {
                if (adsPrefernce.getInHouseAds().size() != 0) {
                    cardView.setVisibility(View.VISIBLE);
                    inflateNativeAdInHouse(isSmall, cardView);
                    inhouseNativeListener.onAdLoaded();
                    cardView.setCardBackgroundColor(getResources().getColor(R.color.white));
                    cardView.setBackgroundColor(getResources().getColor(R.color.white));
                } else {
                    cardView.setVisibility(View.GONE);
                    inhouseNativeListener.onAdShowFailed();
                }
            } else {
                cardView.setVisibility(View.GONE);
                inhouseNativeListener.onAdShowFailed();
            }
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
            cardView.setVisibility(View.GONE);
            inhouseNativeListener.onAdShowFailed();
        }

    }

    public void hideStatusBar() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void exitApp() {

        ConstantAds.IS_APP_KILLED = true;
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
        finish();
    }

    public static boolean isConnected(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void withDelay(int delay, Callable<Void> callable) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    callable.call();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, delay);
    }

    public void withDelay(Activity context, int delay, String message, Callable<Void> callable) {
        showProgress(context, message);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dismisProgress(context);
                try {
                    callable.call();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, delay);
    }

    public void toast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void networkAvailable() {
        withDelay(500, new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                if (!isLoaded_ADS) {
                    getAdsx();

                }

                return null;
            }
        });

    }

    @Override
    public void networkUnavailable() {

    }
































}
