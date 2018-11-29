package PokerGame_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PokerDesign {

	public PokerDesign() {
		JFrame guiFrame = new JFrame();
		guiFrame.getContentPane().setBackground(new Color(135, 206, 250));
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setTitle("Example GUI");
		guiFrame.setSize(700, 700);
		guiFrame.setBackground(Color.black);
		guiFrame.setResizable(true);
		// Center Frame
		guiFrame.setLocationRelativeTo(null);
		// Options for the JComboBox

		String[] firstOptions = { "Rules", "Start Game", "MoneyBoard", "Shop" };
		// Getting rules here
		String[] Rules = new RuleReader().getRules("src\\PokerGame_GUI\\allPokerRules.txt");

		// The first JPanel contains a JLabel and JCombobox
		final JPanel comboPanel = new JPanel(new GridBagLayout());
		comboPanel.setBackground(Color.cyan);

		JLabel welcomeLabl = new JLabel("THE WINGS POKER");
		welcomeLabl.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		GridBagConstraints gbc_welcomeLabl = new GridBagConstraints();
		gbc_welcomeLabl.insets = new Insets(0, 0, 5, 5);
		gbc_welcomeLabl.gridx = 1;
		gbc_welcomeLabl.gridy = 0;
		comboPanel.add(welcomeLabl, gbc_welcomeLabl);

		// Create the second JPanel. Add a JLabel and JList and
		// make use the JPanel is not visible.
		final JPanel listPanel = new JPanel(new GridBagLayout());
		GridBagConstraints lc = new GridBagConstraints();
		lc.insets = new Insets(0, 0, 0, 5);
		lc.gridx = 0;
		lc.gridy = 0;

		listPanel.setVisible(false);
		JLabel listLbl = new JLabel("BEST HANDS POSSIBLE");
		JList ruleList = new JList(Rules);
		ruleList.setLayoutOrientation(JList.VERTICAL);
		GridBagConstraints gbc_listLbl = new GridBagConstraints();
		gbc_listLbl.insets = new Insets(0, 0, 5, 5);
		gbc_listLbl.gridx = 0;
		gbc_listLbl.gridy = 0;
		listPanel.add(listLbl, gbc_listLbl);
		
				JButton BACKButton = new JButton("BACK");
				BACKButton.setBackground(Color.RED);
				

		lc.gridx = 0;
		lc.gridy = 1;
		listPanel.add(ruleList, lc);
		GridBagConstraints p1c = new GridBagConstraints();
		p1c.gridx = 20;
		p1c.gridy = 20;
		GridBagConstraints p2c = new GridBagConstraints();
		p2c.gridx = 20;
		p2c.gridy = 20;

		JPanel picPanel = new JPanel(new GridBagLayout());
		picPanel.setVisible(false);

		Cards cards = new Cards();
		/* These labels are the back side of cards with The wings LOGO */
		JLabel[][] label = cards.gameCardsLabel();
		for (int i = 0; i < label.length; i++) {
			picPanel.add(label[i][0]);
		}

		/* These labels are the face side of the card that will be updated later */

		ArrayList<String> label_names = cards.getCardLabelNames();
		ArrayList<String> player_one_names = new ArrayList<String>();
		ArrayList<String> player_two_names = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			player_one_names.add(label_names.get(i));
			player_two_names.add(label_names.get(i + 5));
		}


		final JPanel evaluateButtonPanel = new JPanel(new GridBagLayout());
		evaluateButtonPanel.setVisible(false);
						
								final JPanel p2WinsPanel = new JPanel(new GridBagLayout());
								GridBagConstraints gbc_p2WinsPanel = new GridBagConstraints();
								gbc_p2WinsPanel.insets = new Insets(0, 0, 5, 5);
								gbc_p2WinsPanel.gridx = 0;
								gbc_p2WinsPanel.gridy = 0;
								JLabel p2Wins = new JLabel("PLAYER 2 WINS!!!");
								GridBagConstraints gbc_p2Wins = new GridBagConstraints();
								p2WinsPanel.add(p2Wins, gbc_p2Wins);
								p2WinsPanel.setVisible(false);
								evaluateButtonPanel.add(p2WinsPanel, gbc_p2WinsPanel);
		
		final JPanel p1WinsPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc_p1WinsPanel = new GridBagConstraints();
		gbc_p1WinsPanel.insets = new Insets(0, 0, 5, 5);
		gbc_p1WinsPanel.gridx = 0;
		gbc_p1WinsPanel.gridy = 1;
		JLabel p1Wins = new JLabel("PLAYER 1 WINS!!!");
		p1WinsPanel.add(p1Wins);
		p1WinsPanel.setVisible(false);
		evaluateButtonPanel.add(p1WinsPanel, gbc_p1WinsPanel);
		
				JButton evaluateButton = new JButton("EVALUATE");
				
						evaluateButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent event) {
								if (highCard(player_one_names) > highCard(player_two_names)) {
									for(int i =0; i<evaluateButtonPanel.getComponentCount();i++) {
										if(i == 1 || i==4) {//player location and QUIT button
											evaluateButtonPanel.getComponent(i).setVisible(true);
										}
										else {
											evaluateButtonPanel.getComponent(i).setVisible(false);
										}
									}
									comboPanel.setVisible(false);
									picPanel.setVisible(true);
									listPanel.setVisible(false);
									evaluateButtonPanel.setVisible(true);
				
								} else {
									for(int i =0; i<evaluateButtonPanel.getComponentCount();i++) {
										if(i == 0 || i==4) {//player location and QUIT button
											evaluateButtonPanel.getComponent(i).setVisible(true);
										}
										else {
											evaluateButtonPanel.getComponent(i).setVisible(false);
										}
									}
									comboPanel.setVisible(false);
									picPanel.setVisible(true);
									listPanel.setVisible(false);
									evaluateButtonPanel.setVisible(true);
									
								}
							}
						});
						
						ActionListener quitAction = new ActionListener() {
							public void actionPerformed(ActionEvent event) {
								picPanel.setVisible(false);
								listPanel.setVisible(false);
								evaluateButtonPanel.setVisible(false);
								p2WinsPanel.setVisible(false);
								p1WinsPanel.setVisible(false);
								comboPanel.setVisible(true);
							}
						};
						
						BACKButton.addActionListener(quitAction);
						GridBagConstraints gbc_BACKButton = new GridBagConstraints();
						gbc_BACKButton.insets = new Insets(0, 0, 5, 0);
						gbc_BACKButton.gridx = 2;
						gbc_BACKButton.gridy = 0;
						listPanel.add(BACKButton, gbc_BACKButton);
						
						GridBagConstraints gbc_evaluateButton = new GridBagConstraints();
						gbc_evaluateButton.insets = new Insets(0, 0, 5, 5);
						gbc_evaluateButton.gridx = 0;
						gbc_evaluateButton.gridy = 2;
						evaluateButtonPanel.add(evaluateButton, gbc_evaluateButton);

		evaluateButtonPanel.setBackground(Color.cyan);

		GridLayout grid = new GridLayout(2, 5, 2, 2);
		picPanel.setLayout(grid);

		guiFrame.getContentPane().add(comboPanel, BorderLayout.NORTH);
		JButton btnStartGame = new JButton("START GAME");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboPanel.setVisible(false);
				listPanel.setVisible(false);
				picPanel.setVisible(true);
				evaluateButtonPanel.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnStartGame = new GridBagConstraints();
		gbc_btnStartGame.insets = new Insets(0, 0, 0, 5);
		gbc_btnStartGame.gridx = 0;
		gbc_btnStartGame.gridy = 1;
		comboPanel.add(btnStartGame, gbc_btnStartGame);

		JButton btnHowToPlay = new JButton("HOW TO PLAY");
		btnHowToPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboPanel.setVisible(false);
				listPanel.setVisible(true);
				evaluateButtonPanel.setVisible(false);
			}
		});
		GridBagConstraints gbc_btnHowToPlay = new GridBagConstraints();
		gbc_btnHowToPlay.insets = new Insets(0, 0, 0, 5);
		gbc_btnHowToPlay.gridx = 1;
		gbc_btnHowToPlay.gridy = 1;
		comboPanel.add(btnHowToPlay, gbc_btnHowToPlay);

		JButton btnMoneyboard = new JButton("MONEYBOARD");
		GridBagConstraints gbc_btnMoneyboard = new GridBagConstraints();
		gbc_btnMoneyboard.insets = new Insets(0, 0, 0, 5);
		gbc_btnMoneyboard.gridx = 2;
		gbc_btnMoneyboard.gridy = 1;
		comboPanel.add(btnMoneyboard, gbc_btnMoneyboard);
				
						JButton btnShop = new JButton("NEW GAME");
						btnShop.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
							}
						});
						GridBagConstraints gbc_btnShop = new GridBagConstraints();
						gbc_btnShop.gridx = 5;
						gbc_btnShop.gridy = 1;
						comboPanel.add(btnShop, gbc_btnShop);

		guiFrame.getContentPane().add(evaluateButtonPanel, BorderLayout.WEST);
		
				GridBagConstraints evbc = new GridBagConstraints();
				evbc.insets = new Insets(0, 0, 5, 5);
				evbc.gridx = 0;
				evbc.gridy = 3;
				
						JLabel evLbl = new JLabel("PRESS TO EVALUATE:");
						evLbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
						
								evaluateButtonPanel.add(evLbl, evbc);
								evbc.gridx = 0;
								evbc.gridy = 0;
								
										
								
										evbc.gridx = 1;
										evbc.gridy = 1;
										evbc.gridx = 1;
										evbc.gridy = 2;
										JButton QUITButton = new JButton("QUIT-GAME");
										QUITButton.setBackground(Color.RED);
										GridBagConstraints gbc_QUITButton = new GridBagConstraints();
										gbc_QUITButton.insets = new Insets(0, 0, 0, 5);
										gbc_QUITButton.gridx = 0;
										gbc_QUITButton.gridy = 4;
										QUITButton.addActionListener(quitAction);
										evaluateButtonPanel.add(QUITButton, gbc_QUITButton);

		guiFrame.getContentPane().add(picPanel, BorderLayout.AFTER_LINE_ENDS);
		guiFrame.getContentPane().add(listPanel, BorderLayout.SOUTH);
		guiFrame.setVisible(true);

	}

	public String get_cardName(String playerLabel) {
		String cardNum = playerLabel.substring(0, playerLabel.length() - 1);
		switch (cardNum) {
		case "A":
			return "14";
		case "K":
			return "13";
		case "Q":
			return "12";
		case "J":
			return "11";
		default:
			return cardNum;
		}
	}

	public String get_suitName(String playerLabel) {
		return playerLabel.substring(playerLabel.length() - 1);
	}

	public int highCard(ArrayList<String> playerLabels) {
		int highCardNum = 0;
		for (int i = 0; i < 5; i++) {
			int card1 = Integer.parseInt(get_cardName(playerLabels.get(i)));
			if (highCardNum <= card1) {
				highCardNum = card1;
			}
		}
		return highCardNum;
	}

}
