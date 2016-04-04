package com.rsp.rishi;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class WordGuessPlay extends Activity implements OnClickListener{
	
	String[] word={"Sprint"};
	String[] des={"Running very fast"};	
	
	Intent ourIntent=new Intent("com.rsp.rishi.GAMEOVER");
public void win_chk(){
		
		for (int i=0;i<len;i++)
		{
			if (place_filled[i]==1)
			{
				win=true;
			}else {
				win=false;
				break;
			}
		}
	}
	public void winner(){
		 
		if (win==true){
			game_over.setText("Great Guessing! You Won!");
			//txt_result.setText("Great Guessing! You Won!");
			try {
				startActivity(ourIntent);
			}catch(ActivityNotFoundException e){
				e.printStackTrace();
			}
		}else if (game_over.getText().toString()=="Game Over"){
			//txt_result.setText("Great Guessing! You Won!");
			try {
				startActivity(ourIntent);
			}catch(ActivityNotFoundException e){
				e.printStackTrace();
			}
		}
	}

	ImageButton a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;
	TableLayout tb;
	TableRow life;
	Button submit;
	ImageView iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8,iv9,l1,l2,l3;	
	EditText txt;
	TextView err,game_over,txt_result,description;
	int len,lives=3,loop;
	boolean life_chk,play_chk,win=false;
	String puzzle;
	int[] place_filled={0,0,0,0,0,0,0,0,0};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.main);
	       
	        
	        a=(ImageButton) findViewById(R.id.imageButton1);
	        b=(ImageButton) findViewById(R.id.imageButton2);
	        c=(ImageButton) findViewById(R.id.imageButton3);
	        d=(ImageButton) findViewById(R.id.imageButton4);
	        e=(ImageButton) findViewById(R.id.imageButton5);
	        f=(ImageButton) findViewById(R.id.imageButton6);
	        g=(ImageButton) findViewById(R.id.imageButton7);
	        h=(ImageButton) findViewById(R.id.imageButton8);
	        i=(ImageButton) findViewById(R.id.imageButton9);
	        j=(ImageButton) findViewById(R.id.imageButton10);
	        k=(ImageButton) findViewById(R.id.imageButton11);
	        l=(ImageButton) findViewById(R.id.imageButton12);
	        m=(ImageButton) findViewById(R.id.imageButton13);
	        n=(ImageButton) findViewById(R.id.imageButton14);
	        o=(ImageButton) findViewById(R.id.imageButton15);
	        p=(ImageButton) findViewById(R.id.imageButton16);
	        q=(ImageButton) findViewById(R.id.imageButton17);
	        r=(ImageButton) findViewById(R.id.imageButton18);
	        s=(ImageButton) findViewById(R.id.imageButton19);
	        t=(ImageButton) findViewById(R.id.imageButton20);
	        u=(ImageButton) findViewById(R.id.imageButton21);
	        v=(ImageButton) findViewById(R.id.imageButton22);
	        w=(ImageButton) findViewById(R.id.imageButton23);
	        x=(ImageButton) findViewById(R.id.imageButton24);
	        y=(ImageButton) findViewById(R.id.imageButton25);
	        z=(ImageButton) findViewById(R.id.imageButton26);
	        
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
	               
	        
	        iv1=(ImageView) findViewById(R.id.imageView1);
	        iv2=(ImageView) findViewById(R.id.imageView2);
	        iv3=(ImageView) findViewById(R.id.imageView3);
	        iv4=(ImageView) findViewById(R.id.imageView4);
	        iv5=(ImageView) findViewById(R.id.imageView5);
	        iv6=(ImageView) findViewById(R.id.imageView6);
	        iv7=(ImageView) findViewById(R.id.imageView7);
	        iv8=(ImageView) findViewById(R.id.imageView8);
	        iv9=(ImageView) findViewById(R.id.imageView9);
	        
	        l1=(ImageView) findViewById(R.id.imageView10);
	        l2=(ImageView) findViewById(R.id.imageView11);
	        l3=(ImageView) findViewById(R.id.imageView12);
	        
	        txt=(EditText) findViewById(R.id.editText1);
	        err=(TextView) findViewById(R.id.textView1);
	        game_over=(TextView) findViewById(R.id.textView2);
	        submit=(Button) findViewById(R.id.button1);
	        life=(TableRow) findViewById(R.id.tableRow7);
	        tb=(TableLayout) findViewById(R.id.tableLayout1);
	        txt_result=(TextView) findViewById(R.id.txt_result);
	        description=(TextView) findViewById(R.id.txt_des);
		
		
		
		puzzle=word[0].toLowerCase();
		description.setText(""+des[0]);
		
	    len=puzzle.length();
        switch(len){
		case 9:iv9.setVisibility(View.VISIBLE);
		case 8:iv8.setVisibility(View.VISIBLE);
		case 7:iv7.setVisibility(View.VISIBLE);
		case 6:iv6.setVisibility(View.VISIBLE);
		case 5:iv5.setVisibility(View.VISIBLE);
		case 4:iv4.setVisibility(View.VISIBLE);
		case 3:iv3.setVisibility(View.VISIBLE);
		case 2:iv2.setVisibility(View.VISIBLE);
		case 1:iv1.setVisibility(View.VISIBLE);
		}
        switch(len+1){
        case 1:iv1.setVisibility(View.GONE);
		case 2:iv2.setVisibility(View.GONE);
		case 3:iv3.setVisibility(View.GONE);
		case 4:iv4.setVisibility(View.GONE);
		case 5:iv5.setVisibility(View.GONE);
		case 6:iv6.setVisibility(View.GONE);
		case 7:iv7.setVisibility(View.GONE);
		case 8:iv8.setVisibility(View.GONE);
		case 9:iv9.setVisibility(View.GONE);        
        }
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.imageButton1:
			a.setVisibility(View.INVISIBLE);
			life_chk = true;
			for (loop = 0; loop < len; loop++) {
				if (puzzle.charAt(loop) == 'a') {
					life_chk = false;
					place_filled[loop] = 1;
					switch (loop + 1) {
					case 9:
						iv9.setImageResource(R.drawable.a);
						break;
					case 8:
						iv8.setImageResource(R.drawable.a);
						break;
					case 7:
						iv7.setImageResource(R.drawable.a);
						break;
					case 6:
						iv6.setImageResource(R.drawable.a);
						break;
					case 5:
						iv5.setImageResource(R.drawable.a);
						break;
					case 4:
						iv4.setImageResource(R.drawable.a);
						break;
					case 3:
						iv3.setImageResource(R.drawable.a);
						break;
					case 2:
						iv2.setImageResource(R.drawable.a);
						break;
					case 1:
						iv1.setImageResource(R.drawable.a);
						break;
					}

				}
			}
			if (life_chk == true) {
				lives--;
				switch (lives) {
				case 2:
					l3.setVisibility(View.INVISIBLE);
					break;
				case 1:
					l2.setVisibility(View.INVISIBLE);
					break;
				case 0:
					l1.setVisibility(View.INVISIBLE);
					game_over.setText("Game Over");
					break;
				}
			}
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
						iv9.setImageResource(R.drawable.b);
						break;
					case 8:
						iv8.setImageResource(R.drawable.b);
						break;
					case 7:
						iv7.setImageResource(R.drawable.b);
						break;
					case 6:
						iv6.setImageResource(R.drawable.b);
						break;
					case 5:
						iv5.setImageResource(R.drawable.b);
						break;
					case 4:
						iv4.setImageResource(R.drawable.b);
						break;
					case 3:
						iv3.setImageResource(R.drawable.b);
						break;
					case 2:
						iv2.setImageResource(R.drawable.b);
						break;
					case 1:
						iv1.setImageResource(R.drawable.b);
						break;
					}

				}

			}
			if (life_chk == true) {
				lives--;
				switch (lives) {
				case 2:
					l3.setVisibility(View.INVISIBLE);
					break;
				case 1:
					l2.setVisibility(View.INVISIBLE);
					break;
				case 0:
					l1.setVisibility(View.INVISIBLE);
					game_over.setText("Game Over");
					break;
				}
			}
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
						iv9.setImageResource(R.drawable.c);
						break;
					case 8:
						iv8.setImageResource(R.drawable.c);
						break;
					case 7:
						iv7.setImageResource(R.drawable.c);
						break;
					case 6:
						iv6.setImageResource(R.drawable.c);
						break;
					case 5:
						iv5.setImageResource(R.drawable.c);
						break;
					case 4:
						iv4.setImageResource(R.drawable.c);
						break;
					case 3:
						iv3.setImageResource(R.drawable.c);
						break;
					case 2:
						iv2.setImageResource(R.drawable.c);
						break;
					case 1:
						iv1.setImageResource(R.drawable.c);
						break;
					}

				}
			}
			if (life_chk == true) {
				lives--;
				switch (lives) {
				case 2:
					l3.setVisibility(View.INVISIBLE);
					break;
				case 1:
					l2.setVisibility(View.INVISIBLE);
					break;
				case 0:
					l1.setVisibility(View.INVISIBLE);
					game_over.setText("Game Over");
					break;
				}
			}
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
						iv9.setImageResource(R.drawable.d);
						break;
					case 8:
						iv8.setImageResource(R.drawable.d);
						break;
					case 7:
						iv7.setImageResource(R.drawable.d);
						break;
					case 6:
						iv6.setImageResource(R.drawable.d);
						break;
					case 5:
						iv5.setImageResource(R.drawable.d);
						break;
					case 4:
						iv4.setImageResource(R.drawable.d);
						break;
					case 3:
						iv3.setImageResource(R.drawable.d);
						break;
					case 2:
						iv2.setImageResource(R.drawable.d);
						break;
					case 1:
						iv1.setImageResource(R.drawable.d);
						break;
					}

				}
			}
			if (life_chk == true) {
				lives--;
				switch (lives) {
				case 2:
					l3.setVisibility(View.INVISIBLE);
					break;
				case 1:
					l2.setVisibility(View.INVISIBLE);
					break;
				case 0:
					l1.setVisibility(View.INVISIBLE);
					game_over.setText("Game Over");
					break;
				}
			}
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
						iv9.setImageResource(R.drawable.e);
						break;
					case 8:
						iv8.setImageResource(R.drawable.e);
						break;
					case 7:
						iv7.setImageResource(R.drawable.e);
						break;
					case 6:
						iv6.setImageResource(R.drawable.e);
						break;
					case 5:
						iv5.setImageResource(R.drawable.e);
						break;
					case 4:
						iv4.setImageResource(R.drawable.e);
						break;
					case 3:
						iv3.setImageResource(R.drawable.e);
						break;
					case 2:
						iv2.setImageResource(R.drawable.e);
						break;
					case 1:
						iv1.setImageResource(R.drawable.e);
						break;
					}

				}
			}
			if (life_chk == true) {
				lives--;
				switch (lives) {
				case 2:
					l3.setVisibility(View.INVISIBLE);
					break;
				case 1:
					l2.setVisibility(View.INVISIBLE);
					break;
				case 0:
					l1.setVisibility(View.INVISIBLE);
					game_over.setText("Game Over");
					break;
				}
			}
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
						iv9.setImageResource(R.drawable.f);
						break;
					case 8:
						iv8.setImageResource(R.drawable.f);
						break;
					case 7:
						iv7.setImageResource(R.drawable.f);
						break;
					case 6:
						iv6.setImageResource(R.drawable.f);
						break;
					case 5:
						iv5.setImageResource(R.drawable.f);
						break;
					case 4:
						iv4.setImageResource(R.drawable.f);
						break;
					case 3:
						iv3.setImageResource(R.drawable.f);
						break;
					case 2:
						iv2.setImageResource(R.drawable.f);
						break;
					case 1:
						iv1.setImageResource(R.drawable.f);
						break;
					}

				}
			}
			if (life_chk == true) {
				lives--;
				switch (lives) {
				case 2:
					l3.setVisibility(View.INVISIBLE);
					break;
				case 1:
					l2.setVisibility(View.INVISIBLE);
					break;
				case 0:
					l1.setVisibility(View.INVISIBLE);
					game_over.setText("Game Over");
					break;
				}
			}
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
						iv9.setImageResource(R.drawable.g);
						break;
					case 8:
						iv8.setImageResource(R.drawable.g);
						break;
					case 7:
						iv7.setImageResource(R.drawable.g);
						break;
					case 6:
						iv6.setImageResource(R.drawable.g);
						break;
					case 5:
						iv5.setImageResource(R.drawable.g);
						break;
					case 4:
						iv4.setImageResource(R.drawable.g);
						break;
					case 3:
						iv3.setImageResource(R.drawable.g);
						break;
					case 2:
						iv2.setImageResource(R.drawable.g);
						break;
					case 1:
						iv1.setImageResource(R.drawable.g);
						break;
					}

				}
			}
			if (life_chk == true) {
				lives--;
				switch (lives) {
				case 2:
					l3.setVisibility(View.INVISIBLE);
					break;
				case 1:
					l2.setVisibility(View.INVISIBLE);
					break;
				case 0:
					l1.setVisibility(View.INVISIBLE);
					game_over.setText("Game Over");
					break;
				}
			}
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
						iv9.setImageResource(R.drawable.h);
						break;
					case 8:
						iv8.setImageResource(R.drawable.h);
						break;
					case 7:
						iv7.setImageResource(R.drawable.h);
						break;
					case 6:
						iv6.setImageResource(R.drawable.h);
						break;
					case 5:
						iv5.setImageResource(R.drawable.h);
						break;
					case 4:
						iv4.setImageResource(R.drawable.h);
						break;
					case 3:
						iv3.setImageResource(R.drawable.h);
						break;
					case 2:
						iv2.setImageResource(R.drawable.h);
						break;
					case 1:
						iv1.setImageResource(R.drawable.h);
						break;
					}

				}
			}
			if (life_chk == true) {
				lives--;
				switch (lives) {
				case 2:
					l3.setVisibility(View.INVISIBLE);
					break;
				case 1:
					l2.setVisibility(View.INVISIBLE);
					break;
				case 0:
					l1.setVisibility(View.INVISIBLE);
					game_over.setText("Game Over");
					break;
				}
			}
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
						iv9.setImageResource(R.drawable.i);
						break;
					case 8:
						iv8.setImageResource(R.drawable.i);
						break;
					case 7:
						iv7.setImageResource(R.drawable.i);
						break;
					case 6:
						iv6.setImageResource(R.drawable.i);
						break;
					case 5:
						iv5.setImageResource(R.drawable.i);
						break;
					case 4:
						iv4.setImageResource(R.drawable.i);
						break;
					case 3:
						iv3.setImageResource(R.drawable.i);
						break;
					case 2:
						iv2.setImageResource(R.drawable.i);
						break;
					case 1:
						iv1.setImageResource(R.drawable.i);
						break;
					}

				}
			}
			if (life_chk == true) {
				lives--;
				switch (lives) {
				case 2:
					l3.setVisibility(View.INVISIBLE);
					break;
				case 1:
					l2.setVisibility(View.INVISIBLE);
					break;
				case 0:
					l1.setVisibility(View.INVISIBLE);
					game_over.setText("Game Over");
					break;
				}
			}
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
						iv9.setImageResource(R.drawable.j);
						break;
					case 8:
						iv8.setImageResource(R.drawable.j);
						break;
					case 7:
						iv7.setImageResource(R.drawable.j);
						break;
					case 6:
						iv6.setImageResource(R.drawable.j);
						break;
					case 5:
						iv5.setImageResource(R.drawable.j);
						break;
					case 4:
						iv4.setImageResource(R.drawable.j);
						break;
					case 3:
						iv3.setImageResource(R.drawable.j);
						break;
					case 2:
						iv2.setImageResource(R.drawable.j);
						break;
					case 1:
						iv1.setImageResource(R.drawable.j);
						break;
					}

				}
			}
			if (life_chk == true) {
				lives--;
				switch (lives) {
				case 2:
					l3.setVisibility(View.INVISIBLE);
					break;
				case 1:
					l2.setVisibility(View.INVISIBLE);
					break;
				case 0:
					l1.setVisibility(View.INVISIBLE);
					game_over.setText("Game Over");
					break;
				}
			}
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
						iv9.setImageResource(R.drawable.k);
						break;
					case 8:
						iv8.setImageResource(R.drawable.k);
						break;
					case 7:
						iv7.setImageResource(R.drawable.k);
						break;
					case 6:
						iv6.setImageResource(R.drawable.k);
						break;
					case 5:
						iv5.setImageResource(R.drawable.k);
						break;
					case 4:
						iv4.setImageResource(R.drawable.k);
						break;
					case 3:
						iv3.setImageResource(R.drawable.k);
						break;
					case 2:
						iv2.setImageResource(R.drawable.k);
						break;
					case 1:
						iv1.setImageResource(R.drawable.k);
						break;
					}

				}
			}
			if (life_chk == true) {
				lives--;
				switch (lives) {
				case 2:
					l3.setVisibility(View.INVISIBLE);
					break;
				case 1:
					l2.setVisibility(View.INVISIBLE);
					break;
				case 0:
					l1.setVisibility(View.INVISIBLE);
					game_over.setText("Game Over");
					break;
				}
			}
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
						iv9.setImageResource(R.drawable.l);
						break;
					case 8:
						iv8.setImageResource(R.drawable.l);
						break;
					case 7:
						iv7.setImageResource(R.drawable.l);
						break;
					case 6:
						iv6.setImageResource(R.drawable.l);
						break;
					case 5:
						iv5.setImageResource(R.drawable.l);
						break;
					case 4:
						iv4.setImageResource(R.drawable.l);
						break;
					case 3:
						iv3.setImageResource(R.drawable.l);
						break;
					case 2:
						iv2.setImageResource(R.drawable.l);
						break;
					case 1:
						iv1.setImageResource(R.drawable.l);
						break;
					}

				}
			}
			if (life_chk == true) {
				lives--;
				switch (lives) {
				case 2:
					l3.setVisibility(View.INVISIBLE);
					break;
				case 1:
					l2.setVisibility(View.INVISIBLE);
					break;
				case 0:
					l1.setVisibility(View.INVISIBLE);
					game_over.setText("Game Over");
					break;
				}
			}
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
						iv9.setImageResource(R.drawable.m);
						break;
					case 8:
						iv8.setImageResource(R.drawable.m);
						break;
					case 7:
						iv7.setImageResource(R.drawable.m);
						break;
					case 6:
						iv6.setImageResource(R.drawable.m);
						break;
					case 5:
						iv5.setImageResource(R.drawable.m);
						break;
					case 4:
						iv4.setImageResource(R.drawable.m);
						break;
					case 3:
						iv3.setImageResource(R.drawable.m);
						break;
					case 2:
						iv2.setImageResource(R.drawable.m);
						break;
					case 1:
						iv1.setImageResource(R.drawable.m);
						break;
					}

				}
			}
			if (life_chk == true) {
				lives--;
				switch (lives) {
				case 2:
					l3.setVisibility(View.INVISIBLE);
					break;
				case 1:
					l2.setVisibility(View.INVISIBLE);
					break;
				case 0:
					l1.setVisibility(View.INVISIBLE);
					game_over.setText("Game Over");
					break;
				}
			}
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
						iv9.setImageResource(R.drawable.n);
						break;
					case 8:
						iv8.setImageResource(R.drawable.n);
						break;
					case 7:
						iv7.setImageResource(R.drawable.n);
						break;
					case 6:
						iv6.setImageResource(R.drawable.n);
						break;
					case 5:
						iv5.setImageResource(R.drawable.n);
						break;
					case 4:
						iv4.setImageResource(R.drawable.n);
						break;
					case 3:
						iv3.setImageResource(R.drawable.n);
						break;
					case 2:
						iv2.setImageResource(R.drawable.n);
						break;
					case 1:
						iv1.setImageResource(R.drawable.n);
						break;
					}

				}
			}
			if (life_chk == true) {
				lives--;
				switch (lives) {
				case 2:
					l3.setVisibility(View.INVISIBLE);
					break;
				case 1:
					l2.setVisibility(View.INVISIBLE);
					break;
				case 0:
					l1.setVisibility(View.INVISIBLE);
					game_over.setText("Game Over");
					break;
				}
			}
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
						iv9.setImageResource(R.drawable.o);
						break;
					case 8:
						iv8.setImageResource(R.drawable.o);
						break;
					case 7:
						iv7.setImageResource(R.drawable.o);
						break;
					case 6:
						iv6.setImageResource(R.drawable.o);
						break;
					case 5:
						iv5.setImageResource(R.drawable.o);
						break;
					case 4:
						iv4.setImageResource(R.drawable.o);
						break;
					case 3:
						iv3.setImageResource(R.drawable.o);
						break;
					case 2:
						iv2.setImageResource(R.drawable.o);
						break;
					case 1:
						iv1.setImageResource(R.drawable.o);
						break;
					}

				}
			}
			if (life_chk == true) {
				lives--;
				switch (lives) {
				case 2:
					l3.setVisibility(View.INVISIBLE);
					break;
				case 1:
					l2.setVisibility(View.INVISIBLE);
					break;
				case 0:
					l1.setVisibility(View.INVISIBLE);
					game_over.setText("Game Over");
					break;
				}
			}
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
						iv9.setImageResource(R.drawable.p);
						break;
					case 8:
						iv8.setImageResource(R.drawable.p);
						break;
					case 7:
						iv7.setImageResource(R.drawable.p);
						break;
					case 6:
						iv6.setImageResource(R.drawable.p);
						break;
					case 5:
						iv5.setImageResource(R.drawable.p);
						break;
					case 4:
						iv4.setImageResource(R.drawable.p);
						break;
					case 3:
						iv3.setImageResource(R.drawable.p);
						break;
					case 2:
						iv2.setImageResource(R.drawable.p);
						break;
					case 1:
						iv1.setImageResource(R.drawable.p);
						break;
					}

				}
			}
			if (life_chk == true) {
				lives--;
				switch (lives) {
				case 2:
					l3.setVisibility(View.INVISIBLE);
					break;
				case 1:
					l2.setVisibility(View.INVISIBLE);
					break;
				case 0:
					l1.setVisibility(View.INVISIBLE);
					game_over.setText("Game Over");
					break;
				}
			}
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
						iv9.setImageResource(R.drawable.q);
						break;
					case 8:
						iv8.setImageResource(R.drawable.q);
						break;
					case 7:
						iv7.setImageResource(R.drawable.q);
						break;
					case 6:
						iv6.setImageResource(R.drawable.q);
						break;
					case 5:
						iv5.setImageResource(R.drawable.q);
						break;
					case 4:
						iv4.setImageResource(R.drawable.q);
						break;
					case 3:
						iv3.setImageResource(R.drawable.q);
						break;
					case 2:
						iv2.setImageResource(R.drawable.q);
						break;
					case 1:
						iv1.setImageResource(R.drawable.q);
						break;
					}

				}
			}
			if (life_chk == true) {
				lives--;
				switch (lives) {
				case 2:
					l3.setVisibility(View.INVISIBLE);
					break;
				case 1:
					l2.setVisibility(View.INVISIBLE);
					break;
				case 0:
					l1.setVisibility(View.INVISIBLE);
					game_over.setText("Game Over");
					break;
				}
			}
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
						iv9.setImageResource(R.drawable.r);
						break;
					case 8:
						iv8.setImageResource(R.drawable.r);
						break;
					case 7:
						iv7.setImageResource(R.drawable.r);
						break;
					case 6:
						iv6.setImageResource(R.drawable.r);
						break;
					case 5:
						iv5.setImageResource(R.drawable.r);
						break;
					case 4:
						iv4.setImageResource(R.drawable.r);
						break;
					case 3:
						iv3.setImageResource(R.drawable.r);
						break;
					case 2:
						iv2.setImageResource(R.drawable.r);
						break;
					case 1:
						iv1.setImageResource(R.drawable.r);
						break;
					}

				}
			}
			if (life_chk == true) {
				lives--;
				switch (lives) {
				case 2:
					l3.setVisibility(View.INVISIBLE);
					break;
				case 1:
					l2.setVisibility(View.INVISIBLE);
					break;
				case 0:
					l1.setVisibility(View.INVISIBLE);
					game_over.setText("Game Over");
					break;
				}
			}
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
						iv9.setImageResource(R.drawable.s);
						break;
					case 8:
						iv8.setImageResource(R.drawable.s);
						break;
					case 7:
						iv7.setImageResource(R.drawable.s);
						break;
					case 6:
						iv6.setImageResource(R.drawable.s);
						break;
					case 5:
						iv5.setImageResource(R.drawable.s);
						break;
					case 4:
						iv4.setImageResource(R.drawable.s);
						break;
					case 3:
						iv3.setImageResource(R.drawable.s);
						break;
					case 2:
						iv2.setImageResource(R.drawable.s);
						break;
					case 1:
						iv1.setImageResource(R.drawable.s);
						break;
					}

				}
			}
			if (life_chk == true) {
				lives--;
				switch (lives) {
				case 2:
					l3.setVisibility(View.INVISIBLE);
					break;
				case 1:
					l2.setVisibility(View.INVISIBLE);
					break;
				case 0:
					l1.setVisibility(View.INVISIBLE);
					game_over.setText("Game Over");
					break;
				}
			}
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
						iv9.setImageResource(R.drawable.t);
						break;
					case 8:
						iv8.setImageResource(R.drawable.t);
						break;
					case 7:
						iv7.setImageResource(R.drawable.t);
						break;
					case 6:
						iv6.setImageResource(R.drawable.t);
						break;
					case 5:
						iv5.setImageResource(R.drawable.t);
						break;
					case 4:
						iv4.setImageResource(R.drawable.t);
						break;
					case 3:
						iv3.setImageResource(R.drawable.t);
						break;
					case 2:
						iv2.setImageResource(R.drawable.t);
						break;
					case 1:
						iv1.setImageResource(R.drawable.t);
						break;
					}

				}
			}
			if (life_chk == true) {
				lives--;
				switch (lives) {
				case 2:
					l3.setVisibility(View.INVISIBLE);
					break;
				case 1:
					l2.setVisibility(View.INVISIBLE);
					break;
				case 0:
					l1.setVisibility(View.INVISIBLE);
					game_over.setText("Game Over");
					break;
				}
			}
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
						iv9.setImageResource(R.drawable.u);
						break;
					case 8:
						iv8.setImageResource(R.drawable.u);
						break;
					case 7:
						iv7.setImageResource(R.drawable.u);
						break;
					case 6:
						iv6.setImageResource(R.drawable.u);
						break;
					case 5:
						iv5.setImageResource(R.drawable.u);
						break;
					case 4:
						iv4.setImageResource(R.drawable.u);
						break;
					case 3:
						iv3.setImageResource(R.drawable.u);
						break;
					case 2:
						iv2.setImageResource(R.drawable.u);
						break;
					case 1:
						iv1.setImageResource(R.drawable.u);
						break;
					}

				}
			}
			if (life_chk == true) {
				lives--;
				switch (lives) {
				case 2:
					l3.setVisibility(View.INVISIBLE);
					break;
				case 1:
					l2.setVisibility(View.INVISIBLE);
					break;
				case 0:
					l1.setVisibility(View.INVISIBLE);
					game_over.setText("Game Over");
					break;
				}
			}
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
						iv9.setImageResource(R.drawable.v);
						break;
					case 8:
						iv8.setImageResource(R.drawable.v);
						break;
					case 7:
						iv7.setImageResource(R.drawable.v);
						break;
					case 6:
						iv6.setImageResource(R.drawable.v);
						break;
					case 5:
						iv5.setImageResource(R.drawable.v);
						break;
					case 4:
						iv4.setImageResource(R.drawable.v);
						break;
					case 3:
						iv3.setImageResource(R.drawable.v);
						break;
					case 2:
						iv2.setImageResource(R.drawable.v);
						break;
					case 1:
						iv1.setImageResource(R.drawable.v);
						break;
					}

				}
			}
			if (life_chk == true) {
				lives--;
				switch (lives) {
				case 2:
					l3.setVisibility(View.INVISIBLE);
					break;
				case 1:
					l2.setVisibility(View.INVISIBLE);
					break;
				case 0:
					l1.setVisibility(View.INVISIBLE);
					game_over.setText("Game Over");
					break;
				}
			}
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
						iv9.setImageResource(R.drawable.w);
						break;
					case 8:
						iv8.setImageResource(R.drawable.w);
						break;
					case 7:
						iv7.setImageResource(R.drawable.w);
						break;
					case 6:
						iv6.setImageResource(R.drawable.w);
						break;
					case 5:
						iv5.setImageResource(R.drawable.w);
						break;
					case 4:
						iv4.setImageResource(R.drawable.w);
						break;
					case 3:
						iv3.setImageResource(R.drawable.w);
						break;
					case 2:
						iv2.setImageResource(R.drawable.w);
						break;
					case 1:
						iv1.setImageResource(R.drawable.w);
						break;
					}

				}
			}
			if (life_chk == true) {
				lives--;
				switch (lives) {
				case 2:
					l3.setVisibility(View.INVISIBLE);
					break;
				case 1:
					l2.setVisibility(View.INVISIBLE);
					break;
				case 0:
					l1.setVisibility(View.INVISIBLE);
					game_over.setText("Game Over");
					break;
				}
			}
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
						iv9.setImageResource(R.drawable.x);
						break;
					case 8:
						iv8.setImageResource(R.drawable.x);
						break;
					case 7:
						iv7.setImageResource(R.drawable.x);
						break;
					case 6:
						iv6.setImageResource(R.drawable.x);
						break;
					case 5:
						iv5.setImageResource(R.drawable.x);
						break;
					case 4:
						iv4.setImageResource(R.drawable.x);
						break;
					case 3:
						iv3.setImageResource(R.drawable.x);
						break;
					case 2:
						iv2.setImageResource(R.drawable.x);
						break;
					case 1:
						iv1.setImageResource(R.drawable.x);
						break;
					}

				}
			}
			if (life_chk == true) {
				lives--;
				switch (lives) {
				case 2:
					l3.setVisibility(View.INVISIBLE);
					break;
				case 1:
					l2.setVisibility(View.INVISIBLE);
					break;
				case 0:
					l1.setVisibility(View.INVISIBLE);
					game_over.setText("Game Over");
					break;
				}
			}
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
						iv9.setImageResource(R.drawable.y);
						break;
					case 8:
						iv8.setImageResource(R.drawable.y);
						break;
					case 7:
						iv7.setImageResource(R.drawable.y);
						break;
					case 6:
						iv6.setImageResource(R.drawable.y);
						break;
					case 5:
						iv5.setImageResource(R.drawable.y);
						break;
					case 4:
						iv4.setImageResource(R.drawable.y);
						break;
					case 3:
						iv3.setImageResource(R.drawable.y);
						break;
					case 2:
						iv2.setImageResource(R.drawable.y);
						break;
					case 1:
						iv1.setImageResource(R.drawable.y);
						break;
					}

				}
			}
			if (life_chk == true) {
				lives--;
				switch (lives) {
				case 2:
					l3.setVisibility(View.INVISIBLE);
					break;
				case 1:
					l2.setVisibility(View.INVISIBLE);
					break;
				case 0:
					l1.setVisibility(View.INVISIBLE);
					game_over.setText("Game Over");
					break;
				}
			}
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
						iv9.setImageResource(R.drawable.z);
						break;
					case 8:
						iv8.setImageResource(R.drawable.z);
						break;
					case 7:
						iv7.setImageResource(R.drawable.z);
						break;
					case 6:
						iv6.setImageResource(R.drawable.z);
						break;
					case 5:
						iv5.setImageResource(R.drawable.z);
						break;
					case 4:
						iv4.setImageResource(R.drawable.z);
						break;
					case 3:
						iv3.setImageResource(R.drawable.z);
						break;
					case 2:
						iv2.setImageResource(R.drawable.z);
						break;
					case 1:
						iv1.setImageResource(R.drawable.z);
						break;
					}

				}
			}
			if (life_chk == true) {
				lives--;
				switch (lives) {
				case 2:
					l3.setVisibility(View.INVISIBLE);
					break;
				case 1:
					l2.setVisibility(View.INVISIBLE);
					break;
				case 0:
					l1.setVisibility(View.INVISIBLE);
					game_over.setText("Game Over");
					break;
				}
			}
			win_chk();
			winner();
			break;

		}

	}

}
