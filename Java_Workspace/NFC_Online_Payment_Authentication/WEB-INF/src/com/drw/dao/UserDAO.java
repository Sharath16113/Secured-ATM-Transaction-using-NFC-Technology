package com.drw.dao;
import com.drw.action.Key_generation_rns;

import com.drw.serviceLocation.*;

import java.util.Date;
import java.text.SimpleDateFormat;

import java.sql.*;

public class UserDAO 
{
	public static  int checkAUser(String admin_id,String admin_password)
	{
		int flag=0;
		try
		{
			System.out.println("admin_id");
			serverConnector obj=new serverConnector();
			Connection con=obj.serverConnector();
			System.out.println("Connection Established");
			Statement stmt=con.createStatement();
			String sqlquery="select * from d_admin";
			ResultSet rs=stmt.executeQuery(sqlquery);
			while(rs.next())
					{
						String adminid=rs.getString("admin_id");
						String adminpass=rs.getString("admin_password");
						if(adminid.equals(admin_id) && adminpass.equals(admin_password))
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
	public static int checkUser(String userid,String password)
	{int flag=0;
	try
	{     System.out.println("userid is:"+userid+","+password);
		 serverConnector obj=new serverConnector();
		   Connection con=obj.serverConnector();
		   System.out.println("connection established");
		   Statement st=con.createStatement();
		   String sqlquery="select * from d_salesperson where sp_id='"+userid+"'&& sp_password='"+password+"'";
		   ResultSet rs=st.executeQuery(sqlquery);
		   if(rs.next())
		   {
			   flag=1;
		   
		   }
	}
			catch(Exception e)
			{
				System.out.println(e);
			
			}
		    return flag;
		   
	}
	public static int addsales1(String sp_id,String sp_password,String sp_name,String sp_address,String sp_mobile,String key1,String key2,String spemail)
	{
		int flag=0;
		try
		{
			
			
			
			
			
			serverConnector obj=new serverConnector();
			Connection con=obj.serverConnector();
			System.out.println("Connection Established");
			Statement stmt=con.createStatement();
			String sqlquery="insert into d_salesperson(sp_id,sp_password,sp_name,sp_address,sp_mobile,sp_publickey,sp_secretkey,sp_email) values('"+sp_id+"','"+sp_password+"','"+sp_name+"','"+sp_address+"','"+sp_mobile+"','"+key1+"','"+key2+"','"+spemail+"')";
			flag=stmt.executeUpdate(sqlquery);
			
			
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}
	public static int insertUser(int code,String id,String password,String name, String contactperson,String address,String area,String city,String state,String pincode,String type ,String landmark,String phone,String mobile,String fax,String email)
	{int flag=0;
	try
	{
	serverConnector obj=new serverConnector();
	Connection con=obj.serverConnector();
	System.out.println("connection established");
	Statement st=con.createStatement();	
	String sqlquery="insert into d_customer_qps(cust_code, cust_id,cust_password, cust_name,  cust_contact_person, cust_address, cust_area, cust_city, cust_state, cust_pincode, cust_type , cust_landmark, cust_phone, cust_mobile, cust_fax, cust_email)values("+code+",'"+id+"','"+password+"','"+name+"','"+contactperson+"','"+address+"','"+area+"','"+city+"','"+state+"','"+pincode+"','"+type+"','"+landmark+"','"+phone+"','"+mobile+"','"+fax+"','"+email+"')";
	flag=st.executeUpdate(sqlquery);


	}
		catch(Exception e)
		{
			System.out.println(e);
		
		}
	 return flag;

	}
	public static int changeuser(String adminid,String adminnewpass)
	{
		int flag=0;
		try
		{
			serverConnector obj=new serverConnector();
			Connection con=serverConnector.serverConnector();
			System.out.println("Connection Established");
			Statement stmt=con.createStatement();
			String sqlquery="update d_admin set admin_password='"+adminnewpass+"' where admin_id='"+adminid+"'";
			flag=stmt.executeUpdate(sqlquery);
			
			}
	
		catch(Exception e){
		System.out.println(e);
		
	}
	return flag;
	}
	public static int deleteUser(String userid)
	{int flag=0;
	try
	{System.out.println(userid);
	serverConnector obj=new serverConnector();
	Connection con=obj.serverConnector();
	System.out.println("connection established");
	Statement st=con.createStatement();	
	String sqlquery="delete from d_customer_qps where cust_id='"+userid+"'";
	flag=st.executeUpdate(sqlquery);


	}
		catch(Exception e)
		{System.out.println(e);
		
		}
	 return flag;

	}
	
	public static int deleteAuser(String userid)
	{int flag=0;
	try
	{System.out.println(userid);
	serverConnector obj=new serverConnector();
	Connection con=obj.serverConnector();
	System.out.println("connection established");
	Statement st=con.createStatement();	
	String sqlquery="delete from d_salesperson where sp_id='"+userid+"'";
	flag=st.executeUpdate(sqlquery);


	}
		catch(Exception e)
		{System.out.println(e);
		
		}
	 return flag;

	}
	public static int deleteproduct(int code ,int qno)
	{int flag=0;
	try
	{
	serverConnector obj=new serverConnector();
	Connection con=obj.serverConnector();
	System.out.println("connection established");
	Statement st=con.createStatement();	
	String sqlquery="delete from t_quotation where pro_code='"+code+"' && q_no='"+qno+"'";
	flag=st.executeUpdate(sqlquery);

	}
		catch(Exception e)
		{System.out.println(e);
		
		}
	 return flag;

	}
	public static int updateUser(String id,String name,String contactperson,String address,String area,String city,String state,String pincode,String type ,String landmark,String phone,String mobile,String fax,String email)
	{
		int flag=0;
	try
	{
	serverConnector obj=new serverConnector();
	Connection con=obj.serverConnector();
	System.out.println("connection established");
	Statement st=con.createStatement();	
	String sqlquery="update d_customer_qps set cust_name='"+name+"',cust_contact_person='"+contactperson+"',cust_address='"+address+"',cust_area='"+area+"',cust_city='"+city+"',cust_state='"+state+"',cust_pincode='"+pincode+"', cust_type='"+type+"',cust_landmark='"+landmark+"',cust_phone='"+phone+"',cust_mobile='"+mobile+"',cust_fax='"+fax+"',cust_email='"+email+"' where cust_id='"+id+"'";
	flag=st.executeUpdate(sqlquery);
	}
		catch(Exception e)
		{System.out.println(e);
		
		}
	 return flag;

	}
	public static int updatequotation(float tot,int qno)
	{
		int flag=0;
	try
	{
	serverConnector obj=new serverConnector();
	Connection con=obj.serverConnector();
	System.out.println("connection established");
	Statement st=con.createStatement();	
	String sqlquery="update d_quotation set tot_amount='"+tot+"' where q_no='"+qno+"'";
	flag=st.executeUpdate(sqlquery);
	}
		catch(Exception e)
		{System.out.println(e);
		
		}
	 return flag;

	}
	public static int qu(int code,float qty,float tot,int qno)
	{
		int flag=0;
	try
	{
	serverConnector obj=new serverConnector();
	Connection con=obj.serverConnector();
	System.out.println("connection established");
	Statement st=con.createStatement();	
	String sqlquery="update t_quotation set  qty='"+qty+"',amount='"+tot+"' where pro_code='"+code+"' and q_no='"+qno+"'";
	flag=st.executeUpdate(sqlquery);
	}
		catch(Exception e)
		{System.out.println(e);
		
		}
	 return flag;

	}
	
	public static int updatebillstatus()
	{
		int flag=0;
		int sn=0;
	try
	{
	serverConnector obj=new serverConnector();
	Connection con=obj.serverConnector();
	System.out.println("connection established");
	Statement st=con.createStatement();	
	String sql2="select s_no from t_quotation ORDER BY s_no desc LIMIT 1 ";
	ResultSet rs=st.executeQuery(sql2);
	   if(rs.next())
	   {
		   sn=rs.getInt(1);
	   
	   }
	String sqlquery="update t_quotation set status='yes' where s_no='"+sn+"'";
	flag=st.executeUpdate(sqlquery);
	}
		catch(Exception e)
		{System.out.println(e);
		
		}
	 return flag;

	}

	public static int checkpassword(String adminid,String adminoldpass)
	{
		int flag=0;
		try
		{
		serverConnector obj=new serverConnector();
		 Connection con=obj.serverConnector();
		 System.out.println("coonection estsblished"); 
		 Statement stmt=con.createStatement();
		 String query="select admin_password from d_admin where admin_id='"+adminid+"'";
		 ResultSet rs=(ResultSet) stmt.executeQuery(query);
		 while(rs.next())
		 {
			 String s1=rs.getString(1);
			 System.out.println(s1);
			 if(s1.equals(adminoldpass))
			 {
				 flag=1;
				 System.out.println("exists");
 
			 }
		 }
		}
		catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 	return flag;	
	}
	public static int checkqno(int qno)
	{
		int flag=0;
		try
		{
		serverConnector obj=new serverConnector();
		 Connection con=obj.serverConnector();
		 System.out.println("coonection estsblished"); 
		 Statement stmt=con.createStatement();
		 String query="select q_no from d_quotation ";
		 ResultSet rs=(ResultSet) stmt.executeQuery(query);
		 while(rs.next())
		 {
			 String s1=rs.getString(1);
			 int s2=Integer.parseInt(s1);
			 System.out.println(s1);
			 if(s2==qno)
			 {
				 flag=1;
				 System.out.println("exists");
 
			 }
		 }
		}
		catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 	return flag;	
	}
	public static int checkproduct(String s)
	{
		int flag=0;
		try
		{
		serverConnector obj=new serverConnector();
		 Connection con=obj.serverConnector();
		 System.out.println("coonection estsblished"); 
		 Statement stmt=con.createStatement();
		 String query="select pro_name from d_product where pro_name like'"+s+"%'";
		 ResultSet rs=(ResultSet) stmt.executeQuery(query);
		 while(rs.next())
		 {
			 String s1=rs.getString(1);
			 
			 System.out.println(s1);
			 if(s1.equals(s))
			 {
				 flag=1;
				 System.out.println(" product exists");
 
			 }
		 }
		}
		catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 	return flag;
	}
	public static int  code(String code)
	{
		int s=0;
		try
		{
		serverConnector obj=new serverConnector();
		 Connection con=obj.serverConnector();
		 System.out.println("coonection estsblished"); 
		 Statement stmt=con.createStatement();
		 String query="select cust_code from d_customer_qps where cust_id='"+code+"'";
		 ResultSet rs=(ResultSet) stmt.executeQuery(query);
		 while(rs.next())
		 {
			s=Integer.parseInt(rs.getString(1));
			 
		 }
		 
		}
		catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 	return s;
	}
	public static int  getqno()
	{
		int s=0;
		try
		{
		serverConnector obj=new serverConnector();
		 Connection con=obj.serverConnector();
		 System.out.println("coonection estsblished"); 
		 Statement stmt=con.createStatement();
		 String query="select max(q_no)from t_quotation";
		 ResultSet rs=(ResultSet) stmt.executeQuery(query);
		 while(rs.next())
		 {
			s=Integer.parseInt(rs.getString(1));
			 
		 }
		 
		}
		catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 	return s;
	}
	public static String  getname(int code)
	{
		String s1="";
		try
		{
		serverConnector obj=new serverConnector();
		 Connection con=obj.serverConnector();
		 System.out.println("coonection estsblished"); 
		 Statement stmt=con.createStatement();
		 String query="select pro_name from d_product where pro_code='"+code+"'";
		 ResultSet rs=(ResultSet) stmt.executeQuery(query);
		 while(rs.next())
		 {
			s1=rs.getString(1);
			 
		 }
		 
		}
		catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 	return s1;
	}
	public static float  gettotal(int qno)
	{
		float s1=0.0f;
		try
		{
		serverConnector obj=new serverConnector();
		 Connection con=obj.serverConnector();
		 System.out.println("coonection estsblished"); 
		 Statement stmt=con.createStatement();
		 String query="select tot_amount from d_quotation where q_no='"+qno+"'";
		 ResultSet rs=(ResultSet) stmt.executeQuery(query);
		 while(rs.next())
		 {
			s1=Float.parseFloat(rs.getString(1));
			 
		 }
		 
		}
		catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 	return s1;
	}
	public static float  getprice(int code)
	{
		float s1=0.0f;
		try
		{
		serverConnector obj=new serverConnector();
		 Connection con=obj.serverConnector();
		 System.out.println("coonection estsblished"); 
		 Statement stmt=con.createStatement();
		 String query="select pro_price from d_product where pro_code='"+code+"'";
		 ResultSet rs=(ResultSet) stmt.executeQuery(query);
		 while(rs.next())
		 {
			s1=Float.parseFloat(rs.getString(1));
			 
		 }
		 
		}
		catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 	return s1;
	}
	public static float  gettax(int code)
	{
		float s1=0.0f;
		try
		{
		serverConnector obj=new serverConnector();
		 Connection con=obj.serverConnector();
		 System.out.println("coonection estsblished"); 
		 Statement stmt=con.createStatement();
		 String query="select pro_tax from d_product where pro_code='"+code+"'";
		 ResultSet rs=(ResultSet) stmt.executeQuery(query);
		 while(rs.next())
		 {
			s1=Float.parseFloat(rs.getString(1));
			 
		 }
		 
		}
		catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 	return s1;
	}
	public static int  getcatcode(int code)
	{
		int s=0;
		try
		{
		serverConnector obj=new serverConnector();
		 Connection con=obj.serverConnector();
		 System.out.println("coonection estsblished"); 
		 Statement stmt=con.createStatement();
		 String query="select cat_code from d_product where pro_code='"+code+"'";
		 ResultSet rs=(ResultSet) stmt.executeQuery(query);
		 while(rs.next())
		 {
			s=Integer.parseInt(rs.getString(1));
			 
		 }
		 
		}
		catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 	return s;
	}



	public static String datefor()
	{
		SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy");
		Date curr= new Date();
		String t=s.format(curr);
		return t;
	}
	
	public static int insertquery(String d,String des,String e,String p)
	{int flag=0;
	try
	{
	serverConnector obj=new serverConnector();
	Connection con=obj.serverConnector();
	System.out.println("connection established");
	Statement st=con.createStatement();	
	String sqlquery="insert into d_queries(qry_date,qry_description,qry_emailid,qry_phone_no) values('"+d+"','"+des+"','"+e+"','"+p+"')";
	flag=st.executeUpdate(sqlquery);


	}
		catch(Exception e1)
		{
			System.out.println(e1);
		
		}
	 return flag;

	}
	public static int inserd(String d,int code,float tot)
	{int flag=0;
	try
	{
		
	serverConnector obj=new serverConnector();
	Connection con=obj.serverConnector();
	System.out.println("connection established");
	Statement st=con.createStatement();	
	String sqlquery="insert into d_quotation(q_date,cust_code,tot_amount) values('"+d+"',"+code+","+tot+")";
	flag=st.executeUpdate(sqlquery);


	}
		catch(Exception e1)
		{
			System.out.println(e1);
		
		}
	 return flag;

	}
	public static int insertt(int q_no,int pro_code,int cat_code,float qty,float price,float tax,float amount)
	{int flag=0;
	try
	{
	
		int qno1=0;
		String status="";
	serverConnector obj=new serverConnector();
	Connection con=obj.serverConnector();
	System.out.println("connection established");
	Statement st=con.createStatement();	
	String sql2="select q_no, status from t_quotation ORDER BY s_no desc LIMIT 1  ";
	
	ResultSet rs=(ResultSet) st.executeQuery(sql2);
	 while(rs.next())
	 {
		 qno1=rs.getInt(1);
		 status=rs.getString(2);
		 
	 }
	 qno1=qno1+1;
	 String sqlquery="";
	 if(status.equals("yes"))
	 {
			 sqlquery="insert into t_quotation(q_no,pro_code,cat_code,qty,price,tax,amount) values("+qno1+","+pro_code+","+cat_code+","+qty+","+price+","+tax+","+amount+")";
	 }
	 else
	 {
		  sqlquery="insert into t_quotation(q_no,pro_code,cat_code,qty,price,tax,amount) values("+q_no+","+pro_code+","+cat_code+","+qty+","+price+","+tax+","+amount+")"; 
	 }
	
	
	flag=st.executeUpdate(sqlquery);


	}
		catch(Exception e1)
		{
			System.out.println(e1);
			e1.printStackTrace();
		
		}
	 return flag;

	}
	
	public static int  gettabautoid()
	{
		int s=0;
		try
		{
		serverConnector obj=new serverConnector();
		 Connection con=obj.serverConnector();
		 System.out.println("coonection estsblished"); 
		 Statement stmt=con.createStatement();
		 String select_sql = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 't_quotation' AND table_schema = DATABASE( ) ;";
		
		 ResultSet rs=(ResultSet) stmt.executeQuery(select_sql);
		 while(rs.next())
		 {
			s=Integer.parseInt(rs.getString(1));
			 
		 }
		 
		}
		catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 	return s;
	}

	
	
	public static boolean updatenetamount(int billno)
	{
		boolean flag1=false;
		int s=0;
		try
		{
			
			boolean flag=false;
			String  data="";
		serverConnector obj=new serverConnector();
		 Connection con=obj.serverConnector();
		 System.out.println("coonection estsblished"); 
		 Statement stmt=con.createStatement();
		 String select_sql = " select sum(amount)from t_quotation where q_no='"+billno+"'";
		
		 ResultSet rs=(ResultSet) stmt.executeQuery(select_sql);
		 while(rs.next())
		 {
			 data=rs.getString(1);
			 flag=true;
			 System.out.println("data is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+data);
			 
		 }
		 
		 if(flag)
		 {
			 Connection con1=obj.serverConnector();
			 System.out.println("coonection estsblished"); 
			 Statement stmt1=con1.createStatement();
			 String select_sqls = " update t_quotation set net_amount='"+data+"' where q_no='"+billno+"'";
			 s= stmt1.executeUpdate(select_sqls);
			 flag1=true;
			 
			 
		 }
		 
		}
		catch(Exception e)
		 {
			 System.out.println(e);
		 }
		return flag1;
		 	
	}

	
	
	
	public static int quoupdatre(int proCode, float q, float tot) {
		// TODO Auto-generated method stub
		return 0;
	}
	public static int getCard(String readID) 
	{
		int flag=0;
		try
		{
			System.out.println("readID");
			serverConnector obj=new serverConnector();
			Connection con=obj.serverConnector();
			System.out.println("Connection Established");
			Statement stmt=con.createStatement();
			String sqlquery="select * from card";
			ResultSet rs=stmt.executeQuery(sqlquery);
			while(rs.next())
					{
						String xrf_id=rs.getString("rf_id");
						String xname=rs.getString("name");
						String xcard_no=rs.getString("card_no");
						String xmo_no=rs.getString("mo_no");
						
					}
				}
				
		catch(Exception e)
		{
			
			System.out.println(e);
		}
		return flag;
	}
	public static int checkCard(String readID) 
	{
		int flag=0;
		try
		{
			System.out.println("readID");
			serverConnector obj=new serverConnector();
			Connection con=obj.serverConnector();
			System.out.println("Connection Established");
			Statement stmt=con.createStatement();
			String sqlquery="select * from card";
			ResultSet rs=stmt.executeQuery(sqlquery);
			while(rs.next())
					{
						String xid=rs.getString("rf_id");
						if(xid.equals(readID))
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
	public static String checkbillno() {
		int data=0;
		boolean flag=false;
		try
		{
			
			System.out.println("readID");
			serverConnector obj=new serverConnector();
			Connection con=obj.serverConnector();
			System.out.println("Connection Established");
			Statement stmt=con.createStatement();
			String sqlquery="select q_no from d_quotation";
			ResultSet rs=stmt.executeQuery(sqlquery);
			
			while(rs.next())
			{
				
				 data=rs.getInt(1);
				
			}
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return String.valueOf(data);
	}
	public static int adduser(String card_bank,String card_custid,String card_pan,String card_name,String card_exp,String card_balance,String card_atmpin)
	{
		int flag=0;
		try
		{
			
			
			
			
			
			serverConnector obj=new serverConnector();
			Connection con=obj.serverConnector();
			System.out.println("Connection Established");
			Statement stmt=con.createStatement();
			String sqlquery="insert into m_card(card_bank,card_custid,card_pan,card_name,card_exp,card_balance,card_atmpin) values('"+card_bank+"','"+card_custid+"','"+card_pan+"','"+card_name+"','"+card_exp+"','"+card_balance+"','"+card_atmpin+"')";
			System.out.println("userrrrrrrr "+sqlquery);
			flag=stmt.executeUpdate(sqlquery);
			
			
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}
	
	public static int  checkFingerPrint(String s)
	{
		int str=0;
		try
		{
		serverConnector obj=new serverConnector();
		 Connection con=obj.serverConnector();
		 System.out.println("coonection estsblished"); 
		 Statement stmt=con.createStatement();
		 String select_sql = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 't_quotation' AND table_schema = DATABASE( ) ;";
		
		 ResultSet rs=(ResultSet) stmt.executeQuery(select_sql);
		 while(rs.next())
		 {
			str=Integer.parseInt(rs.getString(1));
			 
		 }
		 
		}
		catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 	return str;
	}
	public static int checkbank(String userid,String password)
	{int flag=0;
	try
	{     System.out.println("userid is:"+userid+","+password);
		 serverConnector obj=new serverConnector();
		   Connection con=obj.serverConnector();
		   System.out.println("connection established");
		   Statement st=con.createStatement();
		   String sqlquery="select * from m_bank where d_name='"+userid+"'&& d_password='"+password+"'";
		   ResultSet rs=st.executeQuery(sqlquery);
		   if(rs.next())
		   {
			   flag=1;
		   
		   }
	}
			catch(Exception e)
			{
				System.out.println(e);
			
			}
		    return flag;
		   
	}
	public static int  checkFingerPrint1(String pin,String s)
	{
		int str=0;
		try
		{
		serverConnector obj=new serverConnector();
		 Connection con=obj.serverConnector();
		 System.out.println("coonection estsblished"); 
		 Statement stmt=con.createStatement();
		 String select_sql = "SELECT * from m_card where card_atmpin='"+pin+"' and fingerprint='"+s+"'";
		System.out.println(select_sql);
		 ResultSet rs=(ResultSet) stmt.executeQuery(select_sql);
		 while(rs.next())
		 {
			str=Integer.parseInt(rs.getString(1));
			 
		 }
		 
		}
		catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 	return str;
	}
	
	
	public static int updatetotal(String tot)
	{
		int flag=0;
		try
		{
			serverConnector obj=new serverConnector();
			Connection con=serverConnector.serverConnector();
			System.out.println("Connection Established");
			Statement stmt=con.createStatement();
			//String sqlquery="update d_admin set admin_password='"+adminnewpass+"' where admin_id='"+adminid+"'";
			//flag=stmt.executeUpdate(sqlquery);
			
			}
	
		catch(Exception e){
		System.out.println(e);
		
	}
	return flag;
	}
	
	
	public static int getnetvalue(String pin)
	{
		int flag=0;
		try
		{
			serverConnector obj=new serverConnector();
			Connection con=serverConnector.serverConnector();
			System.out.println("Connection Established");
			Statement stmt=con.createStatement();
			String sqlquery="select net_amount from t_quotation where pin='"+pin+"'";
			flag=stmt.executeUpdate(sqlquery);
			
			}
	
		catch(Exception e){
		System.out.println(e);
		
	}
	return flag;
	}
}
	
	
	




