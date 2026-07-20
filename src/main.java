public class main {
    //variables
    private static commandLineInterface ui;
    public static void main(String[] args) {
        start();
    }
    private static void start(){
        ui = new commandLineInterface();
        ui.welcomeMessage();
        round();
    }
    private static void round(){
        int bet = ui.getBet();
        //somehow send bet to game and start game
        //flag is for if game has not yet ended, will probably end up being a method from game
        boolean flag = true;
        while(flag){
            String command = ui.getCommand();
            switch (command) {
                case "hit":
                    hit();
                    break;
            case "stand":
                    stand();
                    flag = false;
                    break;
            case "double":
                    doubleDown();
                    break;
            case "split":
                    split();
                    break;
            case "exit":
                    exit();
                    break;
            
                default:
                    ui.printOut("invalid command, input validation not working in ui");
            }
            //prints out your hand again and prompts for another input
        }
    }
    private static void cleanUp(){
        ui.cleanUp();
    }
    private static void hit(){

    }
    private static void stand(){
        
    }
    private static void doubleDown(){
        
    }
    private static void split(){

    }
    private static void exit(){
        ui.printOut("Exiting now");
        cleanUp();
        System.exit(0);
    }
}