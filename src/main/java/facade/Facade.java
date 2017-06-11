package facade;

import entity.City;
import entity.Country;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class Facade {

    private EntityManagerFactory emf;

    public Facade() {
    }

    public void addEntityManagerFacotry(EntityManagerFactory emf) {

        this.emf = emf;

    }

    public Country getCountry(String code) {

        EntityManager em = emf.createEntityManager();
        TypedQuery<Country> result = em.createNamedQuery("Country.findByCode", Country.class);
        Country person = result.setParameter("code", code).getSingleResult();
        return person;

    }

    public List<Country> getCountries() {

        EntityManager em = emf.createEntityManager();
        TypedQuery<Country> result = em.createNamedQuery("Country.findAll", Country.class);
        List<Country> countries = result.getResultList();
        return countries;

    }
    
    public List<Country> getCountriesGreaterThan(long number) {

        EntityManager em = emf.createEntityManager();
        TypedQuery<Country> result = em.createQuery("SELECT c FROM Country c WHERE c.population > :number", Country.class);
        List<Country> countries = result.setParameter("number", number).getResultList();
        return countries;
    }
    
      public List<City> getCitiesInCountry(Country countryCode) {

        EntityManager em = emf.createEntityManager();
        TypedQuery<City> result = em.createQuery("SELECT c FROM City c WHERE c.countryCode = :countryCode", City.class);
        List<City> cities = result.setParameter("countryCode", countryCode).getResultList();
        return cities;
    }
     
    public String createNewCity(String countryCode, String city) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Country country = getCountry(countryCode);
        City newCity = new City(city, "LNSQ", 123, country);
        em.persist(newCity);
        country.addCity(newCity);
        em.getTransaction().commit();
        return city;
    }
      
}
