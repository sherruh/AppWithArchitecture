package com.geektech.lastfmapp.data.artists.local;

import com.geektech.lastfmapp.common.RImage;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RArtist extends RealmObject {

    public RArtist() {
    }

    @PrimaryKey
    private String name;
    private String url;
    private String listeners;
    private RealmList<RImage> images;

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

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public RealmList<RImage> getImages() {
        return images;
    }

    public void setImages(RealmList<RImage> images) {
        this.images = images;
    }

    public RArtist(String name, String url, String listeners, RealmList<RImage> images) {
        this.name = name;
        this.url = url;
        this.listeners = listeners;
        this.images = images;
    }
}
