/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author 1511 FOX
 */
public class SortingTest {
    
    private static class Card implements Comparable<Card>{
        public int rank;
        public String suit;

        public Card(int rank, String suit) {
            this.rank = rank;
            this.suit = suit;
        }

        @Override
        public int compareTo(Card c) {
            
            if(!this.suit.equals(c.suit)){
                return this.suit.compareTo(c.suit);
            }else{
                return (this.rank - c.rank);
            }
        }

        @Override
        public String toString() {
            return "[" + this.suit + " , " + this.rank + "]";
        }
        
    }
    
    public static void main(String[] args) {
        ArrayList<Card> a = new ArrayList<Card>();
        a.add(new Card(6, "hearts"));
        a.add(new Card(2, "diamonds"));
        a.add(new Card(10, "club"));
        a.add(new Card(6, "club"));
        a.add(new Card(3, "spades"));
        a.add(new Card(2, "spades"));
        
        Collections.sort(a);
//
//        Collections.reverse(a);
//        
//        Collections.shuffle(a);
        
        System.out.println(a);
    }
}
