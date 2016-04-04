package com.rsp.rishi;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GiveName extends Activity {
	/*
	 * @Override protected void onPause() { // TODO Auto-generated method stub
	 * super.onPause(); finish(); }
	 */

	Intent intent;
	Button submit;
	static EditText fname, lname, des;
	TextView err;
	// static String fpuzzle, lpuzzle, description;
	boolean play_chk, fplay_chk, lplay_chk;
	static boolean give_name;
	int flen, llen, deslen, i;
	Intent dialog = new Intent("com.rsp.rishi.DIALOG");
	private AdView mAdView;

	void validate() {
		play_chk = true;
		fplay_chk = false;
		lplay_chk = false;
		Info.fpuzzle = fname.getText().toString().toLowerCase();
		Info.lpuzzle = lname.getText().toString().toLowerCase();
		Info.description = des.getText().toString().toLowerCase();
		flen = Info.fpuzzle.length();
		llen = Info.lpuzzle.length();
		deslen = Info.description.length();

		if ((flen == 0) || (llen == 0) || (deslen == 0)) {

			if ((flen == 0) && (llen == 0)) {
				Info.err_no = 1;
				startActivity(dialog);
				// err.setText("Please enter a Name!");
			} else if (flen == 0) {
				Info.err_no = 2;
				startActivity(dialog);
				// err.setText("Please enter a First Name!");
			} else if (llen == 0) {
				Info.err_no = 3;
				startActivity(dialog);
				// err.setText("Please enter a Last Name!");
			} else if (deslen == 0) {
				Info.err_no = 4;
				startActivity(dialog);
				// err.setText("Please enter a Description!");
			}

			play_chk = false;
		} else if ((flen > 9) || (llen > 9)) {

			if ((flen > 9) && (llen > 9)) {
				Info.err_no = 5;
				startActivity(dialog);
				// err.setText("Please enter a First and Last Name within 9 Letters!");

			} else if (flen > 9) {
				Info.err_no = 6;
				startActivity(dialog);
				// err.setText("Please enter a First Name within 9 Letters!");

			} else if (llen > 9) {
				Info.err_no = 7;
				startActivity(dialog);
				// err.setText("Please enter a Last Name within 9 Letters!");

			}

			play_chk = false;

		} else if ((flen <= 9) && (llen <= 9)) {

			for (i = 0; i < flen; i++) {

				if (Info.fpuzzle.charAt(i) == ' ') {
					fplay_chk = false;
					Info.err_no = 8;
					startActivity(dialog);
					// err.setText("First Name contains a space.Please enter again!");

					break;
				} else if ((Info.fpuzzle.charAt(i) >= 'a')
						&& (Info.fpuzzle.charAt(i) <= 'z')) {
					fplay_chk = true;
				} else if ((Info.fpuzzle.charAt(i) >= '0')
						&& (Info.fpuzzle.charAt(i) <= '9')) {
					fplay_chk = false;
					Info.err_no = 9;
					startActivity(dialog);
					// err.setText("First Name contains a number.Please enter again!");

					break;
				} else {
					fplay_chk = false;
					Info.err_no = 10;
					startActivity(dialog);
					// err.setText("First Name contains special Characters.Please enter again!");
					break;
				}
			}
			if (fplay_chk == true) {
				for (i = 0; i < llen; i++) {
					// err.append("" + i);
					if (Info.lpuzzle.charAt(i) == ' ') {
						lplay_chk = false;
						Info.err_no = 11;
						startActivity(dialog);
						// err.setText("Last Name contains a space.Please enter again!");

						break;
					} else if ((Info.lpuzzle.charAt(i) >= 'a')
							&& (Info.lpuzzle.charAt(i) <= 'z')) {
						lplay_chk = true;

					} else if ((Info.lpuzzle.charAt(i) >= '0')
							&& (Info.lpuzzle.charAt(i) <= '9')) {
						lplay_chk = false;
						Info.err_no = 12;
						startActivity(dialog);
						// err.setText("Last Name contains a number.Please enter again!");

						break;
					} else {
						lplay_chk = false;
						Info.err_no = 13;
						startActivity(dialog);
						// err.setText("Last Name contains special Characters.Please enter again!");
						break;
					}
				}
			}

			if ((fplay_chk == true) && (lplay_chk == true)) {
				play_chk = true;
				give_name = true;
				// err.setText("Correct");
				try {
					startActivity(intent);
					finish();
					mAdView.destroy();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.givename);

		mAdView = (AdView) findViewById(R.id.adView);
		// mAdView.setAdListener(new ToastAdListener(this));
		mAdView.loadAd(new AdRequest.Builder().build());

		Info.name_dialog = true;
		Info.word_dialog = false;

		intent = new Intent("com.rsp.rishi.NAMEPLAY");
		submit = (Button) findViewById(R.id.bt_challlenge);
		fname = (EditText) findViewById(R.id.txt_fname);
		lname = (EditText) findViewById(R.id.txt_lname);
		des = (EditText) findViewById(R.id.txt_name_des);
		err = (TextView) findViewById(R.id.txt_name_err);
		give_name = false;

		submit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				validate();

			}
		});
	}
}
