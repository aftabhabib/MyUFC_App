package com.example.tae.myufc_app.more_ufc.mvp;

import com.example.tae.myufc_app.data.network.model.Medium;
import com.example.tae.myufc_app.data.network.model.OctagonGirl;
import com.example.tae.myufc_app.ui.base.MvpView;

import java.util.List;

/**
 * Created by TAE on 06-Mar-18.
 */

public interface IMediaMvpView extends MvpView {

    void onFetchDataProgress();
    void onFetchDataSuccess(List<Medium> media);
    void onFetchDataError(String error);

}
