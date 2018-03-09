package com.example.tae.myufc_app.data.network;

import com.example.tae.myufc_app.data.network.model.Events;
import com.example.tae.myufc_app.data.network.model.Medium;
import com.example.tae.myufc_app.data.network.model.OctagonGirl;
import com.example.tae.myufc_app.data.network.service.IRequestInterface;
import com.example.tae.myufc_app.data.network.service.ServiceConnection;

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

    //@Override
  //  public Observable<OctagonGirl> getOctagonGirlDetail(int id) {
   //     return iRequestInterface.getOctagonGirlDetail(id);
  //  }
}
