package PokerGame_GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.Random;


public class Cards {
	
	private String[] _suitName = {"C", "D", "H", "S"};
	private String[] _cardNum = {"2","3","4","5","6","7","8","9","10","J","K","Q","A"};
	private ArrayList<String> _allCards;
	
	public Cards() {
		 ArrayList<String> AllCards = new ArrayList<String>();
		for(int f = 0; f<_cardNum.length; f++ ) {
			for(int s =0; s<_suitName.length; s++) {
				AllCards.add( _cardNum[f] + _suitName[s]);
			}
		}
		_allCards = AllCards;
	}
	
	public BufferedImage projectImage(String getCard) {
		String pngfile = "src\\Card_PNG\\"+ getCard +".png";
		try {
			BufferedImage bg = ImageIO.read(new File(pngfile));
			
	        return bg;
		} 
		catch (Exception e) {
			System.out.println("Image didn't print ");
			return null;
		}
	}
	
	public ImageIcon getImageIcon() {
		ImageIcon Img = new ImageIcon(projectImage(getRandCard()));
		Image nIg = Img.getImage();
		Image aginNew = nIg.getScaledInstance(100, 150, Image.SCALE_SMOOTH);
		ImageIcon newImg = new ImageIcon(aginNew);
		return newImg;
	}
	
	public String getRandCard() {
		Random rand = new Random();
		int elem = rand.nextInt(_allCards.size());
		System.out.println(elem);
		String retval = "";
		retval = 	_allCards.remove(elem);	
		System.out.println(retval);
		return retval;
	}

}
