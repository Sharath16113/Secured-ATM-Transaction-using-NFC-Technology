package com.example.nfc_bill_payment_application;


import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.HttpClient.CustomHttpClient;
import com.HttpClient.Global;




import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
Button btn;
EditText txt1;
Toast toast;
String	response;
EditText txt2;

SessionManager session;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		try
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = 
			        new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
			}
		
		btn=(Button) findViewById(R.id.signinbutton);
		
		txt1=(EditText) findViewById(R.id.sid);
		
		txt2=(EditText) findViewById(R.id.password);
		
		
		 
			
		
		session = new SessionManager(getApplicationContext());
	btn.setOnClickListener(new OnClickListener() {
		
		@SuppressLint("ShowToast")
		@Override
		public void onClick(View v) {
			
		String sid=	txt1.getText().toString();
		
		
		SharedPreferences.Editor editor = getSharedPreferences("Login", MODE_PRIVATE).edit();
		 editor.putString("sid",sid); 			
		 editor.commit();
		
		System.out.println("sid is >>>>>>>>>>>>>>>>>>>>>"+sid);
		String password=	txt2.getText().toString();
		
		System.out.println("password is >>>>>>>>>>>>>>>>>>>>>"+password);
		if(sid.equals(""))
		{
				Toast.makeText(getApplicationContext(), "Please,Enter  Id", Toast.LENGTH_LONG).show();
				return;
		}
		if(password.equals(""))
		{
				Toast.makeText(getApplicationContext(), "Please,Enter  Password", Toast.LENGTH_LONG).show();
				return;
		}
		else
		{
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("sid", sid));
		nameValuePairs.add(new BasicNameValuePair("passs", password));
		
		
	try {
	response = CustomHttpClient.executeHttpPost(Global.URL+"slaeslogin.jsp", nameValuePairs);
		
		System.out.println("response value is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+response);
		
		
	
		
		
			
			
			Toast.makeText(getApplicationContext(), "Enter One Time Password", Toast.LENGTH_LONG).show();
			
			//session.createLoginSession(sid,password);
			Intent intent = new Intent(getApplicationContext(), OTP.class);
			startActivity(intent);
			
		
		
	}
	
	
	
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		}	
		
		
		

		
		
		}	
		
	
	});	
		
		
	
			
	
		}catch (Exception e) {
			// TODO: handle exception
		}
	
	}
}
