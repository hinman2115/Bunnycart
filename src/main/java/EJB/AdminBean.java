/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package EJB;

import Entity.Brandmaster;
import Entity.Categorymaster;
import Entity.Groupmaster;
import Entity.Orderdetails;
import Entity.Ordermaster;
import Entity.Paymentmaster;
import Entity.Productmaster;
import Entity.Registration;
import java.awt.SystemColor;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author Varun
 */
@Stateless
public class AdminBean implements AdminBeanLocal {

    @PersistenceContext(unitName = "mobilemart")
    EntityManager em;
    
    
    Pbkdf2PasswordHashImpl pb = new Pbkdf2PasswordHashImpl();

    @Override
    public void addProductmaster(String pname, String ram, String processor, String screenSize, String color, Integer price, String internalstorage, String networktype, String batterycapacity, String description, Integer quantity, String productimage) {

        Productmaster p = new Productmaster();

        Brandmaster bm = em.find(Brandmaster.class, 1);
        Categorymaster cm = em.find(Categorymaster.class, 4);

        p.setPname(pname);
        p.setRam(ram);
        p.setProcessor(processor);
        p.setScreenSize(screenSize);
        p.setColor(color);
        p.setPrice(price);
        p.setInternalstorage(internalstorage);
        p.setNetworktype(networktype);
        p.setBatterycapacity(batterycapacity);
        p.setDescription(description);
        p.setQuantity(quantity);
        p.setProductimage(productimage);
        p.setBid(bm);
        p.setCid(cm);

        em.persist(p);

    }

    @Override
    public void updateProductmaster(Integer pid, String pname, String ram, String processor, String screenSize, String color, Integer price, String internalstorage, String networktype, String batterycapacity, String description, Integer quantity, String productimage, Integer bid, Integer cid) {
        // Retrieve the existing product by its ID
        Productmaster p = em.find(Productmaster.class, pid);

        if (p != null) {

            Brandmaster bm = em.find(Brandmaster.class, bid);
            Categorymaster cm = em.find(Categorymaster.class, cid);
            // Update the existing product's attributes
            p.setPname(pname);
            p.setRam(ram);
            p.setProcessor(processor);
            p.setScreenSize(screenSize);
            p.setColor(color);
            p.setPrice(price);
            p.setInternalstorage(internalstorage);
            p.setNetworktype(networktype);
            p.setBatterycapacity(batterycapacity);
            p.setDescription(description);
            p.setQuantity(quantity);
            p.setProductimage(productimage);
            p.setBid(bm);
            p.setCid(cm);

            // Persist the updated product
            em.merge(p);
        }

    }

    @Override
    public void removeProductmaster(int pid) {

        Productmaster p = em.find(Productmaster.class, pid);

        em.remove(p);

    }

    @Override
    public Collection<Productmaster> getAllProductmaster() {

        Collection<Productmaster> p = em.createNamedQuery("Productmaster.findAll").getResultList();
        return p;
    }

    @Override
    public void addGroupmaster(String gname) {

        Groupmaster g = new Groupmaster();

        g.setGname(gname);

        em.persist(g);

    }

    @Override
    public void updateGroupmaster(int gid, String gname) {

        Groupmaster g = em.find(Groupmaster.class, gid);

        g.setGid(gid);
        g.setGname(gname);

        em.merge(g);
    }

    @Override
    public void removeGroupmaster(int gid) {

        Groupmaster g = em.find(Groupmaster.class, gid);

        em.remove(g);
    }

    @Override
    public Collection<Groupmaster> getAllGroupmaster() {

        Collection<Groupmaster> g = em.createNamedQuery("Groupmaster.findAll").getResultList();
        return g;
    }

    
    @Override
    public void addCategorymaster(String cname) {

        Categorymaster c = new Categorymaster();

        c.setCname(cname);

        em.persist(c);

    }

    @Override
    public void updateCategorymaster(int cid, String cname) {

        Categorymaster c = em.find(Categorymaster.class, cid);

        c.setCid(cid);
        c.setCname(cname);

        em.merge(c);
    }

    @Override
    public void removeCategorymaster(int cid) {

        Categorymaster c = em.find(Categorymaster.class, cid);

        em.remove(c);
    }

    @Override
    public Collection<Categorymaster> getAllCategorymaster() {

        Collection<Categorymaster> c = em.createNamedQuery("Categorymaster.findAll").getResultList();
        return c;
    }

    @Override
    public void addBrandmaster(String bname) {

        Brandmaster b = new Brandmaster();

        b.setBname(bname);

        em.persist(b);

    }

    @Override
    public void updateBrandmaster(int bid, String bname) {

        Brandmaster b = em.find(Brandmaster.class, bid);

        b.setBid(bid);
        b.setBname(bname);

        em.merge(b);
    }

    @Override
    public void removeBrandmaster(int bid) {

        Brandmaster b = em.find(Brandmaster.class, bid);

        em.remove(b);
    }

    @Override
    public Collection<Brandmaster> getAllBrandmaster() {

        Collection<Brandmaster> b = em.createNamedQuery("Brandmaster.findAll").getResultList();
        return b;
    }

