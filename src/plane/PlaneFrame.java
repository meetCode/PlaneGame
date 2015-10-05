package plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import util.Constant;
import util.GameUtil;
import util.MyFrame;

public class PlaneFrame extends MyFrame{
	Image bg=GameUtil.getImage("images/bg.jpg");
	Plane p=new Plane("images/plane.png",Constant.PLANE_X,Constant.PLANE_Y);
	ArrayList bulletlist=new ArrayList();
	Explode bb;
	
	Date startTime;
	Date endTime;
	
	public void paint(Graphics g){
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
		
		for(int i=0;i<bulletlist.size();i++){
			Bullet b=(Bullet)bulletlist.get(i);
			b.draw(g);
			
			
			//�����ɻ���ײ
			boolean collision = b.getRec().intersects(p.getRec());//�ж��غ�
			//System.out.println(collision);
			if(collision) {
				p.Setlive(false);//�ɻ�����
				
				if(bb==null){
					endTime=new Date();
					bb=new Explode(p.x,p.y);
				}
				bb.draw(g);
				break;
			}
			//������ӡ��Ϣ
			if(!p.isLive()){
				printInfo(g,"GAME OVER",Color.red,40,Constant.GAME_WIDTH/2,Constant.GAME_WIDTH/2);
				long period=(endTime.getTime()-startTime.getTime())/1000;//����Ϊ��λ
				printInfo(g,"time:"+period,Color.white,7,50,90);
			}
		}
	}
	//��ӡ��Ϣ����
	public void printInfo(Graphics g,String str,Color co,int size,int x,int y){
		Color c=g.getColor();
		g.setColor(co);
		Font f = new Font("����",Font.BOLD,50);
		g.setFont(f);
		g.drawString(str, x, y);
		g.setColor(c);
	}
	@Override
	public void lauchFrame(){
		super.lauchFrame();
		addKeyListener(new KeyMonitor());
		//�����ӵ�
		for(int i=0;i<50;i++){
			Bullet b=new Bullet();
			bulletlist.add(b);
		}
		//��ʱ
		startTime=new Date();
		
	}
	//����Ϊ�ڲ��࣬���Է����ʹ���ⲿ�����ͨ����
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
