package com.example.tae.myufc_app.main_events.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.tae.myufc_app.main_events.EventsTab_Fragment;
import com.example.tae.myufc_app.main_events.FightsTab_Fragment;
import com.example.tae.myufc_app.main_events.DetailsTab_Fragment;


public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public PagerAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                EventsTab_Fragment tab1 = new EventsTab_Fragment();
                return tab1;
            case 1:
                FightsTab_Fragment tab2 = new FightsTab_Fragment();
                return  tab2;
            case 2:
                DetailsTab_Fragment tab3 = new DetailsTab_Fragment();
                return  tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
