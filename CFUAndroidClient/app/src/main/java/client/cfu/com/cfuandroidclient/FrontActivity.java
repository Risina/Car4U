package client.cfu.com.cfuandroidclient;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.ArrayList;

import client.cfu.com.cfubase.CFAdvertisementDataHandler;
import client.cfu.com.cfubase.CFMinorDataHandler;


public class FrontActivity extends ActionBarActivity {


    public ArrayList<String> locations;
    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.activity_open_translate,R.anim.activity_close_scale);
        setContentView(R.layout.activity_front);
        LocationAsyncTask locationAsyncTask = new LocationAsyncTask();
        locationAsyncTask.execute();

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadAdvertisements();
            }
        });
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        overridePendingTransition(R.anim.activity_open_scale,R.anim.activity_close_translate);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_front, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadLocations() {
        SharedPreferences preferences = getSharedPreferences("com.cfu.location", MODE_PRIVATE);
        int location = preferences.getInt("location", 0);
        if (location == 0) {
            Intent intent = new Intent(this, LocationActivity.class);
            intent.putStringArrayListExtra("locations", locations);
            startActivity(intent);
        }
    }

    private void loadAdvertisements() {

        Intent intent = new Intent(this, AdListActivity.class);
//        intent.putStringArrayListExtra("locations", locations);
        startActivity(intent);

    }

    private class LocationAsyncTask extends AsyncTask<String, String, String> {

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
//            loadLocations();
//            spinner.setVisibility(View.GONE);
        }
    }

}
