package PokerGame_GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


public class Cards {
	
	private char[] _suitName = {'C', 'D', 'H', 'S'};
	private char[] _cardNum = {2,3,4,5,6,7,8,9,10,'J','K','Q','A'};
	
	public BufferedImage projectImage(String getCard) {
		String pngfile = "C:\\Users\\kotin\\Desktop\\cse 442\\CSE442_PokerGame\\src\\Card_PNG\\"+ getCard +".png";
		try {
			BufferedImage bg = ImageIO.read(new File(pngfile));
			
	        return bg;
		} 
		catch (Exception e) {
			System.out.println("Image didn't print ");
			return null;
		}
	}
	
	public ImageIcon getImageIcon(String getCard) {
		ImageIcon Img = new ImageIcon(projectImage(getCard));
		Image nIg = Img.getImage();
		Image aginNew = nIg.getScaledInstance(100, 150, Image.SCALE_SMOOTH);
		ImageIcon newImg = new ImageIcon(aginNew);
		return newImg;
	}

}
