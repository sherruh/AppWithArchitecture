package com.geektech.lastfmapp.data.artists;

import android.support.annotation.Nullable;

import com.geektech.core.CoreCallback;
import com.geektech.lastfmapp.data.tracks.ITracksRepository;
import com.geektech.lastfmapp.entities.ArtistEntity;
import com.geektech.lastfmapp.entities.TrackEntity;

import java.util.List;

public interface IArtistsRepository {
    @Nullable
    ArtistEntity getArtist(int id);

    void getArtists(ArtistsCallback callback);

    interface ArtistsCallback extends CoreCallback<List<ArtistEntity>> { }
}
