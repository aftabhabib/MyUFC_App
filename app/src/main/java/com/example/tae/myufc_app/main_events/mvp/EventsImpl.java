package com.example.tae.myufc_app.main_events.mvp;

import com.example.tae.myufc_app.data.network.DataManager;
import com.example.tae.myufc_app.data.network.model.Events;
import com.example.tae.myufc_app.ui.base.BasePresenter;
import com.example.tae.myufc_app.ui.utils.rx.SchedulerProvider;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by TAE on 09-Mar-18.
 */

public class EventsImpl <V extends IEventsMvpView>
extends BasePresenter<V>
implements IEventsPresenter<V>{

    public EventsImpl(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void loadEvents() {

        getCompositeDisposable()
                .add(getDataManager().getEvents()
                .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(new Consumer<List<Events>>() {
                            @Override
                            public void accept(List<Events> events) throws Exception {
                                getMvpView().onFetchDataSuccess(events);
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                            }
                        }));
    }
}
