/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
    
    @GET
    @Path("cncn")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCNCN() {
        
        List<Country> countries = facade.getCountries();
        
        JsonArray jA = new JsonArray();
        
        for (int i = 0; i < countries.size(); i++) {
        JsonObject jO = new JsonObject();
            
            jO.addProperty("code", countries.get(i).getCode());
            jO.addProperty("name", countries.get(i).getName());
            jO.addProperty("continent", countries.get(i).getContinent());
//            jO.addProperty("capital", countries.get(i).getCapital().getName());
            jO.addProperty("capital", countries.get(i).getCapital().getId());
            jA.add(jO);
        }
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(jA);
    
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
