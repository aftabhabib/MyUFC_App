package com.example.tae.myufc_app.data.network.service;


import com.example.tae.myufc_app.data.network.model.OctagonGirl;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by TAE on 09-Feb-18.
 */

public interface IRequestInterface {


    /**
     * Octagon girls api
     */
    @GET(ApiList.OCTAGON_GIRLS)
    Observable<List<OctagonGirl>> getOctagonGirl();

   // @GET(ApiList.OCTAGON_GIRL_DETAIL)
  //  Observable<OctagonGirl> getOctagonGirlDetail(@Path("id") int id);

}