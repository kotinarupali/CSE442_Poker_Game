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
		guiFrame.getContentPane().setBackground(Color.WHITE);
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
		comboPanel.setBackground(Color.WHITE);

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

		GridBagLayout gbl_picPanel = new GridBagLayout();
		gbl_picPanel.rowWeights = new double[] {};
		gbl_picPanel.columnWeights = new double[] {};
		JPanel picPanel = new JPanel(gbl_picPanel);
		picPanel.setBackground(Color.WHITE);
		picPanel.setVisible(false);

		JPanel subPicpanel = new JPanel();
		GridBagConstraints gbc_subPicpanel = new GridBagConstraints();
		gbc_subPicpanel.fill = GridBagConstraints.BOTH;
		gbc_subPicpanel.gridx = 0;
		gbc_subPicpanel.gridy = 0;
		picPanel.add(subPicpanel, gbc_subPicpanel);
		GridBagLayout gbl_subPicpanel = new GridBagLayout();
		gbl_subPicpanel.columnWidths = new int[] { 539, 0 };
		gbl_subPicpanel.rowHeights = new int[] { 100, 100, 100, 0 };
		gbl_subPicpanel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_subPicpanel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		subPicpanel.setLayout(gbl_subPicpanel);

		JPanel p1cards = new JPanel();
		GridBagConstraints gbc_p1cards = new GridBagConstraints();
		gbc_p1cards.fill = GridBagConstraints.BOTH;
		gbc_p1cards.insets = new Insets(0, 0, 5, 0);
		gbc_p1cards.gridx = 0;
		gbc_p1cards.gridy = 0;
		subPicpanel.add(p1cards, gbc_p1cards);
		FlowLayout fl_p1cards = new FlowLayout(FlowLayout.CENTER, 5, 5);
		p1cards.setLayout(fl_p1cards);

		JPanel p2cards = new JPanel();
		GridBagConstraints gbc_p2cards = new GridBagConstraints();
		gbc_p2cards.fill = GridBagConstraints.BOTH;
		gbc_p2cards.insets = new Insets(0, 0, 5, 0);
		gbc_p2cards.gridx = 0;
		gbc_p2cards.gridy = 1;
		subPicpanel.add(p2cards, gbc_p2cards);
		FlowLayout fl_p2cards = new FlowLayout(FlowLayout.CENTER, 5, 5);
		p2cards.setLayout(fl_p2cards);

		Cards cards = new Cards();
		/* These labels are the back side of cards with The wings LOGO */
		JLabel[][] label = cards.gameCardsLabel();
		for (int i = 0; i < 5; i++) {
			p1cards.add(label[i][0]);// player 1 cards
			if (i + 5 > 7) {
				p2cards.add(label[i + 5][1]);// player 2 cards front faced
			} else
				p2cards.add(label[i + 5][0]);// player 2 cards
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
		gbc_p2WinsPanel.insets = new Insets(0, 0, 5, 0);
		gbc_p2WinsPanel.gridx = 0;
		gbc_p2WinsPanel.gridy = 0;
		JLabel p2Wins = new JLabel("YOU WON THE DEAL!!!");
		GridBagConstraints gbc_p2Wins = new GridBagConstraints();
		p2WinsPanel.add(p2Wins, gbc_p2Wins);
		p2WinsPanel.setVisible(false);
		evaluateButtonPanel.add(p2WinsPanel, gbc_p2WinsPanel);

		final JPanel p1WinsPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc_p1WinsPanel = new GridBagConstraints();
		gbc_p1WinsPanel.insets = new Insets(0, 0, 5, 0);
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
					for (int i = 0; i < evaluateButtonPanel.getComponentCount(); i++) {
						if (i == 1 || i == 4) {// player location and QUIT button
							evaluateButtonPanel.getComponent(i).setVisible(true);
						} else {
							evaluateButtonPanel.getComponent(i).setVisible(false);
						}
					}
					comboPanel.setVisible(false);
					picPanel.setVisible(true);
					listPanel.setVisible(false);
					evaluateButtonPanel.setVisible(true);

				} else {
					for (int i = 0; i < evaluateButtonPanel.getComponentCount(); i++) {
						if (i == 0 || i == 4) {// player location and QUIT button
							evaluateButtonPanel.getComponent(i).setVisible(true);
						} else {
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
		gbc_evaluateButton.insets = new Insets(0, 0, 5, 0);
		gbc_evaluateButton.gridx = 0;
		gbc_evaluateButton.gridy = 2;
		evaluateButtonPanel.add(evaluateButton, gbc_evaluateButton);

		evaluateButtonPanel.setBackground(Color.WHITE);

		GridLayout grid = new GridLayout(2, 5, 2, 2);
		picPanel.setLayout(grid);
		guiFrame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		guiFrame.getContentPane().add(comboPanel);
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

		JButton btnHowToPlay = new JButton("ABOUT GAME");
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

		JPanel moneyPanel = new JPanel();
		guiFrame.getContentPane().add(moneyPanel);

		JLabel boardLabel = new JLabel("MONEYBOARD");
		moneyPanel.add(boardLabel);
		moneyPanel.setVisible(false);

		JButton btnMoneyboard = new JButton("MONEYBOARD");
		btnMoneyboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				picPanel.setVisible(false);
				listPanel.setVisible(false);
				evaluateButtonPanel.setVisible(false);
				comboPanel.setVisible(false);
				moneyPanel.setVisible(true);
			}
		});
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

		guiFrame.getContentPane().add(evaluateButtonPanel);

		GridBagConstraints evbc = new GridBagConstraints();
		evbc.insets = new Insets(0, 0, 5, 0);
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
		gbc_QUITButton.insets = new Insets(0, 0, 5, 0);
		gbc_QUITButton.gridx = 0;
		gbc_QUITButton.gridy = 4;
		QUITButton.addActionListener(quitAction);
		evaluateButtonPanel.add(QUITButton, gbc_QUITButton);

		JButton btnNewGame = new JButton("NEW GAME");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guiFrame.dispose();
				new PokerDesign();
			}
		});
		GridBagConstraints gbc_btnNewGame = new GridBagConstraints();
		gbc_btnNewGame.gridx = 0;
		gbc_btnNewGame.gridy = 5;
		evaluateButtonPanel.add(btnNewGame, gbc_btnNewGame);

		guiFrame.getContentPane().add(picPanel);

		JPanel allButtons = new JPanel();
		GridBagConstraints gbc_allButtons = new GridBagConstraints();
		gbc_allButtons.fill = GridBagConstraints.BOTH;
		gbc_allButtons.gridx = 0;
		gbc_allButtons.gridy = 2;
		subPicpanel.add(allButtons, gbc_allButtons);

		JButton raiseButton = new JButton("RAISE");
		allButtons.add(raiseButton);

		JButton showButton = new JButton("SHOW");
		allButtons.add(showButton);

		JButton foldButton = new JButton("FOLD");
		allButtons.add(foldButton);
		guiFrame.getContentPane().add(listPanel);
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
