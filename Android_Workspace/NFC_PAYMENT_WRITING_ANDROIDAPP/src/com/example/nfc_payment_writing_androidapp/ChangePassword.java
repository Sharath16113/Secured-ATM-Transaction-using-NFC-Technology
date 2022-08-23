
package com.example.nfc_payment_writing_androidapp;

import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.HttpClient.CustomHttpClient;
import com.HttpClient.Global;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePassword extends Activity
{
	String current_pass = "", new_pass = "", loginu = "", confirmpa = "";
	EditText c_pass, new_password, con_pass;
	String output1 = "";
	String result = "";
	Button change;
	String pass = "";
	String response="";
	
	
	boolean b =false;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.changepass);
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = 
			        new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
			}
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		c_pass = (EditText) findViewById(R.id.current_pass);
		 
		new_password = (EditText) findViewById(R.id.new_password);
		
		
		con_pass = (EditText) findViewById(R.id.confirm_password);
		

		
		change = (Button) findViewById(R.id.login);

		change.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				current_pass = c_pass.getText().toString();
				new_pass = new_password.getText().toString();
				confirmpa = con_pass.getText().toString();
				System.out.println(""+current_pass);
				System.out.println(""+new_pass);
				System.out.println(""+confirmpa);
				
				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("CurrentPass", current_pass));
				nameValuePairs.add(new BasicNameValuePair("NewPass",new_pass));
				nameValuePairs.add(new BasicNameValuePair("ConfirmPass", confirmpa));
			

				System.out.println("All Values " + current_pass + "."+ new_pass + "." + confirmpa);
				

				if ((current_pass.equals("") || current_pass.length() == 0)&& (new_pass.equals(""))&& (confirmpa.equals("") || confirmpa.length() == 0))
				{
					Toast.makeText(getApplicationContext(),	" Please Enter All the Fields ",Toast.LENGTH_SHORT).show();
					
				}
			
				 if("".equals(current_pass))
				{
					
					Toast.makeText(getApplicationContext(),	" Please Enter Current Password ",Toast.LENGTH_SHORT).show();
				}
				 if("".equals(new_pass))
				{
					Toast.makeText(getApplicationContext(),	" Please Enter New Password ",Toast.LENGTH_SHORT).show();
				}
				 if("".equals(confirmpa))
				{
					
					Toast.makeText(getApplicationContext(),	" Please Enter Confirm Password ",Toast.LENGTH_SHORT).show();
				}
				 if(!new_pass.equals(confirmpa))
				{
					
					Toast.makeText(getApplicationContext(),	" New Password and Confirm Password Mismatch ",Toast.LENGTH_SHORT).show();
				}
				 else
				 {

					try {
					
						
						
						response = CustomHttpClient.executeHttpPost(Global.URL+"Changepass", nameValuePairs);

						String result1 = response.trim();
						System.out.println("Output From Fine Dest>>>>>>>>>>>>>>> " + result1);

						if (result1.equals("true"))
						{
							Toast.makeText(getApplicationContext(),"Admin Password Changed Successfully",
									Toast.LENGTH_LONG).show();
							Intent intent = new Intent(getApplicationContext(),
									HomeScreen.class);
							startActivity(intent);
						} else
						{

							Toast.makeText(getApplicationContext(),
									"Error in password changing",
									Toast.LENGTH_LONG).show();
							Intent intent1 = new Intent(
									getApplicationContext(), ChangePassword.class);
							startActivity(intent1);
						}

					} catch (Exception e)
					{
						
						Toast.makeText(getApplicationContext()," Exception "+e,Toast.LENGTH_LONG).show();
					}

				
				}
				
			}
				
		});

	}

}

