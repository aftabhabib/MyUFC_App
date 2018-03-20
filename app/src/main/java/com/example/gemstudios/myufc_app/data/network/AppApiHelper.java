package com.example.gemstudios.myufc_app.data.network;

import com.example.gemstudios.myufc_app.data.network.model.Events;
import com.example.gemstudios.myufc_app.data.network.model.EventsDetails;
import com.example.gemstudios.myufc_app.data.network.model.Fighters;
import com.example.gemstudios.myufc_app.data.network.model.Medium;
import com.example.gemstudios.myufc_app.data.network.model.News;
import com.example.gemstudios.myufc_app.data.network.model.OctagonGirl;
import com.example.gemstudios.myufc_app.data.network.model.TitleHolders;
import com.example.gemstudios.myufc_app.data.network.service.IRequestInterface;
import com.example.gemstudios.myufc_app.data.network.service.ServiceConnection;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by TAE on 13-Feb-18.
 */

public class AppApiHelper implements IApiHelper{

    private IRequestInterface iRequestInterface;


    public AppApiHelper() {
        iRequestInterface = ServiceConnection.getConnection();
    }


    @Override
    public Observable<List<OctagonGirl>> getOctagonGirl() {
        return iRequestInterface.getOctagonGirl();
    }

    public Observable<List<Medium>> getMedia()
    {
        return iRequestInterface.getMedia();
    }

    public Observable<List<Events>> getEvents()
    {
        return iRequestInterface.getEvents();
    }

    public Observable<List<EventsDetails>> getEventsDetails(int id){
        return iRequestInterface.getEventsDetails(id);
    }

    public Observable<List<News>> getNews() { return iRequestInterface.getNews();}

    public Observable<List<TitleHolders>> getTitleHolders() { return iRequestInterface.getTitleHolders();}

    public Observable<List<Fighters>> getFighters() { return iRequestInterface.getFighters();}
}
