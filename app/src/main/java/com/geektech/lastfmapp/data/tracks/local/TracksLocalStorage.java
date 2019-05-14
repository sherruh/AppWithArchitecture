package com.geektech.lastfmapp.data.tracks.local;

import com.geektech.core.CoreRealmDataSource;
import com.geektech.lastfmapp.data.tracks.ITracksRepository;
import com.geektech.lastfmapp.entities.TrackEntity;

import java.util.ArrayList;
import java.util.List;

public class TracksLocalStorage extends CoreRealmDataSource
        implements ITracksLocalStorage {

    private List<RTrack> tracksToRTracks(List<TrackEntity> tracks){

        ArrayList<RTrack> result = new ArrayList<>();

        for (TrackEntity track:tracks){
            result.add(trackToRTrack(track));
        }

        return result;
    }

    private RTrack trackToRTrack(TrackEntity track){
        return null;
    }

    private List<TrackEntity> rtracksToTracks(List<RTrack> rTracks){

        ArrayList<TrackEntity> result = new ArrayList<>();

        for(RTrack rTrack:rTracks){

            result.add(rTrackToTrack(rTrack));

        }

        return result;

    }

    private TrackEntity rTrackToTrack(RTrack rTrack){
        return null;
    }

    @Override
    public void getTracks(ITracksRepository.TracksCallback callback) {
        //TODO: Fetch from DB
    }

    @Override
    public void setTracks(List<TrackEntity> tracks) {
        //TODO: Save to DBw
    }

    @Override
    public TrackEntity getTrack() {
        return null;
    }
}
