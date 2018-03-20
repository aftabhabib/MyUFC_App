package com.example.gemstudios.myufc_app.more_ufc.mvp;

import com.example.gemstudios.myufc_app.data.network.DataManager;
import com.example.gemstudios.myufc_app.data.network.model.Medium;
import com.example.gemstudios.myufc_app.ui.base.BasePresenter;
import com.example.gemstudios.myufc_app.ui.utils.rx.SchedulerProvider;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by TAE on 06-Mar-18.
 */

public class MediaImpl<V extends IMediaMvpView>
extends BasePresenter<V>
implements IMediaPresenter<V> {


    public MediaImpl(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    public void loadMedia() {

        getCompositeDisposable()
                .add(getDataManager().getMedia()
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(new Consumer<List<Medium>>() {
                            @Override
                            public void accept(List<Medium> media) throws Exception {
                                getMvpView().onFetchDataSuccess(media);
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                            }
                        }));

    }
}
