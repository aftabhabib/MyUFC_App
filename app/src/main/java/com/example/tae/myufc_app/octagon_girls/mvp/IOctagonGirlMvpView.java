package com.example.tae.myufc_app.octagon_girls.mvp;

import com.example.tae.myufc_app.data.network.model.OctagonGirl;
import com.example.tae.myufc_app.ui.base.MvpView;

import java.util.List;

/**
 * Created by TAE on 06-Mar-18.
 */

public interface IOctagonGirlMvpView extends MvpView {

    void onFetchDataProgress();
    void onFetchDataSuccess(List<OctagonGirl> octagonGirl);
    void onFetchDataError(String error);

}
