package com.Database;

import java.util.ArrayList;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper
{

	 // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "db_empapp";

    // Contacts table name
    private static final String TABLE_CONTACTS = "m_employee";
    private static final String TABLE_KEY = "m_otp";
    
    // Key Table Columns names
    private static final String KEY_ID1 = "k_id";
    private static final String KEY_AES = "emp_no";
    private static final String OTP = "emp_otp";
   
    
    

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_USERID = "emp_no";
    private static final String KEY_PASS = "emp_name";
    private static final String KEY_NAME = "from_mobile";
    private static final String KEY_EMAIL = "to_mobile";
    
    
    	// OTP Table 
 		
 	    private static final String query1 = "CREATE TABLE " + TABLE_KEY
 	            + "(" + KEY_ID1 + " INTEGER PRIMARY KEY," + KEY_AES + " TEXT," + OTP +" TEXT"+ ")";
 	    
 		
    
    private final ArrayList<User> emp_list = new ArrayList<User>();
    
    
	public DataBaseHelper(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
	}
	
	@Override
	public void onCreate(SQLiteDatabase db)
	{
		System.out.println("********** Start to Create the Table ************");
		// User Table
		 String query = "CREATE TABLE " + TABLE_CONTACTS + "("+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_USERID + " TEXT," + KEY_PASS + " TEXT," + KEY_NAME + " TEXT," + KEY_EMAIL + " TEXT" + ")";
		 
		 Log.d("Create Query", query);
		 
		 db.execSQL(query);
		 
		 // Key Table
		 Log.d("Create Table for Key ", query1);
		 
		 db.execSQL(query1);
		 
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		 // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KEY);

        // Create tables again
        onCreate(db);
		
	}
	
	// Adding new user
    public boolean Add_Emp(User user)
    {
    	boolean b = false;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_USERID, user.getEmpNo()); // Employee No
        values.put(KEY_PASS, user.getEmpName()); // Employee Name
        values.put(KEY_NAME, user.getFromMobile()); // Mobile Number1
        values.put(KEY_EMAIL, user.getToMobile()); // Mobile Number2
       
        // Inserting Row
       db.insert(TABLE_CONTACTS, null, values);
       db.close(); // Closing database connection
        
       b = true;
	   return b;
        
    }
    
 // Adding AES Key
    public boolean inserKey(KeySet key)
    {
    	boolean b = false;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_AES, key.getKey_aes()); // User ID
        values.put(OTP, key.getEmpOtp()); // User ID
       
        // Inserting Row
       db.insert(TABLE_KEY, null, values);
       db.close(); // Closing database connection
        
        b = true;
		return b;
        
    }

 // Getting Key
    public KeySet Get_OTP(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_KEY, new String[] { KEY_ID1,KEY_AES,OTP }, KEY_AES + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        KeySet contact = new KeySet(cursor.getString(1),cursor.getString(2));
        // return contact
        cursor.close();
        db.close();

        return contact;
    }
    
 // Check User Id Already Exist
    public boolean Check_Empno(String empno)
    {
 	   boolean b = false;
         try {
         	

             // Check User ID
             String selectQuery = "SELECT  * FROM " + TABLE_KEY+" where emp_no='"+empno+"'";
             
             System.out.println("selectQuery :"+selectQuery);
             SQLiteDatabase db = this.getWritableDatabase();
             
             System.out.println("selectQuery ddfgdfg:"+selectQuery);
             
             Cursor cursor = db.rawQuery(selectQuery, null);
             
             System.out.println("cursor :"+cursor.getCount());
             
             if(cursor.getCount()!=0)
             {
             	b = true;
             }
             
           
         }
         catch (Exception e)
         {
            
             Log.e("all_contact", "" + e);
         }

         return b;
     }

    
    
    
// Check User Id Already Exist
   public boolean Check_UserId(String userid)
   {
	   boolean b = false;
        try {
        	

            // Check User ID
            String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS+" where emp_no='"+userid+"'";
            
            System.out.println("selectQuery :"+selectQuery);
            SQLiteDatabase db = this.getWritableDatabase();
            
            System.out.println("selectQuery ddfgdfg:"+selectQuery);
            
            Cursor cursor = db.rawQuery(selectQuery, null);
            
            System.out.println("cursor :"+cursor.getCount());
            
            if(cursor.getCount()!=0)
            {
            	b = true;
            }
            
          
        }
        catch (Exception e)
        {
           
            Log.e("all_contact", "" + e);
        }

        return b;
    }

   // Updating single contact
   public int Update_OTP(String otp,String empno)
   {
       SQLiteDatabase db = this.getWritableDatabase();

       ContentValues values = new ContentValues();
       values.put(OTP, otp);
       
       // updating row
       return db.update(TABLE_KEY, values, KEY_ID + " = ?",
               new String[] { String.valueOf(empno) });
   }
   
   // Updating single contact
   public int Update_Emp(String enm,String sno)
   {
	   System.out.println("...... "+enm+"...."+sno);
       SQLiteDatabase db = this.getWritableDatabase();

       ContentValues values = new ContentValues();
       values.put(KEY_PASS, enm);
       
       // updating row
       return db.update(TABLE_CONTACTS, values, KEY_USERID + " = ?",
               new String[] { String.valueOf(sno) });
   }
    
    
   
}
