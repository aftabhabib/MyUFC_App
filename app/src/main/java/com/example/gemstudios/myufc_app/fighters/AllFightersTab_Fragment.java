package com.example.gemstudios.myufc_app.fighters;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gemstudios.myufc_app.MyApp;
import com.example.gemstudios.myufc_app.R;
import com.example.gemstudios.myufc_app.data.network.AppDataManager;
import com.example.gemstudios.myufc_app.data.network.model.Fighters;
import com.example.gemstudios.myufc_app.data.network.model.TitleHolders;
import com.example.gemstudios.myufc_app.fighters.adapter.Fighters_Adapter;
import com.example.gemstudios.myufc_app.fighters.mvp.FightersImpl;
import com.example.gemstudios.myufc_app.fighters.mvp.IFighterMvpView;
import com.example.gemstudios.myufc_app.ui.base.BaseFragment;
import com.example.gemstudios.myufc_app.ui.utils.rx.AppSchedulerProvider;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.disposables.CompositeDisposable;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllFightersTab_Fragment extends BaseFragment
implements IFighterMvpView {

    /**
     * adding bindview for recyclyerview
     */
    @BindView(R.id.recycler) RecyclerView recyclerView;

    private FightersImpl<AllFightersTab_Fragment> fightersPresenter;
    Fighters_Adapter fighters_adapter;
    List<Fighters> fightersList;

    private AdView mAdView;
    private AdRequest adRequest;


    public AllFightersTab_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fightersPresenter = new FightersImpl<>(new AppDataManager(), new AppSchedulerProvider(),
                new CompositeDisposable());

        fightersPresenter.onAttach(this);

        setHasOptionsMenu(true);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_fighters_tab_, container, false);

          }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /**
         * setting layout for the recycler view
         * creating the request to irequest interface
         */

        MobileAds.initialize(MyApp.getInstance().getAppContext(), "ca-app-pub-0870153753180861~4982064606");

        mAdView = view.findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        fightersPresenter.loadFighters();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if ((newText != null) && (!newText.isEmpty())) {
                    newText = newText.toLowerCase();

                        List<Fighters> filteredModelList = filter(fightersList, newText);
                        if (filteredModelList.size() >0) {
                            List<Fighters> filtersTest = filteredModelList;
                            //Toast.makeText(getActivity().getApplicationContext(), "" + filteredModelList.get(0).getFirstName(), Toast.LENGTH_LONG).show();
                          //  fighters_adapter.setSearchResult(filtersTest);
                            recyclerView.setAdapter(new Fighters_Adapter(getActivity().getApplicationContext(), R.layout.fighters_row,filtersTest));

                        }
                        else
                        {
                            Toast.makeText(getActivity().getApplicationContext(), "empty list", Toast.LENGTH_LONG).show();
                        }
                    }
                return true;
            }
        });
    }

    public List<Fighters> filter(List<Fighters> fightersList, String query)
    {

        query = query.toLowerCase();
        List<Fighters> filteredModeList = new ArrayList<>();
        for (Fighters fighters : fightersList)
        {
            String text = fighters.getFirstName().toLowerCase();
            if (text.contains(query)) {
                filteredModeList.add(fighters);
            }

            else
            {
               // Toast.makeText(getActivity().getApplicationContext(), "No results found!", Toast.LENGTH_LONG).show();
            }
        }
        return filteredModeList;
    }


    @Override
    public void onFetchDataSuccessFighters(List<Fighters> fighters) {
        this.fightersList = fighters;
        recyclerView.setAdapter(new Fighters_Adapter(getActivity().getApplicationContext(), R.layout.fighters_row,fighters));
    }


    @Override
    public void onFetchDataProgress() {

    }

    @Override
    public void onFetchDataSuccess(List<TitleHolders> titleHoldersList) {


    }

    @Override
    public void onFetcDataError(String error) {

    }


}
