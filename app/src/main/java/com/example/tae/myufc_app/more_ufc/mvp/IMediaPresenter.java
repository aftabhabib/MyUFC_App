package com.example.tae.myufc_app.more_ufc.mvp;

import com.example.tae.myufc_app.ui.base.MvpPresenter;

/**
 * Created by TAE on 06-Mar-18.
 */

public interface IMediaPresenter<V extends IMediaMvpView> extends MvpPresenter<V>{

    void loadMedia();

}
