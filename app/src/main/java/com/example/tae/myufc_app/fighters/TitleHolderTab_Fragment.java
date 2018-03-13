package com.example.tae.myufc_app.fighters;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tae.myufc_app.R;
import com.example.tae.myufc_app.data.network.AppDataManager;
import com.example.tae.myufc_app.data.network.model.TitleHolders;
import com.example.tae.myufc_app.fighters.adapter.TitleHolder_Adapter;
import com.example.tae.myufc_app.fighters.mvp.FightersImpl;
import com.example.tae.myufc_app.fighters.mvp.IFighterMvpView;
import com.example.tae.myufc_app.ui.base.BaseFragment;
import com.example.tae.myufc_app.ui.utils.rx.AppSchedulerProvider;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

/**
 * A simple {@link Fragment} subclass.
 */
public class TitleHolderTab_Fragment extends BaseFragment
implements IFighterMvpView{

    private RecyclerView recyclerView;
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

        titleHoldersPresenter.loadTitleHolders();
    }

    @Override
    public void onFetchDataProgress() {

    }

    @Override
    public void onFetchDataSuccess(List<TitleHolders> titleHoldersList) {

        recyclerView.setAdapter(new TitleHolder_Adapter(getActivity().getApplicationContext(), titleHoldersList, R.layout.titleholder_row));
    }

    @Override
    public void onFetcDataError(String error) {

    }
}
