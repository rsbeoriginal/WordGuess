package com.rsp.rishi;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Challenge extends Activity {

	Button submit;
	EditText txt_word, txt_des;
	TextView txt_err;
	//static String puzzle, description;
	boolean play_chk;
	static boolean challenge = false;
	int len, len_des, loop;
	Intent dialog=new Intent("com.rsp.rishi.DIALOG");
	private AdView mAdView;

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN	, WindowManager.LayoutParams.FLAG_FULLSCREEN);		
		
		setContentView(R.layout.guess);
		mAdView = (AdView) findViewById(R.id.adView);
		//mAdView.setAdListener(new ToastAdListener(this));
		mAdView.loadAd(new AdRequest.Builder().build());
		
		Info.name_dialog = false;
		Info.word_dialog = true;

		submit = (Button) findViewById(R.id.bt_submit);
		txt_word = (EditText) findViewById(R.id.txt_word);
		txt_des = (EditText) findViewById(R.id.des);
		txt_err = (TextView) findViewById(R.id.txt_err);

		submit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				play_chk = true;
				len = txt_word.length();

				if (len == 0) {
					//txt_err.setText("Please enter a word with Max Word Length of 9");
					play_chk = false;
					Info.err_no=1;
					startActivity(dialog);	
				} else if (len <= 9) {
					Info.puzzle = txt_word.getText().toString().toLowerCase();
					len_des = txt_des.length();
					if (len_des == 0) {
						play_chk = false;
						//txt_err.setText("Your description of the word is empty");
						Info.err_no=2;
						startActivity(dialog);	
					} else {
						for (loop = 0; loop < len; loop++)

						{
							if (Info.puzzle.charAt(loop) == ' ') {
								play_chk = false;
								//txt_err.setText("Your word contains a space.Please enter another word!");
								Info.err_no=3;
								startActivity(dialog);	
								break;
							} else if ((Info.puzzle.charAt(loop) >= 'a')
									&& (Info.puzzle.charAt(loop) <= 'z')) {
								play_chk = true;

							} else if ((Info.puzzle.charAt(loop) >= '0')
									&& (Info.puzzle.charAt(loop) <= '9')) {
								play_chk = false;
								//txt_err.setText("Your word contains a contains a number.Please enter another word!");
								Info.err_no=4;
								startActivity(dialog);	
								break;
								} else {
								play_chk = false;
								//txt_err.setText("Your word contains a contains a special character.Please enter another word!");
								Info.err_no=5;
								startActivity(dialog);
								break;
							}
						}
					}
				} else if (len > 9) {
					//txt_err.setText("Word Length Exceeds 9");
					play_chk = false;
					Info.err_no=6;
					startActivity(dialog);	
				}

				if (play_chk == true) {
					challenge = true;
					Info.description = txt_des.getText().toString();
					Intent wordguess = new Intent("com.rsp.rishi.WORDGUESS");
					startActivity(wordguess);
					finish();
					mAdView.destroy();
				}
			}

		});

	}

}
