package edu.bu.PTC.Game_Objects;

public class Player extends Game_Object{
	private int powerupstate;
	private int obstaclestate;
	
	//the speed from the accelorometer
	//might have to do from main
	public double controlledhorizontalspeed;
	
	//the speed the player falls down at when not on a ledge
	public double fallingdownspeed;
	
	//to control the animation, might need a counter to control better
	private int imagestate;
	
	//state can be 'f' for falling down
	//'o' for on a ledge
	//'l' for colliding with a ledge on the left
	//'r' for colliding with a ledge on the right
	public char state;
	public boolean isDead=false;
	public double fallingfactor=1.3;
	public Player(){
		super();
		state='f';
		xlocation=300;
		fallingdownspeed=2.5;
		powerupstate = 0;
		obstaclestate = 0;
		controlledhorizontalspeed = 0;
		imagestate = 1;
		speed=5;
	}
	
	public Player(int in_num, char in_code, double in_x, double in_y, double in_speed){
		super(in_num, in_code, in_x, in_y, in_speed);
		speed=10;
		fallingdownspeed=2.5;
		powerupstate = 0;
		obstaclestate = 0;
		controlledhorizontalspeed = 0;
		imagestate = 1;
	}
	
	private void changehorizontalspeed(){
		//not sure if this should be in the main activity
		//see tiltballactivity example
		//get data from accelorometer?
		// controlledhorizontalspeed = ?
	}
	
	//changing the animation frame
	private void changeimagestate(){
		if (imagestate == 1){
			imagestate = 0;
		}
		else if (imagestate == 0){
			imagestate = 1;
		}
	}
	
	public void update(int height){
		//have to find closest ledge each time you update
		//and change state if necessary
		if(ylocation<=-50||ylocation>=(height+70))
				isDead=true;
		switch(state){
		case 'f': 
			ylocation = ylocation + Math.pow(fallingfactor, 2);
			fallingfactor=fallingfactor+0.03;
			xlocation = xlocation + controlledhorizontalspeed;
			//make sure the player can't fly off screen
			//will have to change numbers based on how wide the player model is
			if (xlocation < 0)
				xlocation = 0;
			if (xlocation > 680)
				xlocation = 680;
			break;
		case 'o':
			ylocation = ylocation - speed;
			xlocation = xlocation + controlledhorizontalspeed;
			if (xlocation < 0)
				xlocation = 0;
			if (xlocation > 680)
				xlocation = 680;
			break;
		case 'l':
			//a negative controlledhorizontalspeed (CHS) means the player wants to move left
			//but the ledge is blocking it in case 'l', so the player will only move horizontally
			//if CHS is positive, same reasoning for case 'r'
			ylocation = ylocation + fallingdownspeed;
			if(controlledhorizontalspeed > 0){
				xlocation += controlledhorizontalspeed;
			}
			if (xlocation < 0)
				xlocation = 0;
			if (xlocation > 680)
				xlocation = 680;
		case 'r':
			ylocation += fallingdownspeed;
			if(controlledhorizontalspeed < 0){
				xlocation += controlledhorizontalspeed;
			}
			if (xlocation < 0)
				xlocation = 0;
			if (xlocation > 680)
				xlocation = 680;
		}
	}

}
