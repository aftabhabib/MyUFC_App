package com.example.tae.myufc_app.main_events.mvp;

import com.example.tae.myufc_app.data.network.model.Events;
import com.example.tae.myufc_app.data.network.model.EventsDetails;
import com.example.tae.myufc_app.ui.base.MvpView;

import java.util.List;

/**
 * Created by TAE on 09-Mar-18.
 */

public interface IEventsMvpView extends MvpView {

    void onFetchDataProgress();

    void onFetchDataSuccess(List<Events> media);

    void onFetchDataSuccessDetails(List<EventsDetails> eventsDetails);

    void onFetchDataError(String error);
}
