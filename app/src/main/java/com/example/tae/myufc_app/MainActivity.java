package com.example.tae.myufc_app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NavUtils;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.tae.myufc_app.fighters.FighterFragment;
import com.example.tae.myufc_app.latest_news.LatestNewsFragment;
import com.example.tae.myufc_app.live_stream.LiveStreamFragment;
import com.example.tae.myufc_app.main_events.EventsTab_Fragment;
import com.example.tae.myufc_app.main_events.FightsTab_Fragment;
import com.example.tae.myufc_app.main_events.MainEventsFragment;
import com.example.tae.myufc_app.main_events.DetailsTab_Fragment;
import com.example.tae.myufc_app.more_ufc.MoreUFCFragment;
import com.example.tae.myufc_app.octagon_girls.OctagonGirlsDetails_Fragment;
import com.example.tae.myufc_app.octagon_girls.OctagonGirlsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Bundle savedInstanceState;
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
      //  if (getFragmentManager().getBackStackEntryCount() == 0) {
      //      this.finish();
      //  } else {
      //      super.onBackPressed();
      //  }
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

   // @Override
  //  public boolean onOptionsItemSelected(MenuItem item) {
    //    switch (item.getItemId()) {
    //        case R.id.action_settings:
    //          Toast.makeText(getApplication(), "efwf", Toast.LENGTH_SHORT).show();
    //         finish();
    //            return true;
    //    }
    //    return super.onOptionsItemSelected(item);
   // }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.itm_events) {
            loadMainEventsFragment();
        }

        if (id == R.id.itm_latest_news) {
            loadLatestNewsFragment();
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadLatestNewsFragment() {
      //  if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, new LatestNewsFragment())
                    .addToBackStack(null)
                    .commit();
      //  }
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
      //  if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, new LiveStreamFragment())
                    .addToBackStack(null)
                    .commit();
       // }
    }

    public void loadMoreUFCFragment() {
      //  if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, new MoreUFCFragment())
                    .addToBackStack(null)
                    .commit();
       // }
    }

    public void loadOctagonGirlsFragment() {
       // if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, new OctagonGirlsFragment())
                    .addToBackStack(null)
                    //.addToBackStack()
                    .commit();
        //}
    }

    public static void loadOctagonGirlsDetailsFragment() {
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, new OctagonGirlsDetails_Fragment())
                .addToBackStack(null)
                .commit();
    }


    public void buyTicketsIntent() {
        String url = "http://m.uk.ufc.com/tickets";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }


}
