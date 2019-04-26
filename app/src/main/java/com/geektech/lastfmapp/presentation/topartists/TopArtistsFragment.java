package com.geektech.lastfmapp.presentation.topartists;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geektech.lastfmapp.R;
import com.geektech.lastfmapp.model.ArtistEntity;
import com.geektech.lastfmapp.model.TrackEntity;
import com.geektech.lastfmapp.presentation.toptracks.ITopTracksContract;

import java.util.List;

import core.CoreFragment;

public class TopArtistsFragment extends CoreFragment implements ITopArtistsContract.View {


    public static TopArtistsFragment getInstance(){
        return new TopArtistsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_artists, container, false);
        TextView textView = (TextView) view;
        textView.setText("Fragment Top Artists");
        return view;
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
    public void attachPresenter(ITopArtistsContract.Presenter presenter) {
        mPresenter=presenter;
        mPresenter.attachView(this  );
    }

    @Override
    public void finishView() {
        getActivity().finish();
    }
}
