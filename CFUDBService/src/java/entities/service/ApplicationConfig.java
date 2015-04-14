/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Risina
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(entities.service.AdvertisementFacadeREST.class);
        resources.add(entities.service.Authenticator.class);
        resources.add(entities.service.BodyTypeFacadeREST.class);
        resources.add(entities.service.BrandFacadeREST.class);
        resources.add(entities.service.ConditionTypeFacadeREST.class);
        resources.add(entities.service.FavouriteFacadeREST.class);
        resources.add(entities.service.FuelTypeFacadeREST.class);
        resources.add(entities.service.LocationFacadeREST.class);
        resources.add(entities.service.TransmissionTypeFacadeREST.class);
        resources.add(entities.service.UserFacadeREST.class);
        resources.add(entities.service.VehicleTypeFacadeREST.class);
    }
    
}
