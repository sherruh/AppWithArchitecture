package com.geektech.lastfmapp.data.tracks.local;

import com.geektech.core.Logger;
import com.geektech.core.realm.CoreRealmDataSource;
import com.geektech.lastfmapp.data.tracks.ITracksRepository;
import com.geektech.lastfmapp.entities.TrackEntity;

import java.util.List;


import io.realm.Realm;
import io.realm.RealmResults;

public class TracksLocalStorage extends CoreRealmDataSource
        implements ITracksLocalStorage {

    private void getArtistTracks(String artistName, ITracksRepository.TracksCallback callback) {
        Realm realm = null;

        try {
            realm = getRealmInstance();

            //TODO: Search tracks by artistName
        } catch (Exception e) {
            Logger.e(e);
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

    @Override
    public void getTracks(ITracksRepository.TracksCallback callback) {
        Realm realm = getRealmInstance();

        RealmResults<RTrack> results = realm.where(RTrack.class).findAll();

        callback.onSuccess(
                TracksMapper.toTracks(realm.copyFromRealm(results))
        );

        realm.close();
    }

    @Override
    public void setTracks(List<TrackEntity> tracks) {
        executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                for (TrackEntity track : tracks) {
                    RTrack managedTrack = realm.where(RTrack.class)
                            .equalTo("Id", track.getId())
                            .findFirst();

                    if (managedTrack == null) {
                        realm.copyToRealm(TracksMapper.toRTrack(track));
                    } else {
                        managedTrack.setListeners(track.getListeners());
                        managedTrack.setPlaycount(track.getPlaycount());
                        managedTrack.setUrl(track.getUrl());
                    }
                }

            }
        });
    }

    @Override
    public TrackEntity getTrack(String id) {
        Realm realm = getRealmInstance();
        RTrack rTrack=realm.where(RTrack.class).equalTo("id",id).findFirst();

        return null;
    }
}
