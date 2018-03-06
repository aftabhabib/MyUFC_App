package com.example.tae.myufc_app.data.network;

import com.example.tae.myflavoursapp.data.network.model.CharactersModel;
import com.example.tae.myflavoursapp.data.network.model.RelatedTopic;

import io.reactivex.Observable;

/**
 * Created by TAE on 13-Feb-18.
 */

public interface IApiHelper {

    Observable<CharactersModel> getCharactersList();

}
