package client.cfu.com.cfuandroidclient;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import client.cfu.com.cfubase.CFHttpManager;
import client.cfu.com.cfubase.CFMinorDataHandler;
import client.cfu.com.constants.CFConstants;
import client.cfu.com.util.CFPopupHelper;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni == null) {
            CFPopupHelper.alertHelper(this, getString(R.string.turn_on_internet)).show();
        } else {
            new ServerAvailabilityAsyncTask().execute();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void proceed(boolean isServerAvailable) {
        if (!isServerAvailable) {
            TextView textView = (TextView) findViewById(R.id.textView);
            CFPopupHelper.alertHelper(this, getString(R.string.connection_error)).show();
            textView.setText(getString(R.string.connection_failed));
        } else {
//            CFPopupHelper.showProgressSpinner(this, View.VISIBLE);
            new MinorDataAsyncTask().execute();
        }
    }

    private void startActivities()
    {
        SharedPreferences prefs = getSharedPreferences("com.cfu.location", MODE_PRIVATE);
        String location = prefs.getString("location", null);
        if (location == null) {
            Intent intent = new Intent(this, LocationActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, FrontActivity.class);
            startActivity(intent);
        }

//        CFPopupHelper.showProgressSpinner(this, View.GONE);

//        Intent intent = new Intent(this, LocationActivity.class);
//        startActivity(intent);
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

    private class ServerAvailabilityAsyncTask extends AsyncTask<String, String, Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {
            return CFHttpManager.checkServerAvailability();
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            proceed(aBoolean);
        }
    }

    private class MinorDataAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(String... params) {

            CFConstants.LOCATIONS = CFMinorDataHandler.getLocations();
            CFConstants.BODYTYPES = CFMinorDataHandler.getBodyTypes();
            CFConstants.BRANDS = CFMinorDataHandler.getBrands();
            CFConstants.CONDITIONTYPES = CFMinorDataHandler.getConditions();
            CFConstants.FUELTYPES = CFMinorDataHandler.getFuelTypes();
            CFConstants.TRANSMISSIONTYPES = CFMinorDataHandler.getTransmissionTypes();
            CFConstants.VEHICLETYPES = CFMinorDataHandler.getVehicleTypes();
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            startActivities();
//            CFPopupHelper.showProgressSpinner(LocationActivity.this, View.GONE);
//            spinner.setVisibility(View.GONE);
        }
    }
}
