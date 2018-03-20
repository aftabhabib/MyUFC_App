package com.example.gemstudios.myufc_app.fighters.mvp;

import com.example.gemstudios.myufc_app.ui.base.MvpPresenter;

/**
 * Created by TAE on 13-Mar-18.
 */

public interface IFighterPresenter <V extends IFighterMvpView> extends MvpPresenter<V> {

    void loadTitleHolders();
}
