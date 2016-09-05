package ua.cooperbroth.aircheck.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ua.cooperbroth.aircheck.R;
import ua.cooperbroth.aircheck.data.model.Query;

/**
 * @author Stas
 * @since 23.04.16.
 */
public class AdapterQueryList extends ArrayAdapter<Query> {

    List<Query> mQueries;

    public AdapterQueryList(Context context, int resource, List<Query> objects) {
        super(context, resource, objects);
        mQueries = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = View.inflate(getContext(), R.layout.query_item, null);
        }
        ((TextView)convertView.findViewById(R.id.query_item))
                .setText(((Query)mQueries.get(position)).getText());

        return convertView;
    }
}
