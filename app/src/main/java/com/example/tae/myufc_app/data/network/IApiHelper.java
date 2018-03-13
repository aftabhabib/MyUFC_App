package com.example.tae.myufc_app.data.network;

import com.example.tae.myufc_app.data.network.model.Events;
import com.example.tae.myufc_app.data.network.model.EventsDetails;
import com.example.tae.myufc_app.data.network.model.Medium;
import com.example.tae.myufc_app.data.network.model.News;
import com.example.tae.myufc_app.data.network.model.OctagonGirl;
import com.example.tae.myufc_app.data.network.model.TitleHolders;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by TAE on 13-Feb-18.
 */

public interface IApiHelper {

    Observable<List<OctagonGirl>> getOctagonGirl();

    Observable<List<Medium>> getMedia();

    Observable<List<Events>> getEvents();

    Observable<List<EventsDetails>> getEventsDetails(int id);

    Observable<List<News>> getNews();

    Observable<List<TitleHolders>> getTitleHolders();

   // Observable<OctagonGirl> getOctagonGirlDetail(int id);
}
