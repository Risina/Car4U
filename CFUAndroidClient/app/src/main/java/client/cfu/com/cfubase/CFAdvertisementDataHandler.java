package client.cfu.com.cfubase;


import android.graphics.Bitmap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


import client.cfu.com.cfubase.entities.CFAdvertisement;
import client.cfu.com.cfubase.entities.CFBodyType;
import client.cfu.com.cfubase.entities.CFBrand;
import client.cfu.com.cfubase.entities.CFConditionType;
import client.cfu.com.cfubase.entities.CFFuelType;
import client.cfu.com.cfubase.entities.CFLocation;
import client.cfu.com.cfubase.entities.CFTransmissionType;
import client.cfu.com.cfubase.entities.CFUser;
import client.cfu.com.cfubase.entities.CFVehicleType;

/**
 * 
 */
public class CFAdvertisementDataHandler {


    public CFAdvertisementDataHandler() {
    }

    private List<CFAdvertisement> advertisements;
    private HashMap<String,String> filterParams;
    private client.cfu.com.cfubase.CFUserSessionManager sessionManager;




    public CFAdvertisement getAdvertisementById(BigInteger id) {
        // TODO implement here
        return null;
    }

    public List<CFAdvertisement> getAdvertisements() {
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        List<CFAdvertisement> advertisementList = new ArrayList<>();

        String result = CFHttpManager.getData("http://192.168.1.2:8200/CFUDBService/webresources/entities.advertisement", new HashMap<String, String>());

        List<JSONObject> advertisementObjects = getValuesFromJsonString(result);
        for (JSONObject obj:advertisementObjects) {

            try {
                CFAdvertisement ad = new CFAdvertisement();
                ad.setId(Long.parseLong(obj.get("id").toString()));
                ad.setTitle(obj.get("title").toString());
                ad.setDescription(obj.get("description").toString());
                ad.setPrice(Long.parseLong(obj.get("price").toString()));
                ad.setIsPriceNegotiable(obj.get("isPriceNegotiable").toString().equals("1"));
                ad.setModel(obj.get("model").toString());
                ad.setModelYear(Short.parseShort(obj.get("modelYear").toString()));
                ad.setEngineCapacity(Integer.parseInt(obj.get("engineCapacity").toString()));
                ad.setMilage(Long.parseLong(obj.get("milage").toString()));


                JSONObject fuelTypeObj = new JSONObject(obj.get("fuelTypeId").toString());
                CFFuelType ft=new CFFuelType(Integer.parseInt(fuelTypeObj.get("id").toString()));
                ft.setFuelTypeString(fuelTypeObj.get("fuelTypeString").toString());

                ad.setFuelTypeId(ft);

                JSONObject transmissionTypeObj = new JSONObject(obj.get("transmissionTypeId").toString());
                CFTransmissionType tt=new CFTransmissionType(Integer.parseInt(transmissionTypeObj.get("id").toString()));
                tt.setTransmissionTypeString(transmissionTypeObj.get("transmissionTypeString").toString());

                ad.setTransmissionTypeId(tt);

                JSONObject conditionObj = new JSONObject(obj.get("conditionId").toString());
                CFConditionType ct=new CFConditionType(Integer.parseInt(conditionObj.get("id").toString()));
                ct.setConditionString(conditionObj.get("conditionString").toString());

                ad.setConditionId(ct);

                JSONObject bodyTypeObj = new JSONObject(obj.get("bodyTypeId").toString());
                CFBodyType bt=new CFBodyType(Integer.parseInt(bodyTypeObj.get("id").toString()));
                bt.setBodyTypeString(bodyTypeObj.get("bodyTypeString").toString());

                ad.setBodyTypeId(bt);

                JSONObject brandObj = new JSONObject(obj.get("brandId").toString());
                CFBrand brt=new CFBrand(Integer.parseInt(brandObj.get("id").toString()));
                brt.setBrandString(brandObj.get("brandString").toString());

                ad.setBrandId(brt);

                JSONObject vehicleTypeObj = new JSONObject(obj.get("vehicleTypeId").toString());
                CFVehicleType vt=new CFVehicleType(Integer.parseInt(vehicleTypeObj.get("id").toString()));
                vt.setTypeString(vehicleTypeObj.get("typeString").toString());

                ad.setVehicleTypeId(vt);

                JSONObject userTypeObj = new JSONObject(obj.get("userId").toString());
                CFUser user = new CFUser(Long.parseLong(userTypeObj.get("id").toString()));
                user.setUName(userTypeObj.get("UName").toString());
                user.setPhoneNo1(userTypeObj.get("phoneNo1").toString());


                if(isSafeMethod(userTypeObj, "phoneNo2")){
                    user.setPhoneNo2(userTypeObj.get("phoneNo2").toString());
                }
                if(isSafeMethod(userTypeObj, "phoneNo3")){
                    user.setPhoneNo3(userTypeObj.get("phoneNo3").toString());
                }


                user.setEmail(userTypeObj.get("email").toString());

                JSONObject locationObj = new JSONObject(userTypeObj.get("locationId").toString());
                CFLocation location = new CFLocation(Integer.parseInt(locationObj.get("id").toString()));
                location.setLocationString(locationObj.get("locationString").toString());
                user.setLocationId(location);

                ad.setUserId(user);

                advertisementList.add(ad);

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
        return advertisementList;
    }


    public List<CFAdvertisement> getAdvertisements(String searchQuery) {
        // TODO implement here
        return null;
    }


    public List<CFAdvertisement> getAdvertisements(int locationId) {
        // TODO implement here
        return null;
    }


    public List<CFAdvertisement> getFavourites(BigInteger userId) {
        // TODO implement here
        return null;
    }


    public Boolean addAdvertisement(CFAdvertisement advertisement) {
        // TODO implement here
        return null;
    }

    public Boolean addFavourite(BigInteger userId, BigInteger advertisementId) {
        // TODO implement here
        return null;
    }


    public Boolean removeAdvertisement(BigInteger advertisementId) {
        // TODO implement here
        return null;
    }

    public Boolean uploadImage(Bitmap image, String name) {
        // TODO implement here
        return null;
    }

    private List<JSONObject>getValuesFromJsonString(String result){
        ArrayList<JSONObject> valueArrayList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(result);
            for(int i=0; i<jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                valueArrayList.add(obj);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return valueArrayList;
    }

    private boolean isSafeMethod(JSONObject obj, String key) {
        boolean b;
        try {
            obj.get(key);
            b = true;
        }
        catch (JSONException e) {
            b = false;
        }
        return b;

    }

}