/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package EJB;

import Entity.Addcart;
import Entity.Productmaster;
import Entity.Registration;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Varun
 */
@Local
public interface UserBeanLocal {
    
    String addRegistration(String username, String email, int mobileno, String address, int pincode, String password, int gid);
    String updateRegistration(String username, String email, int mobileno, String address, int pincode, String password, int gid);
    void removeRegistration(String email);
    Collection<Registration> getAllRegistration();
    
    public String addAddCart(String email,int pid,int quantity);
//     public Addcart addToCart(Addcart cart, String email, int pid, int qty);
    public void removeAddCart(String email,int pid);
    public Collection<Addcart> viewCart(String email);
    Collection<Addcart> getAllCarts();
    
    Productmaster getProductDetails(int pid);
    
    Registration findEmail(String email);
    
    public String sayHello(String name);

    public String updateRegistration(String username, String email, int mobileno, String address, int pincode, String password);

    public String addRegistration(String username, String email, int mobileno, String address, int pincode, String password);

   
    
    
}
