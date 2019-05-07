package com.geektech.lastfmapp.presentation.artist;

import com.geektech.core.mvp.CoreMvpPresenter;
import com.geektech.lastfmapp.entities.ArtistEntity;

public class ArtistPresenter extends CoreMvpPresenter<IArtistContract.View> implements
        IArtistContract.Presenter {


    @Override
    public void setArtist(ArtistEntity artist) {
        view.showArtistDetails(artist);
    }
}
