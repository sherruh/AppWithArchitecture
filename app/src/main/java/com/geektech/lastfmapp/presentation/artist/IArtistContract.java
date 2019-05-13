package com.geektech.lastfmapp.presentation.artist;

import com.geektech.core.mvp.ICoreMvpContract;
import com.geektech.lastfmapp.entities.ArtistEntity;

public interface IArtistContract {
    interface View extends ICoreMvpContract.View<Presenter> {
        void showArtist(ArtistEntity artist);
    }

    interface Presenter extends ICoreMvpContract.Presenter<View> {

    }
}
