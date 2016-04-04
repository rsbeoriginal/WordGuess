package com.rsp.rishi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Car_Level extends Activity {

	//static boolean startcareer;
	TextView txt_name;
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		if (Info.car_name=="NIL"){
			txt_name.setText("Welcome");
			
		}else {
			txt_name.setText("Welcome "+Info.car_name+",");
		}
		//if (Info.car_name == "NIL") {
			//finish();
		//}
	}

	static boolean finish = false;

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		if (finish == true) {
			finish();
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.car_level);
		txt_name=(TextView) findViewById(R.id.txt_car_name);
		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new ImageAdapter(this));
		if (Info.car_name=="NIL"){
			txt_name.setText("Welcome");
			//Info.startcareer=true;
		}else {
			txt_name.setText("Welcome "+Info.car_name+",");
			//Info.startcareer=false;
		}
		/*Intent career = new Intent("com.rsp.rishi.CAREER");
		finish = false;
		if (Info.car_name=="NIL"){
			txt_name.setText("Welcome");
			Info.startcareer=true;
		}else {
			txt_name.setText("Welcome "+Info.car_name+",");
			Info.startcareer=false;
		}
		if (Info.startcareer=true){
			startActivity(career);
		}else if (Info.car_name=="NIL"){
			finish();
		}*/
		gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				// TODO Auto-generated method stub

				Info.car_level=position;
				
				Info.career=true;
				Info.challenge=false;
				Info.play=false;
				
				Toast.makeText(Car_Level.this, "" + (position+1),
						Toast.LENGTH_SHORT).show();
				
				Intent play=new Intent("com.rsp.rishi.WORDGUESS");
				startActivity(play);
				
			}

		});
	}

}
