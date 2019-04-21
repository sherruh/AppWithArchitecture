package com.geektech.lastfmapp.presentation.basecontracts;

public interface BasePresenter {

    void attachView(BaseView view);

    void detachView();
}
