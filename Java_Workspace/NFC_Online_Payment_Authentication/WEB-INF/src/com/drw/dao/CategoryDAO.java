 package com.drw.dao;
import com.drw.serviceLocation.*;
import java.sql.*;
public class CategoryDAO
{
	public static int deletecategory(String cat_code)
	{
		int flag=0;
		try
		{
			serverConnector obj=new serverConnector();
			Connection con=obj.serverConnector();
			System.out.println("Connection Established");
			Statement stmt=con.createStatement();
			String sqlquery="delete from d_cat where cat_code="+cat_code+"";
			flag=stmt.executeUpdate(sqlquery);
		}
				
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}
	public static int updatecategory(int cat_code,String cat_name)
	{
		int flag=0;
		try
		{
			serverConnector obj=new serverConnector();
			Connection con=obj.serverConnector();
			System.out.println("Connection Established");
			Statement stmt=con.createStatement();
			String sqlquery="update d_cat set cat_name='"+cat_name+"' where cat_code="+cat_code+"";
			flag=stmt.executeUpdate(sqlquery);
		}
	catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}
	
	public static int addcategory(String cat_code,String cat_name)
	{
		int flag=0;
		try
		{
			
			serverConnector obj=new serverConnector();
			Connection con=obj.serverConnector();
			System.out.println("Connection Established");
			Statement stmt=con.createStatement();
			String sqlquery="insert into d_cat(cat_code,cat_name)values('"+cat_code+"','"+cat_name+"')";
			flag=stmt.executeUpdate(sqlquery);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}

}

