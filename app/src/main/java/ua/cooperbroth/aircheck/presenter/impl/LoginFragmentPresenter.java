package ua.cooperbroth.aircheck.presenter.impl;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ua.cooperbroth.aircheck.R;
import ua.cooperbroth.aircheck.presenter.ILoginFragmentPresenter;
import ua.cooperbroth.aircheck.view.ILoginFragmentView;

/**
 * @author Stas
 * @since 23.04.16.
 */
public class LoginFragmentPresenter implements ILoginFragmentPresenter{

    private ILoginFragmentView mLoginFragmentView;

    public LoginFragmentPresenter(ILoginFragmentView view) {
        mLoginFragmentView = view;
    }

    @Override
    public void onLoginPressed(String login, String pass) {

        if (!mLoginFragmentView.verifyLogin(login)) {
            mLoginFragmentView.showSnackBar(R.string.incorrect_login);
            return;
        }
        if(!mLoginFragmentView.verifyPass(pass)) {
            mLoginFragmentView.showSnackBar(R.string.incorrect_password);
            return;
        }

        sendLoginData(login, pass);
    }

    @Override
    public boolean loginRegex(String login) {
        return !TextUtils.isEmpty(login) && android.util.Patterns.EMAIL_ADDRESS.matcher(login).matches();
    }

    @Override
    public boolean passRegex(String pass) {
        Pattern mPattern;
        Matcher mMatcher;

        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{4,}$";

        mPattern = Pattern.compile(PASSWORD_PATTERN);
        mMatcher = mPattern.matcher(pass);

        return mMatcher.matches();
    }


    private void sendLoginData(String login, String pass) {

    }
}
