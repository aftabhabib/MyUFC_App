package com.example.gemstudios.myufc_app.octagon_girls.octagon_girls_gallery_tab;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gemstudios.myufc_app.MyApp;
import com.example.gemstudios.myufc_app.R;
import com.example.gemstudios.myufc_app.data.network.AppDataManager;
import com.example.gemstudios.myufc_app.data.network.model.OctagonGirl;
import com.example.gemstudios.myufc_app.octagon_girls.adapter.OctagonGirlGalleryTab_Adapter;
import com.example.gemstudios.myufc_app.octagon_girls.mvp.IOctagonGirlMvpView;
import com.example.gemstudios.myufc_app.octagon_girls.mvp.OctagonGirlImpl;
import com.example.gemstudios.myufc_app.ui.base.BaseFragment;
import com.example.gemstudios.myufc_app.ui.utils.rx.AppSchedulerProvider;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

/**
 * A simple {@link Fragment} subclass.
 */
public class OctagonGirlsGalleryTab_Fragment extends BaseFragment
        implements IOctagonGirlMvpView {

    private RecyclerView recyclerView;
    private OctagonGirlImpl<OctagonGirlsGalleryTab_Fragment> octagonGirlDetailFragment;
    private AdView mAdView;
    private AdRequest adRequest;
    public OctagonGirlsGalleryTab_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        octagonGirlDetailFragment = new OctagonGirlImpl<>(new AppDataManager(),
                new AppSchedulerProvider(), new CompositeDisposable());

        octagonGirlDetailFragment.onAttach(this);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_octagon_girls_gallery_tab_, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MobileAds.initialize(MyApp.getInstance().getAppContext(), "ca-app-pub-0870153753180861~4982064606");

        mAdView = view.findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        octagonGirlDetailFragment.loadOctagonGirlGallery();
    }

    @Override
    public void onFetchDataProgress() {

    }

    @Override
    public void onFetchDataSuccess(List<OctagonGirl> octagonGirl) {
        recyclerView.setAdapter(new OctagonGirlGalleryTab_Adapter(getActivity().getApplicationContext(), octagonGirl, R.layout.octagon_girls_gallery_row));

    }

    @Override
    public void onFetchDataError(String error) {

    }
}
