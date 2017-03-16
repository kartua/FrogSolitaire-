///////////////////////////////////////////////////////////////////////////////
//
//
//
//
//
//
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Arrays;
import java.util.Collections;
import jsjf.*;

/**
 *
 * @author Kartua
 */
//
public class Frog {

    PlayingCard[] allCards = new PlayingCard[52];

    LinkedStack deck = new LinkedStack();//Deck card pile
    LinkedStack reserve = new LinkedStack();//Reserve card pile 
    LinkedStack hand = new LinkedStack();//Card in hand pile
    LinkedStack foundation1 = new LinkedStack();//foundation1 pile
    LinkedStack foundation2 = new LinkedStack();//foundation2 pile
    LinkedStack foundation3 = new LinkedStack();//foundation3 pile
    LinkedStack foundation4 = new LinkedStack();//foundation4 pile
    LinkedStack wastePile1 = new LinkedStack();//waste1 pile
    LinkedStack wastePile2 = new LinkedStack();//waste2 pile
    LinkedStack wastePile3 = new LinkedStack();//waste3 pile
    LinkedStack wastePile4 = new LinkedStack();//waste4 pile

    //variables int use to indicate game mode
    final int EMPTY_HAND = 0;
    final int FROM_DECK = 1;
    final int FROM_RESERVE = 2;
    final int FROM_WASTE1 = 3;
    final int FROM_WASTE2 = 4;
    final int FROM_WASTE3 = 5;
    final int FROM_WASTE4 = 6;

    //variable to control that what action should do with card
    private static int mode;

    //**Constructor**
    //
    public Frog() {
        //starting mode with empty hand
        mode = EMPTY_HAND;
        //Create 52 PlayingCard objects which repesent all card 
        //and load into an array
        allCards[0] = new PlayingCard("Clubs", 1, "Cards/ca.jpg");
        allCards[1] = new PlayingCard("Clubs", 2, "Cards/c2.jpg");
        allCards[2] = new PlayingCard("Clubs", 3, "Cards/c3.jpg");
        allCards[3] = new PlayingCard("Clubs", 4, "Cards/c4.jpg");
        allCards[4] = new PlayingCard("Clubs", 5, "Cards/c5.jpg");
        allCards[5] = new PlayingCard("Clubs", 6, "Cards/c6.jpg");
        allCards[6] = new PlayingCard("Clubs", 7, "Cards/c7.jpg");
        allCards[7] = new PlayingCard("Clubs", 8, "Cards/c8.jpg");
        allCards[8] = new PlayingCard("Clubs", 9, "Cards/c9.jpg");
        allCards[9] = new PlayingCard("Clubs", 10, "Cards/c10.jpg");
        allCards[10] = new PlayingCard("Clubs", 11, "Cards/cj.jpg");
        allCards[11] = new PlayingCard("Clubs", 12, "Cards/cq.jpg");
        allCards[12] = new PlayingCard("Clubs", 13, "Cards/ck.jpg");
        allCards[13] = new PlayingCard("Diamonds", 1, "Cards/da.jpg");
        allCards[14] = new PlayingCard("Diamonds", 2, "Cards/d2.jpg");
        allCards[15] = new PlayingCard("Diamonds", 3, "Cards/d3.jpg");
        allCards[16] = new PlayingCard("Diamonds", 4, "Cards/d4.jpg");
        allCards[17] = new PlayingCard("Diamonds", 5, "Cards/d5.jpg");
        allCards[18] = new PlayingCard("Diamonds", 6, "Cards/d6.jpg");
        allCards[19] = new PlayingCard("Diamonds", 7, "Cards/d7.jpg");
        allCards[20] = new PlayingCard("Diamonds", 8, "Cards/d8.jpg");
        allCards[21] = new PlayingCard("Diamonds", 9, "Cards/d9.jpg");
        allCards[22] = new PlayingCard("Diamonds", 10, "Cards/d10.jpg");
        allCards[23] = new PlayingCard("Diamonds", 11, "Cards/dj.jpg");
        allCards[24] = new PlayingCard("Diamonds", 12, "Cards/dq.jpg");
        allCards[25] = new PlayingCard("Diamonds", 13, "Cards/dk.jpg");
        allCards[26] = new PlayingCard("Hearts", 1, "Cards/ha.jpg");
        allCards[27] = new PlayingCard("Hearts", 2, "Cards/h2.jpg");
        allCards[28] = new PlayingCard("Hearts", 3, "Cards/h3.jpg");
        allCards[29] = new PlayingCard("Hearts", 4, "Cards/h4.jpg");
        allCards[30] = new PlayingCard("Hearts", 5, "Cards/h5.jpg");
        allCards[31] = new PlayingCard("Hearts", 6, "Cards/h6.jpg");
        allCards[32] = new PlayingCard("Hearts", 7, "Cards/h7.jpg");
        allCards[33] = new PlayingCard("Hearts", 8, "Cards/h8.jpg");
        allCards[34] = new PlayingCard("Hearts", 9, "Cards/h9.jpg");
        allCards[35] = new PlayingCard("Hearts", 10, "Cards/h10.jpg");
        allCards[36] = new PlayingCard("Hearts", 11, "Cards/hj.jpg");
        allCards[37] = new PlayingCard("Hearts", 12, "Cards/hq.jpg");
        allCards[38] = new PlayingCard("Hearts", 13, "Cards/hk.jpg");
        allCards[39] = new PlayingCard("Spades", 1, "Cards/sa.jpg");
        allCards[40] = new PlayingCard("Spades", 2, "Cards/s2.jpg");
        allCards[41] = new PlayingCard("Spades", 3, "Cards/s3.jpg");
        allCards[42] = new PlayingCard("Spades", 4, "Cards/s4.jpg");
        allCards[43] = new PlayingCard("Spades", 5, "Cards/s5.jpg");
        allCards[44] = new PlayingCard("Spades", 6, "Cards/s6.jpg");
        allCards[45] = new PlayingCard("Spades", 7, "Cards/s7.jpg");
        allCards[46] = new PlayingCard("Spades", 8, "Cards/s8.jpg");
        allCards[47] = new PlayingCard("Spades", 9, "Cards/s9.jpg");
        allCards[48] = new PlayingCard("Spades", 10, "Cards/s10.jpg");
        allCards[49] = new PlayingCard("Spades", 11, "Cards/sj.jpg");
        allCards[50] = new PlayingCard("Spades", 12, "Cards/sq.jpg");
        allCards[51] = new PlayingCard("Spades", 13, "Cards/sk.jpg");
        //shuffle elements in the array
        Collections.shuffle(Arrays.asList(allCards));
//        deal();

    }

