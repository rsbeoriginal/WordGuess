package com.rsp.rishi;

import java.util.Random;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import android.app.ListActivity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Play extends ListActivity {
	private InterstitialAd interstitial;
	String[] menu = { "Guess a Word", "Guess a Name" };
	String[] intent = { "WordGuess", "NamePlay" };
	static String[] word = { "Sprint",
					  "Original", 
					  "Trick", 
					  "Villain", 
					  "Adventure",
					  "Minister",
					  "Brave",
					  "Martyr",
					  "Camera",
					  "Camcorder",
					  "Hospital",
					  "Generator",
					  "Manager",
					  "Dance",					  
					  "Orator",
					  "Planet",
					  "Plant",
					  "Phobia",
					  "Zoology",
					  "Botany",
					  "Poverty",
					  "Powder",
					  "Servant",
					  "Slave",
					  "Sleep",
					  "Slide",
					  "Slip",
					  "Mob",
					  "Sky",
					  "Surplus",
					  "Surrender",
					  "Terror",
					  "Rules",
					  "Rugby",
					  "Tactic",
					  "Transport"};
	static String[] des = {
			"Running very fast",
			"the earliest form of something, from which copies may be made",
			"to deceive or outwit someone",
			"(in a film, novel, or play) a character whose evil actions or motives are important to the plot",
			"an unusual and exciting or daring experience",
			"person who is in charge of a particular government department",
			"willing to do things which are dangerous, and does not show fear in difficult or dangerous situations",
			"someone who is killed or made to suffer greatly because of their religious or political beliefs, and is admired and respected by people who share those beliefs",
			"equipment that is used for taking photographs",
			"portable video camera which records both pictures and sound",
			"place where people who are ill are looked after by nurses and doctors",
			"a machine which produces electricity",
			"a person who is responsible for running part of or the whole of a business organization",
			"moving body and feet in a way which follows a rhythm, usually in time to music",			
			"someone who is skilled at making formal speeches, especially ones which affect people's feelings and beliefs",
			"large, round object in space that moves around a star",
			"living thing that grows in the earth and has a stem, leaves, and roots",
			"very strong irrational fear or hatred of something",
			"scientific study of animals",
			"scientific study of plants",
			"state of being extremely poor",
			"consists of many tiny particles of a solid substance",
			"someone who is employed to work at another person's home",
			"someone who is the property of another person and has to work for that person",
			"natural state of rest in which your eyes are closed, your body is inactive, and your mind does not think",
			"moveing smoothly over or against something",
			"accidentally slide and lose your balance",
			"large, disorganized, and often violent crowd of people",
			"space around the earth which you can see when you stand outside and look upwards",
			"used to describe something that is extra or that is more than is needed",
			"to give up during fight",
			"very great fear",
			"instructions that tell you what you are allowed to do and what you are not allowed to do",
			"game played by two teams using an oval ball",
			"method that you choose to use in order to achieve what you want in a particular situation",
			" system for taking people or goods from one place to another"};
	static String puzzle, description;
	Button bt_play;

	//static boolean play = false;
	Random rad = new Random();
	int rand;

	// Intent wordguess=new Intent("com.rsp.rishi.WORDGUESS");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN	, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		interstitial = new InterstitialAd(this);
		interstitial.setAdUnitId(getResources().getString(R.string.ad_interstitial));
		AdRequest adRequest = new AdRequest.Builder().build();
		interstitial.loadAd(adRequest);
		
		setListAdapter(new ArrayAdapter<String>(Play.this,
				android.R.layout.simple_list_item_1, menu));
		// setContentView(R.layout.play);
		/*bt_play = (Button) findViewById(R.id.bt_play);
		bt_play.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				rand = rad.nextInt(5);
				play = true;
				puzzle = word[rand].toLowerCase();
				description = des[rand];
				Intent start = new Intent("com.rsp.rishi.WORDGUESS");
				startActivity(start);
				try {
					Class wordguess = Class.forName("com.rsp.rishi.WordGuess");
					Intent start_game = new Intent(Play.this, wordguess);
					startActivity(start_game);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});*/
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Info.play = true;
		Info.challenge=false;
		Info.career=false;
		switch (position) {
		case 0:
			rand = rad.nextInt(36);
			
			puzzle = Info.word[rand].toLowerCase();
			description = Info.des[rand];
			break;
		}
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
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
