public class dealer {
    private hand dealerHand;
    dealer(){
        dealerHand = new hand();
    }
    public void addCard(card aCard){
        dealerHand.addCard(aCard);
    }
    public int getHandValue(){
        return dealerHand.getValue();
    }
    public String getHandToString(){
        return "dealer ".concat(dealerHand.handToString());
    }
    public void clearHand(){
        dealerHand.clearHand();
    }

}
