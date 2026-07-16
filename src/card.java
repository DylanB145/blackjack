public class card {
    public enum suitEnum {
        Spades, Hearts, Diamonds, Clubs
    }

    // variables
    private int value;
    private String rank;
    private suitEnum suit;

    card(int value, String rank, suitEnum suit) {
        this.value = value;
        this.rank = rank;
        this.suit = suit;
    }

    // getters
    public int getValue() {
        return value;
    }

    public String getRank() {
        return rank;
    }

    public suitEnum getSuit() {
        return suit;
    }
    
    // setters
    public void setAce() {
        // will only be used to change value from 11 to 1 for aces
        if (value == 11)
            value = 1;
        else
            System.err.println("Invalid value change");
    }
}
