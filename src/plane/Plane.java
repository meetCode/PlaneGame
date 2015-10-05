package plane;

import java.awt.Graphics;
import java.awt.event.KeyEvent;



public class Plane extends GameObject{
	boolean up,down,left,right;
	boolean live=true;
	public void draw(Graphics g){
		if(live){
			g.drawImage(img, (int)x, (int)y, null);
			move();
		}
		
	}
	public void move(){
		//38 40 37 39:up down left right
		if(left) 	x-=speed;
		if(right)	x+=speed;
		if(up)   	y-=speed;
		if(down) 	y+=speed;
		
	}
	public void direction(int e,boolean add){
		switch(e){
		case KeyEvent.VK_RIGHT:	right=add;break;
		case KeyEvent.VK_LEFT:	left=add;break;
		case KeyEvent.VK_UP:	up=add;break;
		case KeyEvent.VK_DOWN:	down=add;break;
		}
	}
	public Plane(String path,double x,double y){//TODO 为什么这里依赖GameObject的空构造器
		this.speed=10;
		this.img=util.GameUtil.getImage(path);
		width=img.getWidth(null);
		height=img.getHeight(null);
		this.x=x;
		this.y=y;
	}
	public Plane(){
		
	}
	public boolean isLive(){
		return live;
	}
	public void Setlive(boolean live){
		this.live=live;
	}
	
}