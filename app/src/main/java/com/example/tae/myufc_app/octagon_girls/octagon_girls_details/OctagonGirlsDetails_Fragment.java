package com.example.tae.myufc_app.octagon_girls.octagon_girls_details;


import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tae.myufc_app.MyApp;
import com.example.tae.myufc_app.R;
import com.example.tae.myufc_app.ui.base.BaseFragment;
import com.squareup.picasso.Picasso;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class OctagonGirlsDetails_Fragment extends BaseFragment {

    //private int id;
    private String name, height, weight, food, quote, website, img, youtube;
    private TextView tName, tQuote, tHeight, tWeight, tFood;
    private ImageButton btnYoutube;
    private ImageView tImage;
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


        btnYoutube = view.findViewById(R.id.btnYoutube);
        btnYoutube.setImageResource(R.drawable.ic_launcher_background);
        btnYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(youtube));
                startActivity(i);
                //Toast.makeText(getActivity(), "pressed", Toast.LENGTH_LONG).show();
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
