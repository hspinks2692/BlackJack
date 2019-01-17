import java.util.*;
import java.nio.*;

public class BlackJack {
    public static ArrayList<String> Discard = new ArrayList<String>();
    public static int Played = 0;
    
    public static ArrayList CreateDeck(){
        ArrayList<String> deck = new ArrayList<String>();
        String suits = "CHSD";
        String values = "A234567890JQK";
        String card = "";
        for (int a = 0; a < 1; a++){ /**Change the middle number for multiple decks**/
            for (int i = 0; i < suits.length(); i++){
                for (int j = 0; j < values.length(); j++){
                    if (values.charAt(j) == '0'){
                        card = "[10" + suits.charAt(i) + "]";
                    }
                    else{
                        card = "[" + values.charAt(j) + suits.charAt(i) + "]";
                    }
                    deck.add(card);
                }
            }
        }
        return deck;
    }
    
    public static ArrayList FirstShuffle(ArrayList deck){
        ArrayList<String> shuffled = new ArrayList<String>();
        int Size = deck.size();
        Random rand = new Random();
        int spot = 0;
        while (deck.size() > 0){
            spot = rand.nextInt(deck.size());
            shuffled.add(deck.get(spot).toString());
            deck.remove(spot);
        }
        return shuffled;
    }
    
    public static boolean hasAce(ArrayList hand){
        for (int i = 0; i < hand.size(); i++){
            if (hand.get(i).toString().charAt(1) == 'A'){
                return true;
            }
        }
        return false;
    }
    
    public static boolean isAce(String card){
        if (card.charAt(1) == 'A'){
            return true;
        }
        return false;
    }
    
    public static String Deal(ArrayList deck){
        String Card = deck.get(0).toString();
        BlackJack.Discard.add(deck.get(0).toString());
        BlackJack.Played++;
        deck.remove(0);
        return Card;
    }
    
    public static int Values(String Card){
        char card = Card.charAt(1);
        if (card == '1' || card == 'J' || card == 'Q' || card == 'K'){
            return 10;
        }
        else if(card == 'A'){
            return 1;
        }
        else{
            return Character.getNumericValue(card);
        }
    }
    
    public static ArrayList Start(ArrayList deck, ArrayList dealer, ArrayList player, int dV, int pV){
        dealer.add(Deal(deck));
        player.add(Deal(deck));
        dealer.add(Deal(deck));
        player.add(Deal(deck));
        dV = Values(dealer.get(1).toString());
        pV = Values(player.get(0).toString()) + Values(player.get(1).toString());
        
        System.out.println("Dealer: [??] " + dealer.get(1).toString() + "    " + dV + "?");
        System.out.println();
        System.out.println("Player: " + player.get(0).toString() + 
                            " " + player.get(1).toString() + "    " + pV);
        
        return null;
    }
    
    public static void main(String args[]){
        ArrayList<String> deck = new ArrayList<String>();
        ArrayList<String> dealer = new ArrayList<String>();
        ArrayList<String> player = new ArrayList<String>();
        int dValue = 0;
        int pValue = 0;
        deck = CreateDeck();
        deck = FirstShuffle(deck);
        deck = Start(deck, dealer, player, dValue, pValue);
        System.out.println(dealer);
        //Deal(deck);
        //System.out.println(deck.size());
        //System.out.println(deck);
    }
    
    public void test(){
        ArrayList<String> deck = new ArrayList<String>();
        ArrayList<String> Test = new ArrayList<String>();
        deck = CreateDeck();
        deck = FirstShuffle(deck);
        String test = "";
        for (int i = 0; i < 52; i++){
            Test.add(Deal(deck));
            System.out.println(Test);
            if (hasAce(Test) == true){
                Test = new ArrayList<String>();
            }
        }
        //System.out.println(Test);
    }
}
