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
		gbl_subPicpanel.rowHeights = new int[] { 100, 0, 100, 100, 0 };
		gbl_subPicpanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_subPicpanel.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
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
		
		JLabel lblAmount = new JLabel("CPU $");
		p1cards.add(lblAmount);

		JPanel addMoney = new JPanel();
		GridBagConstraints gbc_addMoney = new GridBagConstraints();
		gbc_addMoney.insets = new Insets(0, 0, 5, 0);
		gbc_addMoney.fill = GridBagConstraints.BOTH;
		gbc_addMoney.gridx = 0;
		gbc_addMoney.gridy = 1;
		subPicpanel.add(addMoney, gbc_addMoney);
		
		JLabel label_1 = new JLabel("$");
		addMoney.add(label_1);
		
		JSlider slider = new JSlider();
		slider.setMinorTickSpacing(10);
		slider.setMajorTickSpacing(20);
		slider.setSnapToTicks(true);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setForeground(new Color(0, 0, 0));
		slider.setValue(10);
		slider.setToolTipText("Amount to  raise");
		addMoney.add(slider);

		JButton raiseButton = new JButton("RAISE");
		raiseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		addMoney.add(raiseButton);


		JPanel p2cards = new JPanel();
		GridBagConstraints gbc_p2cards = new GridBagConstraints();
		gbc_p2cards.fill = GridBagConstraints.BOTH;
		gbc_p2cards.insets = new Insets(0, 0, 5, 0);
		gbc_p2cards.gridx = 0;
		gbc_p2cards.gridy = 2;
		subPicpanel.add(p2cards, gbc_p2cards);
		FlowLayout fl_p2cards = new FlowLayout(FlowLayout.CENTER, 5, 5);
		p2cards.setLayout(fl_p2cards);
		
		JLabel lblNewLabel = new JLabel("YOU $");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		p2cards.add(lblNewLabel);

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
		
		ActionListener quitAction = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				picPanel.setVisible(false);
				listPanel.setVisible(false);
				comboPanel.setVisible(true);
			}
		};

		BACKButton.addActionListener(quitAction);
		GridBagConstraints gbc_BACKButton = new GridBagConstraints();
		gbc_BACKButton.insets = new Insets(0, 0, 5, 0);
		gbc_BACKButton.gridx = 2;
		gbc_BACKButton.gridy = 0;
		listPanel.add(BACKButton, gbc_BACKButton);

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

		guiFrame.getContentPane().add(picPanel);

		JPanel allButtons = new JPanel();
		GridBagConstraints gbc_allButtons = new GridBagConstraints();
		gbc_allButtons.fill = GridBagConstraints.BOTH;
		gbc_allButtons.gridheight = 2;
		gbc_allButtons.gridx = 0;
		gbc_allButtons.gridy = 3;
		subPicpanel.add(allButtons, gbc_allButtons);
		allButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel evLbl = new JLabel("CLICK TO");
		allButtons.add(evLbl);
		evLbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		JButton evaluateButton = new JButton("EVALUATE");
		evaluateButton.setEnabled(false);
		allButtons.add(evaluateButton);

		JButton btnNewGame = new JButton("NEW GAME");
		allButtons.add(btnNewGame);
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guiFrame.dispose();
				new PokerDesign();
			}
		});

		JButton QUITButton = new JButton("BACK");
		allButtons.add(QUITButton);
		QUITButton.setBackground(Color.RED);
		QUITButton.addActionListener(quitAction);

		evaluateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (highCard(player_one_names) > highCard(player_two_names)) {
					evLbl.setText("YOU WON THE DEAL");
				} else {
					evLbl.setText("YOU LOST THE DEAL");
				}
				comboPanel.setVisible(false);
				picPanel.setVisible(true);
				listPanel.setVisible(false);
				evaluateButton.setVisible(false);
				addMoney.setVisible(false);
			}
		});
		
		JButton foldButton = new JButton("FOLD");
		foldButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (highCard(player_one_names) > highCard(player_two_names)) {
					evLbl.setText("YOU COULD HAVE WON");
				} else {
					evLbl.setText("BETTER YOU GAVE UP");
				}
				comboPanel.setVisible(false);
				picPanel.setVisible(true);
				listPanel.setVisible(false);
				evaluateButton.setVisible(false);
				addMoney.setVisible(false);
			}
		});
		addMoney.add(foldButton);
		
		JButton showButton = new JButton("SHOW");
		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i < 5; i++) {
					label[i][0].setIcon(cards.getImageIcon(player_one_names.get(i)));// player 1 cards
					label[i+5][0].setIcon(cards.getImageIcon(player_one_names.get(i)));// player 2 cards
					evaluateButton.setEnabled(true);
					foldButton.setEnabled(false);
					raiseButton.setEnabled(false);
				}
			}
		});
		addMoney.add(showButton);
		
		
		
		
		
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

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
