package ua.cooperbroth.aircheck.data;

import java.util.List;

import ua.cooperbroth.aircheck.data.model.Query;
import ua.cooperbroth.aircheck.data.net.NetDataProvider;

/**
 * Provides data from different sources, depends on internet connection
 */
public class DataProvider implements IDataProvider {

    private NetDataProvider mNetProvider;

    public DataProvider(NetDataProvider netDataProvider) {
        mNetProvider = netDataProvider;
    }

    @Override
    public void textRequest(Callback<List<Query>> callback, String text) {
        mNetProvider.textRequest(callback, text);
    }
}