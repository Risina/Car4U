package client.cfu.com.cfuandroidclient;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import client.cfu.com.cfubase.CFMinorDataHandler;
import client.cfu.com.util.CFPopupHelper;


public class LocationActivity extends Activity {

    List<String> locations = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        overridePendingTransition(R.anim.activity_open_translate,R.anim.activity_close_scale);

        CFPopupHelper.showProgressSpinner(this, View.VISIBLE);
        new LocationAsyncTask().execute();


    }

    @Override
    protected void onPause()
    {
        super.onPause();
        //closing transition animations
        overridePendingTransition(R.anim.activity_open_scale,R.anim.activity_close_translate);
    }

    public void loadLocations() {
//        Intent intent = getIntent();
//        List<String> locationList = intent.getStringArrayListExtra("locations");

        ListView listView = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, locations);
        listView.setAdapter(adapter);
        final Activity thisActivity = this;

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                SharedPreferences.Editor editor = getSharedPreferences("com.cfu.location", MODE_PRIVATE).edit();
//                editor.putInt("location", position);
//                editor.apply();
                Intent intent = new Intent(thisActivity, FrontActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_location, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class LocationAsyncTask extends AsyncTask<String, String, String> {
        Activity activity;


        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(String... params) {


            locations = new ArrayList<>(CFMinorDataHandler.getLocations());
//            vehicleTypes = CFMinorDataHandler.getVehicleTypes();
//            brands = CFMinorDataHandler.getBrands();
//            bodyTypes = CFMinorDataHandler.getBodyTypes();
//            transmissionTypes = CFMinorDataHandler.getTransmissionTypes();
//            conditions = CFMinorDataHandler.getConditions();
//            fuelTypes = CFMinorDataHandler.getFuelTypes();

//            CFAdvertisementDataHandler adh = new CFAdvertisementDataHandler();
//            adList = adh.getAdvertisements();
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            loadLocations();
            CFPopupHelper.showProgressSpinner(LocationActivity.this, View.GONE);
//            spinner.setVisibility(View.GONE);
        }
    }
}
