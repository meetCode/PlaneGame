package plane;

import java.awt.Graphics;
import java.awt.Image;

public class Plane {
	double x,y;
	Image img;
	public void draw(Graphics g){
		g.drawImage(img, (int)x, (int)y, null);
	}
	public Plane(String path,double x,double y){
		this.img=util.GameUtil.getImage(path);
		this.x=x;
		this.y=y;
	}
	public Plane(){
	}
}