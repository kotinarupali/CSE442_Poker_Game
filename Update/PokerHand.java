package PokerHand;


/*Switch between the project source binary to java6 to java8 (vice versa)....-- so it can be run in IDE an applet */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author bing
 */
public class PokerHand extends Applet implements ActionListener {

    /**
     * ******************Declare All Component Here, initialize
     * later***********************
     */
    /**
     * *************JComboBox**********************
     */
    JComboBox list = new JComboBox();

    /**
     * *************JTable*******************
     */
    String[] score_board_Headings = {"Player_name", "Score"};
    //This is need to modified, since we need to register each player to the game.
    Object score_board_data[][] = {{"Player 1", "0"}, {"Player 2", "1"}, {"Player 3", "2"}, {"Player 4", "3"},};
    JScrollPane score_board_scrollPane;
    JTable score_board_table;

    /**
     *
     * ***************************************
     */
    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    @Override
    public void init() {
        // TODO start asynchronous download of heavy resources
        /*Set Layout for score board*/
        setLayout(new FlowLayout());
        // Each button msut be in order 
        button1 = new Button("SHOP");
        add(button1);
        button1.addActionListener(this);

        button2 = new Button("Game Rules");
        add(button2);
        button2.addActionListener(this);

        //
        setLayout(new FlowLayout());
        setupScore_board();
        //
        score_board_table = new JTable(score_board_data, score_board_Headings);
        score_board_table.setPreferredScrollableViewportSize(new Dimension(400, 70));
        score_board_scrollPane = new JScrollPane(score_board_table);
        add(score_board_scrollPane);
    }

    @Override
    /*What u need to draw, do it right here*/
    public void paint(Graphics g) {
        /*draw the applet*/
        super.paint(g);

        /**
         * ************Set Font size For welcome screen text******************
         */
        Font welcome = new Font("SansSerif", Font.BOLD + Font.ITALIC, 36);
        g.setColor(Color.red);
        g.setFont(welcome);
        g.drawString("Welcome to PokerHand Game", 50, 50);

    }

    // TODO overwrite start(), stop() and destroy() methods
    @Override
    public void actionPerformed(ActionEvent e) {
        /*Notify user that button is pressed */
        if (e.getSource() == button1) {
            System.out.println("Here is the Shop");
        } else {
            System.out.println("Here is the game rule");
        }
    }
    Button button1, button2; // Follow the order

    public void setupScore_board() {

        for (int i = 1; i < 10; i++) {
            list.addItem(String.valueOf(i));

        }
        add(list);
    }
}
