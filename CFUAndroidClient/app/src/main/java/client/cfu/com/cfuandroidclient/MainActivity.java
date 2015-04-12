package client.cfu.com.cfuandroidclient;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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


public class MainActivity extends ActionBarActivity {

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
        setContentView(R.layout.activity_main);

        spinner = (ProgressBar) findViewById(R.id.progressBar1);
        spinner.setVisibility(View.VISIBLE);



//        flags = new int[]{
//                R.drawable.india,
//                R.drawable.pakistan,
//                R.drawable.srilanka,
//                R.drawable.china,
//                R.drawable.bangladesh,
//                R.drawable.nepal,
//                R.drawable.afghanistan,
//                R.drawable.nkorea,
//                R.drawable.skorea,
//                R.drawable.japan
//        };
//
//        // Array of strings to store currencies
//        currency = new String[]{
//                "Indian Rupee",
//                "Pakistani Rupee",
//                "Sri Lankan Rupee",
//                "Renminbi",
//                "Bangladeshi Taka",
//                "Nepalese Rupee",
//                "Afghani",
//                "North Korean Won",
//                "South Korean Won",
//                "Japanese Yen"
//        };
//
//        countries = new String[]{
//                "India",
//                "Pakistan",
//                "Sri Lanka",
//                "China",
//                "Bangladesh",
//                "Nepal",
//                "Afghanistan",
//                "North Korea",
//                "South Korea",
//                "Japan"
//        };

        DataAsyncTask asyncTask = new DataAsyncTask();
        asyncTask.execute();
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void createList() {
//        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
//
//        for (int i = 0; i < 6; i++) {
//            HashMap<String, String> hm = new HashMap<String, String>();
//            hm.put("txt", "Country : " + countries[i]);
//            hm.put("cur", "Currency : " + bodyTypes.get(i));
//            hm.put("flag", Integer.toString(flags[i]));
//            aList.add(hm);
//        }
//
//        // Keys used in Hashmap
//        String[] from = {"flag", "txt", "cur"};
//
//        int[] to = {R.id.flag, R.id.txt, R.id.cur};

//        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.ad_list, from, to);

        AdAdapter adAdapter = new AdAdapter(getBaseContext(), R.layout.ad_list, adList);
        ListView listView = (ListView) findViewById(R.id.listview);

        listView.setAdapter(adAdapter);

    }

    private void loadLocations() {
        SharedPreferences preferences = getSharedPreferences("com.cfu.location", MODE_PRIVATE);
        int location = preferences.getInt("location", 0);
        if (location == 0) {
            Intent intent = new Intent(this, LocationActivity.class);
            intent.putStringArrayListExtra("locations", locations);
            startActivityForResult(intent, LOCATION_REQ_CODE);
        }
    }


    private class DataAsyncTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(String... params) {


            locations = new ArrayList<>(CFMinorDataHandler.getLocations());
            vehicleTypes = CFMinorDataHandler.getVehicleTypes();
            brands = CFMinorDataHandler.getBrands();
            bodyTypes = CFMinorDataHandler.getBodyTypes();
            transmissionTypes = CFMinorDataHandler.getTransmissionTypes();
            conditions = CFMinorDataHandler.getConditions();
            fuelTypes = CFMinorDataHandler.getFuelTypes();

            CFAdvertisementDataHandler adh = new CFAdvertisementDataHandler();
            adList = adh.getAdvertisements();
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            createList();
            spinner.setVisibility(View.GONE);
            loadLocations();

        }
    }


}
