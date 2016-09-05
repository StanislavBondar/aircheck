package ua.cooperbroth.aircheck.dagger.components;

import dagger.Component;
import ua.cooperbroth.aircheck.dagger.DataScope;
import ua.cooperbroth.aircheck.dagger.module.DataServiceModule;
import ua.cooperbroth.aircheck.data.ChartProvider;
import ua.cooperbroth.aircheck.data.DataProvider;
/**
 * @author Stas
 * @since 23.04.16.
 */
@DataScope
@Component(
        dependencies = NetComponent.class,
        modules = DataServiceModule.class
)
public interface DataServiceComponent {

    DataProvider getDataProvider();
    ChartProvider getChartProvider();

}