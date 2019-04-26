package com.geektech.lastfmapp.presentation.topartists;

import com.geektech.lastfmapp.model.ArtistEntity;



import java.util.ArrayList;

import core.CorePresenter;

public class TopArtistsPresenter extends CorePresenter implements ITopArtistsContract.Presenter {

    ArrayList<ArtistEntity> artists;

    @Override
    public void getArtists() {
        //TODO get artists from repository
        artists=new ArrayList<>();
        artists.add(new ArtistEntity(1,"name"));
        artists.add(new ArtistEntity(2,"name"));
        artists.add(new ArtistEntity(3,"name"));
        artists.add(new ArtistEntity(4,"name"));
        artists.add(new ArtistEntity(5,"name"));

    }

    @Override
    public void onArtistClick(int position) {

    }

    @Override
    public void attachView(ITopArtistsContract.View view) {
        mView=view;
        ((ITopArtistsContract.View) mView).showArtists(artists);
        mView.attachPresenter(this);
    }

    @Override
    public void detachView() {
        mView=null;
    }
}
