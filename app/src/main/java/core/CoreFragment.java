package core;

import android.support.v4.app.Fragment;

public class CoreFragment<T extends ICoreMvpContract.Presenter>
        extends Fragment {

    T mPresenter;

    public void attachPresent(T presenter){
        mPresenter=presenter;
        mPresenter.attachView(I);
    }



}
