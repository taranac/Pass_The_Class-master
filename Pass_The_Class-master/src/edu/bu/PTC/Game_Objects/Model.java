package edu.bu.PTC.Game_Objects;
import android.graphics.Canvas;
import edu.bu.PTC.Game_Objects.*;

public class Model {
	public Ledge[] ledgearray;
	public Player theplayer;
	public int score;
	public Ledge closestledge;
	private int generate_ledge_delay;
	public int ledgetograb;
	//the resolution on my phone
	public int width = 720;
	public int height = 1280;
	public double max_delay = 100;
	
	public Model(){
		ledgearray = new Ledge [30];
		for (int i = 0; i < 30; i++){
			ledgearray[i] = new Ledge();
		}
		theplayer = new Player();
	}
	
	public void update(int height){
		//update the player's state
		for (int i = 0; i < 30 ; i++)
			ledgearray[i].speed += 0.0015;
			theplayer.speed += .0015;
			theplayer.fallingdownspeed += 0.0015;
			max_delay -= 0.0015;
		if (checkhorizontalcollision(height)){
			theplayer.state = 'o';
			theplayer.fallingfactor = 1.4;
		}
		else{
			theplayer.state = 'f';
			
		}
		//update ledges and players
		for (int i = 0; i<30; i++){
			ledgearray[i].update();
		}
		theplayer.update(height);
		
		//update the closest ledge

		
		//grab one of the unused ledges and make it show up on screen
		//only does it when generate_ledge_delay is a certain number
		//so we can control when it happens
		generate_ledge_delay=generate_ledge_delay+(int)Math.random()*10+5;
		if (generate_ledge_delay > max_delay){
			//int ledgetograb = 0;
			for (int i = 0;i<30;i++){
				if (ledgearray[i].state == 'n'){
					ledgetograb = i;
					break;
				}
			}
			ledgearray[ledgetograb].state = 'y';
			ledgearray[ledgetograb].ylocation = 0;
			ledgearray[ledgetograb].xlocation = (int)(Math.random()*570 + 1);
			generate_ledge_delay = 0;
		}
		
		score += theplayer.speed;

	}
	
	public void findclosestledge(int height){
		int ledgenumber = 0;
		for (int i = 1;i<30;i++){
			double tempx1 = ledgearray[ledgenumber].xlocation;
			double tempy1 = ledgearray[ledgenumber].ylocation;
			double distance1 = Math.sqrt((Math.pow((tempx1 - theplayer.xlocation),2) + 
					Math.pow((tempy1 - (theplayer.ylocation+50)), 2)));
			double tempx2 = ledgearray[i].xlocation;
			double tempy2 = ledgearray[i].ylocation;
			double distance2 = Math.sqrt((Math.pow((tempx2 - theplayer.xlocation),2) + 
					Math.pow((tempy2 - (theplayer.ylocation+50)), 2)));
			if (distance2 > distance1 && ledgearray[i].state == 'y'){
				ledgenumber = i;
			}
		}
		closestledge = ledgearray[ledgenumber];
	}
	
	private boolean checkhorizontalcollision(int height){
		//if the closestledge is within the collision distance horizontally
		//check to see if playerx is within the ledge's start and endx
		//set state to 'o', call changeimagestate
		//the 50 is just a placeholder number, i don't know the size of the models
		for (int i = 0; i < 30; i++){
			if (((1280-theplayer.ylocation -ledgearray[i].ylocation) < 130) &&
				((1280-theplayer.ylocation - ledgearray[i].ylocation )> 110)
				&& ((theplayer.xlocation - ledgearray[i].xlocation) < 120) &&
				((theplayer.xlocation - ledgearray[i].xlocation) > -30) &&
				ledgearray[i].state == 'y'){
			return true;
				}
			}
		return false;
	}
	
	/*private int checkverticalcollision(){
		//calls findclosestledge to return the closest ledge
		//checks to see if playerx is within some horizontal distance of the ledge
		//while the player's y overlaps with the ledge's y
		//to see if the ledge prevents the player from moving left/right
		//return 1 for left collision, 2 for right collision, 0 for no collision
		
		//50, 200,240 are place holders for the height and width required
		//240-200 should equal the width of the player model
		
		for (int i = 0;i<30;i++){
			if ((1280-theplayer.ylocation - ledgearray[i].ylocation) < 120 &&
					(1280-theplayer.ylocation - ledgearray[i].ylocation) > -90){
						if((theplayer.xlocation - ledgearray[i].xlocation) > -40 &&
								(theplayer.xlocation-ledgearray[i].xlocation) < 0){
							return 1;
						}
						else if ((theplayer.xlocation - ledgearray[i].xlocation) < 190 &&
								(theplayer.xlocation - ledgearray[i].xlocation) > 150)
							return 2;
						}
		}
		return 0;
	}*/
}

