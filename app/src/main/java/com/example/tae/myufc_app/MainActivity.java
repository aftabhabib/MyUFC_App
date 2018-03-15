package com.example.tae.myufc_app;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.tae.myufc_app.data.local.realm_database.controller.RealmHelper;
import com.example.tae.myufc_app.data.local.realm_database.model.TitleHoldersRealm;
import com.example.tae.myufc_app.fighters.FighterFragment;
import com.example.tae.myufc_app.buy_tickets.buy_tickets_activity;
import com.example.tae.myufc_app.fighters.adapter.TitleHolder_Adapter_Realm;
import com.example.tae.myufc_app.live_stream.live_stream_activity;
import com.example.tae.myufc_app.main_events.MainEventsFragment;
import com.example.tae.myufc_app.more_ufc.MoreUFCFragment;
import com.example.tae.myufc_app.octagon_girls.octagon_girls_tab.OctagonGirlsFragment;
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    /**
     * main activity for the app
     * responsible for the nav and opening fragments
     */
    static Bundle savedInstanceState;
    private static FragmentManager fragmentManager;

    private Realm realm;
    private static RealmHelper realmHelper;

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

       // loadMainEventsFragment();
        callService();

        /**
         * realm database init
         */

        initRealm();
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

    /**
     * creating a realm object and creating calls for realm
    *
     */

    private void initRealm(){
        realm = Realm.getDefaultInstance();
        realmHelper = new RealmHelper(realm);
    }

    public static ArrayList<TitleHoldersRealm> getRealmDatabase(){
        Log.i("realm db", String.valueOf(realmHelper.getTitleHoldersDB().size()));
        return realmHelper.getTitleHoldersDB();
    }

    public static void deleteRealmDatabase(){
        realmHelper.deleteRealmData();
    }

    public static void saveRealm (String name, int wins, int draws, int losses){
        TitleHoldersRealm titleHoldersRealm = new TitleHoldersRealm(name, wins, draws, losses);
        realmHelper.storeData(titleHoldersRealm);
        Log.i("realm database", String.valueOf(realmHelper.getTitleHoldersDB().size()));
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

    public void callService()
    {
        ReactiveNetwork.observeInternetConnectivity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean isConnectedToInternet) throws Exception {
                        if (isConnectedToInternet)
                        {
                            loadMainEventsFragment();

                        }
                        else
                        {
                            AlertNetwork();

                        }
                    }
                });
    }

    public void AlertNetwork()
    {
        AlertDialog.Builder a_builder = new AlertDialog.Builder(MyApp.getInstance());
        a_builder.setMessage("There is no network connected.. Please make sure you are connected to the internet")
                .setCancelable(false)
                .setPositiveButton("Close the App", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).setNegativeButton("Continue using the App with cached data", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                Toast.makeText(MyApp.getInstance(), "Loading from cache storage..", Toast.LENGTH_LONG).show();

            }
        });

        AlertDialog alert = a_builder.create();
        alert.setTitle("Connection status");
        alert.show();
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

            Intent intent = new Intent(MyApp.getInstance().getAppContext(), live_stream_activity.class);
            MyApp.getInstance().getAppContext().startActivity(intent);
        }
    }

    public static void loadMoreUFCFragment() {
       // if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, new MoreUFCFragment())
                    .addToBackStack(null)
                    .commit();
       // }
    }

    public void loadOctagonGirlsFragment() {

        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, new OctagonGirlsFragment())
                    .addToBackStack(null)
                    .commit();
        }
    }

      public void buyTicketsIntent() {

          Intent intent = new Intent(MyApp.getInstance().getAppContext(), buy_tickets_activity.class);
          MyApp.getInstance().getAppContext().startActivity(intent);
    }


}
