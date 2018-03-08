package com.example.tae.myufc_app.octagon_girls;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tae.myufc_app.R;
import com.example.tae.myufc_app.data.network.AppDataManager;
import com.example.tae.myufc_app.data.network.model.OctagonGirl;
import com.example.tae.myufc_app.octagon_girls.mvp.IOctagonGirlMvpView;
import com.example.tae.myufc_app.octagon_girls.mvp.OctagonGirlImpl;
import com.example.tae.myufc_app.ui.base.BaseFragment;
import com.example.tae.myufc_app.ui.utils.rx.AppSchedulerProvider;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

/**
 * A simple {@link Fragment} subclass.
 */
public class OctagonGirlsGalleryTab_Fragment extends BaseFragment
        implements IOctagonGirlMvpView {

    private RecyclerView recyclerView;
    private OctagonGirlImpl<OctagonGirlsGalleryTab_Fragment> octagonGirlDetailFragment;

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
