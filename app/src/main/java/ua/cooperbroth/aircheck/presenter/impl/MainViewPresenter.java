package ua.cooperbroth.aircheck.presenter.impl;

import android.util.Log;

import java.util.List;

import ua.cooperbroth.aircheck.app.AircheckApplication;
import ua.cooperbroth.aircheck.data.Callback;
import ua.cooperbroth.aircheck.data.model.ChartData;
import ua.cooperbroth.aircheck.data.model.Query;
import ua.cooperbroth.aircheck.presenter.IMainViewPresenter;
import ua.cooperbroth.aircheck.view.IMainView;
/**
 * @author Stas
 * @since 23.04.16.
 */
public class MainViewPresenter implements IMainViewPresenter {

    private IMainView mView;

    public MainViewPresenter(IMainView view) {
        mView = view;
    }

    @Override
    public void onGoButtonPressed() {
        mView.showChartFragment();
    }

    @Override
    public void onSearchButtonPressed() {
        mView.startMenuActivity();
    }

    @Override
    public void dataLoad(String text) {
        AircheckApplication.getInstance()
                .getDataServiceComponent()
                .getDataProvider()
                .textRequest(new Callback<List<Query>>() {
                    @Override
                    public void onDataReceived(List<Query> data) {

                        for (Query mQuery : data) {
                            System.out.println("RESPONSE ==  " + mQuery.getText()
                                    + "    " + mQuery.getQueryType() + "      "
                                    + mQuery.getToken());
                        }
                        mView.updateQueryList(data);

                    }

                    @Override
                    public void onError(String e) {
                        Log.e(getClass().getName(), "SUKA ERROR  " + e);
                    }
                }, text);
    }

    @Override
    public void setQueryText(String text) {
        mView.setSearchText(text);
    }

    @Override
    public void loadChart(String token) {
        AircheckApplication.getInstance()
                .getChartServiceComponent()
                .getChartProvider()
                .textRequest(new Callback<ChartData>() {
                    @Override
                    public void onDataReceived(ChartData data) {


                        System.out.println("RESPONSE ==  " + data);

                        mView.chartDataLoaded(data);

                    }

                    @Override
                    public void onError(String e) {
                        Log.e(getClass().getName(), "SUKA ERROR  " + e);
                    }
                }, token);
    }
}