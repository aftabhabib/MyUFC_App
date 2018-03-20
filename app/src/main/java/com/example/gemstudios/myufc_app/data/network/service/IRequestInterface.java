package com.example.gemstudios.myufc_app.data.network.service;


import com.example.gemstudios.myufc_app.data.network.model.Events;
import com.example.gemstudios.myufc_app.data.network.model.EventsDetails;
import com.example.gemstudios.myufc_app.data.network.model.Fighters;
import com.example.gemstudios.myufc_app.data.network.model.Medium;
import com.example.gemstudios.myufc_app.data.network.model.News;
import com.example.gemstudios.myufc_app.data.network.model.OctagonGirl;
import com.example.gemstudios.myufc_app.data.network.model.TitleHolders;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by TAE on 09-Feb-18.
 */

public interface IRequestInterface {


    /**
     * Octagon girls api
     */
    @GET(ApiList.OCTAGON_GIRLS)
    Observable<List<OctagonGirl>> getOctagonGirl();

    @GET(ApiList.MEDIA_URL)
    Observable<List<Medium>> getMedia();

    @GET(ApiList.EVENT_URL)
    Observable<List<Events>> getEvents();

    @GET(ApiList.EVENT_DETAILS_URL)
    Observable<List<EventsDetails>> getEventsDetails(@Path("id") int id);

    @GET(ApiList.NEWS_URL)
    Observable<List<News>> getNews();

    @GET(ApiList.TITLE_HOLDERS_URL)
    Observable<List<TitleHolders>> getTitleHolders();

   @GET(ApiList.FIGHTERS_URL)
    Observable<List<Fighters>> getFighters();

}
