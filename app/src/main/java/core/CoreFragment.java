package core;

import android.support.v4.app.Fragment;

public class CoreFragment<T extends ICoreMvpContract.Presenter>
        extends Fragment {

    public T mPresenter;

}
