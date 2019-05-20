package com.geektech.lastfmapp.presentation.artist;

import com.geektech.core.mvp.ICoreMvpContract;
import com.geektech.lastfmapp.entities.ArtistEntity;
import com.geektech.lastfmapp.entities.TrackEntity;

import java.util.List;

public interface IArtistContract {
    interface View extends ICoreMvpContract.View<Presenter> {
        void showArtist(ArtistEntity artist);

        void showTopTracks(List<TrackEntity> tracks);
    }

    interface Presenter extends ICoreMvpContract.Presenter<View> {
        void getTopTracks(ArtistEntity artist);
    }
}
