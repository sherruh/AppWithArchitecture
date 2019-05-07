package com.geektech.lastfmapp.data.artists;

import android.support.annotation.Nullable;

import com.geektech.lastfmapp.data.artists.local.ArtistsLocalStorage;
import com.geektech.lastfmapp.data.artists.remote.ArtistsRemoteStorage;
import com.geektech.lastfmapp.entities.ArtistEntity;

import java.util.List;

public class ArtistsRepository implements IArtistsRepository {

    private ArtistsLocalStorage local;
    private ArtistsRemoteStorage remote;

    public ArtistsRepository(ArtistsLocalStorage local, ArtistsRemoteStorage remote) {
        this.local = local;
        this.remote = remote;
    }

    @Nullable
    @Override
    public ArtistEntity getArtist(int id) {
        return null;
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
