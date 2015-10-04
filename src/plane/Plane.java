package plane;

import java.awt.Graphics;
import java.awt.Image;



public class Plane {
	double x,y;
	Image img;
	boolean up,down,left,right;
	int speed=10;
	/**
	 * draw the plane
	 * @param g
	 */
	public void draw(Graphics g){
		g.drawImage(img, (int)x, (int)y, null);
		move();
	}
	public void move(){
		//38 40 37 39:up down left right
		if(left) x-=speed;
		if(right) x+=speed;
		if(up)   y-=speed;
		if(down) y+=speed;
		
	}
	public Plane(String path,double x,double y){
		this.img=util.GameUtil.getImage(path);
		this.x=x;
		this.y=y;
	}
	public Plane(){
	}
}