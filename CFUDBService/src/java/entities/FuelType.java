/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Risina
 */
@Entity
@Table(name = "FuelType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FuelType.findAll", query = "SELECT f FROM FuelType f"),
    @NamedQuery(name = "FuelType.findById", query = "SELECT f FROM FuelType f WHERE f.id = :id"),
    @NamedQuery(name = "FuelType.findByFuelTypeString", query = "SELECT f FROM FuelType f WHERE f.fuelTypeString = :fuelTypeString")})
public class FuelType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "FuelTypeString")
    private String fuelTypeString;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fuelTypeId")
    private Collection<Advertisement> advertisementCollection;

    public FuelType() {
    }

    public FuelType(Integer id) {
        this.id = id;
    }

    public FuelType(Integer id, String fuelTypeString) {
        this.id = id;
        this.fuelTypeString = fuelTypeString;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFuelTypeString() {
        return fuelTypeString;
    }

    public void setFuelTypeString(String fuelTypeString) {
        this.fuelTypeString = fuelTypeString;
    }

    @XmlTransient
    public Collection<Advertisement> getAdvertisementCollection() {
        return advertisementCollection;
    }

    public void setAdvertisementCollection(Collection<Advertisement> advertisementCollection) {
        this.advertisementCollection = advertisementCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuelType)) {
            return false;
        }
        FuelType other = (FuelType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.FuelType[ id=" + id + " ]";
    }
    
}
