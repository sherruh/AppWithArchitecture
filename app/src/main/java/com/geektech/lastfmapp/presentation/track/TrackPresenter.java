package com.geektech.lastfmapp.presentation.track;

import com.geektech.lastfmapp.model.TrackEntity;


public class TrackPresenter implements ITrackContract.Presenter {

    ITrackContract.View mView;

    @Override
    public void getTrack() {
        //TODO: Get track from Repository
        TrackEntity track=new TrackEntity(1,"name","artist","image");
        if(mView!=null) mView.showTrackInfo(track);
    }

    @Override
    public void onClickPlay() {

    }

    @Override
    public void attachView(ITrackContract.View view) {
        mView=(ITrackContract.View)view;
        mView.attachPresenter(this);
    }

    @Override
    public void detachView() {
        mView=null;
    }
}
