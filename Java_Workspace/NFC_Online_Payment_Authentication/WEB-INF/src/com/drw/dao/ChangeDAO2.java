package com.drw.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.drw.serviceLocation.serverConnector;
public class ChangeDAO2 
{
public static int cpassword(String sp_id, String newpassword) 
	{
			int flag=0;
			try
			{
				
				serverConnector obj=new serverConnector();
				Connection con=obj.serverConnector();
				System.out.println("Connection Established");
				Statement stmt=con.createStatement();
				String sqlQuery="update d_salesperson set sp_password='"+newpassword+"' where sp_id='"+sp_id+"'";
				flag=stmt.executeUpdate(sqlQuery);
			}
			catch(Exception e) 
			{
				System.out.println(e);
			}
			return flag;
		}

	public static int checkpass(String sp_id, String oldpassword) 
	{
		ResultSet rs;
		int flag=0;
		try
		{
			
			serverConnector obj=new serverConnector();
			Connection con=obj.serverConnector();
			System.out.println("Connection Established");
			Statement stmt=con.createStatement();
			String sqlQuery="select * from d_salesperson where sp_id='"+sp_id+"'";
			rs=stmt.executeQuery(sqlQuery);
			if(rs.next())
			{
				String rs1=rs.getString(1);
				if(rs1.equals(oldpassword))
				{
					flag=1;
				}
			}
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}
}

