package com.rsp.rishi;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Car_gameover extends Activity implements OnCompletionListener, OnClickListener {

	Button play_again;
	static TextView txt_result, txt_car_name;
	ImageView img_result;
	MediaPlayer win, lose, lose1, lose2, lose3, lose4;
	Random rad = new Random();
	int r;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.car_gameover);
		r = rad.nextInt(5);

		play_again = (Button) findViewById(R.id.bt_play_again);
		txt_car_name = (TextView) findViewById(R.id.txt_car_name);
		txt_result = (TextView) findViewById(R.id.txt_result);
		img_result = (ImageView) findViewById(R.id.img_result);
		win = MediaPlayer.create(Car_gameover.this, R.raw.win);
		lose = MediaPlayer.create(Car_gameover.this, R.raw.lose);
		lose1 = MediaPlayer.create(Car_gameover.this, R.raw.lose1);
		lose2 = MediaPlayer.create(Car_gameover.this, R.raw.lose2);
		lose3 = MediaPlayer.create(Car_gameover.this, R.raw.lose3);
		lose4 = MediaPlayer.create(Car_gameover.this, R.raw.lose4);
		win.setOnCompletionListener(this);
		lose.setOnCompletionListener(this);
		lose1.setOnCompletionListener(this);
		lose2.setOnCompletionListener(this);
		lose3.setOnCompletionListener(this);
		lose4.setOnCompletionListener(this);
		
		play_again.setOnClickListener(this);

		txt_car_name.setText("Hey " + Info.car_name + ",");

		if (WordGuess.win == true) {
			win.start();
			Info.level_1[Info.car_level]=1;
			txt_result
					.setText("Great Guessing! You Won! \nYour Guessing Word was "
							+ WordGuess.puzzle.toUpperCase());
			img_result.setImageResource(R.drawable.win);

		} else // if (WordGuess.win == false) {
		{
			switch (r) {
			case 0:
				lose.start();
				break;
			case 1:
				lose1.start();
				break;
			case 2:
				lose2.start();
				break;
			case 3:
				lose3.start();
				break;
			case 4:
				lose4.start();
				break;
			}
			txt_result.setText("GAME OVER \nYour Guessing Word was "
					+ WordGuess.puzzle.toUpperCase());

			img_result.setImageResource(R.drawable.lose);
		}
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		win.release();
		lose.release();
		lose1.release();
		lose2.release();
		lose3.release();
		lose4.release();
		finish();
	}

	@Override
	public void onCompletion(MediaPlayer mp) {
		// TODO Auto-generated method stub
		win.release();
		lose.release();
		lose1.release();
		lose2.release();
		lose3.release();
		lose4.release();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bt_play_again:
			//Intent menu=new Intent("com.rsp.rishi.CAR_MENU");
			Intent menu;
			switch(Info.car_scene){
			case 0:menu=new Intent("com.rsp.rishi.CAR_LEVEL");
				startActivity(menu);
				break;
			}
			
			break;
		}
	}

}
