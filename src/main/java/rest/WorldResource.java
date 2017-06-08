/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entity.Country;
import facade.Facade;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import utility.JSONConverter;

/**
 * REST Web Service
 *
 * @author bearu
 */
@Path("world")
public class WorldResource {
    
    private Facade facade = new Facade();
    private JSONConverter converter = new JSONConverter();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public WorldResource() {
        
        facade.addEntityManagerFacotry(Persistence.createEntityManagerFactory("pu"));
        
    }

    /**
     * Method to return every country object from the mySQL database.
     * @return A list with every object in JSON format
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCountries() {
        
        List<Country> countries = facade.getCountries();
   
        return converter.getJSONFromCountries(countries);
    
    }
    
        /**
     * Method used to return a specific user by ID.
     *
     * @param id The ID of what user needs to be fetched.
     * @return Returns a JSON object with the given ID.
     */
    @GET
    @Path("{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonById(@PathParam("code") String code) {

        Country country = facade.getCountry(code);
        return converter.getJSONFromCountry(country);

    }

 
}
