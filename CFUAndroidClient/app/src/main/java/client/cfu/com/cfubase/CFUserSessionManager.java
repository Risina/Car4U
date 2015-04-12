package client.cfu.com.cfubase;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.*;

import client.cfu.com.cfubase.entities.CFUser;

/**
 * 
 */
public class CFUserSessionManager {

    /**
     * 
     */
    public CFUserSessionManager() {
    }

    /**
     * 
     */
    private Context applicationContext;

    /**
     * 
     */
    private SharedPreferences pref;


    /**
     * @param String email 
     * @param String password 
     * @return
     */
    public void createUserLoginSession(String email, String password) {
        // TODO implement here
    }

    /**
     * @return
     */
    public CFUserSessionManager getInstance() {
        // TODO implement here
        return null;
    }

    /**
     * @param String email 
     * @param String password 
     * @return
     */
    private Boolean authenticate(String email, String password) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public CFUser getUser() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public void logoutUser() {
        // TODO implement here
    }

}