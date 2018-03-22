package com.example.gemstudios.myufc_app.octagon_girls.octagon_girls_details;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gemstudios.myufc_app.MyApp;
import com.example.gemstudios.myufc_app.R;
import com.example.gemstudios.myufc_app.ui.base.BaseFragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class OctagonGirlsDetails_Fragment extends BaseFragment {

    /**
     * adding bindview for recyclyerview and other variable parameters
     */

    @BindView(R.id.tName) TextView tName;
    @BindView(R.id.tQuote) TextView tQuote;
    @BindView(R.id.tHeight) TextView tHeight;
    @BindView(R.id.tWeight) TextView tWeight;
    @BindView(R.id.tFood) TextView tFood;
    @BindView(R.id.btnWeb) ImageButton btnWeb;
    @BindView(R.id.btnYoutube) ImageButton btnYoutube;
    @BindView(R.id.tImg) ImageView tImage;
    private AdView mAdView;
    private AdRequest adRequest;

    private String name, height, weight, food, quote, website, img, youtube;
    SharedPreferences sharedPref;
    Context context;


    public OctagonGirlsDetails_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //if (savedInstanceState == null) {
       // getChanges();
        //}
      //  setHasOptionsMenu(true);

        sharedPref = getActivity().getSharedPreferences("myPrefs", MODE_PRIVATE);
        return inflater.inflate(R.layout.fragment_octagon_girls_details_tab_, container, false);
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MobileAds.initialize(MyApp.getInstance().getAppContext(), "ca-app-pub-0870153753180861~4982064606");

        mAdView = view.findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        btnYoutube = view.findViewById(R.id.btnYoutube);
        btnYoutube.setImageResource(R.drawable.youtube_logo);

            btnYoutube.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (youtube != "") {
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(youtube));
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(getActivity(), "No youtube link found!", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        btnWeb = view.findViewById(R.id.btnWeb);
        btnWeb.setImageResource(R.drawable.web_logo);


            btnWeb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (website != "") {
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(website));
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(getActivity(), "No website link found!", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        tName = view.findViewById(R.id.tName);
        tQuote = view.findViewById(R.id.tQuote);
        tHeight = view.findViewById(R.id.tHeight);
        tWeight = view.findViewById(R.id.tWeight);
        tFood = view.findViewById(R.id.tFood);
       // tWeb = "";
        tImage = view.findViewById(R.id.tImg);
         if (sharedPref != null) {
        getChanges();
          }
    }


    public void getChanges() {
                name = sharedPref.getString("name", "No Octagon Girl Selected");
                quote = sharedPref.getString("quote", "No Octagon Girl Selected");
                food = sharedPref.getString("food", "No Octagon Girl Selected");
                height = sharedPref.getString("height", "No Octagon Girl Selected");
                weight = sharedPref.getString("weight", "No Octagon Girl Selected");
                website = sharedPref.getString("website", "No Octagon Girl Selected");
                img = sharedPref.getString("img", "No Octagon Girl Selected");
                youtube = sharedPref.getString("youtube", "No Octagon Girl Selected");

                tName.setText(name.toString());
                tQuote.setText(quote.toString());
                tFood.setText(food.toString());
                tHeight.setText(height.toString());
                tWeight.setText(weight.toString());


                Picasso.with(getActivity())
                        .load(img)
                        .into(tImage);
            }


}

