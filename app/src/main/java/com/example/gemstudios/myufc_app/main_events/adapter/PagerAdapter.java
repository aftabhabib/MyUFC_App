package com.example.gemstudios.myufc_app.main_events.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.gemstudios.myufc_app.main_events.EventsTab_Fragment;
import com.example.gemstudios.myufc_app.main_events.news_feed_tab.NewsTab_Fragment;


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
                NewsTab_Fragment tab1 = new NewsTab_Fragment();
                return tab1;
            case 1:
                 EventsTab_Fragment tab2 = new EventsTab_Fragment();
                return  tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
