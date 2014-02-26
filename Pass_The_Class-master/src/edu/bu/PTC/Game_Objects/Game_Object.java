package edu.bu.PTC.Game_Objects;


//XLOCATION REFERS TO THE SHORTER SIDE OF THE PHONE
//YLOCATION REFERS TO THE LONGER SIDE OF THE PHONE
public class Game_Object {
	protected int id_num;
	protected char code;
	public double xlocation;
	public double ylocation;
	public double speed;
	
	public Game_Object(){
		id_num = 0;
		code = 'N';
		xlocation = 0;
		ylocation = 0;
		speed = 5;
	}
	
	public Game_Object(int in_num, char in_code, double in_x, double in_y, double in_speed){
		id_num = in_num;
		code = in_code;
		xlocation = in_x;
		ylocation = in_y;
		speed = in_speed;
		speed= 5;
	}
}
