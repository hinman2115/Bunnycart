/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CDIBean;

import Client.RestAdmin;
import EJB.AdminBeanLocal;
import Entity.Brandmaster;
import Entity.Categorymaster;
import Entity.Orderdetails;
import Entity.Ordermaster;
import Entity.Paymentmaster;
import Entity.Productmaster;
import Entity.Registration;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.Part;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Request;
import org.glassfish.soteria.identitystores.hash.PasswordHashCompare;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author Varun
 */
@Named(value = "adminCDIBean")
@RequestScoped
public class AdminCDIBean {

    @EJB
    private AdminBeanLocal adminBean;
    
    private Part file1;
    
    

    Pbkdf2PasswordHashImpl pb;
    PasswordHashCompare phc;
    
    RestAdmin ra=new RestAdmin();
    Response rs;
    
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
       String price;
       String internalstorage;
       String networktype;
       String batterycapacity;
       String description; 
       String quantity;
       String productimage;
       String bid;
       String cid;
       
       
       Collection<Categorymaster> cat;
       GenericType<Collection<Categorymaster>> gcat;
       

       String cname;
       
    Collection<Brandmaster> br;
    GenericType<Collection<Brandmaster>> gbr;

    String bname;

    
    Collection<Paymentmaster> pay;
    GenericType<Collection<Paymentmaster>> gpay;
     
     String pid;
     String payment_type;
     String status;
     String oid;
    
    Collection<Ordermaster> or;
    Collection<Orderdetails> ord;
    GenericType<Collection<Ordermaster>> gor;
    GenericType<Collection<Orderdetails>> gord; 
    
    
    //order master tabel
    

    Date odate;
    String totalamount;

     //order details tabel
    
    String qty;
    String rate;
    String amount;
    String odid;
    
    
    public AdminCDIBean() {
        
        pb = new Pbkdf2PasswordHashImpl();
        phc= new PasswordHashCompare();
       
        reg = new ArrayList();
        greg = new GenericType<Collection<Registration>>() 
        
        {
            
        };
        
        pro=new ArrayList();
        gpro=new GenericType<Collection<Productmaster>>(){};
        
        cat=new ArrayList();
        gcat=new GenericType<Collection<Categorymaster>>(){};
        
        br=new ArrayList();
        gbr=new GenericType<Collection<Brandmaster>>(){};
            
        pay=new ArrayList();
        gpay=new GenericType<Collection<Paymentmaster>>(){} ;
        
        or=new ArrayList();
        gor=new GenericType<Collection<Ordermaster>>(){};
        
        ord=new ArrayList();
        gord=new  GenericType<Collection<Orderdetails>>(){};
        getAllProductmaster();
    }
    
