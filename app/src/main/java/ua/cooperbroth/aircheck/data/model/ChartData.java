package ua.cooperbroth.aircheck.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
/**
 * @author Stas
 * @since 23.04.16.
 */
public class ChartData {

    @SerializedName("description")
    @Expose
    private Description mDescription;

    @SerializedName("fields")
    @Expose
    private List<Field> mFields;

    @SerializedName("rows")
    @Expose
    private List<List<Object>> mRows;

    public Description getDescription() {
        return mDescription;
    }

    public List<Field> getFields() {
        return mFields;
    }

    public List<List<Object>> getRows() {
        return mRows;
    }
}