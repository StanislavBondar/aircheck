package ua.cooperbroth.aircheck.data;

/**
 * @author Stas
 * @since 23.04.16.
 *
 * Слушатель на получение данных от какого либо сервиса данных
 *
 * @param <T>
 */
public interface Callback<T> {

    void onDataReceived(T data);

    void onError(String e);

}