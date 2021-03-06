package ua.cooperbroth.aircheck.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import ua.cooperbroth.aircheck.app.AircheckApplication;
import ua.cooperbroth.aircheck.dagger.components.DataServiceComponent;
/**
 * @author Stas
 * @since 23.04.16.
 */
public abstract class BaseFragment extends Fragment {

    private View mRootView;

    private String mTitle;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(getLayoutId(), container, false);
            ButterKnife.bind(this, mRootView);
            setUpComponent(AircheckApplication.getInstance().getDataServiceComponent());
            updateView(mRootView);
        }
        return mRootView;
    }

    @Override
    public void onDestroyView() {
        if (mRootView.getParent() != null) {
            ((ViewGroup) mRootView.getParent()).removeView(mRootView);
        }
        super.onDestroyView();
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    protected abstract void updateView(View view);

    protected abstract int getLayoutId();

    protected abstract void setUpComponent(DataServiceComponent component);

}