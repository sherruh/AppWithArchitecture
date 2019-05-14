package com.geektech.lastfmapp.data.tracks.local;

import com.geektech.lastfmapp.entities.ArtistEntity;
import com.geektech.lastfmapp.entities.ImageOfEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

public class RTrack extends RealmObject {
    @PrimaryKey
    private long rId;

    @Index
    private String id;

    private String name;

    private String url;

    private String playcount;

    private String listeners;

    public RTrack(long rId, String id, String name, String url, String playcount, String listeners) {
        this.rId = rId;
        this.id = id;
        this.name = name;
        this.url = url;
        this.playcount = playcount;
        this.listeners = listeners;
    }

    public RTrack() {
    }

    public long getrId() {
        return rId;
    }

    public void setrId(long rId) {
        this.rId = rId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPlaycount() {
        return playcount;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }
}
