package client.cfu.com.cfuandroidclient.util;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import client.cfu.com.cfuandroidclient.R;

/**
 * Created by Risina on 4/12/15.
 */
public class AccountMentFragment extends Fragment {

    View rootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.account_menu ,container, false);

        return rootView;
    }
}
