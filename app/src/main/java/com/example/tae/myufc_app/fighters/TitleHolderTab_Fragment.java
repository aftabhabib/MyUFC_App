package com.example.tae.myufc_app.fighters;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tae.myufc_app.MainActivity;
import com.example.tae.myufc_app.R;
import com.example.tae.myufc_app.data.local.realm_database.controller.RealmHelper;
import com.example.tae.myufc_app.data.network.AppDataManager;
import com.example.tae.myufc_app.data.network.model.Fighters;
import com.example.tae.myufc_app.data.network.model.TitleHolders;
import com.example.tae.myufc_app.fighters.adapter.TitleHolder_Adapter;
import com.example.tae.myufc_app.fighters.adapter.TitleHolder_Adapter_Realm;
import com.example.tae.myufc_app.fighters.mvp.FightersImpl;
import com.example.tae.myufc_app.fighters.mvp.IFighterMvpView;
import com.example.tae.myufc_app.ui.base.BaseFragment;
import com.example.tae.myufc_app.ui.utils.rx.AppSchedulerProvider;
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork;

import java.util.List;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;

/**
 * A simple {@link Fragment} subclass.
 */
public class TitleHolderTab_Fragment extends BaseFragment
implements IFighterMvpView{

    private Realm realm;
    private static RealmHelper realmHelper;

    /**
     * adding bindview for recyclyerview
     */

    @BindView(R.id.recycler) RecyclerView recyclerView;
    private FightersImpl<TitleHolderTab_Fragment> titleHoldersPresenter;

    public TitleHolderTab_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        titleHoldersPresenter = new FightersImpl<>(new AppDataManager(), new AppSchedulerProvider(), new CompositeDisposable());


        titleHoldersPresenter.onAttach(this);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_title_holder_tab_, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

       // titleHoldersPresenter.loadTitleHolders();
        callService();
    }

    public void callService()
    {
        ReactiveNetwork.observeInternetConnectivity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean isConnectedToInternet) throws Exception {
                        if (isConnectedToInternet)
                        {
                            titleHoldersPresenter.loadTitleHolders();

                        }
                        else
                        {
                            AlertNetwork();

                        }
                    }
                });
    }

    public void AlertNetwork()
    {
        AlertDialog.Builder a_builder2 = new AlertDialog.Builder(getActivity());
        a_builder2.setMessage("There is no network connected.. Please make sure you are connected to the internet")
                .setCancelable(false)
                .setPositiveButton("Close the App", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        getActivity().finish();
                    }
                }).setNegativeButton("Continue using the App", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();


                if (MainActivity.getRealmDatabase().isEmpty())
                {
                    Toast.makeText(getActivity(), "No Realm backup found..", Toast.LENGTH_LONG).show();
                }
                else if (MainActivity.getRealmDatabase().size() > 0) {

                        recyclerView.setAdapter(new TitleHolder_Adapter_Realm(getActivity(), MainActivity.getRealmDatabase(), R.layout.titleholder_row));
                        Toast.makeText(getActivity(), "Loading from Realm Backup..", Toast.LENGTH_LONG).show();

                }

            }
        });

        AlertDialog alert = a_builder2.create();
        alert.setTitle("Defaulted to realm backup");
        alert.show();
    }


    private void DatabaseResults(List<TitleHolders> titleHolders) {
        for (TitleHolders resultDB : titleHolders) {
            MainActivity.saveRealm(
                    resultDB.getFirstName(),
                    resultDB.getWins(),
                    resultDB.getDraws(),
                    resultDB.getLosses()
            );
        }
    }

    @Override
    public void onFetchDataProgress() {

    }

    @Override
    public void onFetchDataSuccess(List<TitleHolders> titleHoldersList) {
        DatabaseResults(titleHoldersList);
        recyclerView.setAdapter(new TitleHolder_Adapter(getActivity().getApplicationContext(), titleHoldersList, R.layout.titleholder_row));


    }

    @Override
    public void onFetcDataError(String error) {

    }

    @Override
    public void onFetchDataSuccessFighters(List<Fighters> fighters) {

    }
}
