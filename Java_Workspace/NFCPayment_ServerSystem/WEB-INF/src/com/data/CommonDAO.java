package com.data;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class CommonDAO {
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	 static int upload_flag;

	public static ResultSet getFiles(int id, String type) {
		try {
			//String status="yes";
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select * from m_file_one where user_id='" +id+ "'");
			System.out.println("=====================");
			} 
		catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getUsers()....."
					+ e);
		}
		return resultSet;
	}

	public static int getUserID(String userid) {
		int id = 0;
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();

			String sql = "select id from userlogin where userid='" + userid
					+ "'";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			System.out.println("User ID to return : " + id);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getUserID()....."
					+ e);
		}
		return id;
	}
	
	
	//
	//
	///
	//
	//
	
	public static int m_file(String fname, int blocks) 
	{
		boolean flag=false;
		int fno=0;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql="insert into m_file (file_name,Blocks) values('"+fname+"','"+blocks+"')";
			String sql2="select * from m_file";
			System.out.println(sql);
			System.out.println(sql2);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Insert to database  Status : "+flag);
			resultSet=statement.executeQuery(sql2);
			while(resultSet.next())
			{
				fno=resultSet.getInt(1);
			}
		}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in AdminDAO-register()....."+e);
			}
			return fno;
	}
	
	public static boolean inserttolltransactions(String tname,String dte,String tim,String vehinum,String vtype,String fare) 
	{
		boolean flag=false;
		int fno=0;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql="insert into m_androidtransaction (toll_id,toll_pdte,toll_tim,toll_vehiclenum,toll_vtype,toll_fare) values('"+tname+"','"+dte+"','"+tim+"','"+vehinum+"','"+vtype+"','"+fare+"')";
			
			System.out.println(sql);
			
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			
		}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in AdminDAO-register()....."+e);
			}
			return flag;
	}
	
	public static String gethashblocknos(String fname) 
	{
		//boolean flag=false;
		String hashblknos=null;;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
		
			String sql2="select * from m_file_one where file_name='"+fname+"'";
		
			resultSet=statement.executeQuery(sql2);
			while(resultSet.next())
			{
				hashblknos=resultSet.getString(7);
			}
		}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in AdminDAO-register()....."+e);
			}
			return hashblknos;
	}
	
	public static String gethashblockname(int hash_id) 
	{
		//boolean flag=false;
		String blkname=null;;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
		    String status="no";
			String sql2="select * from m_hash_code where hash_unique_code='"+hash_id+"' and uploaded_status='"+status+"'";
		
			resultSet=statement.executeQuery(sql2);
			while(resultSet.next())
			{
				blkname=resultSet.getString(3);
			}
		}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in AdminDAO-register()....."+e);
			}
			return blkname;
	}
	
	
	
	
	
	
	
	public static int m_hash_code_insert_getid(String hash,String blockname) 
	{
		
		boolean flag=false;
		boolean flag2=false;
		int id=0;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			
			String sql="insert into m_hash_code (hash_code,no_instnce) values('"+hash+"','"+1+"')";
			String sql3="select * from m_hash_code where hash_code='"+hash+"'";
			String sql2="select * from m_hash_code  where hash_code='"+hash+"'";
			String status2="no";
			String sql4="select hash_unique_code from m_hash_code where hash_code='"+hash+"' and uploaded_status='"+status2+"'";
			int unique_id=0;
			System.out.println(sql);
			System.out.println(sql3);
			System.out.println(sql2);
			resultSet=statement.executeQuery(sql3);
			while(resultSet.next())
			{
				flag2=true;
			}
			if(flag2==false)
			{
				int i=statement.executeUpdate(sql);
				if(i!=0)
				{
					flag=true;
				}
				System.out.println("Insert hash and instance to database  Status : "+flag); 
				
				
			resultSet=statement.executeQuery(sql4);
			while(resultSet.next())
			{
				unique_id=resultSet.getInt(1);
			}
			String blk_name1=unique_id+blockname;
			int k=statement.executeUpdate("update m_hash_code set blk_name='"+blk_name1+"' where hash_code='"+hash+"' and hash_unique_code='"+unique_id+"'");
			
		if(k!=0)
		{
			flag=true;
		}
		System.out.println("Insert to database  Status : "+flag);
		
	}
			
			if(flag2==true)
			{
				int instance=0;
				resultSet=statement.executeQuery("select * from m_hash_code where hash_code='"+hash+"'");
				while(resultSet.next())
				{
					instance=resultSet.getInt(4);
				}
				instance=instance+1;
			    System.out.println("--------INSTANCE-----"+instance);
				int i=statement.executeUpdate("update m_hash_code set no_instnce='"+instance+"' where hash_code='"+hash+"'");
				System.out.println("-----UPDATE INSTANCE-----"+instance);
				upload_flag=2;
				if(i!=0)
				{
					flag=true;
				}
				System.out.println("update no_instance in database  Status : "+flag);
			}
			resultSet=statement.executeQuery(sql2);
			while(resultSet.next())
			{
				id=resultSet.getInt(1);
			}
		}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in m_hash_code_insert....."+e);
			}
			return id;
	}
	
	
	
	
	
	/*public static boolean m_getblocks(File file2,String dir) 
	{
		
		boolean flag=false;
		boolean flag2=false;
		String hash_blk_name=null;
		boolean	flag_new=false;
		String status1="yes";
		String status2="no";
		int i=0;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String status="no";
			String sql2="select uploaded_status from m_hash_code where  uploaded_status='"+status+"'";
			System.out.println(sql2);
			String sql3="select * from m_hash_code where hash_code='"+hash+"'";
			resultSet=statement.executeQuery(sql3);
			while(resultSet.next())
			{
				flag2=true;
			}
			if(flag2==true)
			{
				int instance=0;
				resultSet=statement.executeQuery("select * from m_hash_code where hash_code='"+hash+"'");
				while(resultSet.next())
				{
					instance=resultSet.getInt(4);
				}
				instance=instance+1;
			    System.out.println("--------INSTANCE-----"+instance);
				int i=statement.executeUpdate("update m_hash_code set no_instnce='"+instance+"' where hash_code='"+hash+"'");
				System.out.println("-----UPDATE INSTANCE-----"+instance);
				//upload_flag=2;
				if(i!=0)
				{
					flag=true;
				}
				System.out.println("update no_instance in database  Status : "+flag);
			}
			resultSet=statement.executeQuery(sql2);
			while(resultSet.next())
			{
				
				hash_blk_name=resultSet.getString(1);
				//flag_new=Utility.uploadFile(Utility.getPro("server"), Utility.getPro("user"), Utility.getPro("pass"),hash_blk_name,file2,dir);  
				if(flag_new) 
				{
				i=statement.executeUpdate("update m_hash_code set uploaded_status='"+status1+"'where blk_name='"+hash_blk_name+"'");
				}
			}
		
		}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in m_hash_code_insert....."+e);
			}
			return flag_new;
	}*/
	
	
	
	
	
	
	
	
	public static int m_upload_status(String blk_name) 
	{
		
		boolean flag=false;
		int i=0;
		//String status=null;
		//String status="yes";
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			
			
				String status1="yes";
				
				 i=statement.executeUpdate("update m_hash_code set uploaded_status='"+status1+"'where blk_name='"+blk_name+"'");
				
				if(i!=0)
				{
					flag=true;
				}
				System.out.println("update uploaded status in database  Status : "+flag);
			
		}
		    catch(Exception e)
			{
				System.out.println("Opp's Error is in m_hash_code_insert....."+e);
			}
			return i;
	}
	
	
	
	public static boolean m_file_hash(int F_no,int block_no, String HashCode) 
	{
		boolean flag=false;
		try
		{
			
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql="insert into m_file_hash (file_no,block_no,hash_code) values('"+F_no+"','"+block_no+"','"+HashCode+"')";
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Insert to database  Status : "+flag);
		}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in AdminDAO-register()....."+e);
			}
			return flag;
	}
	
	
	
	
	
	public static boolean updateotp(String sid,String spass,String otp) 
	{
		boolean flag=false;
		try
		{
			
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql="update d_salesperson set sp_otp='"+otp+"' where sp_id='"+sid+"' and sp_password='"+spass+"'";
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Insert to database  Status : "+flag);
		}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in AdminDAO-register()....."+e);
			}
			return flag;
	}
	
	public static int m_file_byteone(String substr) 
	{
		int id=0;
		try
		{
			 
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql2="select * from m_level1 where m_l1_byte='"+substr+"' ";
			System.out.println(sql2);
			resultSet=statement.executeQuery(sql2);
			while(resultSet.next())
			{
				id=resultSet.getInt(1);
			}
		}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in AdminDAO-register()....."+e);
			}
			return id;
	}
	public static String getphonenum(String sid) 
	{
		String phone="";
		try
		{
			 
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql2="select sp_email from d_salesperson where sp_id='"+sid+"' ";
			System.out.println(sql2);
			resultSet=statement.executeQuery(sql2);
			while(resultSet.next())
			{
				phone=resultSet.getString(1);
			}
		}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in AdminDAO-register()....."+e);
			}
			return phone;
	}
	
	public static boolean m_file_one(String file_name,int file_size1,int file_size2,int no_padding,int no_blocks, String hash_blk_no,int userid,String date,String time,String day) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql="insert into m_file_one (file_name,file_size1,file_size2,padding,no_blocks,hash_blk_nos,user_id,date,time,day) values('"+file_name+"','"+file_size1+"','"+file_size2+"','"+no_padding+"','"+no_blocks+"','"+hash_blk_no+"','"+userid+"','"+date+"','"+time+"','"+day+"')";
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Insert to database  Status : "+flag);
		}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in AdminDAO-register()....."+e);
			}
			return flag;
	}
	
	
	public static int m_file_level2_insert_getid(int id , String ss1) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			
			String sql="insert into m_level2 (m_l1_code,m_l2_byte) values('"+id+"','"+ss1+"')";
			String sql2="select * from m_level2 where m_l1_code='"+id+"' and  m_l2_byte='"+ss1+"' group by m_l1_code,m_l2_byte";
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Insert to database  Status : "+flag);
			resultSet=statement.executeQuery(sql2);
			while(resultSet.next())
			{
				id=resultSet.getInt(1);
			}
		}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in AdminDAO-register()....."+e);
			}
			return id;
	}
	
	
	
	
	/*public static int m_hash_code_insert_getid(String hash, String blk_name,File file1,String dir) 
	{
		
		boolean flag=false;
		boolean flag2=false;
		int id=0;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			
			String sql="insert into m_hash_code (hash_code,blk_name,no_instnce) values('"+hash+"','"+blk_name+"','"+1+"')";
			String sql3="select * from m_hash_code where hash_code='"+hash+"'";
			String sql2="select * from m_hash_code  where hash_code='"+hash+"' and  blk_name='"+blk_name+"'";
			System.out.println(sql);
			System.out.println(sql3);
			System.out.println(sql2);
			resultSet=statement.executeQuery(sql3);
			while(resultSet.next())
			{
				flag2=true;
			}
			if(flag2==false)
			{
				 
				
				boolean flag_new=false;
				flag_new=Utility.uploadFile(Utility.getPro("server"), Utility.getPro("user"), Utility.getPro("pass"),blk_name,file1,dir);
				if(flag_new==true)
				{
				upload_flag=1;
				}
				int i=statement.executeUpdate(sql);
				if (flag_new)
			    {
			    	String status="yes";
			    	int i2=statement.executeUpdate("update m_hash_code set uploaded_status='"+status+"' where hash_code='"+hash+"'");
					System.out.println("-----UPDATE upload status-----"+status);
					if(i2!=0)
					{
						flag=true;
					}
					System.out.println("Insert the uploaded status to database : "+flag);	
			    }
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Insert to database  Status : "+flag);
			}
			
			if(flag2==true)
			{
				int instance=0;
				resultSet=statement.executeQuery("select * from m_hash_code where hash_code='"+hash+"'");
				while(resultSet.next())
				{
					instance=resultSet.getInt(5);
				}
				instance=instance+1;
			    System.out.println("--------INSTANCE-----"+instance);
				int i=statement.executeUpdate("update m_hash_code set no_instnce='"+instance+"' where hash_code='"+hash+"'");
				System.out.println("-----UPDATE INSTANCE-----"+instance);
				if(i!=0)
				{
					flag=true;
				}
				System.out.println("Insert to database  Status : "+flag);
			}
			resultSet=statement.executeQuery(sql2);
			while(resultSet.next())
			{
				id=resultSet.getInt(1);
			}
		}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in AdminDAO-register()....."+e);
			}
			return id;
	}
	
	*/
	
	
	
	
	
	
	
	public static int m_block_name_insert(String hash, int id2,String blk_name) 
	{
		
		//boolean flag=false;
		int i=0;
		String blk_name1=id2+"_"+blk_name;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql="update m_hash_code set blk_name='"+blk_name1+"' where hash_code='"+hash+"' and hash_unique_code='"+id2+"'";
			System.out.println("===============Block insertion======="+sql);
		    i =statement.executeUpdate(sql);
					
		}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("======Error in block_name insertion======="+e);
			}
			return i;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static boolean m_file_level3_insert(int m_l2_code,String m_l3_bytes,int hash_uniq_code) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql="insert into m_level3(m_l2_code,m_l3_bytes,hash_uniq_code) values('"+m_l2_code+"','"+m_l3_bytes+"','"+hash_uniq_code+"')";
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Insert to database  Status : "+flag);
		}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in AdminDAO-register()....."+e);
			}
			return flag;
	}
	
	public static int m_file_get_hash_id(String hashcode) 
	{
		int hash_no=0;
		try
		{ 
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql2="select min(hash_unique_code)from m_hash_code where hash_code='"+hashcode+"' group by hash_code";
			System.out.println(sql2);
			resultSet=statement.executeQuery(sql2);
			while(resultSet.next())
			{
				hash_no=resultSet.getInt(1);
			}
		}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in AdminDAO-register()....."+e);
			}
			return hash_no;
	}
	
	//
	//
	//
	//
	//
	//
	//

	
	
	
	
	
	
	
	public static int getMd(String mdid) {
		int id = 0;
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();

			String sql = "select id from m_trans where file_md='" + mdid
					+ "'";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			System.out.println("File ID to return : " + id);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getUserID()....."
					+ e);
		}
		return id;
	}
	
	
	
	
	
	
	
	
	
	public static ResultSet getFilesByGrpName(String name, String type) {
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("select * from m_trans where trans_type='" + type + "'");
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getUsers()....."
					+ e);
		}
		return resultSet;
	}
	
	
	
	
	
	public static ResultSet getDel(int rs2) {
		try {
			String sql="Delete from m_audit_request where File_id='"+ rs2 + "'";
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			System.out.println("---------<<<<<>>>><<>>"+sql);
			
			System.out.println("---------<<<<<>>>><<>>"+sql);
			System.out.println("---------<<<<<>>>><<>>"+sql);
		
			boolean res = statement.execute(sql);
		
			System.out.println("-------->>>><<<<<>>>><<>>"+res);
			System.out.println("-------->>>><<<<<>>>><<>>"+res);
			System.out.println("-------->>>><<<<<>>>><<>>"+res);
			System.out.println("-------->>>><<<<<>>>><<>>"+res);
			
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getUsers()....."
					+ e);
		}
		return resultSet;
	}
	
	
	

	public static String getGrpName(String userid) {
		String grp_name = "";
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();

			String sql = "select groups from userlogin where userid='" + userid
					+ "'";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				grp_name = resultSet.getString(1);
			}
			System.out.println("User Group name to return : " + grp_name);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getUserID()....."
					+ e);
		}
		return grp_name;
	}
	public static boolean validateotp(String otp) {
		String grp_name = "";
	boolean flag=false;
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();

			String sql = "select * from d_salesperson where  sp_otp='"+otp+"' ";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				flag=true;
			}
			
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getUserID()....."
					+ e);
		}
		return flag;
	}
	public static int getTransID() {
		int id = 1000;
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select id from m_trans");
			while (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			System.out.println("Trans ID to return : " + id);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getTransID()....."
					+ e);
		}
		return id;
	}

	public static boolean makeTrans(int id, String fileName, String type) {
		boolean flag = false;
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			String sql2="update m_file_one set status1='"+type+"' where file_name='"+fileName+"'";
			/*String sql = "insert into m_trans values (?,?,?,?,?,?,?)";
			String status="no";
			// System.out.println("trans value is"+sql);
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, getTransID() + 1);
			ps.setInt(2, id);
			ps.setString(3, fileName);
			ps.setString(4, type);
			ps.setString(5, Utility.getDate());
			ps.setString(6, Utility.getTime());
			ps.setString(7, Utility.getDay());
			
			int i = ps.executeUpdate();*/
			int i=statement.executeUpdate(sql2);
			if (i != 0) {
				flag = true;
			}
			System.out.println("Upload File Status : " + flag);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-makeTrans()....."
					+ e);
		}
		return flag;
	}

	
	
	
	
	
	
	
	
	
	public static boolean UpdateTrans(String id, String type) {
		boolean flag = false;
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("delete from m_file_one where file_no='"
					+ id + "'");
			if (i != 0) {
				flag = true;
			}
			System.out.println("UpdateTrans  Status : " + flag);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-UpdateTrans()....."
					+ e);
		}
		return flag;
	}
	
	
	
	public static boolean Updatehashtable(String id) {
		boolean flag = false;
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("delete from m_hash_code where hash_unique_code='"
					+ id + "'");
			if (i != 0) {
				flag = true;
			}
			System.out.println("Updatehashtable  Status : " + flag);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-UpdateTrans()....."
					+ e);
		}
		return flag;
	}
	
	/*public static boolean UpdateInstance(String blkname) {
		boolean flag = false;
		boolean flag1=false;
		int instnce=0;
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			String sql1="select no_instnce from m_hash_code where blk_name='"+blkname+"'";
			
			resultSet = statement.executeQuery(sql1);
			while (resultSet.next()) 
			{
				instnce = resultSet.getInt(1);
				System.out.println("====INSTANCE++++++"+instnce);
			}
			//String sql2="update m_hash_code set no_instnce='"+instnce+"' where blk_name='"+blkname+"'";
			if(instnce==1)
			{
			flag=Utility.deleteFile(Utility.getPro("server"),Utility.getPro("user"),Utility.getPro("pass"), blkname);
			int i = statement.executeUpdate("delete from m_hash_code where blk_name='"+blkname+"'");
			System.out.println("--------DELETE from m_hash_code table-----"+i);
			}
			else 
			{   
				
				int instnce1=instnce-1;
				String sql2="update m_hash_code set no_instnce='"+instnce1+"' where blk_name='"+blkname+"'";
				System.out.println("----------UPDATE INSTANCE AFTER DELETION OF BLOCK----------"+sql2);
				int i2=statement.executeUpdate("update m_hash_code set no_instnce='"+instnce1+"'where blk_name='"+blkname+"'");
			
			if (i2 != 0) 
			{
				flag1 = true;
			}
			}
			System.out.println("UpdateTrans  Status : " + flag1);
		} catch (Exception e) 
		{
			System.out.println("Opp's+=++++++====+++++ Error is in CommonDAO-UpdateTrans()....."
					+ e);
		}
		return flag;
	}
	*/
	

	public static int getCloudNo(String id) {
		int num = 0;
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("select cloud from m_trans where id='" + id
							+ "'");
			while (resultSet.next()) {
				num = resultSet.getInt(1);
			}
			System.out.println("Cloud Number to return : " + num);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getCloudNo()....."
					+ e);
		}
		return num;
	}

	public static String getGroupName(String userid) {
		String name = "";
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			String sql = "select groups from userlogin where userid='" + userid
					+ "'";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				name = resultSet.getString(1);
			}
			System.out.println("Group name to return : " + name);
		} catch (Exception e) {
			System.out
					.println("Opp's Error is in CommonDAO-getGroupName()....."
							+ e);
		}
		return name;
	}

	public static String getFileName(String id)
	{
		//String fileid= ConvertArrayToString.convertToString(id);
		String fname = "";
		int id2=Integer.parseInt(id);
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_file_one where file_no='"+id2+"'");
			while (resultSet.next()) 
			{
				fname = resultSet.getString(2);
			}
			System.out.println("File Name to return : " +fname);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getFileName()....."
					+ e);
		}
		return fname;
	}
	
	public static String gethashblknos(String fname)
	{
		//String fileid= ConvertArrayToString.convertToString(id);
		String hashblknos=null;
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("select hash_blk_nos from m_file_one where file_name='"+ fname + "'");
			while (resultSet.next()) {
				hashblknos = resultSet.getString(1);
			}
			System.out.println("File Name to return : " +fname);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getHashBlocksName()....."
					+ e);
		}
		return hashblknos;
	}
	
	
	public static String getblocks(String hashid)
	{
		//String fileid= ConvertArrayToString.convertToString(id);
		String hashblkname=null;
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("select blk_name from m_hash_code where hash_unique_code='"
							+ hashid + "'");
			while (resultSet.next()) {
				hashblkname = resultSet.getString(1);
			}
			System.out.println("Block Name to return : " +hashblkname);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getFileName()....."
					+ e);
		}
		return hashblkname;
	}
	
	
	public static boolean getInstance(String hashid)
	{
		//String fileid= ConvertArrayToString.convertToString(id);
		String hashblkname=null;
		boolean flag=false;
		int instance=0;
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("select no_instnce from m_hash_code where hash_unique_code='"
							+ hashid + "'");
			while (resultSet.next())
			{
				instance = resultSet.getInt(1);
			}
			if(instance>1)
			{
			 int instance1=instance-1;	
			 
			 int i2=statement.executeUpdate("update m_hash_code set no_instnce='"+instance1+"'where hash_unique_code='"+hashid+"'");
				
				if (i2 != 0) 
				{
					flag = false;
				}
			}
			 
			else if(instance==1)
			{
				flag=true;
			}
		
			//System.out.println("Block Name to return : " +hashblkname);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getInstance()....."
					+ e);
		}
		return flag;
	}
	
	
	
	/*public static String getFileName2(String[] id)
	{
		String fileid= ConvertArrayToString.convertToString(id);
		String fname = "";
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("select file_name from m_trans where id='"
							+ fileid + "'");
			while (resultSet.next()) {
				fname = resultSet.getString(3);
			}
			System.out.println("File Name to return : " +fname);
			System.out.println("File Name to return --->>><<<<>>>: " +fname);
			System.out.println("File Name to return --->>><<<<>>>: " +fname);
			System.out.println("File Name to return --->>><<<<>>>: " +fname);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getFileName()....."
					+ e);
		}
		return fname;
	}*/

	public static String getMD(String id) {
		String md = "";
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("select file_md from m_trans where id='" + id
							+ "'");
			while (resultSet.next()) {
				md = resultSet.getString(1);
			}
			System.out.println("File MD to return : " + md);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getMD()....." + e);
		}
		return md;
	}

	public static int getUserId(String id) {
		int id1 = 0;
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("select user_id from m_trans where id='" + id
							+ "'");
			while (resultSet.next()) {
				id1 = resultSet.getInt(1);
			}
			System.out.println("User ID to return : " + id1);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getUserId()....."
					+ e);
		}
		return id1;
	}

	public static String getUserName(int id) {
		String uname = "";
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("select userid from userlogin where id='"
							+ id + "'");
			while (resultSet.next()) {
				uname = resultSet.getString(1);
			}
			System.out.println("User Name to return : " + uname);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getUserName()....."
					+ e);
		}
		return uname;
	}

	public static byte[] getPubKey(String userid) throws Exception {
		byte pubKey[] = null;
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			String sql="select pubkey from digkey where userid='"
					+ userid + "'";
			System.out.println("==========pubkey======: "+sql);
			
			resultSet = statement
					.executeQuery(sql);
			while (resultSet.next()) {
				pubKey = resultSet.getBytes(1);
			}
			System.out.println("User pubKey to return : " + pubKey);
		} catch (Exception e) {
			System.out.println("Unable to process file for getPubKey :" + e);
		}
		return pubKey;
	}

	public static byte[] getPvtKey(String userid) throws Exception {
		byte pvtKey[] = null;
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			String sql="select pvtkey from digkey where userid='"
					+ userid + "'";
			System.out.println("sql :"+sql);
			resultSet = statement
					.executeQuery(sql);
			while (resultSet.next()) {
				pvtKey = resultSet.getBytes(1);
			}
			System.out.println("User pvtKey to return : " + pvtKey);
		} catch (Exception e) {
			System.out.println("Unable to process file for getPvtKey :" + e);
		}
		return pvtKey;
	}

	public static byte[] getDS(int id) throws Exception {
		byte ds[] = null;
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("select file_ds from m_trans where user_id='"
							+ id + "'");
			while (resultSet.next()) {
				ds = resultSet.getBytes(1);
			}
			System.out.println("User getDS to return : " + ds);
		} catch (Exception e) {
			System.out.println("Unable to process file for getDS :" + e);
		}
		return ds;
	}
	
	public static byte[] getDS2(int id,String fname) throws Exception {
		byte ds[] = null;
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			String sql="select file_ds from m_trans where user_id='"
					+ id + "' and file_name='"+fname+"'";
			
			System.out.println("========================");
			System.out.println("sql  "+sql);
			resultSet = statement
					.executeQuery(sql);
			while (resultSet.next()) {
				ds = resultSet.getBytes(1);
			}
			System.out.println("User getDS to return : " + ds);
		} catch (Exception e) {
			System.out.println("Unable to process file for getDS :" + e);
		}
		return ds;
	}

	public static String getMailID(String userid) {
		String email = "";
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("select email from userlogin where userid='"
							+ userid + "'");
			while (resultSet.next()) {
				email = resultSet.getString(1);
			}
			System.out.println("email to return : " + email);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getMailID()....."
					+ e);
		}
		return email;
	}

	public static void delete(File file) {
		if (file.isDirectory()) {
			String fileList[] = file.list();
			if (fileList.length == 0) {
				System.out.println("Deleting Directory : " + file.getPath());
				file.delete();
			} else {
				int size = fileList.length;
				for (int i = 0; i < size; i++) {
					String fileName = fileList[i];
					System.out.println("File path : " + file.getPath()
							+ " and name :" + fileName);
					String fullPath = file.getPath() + "/" + fileName;
					File fileOrFolder = new File(fullPath);
					System.out.println("Full Path :" + fileOrFolder.getPath());
					delete(fileOrFolder);
				}
			}
		} else {
			System.out.println("Deleting file : " + file.getPath());
			file.delete();
		}
	}

	public static boolean checkRequest(String[] fileIdArr, String userId) {

		String query = "SELECT File_id FROM m_audit_request WHERE User_id='"
				+ userId + "'";
		ArrayList<String> x_list = new ArrayList<String>();
		ArrayList<String> existingFile = new ArrayList<String>();

		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				x_list.add(resultSet.getString(1));
			}

			existingFile = getArrayList(x_list);

			for (String x_s : fileIdArr) {
				if (existingFile.contains(x_s)) {
					return true;
				}
			}

		} catch (Exception e) {
			System.out
					.println("Opp's Error is in CommonDAO-checkRequest()....."
							+ e);
		}

		return false;
	}

	private static ArrayList<String> getArrayList(ArrayList<String> x_ar) {

		ArrayList<String> x_list = new ArrayList<String>();

		for (String x : x_ar) {
			if (!(x.contains(","))) {
				x_list.add(x);
			} else {
				String[] x_array = x.split(",");
				for (String x_s : x_array) {
					x_list.add(x_s);
				}
			}
		}
		return x_list;
	}

	
	
	public static boolean isFilePresentServer(String fileName) 
	{
	  boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql="select f_name from m_file_upload where f_name='"+fileName+"'";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("File Present Status--->"+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in isFilePresentOnIndiaServer....."+e);
		}
		return flag;
	}
	
	
	
	
	
	
	
	public static ArrayList<String> getCloudByServerID( int server_id)
	{
		ArrayList<String> list = new ArrayList<String>();
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_cloud where c_id='"+server_id+"'");
		
			while(resultSet.next())
			{
				list.add(resultSet.getString(2));//ftp.drivehq.com
				list.add(resultSet.getString(3));//Cloud_user_name
				list.add(resultSet.getString(4));//Cloud_password
				//list.add(resultSet.getString(5));//cloud_directory
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		finally
		{
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
	}
	
	
	
	
	
	
	public static boolean  addDownloadTransaction(int userId,int fileId,String transactionStatus) 
	{
		boolean flag=false;
		String sql="";
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			sql="insert into m_transaction(u_code,f_code,t_status) values('"+userId+"','"+fileId+"','"+transactionStatus+"')";
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Download Transaction Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-addDownloadTransaction(): ");
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean checkUser(String name, String userid) {
		
		
		System.out.println("its came inside check user.....................");
		
		boolean flag=false;
		ResultSet rs=null;
		String sql="";
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			sql="select *from m_executive where username='"+ name + "' and password='" + userid + "'";
			System.out.println(sql);
			rs=statement.executeQuery(sql);
			while(rs.next())
			{
				flag=true;
			}
			System.out.println("Download Transaction Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-addDownloadTransaction(): ");
			e.printStackTrace();
		}
		return flag;
	
	
	
	}

	public static String getposkeys(String sid) {
		
		
		String key1 = "";
		String key2 = "";
		String data="";
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select *  from d_salesperson where sp_id='"+ sid + "'");
			while (resultSet.next()) 
			{
				key1 = resultSet.getString(6);
				key2 = resultSet.getString(7);
			}
			
			 data=key1+"-"+key2;
		
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getUserName()....."
					+ e);
		}
		return data;
		
		
	}

	
