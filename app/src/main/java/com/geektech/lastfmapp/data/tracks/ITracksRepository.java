package com.geektech.lastfmapp.data.tracks;

import android.support.annotation.Nullable;

import com.geektech.core.CoreCallback;
import com.geektech.lastfmapp.entities.ArtistEntity;
import com.geektech.lastfmapp.entities.TrackEntity;

import java.util.List;

public interface ITracksRepository {

    @Nullable
    TrackEntity getTrack(String id);

    void getTracks(TracksCallback callback);

    void getTopTracksOfArtist(TracksCallback callback, ArtistEntity artist);

    interface TracksCallback extends CoreCallback<List<TrackEntity>> { }
}
