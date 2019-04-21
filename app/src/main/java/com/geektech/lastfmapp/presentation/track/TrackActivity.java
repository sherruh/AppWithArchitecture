package com.geektech.lastfmapp.presentation.track;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.geektech.lastfmapp.R;
import com.geektech.lastfmapp.model.TrackEntity;
import com.geektech.lastfmapp.presentation.basecontracts.BasePresenter;

public class TrackActivity extends AppCompatActivity implements TrackContract.View {

    TrackContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
        presenter=new TrackPresenter();
        presenter.attachView(this);
    }

    @Override
    public void showTrackInfo(TrackEntity trackEntity) {

    }

    @Override
    public void finishView() {
        finish();
    }

    @Override
    public void attachPresenter(BasePresenter presenter) {

    }
}
