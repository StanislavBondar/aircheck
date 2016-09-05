package ua.cooperbroth.aircheck.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Stas
 * @since 23.04.16.
 */
public class Query implements Parcelable {

    @SerializedName("text")
    @Expose
    private String mText;

    @SerializedName("query_type")
    @Expose
    private String mQueryType;

    @SerializedName("token")
    @Expose
    private String mToken;


    public Query(Parcel in) {
        mText = in.readString();
        mQueryType = in.readString();
        mToken = in.readString();
    }

    public Query(String text, String queryType, String token) {
        mText = text;
        mQueryType = queryType;
        mToken = token;
    }

    public String getText() {
        return mText;
    }

    public String getQueryType() {
        return mQueryType;
    }

    public String getToken() {
        return mToken;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mText);
        dest.writeString(mQueryType);
        dest.writeString(mToken);
    }

    public static final Creator<Query> CREATOR = new Creator<Query>() {
        @Override
        public Query createFromParcel(Parcel in) {
            return new Query(in);
        }

        @Override
        public Query[] newArray(int size) {
            return new Query[size];
        }
    };
}
