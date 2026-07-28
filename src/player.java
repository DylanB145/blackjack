import java.util.ArrayList;

public class player {
    // variables
    private ArrayList<hand> playerHand;
    private int gainLoss;

    player() {
        gainLoss = 0;
        playerHand = new ArrayList<hand>();
    }

    public void newRound() {
        playerHand.clear();
        playerHand.add(new hand());
    }

    public void addCard(card aCard, int index) {
        playerHand.get(index).addCard(aCard);
    }

    public int getHandValue(int index) {
        return playerHand.get(index).getValue();
    }

    public int getGainLoss() {
        return gainLoss;
    }

    public void addGainLoss(int bet) {
        gainLoss += bet;
    }

    public String getHandToString(int index) {
        return "Hand " + Integer.toString(index) + ": " + playerHand.get(index).handToString();
    }

    public int getHandCount() {
        return playerHand.size();
    }

    public boolean split(int index) {
        if (!playerHand.get(index).checkSplit())
            return false;
        addSplitHand(playerHand.get(index).removeSplitCard(), playerHand.get(index).getBet());
        return true;
    }

    private void addSplitHand(card aCard, int bet) {
        playerHand.add(new hand());
        playerHand.get(playerHand.size()-1).addCard(aCard);
        playerHand.get(playerHand.size()-1).setBet(bet);
    }

    public void setBet(int index, int bet) {
        playerHand.get(index).setBet(bet);
    }

    public int getBet(int index) {
        return playerHand.get(index).getBet();
    }

    public void removeHand(int index) {
        playerHand.remove(index);
    }
}
