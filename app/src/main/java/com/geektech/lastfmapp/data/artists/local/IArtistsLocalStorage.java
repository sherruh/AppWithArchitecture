package com.geektech.lastfmapp.data.artists.local;

import com.geektech.lastfmapp.data.artists.IArtistsRepository;
import com.geektech.lastfmapp.data.tracks.ITracksRepository;
import com.geektech.lastfmapp.entities.ArtistEntity;
import com.geektech.lastfmapp.entities.TrackEntity;

import java.util.List;

public interface IArtistsLocalStorage {
    void getArtists(IArtistsRepository.ArtistsCallback callback);

    void setArtists(List<ArtistEntity> artists);

    ArtistEntity getArtist();
}
