package ua.cooperbroth.aircheck.dagger.components;

import dagger.Component;
import ua.cooperbroth.aircheck.dagger.ActivityScope;
import ua.cooperbroth.aircheck.dagger.module.ViewModule;
import ua.cooperbroth.aircheck.view.activity.MainActivity;
import ua.cooperbroth.aircheck.view.activity.MenuActivity;
import ua.cooperbroth.aircheck.view.fragment.ChartFragment;
import ua.cooperbroth.aircheck.view.fragment.LoginFragment;
import ua.cooperbroth.aircheck.view.fragment.MainFragment;
/**
 * @author Stas
 * @since 23.04.16.
 */
@ActivityScope
@Component(
        dependencies = DataServiceComponent.class,
        modules = ViewModule.class
)
public interface ViewComponent {
    void inject(MainActivity view);
    void inject(MainFragment view);
    void inject(MenuActivity view);
    void inject(ChartFragment view);
    void inject(LoginFragment view);
}