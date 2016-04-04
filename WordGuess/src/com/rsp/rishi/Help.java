package com.rsp.rishi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Help extends Activity implements OnClickListener{

	Button guessword,guessname,giveword,givename,menu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);
		guessword=(Button) findViewById(R.id.hbt_guessword);
		guessname=(Button) findViewById(R.id.hbt_guessname);
		giveword=(Button) findViewById(R.id.hbt_giveword);
		givename=(Button) findViewById(R.id.hbt_givename);
		menu=(Button) findViewById(R.id.hbt_menu);
		guessword.setOnClickListener(this);
		guessname.setOnClickListener(this);
		giveword.setOnClickListener(this);
		givename.setOnClickListener(this);
		menu.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i;
		switch(v.getId()){
		case R.id.hbt_guessword:
			Info.play = true;
			i= new Intent("com.rsp.rishi.WORDGUESS");
			startActivity(i);
			break;
		case R.id.hbt_guessname:
			Info.play = true;
			i= new Intent("com.rsp.rishi.NAMEPLAY");
			startActivity(i);
			break;
		case R.id.hbt_giveword:
			Info.challenge = true;
			i= new Intent("com.rsp.rishi.CHALLENGE");
			startActivity(i);
			break;
		case R.id.hbt_givename:
			Info.challenge = true;
			i= new Intent("com.rsp.rishi.GIVENAME");
			startActivity(i);
			break;
		case R.id.hbt_menu:
			finish();
			//i= new Intent("com.rsp.rishi.MENU");
			//startActivity(i);
			break;
		}
		
	}

}
