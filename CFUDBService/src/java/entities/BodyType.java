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
@Table(name = "BodyType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BodyType.findAll", query = "SELECT b FROM BodyType b"),
    @NamedQuery(name = "BodyType.findById", query = "SELECT b FROM BodyType b WHERE b.id = :id"),
    @NamedQuery(name = "BodyType.findByBodyTypeString", query = "SELECT b FROM BodyType b WHERE b.bodyTypeString = :bodyTypeString")})
public class BodyType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "BodyTypeString")
    private String bodyTypeString;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bodyTypeId")
    private Collection<Advertisement> advertisementCollection;

    public BodyType() {
    }

    public BodyType(Integer id) {
        this.id = id;
    }

    public BodyType(Integer id, String bodyTypeString) {
        this.id = id;
        this.bodyTypeString = bodyTypeString;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBodyTypeString() {
        return bodyTypeString;
    }

    public void setBodyTypeString(String bodyTypeString) {
        this.bodyTypeString = bodyTypeString;
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
        if (!(object instanceof BodyType)) {
            return false;
        }
        BodyType other = (BodyType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BodyType[ id=" + id + " ]";
    }
    
}
