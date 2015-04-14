package client.cfu.com.cfuandroidclient;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import client.cfu.com.cfubase.CFMinorDataHandler;
import client.cfu.com.cfubase.CFUserDataHandler;
import client.cfu.com.cfubase.CFUserSessionManager;
import client.cfu.com.cfubase.entities.CFUser;
import client.cfu.com.constants.CFConstants;
import client.cfu.com.util.CFPopupHelper;


public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences prefs = getSharedPreferences("com.cfu.user", MODE_PRIVATE);
        String userEmail = prefs.getString("userEmail", null);
        String userPassword = prefs.getString("userPw", null);

        if(userEmail != null && userPassword != null) {
            Intent intent = new Intent(this, FrontActivity.class);
            startActivity(intent);
        }
        else {
            final TextView email = (TextView)findViewById(R.id.editTextEmail);
            final TextView password = (TextView)findViewById(R.id.editTextPassword);
            Button button = (Button)findViewById(R.id.button2);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String emailText = email.getText().toString();
                    String passwordText = password.getText().toString();
                    LoginAsyncTask asyncTask = new LoginAsyncTask(getApplicationContext());
                    asyncTask.execute(emailText, passwordText);
                }
            });
        }
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
            return sessionManager.createUserLoginSession(params[0], params[1]);
        }

        @Override
        protected void onPostExecute(String result) {
//            loadLocations();
//            spinner.setVisibility(View.GONE);
//            SharedPreferences prefs = getSharedPreferences("com.cfu.user", MODE_PRIVATE);
//            String userE = prefs.getString("userEmail", "email");
//            String pw = prefs.getString("userPw", "userPw");
            String toastString = "";
            if(result.equals(CFConstants.STATUS_OK)) {
                toastString = getString(R.string.login_successful);
            }
            else {
                toastString = getString(R.string.login_failed);
            }
            CFPopupHelper.showToast(getApplicationContext(), toastString);
        }
    }
}
