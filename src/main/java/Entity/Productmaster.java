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
import javax.validation.constraints.Size;

/**
 *
 * @author Varun
 */
@Entity
@Table(name = "productmaster")
@NamedQueries({
    @NamedQuery(name = "Productmaster.findAll", query = "SELECT p FROM Productmaster p"),
    @NamedQuery(name = "Productmaster.findByPid", query = "SELECT p FROM Productmaster p WHERE p.pid = :pid"),
    @NamedQuery(name = "Productmaster.findByPname", query = "SELECT p FROM Productmaster p WHERE p.pname = :pname"),
    @NamedQuery(name = "Productmaster.findByRam", query = "SELECT p FROM Productmaster p WHERE p.ram = :ram"),
    @NamedQuery(name = "Productmaster.findByProcessor", query = "SELECT p FROM Productmaster p WHERE p.processor = :processor"),
    @NamedQuery(name = "Productmaster.findByScreenSize", query = "SELECT p FROM Productmaster p WHERE p.screenSize = :screenSize"),
    @NamedQuery(name = "Productmaster.findByColor", query = "SELECT p FROM Productmaster p WHERE p.color = :color"),
    @NamedQuery(name = "Productmaster.findByPrice", query = "SELECT p FROM Productmaster p WHERE p.price = :price"),
    @NamedQuery(name = "Productmaster.findByInternalstorage", query = "SELECT p FROM Productmaster p WHERE p.internalstorage = :internalstorage"),
    @NamedQuery(name = "Productmaster.findByNetworktype", query = "SELECT p FROM Productmaster p WHERE p.networktype = :networktype"),
    @NamedQuery(name = "Productmaster.findByBatterycapacity", query = "SELECT p FROM Productmaster p WHERE p.batterycapacity = :batterycapacity"),
    @NamedQuery(name = "Productmaster.findByDescription", query = "SELECT p FROM Productmaster p WHERE p.description = :description"),
    @NamedQuery(name = "Productmaster.findByQuantity", query = "SELECT p FROM Productmaster p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "Productmaster.findByProductimage", query = "SELECT p FROM Productmaster p WHERE p.productimage = :productimage")})
public class Productmaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pid")
    private Integer pid;
    @Size(max = 50)
    @Column(name = "pname")
    private String pname;
    @Size(max = 30)
    @Column(name = "ram")
    private String ram;
    @Size(max = 30)
    @Column(name = "processor")
    private String processor;
    @Size(max = 30)
    @Column(name = "screen_size")
    private String screenSize;
    @Size(max = 30)
    @Column(name = "color")
    private String color;
    @Column(name = "price")
    private Integer price;
    @Size(max = 30)
    @Column(name = "internalstorage")
    private String internalstorage;
    @Size(max = 30)
    @Column(name = "networktype")
    private String networktype;
    @Size(max = 30)
    @Column(name = "batterycapacity")
    private String batterycapacity;
    @Size(max = 50)
    @Column(name = "description")
    private String description;
    @Column(name = "quantity")
    private Integer quantity;
    @Size(max = 400)
    @Column(name = "productimage")
    private String productimage;
    @JoinColumn(name = "bid", referencedColumnName = "bid")
    @ManyToOne
    private Brandmaster bid;
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    @ManyToOne
    @JsonbTransient
    private Categorymaster cid;

    public Productmaster() {
    }

    public Productmaster(Integer pid) {
        this.pid = pid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getInternalstorage() {
        return internalstorage;
    }

    public void setInternalstorage(String internalstorage) {
        this.internalstorage = internalstorage;
    }

    public String getNetworktype() {
        return networktype;
    }

    public void setNetworktype(String networktype) {
        this.networktype = networktype;
    }

    public String getBatterycapacity() {
        return batterycapacity;
    }

    public void setBatterycapacity(String batterycapacity) {
        this.batterycapacity = batterycapacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductimage() {
        return productimage;
    }

    public void setProductimage(String productimage) {
        this.productimage = productimage;
    }

    public Brandmaster getBid() {
        return bid;
    }

    public void setBid(Brandmaster bid) {
        this.bid = bid;
    }

    public Categorymaster getCid() {
        return cid;
    }

    public void setCid(Categorymaster cid) {
        this.cid = cid;
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
        if (!(object instanceof Productmaster)) {
            return false;
        }
        Productmaster other = (Productmaster) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Productmaster[ pid=" + pid + " ]";
    }
    
}
