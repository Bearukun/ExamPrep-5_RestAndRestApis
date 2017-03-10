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

}
