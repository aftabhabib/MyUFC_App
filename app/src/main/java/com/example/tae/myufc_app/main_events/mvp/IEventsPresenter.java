package com.example.tae.myufc_app.main_events.mvp;

import com.example.tae.myufc_app.ui.base.MvpPresenter;

/**
 * Created by TAE on 09-Mar-18.
 */

public interface IEventsPresenter <V extends IEventsMvpView> extends MvpPresenter<V> {

    void loadEvents();
    void loadEventsDetails(int id);
    void loadNews();

}
