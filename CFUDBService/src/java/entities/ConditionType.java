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
@Table(name = "ConditionType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConditionType.findAll", query = "SELECT c FROM ConditionType c"),
    @NamedQuery(name = "ConditionType.findById", query = "SELECT c FROM ConditionType c WHERE c.id = :id"),
    @NamedQuery(name = "ConditionType.findByConditionString", query = "SELECT c FROM ConditionType c WHERE c.conditionString = :conditionString")})
public class ConditionType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ConditionString")
    private String conditionString;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conditionId")
    private Collection<Advertisement> advertisementCollection;

    public ConditionType() {
    }

    public ConditionType(Integer id) {
        this.id = id;
    }

    public ConditionType(Integer id, String conditionString) {
        this.id = id;
        this.conditionString = conditionString;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConditionString() {
        return conditionString;
    }

    public void setConditionString(String conditionString) {
        this.conditionString = conditionString;
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
        if (!(object instanceof ConditionType)) {
            return false;
        }
        ConditionType other = (ConditionType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ConditionType[ id=" + id + " ]";
    }
    
}
