package com.geektech.lastfmapp.presentation.track;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.geektech.core.mvp.CoreMvpActivity;
import com.geektech.lastfmapp.App;
import com.geektech.lastfmapp.R;
import com.geektech.lastfmapp.entities.ArtistEntity;
import com.geektech.lastfmapp.entities.TrackEntity;

public class TrackActivity extends CoreMvpActivity<ITrackContract.Presenter>
    implements ITrackContract.View{

    private ImageView imageTrack;
    private TextView textName;
    private TextView textArtist;

    private static final String EXTRA_TRACK_ID = "track_id";

    public static void start(
            Activity activity,
            String trackId
    ) {
        Intent intent = new Intent(activity, TrackActivity.class);

        intent.putExtra(EXTRA_TRACK_ID, trackId);

        activity.startActivity(intent);
    }

    private static String getTrackId(Intent intent) {
        return intent.getStringExtra(EXTRA_TRACK_ID);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_track;
    }

    @Override
    protected void initView() {
        imageTrack=findViewById(R.id.image_activity_track);
        textName=findViewById(R.id.text_activity_track_name);
        textArtist=findViewById(R.id.text_activity_track_artist);
    }

    @Nullable
    @Override
    protected ITrackContract.Presenter providePresenter() {
        return new TrackPresenter(
                App.tracksRepository,
                getTrackId(getIntent())
        );
    }

    @Override
    public void showTrack(TrackEntity trackEntity) {
        textName.setText(trackEntity.getName());
        textArtist.setText("Artist: "+trackEntity.getArtist().getName());
        Glide.with(this).load(trackEntity.getImage().get(2).getUrl()).
                into(imageTrack);
    }
}
