package com.example.tae.myufc_app.main_events;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tae.myufc_app.R;
import com.example.tae.myufc_app.data.network.AppDataManager;
import com.example.tae.myufc_app.data.network.model.Events;
import com.example.tae.myufc_app.data.network.model.EventsDetails;
import com.example.tae.myufc_app.data.network.model.News;
import com.example.tae.myufc_app.main_events.adapter.EventsTab_Adapter;
import com.example.tae.myufc_app.main_events.mvp.EventsImpl;
import com.example.tae.myufc_app.main_events.mvp.IEventsMvpView;
import com.example.tae.myufc_app.ui.base.BaseFragment;
import com.example.tae.myufc_app.ui.utils.rx.AppSchedulerProvider;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

public class EventsTab_Fragment extends BaseFragment
implements IEventsMvpView{

    private RecyclerView recyclerView;
    private EventsImpl<EventsTab_Fragment> eventsTabfragmentPresenter;

    public EventsTab_Fragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setHasOptionsMenu(false);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        eventsTabfragmentPresenter = new EventsImpl<>(new AppDataManager(),
                new AppSchedulerProvider(), new CompositeDisposable());

        eventsTabfragmentPresenter.onAttach(this);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_events_tab_, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));

        eventsTabfragmentPresenter.loadEvents();
    }

    @Override
    public void onFetchDataProgress() {

    }

    @Override
    public void onFetchDataSuccess(List<Events> events) {

        recyclerView.setAdapter(new EventsTab_Adapter(getActivity().getApplicationContext(), events, R.layout.events_row));
    }

    @Override
    public void onFetchDataSuccessDetails(List<EventsDetails> eventsDetails) {

    }

    @Override
    public void onFetchDataError(String error) {

    }

    @Override
    public void onFetchDataSuccessNews(List<News> news) {

    }
}
