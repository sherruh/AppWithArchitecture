package com.geektech.lastfmapp.entities;

import com.google.gson.annotations.SerializedName;

public class ArtistEntity {
    @SerializedName("name")
    private String name;
    @SerializedName("mbid")
    private String mbid;
    @SerializedName("url")
    private String url;

    public ArtistEntity(String name, String mbid, String url) {
        this.name = name;
        this.mbid = mbid;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return name + " " + url;
    }
}
