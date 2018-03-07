package com.example.tae.myufc_app.octagon_girls;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tae.myufc_app.R;
import com.example.tae.myufc_app.data.network.AppDataManager;
import com.example.tae.myufc_app.data.network.model.OctagonGirl;
import com.example.tae.myufc_app.ui.base.BaseFragment;
import com.example.tae.myufc_app.ui.utils.rx.AppSchedulerProvider;
import com.squareup.picasso.Picasso;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

/**
 * A simple {@link Fragment} subclass.
 */
public class OctagonGirlsDetailsTab_Fragment extends BaseFragment{

    private int id;
    private String name, height, weight, food, quote, website, img, youtube;
    private TextView tName, tQuote, tHeight, tWeight, tFood, tWeb, tYoutube;
    private ImageView tImage;
    SharedPreferences sharedPref;
    Context context;


    public OctagonGirlsDetailsTab_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getChanges();
        return inflater.inflate(R.layout.fragment_octagon_girls_details_tab_, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tName = view.findViewById(R.id.tName);
        tQuote = view.findViewById(R.id.tQuote);
        tHeight = view.findViewById(R.id.tHeight);
        tWeight = view.findViewById(R.id.tWeight);
        tFood = view.findViewById(R.id.tFood);
        tWeb = view.findViewById(R.id.tWeb);
        tImage = view.findViewById(R.id.tImg);
        tYoutube = view.findViewById(R.id.tYoutube);

        getChanges();

       }

       public void getChanges(){
           sharedPref = getContext().getSharedPreferences("myPrefs", Context.MODE_PRIVATE);

           sharedPref.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
               @Override
               public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                   name = sharedPref.getString("name", "No Octagon Girl Selected");
                   quote = sharedPref.getString("quote", "No Octagon Girl Selected");
                   food = sharedPref.getString("food", "No Octagon Girl Selected");
                   height = sharedPref.getString("height", "No Octagon Girl Selected");
                   weight = sharedPref.getString("weight", "No Octagon Girl Selected");
                   website = sharedPref.getString("website","No Octagon Girl Selected");
                   img = sharedPref.getString("img", "No Octagon Girl Selected");
                   youtube = sharedPref.getString("youtube", "No Octagon Girl Selected");

                   tName.setText(name.toString());
                   tQuote.setText(quote.toString());
                   tFood.setText(food.toString());
                   tHeight.setText(height.toString());
                   tWeight.setText(weight.toString());
                   tWeb.setText(website.toString());
                   tYoutube.setText(youtube.toString());

                   Picasso.with(context)
                           .load(img)
                           .into(tImage);
               }
           });
       }

}
