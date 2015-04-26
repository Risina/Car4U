package client.cfu.com.cfuandroidclient.util;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

import client.cfu.com.cfuandroidclient.R;
import client.cfu.com.constants.CFConstants;

/**
 * Created by Risina on 4/26/15.
 */
public class LocationAdapter extends ArrayAdapter<JSONObject> {
    private List<JSONObject> list;
    Context context;
    int currentLocationId = 0;

    private static class ViewHolder {
        private TextView itemView;
    }

    public LocationAdapter(Context context, int textViewResourceId, List<JSONObject> items) {
        super(context, textViewResourceId, items);
        this.context = context;
        this.list = items;
    }

    public int getId() {
        return currentLocationId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if(v == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.minor_data_list, null);

        }

        if(list.get(position) != null){
            TextView textView = (TextView)v.findViewById(R.id.txt);
            try {
                textView.setText((String)list.get(position).get("locationString"));
                currentLocationId = Integer.parseInt(list.get(position).get("id").toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return v;
    }
}
