package com.example.tae.myufc_app.main_events.event_details;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.tae.myufc_app.MyApp;
import com.example.tae.myufc_app.R;

public class Event_Details_Main extends AppCompatActivity {

    FragmentManager fragmentManager;

    /**
     * this activity is to load the event details fragment
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_details_main);

        fragmentManager = getSupportFragmentManager();

        /**
         * adds the action support bar
         */
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

       EventDetailsFragment eventDetailsFragment = new EventDetailsFragment();

        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, eventDetailsFragment)
                .disallowAddToBackStack()
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

  }
