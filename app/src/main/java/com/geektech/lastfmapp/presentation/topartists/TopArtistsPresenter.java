package com.geektech.lastfmapp.presentation.topartists;

import com.geektech.lastfmapp.model.ArtistEntity;
import com.geektech.lastfmapp.presentation.basecontracts.BaseView;


import java.util.ArrayList;

public class TopArtistsPresenter implements TopArtistsContract.Presenter {

    TopArtistsContract.View mView;

    @Override
    public void getArtists() {
        //TODO get artists from repository
        ArrayList<ArtistEntity> artists=new ArrayList<>();
        artists.add(new ArtistEntity(1,"name"));
        artists.add(new ArtistEntity(2,"name"));
        artists.add(new ArtistEntity(3,"name"));
        artists.add(new ArtistEntity(4,"name"));
        artists.add(new ArtistEntity(5,"name"));

        if (mView!=null) mView.showArtists(artists);
    }

    @Override
    public void onArtistClick(int position) {

    }

    @Override
    public void attachView(BaseView view) {
        mView=(TopArtistsContract.View)view;
        mView.attachPresenter(this);
    }

    @Override
    public void detachView() {
        mView=null;
    }
}
