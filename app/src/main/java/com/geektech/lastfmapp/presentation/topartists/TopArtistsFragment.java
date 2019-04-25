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

import java.util.List;

import core.CoreFragment;

public class TopArtistsFragment extends CoreFragment {

    ITopArtistsContract.Presenter mPresenter;

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


}