public static String getaeskeys() {
		
		
		String key1 = "";
		String key2 = "";
		String data="";
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select *  from m_as ");
			while (resultSet.next()) 
			{
				key1 = resultSet.getString(2);
				key2 = resultSet.getString(3);
			}
			
			 data=key1+"-"+key2;
		
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getUserName()....."
					+ e);
		}
		return data;
		
		
	}
	public static boolean Checkcurrentpassword(String oldpass,String sid) {
		
        
		
		boolean flag=false;
		ResultSet rs=null;
		String sql="";
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			sql="select * from d_salesperson where sp_password='"+ oldpass + "' and sp_id= '"+ sid + "'";
			System.out.println(sql);
			rs=statement.executeQuery(sql);
			while(rs.next())
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return flag;
	
		
		
		
		
		
	}

	public static boolean Checkcurrentpass(String oldpass) {
		
        System.out.println("its came Checkcurrentpassword.....................");
		
		boolean flag=false;
		ResultSet rs=null;
		String sql="";
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			sql="select * from d_admin where admin_password='"+ oldpass + "'";
			System.out.println(sql);
			rs=statement.executeQuery(sql);
			while(rs.next())
			{
				flag=true;
			}
			System.out.println("Download Transaction Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-addDownloadTransaction(): ");
			e.printStackTrace();
		}
		return flag;
	
		
		
		
		
		
	}
	public static boolean Checkadminn(String usr,String pass) {
		
        System.out.println("its came Checkcurrentpassword.....................");
		
		boolean flag=false;
		ResultSet rs=null;
		String sql="";
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			sql="select * from m_admin where admin_password='"+ pass + "' and admin_id='"+ usr + "'";
			System.out.println(sql);
			rs=statement.executeQuery(sql);
			while(rs.next())
			{
				flag=true;
			}
			System.out.println("Download Transaction Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-addDownloadTransaction(): ");
			e.printStackTrace();
		}
		return flag;
	
		
		
		
		
		
	}
