	package edu.bu.PTC;

import edu.bu.PTC.Game_Objects.Ledge;
import edu.bu.PTC.Game_Objects.Model;
import edu.bu.PTC.Game_Objects.Player;
import android.R.bool;
import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnTouchListener;

public class GameScreen extends View implements OnTouchListener{
	public int delay;
	public Model control;
	//public Bitmap role1;
	public Bitmap role;
	public Bitmap role3;
	public Bitmap role2;
	public float height;
	public float width;
	public float xTouch;
	public float yTouch;
	public boolean IsStop;
	public Bitmap StopButton;
	public Bitmap StartButton;
	public Bitmap mLedgeImage;
	public Bitmap Gameover;
	public Paint paint;
	public Bitmap background;
	//public Bitmap StopButton1;
	//public Bitmap StartButton1;
	//public Bitmap mLedgeImage1;
	//public Bitmap Gameover1;
	//public Bitmap background1;
	
	public GameScreen(Context context) {
		super(context);
		control=new Model();

		role=BitmapFactory.decodeResource(getResources(), R.drawable.main2);
		role=Bitmap.createScaledBitmap(role, 40, 70, true);
		role2=BitmapFactory.decodeResource(getResources(), R.drawable.minirun1);
		role2=Bitmap.createScaledBitmap(role, 40, 70, true);
		role3=BitmapFactory.decodeResource(getResources(), R.drawable.minirunn1);
		role3=Bitmap.createScaledBitmap(role, 40, 70, true);
		//role1.recycle();
		
		mLedgeImage=BitmapFactory.decodeResource(getResources(), R.drawable.minibigbook);
		mLedgeImage=Bitmap.createScaledBitmap(mLedgeImage,150,20,true);
		//mLedgeImage1.recycle();
		
		StopButton=BitmapFactory.decodeResource(getResources(), R.drawable.pausebutton);
		StopButton=Bitmap.createScaledBitmap(StopButton,50,50,true);
		//StopButton1.recycle();
		
		StartButton=BitmapFactory.decodeResource(getResources(), R.drawable.startbutton);
		StartButton=Bitmap.createScaledBitmap(StartButton,50,50,true);
		//StartButton1.recycle();
		
		Gameover=BitmapFactory.decodeResource(getResources(), R.drawable.gameover);
		Gameover=Bitmap.createScaledBitmap(Gameover,450,900,true);
		//Gameover1.recycle();
		
		background=BitmapFactory.decodeResource(getResources(), R.drawable.wrinkled3);
		background=Bitmap.createScaledBitmap(background,720,1280,true);
		//background1.recycle();
		
		paint=new Paint();
		paint.setColor(Color.RED);
		paint.setTextSize(40);
		
	};
	@Override
	protected void onDraw(Canvas canvas){
		if(control.theplayer.isDead){
			super.onDraw(canvas);
			setOnTouchListener(this);
			height=this.getHeight();
			width=this.getWidth();
			
			canvas.drawBitmap(background,0,0,null);
			canvas.drawBitmap(StopButton,width-50,height-50,null);
			
				for(int j=0; j<30; j++){
					if(control.ledgearray[j].state=='y')
						canvas.drawBitmap(mLedgeImage, (float)control.ledgearray[j].xlocation,(float)(canvas.getHeight()- control.ledgearray[j].ylocation), null);
					
			}
			canvas.drawBitmap(Gameover,width/2-225,height/2-450,null);
			canvas.drawText(String.valueOf(control.score), 265, 750, paint);
			
			
		}
			
		else if(!IsStop){
		super.onDraw(canvas);
		setOnTouchListener(this);
		height=this.getHeight();
		width=this.getWidth();
		control.update((int)height);
		canvas.drawBitmap(background,0,0,null);
		canvas.drawBitmap(StopButton,width-50,height-50,null);
		canvas.drawBitmap(role, (float)control.theplayer.xlocation, (float)control.theplayer.ylocation, null);
		
			for(int j=0; j<30; j++){
				if(control.ledgearray[j].state=='y')
					canvas.drawBitmap(mLedgeImage, (float)control.ledgearray[j].xlocation,(float)(canvas.getHeight()- control.ledgearray[j].ylocation), null);
					canvas.drawText("Score: "+String.valueOf(control.score), 0, 50, paint);
					
		}
		
		invalidate();
		}
		else if(IsStop){
			super.onDraw(canvas);
			setOnTouchListener(this);
			height=this.getHeight();
			width=this.getWidth();
			canvas.drawBitmap(background,0,0,null);
			canvas.drawBitmap(StopButton,width-50,height-50,null);
			canvas.drawBitmap(role, (float)control.theplayer.xlocation, (float)control.theplayer.ylocation, null);
			delay++;
			
				for(int j=0; j<30; j++){
					if(control.ledgearray[j].state=='y')
						canvas.drawBitmap(mLedgeImage, (float)control.ledgearray[j].xlocation,(float)(canvas.getHeight()- control.ledgearray[j].ylocation), null);
						canvas.drawText("Score: "+String.valueOf(control.score), 0, 50 , paint);
						
			}
			invalidate();
		}
	
	}
	@Override
	public boolean onTouch(View View1, MotionEvent me) {
		xTouch=me.getX();
		yTouch=me.getY();
		if(xTouch>(width-50)&&yTouch>(height-50)&&control.theplayer.isDead==false){
			if(IsStop)
				IsStop=false;
			else
				IsStop=true;
			
		}
	
		return false;
	}
}

