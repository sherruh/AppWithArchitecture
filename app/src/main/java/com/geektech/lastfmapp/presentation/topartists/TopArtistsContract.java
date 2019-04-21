package com.geektech.lastfmapp.presentation.topartists;

import com.geektech.lastfmapp.model.ArtistEntity;
import com.geektech.lastfmapp.presentation.basecontracts.BasePresenter;
import com.geektech.lastfmapp.presentation.basecontracts.BaseView;

import java.util.List;

public interface TopArtistsContract {
    interface View extends BaseView {
        void showArtists(List<ArtistEntity> artists);

        void openArtist(ArtistEntity artist);

        void showMessage(String message);

    }

    interface Presenter extends BasePresenter {

        void getArtists();

        void onArtistClick(int position);

    }
}
