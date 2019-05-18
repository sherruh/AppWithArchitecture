package com.geektech.lastfmapp.presentation.topartists;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.geektech.core.Logger;
import com.geektech.core.mvp.CoreMvpFragment;
import com.geektech.lastfmapp.R;
import com.geektech.lastfmapp.entities.ArtistEntity;
import com.geektech.lastfmapp.presentation.artist.ArtistActivity;
import com.geektech.lastfmapp.presentation.artist.ArtistPresenter;
import com.geektech.lastfmapp.presentation.topartists.recycler.TopArtistViewHolder;
import com.geektech.lastfmapp.presentation.topartists.recycler.TopArtistsAdapter;
import com.geektech.lastfmapp.presentation.toptracks.TopTracksFragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TopArtistsFragment extends CoreMvpFragment<ITopArtistsContract.Presenter>
    implements ITopArtistsContract.View, TopArtistViewHolder.TopArtistClickListener {

    public static TopArtistsFragment newInstance(){
        return new TopArtistsFragment();
    }

    TopArtistsAdapter mAdapter;
    RecyclerView recyclerView;
    private SwipeRefreshLayout mRefresh;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_top_artists;
    }

    @Override
    protected void initView(View view) {
        mRefresh=view.findViewById(R.id.refresh_top_artists);
        mRefresh.setOnRefreshListener(() -> refreshArtists());

        recyclerView=view.findViewById(R.id.recycler_top_artists);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter=new TopArtistsAdapter(this,new ArrayList<>());
        recyclerView.setAdapter(mAdapter);
    }

    private void refreshArtists() {
        if (presenter != null) {
            presenter.getArtists();
        }
    }

    @Override
    public void showArtists(List<ArtistEntity> artists) {
        mAdapter.setArtists(artists);
    }

    @Override
    public void openArtistDetails(ArtistEntity artist) {
        if(getActivity() != null){
            ArtistActivity.start(getActivity(),artist.getName());
        }
    }

    @Override
    public void startRefresh() {
        if (mRefresh != null) {
            mRefresh.setRefreshing(true);
        }
    }

    @Override
    public void stopRefresh() {
        if (mRefresh != null) {
            mRefresh.setRefreshing(false);
        }
    }

    @Override
    public void onArtistClick(int position) {
        if(presenter != null){
            presenter.onArtistClick(position);
        }
    }
}