    public PlayingCard getreserveCard() {

        return (PlayingCard) reserve.peek();
    }

    public PlayingCard getdeckCard() {

        return (PlayingCard) deck.peek();
    }

    public PlayingCard gethandCard() {

        return (PlayingCard) hand.peek();
    }

    public PlayingCard getwaste1Card() {

        return (PlayingCard) wastePile1.peek();
    }

    public PlayingCard getwaste2Card() {

        return (PlayingCard) wastePile2.peek();
    }

    public PlayingCard getwaste3Card() {

        return (PlayingCard) wastePile3.peek();
    }

    public PlayingCard getwaste4Card() {

        return (PlayingCard) wastePile4.peek();
    }

    public PlayingCard getfound1Card() {
        return (PlayingCard) foundation1.peek();
    }

    public PlayingCard getfound2Card() {

        return (PlayingCard) foundation2.peek();
    }

    public PlayingCard getfound3Card() {

        return (PlayingCard) foundation3.peek();
    }

    public PlayingCard getfound4Card() {

        return (PlayingCard) foundation4.peek();
    }

    public static void setMode(int i) {
        mode = i;
    }

    public static int getMode() {
        return mode;
    }

    /////////////////////GAME PERFOEMING METHODS///////////////////////////
    ///////////////////                          /////////////////////////
    public void deal() {
        int i = 0;
        //push 13 cards in the array to reserve pile
        //if there is 'A'card in the reserve pile, then it will be push to
        //foundation pile.
        while (i < 13) {
            if (allCards[i].getValue() == 1) {
                if (foundation1.isEmpty()) {
                    foundation1.push(allCards[i]);
                } else if (foundation2.isEmpty()) {
                    foundation2.push(allCards[i]);
                } else if (foundation3.isEmpty()) {
                    foundation3.push(allCards[i]);
                } else {
                    foundation4.push(allCards[i]);
                }
            } else {
                reserve.push(allCards[i]);
            }
            i++;
        }
        //push the rest of cards into deck pile.
        while (i < 52) {
            deck.push(allCards[i]);
            i++;
        }
        
        System.out.println(deck.size());
        System.out.println(reserve.size());

    }

    public void getCardFromDeck() {
        hand.push(deck.pop());
        mode = FROM_DECK;

    }

    public void putCardBacktoDeck() {
        deck.push(hand.pop());
        mode = EMPTY_HAND;
    }
//
//    public void pushCardHandtoWaste2() {
//        wastePile2.push(hand.pop());
//        mode = EMPTY_HAND;
//    }
//
//    public void pushCardHandtoWaste3() {
//        wastePile3.push(hand.pop());
//        mode = EMPTY_HAND;
//    }
//
//    public void pushCardHandtoWaste4() {
//        wastePile4.push(hand.pop());
//        mode = EMPTY_HAND;
//    }
//
//    public void pushCardHandtoFound1() {
//        foundation1.push(hand.pop());
//        mode = EMPTY_HAND;
//    }
//
//    public void pushCardHandtoFound2() {
//        foundation2.push(hand.pop());
//        mode = EMPTY_HAND;
//    }
//
//    public void pushCardHandtoFound3() {
//        foundation3.push(hand.pop());
//        mode = EMPTY_HAND;
//    }
//
//    public void pushCardHandtoFound4() {
//        foundation4.push(hand.pop());
//        mode = EMPTY_HAND;
//    }
//
//    public void pushCardWaste2toHand() {
//        hand.push(wastePile2.pop());
//        mode = FROM_WASTE2;
//    }
//
//    public void pushCardWaste3toHand() {
//        hand.push(wastePile3.pop());
//        mode = FROM_WASTE3;
//    }
//
//    public void pushCardWaste4toHand() {
//        hand.push(wastePile4.pop());
//        mode = FROM_WASTE4;
//    }
//
//    public void pushCardReservetoHand() {
//        hand.push(reserve.pop());
//        mode = FROM_RESERVE;
//    }
//
//    public void pushCardHandtoReserve() {
//        reserve.push(hand.pop());
//        mode = EMPTY_HAND;
//    }

