package com.example.tae.myufc_app.fighters;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tae.myufc_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StatsTab_Fragment extends Fragment {


    public StatsTab_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stats_tab_, container, false);
    }

}
