package com.geektech.lastfmapp.presentation.artist;

import com.geektech.lastfmapp.model.ArtistEntity;


public class ArtistPresenter implements IArtistContract.Presenter {

    IArtistContract.View mView;

    @Override
    public void getArtist() {
        //TODO get artist from repository
        ArtistEntity artist=new ArtistEntity(1,"name");
        if(mView!=null) mView.showArtistInfo(artist);
    }

    @Override
    public void onClick() {

    }

    @Override
    public void attachView(IArtistContract.View view) {
        mView=(IArtistContract.View)view;
        mView.attachPresenter(this);
    }

    @Override
    public void detachView() {
        mView=null;
    }
}
