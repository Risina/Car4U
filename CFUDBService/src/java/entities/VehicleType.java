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
@Table(name = "VehicleType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehicleType.findAll", query = "SELECT v FROM VehicleType v"),
    @NamedQuery(name = "VehicleType.findById", query = "SELECT v FROM VehicleType v WHERE v.id = :id"),
    @NamedQuery(name = "VehicleType.findByTypeString", query = "SELECT v FROM VehicleType v WHERE v.typeString = :typeString")})
public class VehicleType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TypeString")
    private String typeString;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleTypeId")
    private Collection<Advertisement> advertisementCollection;

    public VehicleType() {
    }

    public VehicleType(Integer id) {
        this.id = id;
    }

    public VehicleType(Integer id, String typeString) {
        this.id = id;
        this.typeString = typeString;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeString() {
        return typeString;
    }

    public void setTypeString(String typeString) {
        this.typeString = typeString;
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
        if (!(object instanceof VehicleType)) {
            return false;
        }
        VehicleType other = (VehicleType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.VehicleType[ id=" + id + " ]";
    }
    
}
