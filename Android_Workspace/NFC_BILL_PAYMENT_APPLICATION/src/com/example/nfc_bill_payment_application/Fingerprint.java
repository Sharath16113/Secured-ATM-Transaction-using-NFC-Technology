package com.example.nfc_bill_payment_application;



import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.HttpClient.Global;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class Fingerprint extends Activity {

	private ImageView img;
	private String m_curentDateandTime;
	private String m_imagepath;
	private Bitmap resized;
	private byte[] imageByte;
	private String imageString;
	private String imageUri;
	private Object s;
	private String bill;
	private String am;
	private String pin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fingerprint);
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = 
		    new StrictMode.ThreadPolicy.Builder().permitAll().build();      
		        StrictMode.setThreadPolicy(policy);
		}
	    img = (ImageView)findViewById(R.id.iv_fp);
		Button b=  (Button)findViewById(R.id.btnvalidate);
		Intent i= getIntent();
		bill=i.getStringExtra("billno");
		am=i.getStringExtra("amount");
		pin=i.getStringExtra("pin");
		b.setOnClickListener(new OnClickListener() {
			
			

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setType("image/*");
				imageUri = getImageUri();
				intent.setAction(Intent.ACTION_GET_CONTENT);//
				startActivityForResult(Intent.createChooser(intent, "Select Picture"), 5);
				
			}
		});
	}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	// TODO Auto-generated method stub
	super.onActivityResult(requestCode, resultCode, data);
	
	
	 if (requestCode == 5  )
	    {
	        if (resultCode == Activity.RESULT_OK)
	        {
	            if (data != null)
	            {
	                try
	                {

	                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(Fingerprint.this.getContentResolver(), data.getData());
	                  
	                 
	                    img.setImageBitmap(bitmap);
	                
	                   
	                  //Converting to Byte[]
						ByteArrayOutputStream stream = new ByteArrayOutputStream();
					
			            bitmap.compress(CompressFormat.JPEG, 70, stream);
			            imageByte =  stream.toByteArray();
			            imageString = Base64.encodeToString(imageByte, Base64.DEFAULT);
			            
			            HttpClient httpClient=new DefaultHttpClient();
			            HttpPost httpPost=new HttpPost(Global.URL+"CheckFingerPrint.jsp");
			            //Log.i(TAG, "PostData: " + httpPost);

			            List<NameValuePair> list=new ArrayList<NameValuePair>();
			            list.add(new BasicNameValuePair("imageByte", imageString));
			            list.add(new BasicNameValuePair("fileName", imageUri));
			            list.add(new BasicNameValuePair("pin", pin));
			            httpPost.setEntity(new UrlEncodedFormEntity(list));
			            HttpResponse httpResponse=  httpClient.execute(httpPost);

			            HttpEntity httpEntity=httpResponse.getEntity();
			            s= readResponse(httpResponse);
			            
			            
			            Toast.makeText(this, "uploaded to server:  " , Toast.LENGTH_LONG).show();
			            Toast.makeText(this, "File Name: " + imageUri, Toast.LENGTH_LONG).show();
			            Toast.makeText(getApplicationContext(), " finger print"+s, Toast.LENGTH_LONG).show();
			           String a=s.toString();
			          String[] h= a.split(">");
			           String g=h[1];
			            if(g.equals("true")){
			            Intent i= new Intent(Fingerprint.this,ReadFragment.class);
			            i.putExtra("billno", bill);
			            i.putExtra("amount", am);
			            i.putExtra("pin", pin);
			            startActivity(i);
			            }
			            else
			            {
			            	Toast.makeText(getApplicationContext(), "wrong finger print", Toast.LENGTH_LONG).show();
				            
			            }
			            Toast.makeText(getApplicationContext(), "wait for few seconds..........", Toast.LENGTH_LONG).show();
			            
	                    
	                } catch (IOException e)
	                {
	                    e.printStackTrace();
	                }

	            }
	        } else if (resultCode == Activity.RESULT_CANCELED)
	        {
	            Toast.makeText(Fingerprint.this, "Cancelled", Toast.LENGTH_SHORT).show();
	        }
	    }

}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private Object readResponse(HttpResponse res) {
		 InputStream is=null;
	        String return_text="";
	        try {
	            is=res.getEntity().getContent();
	            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(is));
	            String line="";
	            StringBuffer sb=new StringBuffer();
	            while ((line=bufferedReader.readLine())!=null)
	            {
	                sb.append(line);
	            }
	            return_text=sb.toString();
	        } catch (Exception e)
	        {

	        }
	        return return_text;

}

	protected String getImageUri() {
		Uri m_imgUri = null;
		File m_file;
		String res = "";
		String filename = "";
		try{
			SimpleDateFormat m_sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
			m_curentDateandTime = m_sdf.format(new Date());
			m_imagepath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + m_curentDateandTime + ".jpg";
			m_file = new File(m_imagepath);
			m_imgUri = Uri.fromFile(m_file);
			
			res = m_imgUri.getPath();
			//filename = String.valueOf(m_imgUri);
			String ss[] = res.split("/");
			filename =  ss[ss.length - 1];
			/*for(int i = 0; i<=ss.length-1; i++)
			{
				filename = ss[];
			}*/
			//filename = String.valueOf(res.split("/"));
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return filename;
	}
	}

	