    private static boolean isValidEmail (String email){
        
       String emailRegex = "^[a-zA-Z0-9_+&-]+(?:\\.[a-zA-Z0-9_+&-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }
    
    public String insertRegiStration()
            
   {   

//        FacesContext context = FacesContext.getCurrentInstance();
//         if(!isValidEmail(email)){
//            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Invalid Email Format", "Invalid Email Format"));
//            return null;
//         }
//         String encpassword = pb.generate(password.toCharArray());
//            System.out.println("username");
//            System.out.println("email");
//            System.out.println("mobileno");
//            System.out.println("address");
//            System.out.println("pincode");
//            System.out.println("pa");
       
            adminBean.addRegistration(username, email, 0, address, 0, password);
         return "login.jsf";
   }
    
    public String updateRegistration(){
        
        ra.updateRegistration(username, email, mobileno, address, pincode, password);
        return "index.jsf";
    }

    public String removeRegistration(){
        
        ra.removeRegistration(email);
            return "index.jsf";
    }
    
     public Collection<Registration> getAllRegistration(){
         
      
         rs = ra.getAllRegistration(Response.class);
        reg=rs.readEntity(greg);
        return reg;
       
     }
    
      public Registration findEmail(String email) {
    try {
        // Assuming 'em' is your entity manager
        TypedQuery<Registration> query = em.createQuery(
            "SELECT r FROM Registration r WHERE r.email = :email", Registration.class);
        query.setParameter("email", email);

        // Retrieve the Registration entity based on the email
        Registration registration = query.getSingleResult();

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
    public String addProductmaster() {
        try {
          //   String pimage=uploadFile(file1);
             String pimage = uploadFile(file1);
             System.out.println(pimage);
            adminBean.addProductmaster(pname, ram, processor, screenSize, color, Integer.SIZE, internalstorage, networktype, batterycapacity, description, Integer.SIZE, pimage);
            System.out.println("Product Added Successfully!");
            return "a-product.jsf?faces-redirect=true";
        } catch (ClientErrorException ex) {
            return "Error Occured";
        }
    }
    
 public String uploadFile(Part file) {
         String filename=null;
       if (file != null) {
            try {
                  filename = file.getSubmittedFileName();

                // Specify the directory where you want to store the files
               String uploadDirectory = "C:\\JavaProject\\MobileMart\\src\\main\\webapp\\resources\\images";
              
                File uploadDir = new File(uploadDirectory);

                // Create the directory if it doesn't exist
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                // Create a File object representing the uploaded file
                File uploadedFile = new File(uploadDirectory, filename);

                // Copy the content of the InputStream to the FileOutputStream
                try (InputStream in = file.getInputStream();
                     FileOutputStream out = new FileOutputStream(uploadedFile)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                }

                // You can use standard Java I/O operations to handle the file.
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File is null");
        }

        return filename; // Navigate to a success page
    }
     
    public String updateProductmaster(){
        
        ra.updateProductmaster(pid, pname, ram, processor, screenSize, color, price, internalstorage, networktype, batterycapacity, description, quantity, productimage, bid, cid);
        return "a-product.jsf?faces-redirect=true";
    }
    
    public void removeProductmaster(String pid){       
         try {
          //   String pimage=uploadFile(file1);
          System.out.println("PId" + pid);
            ra.removeProductmaster(pid);
            System.out.println("Product Deleted Successfully!");
            getAllProductmaster();
           // return "addProductmaster.jsf?faces-redirect=true";
        } catch (ClientErrorException ex) {
          //  return "Error Occured";
          System.out.println("Error in remove : "+ ex.getMessage());
        }
    } 
    
     public void getAllProductmaster(){
         rs = ra.getAllProductmaster(Response.class);
         setPro(rs.readEntity(gpro));
     }
     
     
     public Collection<Productmaster> getAllproducts() {
        rs = ra.getAllProductmaster(Response.class);
        pro = rs.readEntity(gpro);
        System.out.println(pro);
        return pro;
    }
     
     
     public String addCategorymaster(){
         
         adminBean.addCategorymaster(cname);
         return "index.jsf";
     }

     public String updateCategorymaster(){
         
         adminBean.updateCategorymaster(0, cname);
          return "index.jsf";
     }
     
     public String removeCategorymaster(){
         
         adminBean.removeCategorymaster(0);
         return "index.jsf";
     }
     
      public Collection<Categorymaster> getAllCategorymaster() {
         
      
        adminBean.getAllCategorymaster();
        return getAllCategorymaster();
       
     }

      public String addBrandmaster(){
          
          adminBean.addBrandmaster(bname);
          return "index.jsf";
      }
       
      public String updateBrandmaster(){
          
          adminBean.updateBrandmaster(0, bname);
           return "index.jsf";
      }
      
      public String removeBrandmaster(){
          
          adminBean.removeBrandmaster(0);
           return "index.jsf";
      }
      
      public Collection<Brandmaster> getAllBrandmaster(){
          
          rs = ra.getAllBrandmaster(Response.class);
        br=rs.readEntity(gbr);
        return br;
      }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
      
      
       public String addPaymentmaster(){
           
           adminBean.addPaymentmaster(payment_type, status, 0);
           return "index.jsf";
       }

       
       public String updatePaymentmaster(){
           
           adminBean.updatePaymentmaster(0, payment_type, status, 0);
            return "index.jsf";
       }
       
        public String removePaymentmaster(){
        
            adminBean.removePaymentmaster(0);
             return "index.jsf";
        }
       
        public Collection<Paymentmaster> getAllPaymentmaster(){
           
            rs = ra.getAllPaymentmaster(Response.class);
            pay = rs.readEntity(gpay);
            return pay;
        }

//         public String addOrdermaster(){
//             
//             ra.addOrdermaster( email, totalamount, status);
//             return "index.jsf";
//         }
        
        public String updateOrdermaster(){
            
            ra.updateOrdermaster(oid, email, totalamount, status);
            return "index.jsf";
        }
        
         public String removeOrdermaster(){
             
             ra.removeOrdermaster(oid);
             return "index.jsf";
             
         }
         
         public Collection<Ordermaster> getAllOrdermaster(){
             
              rs = ra.getAllOrdermaster(Response.class);
            or = rs.readEntity(gor);
            return or;
         }
         
         public String addOrderdetails(){
             
             ra.addOrderdetails(qty, rate, amount, oid, pid);
             return "index.jsf";
         }
        
       
         public String removeOrderdetails(){
             
             ra.removeOrderdetails(odid);
             return "index.jsf";
             
         }
         
         public Collection<Orderdetails> getAllOrderdetails(){
             
              rs = ra.getAllOrderdetails(Response.class);
            ord = rs.readEntity(gord);
            return ord;
         }

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }

    
         
         
    public Collection<Ordermaster> getOr() {
        return or;
    }

    public void setOr(Collection<Ordermaster> or) {
        this.or = or;
    }

    public Collection<Orderdetails> getOrd() {
        return ord;
    }

    public void setOrd(Collection<Orderdetails> ord) {
        this.ord = ord;
    }

    public GenericType<Collection<Ordermaster>> getGor() {
        return gor;
    }

    public void setGor(GenericType<Collection<Ordermaster>> gor) {
        this.gor = gor;
    }

    public GenericType<Collection<Orderdetails>> getGord() {
        return gord;
    }

    public void setGord(GenericType<Collection<Orderdetails>> gord) {
        this.gord = gord;
    }

    public Date getOdate() {
        return odate;
    }

    public void setOdate(Date odate) {
        this.odate = odate;
    }

    public String getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOdid() {
        return odid;
    }

    public void setOdid(String odid) {
        this.odid = odid;
    }
       
    public Collection<Paymentmaster> getPay() {
        return pay;
    }

    public void setPay(Collection<Paymentmaster> pay) {
        this.pay = pay;
    }

    public GenericType<Collection<Paymentmaster>> getGpay() {
        return gpay;
    }

    public void setGpay(GenericType<Collection<Paymentmaster>> gpay) {
        this.gpay = gpay;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }
      
      
      
    public Collection<Brandmaster> getBr() {
        return br;
    }

    public void setBr(Collection<Brandmaster> br) {
        this.br = br;
    }

    public GenericType<Collection<Brandmaster>> getGbr() {
        return gbr;
    }

    public void setGbr(GenericType<Collection<Brandmaster>> gbr) {
        this.gbr = gbr;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }
      
      
     
    public Collection<Categorymaster> getCat() {
        return cat;
    }

    public void setCat(Collection<Categorymaster> cat) {
        this.cat = cat;
    }

    public GenericType<Collection<Categorymaster>> getGcat() {
        return gcat;
    }

    public void setGcat(GenericType<Collection<Categorymaster>> gcat) {
        this.gcat = gcat;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

  

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

   

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Pbkdf2PasswordHashImpl getPb() {
        return pb;
    }

    public void setPb(Pbkdf2PasswordHashImpl pb) {
        this.pb = pb;
    }

    public PasswordHashCompare getPhc() {
        return phc;
    }

    public void setPhc(PasswordHashCompare phc) {
        this.phc = phc;
    }

    public RestAdmin getRa() {
        return ra;
    }

    public void setRa(RestAdmin ra) {
        this.ra = ra;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getProductimage() {
        return productimage;
    }

    public void setProductimage(String productimage) {
        this.productimage = productimage;
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
