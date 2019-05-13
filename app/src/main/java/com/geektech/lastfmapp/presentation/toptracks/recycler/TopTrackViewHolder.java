package com.geektech.lastfmapp.presentation.toptracks.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.geektech.lastfmapp.R;

public class TopTrackViewHolder extends RecyclerView.ViewHolder {

    public TextView textName;
    public TextView textArtist;
    public ImageView imageTrack;

    public TopTrackViewHolder(
            @NonNull View itemView,
            TopTrackClickListener listener
    ) {
        super(itemView);
        itemView.setOnClickListener(v -> {
            listener.onTrackClick(getLayoutPosition());
        });

        textName=itemView.findViewById(R.id.text_name);
        textArtist=itemView.findViewById(R.id.text_artist);
        imageTrack=itemView.findViewById(R.id.image_track);
    }

    public interface TopTrackClickListener {
        void onTrackClick(int position);

        void onShareClick(int position);

        void onBookmarkClick(int position);
    }

}
