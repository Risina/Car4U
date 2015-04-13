package client.cfu.com.cfuandroidclient;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import client.cfu.com.cfubase.CFMinorDataHandler;
import client.cfu.com.cfubase.CFUserDataHandler;
import client.cfu.com.cfubase.CFUserSessionManager;
import client.cfu.com.cfubase.entities.CFUser;


public class LoginActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView email = (TextView)findViewById(R.id.editTextEmail);
        TextView password = (TextView)findViewById(R.id.editTextPassword);

        LoginAsyncTask asyncTask = new LoginAsyncTask(getApplicationContext());
        asyncTask.execute((String)email.getText(), (String)password.getText());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

    private class LoginAsyncTask extends AsyncTask<String, String, String> {
        Context appContext;

        public LoginAsyncTask(Context applicationContext)
        {
            appContext = applicationContext;
        }
        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(String... params) {
            CFUserSessionManager sessionManager = CFUserSessionManager.getInstance(appContext);
            sessionManager.createUserLoginSession(params[0], params[1]);
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
//            loadLocations();
//            spinner.setVisibility(View.GONE);
        }
    }
}
