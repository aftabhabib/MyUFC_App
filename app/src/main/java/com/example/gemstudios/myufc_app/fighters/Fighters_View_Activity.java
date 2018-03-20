package com.example.gemstudios.myufc_app.fighters;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.http.SslError;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.gemstudios.myufc_app.MyApp;
import com.example.gemstudios.myufc_app.R;
import com.example.gemstudios.myufc_app.data.network.service.ApiList;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Fighters_View_Activity extends AppCompatActivity {

    private SharedPreferences sharedPref;
    private WebView webView;
    private int fighterId;
    private String urlPath;
    private AdView mAdView;
    private AdRequest adRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fighters__view_);

        MobileAds.initialize(MyApp.getInstance().getAppContext(), "ca-app-pub-0870153753180861~1455729045");

        mAdView = findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        sharedPref = getSharedPreferences("ViewFighter", Context.MODE_PRIVATE);

        fighterId = sharedPref.getInt("fighter_details", 0);

        urlPath = ApiList.Base_URL + ApiList.FIGHTERS_URL + fighterId;

        getWeb();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void getWeb() {
        webView = findViewById(R.id.webView);
        //webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                if (handler != null) {
                    handler.proceed();
                } else {
                    super.onReceivedSslError(view, null, error);
                }
            }
        });

        webView.loadUrl(urlPath);
        webView.setHorizontalScrollBarEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        //webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.getSettings().setBuiltInZoomControls(true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

