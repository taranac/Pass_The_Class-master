package edu.bu.PTC;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import edu.bu.PTC.Game_Objects.*;

public class Game extends Activity implements SensorEventListener {
	//public Bitmap role;
	//public Bitmap role2;
	//public Bitmap role3;
	MediaPlayer mp;
	int ST=0;
	public GameScreen View1;
	SensorManager sm;
	Sensor accelerometer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		//role=BitmapFactory.decodeResource(getResources(), R.drawable.main2);
		//role=Bitmap.createScaledBitmap(role, 40, 70, true);
		//role2=BitmapFactory.decodeResource(getResources(), R.drawable.minirun1);
		//role2=Bitmap.createScaledBitmap(role, 40, 70, true);
		//role3=BitmapFactory.decodeResource(getResources(), R.drawable.minirunn1);
		//role3=Bitmap.createScaledBitmap(role, 40, 70, true);
		View1=new GameScreen(this);
		setContentView(View1);
		sm=(SensorManager)getSystemService(SENSOR_SERVICE);
		accelerometer=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		sm.registerListener(this,accelerometer,SensorManager.SENSOR_DELAY_GAME);
		mp = MediaPlayer.create(Game.this, R.raw.test);
		mp.setLooping(true);
		mp.start();
		
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		finish();
		 View1.role.recycle();
		 View1.StopButton.recycle();
		 View1.StartButton.recycle();
		 View1.Gameover.recycle();
		 View1.background.recycle();
		 View1.mLedgeImage.recycle();
		 View1.role2.recycle();
		 View1.role3.recycle();
		 //role.recycle();

	}
	@Override
	protected void onPause() {
	  super.onPause();
	  mp.release();
	  finish();
	  	 View1.role.recycle();
		 View1.StopButton.recycle();
		 View1.StartButton.recycle();
		 View1.Gameover.recycle();
		 View1.background.recycle();
		 View1.mLedgeImage.recycle();
		 View1.role2.recycle();
		 View1.role3.recycle();

	
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		
		mp.start();
	}
	
	public void onSensorChanged(SensorEvent event){
		if(event.values[0]<-0.5&&(!View1.IsStop)){
			
			//View1.role=Bitmap.createBitmap(role2);
			View1.role=BitmapFactory.decodeResource(getResources(), R.drawable.minirun1);
			View1.control.theplayer.xlocation += 5;
			//View1.role=BitmapFactory.decodeResource(getResources(), R.drawable.minirun2);
			//View1.control.theplayer.xlocation += 2.5;
		}
		else if(event.values[0]>0.5&&(!View1.IsStop)){
			//View1.role=Bitmap.createBitmap(role3);
			//View1.role=this.role3;
			View1.role=BitmapFactory.decodeResource(getResources(), R.drawable.minirunn1);
			
			View1.control.theplayer.xlocation -= 5;
			//View1.role=BitmapFactory.decodeResource(getResources(), R.drawable.minirunn2);
			//View1.control.theplayer.xlocation -= 2.5;
		}
		else{
			
			//View1.role=View1.role2;
			//View1.role=BitmapFactory.decodeResource(getResources(), R.drawable.main2);
			//View1.role=Bitmap.createScaledBitmap(View1.role, 40, 70, true);
		}
	}

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
