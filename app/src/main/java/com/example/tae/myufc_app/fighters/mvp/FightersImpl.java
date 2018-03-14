package com.example.tae.myufc_app.fighters.mvp;

import android.widget.Toast;

import com.example.tae.myufc_app.MyApp;
import com.example.tae.myufc_app.data.network.DataManager;
import com.example.tae.myufc_app.data.network.model.Fighters;
import com.example.tae.myufc_app.data.network.model.TitleHolders;
import com.example.tae.myufc_app.ui.base.BasePresenter;
import com.example.tae.myufc_app.ui.base.MvpView;
import com.example.tae.myufc_app.ui.utils.rx.SchedulerProvider;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by TAE on 13-Mar-18.
 */

public class FightersImpl <V extends IFighterMvpView>
extends BasePresenter<V>
implements IFighterPresenter<V>{

    public FightersImpl(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void loadTitleHolders() {

        getCompositeDisposable()
                .add(getDataManager().getTitleHolders()
                .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(new Consumer<List<TitleHolders>>() {
                            @Override
                            public void accept(List<TitleHolders> titleHolders) throws Exception {
                                getMvpView().onFetchDataSuccess(titleHolders);
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                            }
                        }));
    }

    public void loadFighters()
    {
        getCompositeDisposable()
                .add(getDataManager().getFighters()
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(new Consumer<List<Fighters>>() {
                            @Override
                            public void accept(List<Fighters> fighters) throws Exception {
                                getMvpView().onFetchDataSuccessFighters(fighters);
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                getMvpView().onFetcDataError(throwable.getMessage());
                                Toast.makeText(MyApp.getInstance(), "disconnected", Toast.LENGTH_SHORT).show();
                            }
                        }));
    }
}
