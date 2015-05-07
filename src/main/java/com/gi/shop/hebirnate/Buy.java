package com.gi.shop.hebirnate;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Класс предназначен для 
 * @author garadagly
 */
@Entity
@Table(name = "buy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Buy.findAll", query = "SELECT b FROM Buy b"),
    @NamedQuery(name = "Buy.findById", query = "SELECT b FROM Buy b WHERE b.id = :id"),
    @NamedQuery(name = "Buy.findByUserid", query = "SELECT b FROM Buy b WHERE b.userid = :userid order by b.buyDate desc"),
    @NamedQuery(name = "Buy.findByProductid", query = "SELECT b FROM Buy b WHERE b.productid = :productid"),
    @NamedQuery(name = "Buy.findByMarketId", query = "SELECT b FROM Buy b WHERE b.marketId = :marketId"),
    @NamedQuery(name = "Buy.findByIsDelivery", query = "SELECT b FROM Buy b WHERE b.isDelivery = :isDelivery"),
    @NamedQuery(name = "Buy.findByDeliveryAddress", query = "SELECT b FROM Buy b WHERE b.deliveryAddress = :deliveryAddress"),
    @NamedQuery(name = "Buy.findByAmount", query = "SELECT b FROM Buy b WHERE b.amount = :amount"),
    @NamedQuery(name = "Buy.findByBuyDate", query = "SELECT b FROM Buy b WHERE b.buyDate = :buyDate")})
public class Buy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "userid")
    private String userid;
    @Column(name = "productid")
    private Integer productid;
    @Column(name = "marketId")
    private Integer marketId;
    @Column(name = "isDelivery")
    private Boolean isDelivery;
    @Size(max = 100)
    @Column(name = "deliveryAddress")
    private String deliveryAddress;
    @Column(name = "amount")
    private Integer amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "buyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date buyDate;

    public Buy() {
    }

    public Buy(Integer id) {
        this.id = id;
    }

    public Buy(Integer id, Date buyDate) {
        this.id = id;
        this.buyDate = buyDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getMarketId() {
        return marketId;
    }

    public void setMarketId(Integer marketId) {
        this.marketId = marketId;
    }

    public Boolean getIsDelivery() {
        return isDelivery;
    }

    public void setIsDelivery(Boolean isDelivery) {
        this.isDelivery = isDelivery;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
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
        if (!(object instanceof Buy)) {
            return false;
        }
        Buy other = (Buy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gi.shop.hebirnate.Buy[ id=" + id + " ]";
    }

}
