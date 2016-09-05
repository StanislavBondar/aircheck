package ua.cooperbroth.aircheck.presenter.impl;

import android.content.Context;
import android.content.Intent;

import ua.cooperbroth.aircheck.presenter.IFirstFragmentPresenter;
import ua.cooperbroth.aircheck.view.IMainActivityView;
import ua.cooperbroth.aircheck.view.activity.MenuActivity;

/**
 * @author Stas
 * @since 23.04.16.
 */
public class FirstFragmentPresenter implements IFirstFragmentPresenter {

    public FirstFragmentPresenter(IMainActivityView view) {

    }

    @Override
    public void onGoButtonPressed(Context context) {


        Intent mIntent = new Intent(context, MenuActivity.class);
        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(mIntent);
    }

    @Override
    public void onSearchButtonPressed() {

    }
}
