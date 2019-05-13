package com.geektech.lastfmapp;

import android.app.Application;
import android.support.annotation.Nullable;

import com.geektech.lastfmapp.data.artists.ArtistsRepository;
import com.geektech.lastfmapp.data.artists.IArtistsRepository;
import com.geektech.lastfmapp.data.artists.local.ArtistsLocalStorage;
import com.geektech.lastfmapp.data.artists.remote.ArtistsRemoteStorage;
import com.geektech.lastfmapp.data.tracks.ITracksRepository;
import com.geektech.lastfmapp.data.tracks.TracksRepository;
import com.geektech.lastfmapp.data.tracks.local.TracksLocalStorage;
import com.geektech.lastfmapp.data.tracks.remote.TracksRemoteStorage;
import com.geektech.lastfmapp.entities.ArtistEntity;

public class App extends Application {

    public static ITracksRepository tracksRepository;
    public static IArtistsRepository artistsRepository;

    @Override
    public void onCreate() {
        super.onCreate();

        tracksRepository = new TracksRepository(
                new TracksLocalStorage(),
                new TracksRemoteStorage()
        );

        artistsRepository=new ArtistsRepository(
                new ArtistsLocalStorage(),
                new ArtistsRemoteStorage()
        );
    }
}
