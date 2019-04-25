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

public class TopTracksFragment extends CoreFragment {

    private ITopTracksContract.Presenter mPresenter;

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

    //region Contract

    //endregion
}
