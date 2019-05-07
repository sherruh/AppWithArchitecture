package com.geektech.lastfmapp.presentation.track;

import com.geektech.core.mvp.CoreMvpPresenter;
import com.geektech.lastfmapp.entities.TrackEntity;

public class TrackPresenter extends CoreMvpPresenter<ITrackContract.View>
        implements ITrackContract.Presenter {
    @Override
    public void setTrack(TrackEntity trackEntity) {
        view.showTrackDetails(trackEntity);
    }
}
