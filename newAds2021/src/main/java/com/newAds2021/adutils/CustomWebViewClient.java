package com.newAds2021.adutils;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class CustomWebViewClient extends WebViewClient {
    
    final String GAMEZOP_URL = "gamezop.com";
    final String NO_APPLICATION_ERROR = "You do not have an application to run this.";
            
;
    @Override
    public boolean shouldOverrideUrlLoading(
            WebView view, String url) {
        super.shouldOverrideUrlLoading(view, url);
        String domain = "";
        try {
            final URL fullUrl = new URL(url);
            domain = fullUrl.getHost();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (domain.contains(GAMEZOP_URL)) {
            view.loadUrl(url);
        } else {
            loadOutsideWebView(view, url);
        }
        return true;
    }

    private void loadOutsideWebView(WebView view, String url) {
        // Otherwise, the link is not for a page on the site,
        // so launch another intent that handles URLs.
        final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        final PackageManager packageManager = view.getContext().getPackageManager();
        final List<ResolveInfo> activities = packageManager.queryIntentActivities(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        final boolean isIntentSafe = activities.size() > 0;
        if (isIntentSafe) {
            view.getContext().startActivity(intent);
        } else {
            Toast.makeText(view.getContext(),
                    NO_APPLICATION_ERROR,
                    Toast.LENGTH_LONG).show();
        }
    }

}