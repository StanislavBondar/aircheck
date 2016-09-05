package ua.cooperbroth.aircheck.dagger.module;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import ua.cooperbroth.aircheck.data.ChartProvider;
import ua.cooperbroth.aircheck.data.DataProvider;
import ua.cooperbroth.aircheck.data.net.ChartDataProvider;
import ua.cooperbroth.aircheck.data.net.NetDataProvider;
/**
 * @author Stas
 * @since 23.04.16.
 */
@Module()
public class DataServiceModule {

    @Provides
    DataProvider getDataService(NetDataProvider netDataProvider) {
        return new DataProvider(netDataProvider);
    }

    @Provides
    NetDataProvider getNetDataProvider(Retrofit retrofit) {
        return new NetDataProvider(retrofit);
    }

    @Provides
    ChartProvider getChartService(ChartDataProvider chartDataProvider) {
        return new ChartProvider(chartDataProvider);
    }

    @Provides
    ChartDataProvider getChartDataProvider(Retrofit retrofit) {
        return new ChartDataProvider(retrofit);
    }

}