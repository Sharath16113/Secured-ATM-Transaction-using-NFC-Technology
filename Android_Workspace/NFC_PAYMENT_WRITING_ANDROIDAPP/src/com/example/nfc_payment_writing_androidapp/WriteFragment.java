package com.example.nfc_payment_writing_androidapp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.HttpClient.CustomHttpClient;
import com.HttpClient.Global;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WriteFragment extends Activity
{
	// References for Writing Data into NFC Tag Start
		NfcAdapter adapter;
		PendingIntent pendingIntent;
		IntentFilter writeTagFilters[];
		boolean writeMode;
		Tag mytag;
		Context ctx;
		String contents="";
	
	String enumber = "";
	String epname = "";

	String from_mobile="",to_mobile;
	
	//SessionManager session;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState)
{
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.write);
		Button writedata = (Button) findViewById(R.id.write);
		
		
		final EditText bankname = (EditText) findViewById(R.id.bname);
	
		final EditText custid = (EditText) findViewById(R.id.custid);
		final EditText Custname = (EditText) findViewById(R.id.cname);
		
		final EditText expdate = (EditText) findViewById(R.id.expdate);
		
		final EditText pann = (EditText) findViewById(R.id.pan);

		// Login Action

		writedata.setOnClickListener(new View.OnClickListener()
		{

			public void onClick(View v)
			{
				
			String	banknamee = bankname.getText().toString();
			
			String	cudtidd = custid.getText().toString();
			String	custnamee = Custname.getText().toString();
		
			String	expdatee = expdate.getText().toString();
				
			String	pannum = pann.getText().toString();
				
				
				
				
				
				
				
				System.out.println("data  is.........."+banknamee+cudtidd+custnamee+expdatee+pannum);		
			
			
				String carddata =banknamee+"~"+cudtidd+"~"+custnamee+"~"+expdatee+"~"+pannum;
				
				
				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("carddata", carddata));
			
				
				
			
			try
			{
				contents=	CustomHttpClient.executeHttpPost(Global.URL+"Carddata", nameValuePairs);
				
				System.out.println("contents.trim() is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+contents.trim());
				
				
				
			} 
			
			
			catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
		
				
				
				
				
				
				
				System.out.println("contents.trim() is.........."+contents.trim());
				try 
					{
					
					
						Toast.makeText(getApplicationContext(), "carddata>>"+contents.trim(), Toast.LENGTH_LONG).show();
						
						
						String s1="Bangalore is a Garden City in India";
						
						byte out[]=XOR_Operation.xorWithData(s1.getBytes(), contents.trim().getBytes());
						String s3=new String(out);
						
						if(mytag==null)
						{
							Toast.makeText(ctx, ctx.getString(R.string.error_detected), Toast.LENGTH_LONG ).show();
						}
						else
						{
							// Call Write() Method to Write Details to NFC Tag //
							Toast.makeText(getApplicationContext(), "Encryption Success", Toast.LENGTH_LONG).show();
							
							write(s3,mytag);
							showCustomAlert();
							//Intent intent = new Intent(getApplicationContext(), MainActivity.class);
							//startActivity(intent);
							Toast.makeText(ctx, ctx.getString(R.string.ok_writing), Toast.LENGTH_LONG ).show();
							
							
							
							
							
							
						}

					}
					catch (Exception e)
					{
						//exception.setText("Exception:"+e.toString());
						System.out.println("********* Exception *********");
						//Toast.makeText(getApplicationContext(),"Exception"+e.toString(),Toast.LENGTH_SHORT).show();
						e.printStackTrace();
					}
				
				
				
            	
				}
			
			
			
			
		//}
			
			

		});
		
		adapter = NfcAdapter.getDefaultAdapter(this);
		
		// PendingIntent to run when tag gets scanned and Intent to start the current Activity
		pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
		
		// ACTION_TAG_DISCOVERED will launch the onNewIntent method
		IntentFilter tagDetected = new IntentFilter(NfcAdapter.ACTION_TAG_DISCOVERED);
		tagDetected.addCategory(Intent.CATEGORY_DEFAULT);
		writeTagFilters = new IntentFilter[] {tagDetected };
	}
	public void showCustomAlert()
	{
	     
	    Context context = getApplicationContext();
	    // Create layout inflator object to inflate toast.xml file
	    LayoutInflater inflater = getLayoutInflater();
	      
	    // Call toast.xml file for toast layout 
	    View toastRoot = inflater.inflate(R.layout.success, null);
	      
	    Toast toast = new Toast(context);
	     
	    // Set layout to toast 
	    toast.setView(toastRoot);
	    toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL,
	            0, 0);
	    toast.setDuration(Toast.LENGTH_LONG);
	    toast.show();
	     
	}
	
	@SuppressLint("NewApi")
	private void write(String text, Tag tag) throws IOException, FormatException
	{

		//Toast.makeText(getApplicationContext(), " Write() Method Called", Toast.LENGTH_LONG).show();
		
		NdefRecord[] records = {createRecord(text) };
		
		NdefMessage  message = new NdefMessage(records);
		
		//Toast.makeText(getApplicationContext(), "Start to Create Instance", Toast.LENGTH_LONG).show();
		
		// Get an instance of Ndef for the tag.
		Ndef ndef = Ndef.get(tag);
		
		//Toast.makeText(getApplicationContext(), "Enable Input and Output", Toast.LENGTH_LONG).show();
		
		// Enable I/O
		ndef.connect();
		Toast.makeText(getApplicationContext(), "Start to Write Data", Toast.LENGTH_LONG).show();
		
		// Write the message
		ndef.writeNdefMessage(message);
		// Close the connection
		ndef.close();
	}

	@SuppressLint("NewApi")
	private NdefRecord createRecord(String text) throws UnsupportedEncodingException
	{
		Toast.makeText(getApplicationContext(), "Start to createRecord", Toast.LENGTH_LONG).show();
		
		String lang       = "en";
		byte[] textBytes  = text.getBytes();
		byte[] langBytes  = lang.getBytes("US-ASCII");
		int    langLength = langBytes.length;
		int    textLength = textBytes.length;
		byte[] payload    = new byte[1 + langLength + textLength];

		// set status byte (see NDEF spec for actual bits)
		payload[0] = (byte) langLength;

		// copy langbytes and textbytes into payload
		System.arraycopy(langBytes, 0, payload, 1,              langLength);
		System.arraycopy(textBytes, 0, payload, 1 + langLength, textLength);

		NdefRecord recordNFC = new NdefRecord(NdefRecord.TNF_WELL_KNOWN,  NdefRecord.RTD_TEXT,  new byte[0], payload);

		return recordNFC;
	}
	
	@SuppressLint("NewApi")
	protected void onNewIntent(Intent intent)
	{
		// onNewIntent() to pull out the NFC Tag  
		if(NfcAdapter.ACTION_TAG_DISCOVERED.equals(intent.getAction()))
		{
			mytag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);    
			Toast.makeText(this, this.getString(R.string.ok_detection) + mytag.toString(), Toast.LENGTH_LONG ).show();
		}
	}
	
	@Override
	public void onPause()
	{
		super.onPause();
		WriteModeOff();
	}

	@Override
	public void onResume()
	{
		super.onResume();
		WriteModeOn();
	}

	@SuppressLint("NewApi")
	private void WriteModeOn()
	{
		writeMode = true;
		adapter.enableForegroundDispatch(this, pendingIntent, writeTagFilters, null);
	
	
	}

	@SuppressLint("NewApi")
	private void WriteModeOff(){
		writeMode = false;
		adapter.disableForegroundDispatch(this);
	}
	
	
	
}
