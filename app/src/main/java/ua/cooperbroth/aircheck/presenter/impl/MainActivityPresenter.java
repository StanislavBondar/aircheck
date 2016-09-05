package ua.cooperbroth.aircheck.presenter.impl;

import ua.cooperbroth.aircheck.presenter.IMainActivityPresenter;
import ua.cooperbroth.aircheck.view.IMainActivityView;
/**
 * @author Stas
 * @since 23.04.16.
 */
public class MainActivityPresenter implements IMainActivityPresenter {

    private IMainActivityView mView;

    public MainActivityPresenter(IMainActivityView view) {
        mView = view;
    }

    @Override
    public void onBackPressed() {
        mView.popFragmentFromStack();
    }

    @Override
    public void onCreate() {
        mView.showHello();
        mView.initMenu();
    }

    @Override
    public void goToAccScreen() {
        mView.showLoginFragment();
    }

}