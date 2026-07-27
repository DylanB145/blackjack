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
            if (ui.playAgain().equals("n"))
                break;
            aGame.clearHands();
        }
        ui.printOut("Your final win/loss is ".concat(Integer.toString(aGame.getPlayerGainLoss())));
        ui.printOut("The count was ".concat(Integer.toString(aGame.getCount())));
        cleanUp();
    }

    private static boolean round() {
        int bet = ui.getBet();
        aGame.roundStart();
        printDealerHand();
        aGame.dealerAction();
        printPlayerHand();
        if (!(aGame.checkDealerBlackjack() || aGame.checkPlayerBlackjack())) {
            while (!aGame.gameRoundDone) {
                String command = ui.getCommand();
                switch (command) {
                    case "hit":
                        if (aGame.hit()) {
                            playerBusts(bet);
                            return true;
                        }
                        break;
                    case "stand":
                        aGame.gameRoundDone = true;
                        break;
                    case "double":
                        bet = bet * 2;
                        if (aGame.hit()) {
                            playerBusts(bet);
                            return true;
                        }
                        aGame.gameRoundDone = true;
                        break;
                    case "split":
                        // split();
                        // split functionality currently not supported, will just stand for now
                        aGame.gameRoundDone = true;
                        break;
                    case "exit":
                        return false;
                    case "count":
                        ui.printOut("The current count is ".concat(Integer.toString(aGame.getCount())));
                        break;
                    default:
                        ui.printOut("invalid command, input validation not working in ui");
                }
                printPlayerHand();
            }

        } else {
            if (aGame.checkPlayerBlackjack() && !aGame.checkDealerBlackjack()) {
                bet = (int) Math.round(bet * 1.5);
            }
        }
        dealerRound();
        endOfRound(bet);
        return true;
    }

    private static void cleanUp() {
        ui.cleanUp();
    }

    private static void split() {

    }

    private static void dealerRound() {
        while (!aGame.dealerAction())
            printDealerHand();
        printDealerHand();
    }

    private static void playerBusts(int bet) {
        printPlayerHand();
        ui.printOut("You busted and lose ".concat(Integer.toString(bet)));
        aGame.getPlayerWinsResult(bet);

    }

    private static void printPlayerHand() {
        ui.printOut(aGame.playerGetHandToString());
    }

    private static void printDealerHand() {
        ui.printOut(aGame.dealerGetHandToString());
    }

    private static void endOfRound(int bet) {
        game.WinLoseDraw result = aGame.getPlayerWinsResult(bet);
        String concatString = "";
        ui.printOut("Scores: Dealer ".concat(Integer.toString(aGame.getDealerHandValue())).concat(" Player ")
                .concat(Integer.toString(aGame.getPlayerHandValue())));
        if (result == game.WinLoseDraw.win) {
            concatString = "You Won ".concat(Integer.toString(bet).concat(" dollars"));
        } else if (result == game.WinLoseDraw.draw) {
            concatString = "It was a draw, your bet has been returned";
        } else {
            concatString = "You Lost ".concat(Integer.toString(bet).concat(" dollars"));
        }
        ui.printOut(concatString);
    }
}