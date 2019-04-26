package com.geektech.lastfmapp.presentation.topartists;

import com.geektech.lastfmapp.model.ArtistEntity;


import java.util.List;

import core.ICoreMvpContract;

public interface ITopArtistsContract {
    interface View extends ICoreMvpContract.View<Presenter>  {
        void showArtists(List<ArtistEntity> artists);

        void openArtist(ArtistEntity artist);

        void showMessage(String message);

    }

    interface Presenter extends ICoreMvpContract.Presenter<View>  {

        void getArtists();

        void onArtistClick(int position);

    }
}
