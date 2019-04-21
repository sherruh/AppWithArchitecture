package com.geektech.lastfmapp.presentation.topartists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.geektech.lastfmapp.R;
import com.geektech.lastfmapp.model.ArtistEntity;
import com.geektech.lastfmapp.presentation.basecontracts.BasePresenter;
import com.geektech.lastfmapp.presentation.basecontracts.BaseView;

import java.util.List;

public class TopArtistsActivity extends AppCompatActivity implements TopArtistsContract.View {

    TopArtistsContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_artists);

        mPresenter=new TopArtistsPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void showArtists(List<ArtistEntity> artists) {

    }

    @Override
    public void openArtist(ArtistEntity artist) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void finishView() {
        finish();
    }

    @Override
    public void attachPresenter(BasePresenter presenter) {
    }
}
