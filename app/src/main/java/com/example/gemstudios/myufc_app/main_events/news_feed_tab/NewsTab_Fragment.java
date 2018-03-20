package com.example.gemstudios.myufc_app.main_events.news_feed_tab;


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
import com.example.gemstudios.myufc_app.data.network.model.Events;
import com.example.gemstudios.myufc_app.data.network.model.EventsDetails;
import com.example.gemstudios.myufc_app.data.network.model.News;
import com.example.gemstudios.myufc_app.main_events.adapter.NewsTab_Adapter;
import com.example.gemstudios.myufc_app.main_events.mvp.EventsImpl;
import com.example.gemstudios.myufc_app.main_events.mvp.IEventsMvpView;
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
public class NewsTab_Fragment extends BaseFragment implements
        IEventsMvpView{

    private RecyclerView recyclerView;
    private EventsImpl<NewsTab_Fragment> newsTabFragmentPresenter;
    private AdView mAdView;
    private AdRequest adRequest;


    public NewsTab_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        newsTabFragmentPresenter = new EventsImpl<>(new AppDataManager(),
                new AppSchedulerProvider(), new CompositeDisposable());

        newsTabFragmentPresenter.onAttach(this);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_tab, container, false);
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

        newsTabFragmentPresenter.loadNews();
    }

    @Override
    public void onFetchDataProgress() {

    }

    @Override
    public void onFetchDataSuccess(List<Events> media) {

    }

    @Override
    public void onFetchDataSuccessDetails(List<EventsDetails> eventsDetails) {

    }

    @Override
    public void onFetchDataError(String error) {

    }

    @Override
    public void onFetchDataSuccessNews(List<News> news) {

        recyclerView.setAdapter(new NewsTab_Adapter(getActivity().getApplicationContext(),  R.layout.news_row, news));
    }
}
