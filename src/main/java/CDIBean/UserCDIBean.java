/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CDIBean;

import Client.RestUser;
import EJB.UserBeanLocal;
import Entity.Addcart;
import Entity.Productmaster;
import Entity.Registration;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Varun
 */
@Named(value = "userCDIBean")
@RequestScoped
public class UserCDIBean {

    @EJB
    private UserBeanLocal userBean;

    
    
     RestUser ra = new RestUser();
    Response rs;
@Inject
private HttpSession session;
    @PersistenceContext(unitName = "mobilemart")
    EntityManager em;

    Collection<Registration> reg;
    GenericType<Collection<Registration>> greg;

    String username;
    String email;
    String mobileno;
    String address;
    String pincode;
    String password;

    Collection<Productmaster> pro;
    GenericType<Collection<Productmaster>> gpro;

    String pname;
    String ram;
    String processor;
    String screenSize;
    String color;
    String productprice;
    String internalstorage;
    String networktype;
    String batterycapacity;
    String description;
    String quantity;
    String productimage;
    String bid;
    String cid;

    Collection<Addcart> ac;
    GenericType<Collection<Addcart>> gac;

    String cartid;
    String qty;
    String price;
    String pid;
    

    Collection<Productmaster> pm;
    GenericType<Collection<Productmaster>> gpm;
    //    int selectedpid;
    
    @EJB UserBeanLocal ubl;

    public UserCDIBean() {

        reg = new ArrayList();
        greg = new GenericType<Collection<Registration>>() {
        };

        ac = new ArrayList();
        gac = new GenericType<Collection<Addcart>>() {
        };

        pm = new ArrayList();
        gpm = new GenericType<Collection<Productmaster>>() {
        };
    }

    public String updateRegistration() {

        userBean.updateRegistration(username, email, 0, address, 0, password);
        return "index.jsf";
    }

  public String addCart() {
        email = (String) session.getAttribute("user"); // Get email from session
        if (email == null || email.isEmpty()) {
            System.out.println("User email is not available in the session.");
            return "errorPage"; // Redirect to an appropriate error page
        }

        System.out.println("Email: " + email); // Debug print
        System.out.println("ProductId: " + pid);
        System.out.println("Quantity: " + qty);

        try {
            userBean.addAddCart(email, pid, Integer.valueOf(qty));

            // Email sending logic
            String mail = "namanramfale2220@gmail.com";  // Sender's email
            String pass = "icxa mdao xsju wzmw";  // Sender's password or App Password
            String host = "smtp.gmail.com";  // SMTP host (Gmail in this case)
            String from = mail;  // Directly use the email
            String password = pass;  // Directly use the password
            String port = "465";

            Properties prop = new Properties();
            prop.put("mail.smtp.user", from);
            prop.put("mail.smtp.host", host);
            prop.put("mail.smtp.port", port);
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.debug", "true");
            prop.put("mail.smtp.socketFactory.port", port);
            prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            prop.put("mail.smtp.socketFactory.fallback", "false");

            Session session1 = Session.getInstance(prop, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, password);
                }
            });

            session1.setDebug(true);
            MimeMessage message = new MimeMessage(session1);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("Item Added to Cart");

            String htmlContent = "<h1>Thank you for adding to your cart!</h1>"
                    + "<p>You have added <b>" + pname + "</b> to your cart.</p>"
                    + "<p>Quantity: " + qty + "</p>"
                    + "<p>Total Price: " + (Integer.valueOf(qty) * Integer.valueOf(productprice)) + "</p>";
            message.setContent(htmlContent, "text/html");

            Transport.send(message);
            System.out.println("Email sent successfully!");

        } catch (MessagingException ex) {
            ex.printStackTrace();
            return "errorPage"; // Redirect to error page on failure
        } catch (Exception ex) {
            ex.printStackTrace();
            return "errorPage";
        }

        return "checkout.jsf";
    }
    
    
//    public void addToCart() {
//        Productmaster p = ra.getProductDetails(Productmaster.class, pid);
//        Registration u = ra.getRegistrationByEmail(Registration.class, email);
//        
//        Addcart newCart = new Addcart();
//        
//        newCart.setPid(p);
//        newCart.setEmail(u);
//        newCart.setQty(Integer.parseInt(qty));
//        
//        
////        ra.addToCart(newCart,Addcart.class,qty);
////     ra.addToCart(newCart, Addcart.class, qty + "");
////        ra.addToCart(Addcart.class, , qty + "");
//
//    ra.addToCart(Response.class, qty);
////        ra.addt
//
//       
//        System.out.println("Email:" + email);
//        System.out.println("ProductId" + pid);
//        System.out.println("Quantity:" + quantity);
//    }

    public String removeAddCart(int p_id) {

        userBean.removeAddCart(email, p_id);
        return "";
    }

    public Collection<Addcart> viewCart() {
            userBean.viewCart(email);
        return ac;
    }

//     public Collection<Productmaster> getProductDetails(int selectedpid) {
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
     
    
    public Registration getUserByEmail() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(false);

        String email = (String) session.getAttribute("user");
        System.out.println(email);

