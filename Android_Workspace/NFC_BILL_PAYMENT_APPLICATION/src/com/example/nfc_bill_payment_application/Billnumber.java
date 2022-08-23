package com.example.nfc_bill_payment_application;


import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.HttpClient.CustomHttpClient;
import com.HttpClient.Global;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Billnumber extends Activity {
	
	EditText ed1,ed2,ed3;
	Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.write);
		ed1=	(EditText) findViewById(R.id.billno);
		ed2=	(EditText) findViewById(R.id.amount);
		ed3=(EditText) findViewById(R.id.pin);
	     btn=	(Button) findViewById(R.id.write);
	     
	     btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
			String billno=	ed1.getText().toString();
			System.out.println("billno >>>>>>>>>>>>"+billno);
				
			String amount=	ed2.getText().toString();
			System.out.println("amount >>>>>>>>>>>>"+amount);
			String pin=	ed3.getText().toString();
			System.out.println("pin >>>>>>>>>>>>"+pin);
			ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("pin", pin));
			 
			
		try {
		String response = CustomHttpClient.executeHttpPost(Global.URL+"checkpin.jsp", nameValuePairs);
		Toast.makeText(getApplicationContext(), "resp to server:  "+response , Toast.LENGTH_LONG).show();
			System.out.println("response value is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+response);

			if(response.trim().equalsIgnoreCase("true"))
			{
			Intent intent=new Intent(getApplicationContext(),ReadFragment.class);
			intent.putExtra("billno", billno);
			intent.putExtra("amount", amount);
			intent.putExtra("pin", pin);
			startActivity(intent);
			}
			else{
				Toast.makeText(getApplicationContext(), "Entered details are incorrect  " , Toast.LENGTH_LONG).show();
			}
			
			
			
			}		
			
			
			
			
			
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
	     
	}

	
}
