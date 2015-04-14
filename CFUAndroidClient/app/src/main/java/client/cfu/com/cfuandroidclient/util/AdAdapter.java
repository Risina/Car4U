package client.cfu.com.cfuandroidclient.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import client.cfu.com.cfuandroidclient.R;
import client.cfu.com.cfubase.entities.CFAdvertisement;
import client.cfu.com.constants.CFConstants;

/**
 * Created by Risina on 4/12/15.
 */
public class AdAdapter extends ArrayAdapter<CFAdvertisement> {

    private List<CFAdvertisement> adList;
    Context context;

    private static class ViewHolder {
        private TextView itemView;
    }

    public AdAdapter(Context context, int textViewResourceId, List<CFAdvertisement> items) {
        super(context, textViewResourceId, items);
        this.context = context;
        this.adList = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if(v == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.ad_list, null);

        }

        if(adList.get(position) != null){
            TextView textView = (TextView)v.findViewById(R.id.txt);
            textView.setText(adList.get(position).getDescription());

            ImageView imageView = (ImageView)v.findViewById(R.id.flag);
//            imageView.setImageResource(R.drawable.india);

            Picasso.with(context).load(CFConstants.SERVICE_ROOT+"CFUDBService/images/cfu/nepal.png").into(imageView);

        }
        return v;
    }
}
