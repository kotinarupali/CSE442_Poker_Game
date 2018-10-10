package PokerHand;


/*Switch between the project source binary to java6 to java8 (vice versa)....-- so it can be run in IDE an applet */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author bing
 */
public class PokerHand extends Applet implements ActionListener {

    

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    @Override
    public void init() {
        // TODO start asynchronous download of heavy resources
       // Each button msut be in order 
	   button1 = new Button("SHOP");
	   add(button1);
	   button1.addActionListener(this);
	   
	   button2 = new Button("Game Rules");
	   add(button2);
	   button2.addActionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(130, 130, 80));
        g.drawString("Welcome to PokerHand", 15, 20);
    }
    // TODO overwrite start(), stop() and destroy() methods

  
	
    @Override
    public void actionPerformed(ActionEvent e) {
	   /*Notify user that button is pressed */
        if(e.getSource() == button1)
		System.out.println("Here is the Shop");
		else 
		System.out.println("Here is the game rule");
    }
	Button button1, button2; // Follow the order
}
