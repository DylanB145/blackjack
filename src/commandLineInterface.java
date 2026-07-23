import java.util.Scanner;

public class commandLineInterface {
    // variables
    Scanner inputScanner;

    commandLineInterface() {
        inputScanner = new Scanner(System.in);
    }

    public void printOut(String text) {
        System.out.println(text);
    }
    public void cleanUp(){
        inputScanner.close();
    }
    public int getBet() {
        printOut("How much would you like to bet");
        int tempInt = 20;
        boolean flag = true;
        while (flag) {
            try {
                tempInt = inputScanner.nextInt();
                if (tempInt > 500 || tempInt < 20)
                    printOut("Maximum bet is 500, minimum bet is 20");
                else {
                    flag = false;
                }
            } catch (Exception e) {
                printOut("Invalid input, please try again");
            }
            inputScanner.nextLine();
        }
        return tempInt;
    }

    public String getCommand() {
        while (true) {
            String temp = (inputScanner.nextLine()).toLowerCase();
            if (temp.equals("hit") || temp.equals("stand") || temp.equals("double") || temp.equals("split")||temp.equals("exit"))
                return temp;
            if (!temp.equals("help")) {
                printOut("Invalid command");
            }
            printCommandHelp();
        }
    }

    public void printCommandHelp() {
        printOut("Valid inputs are: Hit, Stand, Double, and Split. You may also say exit to exit at any time.");
    }

    public void welcomeMessage() {
        printOut("This is a basic three deck blackjack game. Dealer stands at a soft 17");
    }
    public String playAgain(){
        printOut("Would you like to play again? (y/n)");
        while(true){
            String temp = (inputScanner.nextLine()).toLowerCase();
                        if (temp.equals("y") || temp.equals("n"))
                return temp;
            printOut("invalid answer");
        }
    }

}
