package com.geektech.lastfmapp.presentation.toptracks;

import com.geektech.lastfmapp.model.TrackEntity;
import com.geektech.lastfmapp.presentation.topartists.ITopArtistsContract;


import java.util.ArrayList;

import core.CorePresenter;

public class TopTracksPresenter extends CorePresenter implements ITopTracksContract.Presenter {

    ArrayList<TrackEntity> trackEntities;

    @Override
    public void getTracks() {
        //TODO: Get tracks from Repository
         trackEntities= new ArrayList<>();

        trackEntities.add(new TrackEntity(1, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(2, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(3, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(4, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(5, "name", "artist", "image"));

    }

    @Override
    public void onTrackClick(int position) {

    }

    @Override
    public void attachView(ITopTracksContract.View view) {
        mView = view;
        ((ITopTracksContract.View) mView).showTracks(trackEntities);
        mView.attachPresenter(this);

    }

    @Override
    public void detachView() {
        mView = null;
    }
}
