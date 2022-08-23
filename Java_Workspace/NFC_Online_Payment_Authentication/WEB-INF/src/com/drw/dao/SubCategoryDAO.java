package com.drw.dao;
import com.drw.serviceLocation.*;
import java.sql.*;
public class SubCategoryDAO
{
	public static int deletesubcategory(String sub_cat_code)
	{
		int flag=0;
		try
		{
			serverConnector obj=new serverConnector();
			Connection con=obj.serverConnector();
			System.out.println("Connection Established");
			Statement stmt=con.createStatement();
			String sqlquery="delete from d_sub_cat where sub_cat_code='"+sub_cat_code+"'";
			flag=stmt.executeUpdate(sqlquery);
		}
				
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}
	public static int updatesubcategory(int sub_cat_code,String sub_cat_name,int cat_code)
	{
		int flag=0;
		try
		{
			serverConnector obj=new serverConnector();
			Connection con=obj.serverConnector();
			System.out.println("Connection Established");
			Statement stmt=con.createStatement();
			String sqlquery="update d_sub_cat set sub_cat_name='"+sub_cat_name+"' where sub_cat_code="+sub_cat_code+"";
			flag=stmt.executeUpdate(sqlquery);
		}
	catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}
	
	public static int addsubcategory(int sub_cat_code,int cat_code,String sub_cat_name)
	{
		int flag=0;
		try
		{
			
			serverConnector obj=new serverConnector();
			Connection con=obj.serverConnector();
			System.out.println("Connection Established");
			Statement stmt=con.createStatement();
			String sqlquery="insert into d_sub_cat(sub_cat_code,cat_code,sub_cat_name)values('"+sub_cat_code+"','"+cat_code+"','"+sub_cat_name+"')";
			flag=stmt.executeUpdate(sqlquery);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}

}

