package ua.cooperbroth.aircheck.dagger.module;

import dagger.Module;
import dagger.Provides;
import ua.cooperbroth.aircheck.presenter.IChartFragmentPresenter;
import ua.cooperbroth.aircheck.presenter.ILoginFragmentPresenter;
import ua.cooperbroth.aircheck.presenter.IMainActivityPresenter;
import ua.cooperbroth.aircheck.presenter.IMainViewPresenter;
import ua.cooperbroth.aircheck.presenter.impl.ChartFragmentPresenter;
import ua.cooperbroth.aircheck.presenter.impl.LoginFragmentPresenter;
import ua.cooperbroth.aircheck.presenter.impl.MainActivityPresenter;
import ua.cooperbroth.aircheck.presenter.impl.MainViewPresenter;
import ua.cooperbroth.aircheck.view.IChartFragmentView;
import ua.cooperbroth.aircheck.view.ILoginFragmentView;
import ua.cooperbroth.aircheck.view.IMainActivityView;
import ua.cooperbroth.aircheck.view.IMainView;

/**
 * @author Stas
 * @since 23.04.16.
 * <p>
 * One module for all views
 */
@Module
public class ViewModule {

    private IMainActivityView mMainActivityView;

    private IMainView mMainView;

    private IChartFragmentView mChartFragment;

    private ILoginFragmentView mLoginFragmentView;

    public ViewModule(IMainActivityView view) {
        this.mMainActivityView = view;
    }

    public ViewModule(ILoginFragmentView view) {
        mLoginFragmentView = view;
    }

    public ViewModule(IMainView view) {
        mMainView = view;
    }

    public ViewModule(IChartFragmentView view) {
        mChartFragment = view;
    }

    @Provides
    public IMainActivityView getMainActivityView() {
        return mMainActivityView;
    }

    @Provides
    public IMainView getMainView() {
        return mMainView;
    }

    @Provides
    public IChartFragmentView getChartFragment() {
        return mChartFragment;
    }

    @Provides
    public ILoginFragmentView getLoginFragment() {
        return mLoginFragmentView;
    }

    @Provides
    public IMainActivityPresenter getMainActivityPresenter(IMainActivityView view) {
        return new MainActivityPresenter(view);
    }

    @Provides
    public IMainViewPresenter getMainPresenter(IMainView view) {
        return new MainViewPresenter(view);
    }

    @Provides
    public IChartFragmentPresenter getChartFragmentPresenter(IChartFragmentView view) {
        return new ChartFragmentPresenter(view);
    }

    @Provides
    public ILoginFragmentPresenter getLoginFragmentPresenter(ILoginFragmentView view) {
        return new LoginFragmentPresenter(view);
    }
}