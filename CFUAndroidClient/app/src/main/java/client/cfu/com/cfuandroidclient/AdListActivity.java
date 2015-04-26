package client.cfu.com.cfuandroidclient;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import client.cfu.com.cfuandroidclient.util.AdAdapter;
import client.cfu.com.cfubase.CFAdvertisementDataHandler;
import client.cfu.com.cfubase.CFMinorDataHandler;
import client.cfu.com.cfubase.entities.CFAdvertisement;
import client.cfu.com.util.CFPopupHelper;


public class AdListActivity extends BaseActivity {

    String[] currency;
    int[] flags;
    String[] countries;
    public ArrayList<String> locations;
    private List<String> vehicleTypes;
    private List<String> brands;
    private List<String> bodyTypes;
    private List<String> transmissionTypes;
    private List<String> conditions;
    private List<String> fuelTypes;
    private ProgressBar spinner;
    List<CFAdvertisement> adList;

    private static final String LOCATION = "1";
    private static final String VEHICLE_TYPE = "2";
    private static final String BRAND = "3";
    private static final String BODY_TYPE = "4";
    private static final String TRANSMISSION_TYPE = "5";
    private static final String CONDITION = "6";
    private static final String FUEL_TYPE = "7";
    private static final int LOCATION_REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.activity_open_translate,R.anim.activity_close_scale);
        setContentView(R.layout.activity_ad_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        CFPopupHelper.showProgressSpinner(this, View.VISIBLE);

        DataAsyncTask asyncTask = new DataAsyncTask();
        asyncTask.execute();
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        //closing transition animations
        overridePendingTransition(R.anim.activity_open_scale,R.anim.activity_close_translate);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            Intent intent = new Intent(this, FrontActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    private void createList() {
        AdAdapter adAdapter = new AdAdapter(getBaseContext(), R.layout.ad_list, adList);
        ListView listView = (ListView) findViewById(R.id.listview);

        listView.setAdapter(adAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                loadAdvertisement(position);
            }
        });

    }

    private void loadAdvertisement(int position) {
        Intent intent = new Intent(this, AdViewActivity.class);
        intent.putExtra("advertisement", adList.get(position).toJson());
        startActivity(intent);
    }

    private class DataAsyncTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(String... params) {
//            vehicleTypes = CFMinorDataHandler.getVehicleTypes();
//            brands = CFMinorDataHandler.getBrands();
//            bodyTypes = CFMinorDataHandler.getBodyTypes();
//            transmissionTypes = CFMinorDataHandler.getTransmissionTypes();
//            conditions = CFMinorDataHandler.getConditions();
//            fuelTypes = CFMinorDataHandler.getFuelTypes();

            CFAdvertisementDataHandler adh = new CFAdvertisementDataHandler();
            adList = adh.getAdvertisements();
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            createList();
//            CFPopupHelper.showProgressSpinner(AdListActivity.this, View.GONE);
//            spinner.setVisibility(View.GONE);
        }
    }


}
