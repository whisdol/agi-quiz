//Author: Bastian Sold
package de.fhdw.gruppe2.quizapp.android.activity_questionno3;

import java.io.InputStream;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.Toast;

class LoadImage extends AsyncTask<String, String, Bitmap> {
	private ActivityData mData;
	private Bitmap bitmap;
	private ImageView mView;
	public LoadImage(ActivityData pData,ImageView pView)
	{
		mData = pData;
		mView = pView;
	}
    @Override
        protected void onPreExecute() {
            super.onPreExecute();
    }
       protected Bitmap doInBackground(String... args) {
         try {
               bitmap = BitmapFactory.decodeStream((InputStream)new URL(args[0]).getContent());
        } catch (Exception e) {
              e.printStackTrace();
        }
         return bitmap;
       }
       protected void onPostExecute(Bitmap image) {
         if(image != null){
        	 mView.setImageBitmap(image);
         }else{
           Toast.makeText(mData.getActivity(), "Image Does Not exist or Network Error", Toast.LENGTH_SHORT).show();
         }
       }
   }
