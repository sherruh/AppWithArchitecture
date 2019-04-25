package core;

import android.support.v4.app.Fragment;

public class CoreFragment extends Fragment implements ICoreMvpContract.View {
    ICoreMvpContract.Presenter mPresenter;

    @Override
    public void attachPresenter(ICoreMvpContract.Presenter presenter) {
        mPresenter=presenter;
        mPresenter.attachView(this);
    }

    @Override
    public void finishView() {
        getActivity().finish();
    }
}
