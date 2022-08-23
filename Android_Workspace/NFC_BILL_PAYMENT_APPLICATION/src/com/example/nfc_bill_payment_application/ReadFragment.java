package com.example.nfc_bill_payment_application;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.Database.DataBaseHelper;
import com.Database.KeySet;
import com.Database.XOR_Operation;
import com.HttpClient.CustomHttpClient;
import com.HttpClient.Global;




import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.IntentFilter.MalformedMimeTypeException;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.os.AsyncTask;
import android.os.Bundle;

import android.telephony.SmsManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ReadFragment extends Activity
{

	public static final String MIME_TEXT_PLAIN = "text/plain";
	public static final String TAG = "NfcDemo";
	public static TextView testMag,textencry,otptextview;
	private NfcAdapter mNfcAdapter;
	
	EditText editText,otppassword;
	ImageButton button;
	
	String tag_data="";
	   String message="";
	DataBaseHelper baseHelper;
	String	 sid="";
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.read);
		 
		 SharedPreferences sp1=this.getSharedPreferences("Login",0);

	 sid=sp1.getString("sid", null);       
		 			System.out.println("sid is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sid);	 
		editText = (EditText) findViewById(R.id.encrypteddata);
		button = (ImageButton) findViewById(R.id.readdata);
		
		//Validation
		testMag = (TextView) findViewById(R.id.validate);
		
		
		textencry = (TextView) findViewById(R.id.encrypt);
	
		otptextview = (TextView) findViewById(R.id.otppass);
		
		//EditText for OTP
		otppassword = (EditText) findViewById(R.id.otp);
		
		mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
		
		 Intent intent = getIntent();
        String billno= intent.getStringExtra("billno");
        String amount= intent.getStringExtra("amount");
        String pin= intent.getStringExtra("pin");
         
   message=  billno+"-"+amount+"-"+pin;
        Toast.makeText(getApplicationContext(),"message"+message,Toast.LENGTH_LONG).show();
			
		 try
		 {
			 if (mNfcAdapter == null) 
		        {
		            // Stop here, we definitely need NFC
		            Toast.makeText(this, "This device doesn't support NFC.", Toast.LENGTH_LONG).show();
		            //finish();
		            //return;
		        }
		     
		        if (!mNfcAdapter.isEnabled()) 
		        {
		        	testMag.setText("NFC is disabled.");
		        }
		        else 
		        {
		        	testMag.setText("Detected NFC TAG Content :\n");
		        }
		         
		        handleIntent(getIntent());
		        
		        button.setOnClickListener(new OnClickListener()
		        {
					
					@Override
					public void onClick(View v)
					{
						
						String tag_data = editText.getText().toString();
						
					
		            	
		            
		            	
		            	
		            	
					}
				});
		        
		 }catch(Exception exception)
		 {
			
			 Toast.makeText(this, exception.toString(), Toast.LENGTH_LONG).show();
			 testMag.setText(exception.toString());
		 }
	}

	public void showCustomAlert() {

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
	
	@Override
    protected void onResume() {
        super.onResume();
         
       /*//**
         It's important, that the activity is in the foreground (resumed). Otherwise
          an IllegalStateException is thrown. 
         //*
*/        setupForegroundDispatch(this, mNfcAdapter);
    }
     
    @Override
    protected void onPause() 
    {
        /**
         * Call this before onPause, otherwise an IllegalArgumentException is thrown as well.
         */
        stopForegroundDispatch(this, mNfcAdapter);
         
        super.onPause();
    }
     
    @Override
    protected void onNewIntent(Intent intent) { 
        /**
         * This method gets called, when a new Intent gets associated with the current activity instance.
         * Instead of creating a new activity, onNewIntent will be called. For more information have a look
         * at the documentation.
         * 
         * In our case this method gets called, when the user attaches a Tag to the device.
         */
        handleIntent(intent);
    }
    
    @SuppressLint("NewApi")
	private void handleIntent(Intent intent) 
    {
        String action = intent.getAction();
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action))
        {
             
            String type = intent.getType();
            if (MIME_TEXT_PLAIN.equals(type)) 
            {
     
                Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
               new NdefReaderTask().execute(tag);
                 
            } else 
            {
                Log.d(TAG, "Wrong mime type: " + type);
            }
        } 
        else if (NfcAdapter.ACTION_TECH_DISCOVERED.equals(action))
        {
             
            // In case we would still use the Tech Discovered Intent
            Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
            String[] techList = tag.getTechList();
            String searchedTech = Ndef.class.getName();
             
            for (String tech : techList) 
            {
                if (searchedTech.equals(tech))
                {
                   new NdefReaderTask().execute(tag);
                    break;
                }
            }
        }
        
        System.out.println(".....");
        
    }
    
   
    private class NdefReaderTask extends AsyncTask<Tag, Void, String> 
    {
     
        @SuppressLint("NewApi")
		@Override
        protected String doInBackground(Tag... params)
        {
            Tag tag = params[0];
             
            Ndef ndef = Ndef.get(tag);
            if (ndef == null) {
                // NDEF is not supported by this Tag. 
                return null;
            }
     
            NdefMessage ndefMessage = ndef.getCachedNdefMessage();
     
            NdefRecord[] records = ndefMessage.getRecords();
            for (NdefRecord ndefRecord : records) 
            {
                if (ndefRecord.getTnf() == NdefRecord.TNF_WELL_KNOWN && Arrays.equals(ndefRecord.getType(), NdefRecord.RTD_TEXT)) {
                    try 
                    {
                    	tag_data = readText(ndefRecord);
                    	
                        return readText(ndefRecord);
                    } catch (UnsupportedEncodingException e)
                    {
                        Log.e(TAG, "Unsupported Encoding", e);
                    }
                }
            }
     
            return tag_data;
        }
         
        @SuppressLint("NewApi")
		private String readText(NdefRecord record) throws UnsupportedEncodingException 
        {
            /*
             * See NFC forum specification for "Text Record Type Definition" at 3.2.1 
             * 
             * http://www.nfc-forum.org/specs/
             * 
             * bit_7 defines encoding
             * bit_6 reserved for future use, must be 0
             * bit_5..0 length of IANA language code
             */
     
            byte[] payload = record.getPayload();
     
            // Get the Text Encoding
            String textEncoding = ((payload[0] & 128) == 0) ? "UTF-8" : "UTF-16";
     
            // Get the Language Code
            int languageCodeLength = payload[0] & 0063;
             
            // String languageCode = new String(payload, 1, languageCodeLength, "US-ASCII");
            // e.g. "en"
             
            // Get the Text
            return new String(payload, languageCodeLength + 1, payload.length - languageCodeLength - 1, textEncoding);
        }
         
        @SuppressWarnings("unused")
		@SuppressLint("NewApi")
		@Override
        protected void onPostExecute(String result) 
        {
            if (result != null)
            {
            	//editText.setText(result.trim());
            	textencry.setVisibility(1);
            	editText.setVisibility(1);
            	baseHelper = new DataBaseHelper(getApplicationContext());
            	
            	try 
            	{
            		
            		
                    // Toast.makeText(getApplicationContext(),"patient id is recieved in ReadFragment "+patientid,Toast.LENGTH_LONG).show();
            		
            		System.out.println("its came inside the post exicute method>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            		
            		//Toast.makeText(getApplicationContext(), "XOR Process Start", 5000).show();
					
            		//String decrypteddata = AES_Encryption.decrypt(result, "1111111111aaaaaa");
            		String s1="Bangalore is a Garden City in India";
            		byte out1[]=XOR_Operation.xorWithData(s1.getBytes(), result.getBytes());
            		
            		String s4=new String(out1);
            		System.out.println("Output  is<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<:"+s4.trim());
            		  Toast.makeText(getApplicationContext(),"xor data is "+s4.trim(),Toast.LENGTH_LONG).show();
            		//Toast.makeText(getApplicationContext(), "XOR Process End"+s4, 5000).show();
            		
            		 editText.setText(s4);
            		 String s = editText.getText().toString().trim();
            		 
            		 String SM=message+"~"+s;
            		 Intent intent=new Intent(getApplicationContext(),Viewreadeddata.class);
            		 intent.putExtra("sm", SM);
            		 intent.putExtra("sid", sid);
            		 startActivity(intent);
            		
            		 

            		 
            		 
            		 
            		 
            		 
            		 
            		 
            		 
            		 
            		 
            		 
            		/*if(!s.equals("")||s != null || !s.trim().isEmpty()) 
            		{
            			
            			Intent intentdata=new Intent(getApplicationContext(),Viewreadeddata.class);
            			intentdata.putExtra("readdata", s);
            			startActivity(intentdata);
            			
            			
            			
            			
            			
            		}
            		
            		else
            		{
            			
            			
            			
            			Intent intentdata=new Intent(getApplicationContext(),ReadFragment.class);
            			
            			startActivity(intentdata);
            			
            			
            			
            			
            			
            			
            			
            			
            		}
            		 
            		 
            		 
            		 */
            		 
            	
					
				}
            	catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            	
            }
        }
    }
    
    /**
     * @param activity The corresponding {@link Activity} requesting the foreground dispatch.
     * @param adapter The {@link NfcAdapter} used for the foreground dispatch.
     */
    @SuppressLint("NewApi")
	public static void setupForegroundDispatch(final Activity activity, NfcAdapter adapter) 
    {
        final Intent intent = new Intent(activity.getApplicationContext(), activity.getClass());
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
 
        final PendingIntent pendingIntent = PendingIntent.getActivity(activity.getApplicationContext(), 0, intent, 0);
 
        IntentFilter[] filters = new IntentFilter[1];
        String[][] techList = new String[][]{};
 
        // Notice that this is the same filter as in our manifest.
        filters[0] = new IntentFilter();
        filters[0].addAction(NfcAdapter.ACTION_NDEF_DISCOVERED);
        filters[0].addCategory(Intent.CATEGORY_DEFAULT);
        try
        {
            filters[0].addDataType(MIME_TEXT_PLAIN);
        }
        catch (MalformedMimeTypeException e)
        {
            throw new RuntimeException("Check your mime type.");
        }
         
        adapter.enableForegroundDispatch(activity, pendingIntent, filters, techList);
    }
 
    /**
     * @param activity The corresponding {@link BaseActivity} requesting to stop the foreground dispatch.
     * @param adapter The {@link NfcAdapter} used for the foreground dispatch.
     */
    @SuppressLint("NewApi")
	public static void stopForegroundDispatch(final Activity activity, NfcAdapter adapter) 
    {
        adapter.disableForegroundDispatch(activity);
    }
    

}
