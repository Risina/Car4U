package client.cfu.com.cfubase;

import com.orm.SugarRecord;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.*;

/**
 * 
 */
public class CFUser {

    /**
     * 
     */
    public CFUser() {
    }

    /**
     * 
     */
    private BigInteger id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String phoneNo1;

    /**
     * 
     */
    private String phoneNo2;

    /**
     * 
     */
    private String phoneNo3;

    /**
     * 
     */
    private String type;

    /**
     * 
     */
    private String location;

    /**
     * 
     */
    private Date createdDate;

    /**
     * 
     */
    private Timestamp modifiedDate;



    /**
     * @return
     */
    public String toJson() {
        // TODO implement here
        return "";
    }

    /**
     * @param String jsonString 
     * @return
     */
    public void parseJson(String jsonString) {
        // TODO implement here
    }

}