package com.geektech.lastfmapp.presentation.artist;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.geektech.core.Logger;
import com.geektech.core.mvp.CoreMvpActivity;
import com.geektech.lastfmapp.R;
import com.geektech.lastfmapp.entities.ArtistEntity;

public class ArtistActivity extends CoreMvpActivity<IArtistContract.Presenter>
    implements IArtistContract.View {


    private ImageView imageArtist;
    private TextView textName;
    private TextView textListeners;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_artist;
    }

    @Override
    protected void initView() {
        ArtistEntity artistEntity= (ArtistEntity) getIntent().getSerializableExtra("artist");
        imageArtist=findViewById(R.id.image_activity_artist);
        textName=findViewById(R.id.text_activity_artist_name);
        textListeners=findViewById(R.id.text_activity_artist_listeners);
        showArtistDetails(artistEntity);
    }

    @Nullable
    @Override
    protected IArtistContract.Presenter providePresenter() {
        return new ArtistPresenter();
    }

    @Override
    public void showArtistDetails(ArtistEntity artist) {
        textName.setText(artist.getName());
        textListeners.setText("Listeners: "+artist.getListeners());
        Glide.with(this).load(artist.getImage().get(2).getUrl()).
                into(imageArtist);
    }
}
