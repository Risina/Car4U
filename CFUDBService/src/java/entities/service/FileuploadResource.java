package entities.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.sun.jersey.multipart.FormDataParam;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.ws.rs.PathParam;
 
@Path("fileupload")
public class FileuploadResource {
 
   @POST
   @Path("{imageName}")
   @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadImageFile(
            @FormDataParam("uploadFile") InputStream fileInputStream,
            @PathParam("imageName") String imageName) {
 
        // local variables
        String fileName = imageName;
        String uploadFilePath = null;
 
        try {
           
            uploadFilePath = writeToFileServer(fileInputStream, fileName);
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        finally{
            // release resources, if any
        }
        return Response.ok("File uploaded successfully at " + uploadFilePath).build();
    }
 
    /**
     * write input stream to file server
     * @param inputStream
     * @param fileName
     * @throws IOException
     */
    private String writeToFileServer(InputStream inputStream, String fileName) throws IOException {
 
        OutputStream outputStream = null;
        String qualifiedUploadFilePath = fileName+".jpg";
 
        try {
            outputStream = new FileOutputStream(new File(qualifiedUploadFilePath));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            outputStream.flush();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally{
            //release resource, if any
            outputStream.close();
        }
        return qualifiedUploadFilePath;
    }
 
}
