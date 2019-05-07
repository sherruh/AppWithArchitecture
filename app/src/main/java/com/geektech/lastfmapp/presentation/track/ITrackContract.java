package com.geektech.lastfmapp.presentation.track;

import com.geektech.core.mvp.ICoreMvpContract;
import com.geektech.lastfmapp.entities.ArtistEntity;
import com.geektech.lastfmapp.entities.TrackEntity;

public interface ITrackContract {
    interface View extends ICoreMvpContract.View<Presenter> {
        void showTrackDetails(TrackEntity trackEntity);
    }

    interface Presenter extends ICoreMvpContract.Presenter<View> {
        void setTrack(TrackEntity trackEntity);
    }
}
