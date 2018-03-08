package com.example.tae.myufc_app.octagon_girls.mvp;

import com.example.tae.myufc_app.ui.base.MvpPresenter;

/**
 * Created by TAE on 06-Mar-18.
 */

public interface IOctagonGirlPresenter <V extends IOctagonGirlMvpView> extends MvpPresenter<V>{

    void loadOctagonGirls();

}
