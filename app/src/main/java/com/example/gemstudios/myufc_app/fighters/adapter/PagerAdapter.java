package com.example.gemstudios.myufc_app.fighters.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.gemstudios.myufc_app.fighters.AllFightersTab_Fragment;
import com.example.gemstudios.myufc_app.fighters.TitleHolderTab_Fragment;


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
                TitleHolderTab_Fragment tab1 = new TitleHolderTab_Fragment();
                return tab1;
            case 1:
                AllFightersTab_Fragment tab2 = new AllFightersTab_Fragment();
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
