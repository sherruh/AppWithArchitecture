package com.geektech.lastfmapp.presentation.toptracks;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.geektech.core.Logger;
import com.geektech.core.mvp.CoreMvpFragment;
import com.geektech.lastfmapp.R;
import com.geektech.lastfmapp.data.tracks.remote.TracksRemoteStorage;
import com.geektech.lastfmapp.data.tracks.remote.model.TracksResponse;
import com.geektech.lastfmapp.entities.TrackEntity;
import com.geektech.lastfmapp.presentation.artist.ArtistActivity;
import com.geektech.lastfmapp.presentation.toptracks.recycler.TopTrackViewHolder;
import com.geektech.lastfmapp.presentation.toptracks.recycler.TopTracksAdapter;
import com.geektech.lastfmapp.presentation.track.TrackActivity;

import java.util.ArrayList;
import java.util.List;

public class TopTracksFragment extends CoreMvpFragment<ITopTracksContract.Presenter>
    implements ITopTracksContract.View, TopTrackViewHolder.TopTrackClickListener {

    private TopTracksAdapter mAdapter;
    private ArrayList<TrackEntity> tracks;

    public static TopTracksFragment newInstance() {
        TopTracksFragment fragment = new TopTracksFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_top_tracks;
    }

    @Override
    protected void initView(View view) {
        RecyclerView recyclerView = getActivity().findViewById(R.id.recycler_top_tracks);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new TopTracksAdapter(this, new ArrayList<>());
        recyclerView.setAdapter(mAdapter);
        tracks=new ArrayList<>();
    }

    private void refreshTracks() {
        if (presenter != null) {
            presenter.getTracks();
        }
    }

    //region ViewHolder

    @Override
    public void onTrackClick(int position) {
        openTrackDetails(tracks.get(position));
    }

    @Override
    public void onShareClick(int position) {

    }

    @Override
    public void onBookmarkClick(int position) {

    }

    //endregion

    //region Contract

    @Override
    public void showTracks(List<TrackEntity> tracks) {
        this.tracks.clear();
        this.tracks.addAll(tracks);
        mAdapter.setTracks(tracks);
    }

    @Override
    public void openTrackDetails(TrackEntity track) {
        Intent intent=new Intent(getContext(), TrackActivity.class);
        intent.putExtra("track",track);
        startActivity(intent);
    }

    //endregion
}
