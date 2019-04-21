package com.geektech.lastfmapp.presentation.artist;

import com.geektech.lastfmapp.model.ArtistEntity;
import com.geektech.lastfmapp.presentation.basecontracts.BaseView;

public class ArtistPresenter implements ArtistContract.Presenter {

    ArtistContract.View mView;

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
    public void attachView(BaseView view) {
        mView=(ArtistContract.View)view;
        mView.attachPresenter(this);
    }

    @Override
    public void detachView() {
        mView=null;
    }
}
