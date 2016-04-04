package com.rsp.rishi;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.VideoView;

public class Splash extends Activity {

	MediaPlayer splashsound;
	//VideoView vid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN	, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.splash);
		//vid =(VideoView) findViewById(R.id.videoView1);
		//vid.setBackgroundResource(R.raw.video);
		//vid.start();
		splashsound = MediaPlayer.create(Splash.this, R.raw.splashsound);
		splashsound.start();
		
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(5000);

				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent openfirstappactivity = new Intent(
							"com.rsp.rishi.MENU");
					startActivity(openfirstappactivity);

				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		splashsound.release();
		//vid.stopPlayback();
		
		finish();
	}

}
