package com.geektech.lastfmapp.presentation.toptracks;

import com.geektech.lastfmapp.model.TrackEntity;
import com.geektech.lastfmapp.presentation.basecontracts.BasePresenter;
import com.geektech.lastfmapp.presentation.basecontracts.BaseView;

import java.util.List;

public interface TopTracksContract {
    interface View extends BaseView {

        void showTracks(List<TrackEntity> tracks);

        void openTrack(TrackEntity track);

        void showMessage(String message);

    }

    interface Presenter extends BasePresenter {
        void getTracks();

        void onTrackClick(int position);

    }
}