public static boolean Checkbankname(String bankname) {
		
        System.out.println("its came Checkbankname.....................");
        String status="Active";
		boolean flag=false;
		ResultSet rs=null;
		String sql="";
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			System.out.println("name or id");
			sql="select * from m_card where card_custid='"+bankname.trim()+"'  and card_status='"+status+"'";
			System.out.println("name or id"+sql);
			rs=statement.executeQuery(sql);
			while(rs.next())
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in Checkbankname(String Checkbankname): ");
			e.printStackTrace();
		}
		return flag;
	
		
		
		
		
		
	}


public static boolean checkatm(String atm) {
	
    System.out.println("its came checkatm.....................");
    String status="Active";
	boolean flag=false;
	ResultSet rs=null;
	String sql="";
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		sql="select * from m_card where card_atmpin='"+atm+"'  and card_status='"+status+"'";
		System.out.println("atm"+sql);
		rs=statement.executeQuery(sql);
		while(rs.next())
		{
			flag=true;
		}
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in checkatm(String atm): ");
		e.printStackTrace();
	}
	return flag;

	
	
	
	
	
}



public static boolean checkbillnoandamount(String bill,String amount) {
	
    System.out.println("its came checkatm...............bill......"+bill);
    String status="Active";
	boolean flag=false;
	ResultSet rs=null;
	String sql="";
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		//sql="select * from t_quotation where q_no='"+bill+"' and net_amount='"+amount+"'";
		sql="select * from t_quotation where net_amount='"+amount+"'";
		System.out.println(sql);
		rs=statement.executeQuery(sql);
		while(rs.next())
		{
			flag=true;
		}
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in checkbillnoandamount(String bill,String amount): ");
		e.printStackTrace();
	}
	return flag;

	
	
	
	
	
}
public static boolean customerid(String customerid) {
	
    System.out.println("its came Checkbankname.....................");
	String status="Active";
	boolean flag=false;
	ResultSet rs=null;
	String sql="";
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		sql="select * from m_card where card_name='"+customerid+"' and card_status='"+status+"'";
		System.out.println(sql);
		rs=statement.executeQuery(sql);
		while(rs.next())
		{
			flag=true;
		}
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in customerid(String Checkbankname): ");
		e.printStackTrace();
	}
	return flag;

	
	
	
	
	
}

