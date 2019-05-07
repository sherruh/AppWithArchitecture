package com.geektech.lastfmapp.presentation.track;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.geektech.core.mvp.CoreMvpActivity;
import com.geektech.lastfmapp.R;
import com.geektech.lastfmapp.entities.ArtistEntity;
import com.geektech.lastfmapp.entities.TrackEntity;

public class TrackActivity extends CoreMvpActivity<ITrackContract.Presenter>
    implements ITrackContract.View{

    private ImageView imageTrack;
    private TextView textName;
    private TextView textArtist;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_track;
    }

    @Override
    protected void initView() {
        TrackEntity trackEntity= (TrackEntity) getIntent().getSerializableExtra("track");
        imageTrack=findViewById(R.id.image_activity_track);
        textName=findViewById(R.id.text_activity_track_name);
        textArtist=findViewById(R.id.text_activity_track_artist);
        showTrackDetails(trackEntity);
    }

    @Nullable
    @Override
    protected ITrackContract.Presenter providePresenter() {
        return new TrackPresenter();
    }

    @Override
    public void showTrackDetails(TrackEntity trackEntity) {
        textName.setText(trackEntity.getName());
        textArtist.setText("Artist: "+trackEntity.getArtist().getName());
        Glide.with(this).load(trackEntity.getImage().get(2).getUrl()).
                into(imageTrack);
    }
}
