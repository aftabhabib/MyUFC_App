package com.example.tae.myufc_app.data.network;

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

    //@Override
  //  public Observable<OctagonGirl> getOctagonGirlDetail(int id) {
   //     return iRequestInterface.getOctagonGirlDetail(id);
  //  }
}
