package com.rsp.rishi;

import java.util.Random;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NamePlay extends Activity implements OnClickListener {

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		if (hint_press == true) {
			hint_press = false;
		} else {
			finish();
		}
	}

	ImageButton a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u,
			v, w, x, y, z;
	ImageView iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9, iv10, iv11, iv12,
			iv13, iv14, iv15, iv16, iv17, iv18, l1, l2, l3;
	MediaPlayer wrong, correct;
	Boolean hint_press = false;

	ImageButton word_hint;
	TextView err, game_over, description, txt_hint;
	int flen, llen, lives = 3, loop;
	boolean flife_chk, llife_chk, life_chk, play_chk;
	static boolean win = false;
	static String fpuzzle, lpuzzle;
	int[] first_name = { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, last_name = { 0, 0, 0, 0,
			0, 0, 0, 0, 0 };
	Random rad = new Random();
	int rand;
	static int range = 17;
	private InterstitialAd interstitial;

	public void displayInterstitial() {
		if (interstitial.isLoaded()) {
			interstitial.show();
		} else {
			Toast.makeText(this, "Ad not loaded", Toast.LENGTH_SHORT).show();
		}
	}

	public void hint_text() {
		if (life_chk == true) {

			txt_hint.setTextColor(Color.RED);
			txt_hint.setText("" + Info.wrong_comments[rad.nextInt(3)]);
			Toast.makeText(NamePlay.this,
					"" + Info.wrong_comments[rad.nextInt(3)],
					Toast.LENGTH_SHORT).show();
		} else {
			txt_hint.setTextColor(Color.GREEN);
			txt_hint.setText("" + Info.correct_comments[rad.nextInt(4)]);
			Toast.makeText(NamePlay.this,
					"" + Info.correct_comments[rad.nextInt(4)],
					Toast.LENGTH_SHORT).show();
		}

		if ((lives == 1) && (word_hint.getVisibility() == View.VISIBLE)) {
			txt_hint.setTextColor(Color.RED);
			txt_hint.setText("Need Hint");
			Toast.makeText(NamePlay.this, "Need Hint", Toast.LENGTH_SHORT)
					.show();
		}

	}

	void visible_box() {
		switch (flen) {
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
		switch (flen + 1) {
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

		switch (llen) {
		case 9:
			iv18.setVisibility(View.VISIBLE);
		case 8:
			iv17.setVisibility(View.VISIBLE);
		case 7:
			iv16.setVisibility(View.VISIBLE);
		case 6:
			iv15.setVisibility(View.VISIBLE);
		case 5:
			iv14.setVisibility(View.VISIBLE);
		case 4:
			iv13.setVisibility(View.VISIBLE);
		case 3:
			iv12.setVisibility(View.VISIBLE);
		case 2:
			iv11.setVisibility(View.VISIBLE);
		case 1:
			iv10.setVisibility(View.VISIBLE);
		}
		switch (llen + 1) {
		case 1:
			iv10.setVisibility(View.GONE);
		case 2:
			iv11.setVisibility(View.GONE);
		case 3:
			iv12.setVisibility(View.GONE);
		case 4:
			iv13.setVisibility(View.GONE);
		case 5:
			iv14.setVisibility(View.GONE);
		case 6:
			iv15.setVisibility(View.GONE);
		case 7:
			iv16.setVisibility(View.GONE);
		case 8:
			iv17.setVisibility(View.GONE);
		case 9:
			iv18.setVisibility(View.GONE);
		}
	}

	public void win_chk() {

		for (int i = 0; i < flen; i++) {
			if (first_name[i] == 1) {
				win = true;
			} else {
				win = false;
				break;
			}
		}
		if (win == true) {
			for (int i = 0; i < llen; i++) {
				if (last_name[i] == 1) {
					win = true;
				} else {
					win = false;
					break;
				}
			}
		}

	}

	public void winner() {

		Intent ourIntent = new Intent("com.rsp.rishi.GAMEOVER");
		if (win == true) {

			// GameOver.txt_result.setText("Great Guessing! You Won!");
			game_over.setText("Great Guessing! You Won!");
			// wrong.release();
			// correct.release();
			startActivity(ourIntent);
			/*
			 * try { wrong.release(); correct.release();
			 * startActivity(ourIntent); } catch (ActivityNotFoundException e) {
			 * e.printStackTrace(); }
			 */

		} else if (lives == 0) {
			// GameOver.txt_result.setText("Great Guessing! You Won!");
			game_over.setText("Game Over");
			wrong.release();
			correct.release();
			startActivity(ourIntent);
			/*
			 * try { wrong.release(); correct.release();
			 * startActivity(ourIntent); } catch (ActivityNotFoundException e) {
			 * e.printStackTrace(); }
			 */

		}
	}

	void first_name_click(View v) {
		switch (v.getId()) {
		case R.id.word_hint:
			word_hint.setVisibility(View.INVISIBLE);
			// hint();
			try {
				displayInterstitial();
				hint_press = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case R.id.ib1:
			a.setVisibility(View.INVISIBLE);
			flife_chk = true;
			for (loop = 0; loop < flen; loop++) {
				if (fpuzzle.charAt(loop) == 'a') {
					flife_chk = false;
					first_name[loop] = 1;
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

			win_chk();
			winner();

			break;
		case R.id.ib2:
			b.setVisibility(View.INVISIBLE);
			flife_chk = true;
			for (loop = 0; loop < flen; loop++) {
				if (fpuzzle.charAt(loop) == 'b') {
					flife_chk = false;
					first_name[loop] = 1;
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

			win_chk();
			winner();
			break;
		case R.id.ib3:
			c.setVisibility(View.INVISIBLE);
			flife_chk = true;
			for (loop = 0; loop < flen; loop++) {
				if (fpuzzle.charAt(loop) == 'c') {
					flife_chk = false;
					first_name[loop] = 1;
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

			win_chk();
			winner();
			break;
		case R.id.ib4:
			d.setVisibility(View.INVISIBLE);
			flife_chk = true;
			for (loop = 0; loop < flen; loop++) {
				if (fpuzzle.charAt(loop) == 'd') {
					flife_chk = false;
					first_name[loop] = 1;
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

			win_chk();
			winner();
			break;
		case R.id.ib5:
			e.setVisibility(View.INVISIBLE);
			flife_chk = true;
			for (loop = 0; loop < flen; loop++) {
				if (fpuzzle.charAt(loop) == 'e') {
					flife_chk = false;
					first_name[loop] = 1;
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

			win_chk();
			winner();
			break;
		case R.id.ib6:
			f.setVisibility(View.INVISIBLE);
			flife_chk = true;
			for (loop = 0; loop < flen; loop++) {
				if (fpuzzle.charAt(loop) == 'f') {
					flife_chk = false;
					first_name[loop] = 1;
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

			win_chk();
			winner();
			break;
		case R.id.ib7:
			g.setVisibility(View.INVISIBLE);
			flife_chk = true;
			for (loop = 0; loop < flen; loop++) {
				if (fpuzzle.charAt(loop) == 'g') {
					flife_chk = false;
					first_name[loop] = 1;
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

			win_chk();
			winner();
			break;
		case R.id.ib8:
			h.setVisibility(View.INVISIBLE);
			flife_chk = true;
			for (loop = 0; loop < flen; loop++) {
				if (fpuzzle.charAt(loop) == 'h') {
					flife_chk = false;
					first_name[loop] = 1;
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

			win_chk();
			winner();
			break;
		case R.id.ib9:
			i.setVisibility(View.INVISIBLE);
			flife_chk = true;
			for (loop = 0; loop < flen; loop++) {
				if (fpuzzle.charAt(loop) == 'i') {
					flife_chk = false;
					first_name[loop] = 1;
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

			win_chk();
			winner();
			break;
		case R.id.ib10:
			j.setVisibility(View.INVISIBLE);
			flife_chk = true;
			for (loop = 0; loop < flen; loop++) {
				if (fpuzzle.charAt(loop) == 'j') {
					flife_chk = false;
					first_name[loop] = 1;
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

			win_chk();
			winner();
			break;
		case R.id.ib11:
			k.setVisibility(View.INVISIBLE);
			flife_chk = true;
			for (loop = 0; loop < flen; loop++) {
				if (fpuzzle.charAt(loop) == 'k') {
					flife_chk = false;
					first_name[loop] = 1;
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

			win_chk();
			winner();
			break;
		case R.id.ib12:
			l.setVisibility(View.INVISIBLE);
			flife_chk = true;
			for (loop = 0; loop < flen; loop++) {
				if (fpuzzle.charAt(loop) == 'l') {
					flife_chk = false;
					first_name[loop] = 1;
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

			win_chk();
			winner();
			break;
		case R.id.ib13:
			m.setVisibility(View.INVISIBLE);
			flife_chk = true;
			for (loop = 0; loop < flen; loop++) {
				if (fpuzzle.charAt(loop) == 'm') {
					flife_chk = false;
					first_name[loop] = 1;
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

			win_chk();
			winner();
			break;
		case R.id.ib14:
			n.setVisibility(View.INVISIBLE);
			flife_chk = true;
			for (loop = 0; loop < flen; loop++) {
				if (fpuzzle.charAt(loop) == 'n') {
					flife_chk = false;
					first_name[loop] = 1;
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

			win_chk();
			winner();
			break;
		case R.id.ib15:
			o.setVisibility(View.INVISIBLE);
			flife_chk = true;
			for (loop = 0; loop < flen; loop++) {
				if (fpuzzle.charAt(loop) == 'o') {
					flife_chk = false;
					first_name[loop] = 1;
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

			win_chk();
			winner();
			break;
		case R.id.ib16:
			p.setVisibility(View.INVISIBLE);
			flife_chk = true;
			for (loop = 0; loop < flen; loop++) {
				if (fpuzzle.charAt(loop) == 'p') {
					flife_chk = false;
					first_name[loop] = 1;
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

			win_chk();
			winner();
			break;
		case R.id.ib17:
			q.setVisibility(View.INVISIBLE);
			flife_chk = true;
			for (loop = 0; loop < flen; loop++) {
				if (fpuzzle.charAt(loop) == 'q') {
					flife_chk = false;
					first_name[loop] = 1;
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

			win_chk();
			winner();
			break;
		case R.id.ib18:
			r.setVisibility(View.INVISIBLE);
			flife_chk = true;
			for (loop = 0; loop < flen; loop++) {
				if (fpuzzle.charAt(loop) == 'r') {
					flife_chk = false;
					first_name[loop] = 1;
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

			win_chk();
			winner();
			break;
		case R.id.ib19:
			s.setVisibility(View.INVISIBLE);
			flife_chk = true;
			for (loop = 0; loop < flen; loop++) {
				if (fpuzzle.charAt(loop) == 's') {
					flife_chk = false;
					first_name[loop] = 1;
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

			win_chk();
			winner();
			break;
		case R.id.ib20:
			t.setVisibility(View.INVISIBLE);
			flife_chk = true;
			for (loop = 0; loop < flen; loop++) {
				if (fpuzzle.charAt(loop) == 't') {
					flife_chk = false;
					first_name[loop] = 1;
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

			win_chk();
			winner();
			break;
		case R.id.ib21:
			u.setVisibility(View.INVISIBLE);
			flife_chk = true;
			for (loop = 0; loop < flen; loop++) {
				if (fpuzzle.charAt(loop) == 'u') {
					flife_chk = false;
					first_name[loop] = 1;
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

			win_chk();
			winner();
			break;
		case R.id.ib22:
			v.setVisibility(View.INVISIBLE);
			flife_chk = true;
			for (loop = 0; loop < flen; loop++) {
				if (fpuzzle.charAt(loop) == 'v') {
					flife_chk = false;
					first_name[loop] = 1;
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

			win_chk();
			winner();
			break;
		case R.id.ib23:
			flife_chk = true;
			w.setVisibility(View.INVISIBLE);
			for (loop = 0; loop < flen; loop++) {
				if (fpuzzle.charAt(loop) == 'w') {
					flife_chk = false;
					first_name[loop] = 1;
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

			win_chk();
			winner();
			break;
		case R.id.ib24:
			x.setVisibility(View.INVISIBLE);
			flife_chk = true;
			for (loop = 0; loop < flen; loop++) {
				if (fpuzzle.charAt(loop) == 'x') {
					flife_chk = false;
					first_name[loop] = 1;
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

			win_chk();
			winner();
			break;
		case R.id.ib25:
			y.setVisibility(View.INVISIBLE);
			flife_chk = true;
			for (loop = 0; loop < flen; loop++) {
				if (fpuzzle.charAt(loop) == 'y') {
					flife_chk = false;
					first_name[loop] = 1;
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

			win_chk();
			winner();
			break;
		case R.id.ib26:
			z.setVisibility(View.INVISIBLE);
			flife_chk = true;
			for (loop = 0; loop < flen; loop++) {
				if (fpuzzle.charAt(loop) == 'z') {
					flife_chk = false;
					first_name[loop] = 1;
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

			win_chk();
			winner();
			break;

		}
	}

	void last_name_click(View v) {
		switch (v.getId()) {
		case R.id.word_hint:
			word_hint.setVisibility(View.INVISIBLE);
			// hint();
			try {
				displayInterstitial();
				hint_press = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case R.id.ib1:
			a.setVisibility(View.INVISIBLE);
			llife_chk = true;
			for (loop = 0; loop < llen; loop++) {
				if (lpuzzle.charAt(loop) == 'a') {
					llife_chk = false;
					last_name[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv18.setImageResource(R.drawable.aa);
						break;
					case 8:
						iv17.setImageResource(R.drawable.aa);
						break;
					case 7:
						iv16.setImageResource(R.drawable.aa);
						break;
					case 6:
						iv15.setImageResource(R.drawable.aa);
						break;
					case 5:
						iv14.setImageResource(R.drawable.aa);
						break;
					case 4:
						iv13.setImageResource(R.drawable.aa);
						break;
					case 3:
						iv12.setImageResource(R.drawable.aa);
						break;
					case 2:
						iv11.setImageResource(R.drawable.aa);
						break;
					case 1:
						iv10.setImageResource(R.drawable.aa);
						break;
					}

				}
			}

			win_chk();
			winner();

			break;
		case R.id.ib2:
			b.setVisibility(View.INVISIBLE);
			llife_chk = true;
			for (loop = 0; loop < llen; loop++) {
				if (lpuzzle.charAt(loop) == 'b') {
					llife_chk = false;
					last_name[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv18.setImageResource(R.drawable.ab);
						break;
					case 8:
						iv17.setImageResource(R.drawable.ab);
						break;
					case 7:
						iv16.setImageResource(R.drawable.ab);
						break;
					case 6:
						iv15.setImageResource(R.drawable.ab);
						break;
					case 5:
						iv14.setImageResource(R.drawable.ab);
						break;
					case 4:
						iv13.setImageResource(R.drawable.ab);
						break;
					case 3:
						iv12.setImageResource(R.drawable.ab);
						break;
					case 2:
						iv11.setImageResource(R.drawable.ab);
						break;
					case 1:
						iv10.setImageResource(R.drawable.ab);
						break;
					}

				}

			}

			win_chk();
			winner();
			break;
		case R.id.ib3:
			c.setVisibility(View.INVISIBLE);
			llife_chk = true;
			for (loop = 0; loop < llen; loop++) {
				if (lpuzzle.charAt(loop) == 'c') {
					llife_chk = false;
					last_name[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv18.setImageResource(R.drawable.ac);
						break;
					case 8:
						iv17.setImageResource(R.drawable.ac);
						break;
					case 7:
						iv16.setImageResource(R.drawable.ac);
						break;
					case 6:
						iv15.setImageResource(R.drawable.ac);
						break;
					case 5:
						iv14.setImageResource(R.drawable.ac);
						break;
					case 4:
						iv13.setImageResource(R.drawable.ac);
						break;
					case 3:
						iv12.setImageResource(R.drawable.ac);
						break;
					case 2:
						iv11.setImageResource(R.drawable.ac);
						break;
					case 1:
						iv10.setImageResource(R.drawable.ac);
						break;
					}

				}
			}

			win_chk();
			winner();
			break;
		case R.id.ib4:
			d.setVisibility(View.INVISIBLE);
			llife_chk = true;
			for (loop = 0; loop < llen; loop++) {
				if (lpuzzle.charAt(loop) == 'd') {
					llife_chk = false;
					last_name[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv18.setImageResource(R.drawable.ad);
						break;
					case 8:
						iv17.setImageResource(R.drawable.ad);
						break;
					case 7:
						iv16.setImageResource(R.drawable.ad);
						break;
					case 6:
						iv15.setImageResource(R.drawable.ad);
						break;
					case 5:
						iv14.setImageResource(R.drawable.ad);
						break;
					case 4:
						iv13.setImageResource(R.drawable.ad);
						break;
					case 3:
						iv12.setImageResource(R.drawable.ad);
						break;
					case 2:
						iv11.setImageResource(R.drawable.ad);
						break;
					case 1:
						iv10.setImageResource(R.drawable.ad);
						break;
					}

				}
			}

			win_chk();
			winner();
			break;
		case R.id.ib5:
			e.setVisibility(View.INVISIBLE);
			llife_chk = true;
			for (loop = 0; loop < llen; loop++) {
				if (lpuzzle.charAt(loop) == 'e') {
					llife_chk = false;
					last_name[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv18.setImageResource(R.drawable.ae);
						break;
					case 8:
						iv17.setImageResource(R.drawable.ae);
						break;
					case 7:
						iv16.setImageResource(R.drawable.ae);
						break;
					case 6:
						iv15.setImageResource(R.drawable.ae);
						break;
					case 5:
						iv14.setImageResource(R.drawable.ae);
						break;
					case 4:
						iv13.setImageResource(R.drawable.ae);
						break;
					case 3:
						iv12.setImageResource(R.drawable.ae);
						break;
					case 2:
						iv11.setImageResource(R.drawable.ae);
						break;
					case 1:
						iv10.setImageResource(R.drawable.ae);
						break;
					}

				}
			}

			win_chk();
			winner();
			break;
		case R.id.ib6:
			f.setVisibility(View.INVISIBLE);
			llife_chk = true;
			for (loop = 0; loop < llen; loop++) {
				if (lpuzzle.charAt(loop) == 'f') {
					llife_chk = false;
					last_name[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv18.setImageResource(R.drawable.af);
						break;
					case 8:
						iv17.setImageResource(R.drawable.af);
						break;
					case 7:
						iv16.setImageResource(R.drawable.af);
						break;
					case 6:
						iv15.setImageResource(R.drawable.af);
						break;
					case 5:
						iv14.setImageResource(R.drawable.af);
						break;
					case 4:
						iv13.setImageResource(R.drawable.af);
						break;
					case 3:
						iv12.setImageResource(R.drawable.af);
						break;
					case 2:
						iv11.setImageResource(R.drawable.af);
						break;
					case 1:
						iv10.setImageResource(R.drawable.af);
						break;
					}

				}
			}

			win_chk();
			winner();
			break;
		case R.id.ib7:
			g.setVisibility(View.INVISIBLE);
			llife_chk = true;
			for (loop = 0; loop < llen; loop++) {
				if (lpuzzle.charAt(loop) == 'g') {
					llife_chk = false;
					last_name[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv18.setImageResource(R.drawable.ag);
						break;
					case 8:
						iv17.setImageResource(R.drawable.ag);
						break;
					case 7:
						iv16.setImageResource(R.drawable.ag);
						break;
					case 6:
						iv15.setImageResource(R.drawable.ag);
						break;
					case 5:
						iv14.setImageResource(R.drawable.ag);
						break;
					case 4:
						iv13.setImageResource(R.drawable.ag);
						break;
					case 3:
						iv12.setImageResource(R.drawable.ag);
						break;
					case 2:
						iv11.setImageResource(R.drawable.ag);
						break;
					case 1:
						iv10.setImageResource(R.drawable.ag);
						break;
					}

				}
			}

			win_chk();
			winner();
			break;
		case R.id.ib8:
			h.setVisibility(View.INVISIBLE);
			llife_chk = true;
			for (loop = 0; loop < llen; loop++) {
				if (lpuzzle.charAt(loop) == 'h') {
					llife_chk = false;
					last_name[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv18.setImageResource(R.drawable.ah);
						break;
					case 8:
						iv17.setImageResource(R.drawable.ah);
						break;
					case 7:
						iv16.setImageResource(R.drawable.ah);
						break;
					case 6:
						iv15.setImageResource(R.drawable.ah);
						break;
					case 5:
						iv14.setImageResource(R.drawable.ah);
						break;
					case 4:
						iv13.setImageResource(R.drawable.ah);
						break;
					case 3:
						iv12.setImageResource(R.drawable.ah);
						break;
					case 2:
						iv11.setImageResource(R.drawable.ah);
						break;
					case 1:
						iv10.setImageResource(R.drawable.ah);
						break;
					}

				}
			}

			win_chk();
			winner();
			break;
		case R.id.ib9:
			i.setVisibility(View.INVISIBLE);
			llife_chk = true;
			for (loop = 0; loop < llen; loop++) {
				if (lpuzzle.charAt(loop) == 'i') {
					llife_chk = false;
					last_name[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv18.setImageResource(R.drawable.ai);
						break;
					case 8:
						iv17.setImageResource(R.drawable.ai);
						break;
					case 7:
						iv16.setImageResource(R.drawable.ai);
						break;
					case 6:
						iv15.setImageResource(R.drawable.ai);
						break;
					case 5:
						iv14.setImageResource(R.drawable.ai);
						break;
					case 4:
						iv13.setImageResource(R.drawable.ai);
						break;
					case 3:
						iv12.setImageResource(R.drawable.ai);
						break;
					case 2:
						iv11.setImageResource(R.drawable.ai);
						break;
					case 1:
						iv10.setImageResource(R.drawable.ai);
						break;
					}

				}
			}

			win_chk();
			winner();
			break;
		case R.id.ib10:
			j.setVisibility(View.INVISIBLE);
			llife_chk = true;
			for (loop = 0; loop < llen; loop++) {
				if (lpuzzle.charAt(loop) == 'j') {
					llife_chk = false;
					last_name[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv18.setImageResource(R.drawable.aj);
						break;
					case 8:
						iv17.setImageResource(R.drawable.aj);
						break;
					case 7:
						iv16.setImageResource(R.drawable.aj);
						break;
					case 6:
						iv15.setImageResource(R.drawable.aj);
						break;
					case 5:
						iv14.setImageResource(R.drawable.aj);
						break;
					case 4:
						iv13.setImageResource(R.drawable.aj);
						break;
					case 3:
						iv12.setImageResource(R.drawable.aj);
						break;
					case 2:
						iv11.setImageResource(R.drawable.aj);
						break;
					case 1:
						iv10.setImageResource(R.drawable.aj);
						break;
					}

				}
			}

			win_chk();
			winner();
			break;
		case R.id.ib11:
			k.setVisibility(View.INVISIBLE);
			llife_chk = true;
			for (loop = 0; loop < llen; loop++) {
				if (lpuzzle.charAt(loop) == 'k') {
					llife_chk = false;
					last_name[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv18.setImageResource(R.drawable.ak);
						break;
					case 8:
						iv17.setImageResource(R.drawable.ak);
						break;
					case 7:
						iv16.setImageResource(R.drawable.ak);
						break;
					case 6:
						iv15.setImageResource(R.drawable.ak);
						break;
					case 5:
						iv14.setImageResource(R.drawable.ak);
						break;
					case 4:
						iv13.setImageResource(R.drawable.ak);
						break;
					case 3:
						iv12.setImageResource(R.drawable.ak);
						break;
					case 2:
						iv11.setImageResource(R.drawable.ak);
						break;
					case 1:
						iv10.setImageResource(R.drawable.ak);
						break;
					}

				}
			}

			win_chk();
			winner();
			break;
		case R.id.ib12:
			l.setVisibility(View.INVISIBLE);
			llife_chk = true;
			for (loop = 0; loop < llen; loop++) {
				if (lpuzzle.charAt(loop) == 'l') {
					llife_chk = false;
					last_name[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv18.setImageResource(R.drawable.al);
						break;
					case 8:
						iv17.setImageResource(R.drawable.al);
						break;
					case 7:
						iv16.setImageResource(R.drawable.al);
						break;
					case 6:
						iv15.setImageResource(R.drawable.al);
						break;
					case 5:
						iv14.setImageResource(R.drawable.al);
						break;
					case 4:
						iv13.setImageResource(R.drawable.al);
						break;
					case 3:
						iv12.setImageResource(R.drawable.al);
						break;
					case 2:
						iv11.setImageResource(R.drawable.al);
						break;
					case 1:
						iv10.setImageResource(R.drawable.al);
						break;
					}

				}
			}

			win_chk();
			winner();
			break;
		case R.id.ib13:
			m.setVisibility(View.INVISIBLE);
			llife_chk = true;
			for (loop = 0; loop < llen; loop++) {
				if (lpuzzle.charAt(loop) == 'm') {
					llife_chk = false;
					last_name[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv18.setImageResource(R.drawable.am);
						break;
					case 8:
						iv17.setImageResource(R.drawable.am);
						break;
					case 7:
						iv16.setImageResource(R.drawable.am);
						break;
					case 6:
						iv15.setImageResource(R.drawable.am);
						break;
					case 5:
						iv14.setImageResource(R.drawable.am);
						break;
					case 4:
						iv13.setImageResource(R.drawable.am);
						break;
					case 3:
						iv12.setImageResource(R.drawable.am);
						break;
					case 2:
						iv11.setImageResource(R.drawable.am);
						break;
					case 1:
						iv10.setImageResource(R.drawable.am);
						break;
					}

				}
			}

			win_chk();
			winner();
			break;
		case R.id.ib14:
			n.setVisibility(View.INVISIBLE);
			llife_chk = true;
			for (loop = 0; loop < llen; loop++) {
				if (lpuzzle.charAt(loop) == 'n') {
					llife_chk = false;
					last_name[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv18.setImageResource(R.drawable.an);
						break;
					case 8:
						iv17.setImageResource(R.drawable.an);
						break;
					case 7:
						iv16.setImageResource(R.drawable.an);
						break;
					case 6:
						iv15.setImageResource(R.drawable.an);
						break;
					case 5:
						iv14.setImageResource(R.drawable.an);
						break;
					case 4:
						iv13.setImageResource(R.drawable.an);
						break;
					case 3:
						iv12.setImageResource(R.drawable.an);
						break;
					case 2:
						iv11.setImageResource(R.drawable.an);
						break;
					case 1:
						iv10.setImageResource(R.drawable.an);
						break;
					}

				}
			}

			win_chk();
			winner();
			break;
		case R.id.ib15:
			o.setVisibility(View.INVISIBLE);
			llife_chk = true;
			for (loop = 0; loop < llen; loop++) {
				if (lpuzzle.charAt(loop) == 'o') {
					llife_chk = false;
					last_name[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv18.setImageResource(R.drawable.ao);
						break;
					case 8:
						iv17.setImageResource(R.drawable.ao);
						break;
					case 7:
						iv16.setImageResource(R.drawable.ao);
						break;
					case 6:
						iv15.setImageResource(R.drawable.ao);
						break;
					case 5:
						iv14.setImageResource(R.drawable.ao);
						break;
					case 4:
						iv13.setImageResource(R.drawable.ao);
						break;
					case 3:
						iv12.setImageResource(R.drawable.ao);
						break;
					case 2:
						iv11.setImageResource(R.drawable.ao);
						break;
					case 1:
						iv10.setImageResource(R.drawable.ao);
						break;
					}

				}
			}

			win_chk();
			winner();
			break;
		case R.id.ib16:
			p.setVisibility(View.INVISIBLE);
			llife_chk = true;
			for (loop = 0; loop < llen; loop++) {
				if (lpuzzle.charAt(loop) == 'p') {
					llife_chk = false;
					last_name[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv18.setImageResource(R.drawable.ap);
						break;
					case 8:
						iv17.setImageResource(R.drawable.ap);
						break;
					case 7:
						iv16.setImageResource(R.drawable.ap);
						break;
					case 6:
						iv15.setImageResource(R.drawable.ap);
						break;
					case 5:
						iv14.setImageResource(R.drawable.ap);
						break;
					case 4:
						iv13.setImageResource(R.drawable.ap);
						break;
					case 3:
						iv12.setImageResource(R.drawable.ap);
						break;
					case 2:
						iv11.setImageResource(R.drawable.ap);
						break;
					case 1:
						iv10.setImageResource(R.drawable.ap);
						break;
					}

				}
			}

			win_chk();
			winner();
			break;
		case R.id.ib17:
			q.setVisibility(View.INVISIBLE);
			llife_chk = true;
			for (loop = 0; loop < llen; loop++) {
				if (lpuzzle.charAt(loop) == 'q') {
					llife_chk = false;
					last_name[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv18.setImageResource(R.drawable.aq);
						break;
					case 8:
						iv17.setImageResource(R.drawable.aq);
						break;
					case 7:
						iv16.setImageResource(R.drawable.aq);
						break;
					case 6:
						iv15.setImageResource(R.drawable.aq);
						break;
					case 5:
						iv14.setImageResource(R.drawable.aq);
						break;
					case 4:
						iv13.setImageResource(R.drawable.aq);
						break;
					case 3:
						iv12.setImageResource(R.drawable.aq);
						break;
					case 2:
						iv11.setImageResource(R.drawable.aq);
						break;
					case 1:
						iv10.setImageResource(R.drawable.aq);
						break;
					}

				}
			}

			win_chk();
			winner();
			break;
		case R.id.ib18:
			r.setVisibility(View.INVISIBLE);
			llife_chk = true;
			for (loop = 0; loop < llen; loop++) {
				if (lpuzzle.charAt(loop) == 'r') {
					llife_chk = false;
					last_name[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv18.setImageResource(R.drawable.ar);
						break;
					case 8:
						iv17.setImageResource(R.drawable.ar);
						break;
					case 7:
						iv16.setImageResource(R.drawable.ar);
						break;
					case 6:
						iv15.setImageResource(R.drawable.ar);
						break;
					case 5:
						iv14.setImageResource(R.drawable.ar);
						break;
					case 4:
						iv13.setImageResource(R.drawable.ar);
						break;
					case 3:
						iv12.setImageResource(R.drawable.ar);
						break;
					case 2:
						iv11.setImageResource(R.drawable.ar);
						break;
					case 1:
						iv10.setImageResource(R.drawable.ar);
						break;
					}

				}
			}

			win_chk();
			winner();
			break;
		case R.id.ib19:
			s.setVisibility(View.INVISIBLE);
			llife_chk = true;
			for (loop = 0; loop < llen; loop++) {
				if (lpuzzle.charAt(loop) == 's') {
					llife_chk = false;
					last_name[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv18.setImageResource(R.drawable.as);
						break;
					case 8:
						iv17.setImageResource(R.drawable.as);
						break;
					case 7:
						iv16.setImageResource(R.drawable.as);
						break;
					case 6:
						iv15.setImageResource(R.drawable.as);
						break;
					case 5:
						iv14.setImageResource(R.drawable.as);
						break;
					case 4:
						iv13.setImageResource(R.drawable.as);
						break;
					case 3:
						iv12.setImageResource(R.drawable.as);
						break;
					case 2:
						iv11.setImageResource(R.drawable.as);
						break;
					case 1:
						iv10.setImageResource(R.drawable.as);
						break;
					}

				}
			}

			win_chk();
			winner();
			break;
		case R.id.ib20:
			t.setVisibility(View.INVISIBLE);
			llife_chk = true;
			for (loop = 0; loop < llen; loop++) {
				if (lpuzzle.charAt(loop) == 't') {
					llife_chk = false;
					last_name[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv18.setImageResource(R.drawable.at);
						break;
					case 8:
						iv17.setImageResource(R.drawable.at);
						break;
					case 7:
						iv16.setImageResource(R.drawable.at);
						break;
					case 6:
						iv15.setImageResource(R.drawable.at);
						break;
					case 5:
						iv14.setImageResource(R.drawable.at);
						break;
					case 4:
						iv13.setImageResource(R.drawable.at);
						break;
					case 3:
						iv12.setImageResource(R.drawable.at);
						break;
					case 2:
						iv11.setImageResource(R.drawable.at);
						break;
					case 1:
						iv10.setImageResource(R.drawable.at);
						break;
					}

				}
			}

			win_chk();
			winner();
			break;
		case R.id.ib21:
			u.setVisibility(View.INVISIBLE);
			llife_chk = true;
			for (loop = 0; loop < llen; loop++) {
				if (lpuzzle.charAt(loop) == 'u') {
					llife_chk = false;
					last_name[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv18.setImageResource(R.drawable.au);
						break;
					case 8:
						iv17.setImageResource(R.drawable.au);
						break;
					case 7:
						iv16.setImageResource(R.drawable.au);
						break;
					case 6:
						iv15.setImageResource(R.drawable.au);
						break;
					case 5:
						iv14.setImageResource(R.drawable.au);
						break;
					case 4:
						iv13.setImageResource(R.drawable.au);
						break;
					case 3:
						iv12.setImageResource(R.drawable.au);
						break;
					case 2:
						iv11.setImageResource(R.drawable.au);
						break;
					case 1:
						iv10.setImageResource(R.drawable.au);
						break;
					}

				}
			}

			win_chk();
			winner();
			break;
		case R.id.ib22:
			v.setVisibility(View.INVISIBLE);
			llife_chk = true;
			for (loop = 0; loop < llen; loop++) {
				if (lpuzzle.charAt(loop) == 'v') {
					llife_chk = false;
					last_name[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv18.setImageResource(R.drawable.av);
						break;
					case 8:
						iv17.setImageResource(R.drawable.av);
						break;
					case 7:
						iv16.setImageResource(R.drawable.av);
						break;
					case 6:
						iv15.setImageResource(R.drawable.av);
						break;
					case 5:
						iv14.setImageResource(R.drawable.av);
						break;
					case 4:
						iv13.setImageResource(R.drawable.av);
						break;
					case 3:
						iv12.setImageResource(R.drawable.av);
						break;
					case 2:
						iv11.setImageResource(R.drawable.av);
						break;
					case 1:
						iv10.setImageResource(R.drawable.av);
						break;
					}

				}
			}

			win_chk();
			winner();
			break;
		case R.id.ib23:
			llife_chk = true;
			w.setVisibility(View.INVISIBLE);
			for (loop = 0; loop < llen; loop++) {
				if (lpuzzle.charAt(loop) == 'w') {
					llife_chk = false;
					last_name[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv18.setImageResource(R.drawable.aw);
						break;
					case 8:
						iv17.setImageResource(R.drawable.aw);
						break;
					case 7:
						iv16.setImageResource(R.drawable.aw);
						break;
					case 6:
						iv15.setImageResource(R.drawable.aw);
						break;
					case 5:
						iv14.setImageResource(R.drawable.aw);
						break;
					case 4:
						iv13.setImageResource(R.drawable.aw);
						break;
					case 3:
						iv12.setImageResource(R.drawable.aw);
						break;
					case 2:
						iv11.setImageResource(R.drawable.aw);
						break;
					case 1:
						iv10.setImageResource(R.drawable.aw);
						break;
					}

				}
			}

			win_chk();
			winner();
			break;
		case R.id.ib24:
			x.setVisibility(View.INVISIBLE);
			llife_chk = true;
			for (loop = 0; loop < llen; loop++) {
				if (lpuzzle.charAt(loop) == 'x') {
					llife_chk = false;
					last_name[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv18.setImageResource(R.drawable.ax);
						break;
					case 8:
						iv17.setImageResource(R.drawable.ax);
						break;
					case 7:
						iv16.setImageResource(R.drawable.ax);
						break;
					case 6:
						iv15.setImageResource(R.drawable.ax);
						break;
					case 5:
						iv14.setImageResource(R.drawable.ax);
						break;
					case 4:
						iv13.setImageResource(R.drawable.ax);
						break;
					case 3:
						iv12.setImageResource(R.drawable.ax);
						break;
					case 2:
						iv11.setImageResource(R.drawable.ax);
						break;
					case 1:
						iv10.setImageResource(R.drawable.ax);
						break;
					}

				}
			}

			win_chk();
			winner();
			break;
		case R.id.ib25:
			y.setVisibility(View.INVISIBLE);
			llife_chk = true;
			for (loop = 0; loop < llen; loop++) {
				if (lpuzzle.charAt(loop) == 'y') {
					llife_chk = false;
					last_name[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv18.setImageResource(R.drawable.ay);
						break;
					case 8:
						iv17.setImageResource(R.drawable.ay);
						break;
					case 7:
						iv16.setImageResource(R.drawable.ay);
						break;
					case 6:
						iv15.setImageResource(R.drawable.ay);
						break;
					case 5:
						iv14.setImageResource(R.drawable.ay);
						break;
					case 4:
						iv13.setImageResource(R.drawable.ay);
						break;
					case 3:
						iv12.setImageResource(R.drawable.ay);
						break;
					case 2:
						iv11.setImageResource(R.drawable.ay);
						break;
					case 1:
						iv10.setImageResource(R.drawable.ay);
						break;
					}

				}
			}

			win_chk();
			winner();
			break;
		case R.id.ib26:
			z.setVisibility(View.INVISIBLE);
			llife_chk = true;
			for (loop = 0; loop < llen; loop++) {
				if (lpuzzle.charAt(loop) == 'z') {
					llife_chk = false;
					last_name[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv18.setImageResource(R.drawable.az);
						break;
					case 8:
						iv17.setImageResource(R.drawable.az);
						break;
					case 7:
						iv16.setImageResource(R.drawable.az);
						break;
					case 6:
						iv15.setImageResource(R.drawable.az);
						break;
					case 5:
						iv14.setImageResource(R.drawable.az);
						break;
					case 4:
						iv13.setImageResource(R.drawable.az);
						break;
					case 3:
						iv12.setImageResource(R.drawable.az);
						break;
					case 2:
						iv11.setImageResource(R.drawable.az);
						break;
					case 1:
						iv10.setImageResource(R.drawable.az);
						break;
					}

				}
			}

			win_chk();
			winner();
			break;

		}
	}

	void life() {
		if ((flife_chk == true) && (llife_chk == true)) {
			life_chk = true;
			lives--;
			switch (lives) {
			case 2:
				// l3.setVisibility(View.INVISIBLE);
				l1.setImageResource(R.drawable.cross);
				wrong.start();
				break;
			case 1:
				// l2.setVisibility(View.INVISIBLE);
				l2.setImageResource(R.drawable.cross);
				wrong.start();
				break;
			case 0:
				// l1.setVisibility(View.INVISIBLE);
				l3.setImageResource(R.drawable.cross);
				game_over.setText("Game Over");
				wrong.start();
				break;
			}
		} else {
			life_chk = false;
			correct.start();
		}

	}

	public void entry() {
		if (Info.challenge == true) {
			fpuzzle = Info.fpuzzle.toLowerCase();
			lpuzzle = Info.lpuzzle.toLowerCase();
			description.setText("" + Info.description);
		} else if (Info.play == true) {
			rand = rad.nextInt(range);
			// fpuzzle = "Rishi".toLowerCase();
			// lpuzzle = "Sharma".toLowerCase();
			fpuzzle = Info.fname[rand].toLowerCase();
			lpuzzle = Info.lname[rand].toLowerCase();
			description.setText("" + Info.des_name[rand]);

		}
		flen = fpuzzle.length();
		llen = lpuzzle.length();
	}

	public void hint() {
		Random rad = new Random();
		int rand;
		boolean chk_hint = true;
		View ch;
		char h_ch;
		if (rad.nextBoolean() == true) {
			do {
				rand = rad.nextInt(flen);
				if (first_name[flen - 1] == 0) {
					chk_hint = false;
					h_ch = fpuzzle.charAt(rand);
					ch = view_pass(h_ch);
					first_name_click(ch);
					last_name_click(ch);
				}
			} while (chk_hint == true);
			/*
			 * rand = rad.nextInt(flen); if (first_name[flen - 1] == 0) { //
			 * chk_hint = false; h_ch = fpuzzle.charAt(rand);
			 * 
			 * for (int i = 0; i < flen; i++) { if (fpuzzle.charAt(i) == h_ch) {
			 * ch = view_pass(h_ch); first_name_click(ch); last_name_click(ch);
			 * } } } else if (first_name[flen - 1] == 1) { for (int j = 0; j <
			 * flen; j++) { if (first_name[j] == 0) { // if(rad.nextBoolean()){
			 * h_ch = fpuzzle.charAt(j); ch = view_pass(h_ch);
			 * first_name_click(ch); last_name_click(ch); // } } else {
			 * continue; } } }
			 */
		} else {
			do {
				rand = rad.nextInt(llen);
				if (last_name[rand] == 0) {
					chk_hint = false;
					h_ch = lpuzzle.charAt(rand);
					ch = view_pass(h_ch);
					first_name_click(ch);
					last_name_click(ch);
				}
			} while (chk_hint == true);
			/*
			 * rand = rad.nextInt(llen); if (last_name[llen - 1] == 0) { //
			 * chk_hint = false; h_ch = lpuzzle.charAt(rand);
			 * 
			 * for (int i = 0; i < llen; i++) { if (lpuzzle.charAt(i) == h_ch) {
			 * ch = view_pass(h_ch); first_name_click(ch); last_name_click(ch);
			 * } } } else if (last_name[llen - 1] == 1) { for (int j = 0; j <
			 * llen; j++) { if (last_name[j] == 0) { // if(rad.nextBoolean()){
			 * h_ch = lpuzzle.charAt(j); ch = view_pass(h_ch);
			 * first_name_click(ch); last_name_click(ch); // } } else {
			 * continue; } } }
			 */
		}

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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		interstitial = new InterstitialAd(this);
		interstitial.setAdUnitId(getResources().getString(
				R.string.ad_interstitial));
		AdRequest adRequest = new AdRequest.Builder().build();
		interstitial.loadAd(adRequest);
		interstitial.setAdListener(new AdListener() {
			@Override
			public void onAdLoaded() {
				Toast.makeText(NamePlay.this, "Hint Button is now Available",
						Toast.LENGTH_SHORT).show();
				word_hint.setEnabled(true);
			}

			@Override
			public void onAdClosed() {
				// Proceed to the next level.
				hint();
			}
		});

		setContentView(R.layout.nameplay);
		Menu.gateway = 2;

		iv1 = (ImageView) findViewById(R.id.f1);
		iv2 = (ImageView) findViewById(R.id.f2);
		iv3 = (ImageView) findViewById(R.id.f3);
		iv4 = (ImageView) findViewById(R.id.f4);
		iv5 = (ImageView) findViewById(R.id.f5);
		iv6 = (ImageView) findViewById(R.id.f6);
		iv7 = (ImageView) findViewById(R.id.f7);
		iv8 = (ImageView) findViewById(R.id.f8);
		iv9 = (ImageView) findViewById(R.id.f9);
		iv10 = (ImageView) findViewById(R.id.f10);
		iv11 = (ImageView) findViewById(R.id.f11);
		iv12 = (ImageView) findViewById(R.id.f12);
		iv13 = (ImageView) findViewById(R.id.f13);
		iv14 = (ImageView) findViewById(R.id.f14);
		iv15 = (ImageView) findViewById(R.id.f15);
		iv16 = (ImageView) findViewById(R.id.f16);
		iv17 = (ImageView) findViewById(R.id.f17);
		iv18 = (ImageView) findViewById(R.id.f18);

		l1 = (ImageView) findViewById(R.id.life_1);
		l2 = (ImageView) findViewById(R.id.life_2);
		l3 = (ImageView) findViewById(R.id.life_3);

		a = (ImageButton) findViewById(R.id.ib1);
		b = (ImageButton) findViewById(R.id.ib2);
		c = (ImageButton) findViewById(R.id.ib3);
		d = (ImageButton) findViewById(R.id.ib4);
		e = (ImageButton) findViewById(R.id.ib5);
		f = (ImageButton) findViewById(R.id.ib6);
		g = (ImageButton) findViewById(R.id.ib7);
		h = (ImageButton) findViewById(R.id.ib8);
		i = (ImageButton) findViewById(R.id.ib9);
		j = (ImageButton) findViewById(R.id.ib10);
		k = (ImageButton) findViewById(R.id.ib11);
		l = (ImageButton) findViewById(R.id.ib12);
		m = (ImageButton) findViewById(R.id.ib13);
		n = (ImageButton) findViewById(R.id.ib14);
		o = (ImageButton) findViewById(R.id.ib15);
		p = (ImageButton) findViewById(R.id.ib16);
		q = (ImageButton) findViewById(R.id.ib17);
		r = (ImageButton) findViewById(R.id.ib18);
		s = (ImageButton) findViewById(R.id.ib19);
		t = (ImageButton) findViewById(R.id.ib20);
		u = (ImageButton) findViewById(R.id.ib21);
		v = (ImageButton) findViewById(R.id.ib22);
		w = (ImageButton) findViewById(R.id.ib23);
		x = (ImageButton) findViewById(R.id.ib24);
		y = (ImageButton) findViewById(R.id.ib25);
		z = (ImageButton) findViewById(R.id.ib26);

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

		txt_hint = (TextView) findViewById(R.id.txt_hint);
		description = (TextView) findViewById(R.id.txt_des);
		game_over = (TextView) findViewById(R.id.textView2);
		wrong = MediaPlayer.create(NamePlay.this, R.raw.wrong);
		correct = MediaPlayer.create(NamePlay.this, R.raw.correct);

		entry();
		visible_box();

	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		first_name_click(view);
		last_name_click(view);
		if (view.getId() != word_hint.getId()) {
			life();
			hint_text();
		}

		winner();

	}

}
