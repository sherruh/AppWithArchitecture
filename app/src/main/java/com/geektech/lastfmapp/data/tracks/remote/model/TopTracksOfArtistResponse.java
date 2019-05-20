package com.geektech.lastfmapp.data.tracks.remote.model;

import com.google.gson.annotations.SerializedName;

public class TopTracksOfArtistResponse {
    @SerializedName("toptracks")
    private TracksResponseData tracks;

    public TopTracksOfArtistResponse(TracksResponseData tracks) {
        this.tracks = tracks;
    }

    public TracksResponseData getTracks() {
        return tracks;
    }

    public void setTracks(TracksResponseData tracks) {
        this.tracks = tracks;
    }
}
