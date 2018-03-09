package com.example.tae.myufc_app.data.network;

import com.example.tae.myufc_app.data.network.model.Events;
import com.example.tae.myufc_app.data.network.model.Medium;
import com.example.tae.myufc_app.data.network.model.OctagonGirl;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by TAE on 13-Feb-18.
 */

public interface IApiHelper {

    Observable<List<OctagonGirl>> getOctagonGirl();

    Observable<List<Medium>> getMedia();

    Observable<List<Events>> getEvents();


   // Observable<OctagonGirl> getOctagonGirlDetail(int id);
}
