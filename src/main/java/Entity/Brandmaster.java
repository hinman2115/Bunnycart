/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.json.bind.annotation.JsonbAnnotation;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Varun
 */
@Entity
@Table(name = "brandmaster")
@NamedQueries({
    @NamedQuery(name = "Brandmaster.findAll", query = "SELECT b FROM Brandmaster b"),
    @NamedQuery(name = "Brandmaster.findByBid", query = "SELECT b FROM Brandmaster b WHERE b.bid = :bid"),
    @NamedQuery(name = "Brandmaster.findByBname", query = "SELECT b FROM Brandmaster b WHERE b.bname = :bname")})
public class Brandmaster implements Serializable {

    @Size(max = 255)
    @Column(name = "bname")
    private String bname;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bid")
    private Integer bid;
    @OneToMany(mappedBy = "bid")
    @JsonbTransient
    private List<Productmaster> productmasterList;

    public Brandmaster() {
    }

    public Brandmaster(Integer bid) {
        this.bid = bid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }


    public List<Productmaster> getProductmasterList() {
        return productmasterList;
    }

    public void setProductmasterList(List<Productmaster> productmasterList) {
        this.productmasterList = productmasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bid != null ? bid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Brandmaster)) {
            return false;
        }
        Brandmaster other = (Brandmaster) object;
        if ((this.bid == null && other.bid != null) || (this.bid != null && !this.bid.equals(other.bid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Brandmaster[ bid=" + bid + " ]";
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }
    
}
