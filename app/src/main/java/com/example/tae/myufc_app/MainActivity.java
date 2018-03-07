package com.example.tae.myufc_app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
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
import com.example.tae.myufc_app.octagon_girls.OctagonGirlsDetailsTab_Fragment;
import com.example.tae.myufc_app.octagon_girls.OctagonGirlsFragment;
import com.example.tae.myufc_app.octagon_girls.OctagonGirlsTab_Fragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, EventsTab_Fragment.OnFragmentInteractionListener,
        FightsTab_Fragment.OnFragmentInteractionListener,
        DetailsTab_Fragment.OnFragmentInteractionListener {

    Bundle savedInstanceState;
    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentManager = getSupportFragmentManager();

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
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
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
        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, new LatestNewsFragment())
                    .disallowAddToBackStack()
                    .commit();
        }
    }

    public void loadFighterFragment() {
        if (savedInstanceState != null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, new FighterFragment())
                    .disallowAddToBackStack()
                    .commit();
        }
    }

    public void loadMainEventsFragment() {
        if (savedInstanceState == null) {

            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, new MainEventsFragment())
                    .disallowAddToBackStack()
                    .commit();
        }
    }

    public void loadLiveStreamFragment() {
        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, new LiveStreamFragment())
                    .disallowAddToBackStack()
                    .commit();
        }
    }

    public void loadMoreUFCFragment() {
        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, new MoreUFCFragment())
                    .disallowAddToBackStack()
                    .commit();
        }
    }

    public void loadOctagonGirlsFragment() {
        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, new OctagonGirlsFragment())
                    .disallowAddToBackStack()
                    //.addToBackStack()
                    .commit();
        }
    }


    public void buyTicketsIntent() {
        String url = "http://m.uk.ufc.com/tickets";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public static void OctagonGirlID(int id, Context context) {

        //Toast.makeText(context, "clicked: " + id, Toast.LENGTH_SHORT).show();

        OctagonGirlsFragment octagonGirlsFragment = new OctagonGirlsFragment();

        Bundle bundle = new Bundle();
        bundle.putInt("id", id);

        octagonGirlsFragment.setArguments(bundle);

        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, octagonGirlsFragment)
                .addToBackStack(null)
                .commit();

          }
}
