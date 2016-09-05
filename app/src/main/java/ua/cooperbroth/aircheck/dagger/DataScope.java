package ua.cooperbroth.aircheck.dagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;
/**
 * @author Stas
 * @since 23.04.16.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface DataScope {
}
