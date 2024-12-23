/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
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
import java.util.Collection;
import javax.ejb.Local;
import java.util.Date;

/**
 *
 * @author Varun
 */
@Local
public interface AdminBeanLocal {
    void addProductmaster(String pname,String ram,String processor,String screenSize,String color,Integer price,String internalstorage,String networktype,String batterycapacity,String description,Integer quantity,String productimage);
    void updateProductmaster(Integer pid, String pname, String ram, String processor, String screenSize, String color, Integer price, String internalstorage, String networktype, String batterycapacity, String description, Integer quantity, String productimage, Integer bid, Integer cid);
    void removeProductmaster(int pid);
    Collection<Productmaster> getAllProductmaster();

    void addGroupmaster(String gname);
    void updateGroupmaster(int gid, String gname);
    void removeGroupmaster(int gid);
    Collection<Groupmaster> getAllGroupmaster();

    void addCategorymaster(String cname);
    void updateCategorymaster(int cid, String cname);
    void removeCategorymaster(int cid);
    Collection<Categorymaster> getAllCategorymaster();
    
    void addBrandmaster(String bname);
    void updateBrandmaster(int bid, String bname);
    void removeBrandmaster(int bid);
    Collection<Brandmaster> getAllBrandmaster();

    String addRegistration(String username, String email, int mobileno, String address, int pincode, String password);
    String updateRegistration(String username, String email, int mobileno, String address, int pincode, String password);
    void removeRegistration(String email);
    Collection<Registration> getAllRegistration();

    String addPaymentmaster(String payment_type, String status, int oid);
    String updatePaymentmaster(int pid, String payment_type, String status, int oid);
    void removePaymentmaster(int pid);
    Collection<Paymentmaster> getAllPaymentmaster();

    void addOrdermaster( String email, int totalamount, String status);
    void updateOrdermaster(int oid, String email, int totalamount, String status);
    void removeOrdermaster(int oid);
    Collection<Ordermaster> getAllOrdermaster();
    
    String addOrderdetails(int qty,int rate,int amount, int oid,int pid);
    void removeOrderdetails(int odid);
    Collection<Orderdetails> getAllOrderdetails();
    
    public String sayHello(String name);
}
