package client.cfu.com.cfubase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

/**
 * 
 */
public class CFMinorDataHandler {

    /**
     * 
     */
    public CFMinorDataHandler() {
    }

    /**
     * @return
     */
    public static List<String> getLocations() {

        String result = CFHttpManager.getData("http://192.168.1.2:8200/CFUDBService/webresources/entities.location", new HashMap<String, String>());
        return getValuesFromJsonString(result, "locationString");
    }

    /**
     * @return
     */
    public static List<String> getVehicleTypes() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public static List<String> getBrands() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public static List<String> getBodyTypes() {
        String result = CFHttpManager.getData("http://192.168.1.2:8200/CFUDBService/webresources/entities.bodytype", new HashMap<String, String>());
        return getValuesFromJsonString(result, "bodyTypeString");
    }

    /**
     * @return
     */
    public static List<String> getTransmissionTypes() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public static List<String> getConditions() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public static List<String> getFuelTypes() {
        // TODO implement here
        return null;
    }

    private static List<String>getValuesFromJsonString(String result, String key){
        ArrayList<String> valueArrayList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(result);
            for(int i=0; i<jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                valueArrayList.add((String) obj.get(key));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return valueArrayList;
    }

}