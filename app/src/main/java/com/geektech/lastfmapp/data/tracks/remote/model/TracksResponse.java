package com.geektech.lastfmapp.data.tracks.remote.model;

import com.google.gson.annotations.SerializedName;

public class TracksResponse {
    public TracksResponseData getTopTracksOfArtist() {
        return topTracksOfArtist;
    }

    public void setTopTracksOfArtist(TracksResponseData topTracksOfArtist) {
        this.topTracksOfArtist = topTracksOfArtist;
    }

    @SerializedName("tracks")
    private TracksResponseData tracks;

    @SerializedName("toptracks")
    private TracksResponseData topTracksOfArtist;

    public TracksResponse(TracksResponseData tracks) {
        this.tracks = tracks;
    }

    public TracksResponseData getTracks() {
        return tracks;
    }

    public void setTracks(TracksResponseData tracks) {
        this.tracks = tracks;
    }
}
