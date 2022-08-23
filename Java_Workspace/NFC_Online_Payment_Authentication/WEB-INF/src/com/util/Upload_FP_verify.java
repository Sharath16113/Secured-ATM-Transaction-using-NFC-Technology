package com.util;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import com.drw.action.Fingerprint;
import com.drw.dao.UserDAO;
import com.symmetric_AES.AESCrypt;
import com.util.FingerPrint.direction;


public class Upload_FP_verify extends HttpServlet
{

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
			{

		FileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload =new ServletFileUpload(fileItemFactory);
		List fileItems = null;
		
		String empId,pin="";
		String name;
		String gender;
		String dob;
		String designation;
		String depertment;
		String emailId;
		String phone;
		
		String featureToEncrypt="";
		String encrypted = "";
		String fingerprintValue = "";
		
		try {
			fileItems = servletFileUpload.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileItem file7 = (FileItem) fileItems.get(0);
		FileItem file8 = (FileItem) fileItems.get(1);
		
	//	FileItem file9 = (FileItem) fileItems.get(8);//finger image
		
		
		
		
		pin = file7.getString().trim();
		System.out.println(">>>>>>>>>>>>>emailId>>>>>>>> " + pin);
		
		
		
		String imagename=file8.getName(); //Image Name
		System.out.println(">>>>>>>>>>>>>imagename>>>>>>>> " + imagename);
		
		String image=file8.getString(); // Image
		//System.out.println(">>>>>>>>>>>>>image>>>>>>>> " + image);
		
		String fingerprintfilename = request.getRealPath("") + "/uploadfingerprint/"+imagename;
		
		OutputStream outputStream = new FileOutputStream(fingerprintfilename);
		InputStream inputStream = file8.getInputStream();

			int readBytes = 0;
			byte[] buffer = new byte[10000];
			while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1)
			{
				outputStream.write(buffer, 0, readBytes);
			}
			outputStream.close();
			inputStream.close();
			
			
			//==================== Extract the Features of the Finger Print=================
			
			try {
			
				  FingerPrint fingerprint1 = new FingerPrint(fingerprintfilename); 
					System.out.println("its cazme inside feature extraction>>>>>>>>>>>>>>>>>"+fingerprint1);
					
			            BufferedImage buffer11;
			            
			            // Print original image           
			            buffer11 = fingerprint1.getOriginalImage();
			           
			            // Print binary result           
			            fingerprint1.binarizeMean();
			            buffer11 = fingerprint1.toBufferedImage();
			            
			            // Print binary local result           
			            fingerprint1.binarizeLocalMean();
			            buffer11 = fingerprint1.toBufferedImage();
			            
			            // Remove noise
			            fingerprint1.removeNoise();
			            fingerprint1.removeNoise();
			            fingerprint1.removeNoise();
			            buffer11 = fingerprint1.toBufferedImage();
			            
			            // Skeletonization            
			            fingerprint1.skeletonize();
			           
			            // Direction
			            direction [][] dirMatrix = fingerprint1.getDirections();
			            buffer11 = fingerprint1.directionToBufferedImage(dirMatrix);
			            
			            // Core           
			            buffer11 = fingerprint1.directionToBufferedImage(dirMatrix);
			            Point core = fingerprint1.getCore(dirMatrix);
			            System.out.println("  Core.........."+core);
			           
			            int coreRadius = buffer11.getWidth() / 3;       
			            System.out.println(" Core Radius........"+coreRadius);
			           
			            // Minutiaes           
			            buffer11 = fingerprint1.directionToBufferedImage(dirMatrix);            
			            ArrayList<Point> intersections = fingerprint1.getMinutiaeIntersections(core, coreRadius);
			            ArrayList<Point> endPoints = fingerprint1.getMinutiaeEndpoints(core, coreRadius);
			            System.out.println(" MinutiaeIntersections......."+intersections);
			            System.out.println(" MinutiaeEndpoints............"+endPoints); 
			            
					 int count_intersection=intersections.size();
			         int count_endpoints=endPoints.size();
			         
			         featureToEncrypt=count_intersection+"~"+count_endpoints;
			         System.out.println("priya finger print featureToEncrypt>>>>>>>>>>>>>>>>>"+featureToEncrypt);
			      
			
	        	AESCrypt  encrypter = new AESCrypt();
	         	encrypted = encrypter.encrypt(featureToEncrypt);
			} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			}
			
			//====================END Extract the Features of the Finger Print==ends===============
			
	      
	         int flag = UserDAO.checkFingerPrint1(pin, featureToEncrypt);
	         if(flag!=0)
					{
						System.out.println("its is coming inside the result is ");
						/*UserDAO.getnetvalue(pin);
						UserDAO.updatetotal(tot);*/
						RequestDispatcher rd=null;
						rd=request.getRequestDispatcher("/JSP/salesperson/cardpay1.jsp");
						try {
							rd.forward(request,response);
						} catch (ServletException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
					}
				}
	         
				
	         
	         
	  } //Ending DoPost Method



