package com.geektech.lastfmapp.model;

public class TrackEntity {
    private int id;
    private String name;
    private String artist;
    private String image;

    public TrackEntity(int id, String name, String artist, String image) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + artist + " " + image;
    }
}
