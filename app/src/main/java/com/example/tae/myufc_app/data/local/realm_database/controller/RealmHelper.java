package com.example.tae.myufc_app.data.local.realm_database.controller;

import com.example.tae.myufc_app.data.local.realm_database.model.TitleHoldersRealm;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;


public class RealmHelper {

    private Realm realm;

    public RealmHelper(Realm realm) {
        this.realm = realm;
    }

    public void storeData(final TitleHoldersRealm titleHoldersRealm){
        if (titleHoldersRealm != null){
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.copyToRealm(titleHoldersRealm);
                }
            });
        }
    }

    public void deleteRealmData(){
        RealmResults<TitleHoldersRealm> realmResults = realm.where(TitleHoldersRealm.class).findAll();
        realmResults.deleteAllFromRealm();
    }

    public ArrayList<TitleHoldersRealm> getTitleHoldersDB(){
        ArrayList<TitleHoldersRealm> titleHoldersRealms = new ArrayList<>();

        RealmResults<TitleHoldersRealm> realmResults = realm.where(TitleHoldersRealm.class).findAll();
        for (TitleHoldersRealm online: realmResults) {
            titleHoldersRealms.add(online);
        }

        return titleHoldersRealms;
    }


}
