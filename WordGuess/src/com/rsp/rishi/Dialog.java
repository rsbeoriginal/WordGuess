package com.rsp.rishi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Dialog extends Activity {

	Button bt_ok;
	TextView dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog);
		bt_ok = (Button) findViewById(R.id.bt_dialog);
		dialog = (TextView) findViewById(R.id.txt_dialog);

		

		if (Info.name_dialog == true) {
			switch (Info.err_no) {
			case 1:
				dialog.setText("Please enter a Name!");
				break;
			case 2:
				dialog.setText("Please enter a First Name!");
				break;
			case 3:
				dialog.setText("Please enter a Last Name!");
				break;
			case 4:
				dialog.setText("Please enter a Description!");
				break;
			case 5:
				dialog.setText("Please enter a First and Last Name within 9 Letters!");
				break;
			case 6:
				dialog.setText("Please enter a First Name within 9 Letters!");
				break;
			case 7:
				dialog.setText("Please enter a Last Name within 9 Letters!");
				break;
			case 8:
				dialog.setText("First Name contains a space.Please enter again!");
				break;
			case 9:
				dialog.setText("First Name contains a number.Please enter again!");
				break;
			case 10:
				dialog.setText("First Name contains special Characters.Please enter again!");
				break;
			case 11:
				dialog.setText("Last Name contains a space.Please enter again!");
				break;
			case 12:
				dialog.setText("Last Name contains a number.Please enter again!");
				break;
			case 13:
				dialog.setText("Last Name contains special Characters.Please enter again!");
				break;
			}

		} else if (Info.word_dialog == true) {
			switch (Info.err_no) {
			case 1:
				dialog.setText("Please enter a word with Max Word Length of 9");
				break;
			case 2:
				dialog.setText("Your description of the word is empty");
				break;
			case 3:
				dialog.setText("Your word contains a space.Please enter another word!");
				break;
			case 4:
				dialog.setText("Your word contains a contains a number.Please enter another word!");
				break;
			case 5:
				dialog.setText("Your word contains a contains a special character.Please enter another word!");
				break;
			case 6:
				dialog.setText("Word Length Exceeds 9");
				break;
				
			}

		}

		bt_ok.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

}
