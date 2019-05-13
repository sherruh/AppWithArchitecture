package com.geektech.lastfmapp.presentation.artist;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.geektech.core.Logger;
import com.geektech.core.mvp.CoreMvpActivity;
import com.geektech.lastfmapp.App;
import com.geektech.lastfmapp.R;
import com.geektech.lastfmapp.entities.ArtistEntity;
import com.geektech.lastfmapp.presentation.track.TrackActivity;
import com.geektech.lastfmapp.presentation.track.TrackPresenter;

public class ArtistActivity extends CoreMvpActivity<IArtistContract.Presenter>
    implements IArtistContract.View {

    private static final String EXTRA_ARTIST_ID = "artist_id";

    private ImageView imageArtist;
    private TextView textName;
    private TextView textListeners;

    public static void start(
            Activity activity,
            String artistId
    ) {
        Intent intent = new Intent(activity, ArtistActivity.class);

        intent.putExtra(EXTRA_ARTIST_ID, artistId);

        activity.startActivity(intent);
    }

    private static String getTrackId(Intent intent) {
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
    }

    @Nullable
    @Override
    protected IArtistContract.Presenter providePresenter() {
        return new ArtistPresenter(
                App.artistsRepository,
                getTrackId(getIntent())
        );
    }

    @Override
    public void showArtist(ArtistEntity artist) {
        textName.setText(artist.getName());
        textListeners.setText("Listeners: "+artist.getListeners());
        Glide.with(this).load(artist.getImage().get(2).getUrl()).
                into(imageArtist);
    }
}
