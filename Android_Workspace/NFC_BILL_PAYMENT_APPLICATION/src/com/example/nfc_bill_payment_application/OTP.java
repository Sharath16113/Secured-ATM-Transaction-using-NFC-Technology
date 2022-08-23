
package com.example.nfc_bill_payment_application;
import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.HttpClient.CustomHttpClient;
import com.HttpClient.Global;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OTP extends Activity {
	Button btn;
	EditText txt1;
	Toast toast;
	String	response;
	EditText txt2;
	String	sid="",uid="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_otp);
		
		/*SharedPreferences sp1=this.getSharedPreferences("login",0);

                sid=sp1.getString("sid", null);       */
	 			
	 			
	 			SharedPreferences prefs = getSharedPreferences("Login", MODE_PRIVATE); 
	 			String restoredText = prefs.getString("text", null);
	 			if (restoredText != null) {
	 			   sid = prefs.getString("sid", "No name defined");//"No name defined" is the default value.
	 			 System.out.println("sid >>>>>>>>>>>>>"+sid);	
	 			}	
	 			
	 			
	 			
	 			
		btn=(Button) findViewById(R.id.signinbutton);
		
		txt1=(EditText) findViewById(R.id.sid);
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				String otp=	txt1.getText().toString();
				
				System.out.println("otp is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+otp);


				SharedPreferences prefs = getSharedPreferences("Login", MODE_PRIVATE); 
	 			String restoredText = prefs.getString("text", null);
	 			if (restoredText != null) {
	 			    uid = prefs.getString("sid", "No name defined");//"No name defined" is the default value.
	 			 System.out.println("sid >>>>>>>>>>>>>"+sid);	
	 			}
	 			 System.out.println("uid >>>>>>>>>>>>>"+uid);
				 System.out.println("uid >>>sending >>>>>>>>>>"+uid);
				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("otp", otp));
				nameValuePairs.add(new BasicNameValuePair("UID", uid));
				
	 			
		
			try {
				response = CustomHttpClient.executeHttpPost(Global.URL+"OTP", nameValuePairs);
				
				
				
				

				if(response.trim().equalsIgnoreCase("true"))
				{
					Toast.makeText(getApplicationContext(), "Successfully loginned", Toast.LENGTH_LONG).show();
					
					
					Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
					startActivity(intent);
					
				}
				else
				{
					Toast.makeText(getApplicationContext(), "Invalid OTP", Toast.LENGTH_LONG).show();
					Intent intent = new Intent(getApplicationContext(), OTP.class);
					startActivity(intent);
					
				}
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				System.out.println("response value is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+response);
				
				
				
			}	
			
		});
		
		
	}

	}