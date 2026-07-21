public class player {
    //variables
    private hand playerHand;
    private int gainLoss;


    player(){
        gainLoss=0;
        playerHand = new hand();
    }
    void newRound(){
        playerHand = new hand();
    }
    void addCard(card aCard){
        playerHand.addCard(aCard);
    }
    int getHandValue(){
        return playerHand.getValue();
    }
    int getGainLoss(){
        return gainLoss;
    }
    void addGainLoss(int bet){
        gainLoss+=bet;
    }
}
