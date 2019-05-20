package com.geektech.lastfmapp.data.artists.local;

import com.geektech.core.realm.CoreRealmDataSource;
import com.geektech.lastfmapp.data.artists.IArtistsRepository;
import com.geektech.lastfmapp.data.tracks.local.RTrack;
import com.geektech.lastfmapp.entities.ArtistEntity;
import com.geektech.lastfmapp.entities.TrackEntity;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class ArtistsLocalStorage extends CoreRealmDataSource implements IArtistsLocalStorage {
    @Override
    public void getArtists(IArtistsRepository.ArtistsCallback callback) {
        Realm realm = getRealmInstance();

        RealmResults<RArtist> artists=realm.where(RArtist.class).findAll();

        callback.onSuccess(ArtistsMapper.toArtists(artists));

        realm.close();
    }

    @Override
    public void setArtists(List<ArtistEntity> artists) {
        executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                for (ArtistEntity artist : artists) {
                    RArtist managedArtist = realm.where(RArtist.class)
                            .equalTo("name", artist.getName())
                            .findFirst();

                    if (managedArtist == null) {
                        realm.copyToRealm(ArtistsMapper.artistToRArtist(artist));
                    } else {
                        managedArtist.setListeners(artist.getListeners());
                        managedArtist.setUrl(artist.getUrl());
                        managedArtist.setListeners(artist.getListeners());
                    }
                }
            }
        });
    }

    @Override
    public ArtistEntity getArtist(String name) {
        Realm realm = getRealmInstance();
        RArtist artist = realm.where(RArtist.class).equalTo("name",name).findFirst();
        realm.close();
        return ArtistsMapper.rArtistToArtist(artist);
    }


}
