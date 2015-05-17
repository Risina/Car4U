/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Risina
 */
@Entity
@Table(name = "Advertisement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Advertisement.findAll", query = "SELECT a FROM Advertisement a"),
    @NamedQuery(name = "Advertisement.findById", query = "SELECT a FROM Advertisement a WHERE a.id = :id"),
    @NamedQuery(name = "Advertisement.findByTitle", query = "SELECT a FROM Advertisement a WHERE a.title = :title"),
    @NamedQuery(name = "Advertisement.findByDescription", query = "SELECT a FROM Advertisement a WHERE a.description = :description"),
    @NamedQuery(name = "Advertisement.findByPrice", query = "SELECT a FROM Advertisement a WHERE a.price = :price"),
    @NamedQuery(name = "Advertisement.findByIsPriceNegotiable", query = "SELECT a FROM Advertisement a WHERE a.isPriceNegotiable = :isPriceNegotiable"),
    @NamedQuery(name = "Advertisement.findByImageLocation", query = "SELECT a FROM Advertisement a WHERE a.imageLocation = :imageLocation"),
    @NamedQuery(name = "Advertisement.findByModel", query = "SELECT a FROM Advertisement a WHERE a.model = :model"),
    @NamedQuery(name = "Advertisement.findByModelYear", query = "SELECT a FROM Advertisement a WHERE a.modelYear = :modelYear"),
    @NamedQuery(name = "Advertisement.findByEngineCapacity", query = "SELECT a FROM Advertisement a WHERE a.engineCapacity = :engineCapacity"),
    @NamedQuery(name = "Advertisement.findByMilage", query = "SELECT a FROM Advertisement a WHERE a.milage = :milage"),
    @NamedQuery(name = "Advertisement.findByCreatedDate", query = "SELECT a FROM Advertisement a WHERE a.createdDate = :createdDate"),
    @NamedQuery(name = "Advertisement.findByModifiedDate", query = "SELECT a FROM Advertisement a WHERE a.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "Advertisement.findByLocation", query = "SELECT a FROM Advertisement a WHERE a.userId.locationId.id = :locationId")})
public class Advertisement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic(optional = false)
    @Column(name = "Title")
    private String title;
    @Basic(optional = false)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @Column(name = "Price")
    private long price;
    @Basic(optional = false)
    @Column(name = "IsPriceNegotiable")
    private boolean isPriceNegotiable;
    @Basic(optional = false)
    @Column(name = "ImageLocation")
    private String imageLocation;
    @Basic(optional = false)
    @Column(name = "Model")
    private String model;
    @Basic(optional = false)
    @Column(name = "ModelYear")
    private short modelYear;
    @Basic(optional = false)
    @Column(name = "EngineCapacity")
    private int engineCapacity;
    @Basic(optional = false)
    @Column(name = "Milage")
    private long milage;
    @Basic(optional = false)
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "advertisementId")
    private Collection<Favourite> favouriteCollection;
    @JoinColumn(name = "FuelTypeId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private FuelType fuelTypeId;
    @JoinColumn(name = "TransmissionTypeId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private TransmissionType transmissionTypeId;
    @JoinColumn(name = "ConditionId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private ConditionType conditionId;
    @JoinColumn(name = "BodyTypeId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private BodyType bodyTypeId;
    @JoinColumn(name = "BrandId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Brand brandId;
    @JoinColumn(name = "VehicleTypeId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private VehicleType vehicleTypeId;
    @JoinColumn(name = "UserId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private User userId;

    public Advertisement() {
    }

    public Advertisement(Long id) {
        this.id = id;
    }

    public Advertisement(Long id, String title, String description, long price, boolean isPriceNegotiable, String imageLocation, String model, short modelYear, int engineCapacity, long milage, Date createdDate, Date modifiedDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.isPriceNegotiable = isPriceNegotiable;
        this.imageLocation = imageLocation;
        this.model = model;
        this.modelYear = modelYear;
        this.engineCapacity = engineCapacity;
        this.milage = milage;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public boolean getIsPriceNegotiable() {
        return isPriceNegotiable;
    }

    public void setIsPriceNegotiable(boolean isPriceNegotiable) {
        this.isPriceNegotiable = isPriceNegotiable;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public short getModelYear() {
        return modelYear;
    }

    public void setModelYear(short modelYear) {
        this.modelYear = modelYear;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public long getMilage() {
        return milage;
    }

    public void setMilage(long milage) {
        this.milage = milage;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @XmlTransient
    public Collection<Favourite> getFavouriteCollection() {
        return favouriteCollection;
    }

    public void setFavouriteCollection(Collection<Favourite> favouriteCollection) {
        this.favouriteCollection = favouriteCollection;
    }

    public FuelType getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(FuelType fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public TransmissionType getTransmissionTypeId() {
        return transmissionTypeId;
    }

    public void setTransmissionTypeId(TransmissionType transmissionTypeId) {
        this.transmissionTypeId = transmissionTypeId;
    }

    public ConditionType getConditionId() {
        return conditionId;
    }

    public void setConditionId(ConditionType conditionId) {
        this.conditionId = conditionId;
    }

    public BodyType getBodyTypeId() {
        return bodyTypeId;
    }

    public void setBodyTypeId(BodyType bodyTypeId) {
        this.bodyTypeId = bodyTypeId;
    }

    public Brand getBrandId() {
        return brandId;
    }

    public void setBrandId(Brand brandId) {
        this.brandId = brandId;
    }

    public VehicleType getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(VehicleType vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
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
        if (!(object instanceof Advertisement)) {
            return false;
        }
        Advertisement other = (Advertisement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Advertisement[ id=" + id + " ]";
    }
    
}
