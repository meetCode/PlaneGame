package util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

//read images
public class GameUtil {
	
	private GameUtil(){}	//工具类通常将构造方法私有???
	
	public static Image getImage(String path){
	URL u=GameUtil.class.getClassLoader().getResource(path);	
	BufferedImage ime=null;
	try {
		ime=ImageIO.read(u);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ime;
	}
}
