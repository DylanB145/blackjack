public class dealer {
    private hand dealerHand;
    dealer(){
        dealerHand = new hand();
    }
    void newRound(){
        dealerHand = new hand();
    }
    void addCard(card aCard){
        dealerHand.addCard(aCard);
    }
    int getHandValue(){
        return dealerHand.getValue();
    }
    String getHandToString(){
        return "dealer ".concat(dealerHand.handToString());
    }
}
