package ua.cooperbroth.aircheck.app;

import android.app.Application;
import android.content.Context;

import ua.cooperbroth.aircheck.dagger.components.AppComponent;
import ua.cooperbroth.aircheck.dagger.components.DaggerAppComponent;
import ua.cooperbroth.aircheck.dagger.components.DaggerDataServiceComponent;
import ua.cooperbroth.aircheck.dagger.components.DaggerNetComponent;
import ua.cooperbroth.aircheck.dagger.components.DataServiceComponent;
import ua.cooperbroth.aircheck.dagger.components.NetComponent;
import ua.cooperbroth.aircheck.dagger.module.AppModule;
import ua.cooperbroth.aircheck.dagger.module.DataServiceModule;
import ua.cooperbroth.aircheck.dagger.module.NetModule;
import ua.cooperbroth.aircheck.log.Logger;
/**
 * @author Stas
 * @since 23.04.16.
 */
public class AircheckApplication extends Application {

    private AppComponent mAppComponent;

    private DataServiceComponent mDataServiceComponent;

    private DataServiceComponent mChartServiceComponent;

    private static AircheckApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        setupGraph();
        Logger.buildLogger(getApplicationContext());
    }

    private void setupGraph() {
        AppModule appModule = new AppModule(this);

        mAppComponent = DaggerAppComponent.builder()
                .appModule(appModule)
                .build();

        NetComponent netComponent = DaggerNetComponent.builder()
                .appComponent(mAppComponent)
                .netModule(new NetModule(ApiHelper.API_QUERY_URL))
                .build();

        NetComponent chartDataComponent = DaggerNetComponent.builder()
                .appComponent(mAppComponent)
                .netModule(new NetModule(ApiHelper.API_DATA_URL))
                .build();

        mDataServiceComponent = DaggerDataServiceComponent.builder()
                .netComponent(netComponent)
                .dataServiceModule(new DataServiceModule())
                .build();

        mChartServiceComponent = DaggerDataServiceComponent.builder()
                .netComponent(chartDataComponent)
                .dataServiceModule(new DataServiceModule())
                .build();
    }

    public AppComponent getComponent() {
        return mAppComponent;
    }

    public DataServiceComponent getDataServiceComponent() {
        return mDataServiceComponent;
    }

    public DataServiceComponent getChartServiceComponent() {
        return mChartServiceComponent;
    }

    public static AircheckApplication getInstance() {
        return sInstance;
    }

    public static Context getContext() {
        return sInstance.getApplicationContext();
    }



}