public static boolean expirydte(String expirydte) {
	
    System.out.println("its came expirydte.....................");
    String status="Active";
	boolean flag=false;
	ResultSet rs=null;
	String sql="";
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement(); 
		sql="select * from m_card where card_pan='"+expirydte+"' and card_status='"+status+"'";
		System.out.println(sql);
		rs=statement.executeQuery(sql);
		while(rs.next())
		{
			flag=true;
		}
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in expirydte(String expirydte): ");
		e.printStackTrace();
	}
	return flag;

	
	
	
	
	
}



public static boolean pan(String pan) {
	
    System.out.println("its came pan.....................");
    String status="Active";
	boolean flag=false;
	ResultSet rs=null;
	String sql="";
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		sql="select * from m_card where card_pan='"+pan+"'  and card_status='"+status+"'";
		System.out.println(sql);
		rs=statement.executeQuery(sql);
		while(rs.next())
		{
			flag=true;
		}
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in pan(String pan): ");
		e.printStackTrace();
	}
	return flag;

	
	
	
	
	
}




public static boolean cardname(String cardname) {
	
    System.out.println("its came cardname.....................");
    String status="Active";
	boolean flag=false;
	ResultSet rs=null;
	String sql="";
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		sql="select * from m_card where card_exp='"+cardname+"'  and card_status='"+status+"' ";
		System.out.println(sql);
		rs=statement.executeQuery(sql);
		while(rs.next())
		{
			flag=true;
		}
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in cardname(String cardname): ");
		e.printStackTrace();
	}
	return flag;

	
	
	
	
	
}

