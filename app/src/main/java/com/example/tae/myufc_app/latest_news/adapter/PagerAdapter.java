package com.example.tae.myufc_app.latest_news.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.tae.myufc_app.latest_news.NewsTabDetails_Fragment;
import com.example.tae.myufc_app.latest_news.NewsTab_Fragment;


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
                NewsTabDetails_Fragment tab2 = new NewsTabDetails_Fragment();
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
