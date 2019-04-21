package com.geektech.lastfmapp.presentation.track;

import com.geektech.lastfmapp.model.TrackEntity;
import com.geektech.lastfmapp.presentation.basecontracts.BasePresenter;
import com.geektech.lastfmapp.presentation.basecontracts.BaseView;

public interface TrackContract {

    interface View extends BaseView {

        void showTrackInfo(TrackEntity track);

    }

    interface Presenter extends BasePresenter {

        void getTrack();

        void onClickPlay();

    }
}
