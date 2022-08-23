package com.example.nfc_payment_writing_androidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class Viewreadeddata extends Activity {
	TextView ed1,ed2,ed3,ed4,ed5,ed6;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewcontent);
	ed1=	(TextView) findViewById(R.id.cardno);
	
	/*ed2=	(EditText) findViewById(R.id.vehicleno);*/
	ed3=	(TextView) findViewById(R.id.dor);
	ed4=	(TextView) findViewById(R.id.vtype);
	/*ed5=	(EditText) findViewById(R.id.model);*/
	ed6=	(TextView) findViewById(R.id.expdate);
	
	Button btn =	(Button) findViewById(R.id.back);
		 Intent intent = getIntent();
         String readdata= intent.getStringExtra("readdata");
		System.out.println("read data is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+readdata);
		
		
		String[] data=readdata.split("~");
	String cardnum=	data[0];
	System.out.println("cardnum>>>>>>>>>>>>>>>>>>"+cardnum);
	/*String vehiclenum=	data[1];
	System.out.println("vehiclenum>>>>>>>>>>>>>>>>>>"+vehiclenum);*/
	String dor=	data[1];
	System.out.println("dor>>>>>>>>>>>>>>>>"+dor);
	String vtype=	data[2];
	
	System.out.println("vtype>>>>>>>>>>>>>>>>>>"+vtype);
   /* String model=	data[4];
    
    System.out.println("model>>>>>>>>>>>>>>>>>>"+model);*/
	String expdate=	data[3];
	 System.out.println("expdate>>>>>>>>>>>>>>>>>>"+expdate);
		
		ed1.setText(cardnum);
		/*ed2.setText(vehiclenum);*/
		ed3.setText(dor);
		ed4.setText(vtype);
		/*ed5.setText(model);*/
		ed6.setText(expdate);
		
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				
				
    			Intent intentdata=new Intent(getApplicationContext(),HomeScreen.class);
    			
    			startActivity(intentdata);
    			
				
				
				
				
				
				
				
				
				
				
			}
		});
		
		
		
		
		
		
		
		
		
	}
}
