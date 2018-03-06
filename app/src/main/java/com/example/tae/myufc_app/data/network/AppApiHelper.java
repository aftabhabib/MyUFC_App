package com.example.tae.myufc_app.data.network;


import com.example.tae.myflavoursapp.data.network.model.CharactersModel;
import com.example.tae.myflavoursapp.data.network.service.IRequestInterface;
import com.example.tae.myflavoursapp.data.network.service.ServiceConnection;

import io.reactivex.Observable;

/**
 * Created by TAE on 13-Feb-18.
 */

public class AppApiHelper implements IApiHelper {

    private IRequestInterface iRequestInterface;

    public AppApiHelper(){
        iRequestInterface = ServiceConnection.getConnection();
    }

    @Override
    public Observable<CharactersModel> getCharactersList() {
        return iRequestInterface.getCharacters();
    }
}
