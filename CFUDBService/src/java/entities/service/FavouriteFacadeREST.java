/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.Favourite;
import java.util.List;
import entities.*;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
@Path("entities.favourite")
public class FavouriteFacadeREST extends AbstractFacade<Favourite> {
    @PersistenceContext(unitName = "CFUDBServicePU")
    private final EntityManager em = Persistence.createEntityManagerFactory("CFUDBServicePU").createEntityManager();;

    public FavouriteFacadeREST() {
        super(Favourite.class);
    }

    @POST
    @Consumes({"application/json"})
    public void create(String jsonString) {
        
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject)parser.parse(jsonString);
        Favourite favourite = new Favourite();

        User user = em.find(User.class, new Long(jsonObject.get("userId").toString()));
        Advertisement ad = em.find(Advertisement.class, new Long(jsonObject.get("advertisementId").toString()));
        favourite.setUserId(user);
        favourite.setAdvertisementId(ad);
        
        super.create(favourite);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") Long id, Favourite entity) {
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
    public Favourite find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Favourite> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("get/{from}/{to}")
    @Produces({"application/json"})
    public String findRange(@PathParam("from") Long userId, @PathParam("to") Long adId) {
        
        Object[] details;
        
        try {
            details = (Object[]) em.createNativeQuery("SELECT * FROM Favourite WHERE UserId='"+userId+"' && advertisementId='"+adId+"'").getSingleResult();
            return Long.toString((long) details[0]);
        }
        catch (NoResultException e){
            return "";
        }
        
    }
    
    @GET
    @Path("get/{userId}")
    @Produces({"application/json"})
    public String getFavourites(@PathParam("userId") Long userId) {
        
        List<Favourite> details = null;
        List<String> list = new ArrayList<>();
        
        try {
            details = (List<Favourite>)em.createNamedQuery("Favourite.findByUserId")
                        .setParameter("userId", em.find(User.class, userId))
                        .getResultList();
            
            
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        if(details.size()>0) {
            for(Favourite fav: details){
                list.add(Long.toString(fav.getAdvertisementId().getId()));
            }
        }
        
        return new Gson().toJson(list);
    }
    
    

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Favourite> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
