/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;
 
import com.mysql.jdbc.StringUtils;
import entities.User;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import entities.service.UserFacadeREST;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
 
import sun.misc.BASE64Decoder;

/**
 *
 * @author Risina
 */


 
@Path("auth")
public class Authenticator {
    UserFacadeREST userFacadeREST = new UserFacadeREST();
 @Context
 private HttpServletRequest request;
  
 @GET
 @Path("basic")
 @Produces(MediaType.TEXT_PLAIN)
 public String authenticateHTTPHeader(){
   
  String status;
  try{
   // Get the Authorisation Header from Request
   String header = request.getHeader("authorization");
    
   // Header is in the format "Basic 3nc0dedDat4"
   // We need to extract data before decoding it back to original string
   String data = header.substring(header.indexOf(" ") +1 );
    
   // Decode the data back to original string
   byte[] bytes = new BASE64Decoder().decodeBuffer(data);
   String decoded = new String(bytes);
   
   
   User user = userFacadeREST.findByEmail2(decoded.split(":")[0]);
   
      
   if(user.getPassword().equals(decoded.split(":")[1])) {
       status = user.getId().toString();
   }
   else {
       status = "No/Invalid authentication information provided";
   }
   user = null;

  }catch(Exception e){
   e.printStackTrace();
   status = "No/Invalid authentication information provided";
  }
  
  return status;
 }

    private UserFacadeREST lookupUserFacadeRESTBean() {
        try {
            javax.naming.Context c = new InitialContext();
            return (UserFacadeREST) c.lookup("java:global/CFUDBService/UserFacadeREST!entities.service.UserFacadeREST");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
