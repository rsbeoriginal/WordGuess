package com.rsp.rishi;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import android.app.ListActivity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ChallengeMenu extends ListActivity {

	String[] menu = { "Give a Word", "Give a Name" };
	String[] intent = { "Challenge", "GiveName" };
	// static boolean challenge = false;
	MediaPlayer menu_click;
	private InterstitialAd interstitial;

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN	, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setListAdapter(new ArrayAdapter<String>(ChallengeMenu.this,
				android.R.layout.simple_list_item_1, menu));
		menu_click = MediaPlayer.create(ChallengeMenu.this, R.raw.menu_click);
		menu_click
				.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

					@Override
					public void onCompletion(MediaPlayer mp) {
						// TODO Auto-generated method stub
						menu_click.release();
					}
				});
		
		interstitial = new InterstitialAd(this);
		interstitial.setAdUnitId(getResources().getString(R.string.ad_interstitial));
		AdRequest adRequest = new AdRequest.Builder().build();
		interstitial.loadAd(adRequest);
		

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		menu_click.start();
		Info.challenge = true;
		Info.play = false;
		Info.career=false;
		try {
			String act = intent[position].toUpperCase();
			Intent ourIntent = new Intent("com.rsp.rishi." + act);
			startActivity(ourIntent);
			displayInterstitial();
		} catch (ActivityNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void displayInterstitial() {
		if (interstitial.isLoaded()) {
			interstitial.show();
		} 
	}

}
