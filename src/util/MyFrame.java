package util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MyFrame extends Frame{
	
	public void lauchFrame(){
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);//TODO ����Ϊʲô���õ���constant����
		setLocation(Constant.GAME_Y,Constant.GAME_Y);
		setVisible(true);
		
		new PaintThread().start();//�����߳�
		
		addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}	
		});
	}
	/**
	 * ˫��������Ļ��˸
	 */
	private Image offScreenImage = null;
	public void update(Graphics g) {
		if(offScreenImage == null)
			offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		
		Graphics gOff = offScreenImage.getGraphics();

		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	class PaintThread extends Thread{
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
