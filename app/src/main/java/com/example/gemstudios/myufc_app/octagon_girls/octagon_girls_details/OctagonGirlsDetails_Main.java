package com.example.gemstudios.myufc_app.octagon_girls.octagon_girls_details;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.gemstudios.myufc_app.MyApp;
import com.example.gemstudios.myufc_app.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class OctagonGirlsDetails_Main extends AppCompatActivity {

    FragmentManager fragmentManager;
    private AdView mAdView;
    private AdRequest adRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_octagon_girls_details__main);

        MobileAds.initialize(MyApp.getInstance().getAppContext(), "ca-app-pub-0870153753180861~4982064606");

        mAdView = findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        fragmentManager = getSupportFragmentManager();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        OctagonGirlsDetails_Fragment octagonGirlsDetails_fragment = new OctagonGirlsDetails_Fragment();
        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, octagonGirlsDetails_fragment)
                .disallowAddToBackStack()
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                adRequest = new AdRequest.Builder().build();
                mAdView.loadAd(adRequest);
                finish();

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
