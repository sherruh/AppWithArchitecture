package com.geektech.lastfmapp.data.tracks.local;

import io.realm.RealmObject;

public class RShortArtist extends RealmObject {

    private String name;
    private String url;

    public RShortArtist() {
    }

    public RShortArtist(String name, String url) {
        this.name = name;
        this.url = url;
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
}
