package ua.cooperbroth.aircheck.dagger.components;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import ua.cooperbroth.aircheck.dagger.module.AppModule;
/**
 * @author Stas
 * @since 23.04.16.
 */
@Singleton
@Component(
        modules = {
                AppModule.class
        }
)
public interface AppComponent {

    Application getApp();

    Context getContext();

}