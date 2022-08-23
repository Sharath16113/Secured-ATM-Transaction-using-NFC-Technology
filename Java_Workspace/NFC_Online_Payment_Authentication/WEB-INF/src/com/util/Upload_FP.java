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


public class Upload_FP extends HttpServlet
{

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
			{

		FileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload =new ServletFileUpload(fileItemFactory);
		List fileItems = null;
		
		String empId;
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
		FileItem file1 = (FileItem) fileItems.get(0);
		FileItem file2 = (FileItem) fileItems.get(1);
		FileItem file3 = (FileItem) fileItems.get(2);
		FileItem file4 = (FileItem) fileItems.get(3);
		FileItem file5 = (FileItem) fileItems.get(4);
		FileItem file6 = (FileItem) fileItems.get(5);
		FileItem file7 = (FileItem) fileItems.get(6);
		//FileItem file8 = (FileItem) fileItems.get(7);
	//	FileItem file9 = (FileItem) fileItems.get(8);//finger image
		
		
		empId = file1.getString().trim();
		System.out.println(">>>>>>>>>>>>>empId>>>>>>>> " + empId);
		
		name = file2.getString().trim();
		System.out.println(">>>>>>>>>>>>>name>>>>>>>> " + name);
		
		gender = file3.getString().trim();
		System.out.println(">>>>>>>>>>>>>gender>>>>>>>> " + gender);
		
		dob = file4.getString().trim();
		System.out.println(">>>>>>>>>>>>>dob>>>>>>>> " + dob);
		
		designation = file5.getString().trim();
		System.out.println(">>>>>>>>>>>>>designation>>>>>>>> " + designation);
		
		depertment = file6.getString().trim();
		System.out.println(">>>>>>>>>>>>>depertment>>>>>>>> " + depertment);
		
		emailId = file7.getString().trim();
		System.out.println(">>>>>>>>>>>>>emailId>>>>>>>> " + emailId);
		
		
	 
			
			//==================== Extract the Features of the Finger Print=================
		 
			
			//====================END Extract the Features of the Finger Print==ends===============
			
	      
	         int flag = UserDAO.adduser(empId, name, gender, dob, designation, depertment, emailId);
	         if(flag!=0)
					{
						System.out.println("its is coming inside the result is ");
						
						RequestDispatcher rd=null;
						rd=request.getRequestDispatcher("/JSP/salesperson/User.jsp");
						try {
							rd.forward(request,response);
						} catch (ServletException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
					}
				}
	         
				
	         
	         
	  } //Ending DoPost Method



