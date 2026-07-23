import java.util.ArrayList;
import java.util.Random;

public class deck {

    private ArrayList<card> cards;
    private Random r;

    deck() {
        cards = new ArrayList<card>();
        shuffle();
        r = new Random();
 
    }

    public void shuffle() {
        // sets cards to a new 3 deck arraylist
        if (cards.size() != 0)
            return;
        for (int deck = 0; deck < 3; ++deck) {
            for (int suit = 0; suit < 4; ++suit) {
                card.suitEnum tempEnum = card.suitEnum.Clubs;
                for (int value = 2; value <= 10; ++value) {

                    switch (suit) {
                        case 0:
                            tempEnum = card.suitEnum.Spades;
                            break;
                        case 1:
                            tempEnum = card.suitEnum.Hearts;
                            break;
                        case 2:
                            tempEnum = card.suitEnum.Diamonds;
                            break;
                        case 3:
                            tempEnum = card.suitEnum.Clubs;
                            break;

                        default:
                            System.err.println("invalid card suit creation");
                            tempEnum = card.suitEnum.Clubs;
                            break;
                    }
                    cards.add(new card(value, Integer.toString(value), tempEnum));
                }
                cards.add(new card(10, "J", tempEnum));
                cards.add(new card(10, "Q", tempEnum));
                cards.add(new card(10, "K", tempEnum));
                cards.add(new card(11, "A", tempEnum));
            }
        }
    }


    public card getCard() {
        // returns a random card
        return cards.remove(r.nextInt(cards.size()));
    }
    public int getSize(){
        return cards.size();
    }
}
