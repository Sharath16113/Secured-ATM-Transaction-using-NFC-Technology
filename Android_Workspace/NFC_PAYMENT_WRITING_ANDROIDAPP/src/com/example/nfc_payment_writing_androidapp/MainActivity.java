package com.example.nfc_payment_writing_androidapp;


import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.HttpClient.CustomHttpClient;
import com.HttpClient.Global;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.wifi.WifiManager.WifiLock;
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
WifiLock wifiLock;
EditText txt2;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		try
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*
		WifiManager wm = (WifiManager) getSystemService(Context.WIFI_SERVICE);
		wifiLock = wm.createWifiLock(WifiManager.WIFI_MODE_FULL , "MyWifiLock");
		wifiLock.acquire();*/

		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = 
			        new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
			}
		
		btn=(Button) findViewById(R.id.signinbutton);
		
		txt1=(EditText) findViewById(R.id.username);
		
		txt2=(EditText) findViewById(R.id.password);
		
		
	btn.setOnClickListener(new OnClickListener() {
		
		@SuppressLint("ShowToast")
		@Override
		public void onClick(View v) {
			
		String username=	txt1.getText().toString();
		
		System.out.println("username is >>>>>>>>>>>>>>>>>>>>>"+username);
		String password=	txt2.getText().toString();
		
		System.out.println("password is >>>>>>>>>>>>>>>>>>>>>"+password);
		if(username.equals(""))
		{
				Toast.makeText(getApplicationContext(), "Please,Enter User Id", Toast.LENGTH_LONG).show();
				return;
		}
		if(password.equals(""))
		{
				Toast.makeText(getApplicationContext(), "Please,Enter User Password", Toast.LENGTH_LONG).show();
				return;
		}
		else
		{
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("user", username));
		nameValuePairs.add(new BasicNameValuePair("passs", password));
		
		
	try {
	response = CustomHttpClient.executeHttpPost(Global.URL+"admin.jsp", nameValuePairs);
		
		System.out.println("response value is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+response);
		
		
	
		
		if(response.trim().equalsIgnoreCase("true"))
		{
			Toast.makeText(getApplicationContext(), "Admin Logged In Successfully", Toast.LENGTH_LONG).show();
			Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
			startActivity(intent);
		}
		else
		{
			
			
			Toast.makeText(getApplicationContext(), "Login error,please enter correct admin ID and Admin Password", Toast.LENGTH_LONG).show();
			Intent intent = new Intent(getApplicationContext(), MainActivity.class);
			startActivity(intent);
			
		}
		
		
		
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
