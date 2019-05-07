package com.geektech.lastfmapp.presentation.topartists.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.geektech.lastfmapp.R;
import com.geektech.lastfmapp.entities.ArtistEntity;

import java.util.ArrayList;

public class TopArtistsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private TopArtistViewHolder.TopArtistClickListener mListener;
    private ArrayList<ArtistEntity> mArtists;

    public TopArtistsAdapter(TopArtistViewHolder.TopArtistClickListener Listener,
                             ArrayList<ArtistEntity> artists) {
        mListener = Listener;
        mArtists = artists;
    }

    @NonNull
    @Override
    public TopArtistViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.view_holdeer_top_artists, viewGroup, false);
        return new TopArtistViewHolder(view,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ArtistEntity artistEntity=mArtists.get(i);
        TopArtistViewHolder topArtistViewHolder=(TopArtistViewHolder)viewHolder;
        topArtistViewHolder.textName.setText(artistEntity.getName());
        topArtistViewHolder.textListeners.setText(artistEntity.getListeners());
        Glide.with(topArtistViewHolder.image).
                load(artistEntity.getImage().get(2).getUrl()).
                into(topArtistViewHolder.image);

    }

    @Override
    public int getItemCount() {
        return mArtists.size();
    }

    public void setArtists(ArrayList<ArtistEntity> artists){
        mArtists.clear();
        mArtists.addAll(artists);
        notifyDataSetChanged();
    }
}
