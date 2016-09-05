package ua.cooperbroth.aircheck.view;

import java.util.List;

import ua.cooperbroth.aircheck.data.model.ChartData;
import ua.cooperbroth.aircheck.data.model.Query;
/**
 * @author Stas
 * @since 23.04.16.
 */
public interface IMainView {
    void startMenuActivity();
    void showChartFragment();
    void setSearchText(String text);
    void updateQueryList(List<Query> query);
    void chartDataLoaded(ChartData chartData);
}