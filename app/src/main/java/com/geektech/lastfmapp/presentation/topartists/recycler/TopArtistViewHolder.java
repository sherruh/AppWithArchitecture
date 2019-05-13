package com.geektech.lastfmapp.presentation.topartists.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.geektech.lastfmapp.R;
import com.geektech.lastfmapp.presentation.toptracks.recycler.TopTrackViewHolder;

public class TopArtistViewHolder extends RecyclerView.ViewHolder {

    TextView textName;
    TextView textListeners;
    ImageView image;

    public TopArtistViewHolder(@NonNull View itemView,TopArtistClickListener clickListener) {
        super(itemView);
        itemView.setOnClickListener(v -> clickListener.onArtistClick(getAdapterPosition()));

        textName=itemView.findViewById(R.id.text_name_artist);
        textListeners=itemView.findViewById(R.id.text_artist_listeners);
        image=itemView.findViewById(R.id.image_artist);
    }

    public interface TopArtistClickListener{
        void onArtistClick(int position);
    }
}