//        if (email != null) {
//            try {
//                Response response = ra.getRegistrationByEmail(Response.class, email);
//                System.err.println(email);
//
//                if (response.getStatus() == 200) { // Assuming 200 indicates successful response
//                    reg = response.readEntity(new GenericType<Collection<Registration>>() {});
//                } else {
//                    // Handle non-successful response status
//                    // Example: Log the error or perform appropriate error handling
//                }
//            } catch (Exception e) {
//                // Handle exceptions during the retrieval or deserialization process
//                e.printStackTrace(); // Print stack trace for debugging (you may handle it differently)
//            }
//        } else {
//            // Handle case when email is null or not found in the session
//            // Example: Redirect to login page or perform appropriate action
//        }
        return ubl.findEmail(email);

//        return reg;
    }
//     public Collection<Products> getAllproducts() {
//        rs = ra.getAllProducts(Response.class);
//        allproducts = rs.readEntity(gallproducts);
//        System.out.println(allproducts);
//        return allproducts;
//    <ui:repeat value="#{adminBean.allproducts}" var="product">
//    }
//     public String getProductDetails(int pid) {
//    try {
//        if (pid > 0) {
//            rs = ra.getProductDetails(Response.class, String.valueOf(pid));
//         //   rs = ra.getProductDetails(Response.class);
//            pm = rs.readEntity(gpm);
//            FacesContext.getCurrentInstance().getExternalContext().redirect("product-details.jsf?productId=" + pid);
//            return "product-details.jsf?productId=" + pid;
//        } else {
//            // Handle case when productId is not valid
//            return null;
//        }
//    } catch (Exception ex) {
//        ex.printStackTrace();
//        return null;
//    }
//}
    public void load() {
        System.err.println(pid);
        rs = ra.getProductDetails(Response.class, pid);
        GenericType<Productmaster> genricEvent = new GenericType<Productmaster>() {
        };

        Productmaster cc = rs.readEntity(genricEvent);

        this.pname = cc.getPname();

    }

    public void loadItemDetails() {
        System.out.println("Productid is : " + pid);
        if (pid != null) {
            try {
                // Assuming you have an Entity named 'Item' with a property 'itemName'
                TypedQuery<Productmaster> query = em.createNamedQuery("Productmaster.findByPid", Productmaster.class);
                query.setParameter("pid", Integer.valueOf(pid));

                Productmaster item = query.getSingleResult();
                if (item != null) {
                    System.out.println("Items : "+item.getPrice());
                    pname = item.getPname();
                    internalstorage = item.getInternalstorage();
                    productprice = item.getPrice().toString();
                    setProductprice(item.getPrice().toString());
                    System.out.println("Items : "+productprice);
                    description = item.getDescription();
                    color = item.getColor();
                    networktype = item.getNetworktype();
                    ram = item.getRam();
                    productimage = item.getProductimage();
                    setEmail((String)session.getAttribute("user"));
                  //      System.out.println(image);
                } else {
                    pname = "Item Not Found";
                }
            } catch (NumberFormatException | javax.persistence.NoResultException e) {
                // Handle exception or set a default value for itemName if parsing or query fails
                pname = "Item Not Found";
            }
        } else {
            System.out.println("Product null");
        }
    }
    
      public Collection<Addcart> getAllAddcarts(){
         
      
         rs = ra.getAllCarts(Response.class);
        ac=rs.readEntity(gac);
        return ac;
       
     }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getProductimage() {
        return productimage;
    }

    public void setProductimage(String productimage) {
        this.productimage = productimage;
    }

    
    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }
    
    

//    public int getSelectedpid() {
//        return selectedpid;
//    }
//
//    public void setSelectedpid(int selectedpid) {
//        this.selectedpid = selectedpid;
//    }
    public Collection<Productmaster> getPm() {
        return pm;
    }

    public void setPm(Collection<Productmaster> pm) {
        this.pm = pm;
    }

    public GenericType<Collection<Productmaster>> getGpm() {
        return gpm;
    }

    public void setGpm(GenericType<Collection<Productmaster>> gpm) {
        this.gpm = gpm;
    }

    public Collection<Addcart> getAc() {
        return ac;
    }

    public void setAc(Collection<Addcart> ac) {
        this.ac = ac;
    }

    public GenericType<Collection<Addcart>> getGac() {
        return gac;
    }

    public void setGac(GenericType<Collection<Addcart>> gac) {
        this.gac = gac;
    }

    public String getCartid() {
        return cartid;
    }

    public void setCartid(String cartid) {
        this.cartid = cartid;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public RestUser getRa() {
        return ra;
    }

    public void setRa(RestUser ra) {
        this.ra = ra;
    }

    public Response getRs() {
        return rs;
    }

    public void setRs(Response rs) {
        this.rs = rs;
    }

    public Collection<Registration> getReg() {
        return reg;
    }

    public void setReg(Collection<Registration> reg) {
        this.reg = reg;
    }

    public GenericType<Collection<Registration>> getGreg() {
        return greg;
    }

    public void setGreg(GenericType<Collection<Registration>> greg) {
        this.greg = greg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Productmaster> getPro() {
        return pro;
    }

    public void setPro(Collection<Productmaster> pro) {
        this.pro = pro;
    }

    public GenericType<Collection<Productmaster>> getGpro() {
        return gpro;
    }

    public void setGpro(GenericType<Collection<Productmaster>> gpro) {
        this.gpro = gpro;
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

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String Productprice) {
        this.productprice = Productprice;
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
    
    

}
