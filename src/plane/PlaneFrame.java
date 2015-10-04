package plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import util.Constant;
import util.GameUtil;
import util.MyFrame;

public class PlaneFrame extends MyFrame{
	Image bg=GameUtil.getImage("images/bg.jpg");
	Plane p=new Plane("images/plane.png",Constant.PLANE_X,Constant.PLANE_Y);
	
	public void paint(Graphics g){
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
	}
	@Override
	public void lauchFrame(){
		super.lauchFrame();
		addKeyListener(new KeyMonitor());
	}
	//定义为内部类，可以方便的使用外部类的普通属性
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);
			System.out.println(e.getKeyCode());
			switch(e.getKeyCode()){
			case KeyEvent.VK_RIGHT:	p.right=true;break;
			case KeyEvent.VK_LEFT:	p.left=true;break;
			case KeyEvent.VK_UP:	p.up=true;break;
			case KeyEvent.VK_DOWN:	p.down=true;break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			super.keyReleased(e);
			switch(e.getKeyCode()){
			case KeyEvent.VK_RIGHT:	p.right=false;break;
			case KeyEvent.VK_LEFT:	p.left=false;break;
			case KeyEvent.VK_UP:	p.up=false;break;
			case KeyEvent.VK_DOWN:	p.down=false;break;
			}
		}
		
	}
	/*=====================================*/
	public static void main(String[] args) {
		new PlaneFrame().lauchFrame();
	}
}
