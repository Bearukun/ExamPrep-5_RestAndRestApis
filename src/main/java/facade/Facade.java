package facade;

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
//        TypedQuery<Country> result1 = em.createQuery("SELECT c FROM Country c WHERE c.population > '1000000000'", Country.class);
//        List<Country> countries = result1.getResultList();
//        return countries;
//        TypedQuery<Country> result = em.createQuery("SELECT c FROM Country c WHERE c.population > :number", Country.class);
//        List<Country> countries = result.setParameter("number", number).getResultList();

        
    //return 
            
//        TypedQuery<Country> result = em.createQuery("SELECT c FROM Country c WHERE c.population > ?1", Country.class);
        TypedQuery<Country> result = em.createQuery("SELECT c FROM Country c WHERE c.population > :number", Country.class);
        List<Country> countries = result.setParameter("number", number).getResultList();
//        result.setParameter(1, number);
//        List<Country> countries = (List<Country>) result.getResultList();
        return countries;
    }

}
