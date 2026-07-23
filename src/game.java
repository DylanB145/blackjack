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

    public void roundStart() {
        gameRoundDone = false;
        deckCheckShuffle();
        gamePlayer.addCard(gameDeck.getCard());
        gamePlayer.addCard(gameDeck.getCard());
        gameDealer.addCard(gameDeck.getCard());
    }

    private void deckCheckShuffle() {
        // shuffles at start of round if less then 50 percent of cards are left
        if (gameDeck.getSize() < 156 / 2)
            gameDeck.shuffle();
    }

    public boolean hit() {
        boolean busts = false;
        gamePlayer.addCard(gameDeck.getCard());
        if (gamePlayer.getHandValue() > 21)
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

    public WinLoseDraw getPlayerWinsResult(int bet) {
        int playerHandValue = gamePlayer.getHandValue();
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
    public boolean checkPlayerBlackjack(){
        return gamePlayer.getHandValue()==21;
    }
    public String dealerGetHandToString(){
        return gameDealer.getHandToString();
    }
        public String playerGetHandToString(){
        return gamePlayer.getHandToString();
    }
    public void clearHands(){
        gameDealer.clearHand();
        gamePlayer.clearHand();
    }
}
