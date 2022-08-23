package com.drw.dao;
import com.drw.serviceLocation.*;
import java.sql.*;
public class ProductDAO
{
	public static int deleteproduct(int pro_code)
	{
		int flag=0;
		try
		{
			serverConnector obj=new serverConnector();
			Connection con=obj.serverConnector();
			System.out.println("Connection Established");
			Statement stmt=con.createStatement();
			String sqlquery="delete from d_product where pro_code="+pro_code+"";
			flag=stmt.executeUpdate(sqlquery);
		}
				
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}
	public static int updateproduct(String pro_code,String pro_name,String pro_description)
	{
		int flag=0;
		try
		{
			serverConnector obj=new serverConnector();
			Connection con=obj.serverConnector();
			System.out.println("Connection Established");
			Statement stmt=con.createStatement();
			String sqlquery="update d_product set pro_name='"+pro_name+"',pro_description='"+pro_description+"' where pro_code='"+pro_code+"'";
			flag=stmt.executeUpdate(sqlquery);
		}
	catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}
	
	public static int addproduct(String pro_code,String pro_name,String pro_desc,String cat_code,String sub_cat_code,String pro_photo,String pro_pur_price,String pro_mrp,String pro_price,String pro_tax)
	{
		int flag=0;
		try
		{
			
			serverConnector obj=new serverConnector();
			Connection con=obj.serverConnector();
			System.out.println("Connection Established");
			Statement stmt=con.createStatement();
			System.out.println("dao photo path insert........."+pro_photo);
			String sqlquery="insert into d_product(pro_code,pro_name,pro_description,cat_code,sub_cat_code,pro_photo_path,pro_pur_price,pro_mrp,pro_price,pro_tax)values('"+pro_code+"','"+pro_name+"','"+pro_desc+"','"+cat_code+"','"+sub_cat_code+"','"+pro_photo+"','"+pro_pur_price+"','"+pro_mrp+"','"+pro_price+"','"+pro_tax+"')";
			flag=stmt.executeUpdate(sqlquery);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}

}

