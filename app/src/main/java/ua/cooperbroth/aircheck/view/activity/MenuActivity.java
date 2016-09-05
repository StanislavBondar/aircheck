package ua.cooperbroth.aircheck.view.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.Bind;
import ua.cooperbroth.aircheck.R;
import ua.cooperbroth.aircheck.dagger.components.DaggerViewComponent;
import ua.cooperbroth.aircheck.dagger.components.DataServiceComponent;
import ua.cooperbroth.aircheck.dagger.components.ViewComponent;
import ua.cooperbroth.aircheck.dagger.module.ViewModule;
import ua.cooperbroth.aircheck.view.IMenuActivityView;
/**
 * @author Stas
 * @since 23.04.16.
 */
public class MenuActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, IMenuActivityView {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @Bind(R.id.nav_view)
    NavigationView mNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setSupportActionBar(mToolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(this);
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
        return R.layout.activity_menu;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_manage) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void popFragmentFromStack() {

    }

    @Override
    public void showHello() {

    }

    @Override
    public void initMenu() {

    }

    @Override
    public void showLoginFragment() {

    }
}
