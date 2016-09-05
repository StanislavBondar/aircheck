package ua.cooperbroth.aircheck.data;

import ua.cooperbroth.aircheck.data.model.ChartData;

/**
 * @author Stas
 * @since 23.04.16.
 */
public interface IChartProvider {
    void textRequest(Callback<ChartData> callback, String text);
}
