package com.example.tae.myufc_app.main_events.event_details;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tae.myufc_app.R;
import com.example.tae.myufc_app.data.network.AppDataManager;
import com.example.tae.myufc_app.data.network.model.Events;
import com.example.tae.myufc_app.data.network.model.EventsDetails;
import com.example.tae.myufc_app.data.network.model.News;
import com.example.tae.myufc_app.main_events.adapter.EventsDetails_Adapter;
import com.example.tae.myufc_app.main_events.mvp.EventsImpl;
import com.example.tae.myufc_app.main_events.mvp.IEventsMvpView;
import com.example.tae.myufc_app.ui.base.BaseFragment;
import com.example.tae.myufc_app.ui.utils.rx.AppSchedulerProvider;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventDetailsFragment extends BaseFragment
implements IEventsMvpView{


    /**
     * initiating objects and butterknife
     */
    private int id;
    SharedPreferences sharedPref;
    private String name;
    @BindView(R.id.tNameText) TextView tNameText;
    @BindView(R.id.recycler) RecyclerView recyclerView;

    private EventsImpl<EventDetailsFragment> eventDetailsFragmentPresenter;

    public EventDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
/**
 * initiating the presenter and attaching this view to the presenter
 */
        eventDetailsFragmentPresenter = new EventsImpl<>(new AppDataManager(),
            new AppSchedulerProvider(), new CompositeDisposable());

        eventDetailsFragmentPresenter.onAttach(this);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_details, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /**
         * initiating shared preferences to get the event name
         */
        sharedPref = getActivity().getSharedPreferences("EventDetails", Context.MODE_PRIVATE);

        name = sharedPref.getString("event_name", null);
        tNameText.setText(name);

        id = sharedPref.getInt("event_id", 0);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        /**
         * presenter to make irequest interface and passing the Id
         */
        eventDetailsFragmentPresenter.loadEventsDetails(id);

    }

    @Override
    public void onFetchDataProgress() {

    }

    @Override
    public void onFetchDataSuccess(List<Events> media) {


    }

    /**
     * on success then set the adapter for the recycler view
     */
    @Override
    public void onFetchDataSuccessDetails(List<EventsDetails> eventsDetails) {
       // Toast.makeText(getActivity().getApplicationContext(), "the id is: " + eventsDetails.get(0).getFighter1FirstName(), Toast.LENGTH_LONG).show();
        recyclerView.setAdapter(new EventsDetails_Adapter(getActivity().getApplicationContext(), eventsDetails, R.layout.events_details_row));

    }


    @Override
    public void onFetchDataError(String error) {

    }

    @Override
    public void onFetchDataSuccessNews(List<News> news) {

    }
}
