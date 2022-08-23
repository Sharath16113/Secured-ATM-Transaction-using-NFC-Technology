


package com.example.nfc_bill_payment_application;

import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
 
public class SessionManager
{
    // Shared Preferences
    SharedPreferences pref;
     
    // Editor for Shared preferences
    Editor editor;
     
    // Context
    Context _context;
     
    // Shared pref mode
    int PRIVATE_MODE = 0;
     
    // Sharedpref file name
    private static final String PREF_NAME = "AndroidLogin";
     
    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";
     
    // User name (make variable public to access from outside)
    public static final String KEY_NAME = "name";
    public static final String KEY_DATE = "date";
    public static final String KEY_AMOUNT = "amount";
    public static final String KEY_KEY = "ukey";
    public static final String KEY_PWD = "pwd";
    public static final String KEY_SERVER = "server";
    public static final String KEY_SERVERUID = "serveruid";
    public static final String KEY_SERVERPASS = "serverpass";
    public static final String KEY_PHONE = "phone";
    
     
    // Email address (make variable public to access from outside)
    public static final String KEY_EMAIL = "pwd";
     
    // Constructor
    public SessionManager(Context context)
    {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
     
    /**
     * Create login session
     * */
    public void createLoginSession(String name,String pwd)
    {
    	System.out.println("============================");
    	System.out.println("name :"+name +" pass :"+pwd);
    	System.out.println("============================");
        
        editor.putBoolean(IS_LOGIN, true);
         
        
        editor.putString(KEY_NAME, name);
        
       
         
        
         
        editor.putString(KEY_PWD, pwd);
       
        
        
       
        
       
        editor.commit();
    }   
    
    public void createOutputSession(String name,String date,String amount)
    {
    	
    	System.out.println("UserN "+name+"Date "+date+"Amount "+amount);
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);
         
        // Storing name in pref
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_DATE, date);
        editor.putString(KEY_AMOUNT, amount);
         
        // Storing email in pref
        //editor.putString(KEY_EMAIL, email);
         
        // commit changes
        editor.commit();
    }   
     
    
     
     
    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
        user.put(KEY_NAME, pref.getString(KEY_NAME, null));
        user.put(KEY_PWD, pref.getString(KEY_PWD, null));
      
        
        
        
        
       
        // return user
        return user;
    }
    
    public HashMap<String, String> getUserDetails1()
    {
        HashMap<String, String> user1 = new HashMap<String, String>(); 
        // user name
        user1.put(KEY_NAME, pref.getString(KEY_NAME, null));
         
        // user data
       user1.put(KEY_DATE, pref.getString(KEY_DATE, null));
        user1.put(KEY_AMOUNT, pref.getString(KEY_AMOUNT, null));
         
        // return user
        return user1;
    }
     
    public void logoutUser()
    {
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();
    }
    
  
    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
}