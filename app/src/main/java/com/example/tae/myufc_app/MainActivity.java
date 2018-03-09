package com.example.tae.myufc_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.tae.myufc_app.fighters.FighterFragment;
import com.example.tae.myufc_app.main_events.MainEventsFragment;
import com.example.tae.myufc_app.more_ufc.MoreUFCFragment;
import com.example.tae.myufc_app.octagon_girls.OctagonGirlsDetails_Fragment;
import com.example.tae.myufc_app.octagon_girls.OctagonGirlsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    static Bundle savedInstanceState;
    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentManager = getSupportFragmentManager();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        loadMainEventsFragment();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
            {
            super.onBackPressed();
        }
            if (getFragmentManager().getBackStackEntryCount() == 0) {
                super.onBackPressed();
            }
            else {
                getFragmentManager().popBackStack();
            }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                }
        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.itm_events) {
            loadMainEventsFragment();
        }

        if (id == R.id.itm_watch_live) {
            loadLiveStreamFragment();
        }
        if (id == R.id.itm_fighters) {
            loadFighterFragment();
        }

        if (id == R.id.itm_buytickets) {
            buyTicketsIntent();
        }

        if (id == R.id.itm_media) {
            loadMoreUFCFragment();
        }

        if (id == R.id.itm_OctagonGirls) {
            loadOctagonGirlsFragment();
        }

        Fragment switchTo = null;

        if (switchTo!=null)
        {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragmentContainer, switchTo);
            for (int i= 0; i< getSupportFragmentManager().getBackStackEntryCount(); ++i)
            {
                getSupportFragmentManager().popBackStackImmediate();
            }
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void loadFighterFragment() {
     //   if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, new FighterFragment())
                    .disallowAddToBackStack()
                    .commit();
       // }
    }

    public void loadMainEventsFragment() {
    //    if (savedInstanceState == null) {

            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, new MainEventsFragment())
                    .addToBackStack(null)
                    .commit();
       // }
    }

    public void loadLiveStreamFragment() {
        if (savedInstanceState == null) {

            String url = "http://ufc-data-api.ufc.com/api/v3/iphone/live";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    }

    public void loadMoreUFCFragment() {
        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, new MoreUFCFragment())
                    .addToBackStack(null)
                    .commit();
        }
    }

    public void loadOctagonGirlsFragment() {

        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, new OctagonGirlsFragment())
                    .addToBackStack("octgirlsfrag")
                    .commit();
        }
    }

    public static void loadOctagonGirlsDetailsFragment() {

        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, new OctagonGirlsDetails_Fragment())
                    .addToBackStack("octgirlsdetails")
                    .commit();
        }

    }

    public void buyTicketsIntent() {
        String url = "http://m.uk.ufc.com/tickets";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }


}
