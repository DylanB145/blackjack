import java.util.ArrayList;

public class hand {
    // variables
    private int value;
    private ArrayList<card> cards;
    private int bet;

    hand() {
        value = 0;
        cards = new ArrayList<card>();
        bet = 0;
    }

    public String handToString() {
        String output = "";
        for (int i = 0; i < cards.size(); ++i) {
            output = output.concat(cards.get(i).getRank());
            output = output.concat(" ");
        }
        return output;
    }

    public int addCard(card aCard) {
        cards.add(aCard);
        value += aCard.getValue();
        if (value > 21)
            aceChanger();
        return value;
    }

    public int getValue() {
        return value;
    }

    private void aceChanger() {
        for (int i = 0; i < cards.size(); ++i) {
            if (cards.get(i).getValue() == 11) {
                cards.get(i).setAce();
                value -= 10;
                break;
            }
        }
    }

    public void clearHand() {
        cards.clear();
        value = 0;
        bet = 0;

    }

    public boolean checkSplit() {
        if (cards.size() != 2)
            return false;
        return ((cards.get(0).getValue() == cards.get(1).getValue())
                || (cards.get(0).getRank().equals("A") && cards.get(1).getRank().equals("A")));
    }

    public card removeSplitCard() {
        card tempCard = cards.remove(0);
        value -= tempCard.getValue();
        tempCard.set11();
        return tempCard;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int newBet) {
        bet = newBet;
    }
}
