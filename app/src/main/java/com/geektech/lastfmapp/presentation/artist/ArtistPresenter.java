package com.geektech.lastfmapp.presentation.artist;

import com.geektech.core.Logger;
import com.geektech.core.mvp.CoreMvpPresenter;
import com.geektech.lastfmapp.data.artists.IArtistsRepository;
import com.geektech.lastfmapp.data.tracks.ITracksRepository;
import com.geektech.lastfmapp.entities.ArtistEntity;
import com.geektech.lastfmapp.entities.TrackEntity;

public class ArtistPresenter extends CoreMvpPresenter<IArtistContract.View> implements
        IArtistContract.Presenter {


    private IArtistsRepository repository;
    private String artistId;

    public ArtistPresenter(
            IArtistsRepository repository,
            String artistId
    ) {
        this.repository = repository;
        this.artistId = artistId;
    }


    @Override
    public void onViewCreated() {
        super.onViewCreated();

        ArtistEntity artist = repository.getArtist(artistId);

        if (view != null && artist != null) {
            view.showArtist(artist);
        }
    }
}
