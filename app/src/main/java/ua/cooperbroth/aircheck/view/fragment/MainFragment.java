package ua.cooperbroth.aircheck.view.fragment;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import ua.cooperbroth.aircheck.R;
import ua.cooperbroth.aircheck.adapter.AdapterQueryList;
import ua.cooperbroth.aircheck.dagger.components.DaggerViewComponent;
import ua.cooperbroth.aircheck.dagger.components.DataServiceComponent;
import ua.cooperbroth.aircheck.dagger.components.ViewComponent;
import ua.cooperbroth.aircheck.dagger.module.ViewModule;
import ua.cooperbroth.aircheck.data.model.ChartData;
import ua.cooperbroth.aircheck.data.model.Query;
import ua.cooperbroth.aircheck.presenter.IMainViewPresenter;
import ua.cooperbroth.aircheck.view.IMainView;
import ua.cooperbroth.aircheck.view.activity.MainActivity;
/**
 * @author Stas
 * @since 23.04.16.
 */
public class MainFragment extends BaseFragment implements IMainView,
        OnClickListener, SearchView.OnQueryTextListener,
        AdapterView.OnItemClickListener{

    @Inject
    IMainViewPresenter mPresenter;

    @Bind(R.id.query_list)
    ListView mQueryList;

    private AdapterQueryList mListAdapter;
    private SearchView mSearchView = null;


    public static MainFragment getInstance() {

        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    protected void updateView(View view) {
        mQueryList.setOnItemClickListener(this);
        setHasOptionsMenu(true);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
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
        switch (v.getId()) {
            case R.id.action_search:
                mPresenter.dataLoad("");
                break;

        }
    }

    @Override
    public void startMenuActivity() {
       /* Intent mIntent = new Intent(getActivity(), MenuActivity.class);
        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getActivity().startActivity(mIntent);*/


    }

    @Override
    public void showChartFragment() {
       /* getActivity().getSupportFragmentManager().beginTransaction()
                .replace(MainActivity.CONTAINER_ID, ChartFragment.getInstance())
                .commit();*/
    }

    @Override
    public void updateQueryList(List<Query> query) {
        if (mListAdapter != null) {
            mListAdapter = null;
        }
        mListAdapter = new AdapterQueryList(getActivity(), android.R.layout.simple_list_item_1, query);
        mQueryList.setAdapter(mListAdapter);
    }

    @Override
    public void chartDataLoaded(ChartData chartData) {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(MainActivity.CONTAINER_ID, ChartFragment.getInstance(chartData))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);

        if (searchItem != null) {
            mSearchView = (SearchView) searchItem.getActionView();
        }
        if (mSearchView != null) {
            mSearchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
            mSearchView.setOnQueryTextListener(this);
            mSearchView.setOnClickListener(this);
        }
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        //todo send query
        return false;
    }

    @Override
    public void setSearchText(String text) {
        mSearchView.setQuery(text, true);
    }
    @Override
    public boolean onQueryTextChange(String newText) {

        mPresenter.dataLoad(newText);

        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mPresenter.setQueryText((mListAdapter.getItem(position)).getText());
        mPresenter.loadChart(mListAdapter.getItem(position).getToken());
        mListAdapter.clear();
        mListAdapter.notifyDataSetChanged();
    }
}