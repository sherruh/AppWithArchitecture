package com.geektech.lastfmapp.presentation.artist;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.geektech.core.mvp.CoreMvpActivity;
import com.geektech.lastfmapp.App;
import com.geektech.lastfmapp.R;
import com.geektech.lastfmapp.entities.ArtistEntity;
import com.geektech.lastfmapp.entities.TrackEntity;
import com.geektech.lastfmapp.presentation.toptracks.recycler.TopTrackViewHolder;
import com.geektech.lastfmapp.presentation.toptracks.recycler.TopTracksAdapter;

import java.util.ArrayList;
import java.util.List;

public class ArtistActivity extends CoreMvpActivity<IArtistContract.Presenter>
    implements IArtistContract.View, TopTrackViewHolder.TopTrackClickListener {

    private static final String EXTRA_ARTIST_ID = "artist_id";

    private ImageView imageArtist;
    private TextView textName;
    private TextView textListeners;
    private TopTracksAdapter mAdapter;


    public static void start(
            Activity activity,
            String artistId
    ) {
        Intent intent = new Intent(activity, ArtistActivity.class);

        intent.putExtra(EXTRA_ARTIST_ID, artistId);

        activity.startActivity(intent);
    }

    private static String getArtistId(Intent intent) {
        return intent.getStringExtra(EXTRA_ARTIST_ID);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_artist;
    }

    @Override
    protected void initView() {
        imageArtist=findViewById(R.id.image_activity_artist);
        textName=findViewById(R.id.text_activity_artist_name);
        textListeners=findViewById(R.id.text_activity_artist_listeners);
        RecyclerView recyclerView = findViewById(R.id.recycler_top_tracks_of_artist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new TopTracksAdapter(this, new ArrayList<>());
        recyclerView.setAdapter(mAdapter);
    }

    @Nullable
    @Override
    protected IArtistContract.Presenter providePresenter() {
        return new ArtistPresenter(
                App.artistsRepository,
                App.tracksRepository,
                getArtistId(getIntent())
        );
    }

    @Override
    public void showArtist(ArtistEntity artist) {
        textName.setText(artist.getName());
        textListeners.setText("Listeners: "+artist.getListeners());
        Glide.with(this).load(artist.getImage().get(2).getUrl()).
                into(imageArtist);
    }

    @Override
    public void showTopTracks(List<TrackEntity> tracks) {
        mAdapter.setTracks(tracks);
    }

    @Override
    public void onTrackClick(int position) {

    }
}
