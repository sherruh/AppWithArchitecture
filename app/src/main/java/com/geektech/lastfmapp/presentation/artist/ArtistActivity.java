package com.geektech.lastfmapp.presentation.artist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.geektech.lastfmapp.R;
import com.geektech.lastfmapp.model.ArtistEntity;
import com.geektech.lastfmapp.presentation.basecontracts.BasePresenter;

public class ArtistActivity extends AppCompatActivity implements ArtistContract.View {

    ArtistContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);
        mPresenter=new ArtistPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void showArtistInfo(ArtistEntity artist) {

    }

    @Override
    public void finishView() {
        finish();
    }

    @Override
    public void attachPresenter(BasePresenter presenter) {

    }
}
