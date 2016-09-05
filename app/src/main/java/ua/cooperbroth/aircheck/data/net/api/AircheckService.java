package ua.cooperbroth.aircheck.data.net.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ua.cooperbroth.aircheck.data.model.ChartData;
/**
 * @author Stas
 * @since 23.04.16.
 */
public interface AircheckService {

    @GET("api/aircheck/query")
    Call<List<ua.cooperbroth.aircheck.data.model.Query>> getQuery(@Query("query") String text);

    @GET("api/aircheck/chart-data")
    Call<ChartData> getChartData(@Query("query_token") String token);
/*
    @GET("/v2/listings/{listingId}")
    Call<Result<Listing>> getListing(@Path("listingId") long listingId, @Query("api_key") String apiKey);

https://aircheck-processor-module-dot-cooperbroth-aircheck.appspot.com/api/aircheck/chart-data?query_token=token
https://aircheck-api-module-dot-cooperbroth-aircheck.appspot.com/api/aircheck/chart-data?query_token=eyJhbGciOiJSUzI1NiJ9.eyJleHAiOjE0NjE0NTQ0OTksInN1YiI6IjAiLCJhdWQiOm51bGwsImlzcyI6ImFpcmNoZWNrIiwiaWF0IjoxNDYxNDUwODk5fQ.MHGltjetaN1QA26vsSYUhVu4T7ZuJcWEVyokanavH32ShhwA6Yz2GSZgMK2jz345GSSD0OWIw-FtBz2_YY_k2Ga1rHGUy-gAEzA0KH_yTX0Bya37onl4lB2wAXzCDdAAYPSANGPFfc7tgV3_a9i-rUzRTT_dE59hL0054V9kL_RYhnXPny0tzxxvnzPAEPQ0B97pHvC-QPhGhcRb2w14ObR9kGsR4eaXxD8-w-gf-REUxSX0FZ3WMsl1dVwB4Za-sWoLLa-YrcW77t4jCUseyMY2MuGGgC5lxvrkqAJHWO_sU0ZgWWlTs4T9MNNtHgVXa4zjQ5y6AHWWztYNEtN_1g (847ms, 775-byte body)



    @GET("/v2/listings/{listingId}/images")
    Call<Result<Image>> getListingImages(@Path("listingId") long listingId, @Query("api_key") String apiKey);

    @GET("/v2/listings/active")
    Call<Result<Listing>> getListings(@Query("api_key") String apiKey, @Query("category") String categoryName, @Query("keywords") String keywords);*/
}