public static ResultSet gettransactiondetails(String dte,String vtype,String tollname) {
	
    System.out.println("its came Checkcardnumber.....................");
	
	String trans="";
	ResultSet rs=null;
	String sql="";
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		sql="select * from m_androidtransaction where toll_id='"+tollname+"' and toll_vtype='"+vtype+"' and toll_pdte='"+dte+"'";
		System.out.println(sql);
		rs=statement.executeQuery(sql);
		
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in Checkcardnum(String cardnum): ");
		e.printStackTrace();
	}
	return rs;

	
	
	
	
	
}
public static ResultSet getAsCertificate() {
	
    System.out.println("its came Checkcardnumber.....................");
	

	ResultSet rs=null;
	String sql="";
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		sql="select * from m_as";
		System.out.println(sql);
		rs=statement.executeQuery(sql);
		
		
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	return rs;

	
	
	
	
	
}
public static ResultSet gettransactiondetails2(String dte,String vtype,String tollname) {
	
    System.out.println("its came Checkcardnumber.....................");
	
	String trans="";
	ResultSet rs=null;
	String sql="";
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		sql="select sum(toll_fare) from m_androidtransaction where toll_id='"+tollname+"' and toll_vtype='"+vtype+"' and toll_pdte='"+dte+"'";
		System.out.println(sql);
		rs=statement.executeQuery(sql);
		
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in Checkcardnum(String cardnum): ");
		e.printStackTrace();
	}
	return rs;

	
	
	
	
	
}



