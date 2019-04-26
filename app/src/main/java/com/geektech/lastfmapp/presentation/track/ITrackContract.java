package com.geektech.lastfmapp.presentation.track;

import com.geektech.lastfmapp.model.TrackEntity;


import core.ICoreMvpContract;

public interface ITrackContract {

    interface View extends ICoreMvpContract.View<Presenter> {

        void showTrackInfo(TrackEntity track);

    }

    interface Presenter extends ICoreMvpContract.Presenter<View> {

        void getTrack();

        void onClickPlay();

    }
}
