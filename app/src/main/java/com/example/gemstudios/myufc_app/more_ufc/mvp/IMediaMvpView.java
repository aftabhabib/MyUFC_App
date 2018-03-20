package com.example.gemstudios.myufc_app.more_ufc.mvp;

import com.example.gemstudios.myufc_app.data.network.model.Medium;
import com.example.gemstudios.myufc_app.ui.base.MvpView;

import java.util.List;

/**
 * Created by TAE on 06-Mar-18.
 */

public interface IMediaMvpView extends MvpView {

    void onFetchDataProgress();
    void onFetchDataSuccess(List<Medium> media);
    void onFetchDataError(String error);

  //  @Override
  //  boolean isNetworkConnected();

  //  @Override
  //  void onError(int resId);
}
