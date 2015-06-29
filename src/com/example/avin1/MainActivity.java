package com.example.avin1;

import java.io.InputStream;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {
	ImageView myImg;
    Bitmap myBmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myImg=(ImageView)findViewById(R.id.imageView1);
    }

   public void pickimage(View v){
	   switch(v.getId()){
	   case R.id.button1:
		   Intent goCamera=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		   startActivityForResult(goCamera,10);
		   break;
	   
		   case R.id.button2:
			   Intent goGallery=new Intent(Intent.ACTION_PICK);
			   goGallery.setType("image/*");
			   startActivityForResult(goGallery,20);
			   break;
	   
	   }
   }
   @Override
   protected void onActivityResult(int requestCode,int resultCode,Intent bag){
	   //TODO Auto-generated method stub
	   super.onActivityResult(requestCode, resultCode, bag);
	   if(resultCode==RESULT_OK){
		   try{
			   if(requestCode==10){
				   myBmp=(Bitmap)bag.getExtras().get("data");
				   myImg.setImageBitmap(myBmp);
			   }else if(requestCode==20){
				   Uri selectedimg=bag.getData();
				   InputStream myInputimage=getContentResolver()
						   .openInputStream(selectedimg);
				   myBmp=BitmapFactory.decodeStream(myInputimage);
				   myImg.setImageBitmap(myBmp);
			   } 
			   }catch(Exception e){
				   //TODO:handle exception
			   }
			   
				   
				   
				   
				   
				   
			   
		   }
	  
   }
}
