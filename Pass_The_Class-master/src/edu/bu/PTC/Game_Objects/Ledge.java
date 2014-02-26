package edu.bu.PTC.Game_Objects;

public class Ledge extends Game_Object{
	private double ledgewidth;
	private double ledgeheight;
	
	//state can be y for on the screen moving up;
	//or n for not;
	public char state;
	
	
	public Ledge(){
		super();
		state = 'n';
		ledgewidth=75;
		ledgeheight=15;
	}
	
	public Ledge(int in_num, char in_code, double in_x, double in_y, double in_speed){
		super(in_num, in_code, in_x, in_y, in_speed);
		state = 'n';
		
	}
	
	public void update(){
		switch(state){
		case 'y':
			if (ylocation >= 1280){
				state = 'n';
				xlocation = 0;
				ylocation = 0;
				break;
			}
			else{
				ylocation += speed;
				break;
			}
		case 'n':
			//i don't think we have to do anything here
		}
	}
}