    public void playOnFoundation1() {
        if (foundation1.isEmpty() && !hand.isEmpty()) {
            if (gethandCard().getValue() == 1) {
                foundation1.push(hand.pop());
                mode = EMPTY_HAND;
            }
        } else if (foundation1.isEmpty() && !hand.isEmpty()) {
            if (gethandCard().getValue()
                    == getfound1Card().getValue() + 1) {
                foundation1.push(hand.pop());
                mode = EMPTY_HAND;
            }
        }
    }

    public void playOnFoundation2() {
        if (foundation2.isEmpty() && !hand.isEmpty()) {
            if (gethandCard().getValue() == 1) {
                foundation2.push(hand.pop());
                mode = EMPTY_HAND;
            }
        } else if (foundation2.isEmpty() && !hand.isEmpty()) {
            if (gethandCard().getValue()
                    == getfound2Card().getValue() + 1) {
                foundation2.push(hand.pop());
                mode = EMPTY_HAND;
            }
        }
    }

    public void playOnFoundation3() {
        if (foundation3.isEmpty() && !hand.isEmpty()) {
            if (gethandCard().getValue() == 1) {
                foundation3.push(hand.pop());
                mode = EMPTY_HAND;
            }
        } else if (foundation3.isEmpty() && !hand.isEmpty()) {
            if (gethandCard().getValue()
                    == getfound1Card().getValue() + 1) {
                foundation3.push(hand.pop());
                mode = EMPTY_HAND;
            }
        }
    }

    public void playOnFoundation4() {
        if (foundation4.isEmpty() && !hand.isEmpty()) {
            if (gethandCard().getValue() == 1) {
                foundation4.push(hand.pop());
                mode = EMPTY_HAND;
            }
        } else if (foundation4.isEmpty() && !hand.isEmpty()) {
            if (gethandCard().getValue()
                    == getfound4Card().getValue() + 1) {
                foundation4.push(hand.pop());
                mode = EMPTY_HAND;
            }
        }
    }

    public void playOnWaste1() {
        if (hand.isEmpty() && !wastePile1.isEmpty()) {
            hand.push(wastePile1.pop());
            mode = FROM_WASTE1;

        } else if (getMode() == FROM_DECK
                || getMode() == FROM_WASTE1) {
            wastePile1.push(hand.pop());
            mode = EMPTY_HAND;

        }
    }

    public void playOnWaste2() {
        if (hand.isEmpty() && !wastePile2.isEmpty()) {
            hand.push(wastePile2.pop());
            mode = FROM_WASTE2;

        } else if (getMode() == FROM_DECK
                || getMode() == FROM_WASTE2) {
            wastePile2.push(hand.pop());
            mode = EMPTY_HAND;

        }
    }

    public void playOnWaste3() {
        if (hand.isEmpty() && !wastePile3.isEmpty()) {
            hand.push(wastePile3.pop());
            mode = FROM_WASTE3;

        } else if (getMode() == FROM_DECK
                || getMode() == FROM_WASTE3) {
            wastePile3.push(hand.pop());
            mode = EMPTY_HAND;;

        }
    }

    public void playOnWaste4() {
        if (hand.isEmpty() && !wastePile4.isEmpty()) {
            hand.push(wastePile4.pop());
            mode = FROM_WASTE4;

        } else if (getMode() == FROM_DECK
                || getMode() == FROM_WASTE4) {
            wastePile4.push(hand.pop());
            mode = EMPTY_HAND;
        }
    }

    public void playOnDeck() {
        //Check if the deck is empty does no action.
        if (mode == FROM_DECK) {
            deck.push(hand.pop());
            mode = EMPTY_HAND;
        } else if (!deck.isEmpty()) {
            //check if there is no card in the hand,
            //then pop card from deck to the hand
            if (hand.isEmpty()) {
                hand.push(deck.pop());
                mode = FROM_DECK;
            }
        }
    }

    public void playOnReserve() {
        if (hand.isEmpty()) {
            hand.push(reserve.pop());
            mode = FROM_RESERVE;
        } else if (getMode() == FROM_RESERVE) {
            reserve.push(hand.pop());
            mode = EMPTY_HAND;
        }
    }
}
