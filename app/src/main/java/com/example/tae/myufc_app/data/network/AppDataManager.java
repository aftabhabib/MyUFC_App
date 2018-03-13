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

public class AppDataManager implements DataManager{

    private IApiHelper iApiHelper;


    public AppDataManager() {
        iApiHelper = new AppApiHelper();
    }

  //  @Override
 //   public Observable<OctagonGirl> getOctagonGirlDetail(int id){
  //      return iApiHelper.getOctagonGirlDetail(id);
  //  }
    @Override
    public Observable<List<OctagonGirl>> getOctagonGirl() {
        return iApiHelper.getOctagonGirl();
    }

    public Observable<List<Medium>> getMedia() { return iApiHelper.getMedia();}

    public Observable<List<Events>> getEvents() { return iApiHelper.getEvents();}

    public Observable<List<EventsDetails>> getEventsDetails(int id) { return iApiHelper.getEventsDetails(id);}

    public Observable<List<News>> getNews() { return iApiHelper.getNews();}

    public Observable<List<TitleHolders>> getTitleHolders() { return iApiHelper.getTitleHolders();}

}
