package com.geektech.lastfmapp.data.artists;

import android.support.annotation.Nullable;

import com.geektech.core.Logger;
import com.geektech.lastfmapp.data.artists.local.ArtistsLocalStorage;
import com.geektech.lastfmapp.data.artists.remote.ArtistsRemoteStorage;
import com.geektech.lastfmapp.entities.ArtistEntity;
import com.geektech.lastfmapp.entities.TrackEntity;

import java.util.HashMap;
import java.util.List;

public class ArtistsRepository implements IArtistsRepository {

    private ArtistsLocalStorage local;
    private ArtistsRemoteStorage remote;

    public ArtistsRepository(ArtistsLocalStorage local, ArtistsRemoteStorage remote) {
        this.local = local;
        this.remote = remote;
    }

    private HashMap<String, ArtistEntity> mCache = new HashMap<>();

    private void setCache(List<ArtistEntity> artists) {
        if (local != null) {
            local.setArtists(artists);
        }

        for(ArtistEntity artist : artists) {
            mCache.put(artist.getId(), artist);
        }
    }

    @Nullable
    @Override
    public ArtistEntity getArtist(String id) {

        ArtistEntity artist = mCache.get(id);
        Logger.d(artist.getName());

        if (artist == null && local != null){
            local.getArtist();
        }

        return artist;
    }

    @Override
    public void getArtists(ArtistsCallback callback) {
        if (local!=null) local.getArtists(callback);
        if (remote!=null){
            remote.getArtists(new ArtistsCallback() {
                @Override
                public void onSuccess(List<ArtistEntity> artists) {
                    for (ArtistEntity artist:artists){
                        artist.setId();
                    }
                    setCache(artists);
                    local.setArtists(artists);

                    callback.onSuccess(artists);
                }

                @Override
                public void onFailure(String message) {
                    callback.onFailure(message);
                }
            });
        }
    }
}
