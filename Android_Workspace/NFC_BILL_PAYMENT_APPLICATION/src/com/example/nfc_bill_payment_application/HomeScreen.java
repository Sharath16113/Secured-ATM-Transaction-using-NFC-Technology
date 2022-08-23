package com.example.nfc_bill_payment_application;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
 
public class HomeScreen extends Activity 
{
	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        
       
        
      
         
       
       
       
        
    }
     
    // Initiating Menu XML file (menu.xml)
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.homemenu, menu);
        return true;
    }
     
  
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
         
        switch (item.getItemId())
        {
        case R.id.nfccardread:
           
            Toast.makeText(HomeScreen.this, "  NFC Reading Process", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(), Billnumber.class);
            startActivity(i);
            return true;
            
   
 
        case R.id.changepass:
            Toast.makeText(HomeScreen.this, "Sales Persons Change Password", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), ChangePassword.class);
            startActivity(intent);
            return true;
 
       
 
            
        case R.id.logout:
            Toast.makeText(HomeScreen.this, "You Have Logged Out Successfully", Toast.LENGTH_SHORT).show();
            Intent intent3 = new Intent(getApplicationContext(), IPActivity.class);
            startActivity(intent3);
            return true;
 
       
 
        default:
            return super.onOptionsItemSelected(item);
        }
    }   
    
    @Override
	public void onBackPressed()
	{
		Intent intent1 = new Intent(this,HomeScreen.class);
		startActivity(intent1);
		
	}
 
}











