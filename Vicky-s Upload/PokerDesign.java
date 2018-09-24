package PokerGame_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PokerDesign {
	
	public PokerDesign()
	{
	JFrame guiFrame = new JFrame();
	guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	guiFrame.setTitle("Example GUI");
	guiFrame.setSize(500,400);
	//Center Frame
	guiFrame.setLocationRelativeTo(null);
	//Options for the JComboBox
	String[] firstOptions = {"Rules", "Start Game", "Scoreboard"
	,"Shop", "Date and Time"};
	//Options for the JList
	String[] Rules = {"AKQJ10 series", "All 4 and 1 different","3 and 2 same pair"};
	//The first JPanel contains a JLabel and JCombobox
	final JPanel comboPanel = new JPanel(new GridBagLayout());
	GridBagConstraints gc = new GridBagConstraints();
	//gc.insets = new Insets(10,10,10,10);
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
	final JPanel listPanel = new JPanel();
	listPanel.setVisible(false);
	JLabel listLbl = new JLabel("Best Hand from top to bottom");
	JList ruleList = new JList(Rules);
	ruleList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
	listPanel.add(listLbl);
	listPanel.add(ruleList);
	
	
	JButton begButton = new JButton( "Click to BEGIN");
	//The ActionListener class is used to handle the
	//event that happens when the user clicks the button.
	//As there is not a lot that needs to happen we can
	//define an anonymous inner class to make the code simpler.
	begButton.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent event)
	{
	//When the fruit of veg button is pressed
	//the setVisible value of the listPanel and
	//comboPanel is switched from true to
	//value or vice versa.
	listPanel.setVisible(!listPanel.isVisible());
	comboPanel.setVisible(!comboPanel.isVisible());
	}
	});
	//The JFrame uses the BorderLayout layout manager.
	//Put the two JPanels and JButton in different areas.
	guiFrame.add(comboPanel, BorderLayout.NORTH);
	
	guiFrame.add(listPanel, BorderLayout.CENTER);
	guiFrame.add(begButton,BorderLayout.SOUTH);
	guiFrame.setBackground(Color.DARK_GRAY);
	//make sure the JFrame is visible
	guiFrame.setVisible(true);
	}

}
