/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "categorymaster")
@NamedQueries({
    @NamedQuery(name = "Categorymaster.findAll", query = "SELECT c FROM Categorymaster c"),
    @NamedQuery(name = "Categorymaster.findByCid", query = "SELECT c FROM Categorymaster c WHERE c.cid = :cid"),
    @NamedQuery(name = "Categorymaster.findByCname", query = "SELECT c FROM Categorymaster c WHERE c.cname = :cname")})
public class Categorymaster implements Serializable {

    @Size(max = 255)
    @Column(name = "cname")
    private String cname;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cid")
    private Integer cid;
    @OneToMany(mappedBy = "cid")
     @JsonbTransient
    private List<Productmaster> productmasterList;

    public Categorymaster() {
    }

    public Categorymaster(Integer cid) {
        this.cid = cid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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
        hash += (cid != null ? cid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorymaster)) {
            return false;
        }
        Categorymaster other = (Categorymaster) object;
        if ((this.cid == null && other.cid != null) || (this.cid != null && !this.cid.equals(other.cid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Categorymaster[ cid=" + cid + " ]";
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
    
}
