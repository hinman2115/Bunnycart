/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package Client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:AdminRest [AdminBean]<br>
 * USAGE:
 * <pre>
 *        RestAdmin client = new RestAdmin();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Varun
 */
public class RestAdmin {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/MobileMart/resources";

    public RestAdmin() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("AdminBean");
    }

    public <T> T getAllPaymentmaster(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("payments");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllOrdermaster(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("orders");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateCategorymaster(String cid, String cname) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("category/{0}/{1}", new Object[]{cid, cname})).request().put(null);
    }

    public void addOrdermaster(String odate, String email, String totalamount, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("order/{0}/{1}/{2}/{3}", new Object[]{odate, email, totalamount, status})).request().post(null);
    }

    public void removeOrderdetails(String odid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("orderdetails/{0}", new Object[]{odid})).request().delete();
    }

    public <T> T getAllProductmaster(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("products");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addProductmaster(String pname, String ram, String processor, String screenSize, String color, String price, String internalstorage, String networktype, String batterycapacity, String description, String quantity, String productimage) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("product/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}", new Object[]{pname, ram, processor, screenSize, color, price, internalstorage, networktype, batterycapacity, description, quantity, productimage})).request().post(null);
    }

    public <T> T getAllBrandmaster(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("brands");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String addOrderdetails(String qty, String rate, String amount, String oid, String pid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("orderdetails/{0}/{1}/{2}/{3}/{4}", new Object[]{qty, rate, amount, oid, pid})).request().post(null, String.class);
    }

    public String addPaymentmaster(String payment_type, String status, String oid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("payment/{0}/{1}/{2}", new Object[]{payment_type, status, oid})).request().post(null, String.class);
    }

    public void addGroupmaster(String gname) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("group/{0}", new Object[]{gname})).request().post(null);
    }

    public void removeBrandmaster(String bid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("brand/{0}", new Object[]{bid})).request().delete();
    }

    public void updateBrandmaster(String bid, String bname) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("brand/{0}/{1}", new Object[]{bid, bname})).request().put(null);
    }

    public <T> T getAllCategorymaster(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("categories");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeCategorymaster(String cid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("category/{0}", new Object[]{cid})).request().delete();
    }

    public void removePaymentmaster(String pid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("payment/{0}", new Object[]{pid})).request().delete();
    }

    public String updatePaymentmaster(String pid, String payment_type, String status, String oid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("payment/{0}/{1}/{2}/{3}", new Object[]{pid, payment_type, status, oid})).request().put(null, String.class);
    }

    public String sayHello(String name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("sayHello/{0}", new Object[]{name}));
        return resource.request(javax.ws.rs.core.MediaType.TEXT_HTML).get(String.class);
    }

    public void updateProductmaster(String pid, String pname, String ram, String processor, String screenSize, String color, String price, String internalstorage, String networktype, String batterycapacity, String description, String quantity, String productimage, String bid, String cid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("product/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}/{14}", new Object[]{pid, pname, ram, processor, screenSize, color, price, internalstorage, networktype, batterycapacity, description, quantity, productimage, bid, cid})).request().put(null);
    }

    public void removeRegistration(String email) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("registration/{0}", new Object[]{email})).request().delete();
    }

    public <T> T getAllRegistration(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("registrations");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllOrderdetails(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("orderdetails");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeProductmaster(String pid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("product/{0}", new Object[]{pid})).request().delete();
    }

    public <T> T getAllGroupmaster(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("groups");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateOrdermaster(String oid, String email, String totalamount, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("order/{0}/{1}/{2}/{3}", new Object[]{oid, email, totalamount, status})).request().put(null);
    }

    public void addCategorymaster(String cname) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("category/{0}", new Object[]{cname})).request().post(null);
    }

    public String addRegistration(String username, String email, String mobileno, String address, String pincode, String password) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("registration/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{username, email, mobileno, address, pincode, password})).request().post(null, String.class);
    }

    public String updateRegistration(String username, String email, String mobileno, String address, String pincode, String password) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("registration/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{username, email, mobileno, address, pincode, password})).request().put(null, String.class);
    }

    public void addBrandmaster(String bname) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("brand/{0}", new Object[]{bname})).request().post(null);
    }

    public void removeGroupmaster(String gid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("group/{0}", new Object[]{gid})).request().delete();
    }

    public void removeOrdermaster(String oid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("order/{0}", new Object[]{oid})).request().delete();
    }

    public void updateGroupmaster(String gid, String gname) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("group/{0}/{1}", new Object[]{gid, gname})).request().put(null);
    }

    public void close() {
        client.close();
    }
    
}
