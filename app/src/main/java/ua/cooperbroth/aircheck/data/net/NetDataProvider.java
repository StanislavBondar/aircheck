package ua.cooperbroth.aircheck.data.net;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import ua.cooperbroth.aircheck.data.Callback;
import ua.cooperbroth.aircheck.data.IDataProvider;
import ua.cooperbroth.aircheck.data.model.Query;
import ua.cooperbroth.aircheck.data.net.api.AircheckService;

/**
 * @author Stas
 * @since 23.04.16.
 *
 * Provides data from Internet
 */
public class NetDataProvider implements IDataProvider {

    private Retrofit mRetrofit;

    private AircheckService mService;

    public NetDataProvider(Retrofit retrofit) {
        mRetrofit = retrofit;
        mService = mRetrofit.create(AircheckService.class);
    }

    @Override
    public void textRequest(final Callback<List<Query>> callback, String text) {
        Call<List<Query>> call = mService.getQuery(text);
        call.enqueue(new retrofit2.Callback<List<Query>>() {
            @Override
            public void onResponse(Response<List<Query>> response) {
                List<Query> queries = response.body();
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