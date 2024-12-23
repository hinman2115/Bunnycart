/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package EJB;

import Entity.Addcart;
import Entity.Groupmaster;
import Entity.Productmaster;
import Entity.Registration;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Varun
 */
@Stateless
public class UserBean implements UserBeanLocal {

    @PersistenceContext(unitName = "mobilemart")
     EntityManager em;
    
 @Override
    public String addRegistration(String username, String email, int mobileno, String address, int pincode, String password, int gid) {
        try{
         Groupmaster g = em.find(Groupmaster.class, gid);
        Registration r = new Registration();
        
        r.setUsername(username);
        r.setEmail(email);
        r.setMobileno(mobileno);
        r.setAddress(address);
        r.setPincode(pincode);
        r.setPassword(password);
        r.setGid(g);
        
        em.persist(r);
         return "inserted";
        
    } catch (Exception ex) {
        // Handle exceptions here
        return "Error: " + ex.getMessage();
    }
    }
    
     @Override
    public String updateRegistration(String username, String email, int mobileno, String address, int pincode, String password, int gid) {
        
         try{
         Groupmaster g = em.find(Groupmaster.class, gid);
         
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
    public String addAddCart(String email, int pid, int qty) {
        
        System.out.println("email"+ email);
        System.out.println("product id"+ pid);
        System.out.println("qty"+ qty);
        try {
            Productmaster product = em.find(Productmaster.class, pid);
            Registration user = em.find(Registration.class, email);

            if (product != null && product.getQuantity() >= qty && user != null) {
                Addcart cart = new Addcart();
                cart.setEmail(user);
                cart.setPid(product);
                cart.setQty(qty);
                cart.setPrice((int) (qty * product.getPrice()));

                em.persist(cart);

            } else {
                System.err.println("Eather Email,Productid or Quantity is null");
            }
        } catch (Exception ex) {
            System.out.println("In addto cart : "+ex.getMessage());
        }
        return "";
    }
    
//    public Addcart addToCart(Addcart cart, String email, int pid, int qty) {
//        
//        Registration r = em.find(Registration.class, email);
//        Productmaster p = em.find(Productmaster.class, pid);
//
//        cart.setEmail(r);
//        cart.setPid(p);
//        cart.setPrice((int) (qty * p.getPrice()));
//        em.persist(cart);
//        return cart;
//    }

    @Override
    public void removeAddCart(String email, int pid) {
        try {
            Registration user = em.find(Registration.class, email);
            Productmaster product = em.find(Productmaster.class, pid);

            if (user == null) {
                throw new IllegalArgumentException("User Not Found!!!");
            } else {
                TypedQuery<Addcart> query = em.createQuery(
                        "SELECT c FROM Addcart c WHERE c.email = :user AND c.pid = :pid", Addcart.class);
                query.setParameter("user", user);
                query.setParameter("pid", product);

                List<Addcart> carts = query.getResultList();

                if (!carts.isEmpty()) {
                    Addcart productInCart = carts.get(0);
                    em.remove(productInCart);
                    System.out.println("Product removed from the user's cart.");
                } else {
                    System.out.println("Product not found in the user's cart.");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Collection<Addcart> viewCart(String email) {
        try {
            if (email == null) {
                throw new IllegalArgumentException("Invalid Email!!!");
            }

//            System.out.println("Email: " + email); 
            TypedQuery<Addcart> query = em.createQuery("SELECT c FROM Cart c WHERE c.Registration.email = :email", Addcart.class);
            query.setParameter("email", email);
            Collection<Addcart> result = query.getResultList();
//            System.out.println("Result Size: " + result.size());  

            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    @Override
    public Productmaster getProductDetails(int pid) {

        try {
            Productmaster product = em.find(Productmaster.class, pid);

            if (product != null) {
                return product;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    
    @Override
    public Registration findEmail(String email) {
        try {
//            TypedQuery<Registration> query = em.createQuery(
//                    "SELECT r FROM Registration r WHERE r.email = :email", Registration.class);
//            query.setParameter("email", email);
//
//            // Retrieve the Registration entity based on the email
//            Registration registration = query.getSingleResult();
            Registration registration = (Registration)em.createNamedQuery("Registration.findByEmail")
                    .setParameter("email", email)
                    .getSingleResult();

            if (registration != null) {
                return registration;
            } else {
                return null;
            }
        } catch (NoResultException e) {
            // Handle case when no Registration entity is found for the provided email
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public Collection<Addcart> getAllCarts() {

        Collection<Addcart> ac = em.createNamedQuery("Addcart.findAll").getResultList();
        return ac;
    }

    @Override
    public String sayHello(String name) {
        return "Hello" + name + "in REst";
    }

    @Override
    public String updateRegistration(String username, String email, int mobileno, String address, int pincode, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String addRegistration(String username, String email, int mobileno, String address, int pincode, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

   
    
    

    
}
