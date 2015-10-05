package plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import util.Constant;
import util.GameUtil;
import util.MyFrame;

public class PlaneFrame extends MyFrame{
	Image bg=GameUtil.getImage("images/bg.jpg");
	Plane p=new Plane("images/plane.png",Constant.PLANE_X,Constant.PLANE_Y);
	ArrayList bulletlist=new ArrayList();
	public void paint(Graphics g){
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
		for(int i=0;i<bulletlist.size();i++){
			Bullet b=(Bullet)bulletlist.get(i);
			b.draw(g);
			//检测跟飞机碰撞
			boolean collision = b.getRec().intersects(p.getRec());
			//System.out.println(collision);
			if(collision) 
				System.out.println("###############peng");
		}
	}
	@Override
	public void lauchFrame(){
		super.lauchFrame();
		addKeyListener(new KeyMonitor());
		for(int i=0;i<50;i++){
			Bullet b=new Bullet();
			bulletlist.add(b);
		}
		
	}
	//定义为内部类，可以方便的使用外部类的普通属性
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);
			p.direction(e.getKeyCode(),true);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			super.keyReleased(e);
			p.direction(e.getKeyCode(),false);
		}
		
	}
	/*=====================================*/
	public static void main(String[] args) {
		new PlaneFrame().lauchFrame();
	}
}
