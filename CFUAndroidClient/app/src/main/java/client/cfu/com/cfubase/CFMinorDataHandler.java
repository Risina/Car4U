package client.cfu.com.cfubase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

import client.cfu.com.constants.CFConstants;

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
    public static List<JSONObject> getLocations() {

        String result = CFHttpManager.getData(CFConstants.SERVICE_ROOT+"CFUDBService/webresources/entities.location", new HashMap<String, String>());
        return getValuesFromJsonString(result);
    }

    /**
     * @return
     */
    public static List<JSONObject> getVehicleTypes() {
        String result = CFHttpManager.getData(CFConstants.SERVICE_ROOT+"CFUDBService/webresources/entities.vehicletype", new HashMap<String, String>());
        return getValuesFromJsonString(result);
    }

    /**
     * @return
     */
    public static List<JSONObject> getBrands() {
        String result = CFHttpManager.getData(CFConstants.SERVICE_ROOT+"CFUDBService/webresources/entities.brand", new HashMap<String, String>());
        return getValuesFromJsonString(result);
    }

    /**
     * @return
     */
    public static List<JSONObject> getBodyTypes() {
        String result = CFHttpManager.getData(CFConstants.SERVICE_ROOT+"CFUDBService/webresources/entities.bodytype", new HashMap<String, String>());
        return getValuesFromJsonString(result);
    }

    /**
     * @return
     */
    public static List<JSONObject> getTransmissionTypes() {
        String result = CFHttpManager.getData(CFConstants.SERVICE_ROOT+"CFUDBService/webresources/entities.transmissiontype", new HashMap<String, String>());
        return getValuesFromJsonString(result);
    }

    /**
     * @return
     */
    public static List<JSONObject> getConditions() {
        String result = CFHttpManager.getData(CFConstants.SERVICE_ROOT+"CFUDBService/webresources/entities.conditiontype", new HashMap<String, String>());
        return getValuesFromJsonString(result);
    }

    /**
     * @return
     */
    public static List<JSONObject> getFuelTypes() {
        String result = CFHttpManager.getData(CFConstants.SERVICE_ROOT+"CFUDBService/webresources/entities.fueltype", new HashMap<String, String>());
        return getValuesFromJsonString(result);
    }

    private static List<JSONObject> getValuesFromJsonString(String result){
        ArrayList<JSONObject> valueArrayList = new ArrayList<>();
        HashMap<String, String> map;
        try {
            JSONArray jsonArray = new JSONArray(result);
            for(int i=0; i<jsonArray.length(); i++) {
//                map = new HashMap<String, String>();
                JSONObject obj = jsonArray.getJSONObject(i);
////                valueArrayList.add((String) obj.get(key));
//                map.put("id", obj.get("id").toString());
//                map.put(key, (String) obj.get(key));
//                valueArrayList.add(map);

                valueArrayList.add(obj);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return valueArrayList;
    }

}