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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "paymentmaster")
@NamedQueries({
    @NamedQuery(name = "Paymentmaster.findAll", query = "SELECT p FROM Paymentmaster p"),
    @NamedQuery(name = "Paymentmaster.findByPid", query = "SELECT p FROM Paymentmaster p WHERE p.pid = :pid"),
    @NamedQuery(name = "Paymentmaster.findByPaymentType", query = "SELECT p FROM Paymentmaster p WHERE p.paymentType = :paymentType"),
    @NamedQuery(name = "Paymentmaster.findByStatus", query = "SELECT p FROM Paymentmaster p WHERE p.status = :status")})
public class Paymentmaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pid")
    private Integer pid;
    @Size(max = 50)
    @Column(name = "payment_type")
    private String paymentType;
    @Size(max = 50)
    @Column(name = "status")
    private String status;
    @OneToMany(mappedBy = "pid")
    private List<Orderdetails> orderdetailsList;
    @JoinColumn(name = "oid", referencedColumnName = "oid")
    @ManyToOne
    @JsonbTransient
    private Ordermaster oid;

    public Paymentmaster() {
    }

    public Paymentmaster(Integer pid) {
        this.pid = pid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Orderdetails> getOrderdetailsList() {
        return orderdetailsList;
    }

    public void setOrderdetailsList(List<Orderdetails> orderdetailsList) {
        this.orderdetailsList = orderdetailsList;
    }

    public Ordermaster getOid() {
        return oid;
    }

    public void setOid(Ordermaster oid) {
        this.oid = oid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pid != null ? pid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paymentmaster)) {
            return false;
        }
        Paymentmaster other = (Paymentmaster) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Paymentmaster[ pid=" + pid + " ]";
    }
    
}
