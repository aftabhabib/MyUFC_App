package com.example.tae.myufc_app.main_events;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.http.SslError;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.tae.myufc_app.MyApp;
import com.example.tae.myufc_app.R;
import com.example.tae.myufc_app.data.network.service.ApiList;

import java.net.URI;

public class NewsDetail_Activity extends AppCompatActivity {

    private SharedPreferences sharedPref;
    private WebView webView;
    private String newsId;
    private String urlPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail_);


        sharedPref = getSharedPreferences("NewsDetail", Context.MODE_PRIVATE);

        newsId = sharedPref.getString("news_detail", null);

        //urlPath = "http://ufc-data-api.ufc.com/api/v3/iphone/events/649234/";
        urlPath = ApiList.Base_URL + newsId;

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
