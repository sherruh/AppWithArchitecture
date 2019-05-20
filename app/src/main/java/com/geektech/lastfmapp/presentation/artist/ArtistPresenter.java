package com.geektech.lastfmapp.presentation.artist;

import com.geektech.core.Logger;
import com.geektech.core.mvp.CoreMvpPresenter;
import com.geektech.lastfmapp.data.artists.IArtistsRepository;
import com.geektech.lastfmapp.data.tracks.ITracksRepository;
import com.geektech.lastfmapp.entities.ArtistEntity;
import com.geektech.lastfmapp.entities.TrackEntity;

import java.util.ArrayList;
import java.util.List;

public class ArtistPresenter extends CoreMvpPresenter<IArtistContract.View> implements
        IArtistContract.Presenter {


    private IArtistsRepository repository;
    private ITracksRepository tracksRepository;
    private String artistId;

    public ArtistPresenter(
            IArtistsRepository repository,
            ITracksRepository tracksRepository,
            String artistId
    ) {
        this.repository = repository;
        this.artistId = artistId;
        this.tracksRepository = tracksRepository;
    }


    @Override
    public void onViewCreated() {
        super.onViewCreated();

        ArtistEntity artist = repository.getArtist(artistId);

        if (view != null && artist != null) {
            view.showArtist(artist);
        }

        getTopTracks(artist);
    }

    @Override
    public void getTopTracks(ArtistEntity artist) {
        tracksRepository.getTopTracksOfArtist(new ITracksRepository.TracksCallback() {
            @Override
            public void onSuccess(List<TrackEntity> result) {
                if (view != null && artist != null) {
                    view.showTopTracks(result);
                }
            }

            @Override
            public void onFailure(String message) {

            }
        },artist);
    }
}
