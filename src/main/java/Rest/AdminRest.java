/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package Rest;

import EJB.AdminBeanLocal;
import Entity.Brandmaster;
import Entity.Categorymaster;
import Entity.Groupmaster;
import Entity.Orderdetails;
import Entity.Ordermaster;
import Entity.Paymentmaster;
import Entity.Productmaster;
import Entity.Registration;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import org.glassfish.soteria.identitystores.hash.PasswordHashCompare;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 * REST Web Service
 *
 * @author Varun
 */
@Path("AdminBean")
public class AdminRest {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AdminRest
     */
    @EJB AdminBeanLocal adminBean;
    
//     Pbkdf2PasswordHashImpl pb;
// PasswordHashCompare phc;

    @POST
    @Path("product/{pname}/{ram}/{processor}/{screenSize}/{color}/{price}/{internalstorage}/{networktype}/{batterycapacity}/{description}/{quantity}/{productimage}")
    public void addProductmaster(@PathParam("pname") String pname,
                                 @PathParam("ram") String ram,
                                 @PathParam("processor") String processor,
                                 @PathParam("screenSize") String screenSize,
                                 @PathParam("color") String color,
                                 @PathParam("price") Integer price,
                                 @PathParam("internalstorage") String internalstorage,
                                 @PathParam("networktype") String networktype,
                                 @PathParam("batterycapacity") String batterycapacity,
                                 @PathParam("description") String description,
                                 @PathParam("quantity") Integer quantity,
                                 @PathParam("productimage") String productimage
                                 ) {
        
       adminBean.addProductmaster(pname, ram, processor, screenSize, color, price, internalstorage, networktype, batterycapacity, description, quantity, productimage);
    }

    @PUT
    @Path("product/{pid}/{pname}/{ram}/{processor}/{screenSize}/{color}/{price}/{internalstorage}/{networktype}/{batterycapacity}/{description}/{quantity}/{productimage}/{bid}/{cid}")
    public void updateProductmaster(@PathParam("pid") int pid,
                                    @PathParam("pname") String pname,
                                    @PathParam("ram") String ram,
                                    @PathParam("processor") String processor,
                                    @PathParam("screenSize") String screenSize,
                                    @PathParam("color") String color,
                                    @PathParam("price") Integer price,
                                    @PathParam("internalstorage") String internalstorage,
                                    @PathParam("networktype") String networktype,
                                    @PathParam("batterycapacity") String batterycapacity,
                                    @PathParam("description") String description,
                                    @PathParam("quantity") Integer quantity,
                                    @PathParam("productimage") String productimage,
                                    @PathParam("bid") Integer bid,
                                    @PathParam("cid") Integer cid) {
       
        adminBean.updateProductmaster(pid, pname, ram, processor, screenSize, color, price,
                internalstorage, networktype, batterycapacity, description, quantity, productimage,
                bid, cid);
    }

    @DELETE
    @Path("/product/{pid}")
    public void removeProductmaster(@PathParam("pid") int pid) {
        adminBean.removeProductmaster(pid);
    }

    @GET
    @Path("/products")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Productmaster> getAllProductmaster() {
        return adminBean.getAllProductmaster();
    }

    @POST
    @Path("/group/{gname}")
    public void addGroupmaster(@PathParam("gname") String gname) {
        adminBean.addGroupmaster(gname);
    }

    @PUT
    @Path("/group/{gid}/{gname}")
    public void updateGroupmaster(@PathParam("gid") int gid, @PathParam("gname") String gname) {
        adminBean.updateGroupmaster(gid, gname);
    }

    @DELETE
    @Path("/group/{gid}")
    public void removeGroupmaster(@PathParam("gid") int gid) {
        adminBean.removeGroupmaster(gid);
    }

    @GET
    @Path("/groups")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Groupmaster> getAllGroupmaster() {
        return adminBean.getAllGroupmaster();
    }

    @POST
    @Path("/category/{cname}")
    public void addCategorymaster(@PathParam("cname") String cname) {
        adminBean.addCategorymaster(cname);
    }

    @PUT
    @Path("/category/{cid}/{cname}")
    public void updateCategorymaster(@PathParam("cid") int cid, @PathParam("cname") String cname) {
        adminBean.updateCategorymaster(cid, cname);
    }

    @DELETE
    @Path("/category/{cid}")
    public void removeCategorymaster(@PathParam("cid") int cid) {
        adminBean.removeCategorymaster(cid);
    }

    @GET
    @Path("/categories")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Categorymaster> getAllCategorymaster() {
        return adminBean.getAllCategorymaster();
    }

    @POST
    @Path("/brand/{bname}")
    public void addBrandmaster(@PathParam("bname") String bname) {
        adminBean.addBrandmaster(bname);
    }

