import java.util.ArrayList;

public class hand {
    //variables
    private int value;
    private ArrayList<card> cards;

    hand(){
        value = 0;
        cards = new ArrayList<card>();
    }
    String handToString(){
        String output = "";
        for(int i=0;i<cards.size();++i){
            output.concat(cards.get(i).getRank());
            output.concat(" ");
        }
        return output;
    }
    void addCard(card aCard){
        cards.add(aCard);
    }
}
