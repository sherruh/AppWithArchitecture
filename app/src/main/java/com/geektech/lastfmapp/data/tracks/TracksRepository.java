package com.geektech.lastfmapp.data.tracks;

import android.support.annotation.Nullable;

import com.geektech.lastfmapp.data.tracks.local.ITracksLocalStorage;
import com.geektech.lastfmapp.data.tracks.remote.ITracksRemoteStorage;
import com.geektech.lastfmapp.entities.TrackEntity;

import java.util.HashMap;
import java.util.List;

public class TracksRepository implements ITracksRepository {

    @Nullable
    private ITracksLocalStorage local;
    @Nullable
    private ITracksRemoteStorage remote;

    private HashMap<String, TrackEntity> mCache = new HashMap<>();

    private void setCache(List<TrackEntity> tracks) {
        if (local != null) {
            local.setTracks(tracks);
        }

        for(TrackEntity track : tracks) {
            mCache.put(track.getId(), track);
        }
    }

    public TracksRepository(
            @Nullable ITracksLocalStorage local,
            @Nullable ITracksRemoteStorage remote
    ) {
        this.local = local;
        this.remote = remote;
    }

    @Nullable
    @Override
    public TrackEntity getTrack(String id) {
        TrackEntity track = mCache.get(id);

        if (track == null && local != null) {
            track = local.getTrack();
        }

        return track;
    }

    @Override
    public void getTracks(final TracksCallback callback) {
        if (local != null) {
            local.getTracks(callback);
        }

        if (remote != null) {
            remote.getTracks(new TracksCallback() {
                @Override
                public void onSuccess(List<TrackEntity> tracks) {
                    for (TrackEntity track: tracks){
                        track.setId();
                    }
                    setCache(tracks);
                    local.setTracks(tracks);

                    callback.onSuccess(tracks);
                }

                @Override
                public void onFailure(String message) {
                    callback.onFailure(message);
                }
            });
        }
    }
}
