package com.geektech.lastfmapp.presentation.toptracks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.geektech.lastfmapp.R;
import com.geektech.lastfmapp.model.TrackEntity;

import java.util.List;

public class TopTracksActivity extends AppCompatActivity
    implements TopTracksContract.View {

    private TopTracksContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_tracks);

        mPresenter = new TopTracksPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void showTracks(List<TrackEntity> tracks) {

    }

    @Override
    public void openTrack(TrackEntity track) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void finishView() {
        finish();
    }

    @Override
    public void attachPresenter(TopTracksContract.Presenter presenter) {

    }
}
