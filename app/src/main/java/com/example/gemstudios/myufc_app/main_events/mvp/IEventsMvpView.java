package com.example.gemstudios.myufc_app.main_events.mvp;

import com.example.gemstudios.myufc_app.data.network.model.Events;
import com.example.gemstudios.myufc_app.data.network.model.EventsDetails;
import com.example.gemstudios.myufc_app.data.network.model.News;
import com.example.gemstudios.myufc_app.ui.base.MvpView;

import java.util.List;

/**
 * Created by TAE on 09-Mar-18.
 */

public interface IEventsMvpView extends MvpView {

    void onFetchDataProgress();

    void onFetchDataSuccess(List<Events> media);

    void onFetchDataSuccessDetails(List<EventsDetails> eventsDetails);

    void onFetchDataError(String error);

    void onFetchDataSuccessNews(List<News> news);
}
