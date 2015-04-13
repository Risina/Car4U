package client.cfu.com.cfubase;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.*;

import client.cfu.com.cfubase.entities.CFUser;

/**
 * 
 */
public class CFUserSessionManager {

    private static CFUserSessionManager sessionManager = new CFUserSessionManager();
    private CFUserSessionManager() {
    }

    private static Context applicationContext;

    private SharedPreferences pref;

    public void createUserLoginSession(String email, String password) {
        CFHttpManager.authenticate(email, password);
    }

    public static CFUserSessionManager getInstance(Context appContext) {
        // TODO implement here
        applicationContext = appContext;
        return sessionManager;
    }

    private Boolean authenticate(String email, String password) {
        // TODO implement here
        return null;
    }

    public CFUser getUser() {
        // TODO implement here
        return null;
    }

    public void logoutUser() {
        // TODO implement here
    }

}