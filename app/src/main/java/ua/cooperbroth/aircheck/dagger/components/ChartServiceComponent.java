package ua.cooperbroth.aircheck.dagger.components;

import dagger.Component;
import ua.cooperbroth.aircheck.dagger.DataScope;
import ua.cooperbroth.aircheck.dagger.module.ChartServiceModule;
import ua.cooperbroth.aircheck.data.ChartProvider;

/**
 * @author Stas
 * @since 24.04.16.
 */
@DataScope
@Component(
        dependencies = NetComponent.class,
        modules = ChartServiceModule.class
)
public interface ChartServiceComponent {
    ChartProvider getChartProvider();
}
