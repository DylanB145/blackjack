import java.util.ArrayList;
import java.util.Random;

public class deck {

    private ArrayList<card> cards;
    private Random r;

    deck() {
        shuffle();
        r = new Random();
    }

    private void shuffle() {
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

    public class cardAndShuffleFlag {
        public card aCard;
        public boolean shuffleFlag;

        cardAndShuffleFlag(card tempCard, boolean tempShuffleFlag) {
            // shuffle flag is true if needed to shuffle
            aCard = tempCard;
            shuffleFlag = tempShuffleFlag;
        }
    }

    cardAndShuffleFlag getCard() {
        // returns a random card, and if the deck needed to be shuffled. Neccessary for
        // when card counting is created
        boolean shuffleFlag = false;
        if (cards.size() == 0) {
            shuffleFlag = true;
            shuffle();
        }
        return new cardAndShuffleFlag(cards.remove(r.nextInt(cards.size())), shuffleFlag);
    }
}
