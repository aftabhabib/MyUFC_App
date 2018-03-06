package com.example.tae.myufc_app.octagon_girls;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tae.myufc_app.R;
import com.example.tae.myufc_app.data.network.AppDataManager;
import com.example.tae.myufc_app.data.network.model.OctagonGirl;
import com.example.tae.myufc_app.ui.base.BaseFragment;
import com.example.tae.myufc_app.ui.utils.rx.AppSchedulerProvider;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class OctagonGirlsDetailsTab_Fragment extends BaseFragment
        implements IOctagonGirlMvpView{

    private RecyclerView recyclerView;
    private OctagonGirlImpl<OctagonGirlsDetailsTab_Fragment> octagonGirlsDetailsTabpresenter;

    public OctagonGirlsDetailsTab_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        octagonGirlsDetailsTabpresenter = new OctagonGirlImpl<>(new AppDataManager(),
                new AppSchedulerProvider(), new CompositeDisposable());

        octagonGirlsDetailsTabpresenter.onAttach(this);

        SharedPreferences prefs = getActivity().getSharedPreferences("myPrefs", MODE_PRIVATE);
        String restoredText = prefs.getString("id", null);
        if (restoredText != null) {
            String name = prefs.getString("id", "No name defined"); //"No name defined" is the default value.
            int id = prefs.getInt("id", 0); //0 is the default value.

            Toast.makeText(getActivity(), "id: " + id, Toast.LENGTH_SHORT).show();
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_octagon_girls_details_tab_, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        int id = 6638;
       // octagonGirlsDetailsTabpresenter.loadOctagonGirlsDetails(id);

       }

    @Override
    public void onFetchDataProgress() {

    }

    @Override
    public void onFetchDataSuccess(List<OctagonGirl> octagonGirl) {

    }

    @Override
    public void onFetchDataError(String error) {

    }
}
