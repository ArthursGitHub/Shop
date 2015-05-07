/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gi.shop.hebirnate;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ильяс
 */
@Entity
@Table(name = "markets")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Markets.findAll", query = "SELECT m FROM Markets m"),
    @NamedQuery(name = "Markets.findById", query = "SELECT m FROM Markets m WHERE m.id = :id"),
    @NamedQuery(name = "Markets.findByAddress", query = "SELECT m FROM Markets m WHERE m.address = :address"),
    @NamedQuery(name = "Markets.findByX", query = "SELECT m FROM Markets m WHERE m.x = :x"),
    @NamedQuery(name = "Markets.findByY", query = "SELECT m FROM Markets m WHERE m.y = :y")})
public class Markets implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "address")
    private String address;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "x")
    private Float x;
    @Column(name = "y")
    private Float y;

    public Markets() {
    }

    public Markets(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
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
        if (!(object instanceof Markets)) {
            return false;
        }
        Markets other = (Markets) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gi.shop.hebirnate.Markets[ id=" + id + " ]";
    }
    
}
