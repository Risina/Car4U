package client.cfu.com.cfuandroidclient;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import client.cfu.com.cfubase.entities.CFAdvertisement;
import client.cfu.com.cfubase.entities.CFEntityHelper;


public class AdViewActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.activity_open_translate,R.anim.activity_close_scale);
        setContentView(R.layout.activity_ad_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();
        String s = intent.getStringExtra("advertisement");


        TextView title = (TextView)findViewById(R.id.textViewTitle);
        TextView description = (TextView)findViewById(R.id.textViewDescription);
        TextView brand = (TextView)findViewById(R.id.textViewBrand);
        TextView condition = (TextView)findViewById(R.id.textViewCondition);
        TextView engine = (TextView)findViewById(R.id.textViewEngine);
        TextView fuel = (TextView)findViewById(R.id.textViewFuel);
        TextView mileage = (TextView)findViewById(R.id.textViewMileage);
        TextView model = (TextView)findViewById(R.id.textViewModel);
        TextView modelYear = (TextView)findViewById(R.id.textViewModelYear);
        TextView price = (TextView)findViewById(R.id.textViewPrice);
        TextView transmission = (TextView)findViewById(R.id.textViewTransmission);
        TextView location = (TextView)findViewById(R.id.textViewLocation);

        try {
            JSONObject jsonObject = new JSONObject(s);
            CFAdvertisement ad = CFEntityHelper.getAdvertisementFromJSON(jsonObject, true);

            title.setText(ad.getTitle());
            description.setText(ad.getDescription());
            brand.setText(ad.getBrandId().getBrandString());
            condition.setText(ad.getConditionId().getConditionString());
            engine.setText(Integer.toString(ad.getEngineCapacity()));
            fuel.setText(ad.getFuelTypeId().getFuelTypeString());
            mileage.setText(Long.toString(ad.getMilage()));
            model.setText(ad.getModel());
            modelYear.setText(Long.toString(ad.getMilage()));
            price.setText(Long.toString(ad.getPrice()));
            transmission.setText(ad.getTransmissionTypeId().getTransmissionTypeString());
            location.setText(ad.getUserId().getLocationId().getLocationString());
        }
        catch (JSONException e){
            e.printStackTrace();
        }
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
        getMenuInflater().inflate(R.menu.menu_ad_view, menu);
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
            Intent intent = new Intent(this, AdListActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
