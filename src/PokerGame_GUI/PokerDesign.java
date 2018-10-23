package PokerGame_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PokerDesign {
	
	public PokerDesign(){
	JFrame guiFrame = new JFrame();
	guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	guiFrame.setTitle("Example GUI");
	guiFrame.setSize(700,700);
	guiFrame.setBackground(Color.black);
	guiFrame.setResizable(true);
	//Center Frame
	guiFrame.setLocationRelativeTo(null);
	//Options for the JComboBox
	
	
	String[] firstOptions = {"Rules", "Start Game", "Scoreboard","Shop"};
	//Getting rules here
	String[] Rules = new RuleReader().getRules("C:\\Users\\kotin\\Desktop\\cse 442\\CSE442_PokerGame\\src\\PokerGame_GUI\\allPokerRules.txt");
	
	//The first JPanel contains a JLabel and JCombobox
	final JPanel comboPanel = new JPanel(new GridBagLayout());
	
	GridBagConstraints gc = new GridBagConstraints();
	gc.gridx = 0;
	gc.gridy = 1;
	
	JLabel comboLbl = new JLabel("Select Action:");
	JComboBox dropList = new JComboBox(firstOptions);
	comboPanel.add(comboLbl,gc);
	gc.gridx = 1;
	comboPanel.add(dropList,gc);
	comboPanel.setBackground(Color.cyan);
	
	JLabel welcomeLabl = new JLabel("WELCOME TO THE POKER GAME");
	gc.gridx =0;
	gc.gridy = 2;
	comboPanel.add(welcomeLabl,gc);
	
	//Create the second JPanel. Add a JLabel and JList and
	//make use the JPanel is not visible.
	final JPanel listPanel = new JPanel(new GridBagLayout());
	GridBagConstraints lc = new GridBagConstraints();
	lc.gridx =0; lc.gridy =0;
	
	
	
	listPanel.setVisible(false);
	JLabel listLbl = new JLabel("BEST HANDS POSSIBLE");
	JList ruleList = new JList(Rules);
	ruleList.setLayoutOrientation(JList.VERTICAL);
	listPanel.add(listLbl);
	
	lc.gridx = 0; lc.gridy = 1;
	listPanel.add(ruleList,lc);
        
        final JPanel p1WinsPanel = new JPanel(new GridBagLayout());
	GridBagConstraints p1c = new GridBagConstraints();
	p1c.gridx =20; p1c.gridy =20;
	
	
	
	p1WinsPanel.setVisible(false);
	JLabel p1Wins = new JLabel("PLAYER 1 WINS!!!");
	p1WinsPanel.add(p1Wins);
        
        
        final JPanel p2WinsPanel = new JPanel(new GridBagLayout());
	GridBagConstraints p2c = new GridBagConstraints();
	p2c.gridx =20; p2c.gridy =20;
	
	
	
	p2WinsPanel.setVisible(false);
	JLabel p2Wins = new JLabel("PLAYER 2 WINS!!!");
	p2WinsPanel.add(p2Wins);
        
        
	
	JPanel picPanel = new JPanel(new GridBagLayout());
	picPanel.setVisible(false);
        

	Cards cards = new Cards();
	JLabel[] label = cards.gameCardsLabel();
		
	ArrayList<String> label_names = cards.getCardLabelNames();
        ArrayList<String> player_one_names = new ArrayList<String>();
        for(int i =0; i < 5; i++) {
            player_one_names.add(label_names.get(i));
	}
        
        ArrayList<String> player_two_names = new ArrayList<String>();
        for(int i =5; i < 10; i++) {
            player_two_names.add(label_names.get(i));
	}
	
        for(int i =0; i < 10; i++) {
		System.out.println("Suit: " + get_suitName(label_names.get(i)) + "     Face: " + get_cardName(label_names.get(i)));
	}
        
        
        
	for(int i =0; i < label.length; i++) {
		picPanel.add(label[i]);
	}
	
	final JPanel evaluateButtonPanel = new JPanel(new GridBagLayout());
        evaluateButtonPanel.setVisible(false);
	
	GridBagConstraints evbc = new GridBagConstraints();
	evbc.gridx = 0;
	evbc.gridy = 1;
	
	JLabel evLbl = new JLabel("PRESS TO EVALUATE:");
	
	evaluateButtonPanel.add(evLbl,evbc);
        evbc.gridx = 0;
	evbc.gridy = 0;
        
	evaluateButtonPanel.setBackground(Color.cyan);

	JButton begButton = new JButton("BEGIN");       
	
	begButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
		if(dropList.getSelectedItem().equals("Rules")) {
			comboPanel.setVisible(true);
			listPanel.setVisible(true);
                        evaluateButtonPanel.setVisible(false);
		}
		else if(dropList.getSelectedItem().equals("Start Game")) {
			comboPanel.setVisible(false);
			picPanel.setVisible(true);
                        evaluateButtonPanel.setVisible(true);
                        listPanel.setVisible(false);
		}
		else
                {comboPanel.setVisible(true);
                evaluateButtonPanel.setVisible(false);
                }
		}
	});
        
        JButton evaluateButton = new JButton("EVALUATE");
	
	evaluateButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
		if(highCard(player_one_names) > highCard(player_two_names)) {

                        p1WinsPanel.setVisible(true);
                        p2WinsPanel.setVisible(false);
			comboPanel.setVisible(false);
                        picPanel.setVisible(true);
			listPanel.setVisible(false);
                        evaluateButtonPanel.setVisible(false);
		}
		else {
  
                        p1WinsPanel.setVisible(false);
                        p2WinsPanel.setVisible(true);
			comboPanel.setVisible(false);
			picPanel.setVisible(true);
                        listPanel.setVisible(false);
                        evaluateButtonPanel.setVisible(false);
		}
		}
	});
        
	gc.gridx = 1;
	gc.gridy = 3;
	comboPanel.add(begButton, gc);
        
        evbc.gridx = 1;
	evbc.gridy = 1;
	evaluateButtonPanel.add(evaluateButton, evbc);
        
        GridLayout grid = new GridLayout(2, 5, 2, 2);
        picPanel.setLayout(grid);
	
	
	guiFrame.add(comboPanel, BorderLayout.NORTH);
        guiFrame.add(evaluateButtonPanel, BorderLayout.WEST);
	guiFrame.add(picPanel, BorderLayout.AFTER_LINE_ENDS);
	guiFrame.add(listPanel, BorderLayout.SOUTH);
        guiFrame.add(p1WinsPanel, BorderLayout.CENTER);
        guiFrame.add(p2WinsPanel, BorderLayout.CENTER);
	guiFrame.setVisible(true);
        
        
	}
        
        
        public String get_cardName(String playerLabel)
        {
            String cardNum =  playerLabel.substring(0, playerLabel.length() - 1);
            switch(cardNum)
            {
                case "A": return "14";
                case "K": return "13";
                case "Q": return "12";
                case "J": return "11";
                default: return cardNum;                
            }
        }
        
	public String get_suitName(String playerLabel)
        {
            return playerLabel.substring(playerLabel.length() - 1);
        }
        
        public int highCard(ArrayList<String> playerLabels)
        {
            int highCardNum = 0;
            for (int i = 0; i < 5; i++)
            {
                int card1 = Integer.parseInt(get_cardName(playerLabels.get(i)));
                if (highCardNum <= card1)
                {
                    highCardNum = card1;
                }
            }
            return highCardNum;
        }
        
        
}
