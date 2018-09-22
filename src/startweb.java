
import javax.swing.*;
import java.awt.*;

public class startweb {

    private JFrame window;  // creating a window to display that display poker game title.
    private JPanel game_screen;
    private JButton start_game;// creating a clickable button to start game
    private JLabel label_for_start_game;
    private ImageIcon poker_table;  //creating image button for poker table
    private JButton poker_table_button;

    public startweb() {

        setGui();

    }

    public void setGui() {
        window = new JFrame("Poker game");
        window.setVisible(true);
        window.setSize(1000, 1000);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the window

        game_screen = new JPanel();
        game_screen.setBackground(Color.green);

        // Make buttons 
        start_game = new JButton("start game");
        label_for_start_game = new JLabel("Have Fun!");
        poker_table_button = new JButton(poker_table);

        //Add label to the game screen panel
        game_screen.add(label_for_start_game);
        game_screen.add(start_game);
        game_screen.setPreferredSize(new Dimension(900, 900));

        //add panel to main window application
        window.add(game_screen, BorderLayout.NORTH);

    }

    public static void main(String args[]) {

        new startweb();

    }
}