    @Override
    public String addRegistration(String username, String email, int mobileno, String address, int pincode, String password) {
        try {
            Groupmaster g = em.find(Groupmaster.class, 2);
            Registration r = new Registration();
            
              String encpassword = pb.generate(password.toCharArray());
            
            r.setUsername(username);
            r.setEmail(email);
            r.setMobileno(mobileno);
            r.setAddress(address);
            r.setPincode(pincode);
            r.setPassword(encpassword);
            r.setGid(g);

            em.persist(r);
            return "inserted";

        } catch (Exception ex) {
            // Handle exceptions here
            return "Error: " + ex.getMessage();
        }
    }

    @Override
    public String updateRegistration(String username, String email, int mobileno, String address, int pincode, String password) {

        try {
            Groupmaster g = em.find(Groupmaster.class, 2);

            Registration r = em.find(Registration.class, email);

            r.setUsername(username);
            r.setEmail(email);
            r.setMobileno(mobileno);
            r.setAddress(address);
            r.setPincode(pincode);
            r.setPassword(password);
            r.setGid(g);

            em.merge(r);

            return "updated";

        } catch (Exception ex) {
            // Handle exceptions here
            return "Error: " + ex.getMessage();
        }
    }

    @Override
    public void removeRegistration(String email) {

        Registration r = em.find(Registration.class, email);

        em.remove(r);
    }

    @Override
    public Collection<Registration> getAllRegistration() {

        Collection<Registration> r = em.createNamedQuery("Registration.findAll").getResultList();
        return r;
    }

    @Override
    public String addPaymentmaster(String payment_type, String status, int oid) {
        try {

            Ordermaster om = em.find(Ordermaster.class, oid);

            if (om != null) {

                Collection<Paymentmaster> pm = om.getPaymentmasterList();

                Paymentmaster p = new Paymentmaster();

                // Set payment details
                p.setPaymentType(payment_type);
                p.setStatus(status);
                p.setOid(om);

                pm.add(p);

                om.setPaymentmasterCollection(pm);

                // Persist the new Paymentmaster entity
                em.persist(p);

                // Merge changes to the Ordermaster entity
                em.merge(om);

                return "inserted";
            } else {
                return "Ordermaster not found for ID: " + oid;
            }
        } catch (Exception ex) {
            // Handle exceptions here
            return "Error: " + ex.getMessage();
        }
    }

    @Override
    public String updatePaymentmaster(int pid, String payment_type, String status, int oid) {

        try {

            Ordermaster om = em.find(Ordermaster.class, oid);

            if (om != null) {

                Collection<Paymentmaster> pm = om.getPaymentmasterList();

                Paymentmaster p = em.find(Paymentmaster.class, om);

                if (pm.contains(p)) {
                    pm.remove(p);

                    p.setPaymentType(payment_type);
                    p.setStatus(status);
                    p.setOid(om);

                    pm.add(p);

                    om.setPaymentmasterCollection(pm);

                    em.merge(p);
                    em.merge(om);
                }
                return "updated";
            } else {
                return "Ordermaster not found for ID: " + oid;
            }
        } catch (Exception ex) {
            // Handle exceptions here
            return "Error: " + ex.getMessage();
        }

    }

    @Override
    public void removePaymentmaster(int pid) {

        Paymentmaster pm = em.find(Paymentmaster.class, pid);

        em.remove(pm);

    }

    @Override
    public Collection<Paymentmaster> getAllPaymentmaster() {

        Collection<Paymentmaster> p = em.createNamedQuery("Paymentmaster.findAll").getResultList();
        return p;
    }

    @Override
    public void addOrdermaster( String email, int totalamount, String status) {

        Ordermaster om = new Ordermaster();

        om.setOdate(new Date());
        om.setEmail(email);
        om.setTotalamount(totalamount);
        om.setStatus(status);

        em.persist(om);

    }

    @Override
    public void updateOrdermaster(int oid, String email, int totalamount, String status) {

        Ordermaster om = em.find(Ordermaster.class, oid);
        om.setOid(oid);
        om.setOdate(new Date());
        om.setEmail(email);
        om.setTotalamount(totalamount);
        om.setStatus(status);

        em.merge(om);

    }

    @Override
    public void removeOrdermaster(int oid) {

        Ordermaster om = em.find(Ordermaster.class, oid);

        em.remove(om);
    }

    @Override
    public Collection<Ordermaster> getAllOrdermaster() {

        Collection<Ordermaster> om = em.createNamedQuery("Ordermaster.findAll").getResultList();
        return om;
    }

    @Override
    public String addOrderdetails(int qty, int rate, int amount, int oid, int pid) {
        try {

            Ordermaster om = em.find(Ordermaster.class, oid);
            Paymentmaster pm = em.find(Paymentmaster.class, pid);

            Orderdetails o = new Orderdetails();

            o.setQty(qty);
            o.setRate(rate);
            o.setAmount(amount);
            o.setOid(om);
            o.setPid(pm);

            em.persist(o);

            return "inserted";

        } catch (Exception ex) {
            // Handle exceptions here
            return "Error: " + ex.getMessage();
        }
    }

    @Override
    public void removeOrderdetails(int odid) {

        Orderdetails od = em.find(Orderdetails.class, odid);

        em.remove(od);
    }

    @Override
    public Collection<Orderdetails> getAllOrderdetails() {

        Collection<Orderdetails> od = em.createNamedQuery("Orderdetails.findAll").getResultList();
        return od;
    }

    @Override
    public String sayHello(String name) {
        return "<h1>" + name + "</h1>";
    }

}
