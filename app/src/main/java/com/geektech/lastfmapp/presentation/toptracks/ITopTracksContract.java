package com.geektech.lastfmapp.presentation.toptracks;

import com.geektech.lastfmapp.model.TrackEntity;


import java.util.List;

import core.ICoreMvpContract;

public interface ITopTracksContract {
    interface View extends ICoreMvpContract.View<Presenter> {

        void showTracks(List<TrackEntity> tracks);

        void openTrack(TrackEntity track);

        void showMessage(String message);

    }

    interface Presenter extends ICoreMvpContract.Presenter<View> {
        void getTracks();

        void onTrackClick(int position);

    }
}
