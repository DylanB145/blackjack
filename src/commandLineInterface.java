import java.util.Scanner;

public class commandLineInterface {
    // variables
    Scanner inputScanner;

    commandLineInterface() {
        inputScanner = new Scanner(System.in);
    }

    void printOut(String text) {
        System.out.println(text);
    }
    void cleanUp(){
        inputScanner.close();
    }
    int getBet() {
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

    String getCommand() {
        while (true) {
            String temp = (inputScanner.nextLine()).toLowerCase();
            if (temp.equals("hit") || temp.equals("stand") || temp.equals("double") || temp.equals("split"))
                return temp;
            if (temp.equals("exit")) {

                return temp;
            }
            if (!temp.equals("help")) {
                printOut("Invalid command");
            }
            printCommandHelp();
        }
    }

    void printCommandHelp() {
        printOut("Valid inputs are: Hit, Stand, Double, and Split. You may also say quit to quit at any time.");
    }

    void welcomeMessage() {
        printOut("This is a basic three deck blackjack game. Dealer stands at a soft 17");
    }

}
