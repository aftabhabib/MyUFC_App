package com.example.gemstudios.myufc_app.main_events;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gemstudios.myufc_app.R;
import com.example.gemstudios.myufc_app.data.network.AppDataManager;
import com.example.gemstudios.myufc_app.data.network.model.Events;
import com.example.gemstudios.myufc_app.data.network.model.EventsDetails;
import com.example.gemstudios.myufc_app.data.network.model.News;
import com.example.gemstudios.myufc_app.main_events.adapter.EventsTab_Adapter;
import com.example.gemstudios.myufc_app.main_events.mvp.EventsImpl;
import com.example.gemstudios.myufc_app.main_events.mvp.IEventsMvpView;
import com.example.gemstudios.myufc_app.ui.base.BaseFragment;
import com.example.gemstudios.myufc_app.ui.utils.rx.AppSchedulerProvider;
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork;

import java.util.List;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class EventsTab_Fragment extends BaseFragment
implements IEventsMvpView{

    /**
     * adding bindview for recyclyerview
     */

    @BindView(R.id.recycler) RecyclerView recyclerView;
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
        callService();

    }

    public void callService()
    {
        ReactiveNetwork.observeInternetConnectivity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean isConnectedToInternet) throws Exception {
                        if (isConnectedToInternet)
                        {
                            eventsTabfragmentPresenter.loadEvents();

                        }
                        else
                        {
                            AlertNetwork();

                        }
                    }
                });
    }

    /**
     * alert to tell user there is no internet, and in that case to get data from the cached storage
     */
    public void AlertNetwork()
    {
        AlertDialog.Builder a_builder = new AlertDialog.Builder(getActivity());
        a_builder.setMessage("There is no network connected.. Please make sure you are connected to the internet")
                .setCancelable(false)
                .setPositiveButton("Close the App", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        getActivity().finish();
                    }
                }).setNegativeButton("Continue using the App with cached data", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                Toast.makeText(getActivity(), "Loading from cache storage..", Toast.LENGTH_LONG).show();

            }
        });

        AlertDialog alert = a_builder.create();
        alert.setTitle("Connection status");
        alert.show();
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
