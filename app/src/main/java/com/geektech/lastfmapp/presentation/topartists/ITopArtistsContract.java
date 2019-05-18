package com.geektech.lastfmapp.presentation.topartists;

import com.geektech.core.mvp.ICoreMvpContract;
import com.geektech.lastfmapp.entities.ArtistEntity;
import com.geektech.lastfmapp.entities.TrackEntity;
import com.geektech.lastfmapp.presentation.toptracks.ITopTracksContract;

import java.util.List;

public interface ITopArtistsContract {

    interface View extends ICoreMvpContract.View<Presenter> {
        void showArtists(List<ArtistEntity> artists);

        void openArtistDetails(ArtistEntity artist);

        void startRefresh();

        void stopRefresh();
    }

    interface Presenter extends ICoreMvpContract.Presenter<View>{
        void getArtists();

        void onArtistClick(int position);
    }
}
