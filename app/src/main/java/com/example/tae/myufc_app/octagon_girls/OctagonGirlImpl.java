package com.example.tae.myufc_app.octagon_girls;

import android.util.Log;

import com.example.tae.myufc_app.data.network.DataManager;
import com.example.tae.myufc_app.data.network.model.OctagonGirl;
import com.example.tae.myufc_app.ui.base.BasePresenter;
import com.example.tae.myufc_app.ui.utils.rx.SchedulerProvider;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by TAE on 06-Mar-18.
 */

public class OctagonGirlImpl <V extends IOctagonGirlMvpView>
extends BasePresenter<V>
implements IOctagonGirlPresenter<V> {


    public OctagonGirlImpl(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    public void loadOctagonGirls() {

        getCompositeDisposable()
                .add(getDataManager().getOctagonGirl()
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(new Consumer<List<OctagonGirl>>() {
                            @Override
                            public void accept(List<OctagonGirl> octagonGirls) throws Exception {
                                getMvpView().onFetchDataSuccess(octagonGirls);
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                            }
                        }));
    }
}
