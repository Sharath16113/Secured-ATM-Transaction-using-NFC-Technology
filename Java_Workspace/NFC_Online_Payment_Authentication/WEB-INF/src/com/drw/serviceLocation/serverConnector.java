package com.drw.serviceLocation;

import java.sql.Connection;
import java.sql.DriverManager;

public class serverConnector {
	public static Connection serverConnector()
	{
		Connection con=null;
	 try
	 {
		 Class.forName("com.mysql.jdbc.Driver");
	  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_nfc_payment","root","admin");
	  
	 }
	 catch(Exception e)
	 {System.out.println(e);
	 
	 }
	 return con;
	}
	

}