    @PUT
    @Path("/brand/{bid}/{bname}")
    public void updateBrandmaster(@PathParam("bid") int bid, @PathParam("bname") String bname) {
        adminBean.updateBrandmaster(bid, bname);
    }

    @DELETE
    @Path("/brand/{bid}")
    public void removeBrandmaster(@PathParam("bid") int bid) {
        adminBean.removeBrandmaster(bid);
    }

    @GET
    @Path("/brands")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Brandmaster> getAllBrandmaster() {
        return adminBean.getAllBrandmaster();
    }

    @POST
    @Path("/registration/{username}/{email}/{mobileno}/{address}/{pincode}/{password}")
    public String addRegistration(@PathParam("username") String username,
                                  @PathParam("email") String email,
                                  @PathParam("mobileno") int mobileno,
                                  @PathParam("address") String address,
                                  @PathParam("pincode") int pincode,
                                  @PathParam("password") String password) {
//         pb = new Pbkdf2PasswordHashImpl();
//            phc= new PasswordHashCompare();
//             String enc = pb.generate(password.toCharArray());
        return adminBean.addRegistration(username, email, mobileno, address, pincode, password);
    }

    @PUT
    @Path("/registration/{username}/{email}/{mobileno}/{address}/{pincode}/{password}")
    public String updateRegistration(@PathParam("username") String username,
                                     @PathParam("email") String email,
                                     @PathParam("mobileno") int mobileno,
                                     @PathParam("address") String address,
                                     @PathParam("pincode") int pincode,
                                     @PathParam("password") String password) {
        return adminBean.updateRegistration(username, email, mobileno, address, pincode, password);
    }

    @DELETE
    @Path("/registration/{email}")
    public void removeRegistration(@PathParam("email") String email) {
        adminBean.removeRegistration(email);
    }

    @GET
    @Path("/registrations")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Registration> getAllRegistration() {
        return adminBean.getAllRegistration();
    }

    @POST
    @Path("/payment/{payment_type}/{status}/{oid}")
    public String addPaymentmaster(@PathParam("payment_type") String payment_type,
                                   @PathParam("status") String status,
                                   @PathParam("oid") int oid) {
        return adminBean.addPaymentmaster(payment_type, status, oid);
    }

    @PUT
    @Path("/payment/{pid}/{payment_type}/{status}/{oid}")
    public String updatePaymentmaster(@PathParam("pid") int pid,
                                      @PathParam("payment_type") String payment_type,
                                      @PathParam("status") String status,
                                      @PathParam("oid") int oid) {
        return adminBean.updatePaymentmaster(pid, payment_type, status, oid);
    }

    @DELETE
    @Path("/payment/{pid}")
    public void removePaymentmaster(@PathParam("pid") int pid) {
        adminBean.removePaymentmaster(pid);
    }

    @GET
    @Path("/payments")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Paymentmaster> getAllPaymentmaster() {
        return adminBean.getAllPaymentmaster();
    }

    @POST
    @Path("/order/{odate}/{email}/{totalamount}/{status}")
    public void addOrdermaster(
                               @PathParam("email") String email,
                               @PathParam("totalamount") int totalamount,
                               @PathParam("status") String status) {
        adminBean.addOrdermaster( email, totalamount, status);
    }

    @PUT
    @Path("/order/{oid}/{email}/{totalamount}/{status}")
    public void updateOrdermaster(@PathParam("oid") int oid,
                                  
                                  @PathParam("email") String email,
                                  @PathParam("totalamount") int totalamount,
                                  @PathParam("status") String status) {
        adminBean.updateOrdermaster(oid, email, totalamount, status);
    }

    @DELETE
    @Path("/order/{oid}")
    public void removeOrdermaster(@PathParam("oid") int oid) {
        adminBean.removeOrdermaster(oid);
    }

    @GET
    @Path("/orders")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Ordermaster> getAllOrdermaster() {
        return adminBean.getAllOrdermaster();
    }

    @POST
    @Path("/orderdetails/{qty}/{rate}/{amount}/{oid}/{pid}")
    public String addOrderdetails(@PathParam("qty") int qty,
                                  @PathParam("rate") int rate,
                                  @PathParam("amount") int amount,
                                  @PathParam("oid") int oid,
                                  @PathParam("pid") int pid) {
        return adminBean.addOrderdetails(qty, rate, amount, oid, pid);
    }

    @DELETE
    @Path("/orderdetails/{odid}")
    public void removeOrderdetails(@PathParam("odid") int odid) {
        adminBean.removeOrderdetails(odid);
    }

    @GET
    @Path("/orderdetails")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Orderdetails> getAllOrderdetails() {
        return adminBean.getAllOrderdetails();
    }
    
    @GET
   @Produces(MediaType.TEXT_HTML)
   @Path("sayHello/{name}")
    public String sayHello(@PathParam("name") String name) {
         return adminBean.sayHello(name);
    }
}
