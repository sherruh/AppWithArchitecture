package com.geektech.lastfmapp.presentation.toptracks.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.geektech.lastfmapp.R;
import com.geektech.lastfmapp.entities.TrackEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class TopTracksAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private TopTrackViewHolder.TopTrackClickListener mListener;
    private ArrayList<TrackEntity> mTracks;

    public TopTracksAdapter(
            TopTrackViewHolder.TopTrackClickListener listener,
            ArrayList<TrackEntity> tracks
    ) {
        mListener = listener;
        mTracks = tracks;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.view_holder_top_tracks, viewGroup, false);
        return new TopTrackViewHolder(view,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        TrackEntity track = mTracks.get(i);
        ((TopTrackViewHolder)viewHolder).onBind(track);
    }

    @Override
    public int getItemCount() {
        return mTracks.size();
    }

    public void setTracks(List<TrackEntity> tracks) {
        mTracks.clear();
        mTracks.addAll(tracks);
        notifyDataSetChanged();
    }
}
