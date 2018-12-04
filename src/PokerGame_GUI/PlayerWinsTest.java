/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PokerGame_GUI;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author kotin
 */
public class PlayerWinsTest {
    public static void main(String[] args)
    {
        Evaluate ev = new Evaluate();
        ArrayList<String> player_labels = new ArrayList<>(Arrays.asList("10C", "JC", "QC", "KC", "AC"));
        ArrayList<String> cpu_labels = new ArrayList<>(Arrays.asList("10C", "9C", "10D", "9D", "10H"));
        
        if(ev.evaluateHand(cpu_labels) < ev.evaluateHand(player_labels))
            System.out.println("Player Wins!!");
        else
            System.out.println("CPU Wins!!");
    }
}
