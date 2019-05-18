package com.geektech.lastfmapp.data.tracks.local;



import com.geektech.lastfmapp.common.RImage;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RTrack extends RealmObject {
    @PrimaryKey
    private String id;

    private String name;
    private String url;
    private String playcount;
    private String listeners;
    private RealmList<RImage> images;
    private RShortArtist artist;

    public RTrack(String id, String name, String url, String playcount,
                  String listeners, RealmList<RImage> images, RShortArtist artist) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.playcount = playcount;
        this.listeners = listeners;
        this.images = images;
        this.artist = artist;
    }

    public RTrack(String name, String url, String playcount, String listeners, String id, RealmList<RImage> images) {
        this.name = name;
        this.url = url;
        this.playcount = playcount;
        this.listeners = listeners;
        this.id = id;
        this.images = images;
    }

    public RTrack() {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RealmList<RImage> getImages() {
        return images;
    }

    public void setImages(RealmList<RImage> images) {
        this.images = images;
    }

    public RShortArtist getArtist() {
        return artist;
    }

    public void setArtist(RShortArtist artist) {
        this.artist = artist;
    }
}
