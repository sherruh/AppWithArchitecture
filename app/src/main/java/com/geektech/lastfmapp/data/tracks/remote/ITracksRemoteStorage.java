package com.geektech.lastfmapp.data.tracks.remote;

import com.geektech.lastfmapp.data.tracks.ITracksRepository;
import com.geektech.lastfmapp.entities.ArtistEntity;

public interface ITracksRemoteStorage {
    void getTracks(ITracksRepository.TracksCallback callback);

    void getTopTracksOfArtist(ITracksRepository.TracksCallback callback, ArtistEntity artist);
}