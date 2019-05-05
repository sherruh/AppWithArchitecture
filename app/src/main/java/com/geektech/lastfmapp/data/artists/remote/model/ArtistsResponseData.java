package com.geektech.lastfmapp.data.artists.remote.model;

import com.geektech.lastfmapp.entities.ArtistEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArtistsResponseData {

    @SerializedName("artists")
    private List<ArtistEntity> data;

    public List<ArtistEntity> getData() {
        return data;
    }

    public void setData(List<ArtistEntity> data) {
        this.data = data;
    }

    public ArtistsResponseData(List<ArtistEntity> data) {
        this.data = data;
    }
}
