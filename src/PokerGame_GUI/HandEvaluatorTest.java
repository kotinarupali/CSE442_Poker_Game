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
public class HandEvaluatorTest {
    public static void main(String[] args)
    {
        Evaluate ev = new Evaluate();
        
        // if all hands work then it should be 10 by the end
        int check = 0;       
        // player_labels are always changed and sent to the hand evaluator to check for each rule
        
        // for royal flush
        ArrayList<String> royalFlush_labels = new ArrayList<>(Arrays.asList("10C", "JC", "QC", "KC", "AC"));
        if (ev.evaluateHand(royalFlush_labels) == 23) 
            {
               System.out.println("Royal Flush successfully evaluated");
               check++;
            }
        else
            System.out.println("Failed at evauating Royal Flush");
        
        // for straight flush
        ArrayList<String> straightFlush_labels = new ArrayList<>(Arrays.asList("10C", "9C", "8C", "7C", "6C"));
        if (ev.evaluateHand(straightFlush_labels) == 22) 
            {
               System.out.println("Straight Flush successfully evaluated");
               check++;
            }
        else
            System.out.println("Failed at evauating Straight Flush");
        
        // for four of a kind
        ArrayList<String> fourOfAKind_labels = new ArrayList<>(Arrays.asList("10S", "4D", "10C", "10H", "10D"));
        if (ev.evaluateHand(fourOfAKind_labels) == 21) 
            {
               System.out.println("Four of a Kind successfully evaluated");
               check++;
            }
        else
            System.out.println("Failed at evauating Four of a Kind");
        
        // for full house
        ArrayList<String> fullHouse_labels = new ArrayList<>(Arrays.asList("10C", "9C", "10D", "9D", "10H"));
        if (ev.evaluateHand(fullHouse_labels) == 20) 
            {
               System.out.println("Full House successfully evaluated");
               check++;
            }
        else
            System.out.println("Failed at evauating Full House");
        
        // for flush
        ArrayList<String> flush_labels = new ArrayList<>(Arrays.asList("10C", "4C", "2C", "7C", "QC"));
        if (ev.evaluateHand(flush_labels) == 19) 
            {
               System.out.println("Flush successfully evaluated");
               check++;
            }
        else
            System.out.println("Failed at evauating Flush");
        
        // for straight 
        ArrayList<String> straight_labels = new ArrayList<>(Arrays.asList("6C", "5H", "4D", "3S", "2C"));
        if (ev.evaluateHand(straight_labels) == 18) 
            {
               System.out.println("Straight successfully evaluated");
               check++;
            }
        else
            System.out.println("Failed at evauating Straight");
        
        // for three of a kind
        ArrayList<String> threeOfAKind_labels = new ArrayList<>(Arrays.asList("10S", "4D", "6C", "10H", "10D"));
        if (ev.evaluateHand(threeOfAKind_labels) == 17) 
            {
               System.out.println("Three of a Kind successfully evaluated");
               check++;
            }
        else
            System.out.println("Failed at evauating Three of a Kind");
        
        // for two pair
        ArrayList<String> twoPair_labels = new ArrayList<>(Arrays.asList("10C", "9C", "10D", "9D", "AH"));
        if (ev.evaluateHand(twoPair_labels) == 16) 
            {
               System.out.println("Two Pair successfully evaluated");
               check++;
            }
        else
            System.out.println("Failed at evauating Two Pair");
        
        // for one pair
        ArrayList<String> onePair_labels = new ArrayList<>(Arrays.asList("4C", "9C", "10D", "9D", "AH"));
        if (ev.evaluateHand(onePair_labels) == 15) 
            {
               System.out.println("One Pair successfully evaluated");
               check++;
            }
        else
            System.out.println("Failed at evauating One Pair");
        
        // for high Card
        ArrayList<String> highCard_labels = new ArrayList<>(Arrays.asList("10C", "4C", "JD", "9D", "KH"));
        if (ev.evaluateHand(highCard_labels) < 15) 
            {
               System.out.println("High Card successfully evaluated which is: " + ev.evaluateHand(highCard_labels));
               check++;
            }
        else
            System.out.println("Failed at evauating High Card");
        
        if (check == 10)
        {
            System.out.println();
            System.out.println("All successful!!");
        }
        else
        {
            System.out.println();
            System.out.println("One of the rules is not being evaluated properly");
        }  
    }
}
