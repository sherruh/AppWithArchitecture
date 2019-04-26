package com.geektech.lastfmapp.presentation.toptracks;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geektech.lastfmapp.R;
import com.geektech.lastfmapp.model.TrackEntity;

import java.util.List;

import core.CoreFragment;

public class TopTracksFragment extends CoreFragment implements ITopTracksContract.View {

    public static TopTracksFragment getInstance(){
        return new TopTracksFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_tracks, container, false);
        TextView textView = (TextView) view;
        textView.setText("Fragment Top Tracks");
        return view;
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
    public void attachPresenter(ITopTracksContract.Presenter presenter) {
        mPresenter=presenter;
        mPresenter.attachView(this);
    }

    @Override
    public void finishView() {
        getActivity().finish();
    }

}
