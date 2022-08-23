package com.example.nfc_payment_writing_androidapp;




import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IPActivity extends Activity
{
	public static String data="";
	ProgressDialog prgDialog;
	TextView user,pass;
	EditText id,ip;
	Button login;
	
	String adminid,adminpass;

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
	
		setContentView(R.layout.ip);
		
	
		
		login = (Button) findViewById(R.id.login);
		
		
		ip = (EditText) findViewById(R.id.ip);
		
		
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
		data=		ip.getText().toString();
		
		      Toast.makeText(getApplicationContext(), "IP is>>>>>>"+data, Toast.LENGTH_LONG).show();
				Intent intent=new Intent(getApplicationContext(),MainActivity.class);
				intent.putExtra("ip", data);
				startActivity(intent);
				
				
				
			}
		});
		
		
		
		
		
	}
	
	

	

}
