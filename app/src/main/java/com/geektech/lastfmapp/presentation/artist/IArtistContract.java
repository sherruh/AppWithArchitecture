package com.geektech.lastfmapp.presentation.artist;

import com.geektech.lastfmapp.model.ArtistEntity;

import core.ICoreMvpContract;

public interface IArtistContract {

    interface View extends ICoreMvpContract.View<Presenter> {

        void showArtistInfo(ArtistEntity artist);

    }

    interface Presenter extends ICoreMvpContract.Presenter<View> {

        void getArtist();

        void onClick();

    }
}
