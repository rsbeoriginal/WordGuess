package com.rsp.rishi;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class Car_menu extends Activity {

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if (Info.car_name=="NIL"){
			txt_name.setText("Welcome");
			
		}else {
			txt_name.setText("Welcome "+Info.car_name+",");
		}
	}

	String[] list = { "Scene 1", "Scene 2" };
	String[] action = { "Car_Level" };
	TextView txt_name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.car_menu);
		txt_name = (TextView) findViewById(R.id.txt_car_name);
		ListView menu = (ListView) findViewById(R.id.listView1);
		menu.setAdapter(new ArrayAdapter<String>(Car_menu.this,
				android.R.layout.simple_list_item_1, list));
		menu.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				// TODO Auto-generated method stub

				try {
					String act = action[position].toUpperCase();
					Intent ourIntent = new Intent("com.rsp.rishi." + act);
					startActivity(ourIntent);
					Info.car_scene=position;
				} catch (ActivityNotFoundException e) {
					e.printStackTrace();
				}
			}
		});

		
		Intent career = new Intent("com.rsp.rishi.CAREER");
		
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
		}
	}

}
