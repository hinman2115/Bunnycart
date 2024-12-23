/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package Client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:UserRest [UserRest]<br>
 * USAGE:
 * <pre>
 *        RestUser client = new RestUser();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Varun
 */
public class RestUser {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/MobileMart/resources";

    public RestUser() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("UserRest");
    }

    public <T> T getRegistrationByEmail(Class<T> responseType, String email) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getFindByEmail/{0}", new Object[]{email}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeCart(String email, String productid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deteleProductFromCart/{0}/{1}", new Object[]{email, productid})).request().delete();
    }

    public void removeRegistration(String email) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("registration/{0}", new Object[]{email})).request().delete();
    }

    public <T> T getAllRegistration(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("registrations");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String addRegistration(String username, String email, String mobileno, String address, String pincode, String password) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("registration/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{username, email, mobileno, address, pincode, password})).request().post(null, String.class);
    }

    public String updateRegistration(String username, String email, String mobileno, String address, String pincode, String password) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("registration/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{username, email, mobileno, address, pincode, password})).request().put(null, String.class);
    }

    public String addToCart(String email, String pid, String qty) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("add/{0}/{1}/{2}", new Object[]{email, pid, qty})).request().post(null, String.class);
    }

    public <T> T viewCart(Class<T> responseType, String email) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("viewCart/{0}", new Object[]{email}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllCarts(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("cartss");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getProductDetails(Class<T> responseType, String pid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getProductDetails/{0}", new Object[]{pid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
