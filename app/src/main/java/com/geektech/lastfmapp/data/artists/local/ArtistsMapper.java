package com.geektech.lastfmapp.data.artists.local;

import com.geektech.lastfmapp.common.RImage;
import com.geektech.lastfmapp.entities.ArtistEntity;
import com.geektech.lastfmapp.entities.ImageOfEntity;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

public class ArtistsMapper {

    static RArtist artistToRArtist(ArtistEntity artist){

        RealmList<RImage> images = new RealmList<>();

        for (ImageOfEntity image : artist.getImage()) {
            images.add(new RImage(image.getUrl(), image.getSize()));
        }

        return new RArtist(
                artist.getName(),
                artist.getUrl(),
                artist.getListeners(),
                images
        );
    }

    static ArtistEntity rArtistToArtist(RArtist artist){

        ArrayList<ImageOfEntity> images = new ArrayList<>();

        for (RImage image : artist.getImages()) {
            images.add(new ImageOfEntity(image.getUrl(), image.getSize()));
        }

        return new ArtistEntity(
                artist.getName(),
                "",
                artist.getUrl(),
                artist.getListeners(),
                images
        );
    }

    static List<RArtist> toRArtists(List<ArtistEntity> artists){
        ArrayList<RArtist> result = new ArrayList<>();

        for(ArtistEntity artist: artists){
            result.add(artistToRArtist(artist));
        }

        return result;
    }

    static List<ArtistEntity> toArtists(List<RArtist> artists){
        ArrayList<ArtistEntity> result = new ArrayList<>();

        for(RArtist artist: artists){
            result.add(rArtistToArtist(artist));
        }

        return result;
    }
}
