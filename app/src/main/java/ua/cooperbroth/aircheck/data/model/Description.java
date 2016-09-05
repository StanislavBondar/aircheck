package ua.cooperbroth.aircheck.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Stas
 * @since 23.04.16.
 */
public class Description {

    @SerializedName("paginationToken")
    @Expose
    private String paginationToken;

    @SerializedName("query")
    @Expose
    private String query;

    @SerializedName("query_type")
    @Expose
    private String queryType;

    public String getPaginationToken() {
        return paginationToken;
    }

    public String getQuery() {
        return query;
    }

    public String getQueryType() {
        return queryType;
    }
}
