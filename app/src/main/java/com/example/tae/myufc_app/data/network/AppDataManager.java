package com.example.tae.myufc_app.data.network;

import android.os.MessageQueue;

import com.example.tae.myflavoursapp.data.network.model.CharactersModel;
import com.example.tae.myflavoursapp.data.network.model.RelatedTopic;

import io.reactivex.Observable;

/**
 * Created by TAE on 13-Feb-18.
 */

public class AppDataManager implements DataManager {

    private IApiHelper iApiHelper;

    public AppDataManager() {
        iApiHelper = new AppApiHelper();   /** the class that implements the interface before  **/
    }

    @Override
    public Observable<CharactersModel> getCharactersList() {
        return iApiHelper.getCharactersList();
    }
}
