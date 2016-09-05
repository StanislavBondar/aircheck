package ua.cooperbroth.aircheck.view.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import javax.inject.Inject;

import butterknife.Bind;
import ua.cooperbroth.aircheck.R;
import ua.cooperbroth.aircheck.dagger.components.DaggerViewComponent;
import ua.cooperbroth.aircheck.dagger.components.DataServiceComponent;
import ua.cooperbroth.aircheck.dagger.components.ViewComponent;
import ua.cooperbroth.aircheck.dagger.module.ViewModule;
import ua.cooperbroth.aircheck.presenter.IMainActivityPresenter;
import ua.cooperbroth.aircheck.view.IMainActivityView;
import ua.cooperbroth.aircheck.view.fragment.LoginFragment;
import ua.cooperbroth.aircheck.view.fragment.MainFragment;
/**
 * @author Stas
 * @since 23.04.16.
 */
public class MainActivity extends BaseActivity implements IMainActivityView,
        NavigationView.OnNavigationItemSelectedListener {

    public static final int CONTAINER_ID = R.id.content_fragment;

    private MainFragment mMainFragment;

    @Inject
    IMainActivityPresenter mPresenter;
    private Fragment mainFragment;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @Bind(R.id.nav_view)
    NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            mPresenter.onCreate();
        }
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
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onBackPressed() {
        mPresenter.onBackPressed();
    }

    @Override
    public void popFragmentFromStack() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            FragmentManager fm = getSupportFragmentManager();
            fm.popBackStack();
            if (fm.getBackStackEntryCount() == 1) {
                super.onBackPressed();
            }
        }
    }

    @Override
    public void showHello() {
        getSupportFragmentManager().beginTransaction()
                .replace(CONTAINER_ID, getMainFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void initMenu() {

        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                MainActivity.this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(MainActivity.this);


    }

    @Override
    public void showLoginFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(CONTAINER_ID, LoginFragment.getInstance())
                .addToBackStack(null)
                .commit();
    }


    private Fragment getMainFragment() {
        if (mMainFragment == null) {
            mMainFragment = MainFragment.getInstance();
        }
        return mMainFragment;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.nav_manage:
                mPresenter.goToAccScreen();
                break;
            case R.id.nav_search:
                mPresenter.onCreate();
                break;
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}