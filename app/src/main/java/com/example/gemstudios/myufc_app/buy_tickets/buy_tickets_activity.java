package com.example.gemstudios.myufc_app.buy_tickets;

import android.net.http.SslError;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.gemstudios.myufc_app.R;
import com.example.gemstudios.myufc_app.data.network.service.ApiList;

public class buy_tickets_activity extends AppCompatActivity {

    private WebView webView;
    private String urlPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        urlPath = ApiList.BUY_TICKETS_URL;
        setContentView(R.layout.activity_buy_tickets_activity);

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