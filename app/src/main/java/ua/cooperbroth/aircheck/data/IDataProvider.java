package ua.cooperbroth.aircheck.data;

import java.util.List;

import ua.cooperbroth.aircheck.data.model.Query;

/**
 * @author Stas
 * @since 23.04.16.
 *
 * Data provider. Every method have additional callback parameter for async load
 */
public interface IDataProvider {

    void textRequest(Callback<List<Query>> callback, String text);

}