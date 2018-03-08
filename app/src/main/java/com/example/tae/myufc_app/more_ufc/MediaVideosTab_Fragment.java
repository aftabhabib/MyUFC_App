package com.example.tae.myufc_app.more_ufc;


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
import com.example.tae.myufc_app.data.network.model.Medium;
import com.example.tae.myufc_app.more_ufc.mvp.IMediaMvpView;
import com.example.tae.myufc_app.more_ufc.mvp.MediaImpl;
import com.example.tae.myufc_app.ui.base.BaseFragment;
import com.example.tae.myufc_app.ui.utils.rx.AppSchedulerProvider;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

/**
 * A simple {@link Fragment} subclass.
 */
public class MediaVideosTab_Fragment extends BaseFragment
        implements IMediaMvpView {

    private RecyclerView recyclerView;
    private MediaImpl<MediaVideosTab_Fragment> mediaVideosFragmentPresenter;

    public MediaVideosTab_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mediaVideosFragmentPresenter = new MediaImpl<>(new AppDataManager(),
                new AppSchedulerProvider(), new CompositeDisposable());

        mediaVideosFragmentPresenter.onAttach(this);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_media_videos_tab_, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mediaVideosFragmentPresenter.loadMedia();
    }

    @Override
    public void onFetchDataProgress() {

    }

    @Override
    public void onFetchDataSuccess(List<Medium> media) {
        recyclerView.setAdapter(new MediaTab_Adapter(getActivity().getApplicationContext(), media, R.layout.media_row));
    }

    @Override
    public void onFetchDataError(String error) {

    }
}
