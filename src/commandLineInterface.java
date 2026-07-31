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

    public int getBet() {
        // bet returns -1 if user would like to exit
        printOut("How much would you like to bet. You may also exit");
        int bet = 20;
        String input;
        boolean flag = true;
        Scanner stringScanner;
        while (flag) {
            input = inputScanner.nextLine();
            if (input.toLowerCase().equals("exit"))
                return -1;
            stringScanner = new Scanner(input);
            try {
                bet = stringScanner.nextInt();
                if (bet > 500 || bet < 20)
                    printOut("Maximum bet is 500, minimum bet is 20");
                else {
                    flag = false;
                }
            } catch (Exception e) {
                printOut("Invalid input, please try again");
            }
            stringScanner.close();
        }
        return bet;
    }

    public String getCommand() {
        while (true) {
            String temp = (inputScanner.nextLine()).toLowerCase();
            if (temp.equals("hit") || temp.equals("stand") || temp.equals("double") || temp.equals("split")
                    || temp.equals("exit") || temp.equals("count"))
                return temp;
            if (!temp.equals("help")) {
                printOut("Invalid command");
            }
            printCommandHelp();
        }
    }

    public void printCommandHelp() {
        printOut("Valid inputs are: Hit, Stand, Double, Split and Count. You may also say exit to exit at any time.");
    }

    public void welcomeMessage() {
        printOut("This is a basic three deck blackjack game. Dealer stands at a soft 17");
    }

}
