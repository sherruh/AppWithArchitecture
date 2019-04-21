package com.geektech.lastfmapp.presentation.basecontracts;

public interface BaseView {

    void finishView();

    void attachPresenter(BasePresenter presenter);
}
