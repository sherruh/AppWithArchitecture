package com.geektech.lastfmapp.data.artists.local;

import com.geektech.lastfmapp.data.artists.IArtistsRepository;
import com.geektech.lastfmapp.entities.ArtistEntity;

import java.util.List;

public class ArtistsLocalStorage implements IArtistsLocalStorage {
    @Override
    public void getArtists(IArtistsRepository.ArtistsCallback callback) {

    }

    @Override
    public void setArtists(List<ArtistEntity> artists) {

    }

    @Override
    public ArtistEntity getArtist() {
        return null;
    }
}
