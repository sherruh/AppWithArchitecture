package com.geektech.lastfmapp.data.tracks.local;



import com.geektech.lastfmapp.common.RImage;
import com.geektech.lastfmapp.entities.ArtistEntity;
import com.geektech.lastfmapp.entities.ImageEntity;
import com.geektech.lastfmapp.entities.TrackEntity;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

class TracksMapper {
    static RTrack toRTrack(TrackEntity track) {
        RShortArtist artist=new RShortArtist(track.getArtist().getName(),track.getArtist().getUrl());

        RealmList<RImage> images = new RealmList<>();

        for (ImageEntity image : track.getImage()) {
            images.add(new RImage(image.getUrl(), image.getSize()));
        }

        return new RTrack(
                track.getName(),
                track.getUrl(),
                track.getPlaycount(),
                track.getListeners(),
                track.getId(),
                images,
                artist
        );
    }

    static TrackEntity toTrack(RTrack track) {
        ArtistEntity artist=new ArtistEntity(track.getArtist().getName(),"",
                track.getArtist().getUrl(),"",null);

        ArrayList<ImageEntity> images = new ArrayList<>();

        for (RImage image : track.getImages()) {
            images.add(new ImageEntity(image.getUrl(), image.getSize()));
        }

        return new TrackEntity(
                track.getName(),
                artist,
                track.getUrl(),
                track.getPlaycount(),
                track.getListeners(),
                images
        );
    }

    static List<RTrack> toRTracks(List<TrackEntity> tracks) {
        ArrayList<RTrack> result = new ArrayList<>();

        for (TrackEntity track : tracks) {
            result.add(toRTrack(track));
        }

        return result;
    }

    static List<TrackEntity> toTracks(List<RTrack> tracks) {
        ArrayList<TrackEntity> result = new ArrayList<>();

        for (RTrack rTrack : tracks) {
            result.add(toTrack(rTrack));
        }

        return result;
    }
}
