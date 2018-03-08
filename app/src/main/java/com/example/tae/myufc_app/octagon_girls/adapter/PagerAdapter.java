package com.example.tae.myufc_app.octagon_girls.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.tae.myufc_app.octagon_girls.OctagonGirlsGalleryTab_Fragment;
import com.example.tae.myufc_app.octagon_girls.OctagonGirlsTab_Fragment;


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
                OctagonGirlsTab_Fragment tab1 = new OctagonGirlsTab_Fragment();
                return  tab1;
            case 1:
                OctagonGirlsGalleryTab_Fragment tab2 = new OctagonGirlsGalleryTab_Fragment();
                return tab2;

            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
