package edu.bu.PTC;

import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Main extends Activity {
	
	EditText messageinput;
	Button send;
	Button nextScreen;
	ImageButton startButton;
	ImageButton assignmentButton;
	ImageButton	creditButton;
	TextView message;
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButtonHandler BH=new ButtonHandler();
		startButton = (ImageButton) findViewById(R.id.startButton);
		startButton.setOnClickListener(BH);
		assignmentButton=(ImageButton) findViewById(R.id.assignmentButton);
		assignmentButton.setOnClickListener(BH);
		creditButton=(ImageButton) findViewById(R.id.creditButton);
		creditButton.setOnClickListener(BH);
		

	}
	


	class ButtonHandler implements OnClickListener{

		@Override
		public void onClick(View v) {
			Intent i=new Intent();
			if(v.getId()==R.id.startButton)
				i.setClassName("edu.bu.PTC", "edu.bu.PTC.Game");
			if(v.getId()==R.id.assignmentButton)
				i.setClassName("edu.bu.PTC", "edu.bu.PTC.Assignment");
			if(v.getId()==R.id.creditButton)
				i.setClassName("edu.bu.PTC", "edu.bu.PTC.Credit");
			
			startActivity(i);		
		}
	}
}
		
		
		
		
		
		
		
		
		
		
		/*ImageButton startButton = (ImageButton) findViewById(R.id.startButton);
		startButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v1){
				Intent intent1 = new Intent (v1.getContext(), Game.class);
				startActivityForResult(intent1,0); 
			}
		});
		
		ImageButton assignmentButton = (ImageButton) findViewById(R.id.assignmentButton);
		assignmentButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v2){
				Intent intent2 = new Intent (v2.getContext(), Assignment.class);
				startActivityForResult(intent2,0); 
			}
		});
		
		ImageButton highscoreButton = (ImageButton) findViewById(R.id.highscoreButton);
		highscoreButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v3){
				Intent intent3 = new Intent (v3.getContext(), HighScores.class);
				startActivityForResult(intent3,0); 
			}
		});
		
		ImageButton creditButton = (ImageButton) findViewById(R.id.creditButton);
		creditButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v4){
				Intent intent4 = new Intent (v4.getContext(), Credit.class);
				startActivityForResult(intent4,0); 
			}
		});*/
		
