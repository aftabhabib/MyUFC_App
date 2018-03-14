package com.example.tae.myufc_app.fighters.mvp;

import com.example.tae.myufc_app.data.network.model.Fighters;
import com.example.tae.myufc_app.data.network.model.TitleHolders;
import com.example.tae.myufc_app.ui.base.MvpView;

import java.util.List;

/**
 * Created by TAE on 13-Mar-18.
 */

public interface IFighterMvpView extends MvpView {

    void onFetchDataProgress();
    void onFetchDataSuccess(List<TitleHolders> titleHoldersList);
    void onFetcDataError(String error);

    void onFetchDataSuccessFighters(List<Fighters> fighters);

}
