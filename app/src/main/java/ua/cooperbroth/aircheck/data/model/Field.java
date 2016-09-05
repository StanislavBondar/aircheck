package ua.cooperbroth.aircheck.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Stas
 * @since 24.04.16.
 */
public class Field {

    @SerializedName("unit")
    @Expose
    private String unit;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("type")
    @Expose
    private String type;

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getUnit() {
        return unit;
    }
}
