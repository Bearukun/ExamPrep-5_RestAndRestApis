/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bearu
 */
@Entity
@Table(name = "Country")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c")
    , @NamedQuery(name = "Country.findByCode", query = "SELECT c FROM Country c WHERE c.code = :code")
    , @NamedQuery(name = "Country.findByName", query = "SELECT c FROM Country c WHERE c.name = :name")
    , @NamedQuery(name = "Country.findByContinent", query = "SELECT c FROM Country c WHERE c.continent = :continent")
    , @NamedQuery(name = "Country.findByRegion", query = "SELECT c FROM Country c WHERE c.region = :region")
    , @NamedQuery(name = "Country.findBySurfaceArea", query = "SELECT c FROM Country c WHERE c.surfaceArea = :surfaceArea")
    , @NamedQuery(name = "Country.findByIndepYear", query = "SELECT c FROM Country c WHERE c.indepYear = :indepYear")
    , @NamedQuery(name = "Country.findByPopulation", query = "SELECT c FROM Country c WHERE c.population = :population")
    , @NamedQuery(name = "Country.findByLifeExpectancy", query = "SELECT c FROM Country c WHERE c.lifeExpectancy = :lifeExpectancy")
    , @NamedQuery(name = "Country.findByGnp", query = "SELECT c FROM Country c WHERE c.gnp = :gnp")
    , @NamedQuery(name = "Country.findByGNPOld", query = "SELECT c FROM Country c WHERE c.gNPOld = :gNPOld")
    , @NamedQuery(name = "Country.findByLocalName", query = "SELECT c FROM Country c WHERE c.localName = :localName")
    , @NamedQuery(name = "Country.findByGovernmentForm", query = "SELECT c FROM Country c WHERE c.governmentForm = :governmentForm")
    , @NamedQuery(name = "Country.findByHeadOfState", query = "SELECT c FROM Country c WHERE c.headOfState = :headOfState")
    , @NamedQuery(name = "Country.findByCode2", query = "SELECT c FROM Country c WHERE c.code2 = :code2")})
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Code")
    @Expose
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 52)
    @Column(name = "Name")
    @Expose
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "Continent")
    @Expose
    private String continent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 26)
    @Column(name = "Region")
    @Expose
    private String region;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SurfaceArea")
    @Expose
    private float surfaceArea;
    @Column(name = "IndepYear")
    @Expose
    private Short indepYear;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Population")
    @Expose
    private int population;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LifeExpectancy")
    @Expose
    private Float lifeExpectancy;
    @Column(name = "GNP")
    @Expose
    private Float gnp;
    @Column(name = "GNPOld")
    @Expose
    private Float gNPOld;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "LocalName")
    @Expose
    private String localName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "GovernmentForm")
    @Expose
    private String governmentForm;
    @Size(max = 60)
    @Column(name = "HeadOfState")
    @Expose
    private String headOfState;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Code2")
    @Expose
    private String code2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    @Expose
    private transient Collection<CountryLanguage> countryLanguageCollection;
    @JoinColumn(name = "Capital", referencedColumnName = "ID")
    @ManyToOne
    @Expose
    private City capital;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryCode")
    @Expose
    private transient Collection<City> cityCollection;

    public Country() {
    }

    public Country(String code) {
        this.code = code;
    }

    public Country(String code, String name, String continent, String region, float surfaceArea, int population, String localName, String governmentForm, String code2) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.population = population;
        this.localName = localName;
        this.governmentForm = governmentForm;
        this.code2 = code2;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public float getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public Short getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(Short indepYear) {
        this.indepYear = indepYear;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Float getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(Float lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public Float getGnp() {
        return gnp;
    }

    public void setGnp(Float gnp) {
        this.gnp = gnp;
    }

    public Float getGNPOld() {
        return gNPOld;
    }

    public void setGNPOld(Float gNPOld) {
        this.gNPOld = gNPOld;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    @XmlTransient
    public Collection<CountryLanguage> getCountryLanguageCollection() {
        return countryLanguageCollection;
    }

    public void setCountryLanguageCollection(List<CountryLanguage> countryLanguageCollection) {
        this.countryLanguageCollection = countryLanguageCollection;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    @XmlTransient
    public Collection<City> getCityCollection() {
        return cityCollection;
    }

    public void setCityCollection(List<City> cityCollection) {
        this.cityCollection = cityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Country[ code=" + code + " ]";
    }

}
