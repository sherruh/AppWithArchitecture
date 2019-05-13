package com.geektech.lastfmapp.presentation.toptracks.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.geektech.lastfmapp.R;
import com.geektech.lastfmapp.entities.TrackEntity;

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
            listener.onTrackClick(getAdapterPosition());
        });

        textName=itemView.findViewById(R.id.text_name);
        textArtist=itemView.findViewById(R.id.text_artist);
        imageTrack=itemView.findViewById(R.id.image_track);
    }

    public void onBind(TrackEntity track){
        textName.setText(track.getName());
        textArtist.setText(track.getArtist().getName());
        Glide.with(itemView).
                load(track.getImage().get(2).getUrl()).
                into(imageTrack);
    }

    public interface TopTrackClickListener {

        void onTrackClick(int position);

    }

}
