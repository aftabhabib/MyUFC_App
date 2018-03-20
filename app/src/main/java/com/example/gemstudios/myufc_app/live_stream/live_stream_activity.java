package com.example.gemstudios.myufc_app.live_stream;

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

import butterknife.BindView;

public class live_stream_activity extends AppCompatActivity {

    /**
     * adding bindview for webview
     */
    @BindView(R.id.webView) WebView webView;
    private String urlPath;
    private AdView mAdView;
    private AdRequest adRequest;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_stream_activity);

        MobileAds.initialize(MyApp.getInstance().getAppContext(), "ca-app-pub-0870153753180861~4982064606");
        mAdView = findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        urlPath = ApiList.LIVE_STREAM_URL;
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