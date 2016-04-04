package com.rsp.rishi;

import java.util.Random;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class WordGuess extends Activity implements OnClickListener,
		OnCompletionListener {
	/** Called when the activity is first created. */
	Intent ourIntent = new Intent("com.rsp.rishi.GAMEOVER");
	Intent car_gameover = new Intent("com.rsp.rishi.CAR_GAMEOVER");
	Boolean hint_press=false;
	
	MediaPlayer wrong, correct;

	public void displayInterstitial() {
		if (interstitial.isLoaded()) {
			interstitial.show();
		} else {
			Toast.makeText(this, "Ad not loaded", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void win_chk() {

		for (int i = 0; i < len; i++) {
			if (place_filled[i] == 1) {
				win = true;
			} else {
				win = false;
				break;
			}
		}
	}

	public void winner() {

		if (win == true) {
			game_over.setText("Great Guessing! You Won!");
			// GameOver.txt_result.setText("Great Guessing! You Won!");
			try {
				wrong.release();
				correct.release();
				//game over
				if (Info.career==true){
					startActivity(car_gameover);
				}else {
					startActivity(ourIntent);
				}
			} catch (ActivityNotFoundException e) {
				e.printStackTrace();
			}
		} else if (game_over.getText().toString() == "Game Over") {
			// GameOver.txt_result.setText("Great Guessing! You Won!");
			try {
				wrong.release();
				correct.release();
				if (Info.career==true){
					startActivity(car_gameover);
				}else {
					startActivity(ourIntent);
				}
			} catch (ActivityNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public void word_click(View view) {
		switch (view.getId()) {
		case R.id.word_hint:
			word_hint.setVisibility(View.INVISIBLE);
			//hint();
			try {
				displayInterstitial();
				hint_press=true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			break;

		case R.id.imageButton1:
			a.setVisibility(View.INVISIBLE);
			life_chk = true;
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 'a') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.aa);
						break;
					case 8:
						iv8.setImageResource(R.drawable.aa);
						break;
					case 7:
						iv7.setImageResource(R.drawable.aa);
						break;
					case 6:
						iv6.setImageResource(R.drawable.aa);
						break;
					case 5:
						iv5.setImageResource(R.drawable.aa);
						break;
					case 4:
						iv4.setImageResource(R.drawable.aa);
						break;
					case 3:
						iv3.setImageResource(R.drawable.aa);
						break;
					case 2:
						iv2.setImageResource(R.drawable.aa);
						break;
					case 1:
						iv1.setImageResource(R.drawable.aa);
						break;
					}

				}
			}
			life();
			win_chk();
			winner();

			break;
		case R.id.imageButton2:
			b.setVisibility(View.INVISIBLE);
			life_chk = true;
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 'b') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.ab);
						break;
					case 8:
						iv8.setImageResource(R.drawable.ab);
						break;
					case 7:
						iv7.setImageResource(R.drawable.ab);
						break;
					case 6:
						iv6.setImageResource(R.drawable.ab);
						break;
					case 5:
						iv5.setImageResource(R.drawable.ab);
						break;
					case 4:
						iv4.setImageResource(R.drawable.ab);
						break;
					case 3:
						iv3.setImageResource(R.drawable.ab);
						break;
					case 2:
						iv2.setImageResource(R.drawable.ab);
						break;
					case 1:
						iv1.setImageResource(R.drawable.ab);
						break;
					}

				}

			}
			life();
			win_chk();
			winner();
			break;
		case R.id.imageButton3:
			c.setVisibility(View.INVISIBLE);
			life_chk = true;
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 'c') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.ac);
						break;
					case 8:
						iv8.setImageResource(R.drawable.ac);
						break;
					case 7:
						iv7.setImageResource(R.drawable.ac);
						break;
					case 6:
						iv6.setImageResource(R.drawable.ac);
						break;
					case 5:
						iv5.setImageResource(R.drawable.ac);
						break;
					case 4:
						iv4.setImageResource(R.drawable.ac);
						break;
					case 3:
						iv3.setImageResource(R.drawable.ac);
						break;
					case 2:
						iv2.setImageResource(R.drawable.ac);
						break;
					case 1:
						iv1.setImageResource(R.drawable.ac);
						break;
					}

				}
			}
			life();
			win_chk();
			winner();
			break;
		case R.id.imageButton4:
			d.setVisibility(View.INVISIBLE);
			life_chk = true;
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 'd') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.ad);
						break;
					case 8:
						iv8.setImageResource(R.drawable.ad);
						break;
					case 7:
						iv7.setImageResource(R.drawable.ad);
						break;
					case 6:
						iv6.setImageResource(R.drawable.ad);
						break;
					case 5:
						iv5.setImageResource(R.drawable.ad);
						break;
					case 4:
						iv4.setImageResource(R.drawable.ad);
						break;
					case 3:
						iv3.setImageResource(R.drawable.ad);
						break;
					case 2:
						iv2.setImageResource(R.drawable.ad);
						break;
					case 1:
						iv1.setImageResource(R.drawable.ad);
						break;
					}

				}
			}
			life();
			win_chk();
			winner();
			break;
		case R.id.imageButton5:
			e.setVisibility(View.INVISIBLE);
			life_chk = true;
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 'e') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.ae);
						break;
					case 8:
						iv8.setImageResource(R.drawable.ae);
						break;
					case 7:
						iv7.setImageResource(R.drawable.ae);
						break;
					case 6:
						iv6.setImageResource(R.drawable.ae);
						break;
					case 5:
						iv5.setImageResource(R.drawable.ae);
						break;
					case 4:
						iv4.setImageResource(R.drawable.ae);
						break;
					case 3:
						iv3.setImageResource(R.drawable.ae);
						break;
					case 2:
						iv2.setImageResource(R.drawable.ae);
						break;
					case 1:
						iv1.setImageResource(R.drawable.ae);
						break;
					}

				}
			}
			life();
			win_chk();
			winner();
			break;
		case R.id.imageButton6:
			f.setVisibility(View.INVISIBLE);
			life_chk = true;
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 'f') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.af);
						break;
					case 8:
						iv8.setImageResource(R.drawable.af);
						break;
					case 7:
						iv7.setImageResource(R.drawable.af);
						break;
					case 6:
						iv6.setImageResource(R.drawable.af);
						break;
					case 5:
						iv5.setImageResource(R.drawable.af);
						break;
					case 4:
						iv4.setImageResource(R.drawable.af);
						break;
					case 3:
						iv3.setImageResource(R.drawable.af);
						break;
					case 2:
						iv2.setImageResource(R.drawable.af);
						break;
					case 1:
						iv1.setImageResource(R.drawable.af);
						break;
					}

				}
			}
			life();
			win_chk();
			winner();
			break;
		case R.id.imageButton7:
			g.setVisibility(View.INVISIBLE);
			life_chk = true;
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 'g') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.ag);
						break;
					case 8:
						iv8.setImageResource(R.drawable.ag);
						break;
					case 7:
						iv7.setImageResource(R.drawable.ag);
						break;
					case 6:
						iv6.setImageResource(R.drawable.ag);
						break;
					case 5:
						iv5.setImageResource(R.drawable.ag);
						break;
					case 4:
						iv4.setImageResource(R.drawable.ag);
						break;
					case 3:
						iv3.setImageResource(R.drawable.ag);
						break;
					case 2:
						iv2.setImageResource(R.drawable.ag);
						break;
					case 1:
						iv1.setImageResource(R.drawable.ag);
						break;
					}

				}
			}
			life();
			win_chk();
			winner();
			break;
		case R.id.imageButton8:
			h.setVisibility(View.INVISIBLE);
			life_chk = true;
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 'h') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.ah);
						break;
					case 8:
						iv8.setImageResource(R.drawable.ah);
						break;
					case 7:
						iv7.setImageResource(R.drawable.ah);
						break;
					case 6:
						iv6.setImageResource(R.drawable.ah);
						break;
					case 5:
						iv5.setImageResource(R.drawable.ah);
						break;
					case 4:
						iv4.setImageResource(R.drawable.ah);
						break;
					case 3:
						iv3.setImageResource(R.drawable.ah);
						break;
					case 2:
						iv2.setImageResource(R.drawable.ah);
						break;
					case 1:
						iv1.setImageResource(R.drawable.ah);
						break;
					}

				}
			}
			life();
			win_chk();
			winner();
			break;
		case R.id.imageButton9:
			i.setVisibility(View.INVISIBLE);
			life_chk = true;
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 'i') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.ai);
						break;
					case 8:
						iv8.setImageResource(R.drawable.ai);
						break;
					case 7:
						iv7.setImageResource(R.drawable.ai);
						break;
					case 6:
						iv6.setImageResource(R.drawable.ai);
						break;
					case 5:
						iv5.setImageResource(R.drawable.ai);
						break;
					case 4:
						iv4.setImageResource(R.drawable.ai);
						break;
					case 3:
						iv3.setImageResource(R.drawable.ai);
						break;
					case 2:
						iv2.setImageResource(R.drawable.ai);
						break;
					case 1:
						iv1.setImageResource(R.drawable.ai);
						break;
					}

				}
			}
			life();
			win_chk();
			winner();
			break;
		case R.id.imageButton10:
			j.setVisibility(View.INVISIBLE);
			life_chk = true;
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 'j') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.aj);
						break;
					case 8:
						iv8.setImageResource(R.drawable.aj);
						break;
					case 7:
						iv7.setImageResource(R.drawable.aj);
						break;
					case 6:
						iv6.setImageResource(R.drawable.aj);
						break;
					case 5:
						iv5.setImageResource(R.drawable.aj);
						break;
					case 4:
						iv4.setImageResource(R.drawable.aj);
						break;
					case 3:
						iv3.setImageResource(R.drawable.aj);
						break;
					case 2:
						iv2.setImageResource(R.drawable.aj);
						break;
					case 1:
						iv1.setImageResource(R.drawable.aj);
						break;
					}

				}
			}
			life();
			win_chk();
			winner();
			break;
		case R.id.imageButton11:
			k.setVisibility(View.INVISIBLE);
			life_chk = true;
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 'k') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.ak);
						break;
					case 8:
						iv8.setImageResource(R.drawable.ak);
						break;
					case 7:
						iv7.setImageResource(R.drawable.ak);
						break;
					case 6:
						iv6.setImageResource(R.drawable.ak);
						break;
					case 5:
						iv5.setImageResource(R.drawable.ak);
						break;
					case 4:
						iv4.setImageResource(R.drawable.ak);
						break;
					case 3:
						iv3.setImageResource(R.drawable.ak);
						break;
					case 2:
						iv2.setImageResource(R.drawable.ak);
						break;
					case 1:
						iv1.setImageResource(R.drawable.ak);
						break;
					}

				}
			}
			life();
			win_chk();
			winner();
			break;
		case R.id.imageButton12:
			l.setVisibility(View.INVISIBLE);
			life_chk = true;
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 'l') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.al);
						break;
					case 8:
						iv8.setImageResource(R.drawable.al);
						break;
					case 7:
						iv7.setImageResource(R.drawable.al);
						break;
					case 6:
						iv6.setImageResource(R.drawable.al);
						break;
					case 5:
						iv5.setImageResource(R.drawable.al);
						break;
					case 4:
						iv4.setImageResource(R.drawable.al);
						break;
					case 3:
						iv3.setImageResource(R.drawable.al);
						break;
					case 2:
						iv2.setImageResource(R.drawable.al);
						break;
					case 1:
						iv1.setImageResource(R.drawable.al);
						break;
					}

				}
			}
			life();
			win_chk();
			winner();
			break;
		case R.id.imageButton13:
			m.setVisibility(View.INVISIBLE);
			life_chk = true;
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 'm') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.am);
						break;
					case 8:
						iv8.setImageResource(R.drawable.am);
						break;
					case 7:
						iv7.setImageResource(R.drawable.am);
						break;
					case 6:
						iv6.setImageResource(R.drawable.am);
						break;
					case 5:
						iv5.setImageResource(R.drawable.am);
						break;
					case 4:
						iv4.setImageResource(R.drawable.am);
						break;
					case 3:
						iv3.setImageResource(R.drawable.am);
						break;
					case 2:
						iv2.setImageResource(R.drawable.am);
						break;
					case 1:
						iv1.setImageResource(R.drawable.am);
						break;
					}

				}
			}
			life();
			win_chk();
			winner();
			break;
		case R.id.imageButton14:
			n.setVisibility(View.INVISIBLE);
			life_chk = true;
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 'n') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.an);
						break;
					case 8:
						iv8.setImageResource(R.drawable.an);
						break;
					case 7:
						iv7.setImageResource(R.drawable.an);
						break;
					case 6:
						iv6.setImageResource(R.drawable.an);
						break;
					case 5:
						iv5.setImageResource(R.drawable.an);
						break;
					case 4:
						iv4.setImageResource(R.drawable.an);
						break;
					case 3:
						iv3.setImageResource(R.drawable.an);
						break;
					case 2:
						iv2.setImageResource(R.drawable.an);
						break;
					case 1:
						iv1.setImageResource(R.drawable.an);
						break;
					}

				}
			}
			life();
			win_chk();
			winner();
			break;
		case R.id.imageButton15:
			o.setVisibility(View.INVISIBLE);
			life_chk = true;
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 'o') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.ao);
						break;
					case 8:
						iv8.setImageResource(R.drawable.ao);
						break;
					case 7:
						iv7.setImageResource(R.drawable.ao);
						break;
					case 6:
						iv6.setImageResource(R.drawable.ao);
						break;
					case 5:
						iv5.setImageResource(R.drawable.ao);
						break;
					case 4:
						iv4.setImageResource(R.drawable.ao);
						break;
					case 3:
						iv3.setImageResource(R.drawable.ao);
						break;
					case 2:
						iv2.setImageResource(R.drawable.ao);
						break;
					case 1:
						iv1.setImageResource(R.drawable.ao);
						break;
					}

				}
			}
			life();
			win_chk();
			winner();
			break;
		case R.id.imageButton16:
			p.setVisibility(View.INVISIBLE);
			life_chk = true;
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 'p') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.ap);
						break;
					case 8:
						iv8.setImageResource(R.drawable.ap);
						break;
					case 7:
						iv7.setImageResource(R.drawable.ap);
						break;
					case 6:
						iv6.setImageResource(R.drawable.ap);
						break;
					case 5:
						iv5.setImageResource(R.drawable.ap);
						break;
					case 4:
						iv4.setImageResource(R.drawable.ap);
						break;
					case 3:
						iv3.setImageResource(R.drawable.ap);
						break;
					case 2:
						iv2.setImageResource(R.drawable.ap);
						break;
					case 1:
						iv1.setImageResource(R.drawable.ap);
						break;
					}

				}
			}
			life();
			win_chk();
			winner();
			break;
		case R.id.imageButton17:
			q.setVisibility(View.INVISIBLE);
			life_chk = true;
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 'q') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.aq);
						break;
					case 8:
						iv8.setImageResource(R.drawable.aq);
						break;
					case 7:
						iv7.setImageResource(R.drawable.aq);
						break;
					case 6:
						iv6.setImageResource(R.drawable.aq);
						break;
					case 5:
						iv5.setImageResource(R.drawable.aq);
						break;
					case 4:
						iv4.setImageResource(R.drawable.aq);
						break;
					case 3:
						iv3.setImageResource(R.drawable.aq);
						break;
					case 2:
						iv2.setImageResource(R.drawable.aq);
						break;
					case 1:
						iv1.setImageResource(R.drawable.aq);
						break;
					}

				}
			}
			life();
			win_chk();
			winner();
			break;
		case R.id.imageButton18:
			r.setVisibility(View.INVISIBLE);
			life_chk = true;
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 'r') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.ar);
						break;
					case 8:
						iv8.setImageResource(R.drawable.ar);
						break;
					case 7:
						iv7.setImageResource(R.drawable.ar);
						break;
					case 6:
						iv6.setImageResource(R.drawable.ar);
						break;
					case 5:
						iv5.setImageResource(R.drawable.ar);
						break;
					case 4:
						iv4.setImageResource(R.drawable.ar);
						break;
					case 3:
						iv3.setImageResource(R.drawable.ar);
						break;
					case 2:
						iv2.setImageResource(R.drawable.ar);
						break;
					case 1:
						iv1.setImageResource(R.drawable.ar);
						break;
					}

				}
			}
			life();
			win_chk();
			winner();
			break;
		case R.id.imageButton19:
			s.setVisibility(View.INVISIBLE);
			life_chk = true;
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 's') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.as);
						break;
					case 8:
						iv8.setImageResource(R.drawable.as);
						break;
					case 7:
						iv7.setImageResource(R.drawable.as);
						break;
					case 6:
						iv6.setImageResource(R.drawable.as);
						break;
					case 5:
						iv5.setImageResource(R.drawable.as);
						break;
					case 4:
						iv4.setImageResource(R.drawable.as);
						break;
					case 3:
						iv3.setImageResource(R.drawable.as);
						break;
					case 2:
						iv2.setImageResource(R.drawable.as);
						break;
					case 1:
						iv1.setImageResource(R.drawable.as);
						break;
					}

				}
			}
			life();
			win_chk();
			winner();
			break;
		case R.id.imageButton20:
			t.setVisibility(View.INVISIBLE);
			life_chk = true;
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 't') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.at);
						break;
					case 8:
						iv8.setImageResource(R.drawable.at);
						break;
					case 7:
						iv7.setImageResource(R.drawable.at);
						break;
					case 6:
						iv6.setImageResource(R.drawable.at);
						break;
					case 5:
						iv5.setImageResource(R.drawable.at);
						break;
					case 4:
						iv4.setImageResource(R.drawable.at);
						break;
					case 3:
						iv3.setImageResource(R.drawable.at);
						break;
					case 2:
						iv2.setImageResource(R.drawable.at);
						break;
					case 1:
						iv1.setImageResource(R.drawable.at);
						break;
					}

				}
			}
			life();
			win_chk();
			winner();
			break;
		case R.id.imageButton21:
			u.setVisibility(View.INVISIBLE);
			life_chk = true;
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 'u') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.au);
						break;
					case 8:
						iv8.setImageResource(R.drawable.au);
						break;
					case 7:
						iv7.setImageResource(R.drawable.au);
						break;
					case 6:
						iv6.setImageResource(R.drawable.au);
						break;
					case 5:
						iv5.setImageResource(R.drawable.au);
						break;
					case 4:
						iv4.setImageResource(R.drawable.au);
						break;
					case 3:
						iv3.setImageResource(R.drawable.au);
						break;
					case 2:
						iv2.setImageResource(R.drawable.au);
						break;
					case 1:
						iv1.setImageResource(R.drawable.au);
						break;
					}

				}
			}
			life();
			win_chk();
			winner();
			break;
		case R.id.imageButton22:
			v.setVisibility(View.INVISIBLE);
			life_chk = true;
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 'v') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.av);
						break;
					case 8:
						iv8.setImageResource(R.drawable.av);
						break;
					case 7:
						iv7.setImageResource(R.drawable.av);
						break;
					case 6:
						iv6.setImageResource(R.drawable.av);
						break;
					case 5:
						iv5.setImageResource(R.drawable.av);
						break;
					case 4:
						iv4.setImageResource(R.drawable.av);
						break;
					case 3:
						iv3.setImageResource(R.drawable.av);
						break;
					case 2:
						iv2.setImageResource(R.drawable.av);
						break;
					case 1:
						iv1.setImageResource(R.drawable.av);
						break;
					}

				}
			}
			life();
			win_chk();
			winner();
			break;
		case R.id.imageButton23:
			life_chk = true;
			w.setVisibility(View.INVISIBLE);
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 'w') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.aw);
						break;
					case 8:
						iv8.setImageResource(R.drawable.aw);
						break;
					case 7:
						iv7.setImageResource(R.drawable.aw);
						break;
					case 6:
						iv6.setImageResource(R.drawable.aw);
						break;
					case 5:
						iv5.setImageResource(R.drawable.aw);
						break;
					case 4:
						iv4.setImageResource(R.drawable.aw);
						break;
					case 3:
						iv3.setImageResource(R.drawable.aw);
						break;
					case 2:
						iv2.setImageResource(R.drawable.aw);
						break;
					case 1:
						iv1.setImageResource(R.drawable.aw);
						break;
					}

				}
			}
			life();
			win_chk();
			winner();
			break;
		case R.id.imageButton24:
			x.setVisibility(View.INVISIBLE);
			life_chk = true;
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 'x') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.ax);
						break;
					case 8:
						iv8.setImageResource(R.drawable.ax);
						break;
					case 7:
						iv7.setImageResource(R.drawable.ax);
						break;
					case 6:
						iv6.setImageResource(R.drawable.ax);
						break;
					case 5:
						iv5.setImageResource(R.drawable.ax);
						break;
					case 4:
						iv4.setImageResource(R.drawable.ax);
						break;
					case 3:
						iv3.setImageResource(R.drawable.ax);
						break;
					case 2:
						iv2.setImageResource(R.drawable.ax);
						break;
					case 1:
						iv1.setImageResource(R.drawable.ax);
						break;
					}

				}
			}
			life();
			win_chk();
			winner();
			break;
		case R.id.imageButton25:
			y.setVisibility(View.INVISIBLE);
			life_chk = true;
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 'y') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.ay);
						break;
					case 8:
						iv8.setImageResource(R.drawable.ay);
						break;
					case 7:
						iv7.setImageResource(R.drawable.ay);
						break;
					case 6:
						iv6.setImageResource(R.drawable.ay);
						break;
					case 5:
						iv5.setImageResource(R.drawable.ay);
						break;
					case 4:
						iv4.setImageResource(R.drawable.ay);
						break;
					case 3:
						iv3.setImageResource(R.drawable.ay);
						break;
					case 2:
						iv2.setImageResource(R.drawable.ay);
						break;
					case 1:
						iv1.setImageResource(R.drawable.ay);
						break;
					}

				}
			}
			life();
			win_chk();
			winner();
			break;
		case R.id.imageButton26:
			z.setVisibility(View.INVISIBLE);
			life_chk = true;
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 'z') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.az);
						break;
					case 8:
						iv8.setImageResource(R.drawable.az);
						break;
					case 7:
						iv7.setImageResource(R.drawable.az);
						break;
					case 6:
						iv6.setImageResource(R.drawable.az);
						break;
					case 5:
						iv5.setImageResource(R.drawable.az);
						break;
					case 4:
						iv4.setImageResource(R.drawable.az);
						break;
					case 3:
						iv3.setImageResource(R.drawable.az);
						break;
					case 2:
						iv2.setImageResource(R.drawable.az);
						break;
					case 1:
						iv1.setImageResource(R.drawable.az);
						break;
					}

				}
			}
			life();
			win_chk();
			winner();
			break;

		}

	}

	public void life() {
		if (life_chk == true) {
			lives--;
			wrong.start();
			switch (lives) {
			case 2:
				// l3.setVisibility(View.INVISIBLE);
				l1.setVisibility(View.VISIBLE);
				break;
			case 1:
				// l2.setVisibility(View.INVISIBLE);
				l2.setVisibility(View.VISIBLE);
				break;
			case 0:
				// l1.setVisibility(View.INVISIBLE);
				l3.setVisibility(View.VISIBLE);
				game_over.setText("Game Over");
				break;
			}
		} else {
			correct.start();
		}

	}

	public void hint() {
		Random rad = new Random();
		int rand;
		boolean chk_hint = true;
		View ch;
		char h_ch;

		do {
			rand = rad.nextInt(len);
			if (place_filled[rand] == 0) {
				chk_hint = false;
				h_ch = puzzle.charAt(rand);
				ch = view_pass(h_ch);
				word_click(ch);
			}
		} while (chk_hint == true);

		/*
		 * if (place_filled[rand] == 0) { // chk_hint = false; h_ch =
		 * puzzle.charAt(rand);
		 * 
		 * // for (int i = 0; i < len; i++) { // if (puzzle.charAt(i) == h_ch) {
		 * ch = view_pass(h_ch); word_click(ch); //} //} } /*else if
		 * (place_filled[len - 1] == 1) { for (int j = 0; j < len; j++) { if
		 * (place_filled[j] == 0) { // if(rad.nextBoolean()){ h_ch =
		 * puzzle.charAt(j); ch = view_pass(h_ch); word_click(ch); // } } else {
		 * continue; } } }
		 */

	}

	View view_pass(char h_ch) {
		// TODO Auto-generated method stub
		View ch = null;
		switch (h_ch) {
		case 'a':
			ch = a;
			break;
		case 'b':
			ch = b;
			break;
		case 'c':
			ch = c;
			break;
		case 'd':
			ch = d;
			break;
		case 'e':
			ch = e;
			break;
		case 'f':
			ch = f;
			break;
		case 'g':
			ch = g;
			break;
		case 'h':
			ch = h;
			break;
		case 'i':
			ch = i;
			break;
		case 'j':
			ch = j;
			break;
		case 'k':
			ch = k;
			break;
		case 'l':
			ch = l;
			break;
		case 'm':
			ch = m;
			break;
		case 'n':
			ch = n;
			break;
		case 'o':
			ch = o;
			break;
		case 'p':
			ch = p;
			break;
		case 'q':
			ch = q;
			break;
		case 'r':
			ch = r;
			break;
		case 's':
			ch = s;
			break;
		case 't':
			ch = t;
			break;
		case 'u':
			ch = u;
			break;
		case 'v':
			ch = v;
			break;
		case 'w':
			ch = w;
			break;
		case 'x':
			ch = x;
			break;
		case 'y':
			ch = y;
			break;
		case 'z':
			ch = z;
			break;
		}
		return ch;
	}

	public void hint_text() {
		if (life_chk == true) {

			txt_hint.setTextColor(Color.RED);
			txt_hint.setText("" + Info.wrong_comments[rad.nextInt(3)]);
			Toast.makeText(WordGuess.this,
					"" + Info.wrong_comments[rad.nextInt(3)],
					Toast.LENGTH_SHORT).show();
		} else {
			txt_hint.setTextColor(Color.GREEN);
			txt_hint.setText("" + Info.correct_comments[rad.nextInt(4)]);
			Toast.makeText(WordGuess.this,
					"" + Info.correct_comments[rad.nextInt(4)],
					Toast.LENGTH_SHORT).show();
		}

		if ((lives == 1) && (word_hint.getVisibility() == View.VISIBLE)) {
			txt_hint.setText("Need Hint");
			Toast.makeText(WordGuess.this, "Need Hint", Toast.LENGTH_SHORT)
					.show();
		}

	}

	ImageButton a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u,
			v, w, x, y, z;
	TableLayout tb;
	TableRow life;
	ImageButton word_hint;

	ImageView iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9, l1, l2, l3;
	EditText txt;
	TextView err, game_over, description, txt_hint;
	int len, lives = 3, loop;
	boolean life_chk, play_chk;
	static boolean win = false;
	static String puzzle;
	int[] place_filled = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	Random rad = new Random();
	int rand;
	private InterstitialAd interstitial;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.main);
		Menu.gateway = 1;
		
		interstitial = new InterstitialAd(this);
		interstitial.setAdUnitId(getResources().getString(R.string.ad_interstitial));
		AdRequest adRequest = new AdRequest.Builder().build();
		interstitial.loadAd(adRequest);
		interstitial.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                Toast.makeText(WordGuess.this,"Hint Button is now Available", Toast.LENGTH_SHORT).show();
                word_hint.setEnabled(true);
            }

            @Override
            public void onAdClosed() {
                // Proceed to the next level.
                hint();
            }
        });
		
		a = (ImageButton) findViewById(R.id.imageButton1);
		b = (ImageButton) findViewById(R.id.imageButton2);
		c = (ImageButton) findViewById(R.id.imageButton3);
		d = (ImageButton) findViewById(R.id.imageButton4);
		e = (ImageButton) findViewById(R.id.imageButton5);
		f = (ImageButton) findViewById(R.id.imageButton6);
		g = (ImageButton) findViewById(R.id.imageButton7);
		h = (ImageButton) findViewById(R.id.imageButton8);
		i = (ImageButton) findViewById(R.id.imageButton9);
		j = (ImageButton) findViewById(R.id.imageButton10);
		k = (ImageButton) findViewById(R.id.imageButton11);
		l = (ImageButton) findViewById(R.id.imageButton12);
		m = (ImageButton) findViewById(R.id.imageButton13);
		n = (ImageButton) findViewById(R.id.imageButton14);
		o = (ImageButton) findViewById(R.id.imageButton15);
		p = (ImageButton) findViewById(R.id.imageButton16);
		q = (ImageButton) findViewById(R.id.imageButton17);
		r = (ImageButton) findViewById(R.id.imageButton18);
		s = (ImageButton) findViewById(R.id.imageButton19);
		t = (ImageButton) findViewById(R.id.imageButton20);
		u = (ImageButton) findViewById(R.id.imageButton21);
		v = (ImageButton) findViewById(R.id.imageButton22);
		w = (ImageButton) findViewById(R.id.imageButton23);
		x = (ImageButton) findViewById(R.id.imageButton24);
		y = (ImageButton) findViewById(R.id.imageButton25);
		z = (ImageButton) findViewById(R.id.imageButton26);

		word_hint = (ImageButton) findViewById(R.id.word_hint);
		word_hint.setEnabled(false);

		word_hint.setOnClickListener(this);

		a.setOnClickListener(this);
		b.setOnClickListener(this);
		c.setOnClickListener(this);
		d.setOnClickListener(this);
		e.setOnClickListener(this);
		f.setOnClickListener(this);
		g.setOnClickListener(this);
		h.setOnClickListener(this);
		i.setOnClickListener(this);
		j.setOnClickListener(this);
		k.setOnClickListener(this);
		l.setOnClickListener(this);
		m.setOnClickListener(this);
		n.setOnClickListener(this);
		o.setOnClickListener(this);
		p.setOnClickListener(this);
		q.setOnClickListener(this);
		r.setOnClickListener(this);
		s.setOnClickListener(this);
		t.setOnClickListener(this);
		u.setOnClickListener(this);
		v.setOnClickListener(this);
		w.setOnClickListener(this);
		x.setOnClickListener(this);
		y.setOnClickListener(this);
		z.setOnClickListener(this);

		iv1 = (ImageView) findViewById(R.id.imageView1);
		iv2 = (ImageView) findViewById(R.id.imageView2);
		iv3 = (ImageView) findViewById(R.id.imageView3);
		iv4 = (ImageView) findViewById(R.id.imageView4);
		iv5 = (ImageView) findViewById(R.id.imageView5);
		iv6 = (ImageView) findViewById(R.id.imageView6);
		iv7 = (ImageView) findViewById(R.id.imageView7);
		iv8 = (ImageView) findViewById(R.id.imageView8);
		iv9 = (ImageView) findViewById(R.id.imageView9);

		l1 = (ImageView) findViewById(R.id.imageView10);
		l2 = (ImageView) findViewById(R.id.imageView11);
		l3 = (ImageView) findViewById(R.id.imageView12);

		txt = (EditText) findViewById(R.id.editText1);
		err = (TextView) findViewById(R.id.textView1);
		game_over = (TextView) findViewById(R.id.textView2);

		life = (TableRow) findViewById(R.id.tableRow7);
		tb = (TableLayout) findViewById(R.id.tableLayout1);

		txt_hint = (TextView) findViewById(R.id.txt_hint);
		description = (TextView) findViewById(R.id.txt_des);
		wrong = MediaPlayer.create(WordGuess.this, R.raw.wrong);
		correct = MediaPlayer.create(WordGuess.this, R.raw.correct);
		wrong.setOnCompletionListener(this);
		correct.setOnCompletionListener(this);
		/*
		 * submit.setOnClickListener(new View.OnClickListener() {
		 * 
		 * @Override public void onClick(View v) { // TODO Auto-generated method
		 * stub play_chk=true; len=txt.length(); if (len==0) {
		 * err.setText("Please enter a word with Max Word Length of 9"); } else
		 * if (len<=9) { puzzle=txt.getText().toString().toLowerCase(); for
		 * (loop=0;loop<len;loop++) { if (puzzle.charAt(loop)==' ')
		 * {play_chk=false;
		 * err.setText("Your word contains a space.Please enter another word!");
		 * 
		 * }else if ((puzzle.charAt(loop)<='a')&&(puzzle.charAt(loop)>='z'))
		 * {play_chk=false; err.setText(
		 * "Your word contains a contains a special character.Please enter another word!"
		 * ); } } } else if (len>9){ err.setText("Word Length Exceeds 9"); }
		 * 
		 * 
		 * 
		 * if (play_chk==true){
		 * 
		 * tb.setVisibility(View.VISIBLE); txt.setVisibility(View.INVISIBLE);
		 * err.setVisibility(View.INVISIBLE);
		 * submit.setVisibility(View.INVISIBLE);
		 * 
		 * switch(len){ case 9:iv9.setVisibility(View.VISIBLE); case
		 * 8:iv8.setVisibility(View.VISIBLE); case
		 * 7:iv7.setVisibility(View.VISIBLE); case
		 * 6:iv6.setVisibility(View.VISIBLE); case
		 * 5:iv5.setVisibility(View.VISIBLE); case
		 * 4:iv4.setVisibility(View.VISIBLE); case
		 * 3:iv3.setVisibility(View.VISIBLE); case
		 * 2:iv2.setVisibility(View.VISIBLE); case
		 * 1:iv1.setVisibility(View.VISIBLE); } }
		 * 
		 * } });
		 */
		if (Info.career == true) {

			puzzle = Info.word[Info.car_level].toLowerCase();
			description.setText("" + Info.des[Info.car_level]);
			len = puzzle.length();
		} else if (Info.challenge == true) {

			puzzle = Info.puzzle;
			description.setText("" + Info.description);
			len = puzzle.length();
		} else if (Info.play == true) {
			rand = rad.nextInt(36);
			puzzle = Info.word[rand].toLowerCase();
			description.setText("" + Info.des[rand]);
			// puzzle = Play.puzzle;
			// description.setText("" + Play.description);
			len = puzzle.length();
		}

		switch (len) {
		case 9:
			iv9.setVisibility(View.VISIBLE);
		case 8:
			iv8.setVisibility(View.VISIBLE);
		case 7:
			iv7.setVisibility(View.VISIBLE);
		case 6:
			iv6.setVisibility(View.VISIBLE);
		case 5:
			iv5.setVisibility(View.VISIBLE);
		case 4:
			iv4.setVisibility(View.VISIBLE);
		case 3:
			iv3.setVisibility(View.VISIBLE);
		case 2:
			iv2.setVisibility(View.VISIBLE);
		case 1:
			iv1.setVisibility(View.VISIBLE);
		}
		switch (len + 1) {
		case 1:
			iv1.setVisibility(View.GONE);
		case 2:
			iv2.setVisibility(View.GONE);
		case 3:
			iv3.setVisibility(View.GONE);
		case 4:
			iv4.setVisibility(View.GONE);
		case 5:
			iv5.setVisibility(View.GONE);
		case 6:
			iv6.setVisibility(View.GONE);
		case 7:
			iv7.setVisibility(View.GONE);
		case 8:
			iv8.setVisibility(View.GONE);
		case 9:
			iv9.setVisibility(View.GONE);
		}

		l1.setVisibility(View.INVISIBLE);
		l2.setVisibility(View.INVISIBLE);
		l3.setVisibility(View.INVISIBLE);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		word_click(v);

		hint_text();

	}

	@Override
	public void onCompletion(MediaPlayer mp) {
		// TODO Auto-generated method stub
		// wrong.release();
		// correct.release();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		if(hint_press==true){
			hint_press=false;
		}
		else{
		finish();
		}
	}
}