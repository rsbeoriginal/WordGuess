package com.rsp.rishi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Career extends Activity implements OnClickListener {

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	Button bt_continue, bt_submit;
	EditText txt_name;
	TextView txt_err;

	void initialize() {
		bt_continue = (Button) findViewById(R.id.car_continue);
		bt_submit = (Button) findViewById(R.id.car_submit);
		txt_name = (EditText) findViewById(R.id.car_name);
		txt_err=(TextView) findViewById(R.id.car_error);
	}
	void show_continue(){
		if (Info.car_name=="NIL"){
			bt_continue.setVisibility(View.GONE);
		}else{
			bt_continue.setText("Continue as "+Info.car_name);
		}
	}
	void validation(){
		if (txt_name.length()==0){
			txt_err.setText("Please! Enter your Name!");
		}else{
			txt_err.setText("");
			Info.car=true;
			Info.car_name=txt_name.getText().toString();
			for (int i=0;i<30;i++){
				Info.level_1[i]=0;
			}
			Info.startcareer=false;
			Car_Level.finish=true;
			
			finish();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.career_dia);
		initialize();
		show_continue();
		bt_continue.setOnClickListener(this);
		bt_submit.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		
		case R.id.car_continue:
			Car_Level.finish=true;
			Info.startcareer=false;
			finish();
			break;
		case R.id.car_submit:validation();
			
			break;
		}
	}

}
