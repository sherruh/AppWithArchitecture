package com.geektech.lastfmapp.presentation.artist;

import com.geektech.lastfmapp.model.ArtistEntity;
import com.geektech.lastfmapp.model.TrackEntity;
import com.geektech.lastfmapp.presentation.basecontracts.BasePresenter;
import com.geektech.lastfmapp.presentation.basecontracts.BaseView;

public interface ArtistContract {

    interface View extends BaseView {

        void showArtistInfo(ArtistEntity artist);

    }

    interface Presenter extends BasePresenter {

        void getArtist();

        void onClick();

    }
}
