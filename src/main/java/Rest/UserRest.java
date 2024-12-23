/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package Rest;

import EJB.UserBeanLocal;
import Entity.Addcart;
import Entity.Productmaster;
import Entity.Registration;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Varun
 */
@Path("UserRest")
@RequestScoped
public class UserRest {
    
    @EJB UserBeanLocal ubl;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserRest
     */
    public UserRest() {
    }
    
  @POST
    @Path("/registration/{username}/{email}/{mobileno}/{address}/{pincode}/{password}")
    public String addRegistration(@PathParam("username") String username,
                                  @PathParam("email") String email,
                                  @PathParam("mobileno") int mobileno,
                                  @PathParam("address") String address,
                                  @PathParam("pincode") int pincode,
                                  @PathParam("password") String password) {
        return ubl.addRegistration(username, email, mobileno, address, pincode, password);
    }

    @PUT
    @Path("/registration/{username}/{email}/{mobileno}/{address}/{pincode}/{password}")
    public String updateRegistration(@PathParam("username") String username,
                                     @PathParam("email") String email,
                                     @PathParam("mobileno") int mobileno,
                                     @PathParam("address") String address,
                                     @PathParam("pincode") int pincode,
                                     @PathParam("password") String password) {
        return ubl.updateRegistration(username, email, mobileno, address, pincode, password);
    }

    @DELETE
    @Path("/registration/{email}")
    public void removeRegistration(@PathParam("email") String email) {
        ubl.removeRegistration(email);
    }

    @GET
    @Path("/registrations")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Registration> getAllRegistration() {
        return ubl.getAllRegistration();
    }
   
//    @POST
//    @Path("/add")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Addcart addToCart( Addcart cart,String email, int productid, int qty) {
//       return ubl.addToCart(cart, email, productid, qty);
//    }
    
//    @POST
//    @Path("/add/{email}/{qty}")
//    public Addcart addToCart(
//            Addcart cart,
//            @PathParam("email") String email,
//            @PathParam("qty") int qty
//            ) {
//       
//        // Assuming ubl is an instance of a service or business logic class
//        return ubl.addToCart(cart,email,cart.getPid().getPid(),qty);
//    }
    @POST
    @Path("/add/{email}/{pid}/{qty}")
    public String addToCart(
            @PathParam("email") String email,
            @PathParam("pid") int productId,
            @PathParam("qty") int quantity) {
        
        return ubl.addAddCart(email, productId, quantity);
        
    }
    
    
    @GET
    @Path("viewCart/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Addcart> viewCart(@PathParam("email") String email) {
        return ubl.viewCart(email);
    }
    
    @DELETE
    @Path("deteleProductFromCart/{email}/{productid}")
    public void removeCart(@PathParam("email") String email, @PathParam("productid") int productid) {
        ubl.removeAddCart(email, productid);
    }
    
    @GET
    @Path("getProductDetails/{pid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Productmaster getProductDetails(@PathParam("pid") int pid) {
        return ubl.getProductDetails(pid);
    }
    
     @GET
    @Path("getFindByEmail/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Registration getRegistrationByEmail(@PathParam("email") String email) {
        return ubl.findEmail(email); 
    }
    
     @GET
    @Path("/cartss")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Addcart> getAllCarts() {
        return ubl.getAllCarts();
    }
}
