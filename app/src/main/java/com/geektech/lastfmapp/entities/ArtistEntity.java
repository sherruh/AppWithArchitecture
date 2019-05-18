package com.geektech.lastfmapp.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ArtistEntity implements Serializable {

    private String id;

    @SerializedName("name")
    private String name;
    @SerializedName("mbid")
    private String mbid;
    @SerializedName("url")
    private String url;
    @SerializedName("listeners")
    private String listeners;
    @SerializedName("image")
    private List<ImageOfEntity> image;

    public ArtistEntity(String name, String mbid, String url, String listeners, List<ImageOfEntity> image) {
        this.name = name;
        this.mbid = mbid;
        this.url = url;
        this.listeners = listeners;
        this.image = image;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public List<ImageOfEntity> getImage() {
        return image;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = String.valueOf(name.hashCode());
    }

    public void setImage(List<ImageOfEntity> image) {
        this.image = image;
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
