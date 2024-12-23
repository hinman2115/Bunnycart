/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import javax.json.bind.annotation.JsonbTransient;
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

/**
 *
 * @author Varun
 */
@Entity
@Table(name = "addcart")
@NamedQueries({
    @NamedQuery(name = "Addcart.findAll", query = "SELECT a FROM Addcart a"),
    @NamedQuery(name = "Addcart.findByCarttid", query = "SELECT a FROM Addcart a WHERE a.carttid = :carttid"),
    @NamedQuery(name = "Addcart.findByQty", query = "SELECT a FROM Addcart a WHERE a.qty = :qty"),
    @NamedQuery(name = "Addcart.findByPrice", query = "SELECT a FROM Addcart a WHERE a.price = :price")})
public class Addcart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "carttid")
    private Integer carttid;
    @Column(name = "qty")
    private Integer qty;
    @Column(name = "price")
    private Integer price;
    @JoinColumn(name = "pid", referencedColumnName = "pid")
    @ManyToOne
    private Productmaster pid;
    @JoinColumn(name = "email", referencedColumnName = "email")
    @ManyToOne
      
    private Registration email;

    public Addcart() {
    }

    public Addcart(Integer carttid) {
        this.carttid = carttid;
    }

    public Integer getCarttid() {
        return carttid;
    }

    public void setCarttid(Integer carttid) {
        this.carttid = carttid;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Productmaster getPid() {
        return pid;
    }

    public void setPid(Productmaster pid) {
        this.pid = pid;
    }

    public Registration getEmail() {
        return email;
    }

    public void setEmail(Registration email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carttid != null ? carttid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Addcart)) {
            return false;
        }
        Addcart other = (Addcart) object;
        if ((this.carttid == null && other.carttid != null) || (this.carttid != null && !this.carttid.equals(other.carttid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Addcart[ carttid=" + carttid + " ]";
    }
    
}
