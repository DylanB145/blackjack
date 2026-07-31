public class main {
    // variables
    private static commandLineInterface ui;
    private static game aGame;

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        ui = new commandLineInterface();
        aGame = new game();
        ui.welcomeMessage();
        while (round()) {
            aGame.clearHands();
        }
        ui.printOut("Your final win/loss is ".concat(Integer.toString(aGame.getPlayerGainLoss())));
        ui.printOut("The count was ".concat(Integer.toString(aGame.getCount())));
        cleanUp();
    }

    private static boolean round() {
        int bet = ui.getBet();
        if (bet==-1)return false;
        boolean playerBusts;
        aGame.roundStart(bet);
        printDealerHand();
        aGame.dealerAction();
        for (int i = 0; i < aGame.getHandCount(); ++i) {
                    printPlayerHand(i);
            playerBusts = false;
            if ((!(aGame.checkDealerBlackjack() || aGame.checkPlayerBlackjack(i))) ) {
                aGame.gameRoundDone = false;
                while (!aGame.gameRoundDone) {
                    String command = ui.getCommand();
                    switch (command) {
                        case "hit":
                            if (aGame.hit(i)) {
                                playerBusts(i);
                                i--;
                                playerBusts = true;
                            }
                            break;
                        case "stand":
                            aGame.gameRoundDone = true;
                            break;
                        case "double":
                            aGame.setBet(bet * 2, i);
                            if (aGame.hit(i)) {
                                playerBusts(i);
                                i--;
                                playerBusts = true;
                            }
                            aGame.gameRoundDone = true;
                            break;
                        case "split":
                            split(i);
                            break;
                        case "exit":
                            return false;
                        case "count":
                            ui.printOut("The current count is ".concat(Integer.toString(aGame.getCount())));
                            break;
                        default:
                            ui.printOut("invalid command, input validation not working in ui");
                    }
                    if (!playerBusts&&!command.equals("stand"))
                        printPlayerHand(i);
                }

            } else if (aGame.checkPlayerBlackjack(i) && !aGame.checkDealerBlackjack()&& aGame.getHandCount() == 1) {
                    aGame.setBet((int)Math.round(bet * 1.5), i);
            }

        }
        if (!(aGame.getHandCount() == 0)) {
            dealerRound();
            endOfRound();
        }
        return true;
    }

    private static void cleanUp() {
        ui.cleanUp();
    }

    private static void split(int index) {
        if(!aGame.split(index))ui.printOut("Unable to ");
    }

    private static void dealerRound() {
        while (!aGame.dealerAction())
            printDealerHand();
        printDealerHand();
    }

    private static void playerBusts(int index) {
        printPlayerHand(index);
        ui.printOut("You busted and lose ".concat(Integer.toString(aGame.getBet(index))));
        aGame.getPlayerWinsResult(index);
        aGame.removeHand(index);
        aGame.gameRoundDone = true;
    }

    private static void printPlayerHand(int index) {
        ui.printOut(aGame.playerGetHandToString(index));
    }

    private static void printDealerHand() {
        ui.printOut(aGame.dealerGetHandToString());
    }

    private static void endOfRound() {
        ui.printOut("Scores: Dealer ".concat(Integer.toString(aGame.getDealerHandValue())));
        int gainLossForRound = 0;
        for (int i = 0; i < aGame.getHandCount(); ++i) {
            game.WinLoseDraw result = aGame.getPlayerWinsResult(i);
            ui.printOut("Hand "+Integer.toString(i)+":"+(Integer.toString(aGame.getPlayerHandValue(i))));

            if (result == game.WinLoseDraw.win) {
                gainLossForRound += aGame.getBet(i);
            } else if (!(result == game.WinLoseDraw.draw)) {
                gainLossForRound -= aGame.getBet(i);
            }
        }
        if (gainLossForRound == 0)
            ui.printOut("You broke even");
        else if (gainLossForRound < 0)
            ui.printOut("You lost " + Integer.toString(gainLossForRound*-1) + " Total Dollars.");
        else
            ui.printOut("You Won " + Integer.toString(gainLossForRound) + " Total Dollars.");
    }
}