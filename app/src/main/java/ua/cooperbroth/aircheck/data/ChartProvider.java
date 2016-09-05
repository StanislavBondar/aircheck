package ua.cooperbroth.aircheck.data;

import ua.cooperbroth.aircheck.data.model.ChartData;
import ua.cooperbroth.aircheck.data.net.ChartDataProvider;

/**
 * @author Stas
 * @since 23.04.16.
 */
public class ChartProvider implements IChartProvider {

    private ChartDataProvider mChartProvider;

    public ChartProvider(ChartDataProvider chartDataProvider) {
        mChartProvider = chartDataProvider;
    }

    @Override
    public void textRequest(Callback<ChartData> callback, String text) {
        mChartProvider.textRequest(callback, text);
    }
}