public static ResultSet gettransactiondetails22(String dte,String tollname) {
	
    System.out.println("its came Checkcardnumber.....................");
	
	String trans="";
	ResultSet rs=null;
	String sql="";
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		sql="select sum(toll_fare) from m_androidtransaction where toll_id='"+tollname+"'  and toll_pdte='"+dte+"'";
		System.out.println(sql);
		rs=statement.executeQuery(sql);
		
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in Checkcardnum(String cardnum): ");
		e.printStackTrace();
	}
	return rs;

	
	
	
	
	
}




public static String Takecardamount(String custid) {
	
    System.out.println("its came Checkcardnumber.....................");
	
	boolean flag=false;
	ResultSet rs=null;
	String sql="";
	String data="";
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		sql="select card_balance from  m_card where card_custid='"+custid+"'";
		System.out.println("tttttttttt "+sql);
		rs=statement.executeQuery(sql);
		while(rs.next())
		{
			
			data=rs.getString(1);
			
		}
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in Takecardamount(String custid) ");
		e.printStackTrace();
	}
	return data;

	
	
	
	
	
}



public static String fetchtollamount(String tollname) {
	
    System.out.println("its came Checkcardnumber.....................");
	
	boolean flag=false;
	ResultSet rs=null;
	String sql="";
	String data="";
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		sql="select f_twow from m_tolldetails where t_id='"+tollname+"'";
		System.out.println(sql);
		rs=statement.executeQuery(sql);
		while (rs.next()) 
		{
	data=	rs.getString(1)	;
			
		}
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in Checkcardnum(String cardnum): ");
		e.printStackTrace();
	}
	return data;

	
	
	
	
	
}


public static String fetchtollamount1(String tollname) {
	
    System.out.println("its came Checkcardnumber.....................");
	
	boolean flag=false;
	ResultSet rs=null;
	String sql="";
	String data="";
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		sql="select f_fourw from m_tolldetails where t_id='"+tollname+"'";
		System.out.println(sql);
		rs=statement.executeQuery(sql);
		while (rs.next()) 
		{
	data=	rs.getString(1)	;
			
		}
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in Checkcardnum(String cardnum): ");
		e.printStackTrace();
	}
	return data;

	
	
	
	
	
}
public static String fetchtollamount2(String tollname) {
	
    System.out.println("its came Checkcardnumber.....................");
	
	boolean flag=false;
	ResultSet rs=null;
	String sql="";
	String data="";
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		sql="select f_van from m_tolldetails where t_id='"+tollname+"'";
		System.out.println(sql);
		rs=statement.executeQuery(sql);
		while (rs.next()) 
		{
	data=	rs.getString(1)	;
			
		}
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in Checkcardnum(String cardnum): ");
		e.printStackTrace();
	}
	return data;

	
	
	
	
	
}
public static String fetchtollamount3(String tollname) {
	
    System.out.println("its came Checkcardnumber.....................");
	
	boolean flag=false;
	ResultSet rs=null;
	String sql="";
	String data="";
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		sql="select f_bus from m_tolldetails where t_id='"+tollname+"'";
		System.out.println(sql);
		rs=statement.executeQuery(sql);
		while (rs.next()) 
		{
	data=	rs.getString(1)	;
			
		}
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in Checkcardnum(String cardnum): ");
		e.printStackTrace();
	}
	return data;

	
	
	
	
	
}



