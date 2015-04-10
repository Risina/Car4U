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
@Table(name = "TransmissionType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransmissionType.findAll", query = "SELECT t FROM TransmissionType t"),
    @NamedQuery(name = "TransmissionType.findById", query = "SELECT t FROM TransmissionType t WHERE t.id = :id"),
    @NamedQuery(name = "TransmissionType.findByTransmissionTypeString", query = "SELECT t FROM TransmissionType t WHERE t.transmissionTypeString = :transmissionTypeString")})
public class TransmissionType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "TransmissionTypeString")
    private String transmissionTypeString;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transmissionTypeId")
    private Collection<Advertisement> advertisementCollection;

    public TransmissionType() {
    }

    public TransmissionType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransmissionTypeString() {
        return transmissionTypeString;
    }

    public void setTransmissionTypeString(String transmissionTypeString) {
        this.transmissionTypeString = transmissionTypeString;
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
        if (!(object instanceof TransmissionType)) {
            return false;
        }
        TransmissionType other = (TransmissionType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TransmissionType[ id=" + id + " ]";
    }
    
}
