package com.rsp.rishi;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameOver extends Activity implements OnCompletionListener {

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

	Button play_again;
	static TextView txt_result;
	ImageView img_result;
	MediaPlayer win, lose, lose1, lose2, lose3, lose4;
	Random rad = new Random();
	int r;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN	, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.gameover);
		r = rad.nextInt(5);

		play_again = (Button) findViewById(R.id.bt_play_again);
		txt_result = (TextView) findViewById(R.id.txt_result);
		img_result = (ImageView) findViewById(R.id.img_result);
		win = MediaPlayer.create(GameOver.this, R.raw.win);
		lose = MediaPlayer.create(GameOver.this, R.raw.lose);
		lose1 = MediaPlayer.create(GameOver.this, R.raw.lose1);
		lose2 = MediaPlayer.create(GameOver.this, R.raw.lose2);
		lose3 = MediaPlayer.create(GameOver.this, R.raw.lose3);
		lose4 = MediaPlayer.create(GameOver.this, R.raw.lose4);
		win.setOnCompletionListener(this);
		lose.setOnCompletionListener(this);
		lose1.setOnCompletionListener(this);
		lose2.setOnCompletionListener(this);
		lose3.setOnCompletionListener(this);
		lose4.setOnCompletionListener(this);
		switch (Menu.gateway) {
		case 1:
			if (WordGuess.win == true) {win.start();
			

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
			break;
		case 2:
			if (NamePlay.win == true) {
				win.start();
				txt_result
						.setText("Great Guessing! You Won! \nYour Guessing Word was "
								+ NamePlay.fpuzzle.toUpperCase()
								+ " "
								+ NamePlay.lpuzzle.toUpperCase());
				img_result.setImageResource(R.drawable.win);
			} else // if (NamePlay.win == false){
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
						+ NamePlay.fpuzzle.toUpperCase() + " "
						+ NamePlay.lpuzzle.toUpperCase());
				img_result.setImageResource(R.drawable.lose);
			}
			break;
		}
		play_again.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					Class start = Class.forName("com.rsp.rishi.Menu");
					Intent start_game = new Intent(GameOver.this, start);
					startActivity(start_game);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

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
}
