package PokerGame_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

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
	
	JPanel picPanel = new JPanel(new GridBagLayout());
	picPanel.setVisible(false);
	
        JLabel picLabel1 = new JLabel();
	ImageIcon Img1 = new Cards().getImageIcon("10C");
	picPanel.add(picLabel1);
	picPanel.add(new JLabel(Img1));
        
        JLabel picLabel2 = new JLabel();
	ImageIcon Img2 = new Cards().getImageIcon("10H");
	picPanel.add(picLabel2);
	picPanel.add(new JLabel(Img2));
        
        JLabel picLabel3 = new JLabel();
	ImageIcon Img3 = new Cards().getImageIcon("10D");
	picPanel.add(picLabel3);
	picPanel.add(new JLabel(Img3));
        
        JLabel picLabel4 = new JLabel();
	ImageIcon Img4 = new Cards().getImageIcon("2C");
	picPanel.add(picLabel4);
	picPanel.add(new JLabel(Img4));
        
        JLabel picLabel5 = new JLabel();
	ImageIcon Img5 = new Cards().getImageIcon("2H");
	picPanel.add(picLabel5);
	picPanel.add(new JLabel(Img5));
        
        JLabel picLabel6 = new JLabel();
	ImageIcon Img6 = new Cards().getImageIcon("2D");
	picPanel.add(picLabel6);
	picPanel.add(new JLabel(Img6));
        
	
	
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
        
        GridLayout grid = new GridLayout(2, 3, 10, 10);
        picPanel.setLayout(grid);
	
	
	guiFrame.add(comboPanel, BorderLayout.NORTH);
	guiFrame.add(picPanel, BorderLayout.AFTER_LINE_ENDS);
	guiFrame.add(listPanel, BorderLayout.CENTER);
	guiFrame.setVisible(true);
	}
	
}