package com.example.nfc_bill_payment_application;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.HttpClient.CustomHttpClient;
import com.HttpClient.Global;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;


@SuppressLint("ShowToast")
public class Viewreadeddata extends Activity {
	TextView ed1,ed2,ed3,ed4,ed5,ed6;
	String strDae="";
	SessionManager session;
	Context ctx;
	@SuppressLint("SimpleDateFormat")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewcontent);
	ed1=	(TextView) findViewById(R.id.remaing);
	
	
	Button btn=	(Button) findViewById(R.id.bttn);
	
	
	
	
	btn.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent1 = new Intent(getApplicationContext(),
					HomeScreen.class);
			startActivity(intent1);	
			
		}
	});
    
    
    
 
		 Intent intent = getIntent();
         String sm= intent.getStringExtra("sm");
		System.out.println("sm data is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sm);
		
		 String sid= intent.getStringExtra("sid");
			System.out.println("sid data is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sid);
			
			

   		 ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
   			
   			nameValuePairs.add(new BasicNameValuePair("sm", sm));
   			nameValuePairs.add(new BasicNameValuePair("sid", sid));
   			

		try {
	String	response =  CustomHttpClient.executeHttpPost(Global.URL+"BillpaymentNew", nameValuePairs);
			
			String[] s=response.split("~");
			Toast.makeText(getApplicationContext(),"resppp"+s[1] , Toast.LENGTH_LONG).show();
		if(s[0].equals("success"))
		{
			
			ed1.setText(s[1]);
		}
		else
		{
			Toast.makeText(getApplicationContext(), "not valid ----Transaction failed", Toast.LENGTH_LONG).show();
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

				
				
			
		
	}
	
	
	     
}
