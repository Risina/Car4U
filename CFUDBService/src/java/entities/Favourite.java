/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Risina
 */
@Entity
@Table(name = "Favourite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Favourite.findAll", query = "SELECT f FROM Favourite f"),
    @NamedQuery(name = "Favourite.findById", query = "SELECT f FROM Favourite f WHERE f.id = :id"),
    @NamedQuery(name = "Favourite.findByUserId", query = "SELECT f FROM Favourite f WHERE f.userId = :userId")})


public class Favourite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "AdvertisementId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Advertisement advertisementId;
    @JoinColumn(name = "UserId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private User userId;

    public Favourite() {
    }

    public Favourite(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Advertisement getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(Advertisement advertisementId) {
        this.advertisementId = advertisementId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof Favourite)) {
            return false;
        }
        Favourite other = (Favourite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Favourite[ id=" + id + " ]";
    }
    
}
