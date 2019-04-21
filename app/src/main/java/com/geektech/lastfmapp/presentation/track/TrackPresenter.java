package com.geektech.lastfmapp.presentation.track;

import com.geektech.lastfmapp.model.TrackEntity;
import com.geektech.lastfmapp.presentation.basecontracts.BaseView;

public class TrackPresenter implements TrackContract.Presenter {

    TrackContract.View mView;

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
    public void attachView(BaseView view) {
        mView=(TrackContract.View)view;
        mView.attachPresenter(this);
    }

    @Override
    public void detachView() {
        mView=null;
    }
}