public static String fetchtollamount4(String tollname) {
	
    System.out.println("its came Checkcardnumber.....................");
	
	boolean flag=false;
	ResultSet rs=null;
	String sql="";
	String data="";
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		sql="select f_truck from m_tolldetails where t_id='"+tollname+"'";
		System.out.println(sql);
		rs=statement.executeQuery(sql);
		while (rs.next()) 
		{
	data=	rs.getString(1)	;
			
		}
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in Checkcardnum(String cardnum): ");
		e.printStackTrace();
	}
	return data;

	
	
	
	
	
}
public static ResultSet fetchtolldetails(String tollname) {
	
    System.out.println("its came Checkcardnumber.....................");
	
	boolean flag=false;
	ResultSet rs=null;
	String sql="";
	String data="";
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		sql="select * from m_tolldetails where t_id='"+tollname+"'";
		System.out.println(sql);
		rs=statement.executeQuery(sql);
		
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in Checkcardnum(String cardnum): ");
		e.printStackTrace();
	}
	return rs;
}
	public static boolean changePass(String newpass,String sid) {
		 System.out.println("its came changePass.....................");
			
			boolean flag=false;
			int i=1;
			String sql="";
			try
			{
				Database database=Database.getInstance();
				connection=database.connector();
				statement = connection.createStatement();
				sql="update d_salesperson set sp_password='" + newpass+ "' where sp_id='" + sid+ "'";
				System.out.println(sql);
				i=statement.executeUpdate(sql);
				if(i>0)
				{
					flag=true;
				}
				
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
			}
			return flag;
		
	}
	public static boolean updatestatus(String sid,String otp,String status) {
		 System.out.println("its came changePass.....................");
			
			boolean flag=false;
			int i=1;
			String sql="";
			try
			{
				Database database=Database.getInstance();
				connection=database.connector();
				statement = connection.createStatement();
				sql="update d_salesperson set sp_status='" + status+ "' where sp_otp='"+otp+"'";
				System.out.println(sql);
				i=statement.executeUpdate(sql);
				if(i>0)
				{
					flag=true;
				}
				
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
			}
			return flag;
		
	}
	public static String updateremaingamount(String custid,String remainingamount) {
		
			
			boolean flag=false;
			int i=1;
			String sql="";
			String remainingbalance="";
			try
			{
				Database database=Database.getInstance();
				connection=database.connector();
				statement = connection.createStatement();
				sql="update m_card set card_balance='" + remainingamount+ "' where card_custid='" + custid+ "'";
				System.out.println("remaining"+sql);
				i=statement.executeUpdate(sql);
				if(i>0)
				{
					flag=true;
					
					if(flag==true)
					{
						
						
						
						
						connection=database.connector();
						statement = connection.createStatement();
						sql="select card_balance from m_card where card_custid='"+custid+"'";
						System.out.println(sql);
					ResultSet	rs=statement.executeQuery(sql);
						
						while (rs.next()) {
							remainingbalance=	rs.getString(1);
							
						}
						
						
						
						
						
						
						
					}
					
					
					
					
					
				}
				System.out.println("update stutus is  : "+flag);
				
				
				
				
			}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in UserDAO-addDownloadTransaction(): ");
				e.printStackTrace();
			}
			return remainingbalance;
		
			
		
	}
	
	public static boolean changePassad(String newpass) {
		 System.out.println("its came changePass.....................");
			
			boolean flag=false;
			int i=1;
			String sql="";
			try
			{
				Database database=Database.getInstance();
				connection=database.connector();
				statement = connection.createStatement();
				sql="update d_admin set admin_password='" + newpass+ "'";
				System.out.println(sql);
				i=statement.executeUpdate(sql);
				if(i>0)
				{
					flag=true;
				}
				System.out.println("update stutus is  : "+flag);
			}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in UserDAO-addDownloadTransaction(): ");
				e.printStackTrace();
			}
			return flag;
		
			
			
			
			
			
		
	}
	
	

	public static boolean changePasspatient(String oldpass,String newpass) {
		 System.out.println("its came changePass.....................");
			
			boolean flag=false;
			int i=1;
			String sql="";
			try
			{
				System.out.println(">>>>>>>>>>>??????????????????its acme into change pass");
				Database database=Database.getInstance();
				connection=database.connector();
				statement = connection.createStatement();
				sql="update m_patient set password='"+newpass+"' where password='"+oldpass+"'";
				System.out.println(sql);
				i=statement.executeUpdate(sql);
				if(i>0)
				{
					flag=true;
				}
				System.out.println("update stutus is  : "+flag);
			}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in UserDAO-addDownloadTransaction(): ");
				e.printStackTrace();
			}
			return flag;
		
			
			
			
			
			
		
	}


	public static boolean checkpatient(String patientname,
			String patientpassword) {
		
		

		System.out.println("its came inside check user.....................");
		
		boolean flag=false;
		ResultSet rs=null;
		String sql="";
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			sql="select *from m_patient where p_id='"+ patientname + "' and password='" + patientpassword + "'";
			System.out.println(sql);
			rs=statement.executeQuery(sql);
			while(rs.next())
			{
				flag=true;
			}
			System.out.println("patient check status: "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-addDownloadTransaction(): ");
			e.printStackTrace();
		}
		return flag;
	
	
	}


		public static ArrayList<String> getpatientfiles(String patientid)
		{
			ArrayList<String> list = new ArrayList<String>();
			try
			
			{
				
				System.out.println("patient id is>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+patientid);
				Database database=Database.getInstance();
				connection=database.connector();
				statement = connection.createStatement();
				resultSet = statement.executeQuery("select f_name from m_file where p_id='"+patientid+"'");
			
				while(resultSet.next())
				{
					list.add(resultSet.getString(1));
					
				}
				
			}
			catch(Exception e)
			{
				System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
			}
			finally
			{
				try {
					resultSet.close();
					statement.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			return list;
		}

		public static ArrayList<String> selectcloud() {
			
			
			
			ArrayList<String> list = new ArrayList<String>();
			try
			
			{
				
				Database database=Database.getInstance();
				connection=database.connector();
				statement = connection.createStatement();
				resultSet = statement.executeQuery("select host_name,username,password from m_cloud");
			
				while(resultSet.next())
				{
					list.add(resultSet.getString(1));
					list.add(resultSet.getString(2));
					list.add(resultSet.getString(3));
				}
				
			}
			catch(Exception e)
			{
				System.out.println("Exception in selectcloud: "+ e);
			}
			finally
			{
				try {
					resultSet.close();
					statement.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			return list;
		}

		public static boolean Checkcurrentpasswordpatient(String oldpass) {
			
			 System.out.println("its came Checkcurrentpasswordpatient.....................");
				
				boolean flag=false;
				ResultSet rs=null;
				String sql="";
				try
				{
					Database database=Database.getInstance();
					connection=database.connector();
					statement = connection.createStatement();
					sql="select *from m_patient where password='"+ oldpass + "'";
					System.out.println(sql);
					rs=statement.executeQuery(sql);
					while(rs.next())
					{
						flag=true;
					}
					System.out.println("check current password is  : "+flag);
				}
				catch(Exception e)
				{
					System.out.println("Opp's Error is in UserDAO-addDownloadTransaction(): ");
					e.printStackTrace();
				}
				return flag;
			
			
			
		}

		public static boolean checkdoctor(String doctorid1,
				String doctorpassword1) {
			
			
			

			System.out.println("its came inside check doctor.....................");
			
			boolean flag=false;
			ResultSet rs=null;
			String sql="";
			try
			{
				Database database=Database.getInstance();
				connection=database.connector();
				statement = connection.createStatement();
				sql="select *from m_doctor where d_id='"+ doctorid1 + "' and password='" + doctorpassword1 + "'";
				System.out.println(sql);
				rs=statement.executeQuery(sql);
				while(rs.next())
				{
					flag=true;
				}
				System.out.println("Doctor id check status: "+flag);
			}
			catch(Exception e)
			{
				System.out.println("check status of doctor is : ");
				e.printStackTrace();
			}
			return flag;
		
		
			
			
			
		}

		public static boolean Checkcurrentpasswordoctor(String oldpass) {

			 System.out.println("its came Checkcurrentpasswordpatient.....................");
				
				boolean flag=false;
				ResultSet rs=null;
				String sql="";
				try
				{
					Database database=Database.getInstance();
					connection=database.connector();
					statement = connection.createStatement();
					sql="select *from m_doctor where password='"+ oldpass + "'";
					System.out.println(sql);
					rs=statement.executeQuery(sql);
					while(rs.next())
					{
						flag=true;
					}
					System.out.println("check current password of doctor  : "+flag);
				}
				catch(Exception e)
				{
					System.out.println("Opp's Error is in UserDAO-addDownloadTransaction(): ");
					e.printStackTrace();
				}
				return flag;
			
		}

		public static boolean changePassdoctor(String oldpass, String newpass) {
			 System.out.println("its came changePass.....................");
				
				boolean flag=false;
				int i=1;
				String sql="";
				try
				{
					Database database=Database.getInstance();
					connection=database.connector();
					statement = connection.createStatement();
					sql="update m_doctor set password='"+newpass+"' where password='"+oldpass+"'";
					System.out.println(sql);
					i=statement.executeUpdate(sql);
					if(i>0)
					{
						flag=true;
					}
					System.out.println("update stutus is  : "+flag);
				}
				catch(Exception e)
				{
					System.out.println("Opp's Error is in UserDAO-addDownloadTransaction(): ");
					e.printStackTrace();
				}
				return flag;
			
		}	
		public static boolean checkPin( String pin)
		{
			System.out.println("its came Check Fingerprint.....................");
			
			boolean flag=false;
			ResultSet rs=null;
			String sql="";
			try
			{
				Database database=Database.getInstance();
				connection=database.connector();
				statement = connection.createStatement();
				sql="select * from m_card where  card_atmpin='"+pin+"'";
				System.out.println(sql);
				rs=statement.executeQuery(sql);
				System.out.println(rs);
				while(rs.next())
				{
					flag=true;
				}
				System.out.println("Download Transaction Status : "+flag);
			}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in UserDAO-addDownloadTransaction(): ");
				e.printStackTrace();
			}
			return flag;
		}

		public static boolean checkpin(String pin, String cardid) {
System.out.println("its came Check pin.....................");
			
			boolean flag=false;
			ResultSet rs=null;
			String sql="";
			try
			{
				Database database=Database.getInstance();
				connection=database.connector();
				statement = connection.createStatement();
				sql="select * from m_card where card_atmpin ='"+ pin.trim() + "' and card_custid='"+cardid+"'";
				System.out.println(sql);
				rs=statement.executeQuery(sql);
				System.out.println(rs);
				while(rs.next())
				{
					flag=true;
				}
				System.out.println("Download Transaction Status : "+flag);
			}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in UserDAO-addDownloadTransaction(): ");
				e.printStackTrace();
			}
			return flag;
		}

		public static String checkbill(String bill) {
System.out.println("its came Check pin.....................");
			
			String flag="";
			ResultSet rs=null;
			String sql="";
			try
			{
				Database database=Database.getInstance();
				connection=database.connector();
				statement = connection.createStatement();
				sql="select net_amount from t_quotation where q_no ='"+bill.trim() + "'";
				System.out.println(sql);
				rs=statement.executeQuery(sql);
				System.out.println(rs);
				while(rs.next())
				{
					flag=rs.getString(1);
				}
				System.out.println("Download Transaction Status : "+flag);
			}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in UserDAO-addDownloadTransaction(): ");
				e.printStackTrace();
			}
			return flag;
			
		}

		public static boolean updateAmount(String pin,String amount) {
System.out.println("its came Check pin.....................");
			
			boolean flag=false;
			ResultSet rs=null;
			String sql="";
			try
			{
				Database database=Database.getInstance();
				connection=database.connector();
				statement = connection.createStatement();
				sql="update  m_card  set card_balance ='"+amount+"' where card_atmpin ='"+pin.trim() + "'";
				System.out.println(sql);
				int i=statement.executeUpdate(sql);
				System.out.println(rs);
				if(i!=0)
				{
					flag=true;
				}
				System.out.println("Download Transaction Status : "+flag);
			}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in UserDAO-addDownloadTransaction(): ");
				e.printStackTrace();
			}
			return flag;
			
			
		}

		public static String gettotamount(String pin ,String cardid) {
System.out.println("its came Check pin.....................");
			
			String flag="";
			ResultSet rs=null;
			String sql="";
			try
			{
				Database database=Database.getInstance();
				connection=database.connector();
				statement = connection.createStatement();
				sql="select card_balance from m_card where card_atmpin ='"+pin.trim() + "' and card_custid='"+cardid+"'";
				System.out.println(sql);
				rs=statement.executeQuery(sql);
				System.out.println(rs);
				while(rs.next())
				{
					flag=rs.getString(1);
				}
				System.out.println("Download Transaction Status : "+flag);
			}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in UserDAO-addDownloadTransaction(): ");
				e.printStackTrace();
			}
			return flag;
			
		}	
		
		
		
		public static String getupdatedAmt(String pin) {
			System.out.println("its came Check pin.....................");
						
						String flag="";
						ResultSet rs=null;
						String sql="";
						try
						{
							Database database=Database.getInstance();
							connection=database.connector();
							statement = connection.createStatement();
							sql="select card_balance from m_card where card_atmpin ='"+pin.trim() + "'";
							System.out.println(sql);
							rs=statement.executeQuery(sql);
							System.out.println(rs);
							while(rs.next())
							{
								flag=rs.getString(1);
							}
							System.out.println("Download Transaction Status : "+flag);
						}
						catch(Exception e)
						{
							System.out.println("Opp's Error is in UserDAO-addDownloadTransaction(): ");
							e.printStackTrace();
						}
						return flag;
						
					}
		
		
		public static boolean deletebill(String bill) {
			boolean flag = false;
			try {
				Database database = Database.getInstance();
				connection = database.connector();
				statement = connection.createStatement();
				int i = statement.executeUpdate("delete  from t_quotation where q_no='"
						+ bill + "'");
				if (i != 0) {
					flag = true;
				}
				System.out.println("UpdateTrans  Status : " + flag);
			} catch (Exception e) {
				System.out.println("Opp's Error is in CommonDAO-UpdateTrans()....."
						+ e);
			}
			return flag;
		}
}
	

