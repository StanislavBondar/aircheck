package ua.cooperbroth.aircheck.data.net;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import ua.cooperbroth.aircheck.data.Callback;
import ua.cooperbroth.aircheck.data.IChartProvider;
import ua.cooperbroth.aircheck.data.model.ChartData;
import ua.cooperbroth.aircheck.data.net.api.AircheckService;

/**
 * @author Stas
 * @since 23.04.16.
 */
public class ChartDataProvider implements IChartProvider {

    private Retrofit mRetrofit;

    private AircheckService mService;

    public ChartDataProvider(Retrofit retrofit) {
        mRetrofit = retrofit;
        mService = mRetrofit.create(AircheckService.class);
    }

    @Override
    public void textRequest(final Callback<ChartData> callback, String text) {
        Call mCall = mService.getChartData(text);
        mCall.enqueue(new retrofit2.Callback<ChartData>() {
            @Override
            public void onResponse(Response<ChartData> response) {
                ChartData queries = response.body();
                if (queries != null) {
                    //Returning data immediately to show it to user and after that launching service in foreground to cache it
                    callback.onDataReceived(queries);
                } else {
                    callback.onDataReceived(null);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }
}
