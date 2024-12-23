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
@Table(name = "orderdetails")
@NamedQueries({
    @NamedQuery(name = "Orderdetails.findAll", query = "SELECT o FROM Orderdetails o"),
    @NamedQuery(name = "Orderdetails.findByOdid", query = "SELECT o FROM Orderdetails o WHERE o.odid = :odid"),
    @NamedQuery(name = "Orderdetails.findByQty", query = "SELECT o FROM Orderdetails o WHERE o.qty = :qty"),
    @NamedQuery(name = "Orderdetails.findByRate", query = "SELECT o FROM Orderdetails o WHERE o.rate = :rate"),
    @NamedQuery(name = "Orderdetails.findByAmount", query = "SELECT o FROM Orderdetails o WHERE o.amount = :amount")})
public class Orderdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "odid")
    private Integer odid;
    @Column(name = "qty")
    private Integer qty;
    @Column(name = "rate")
    private Integer rate;
    @Column(name = "amount")
    private Integer amount;
    @JoinColumn(name = "oid", referencedColumnName = "oid")
    @ManyToOne
    private Ordermaster oid;
    @JoinColumn(name = "pid", referencedColumnName = "pid")
    @ManyToOne
    @JsonbTransient
    private Paymentmaster pid;

    public Orderdetails() {
    }

    public Orderdetails(Integer odid) {
        this.odid = odid;
    }

    public Integer getOdid() {
        return odid;
    }

    public void setOdid(Integer odid) {
        this.odid = odid;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Ordermaster getOid() {
        return oid;
    }

    public void setOid(Ordermaster oid) {
        this.oid = oid;
    }

    public Paymentmaster getPid() {
        return pid;
    }

    public void setPid(Paymentmaster pid) {
        this.pid = pid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (odid != null ? odid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderdetails)) {
            return false;
        }
        Orderdetails other = (Orderdetails) object;
        if ((this.odid == null && other.odid != null) || (this.odid != null && !this.odid.equals(other.odid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Orderdetails[ odid=" + odid + " ]";
    }
    
}
