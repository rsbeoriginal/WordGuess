package com.rsp.rishi;

import java.io.IOException;
import java.io.InputStream;

import android.app.ListActivity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

public class Menu extends ListActivity{

	//String[] menu={"Career","Play","Challenge","Help","About Us","Exit"};
	//String[] action={"Car_menu","Play","ChallengeMenu","Help","AboutUs","Exit"};
	//for version 1.0
	String[] menu={"Play","Challenge","Help","About Us","Exit"};
	String[] action={"Play","ChallengeMenu","Help","AboutUs","Exit"};
	static int gateway;
	//MediaPlayer menu_click;
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);	
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN	, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// Create a progress bar to display while the list loads
        ProgressBar progressBar = new ProgressBar(this);
        progressBar.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        progressBar.setIndeterminate(true);
        getListView().setEmptyView(progressBar);

        // Must add the progress bar to the root of the layout
        ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
        root.addView(progressBar);
		
		setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_list_item_1, menu));
		//menu_click = MediaPlayer.create(Menu.this, R.raw.menu_click);
	/*	menu_click.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

					@Override
					public void onCompletion(MediaPlayer mp) {
						// TODO Auto-generated method stub
						menu_click.release();
					}
				});*/
	}
	
	
	/*@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}*/


	@Override
	public void setWallpaper(Bitmap bitmap) throws IOException {
		// TODO Auto-generated method stub
		InputStream  is=getResources().openRawResource(R.drawable.back);
		bitmap=BitmapFactory.decodeStream(is);
		super.setWallpaper(bitmap);
	}


	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		
		super.onListItemClick(l, v, position, id);
		
		//menu_click.start();
		if (position==(menu.length-1)){
			finish();
		}
		try
		{
			String act=action[position].toUpperCase();
			Intent ourIntent=new Intent("com.rsp.rishi."+act);
			startActivity(ourIntent);
		}catch (ActivityNotFoundException e){
			e.printStackTrace();
		}
	}
	
	

	

}
