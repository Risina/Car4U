/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.Advertisement;
import entities.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Risina
 */
@javax.ejb.Stateless
@Path("entities.advertisement")
public class AdvertisementFacadeREST extends AbstractFacade<Advertisement> {
    @PersistenceContext(unitName = "CFUDBServicePU")
    private final EntityManager em = Persistence.createEntityManagerFactory("CFUDBServicePU").createEntityManager();

    public AdvertisementFacadeREST() {
        super(Advertisement.class);
    }

    @POST
    @Consumes({"application/json"})
    public void create(String jsonString) {
        
        Advertisement ad = new Advertisement();
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject)parser.parse(jsonString);

//        Long rowCnt= (Long) em.createNativeQuery("SELECT count(1) FROM Advertisement").getSingleResult();
//        Long id = rowCnt +1;
//        ad.setId(id);
        User u = em.find(User.class, new Long(jsonObject.get("userId").toString()));
        ad.setUserId(u);
        
        BodyType bt = em.find(BodyType.class, new Integer(jsonObject.get("bodyTypeId").toString()));
        ConditionType con = em.find(ConditionType.class, new Integer(jsonObject.get("conditionId").toString()));
        TransmissionType tt = em.find(TransmissionType.class, new Integer(jsonObject.get("transmissionTypeId").toString()));
        VehicleType vt = em.find(VehicleType.class, new Integer(jsonObject.get("vehicleTypeId").toString()));
        Brand br = em.find(Brand.class, new Integer(jsonObject.get("brandId").toString()));
        FuelType ft = em.find(FuelType.class, new Integer(jsonObject.get("fuelTypeId").toString()));
        
        ad.setBodyTypeId(bt);
        ad.setConditionId(con);
        ad.setTransmissionTypeId(tt);
        ad.setVehicleTypeId(vt);
        ad.setBrandId(br);
        ad.setFuelTypeId(ft);
        
        Date date = new Date();
        ad.setCreatedDate(date);
        ad.setModifiedDate(date);
        
        ad.setDescription(jsonObject.get("description").toString());
        ad.setEngineCapacity(Integer.parseInt(jsonObject.get("engineCapacity").toString()));
        ad.setIsPriceNegotiable(new Boolean(jsonObject.get("isPriceNegotiable").toString()));
        ad.setMilage(Long.parseLong(jsonObject.get("milage").toString()));
        ad.setModel(jsonObject.get("model").toString());
        ad.setModelYear(Short.parseShort(jsonObject.get("modelYear").toString()));
        ad.setPrice(Long.parseLong(jsonObject.get("price").toString()));
        ad.setTitle(jsonObject.get("title").toString());
        ad.setImageLocation(jsonObject.get("imageName").toString());
     
        super.create(ad);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") Long id, Advertisement entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Advertisement find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Advertisement> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Advertisement> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
