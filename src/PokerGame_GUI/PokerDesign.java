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
	String[] Rules = new RuleReader().getRules("src\\PokerGame_GUI\\allPokerRules.txt");
	
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
	
	JPanel picPanel = new JPanel(new GridBagLayout());
	picPanel.setVisible(false);
	
	JLabel[] label = new Cards().gameCardsLabel();
		
	ArrayList<String> label_names = cards.getCardLabelNames();
        ArrayList<String> player_one_names = new ArrayList<String>();
        for(int i =0; i < 5; i++) {
            player_one_names.add(label_names.get(i));
	}
        
        ArrayList<String> player_two_names = new ArrayList<String>();
         for(int i =5; i < 10; i++) {
            player_two_names.add(label_names.get(i));
	}
		
	for(int i =0; i < label.length; i++) {
		picPanel.add(label[i]);
	}
	
	
	JButton begButton = new JButton("BEGIN");
	
	begButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
		if(dropList.getSelectedItem().equals("Rules")) {
			comboPanel.setVisible(true);
			listPanel.setVisible(true);
		}
		else if(dropList.getSelectedItem().equals("Start Game")) {
			comboPanel.setVisible(false);
			picPanel.setVisible(true);
                        listPanel.setVisible(false);
		}
		else
		comboPanel.setVisible(true);
		}
	});
	
	gc.gridx =1;
	gc.gridy = 3;
	comboPanel.add(begButton, gc);
        
        GridLayout grid = new GridLayout(2, 5, 2, 2);
        picPanel.setLayout(grid);
	
	
	guiFrame.add(comboPanel, BorderLayout.NORTH);
	guiFrame.add(picPanel, BorderLayout.AFTER_LINE_ENDS);
	guiFrame.add(listPanel, BorderLayout.CENTER);
	guiFrame.setVisible(true);
	}
	
}
