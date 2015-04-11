package client.cfu.com.cfubase;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.ResponseCache;
import java.util.*;

import client.cfu.com.cfuandroidclient.R;

/**
 * 
 */
public class CFHttpManager {

    protected CFHttpManager() {
    }

    protected static String authenticate(String email, String password) {
        // TODO implement here
        return "";
    }

    protected static String getData(String uri, HashMap<String,String> filterParams) {
        InputStream inputStream = null;
        String result = "";
        try {

            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(uri));

            // receive response as inputStream

            // convert inputstream to string
            int status = httpResponse.getStatusLine().getStatusCode();
            if (status == 200) {
                result = EntityUtils.toString(httpResponse.getEntity());
            }
            else {
                result = "Did not work!";
            }

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return result;
    }

    protected static String getDataWithAuthCredentials(String uri, HashMap<String,String> filterParams, String email, String password) {
        // TODO implement here
        return "";
    }

    protected static String addData(String Uri, String jsonString, Bitmap image) {
        // TODO implement here
        return "";
    }


    protected static String uploadImage(Bitmap image, String name, BigInteger advertisementId) {
        // TODO implement here
        return "";
    }

    protected static Bitmap downloadImage(BigInteger advertisementId) {
        // TODO implement here
        return null;
    }


    protected static String removeAdvertisement(BigInteger advertisementId) {
        // TODO implement here
        return "";
    }

}