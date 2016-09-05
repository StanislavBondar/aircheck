package ua.cooperbroth.aircheck.view.fragment;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.Bind;
import ua.cooperbroth.aircheck.R;
import ua.cooperbroth.aircheck.dagger.components.DaggerViewComponent;
import ua.cooperbroth.aircheck.dagger.components.DataServiceComponent;
import ua.cooperbroth.aircheck.dagger.components.ViewComponent;
import ua.cooperbroth.aircheck.dagger.module.ViewModule;
import ua.cooperbroth.aircheck.presenter.ILoginFragmentPresenter;
import ua.cooperbroth.aircheck.view.ILoginFragmentView;

/**
 * @author Stas
 * @since 23.04.16.
 */
public class LoginFragment extends BaseFragment implements ILoginFragmentView,
        View.OnClickListener{

    @Inject
    ILoginFragmentPresenter mPresenter;

    @Bind(R.id.login)
    EditText mLogin;
    @Bind(R.id.password)
    EditText mPassword;
    @Bind(R.id.login_button)
    Button mLoginButton;
    @Bind(R.id.myCoordinatorLayout)
    CoordinatorLayout mCoordinatorLayout;

    private View mView;

    public static LoginFragment getInstance() {

        return new LoginFragment();
    }

    @Override
    protected void updateView(View view) {
        mLoginButton.setOnClickListener(this);
        mView = view;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void setUpComponent(DataServiceComponent component) {
        ViewComponent viewComponent = DaggerViewComponent.builder()
                .dataServiceComponent(component)
                .viewModule(new ViewModule(this))
                .build();

        viewComponent.inject(this);
    }

    @Override
    public void onClick(View v) {
        mPresenter.onLoginPressed(mLogin.getText().toString(),
                mPassword.getText().toString());
    }

    @Override
    public boolean verifyLogin(String login) {
        return mPresenter.loginRegex(login);
    }

    @Override
    public boolean verifyPass(String pass) {
        return mPresenter.passRegex(pass);
    }

    @Override
    public void showSnackBar(int textResource) {
        String mMessage = getResources().getString(textResource);
        Snackbar.make(mCoordinatorLayout, mMessage, Snackbar.LENGTH_LONG)
                .setAction("CLOSE", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                })
                .setActionTextColor(getResources().getColor(android.R.color.holo_red_light))
                .show();
    }
}
