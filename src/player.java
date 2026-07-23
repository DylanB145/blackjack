public class player {
    //variables
    private hand playerHand;
    private int gainLoss;


    player(){
        gainLoss=0;
        playerHand = new hand();
    }
    public void newRound(){
        playerHand = new hand();
    }
    public void addCard(card aCard){
        playerHand.addCard(aCard);
    }
    public int getHandValue(){
        return playerHand.getValue();
    }
    public int getGainLoss(){
        return gainLoss;
    }
    public void addGainLoss(int bet){
        gainLoss+=bet;
    }
    public String getHandToString(){
        return playerHand.handToString();
    }
    public void clearHand(){
        playerHand.clearHand();
    }
}
