package ua.cooperbroth.aircheck.app;

/**
 * @author Stas
 * @since 23.04.16.
 *
 * Class provides information about service API.
 */
public class ApiHelper {

    /**
     * Получение возможных запросов по тексту:
     * https://aircheck-api-module-dot-cooperbroth-aircheck.appspot.com/api/aircheck/query?query=text
     */
    public static final String API_QUERY_URL = "https://aircheck-api-module-dot-cooperbroth-aircheck.appspot.com/";
    /**
     * Получение данных по запросу
     * https://aircheck-processor-module-dot-cooperbroth-aircheck.appspot.com/api/aircheck/chart-data?query_token=token
     */
    public static final String API_DATA_URL = "https://aircheck-processor-module-dot-cooperbroth-aircheck.appspot.com/";
    /**
     * Авторизация пользователей в сервисе Health
     * https://cooperbroth-aircheck.appspot.com/api/aircheck/health/auth?access_token=token
     */
    public static final String API_HEALTH_URL = "https://cooperbroth-aircheck.appspot.com/";

}