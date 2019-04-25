package com.geektech.lastfmapp.presentation.topartists;

import com.geektech.lastfmapp.model.ArtistEntity;



import java.util.ArrayList;

public class TopArtistsPresenter implements ITopArtistsContract.Presenter {

    ITopArtistsContract.View mView;

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
    public void attachView(ITopArtistsContract.View view) {
        mView=view;
        mView.attachPresenter(this);
    }

    @Override
    public void detachView() {
        mView=null;
    }
}
