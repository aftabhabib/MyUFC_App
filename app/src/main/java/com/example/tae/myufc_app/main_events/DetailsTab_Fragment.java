package com.example.tae.myufc_app.main_events;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tae.myufc_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsTab_Fragment extends Fragment {


    public DetailsTab_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details_tab, container, false);
    }

    public interface OnFragmentInteractionListener {
    }
}
