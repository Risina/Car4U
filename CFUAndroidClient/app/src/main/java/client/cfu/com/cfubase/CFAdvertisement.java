package client.cfu.com.cfubase;

import android.graphics.Bitmap;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 
 */
public class CFAdvertisement {

    private BigInteger id;
    private CFUser user;
    private String vehicleType;
    private String title;
    private String description;
    private BigDecimal price;
    private Boolean isPriceNegotiable;
    private String image;
    private String model;
    private String modelYear;
    private String bodyType;
    private String condition;
    private String transmissionType;
    private String fuelType;
    private int engineCapacity;
    private int milage;
    private Date createdDate;
    private Timestamp modifiedDate;

    public CFAdvertisement() {
    }

    public String toJson() {
        // TODO implement here
        return "";
    }

    public void parseJson(String jsonString) {
        // TODO implement here

    }

    public Bitmap getImage() {
        // TODO implement here
        return null;
    }

}