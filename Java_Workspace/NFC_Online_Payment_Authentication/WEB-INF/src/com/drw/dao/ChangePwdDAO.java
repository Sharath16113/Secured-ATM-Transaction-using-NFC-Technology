package com.drw.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.drw.serviceLocation.serverConnector;

public class ChangePwdDAO
{
	public static int updatepassword(String admin_id,String oldpwd,String newpwd,String confirmpwd)
	{
		int flag=0;
		try
		{
			serverConnector obj=new serverConnector();
			Connection con=obj.serverConnector();
			System.out.println("Connection Established");
			Statement stmt=con.createStatement();
			String sqlquery="update d_admin set admin_password='"+newpwd+"' where admin_id='"+admin_id+"'";
			flag=stmt.executeUpdate(sqlquery);
		}
	catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}
	public static int checkpass(String admin_id,String oldpwd)
	{
		ResultSet rs;
		int flag=0;
		try
		{
			serverConnector obj=new serverConnector();
			Connection con=obj.serverConnector();
			System.out.println("Connection Established");
			Statement stmt=con.createStatement();
			String sqlquery="select admin_password from d_admin where admin_id='"+admin_id+"'";
			rs=stmt.executeQuery(sqlquery);
			if(rs.next())
			{
				String rs1=rs.getString(1);
				if(rs1.equals(oldpwd))
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
