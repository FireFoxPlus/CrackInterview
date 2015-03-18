package edu.crackInterview;

public class point {
	private int x;
	private int y;
	public boolean lessThan(point another)
	{
		return x < another.getX() && y < another.getY();
	}
	
	public boolean isInValid(point another)
	{
		return x <= another.getX() || y <= another.getY();
	}
	public point(int valx , int valy){
		x = valx;
		y = valy;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int value){
		x = value;
	}
	public void setY(int value){
		y = value;
	}
}
