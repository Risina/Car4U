/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;

/**
 *
 * @author Risina
 */
@WebServlet("/GetImageServlet")
public class GetImageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fileName = request.getParameter("img");
        String uploadFilePath =  System.getenv("OPENSHIFT_DATA_DIR");
        System.out.println(uploadFilePath);
        
        String name = uploadFilePath+fileName;
        
        java.nio.file.Path p1 = Paths.get(name);
        
        byte[] imageBytes = Files.readAllBytes(p1);
        response.setContentType("image/jpeg");
        response.setContentLength(imageBytes.length);
        response.getOutputStream().write(imageBytes);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public byte[] getImageAsBytes (String ImageName) throws IOException {
         // open image
         File imgPath = new File(ImageName);
         BufferedImage bufferedImage = ImageIO.read(imgPath);

         // get DataBufferBytes from Raster
         WritableRaster raster = bufferedImage .getRaster();
         DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();

         return ( data.getData() );
    }

    private static final long serialVersionUID = 1L;
}
