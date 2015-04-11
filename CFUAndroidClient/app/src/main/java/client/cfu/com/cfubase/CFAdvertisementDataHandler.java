package client.cfu.com.cfubase;

import android.graphics.Bitmap;

import java.math.BigInteger;
import java.util.*;

/**
 * 
 */
public class CFAdvertisementDataHandler {

    /**
     * 
     */
    public CFAdvertisementDataHandler() {
    }

    /**
     * 
     */
    private List<CFAdvertisement> advertisements;

    /**
     * 
     */
    private HashMap<String,String> filterParams;

    /**
     * 
     */
    private client.cfu.com.cfubase.CFUserSessionManager sessionManager;




    /**
     * @param BigInteger id 
     * @return
     */
    public CFAdvertisement getAdvertisementById(BigInteger id) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public List<CFAdvertisement> getAdvertisements() {
        // TODO implement here
        return null;
    }

    /**
     * @param String searchQuery 
     * @return
     */
    public List<CFAdvertisement> getAdvertisements(String searchQuery) {
        // TODO implement here
        return null;
    }

    /**
     * @param int locationId 
     * @return
     */
    public List<CFAdvertisement> getAdvertisements(int locationId) {
        // TODO implement here
        return null;
    }

    /**
     * @param BigInteger userId 
     * @return
     */
    public List<CFAdvertisement> getFavourites(BigInteger userId) {
        // TODO implement here
        return null;
    }

    /**
     * @param CFAdvertisement advertisement 
     * @return
     */
    public Boolean addAdvertisement(CFAdvertisement advertisement) {
        // TODO implement here
        return null;
    }

    /**
     * @param BigInteger userId 
     * @param BigInteger advertisementId 
     * @return
     */
    public Boolean addFavourite(BigInteger userId, BigInteger advertisementId) {
        // TODO implement here
        return null;
    }

    /**
     * @param BigInteger advertisementId 
     * @return
     */
    public Boolean removeAdvertisement(BigInteger advertisementId) {
        // TODO implement here
        return null;
    }

    /**
     * @param Bitmap image 
     * @param String name 
     * @return
     */
    public Boolean uploadImage(Bitmap image, String name) {
        // TODO implement here
        return null;
    }

}