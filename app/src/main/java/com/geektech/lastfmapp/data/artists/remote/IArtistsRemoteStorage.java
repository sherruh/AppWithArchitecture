package com.geektech.lastfmapp.data.artists.remote;

import com.geektech.lastfmapp.data.artists.IArtistsRepository;

public interface IArtistsRemoteStorage {
    void getArtists(IArtistsRepository.ArtistsCallback callback);
}
