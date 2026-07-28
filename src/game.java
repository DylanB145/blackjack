public class game {
    // variables
    private deck gameDeck;
    private player gamePlayer;
    private dealer gameDealer;
    public boolean gameRoundDone;

    game() {
        gameDeck = new deck();
        gamePlayer = new player();
        gameDealer = new dealer();
        gameRoundDone = false;
    }

    public void roundStart(int bet) {
        gamePlayer.newRound();
        gameRoundDone = false;
        deckCheckShuffle();
        gamePlayer.setBet(0, bet);
        gamePlayer.addCard(gameDeck.getCard(),0);
        gamePlayer.addCard(gameDeck.getCard(),0);
        gameDealer.addCard(gameDeck.getCard());
    }

    private void deckCheckShuffle() {
        // shuffles at start of round if less then 50 percent of cards are left
        if (gameDeck.getSize() < 156 / 2)
            gameDeck.shuffle();
    }

    public boolean hit(int index) {
        boolean busts = false;
        gamePlayer.addCard(gameDeck.getCard(),index);
        if (gamePlayer.getHandValue(index) > 21)
            busts = true;
        return busts;
    }

    public boolean dealerAction() {
        // returns true if the dealer stands or busts
        if (gameDealer.getHandValue() >= 17)
            return true;
        gameDealer.addCard(gameDeck.getCard());
        return false;
    }

    public enum WinLoseDraw {
        win, lose, draw
    }

    public WinLoseDraw getPlayerWinsResult(int index) {
        int bet = gamePlayer.getBet(index);
        int playerHandValue = gamePlayer.getHandValue(index);
        int dealerHandValue = gameDealer.getHandValue();
        if (playerHandValue <= 21 && playerHandValue == dealerHandValue)
            return WinLoseDraw.draw;
        if (playerHandValue <= 21 && (playerHandValue > dealerHandValue || dealerHandValue > 21)) {
            gamePlayer.addGainLoss(bet);
            return WinLoseDraw.win;
        }
        gamePlayer.addGainLoss(bet * -1);
        return WinLoseDraw.lose;
    }

    public int getPlayerGainLoss() {
        return gamePlayer.getGainLoss();
    }

    public boolean checkPlayerBlackjack(int index) {
        return gamePlayer.getHandValue(index) == 21;
    }

    public boolean checkDealerBlackjack() {
        return gameDealer.getHandValue() == 21;
    }

    public String dealerGetHandToString() {
        return gameDealer.getHandToString();
    }

    public String playerGetHandToString(int index) {
        return gamePlayer.getHandToString(index);
    }

    public void clearHands() {
        gameDealer.clearHand();
        gamePlayer.newRound();
    }
    
    public int getPlayerHandValue(int index){
        return gamePlayer.getHandValue(index);
    }

    public int getDealerHandValue(){
        return gameDealer.getHandValue();
    }
    public int getCount(){
        return gameDeck.getCount();
    }
    public int getHandCount(){
        return gamePlayer.getHandCount();
    }
    public boolean split(int index){
        //if cant split returns false
        boolean tempBool= gamePlayer.split(index);
        if(tempBool){
            hit(index);
            hit(gamePlayer.getHandCount()-1);
        }
        return tempBool;
    }
    public void setBet(int bet,int index){
        gamePlayer.setBet(index, bet);
    }
    public int getBet(int index){
        return gamePlayer.getBet(index);
    }
    public void removeHand(int index){
        gamePlayer.removeHand(index);
    }
}
