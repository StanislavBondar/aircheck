package ua.cooperbroth.aircheck.dagger.module;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import ua.cooperbroth.aircheck.data.ChartProvider;
import ua.cooperbroth.aircheck.data.net.ChartDataProvider;

/**
 * @author Stas
 * @since 24.04.16.
 */
@Module
public class ChartServiceModule {
    @Provides
    ChartProvider getDataService(ChartDataProvider chartDataProvider) {
        return new ChartProvider(chartDataProvider);
    }

    @Provides
    ChartDataProvider getChartDataProvider(Retrofit retrofit) {
        return new ChartDataProvider(retrofit);
    }

}
