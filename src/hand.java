import java.util.ArrayList;

public class hand {
    //variables
    private int value;
    private ArrayList<card> cards;

    hand(){
        value = 0;
        cards = new ArrayList<card>();
    }
    public String handToString(){
        String output = "";
        for(int i=0;i<cards.size();++i){
            output = output.concat(cards.get(i).getRank());
            output = output.concat(" ");
        }
        return output;
    }
    public int addCard(card aCard){
        cards.add(aCard);
        value+=aCard.getValue();
        if(value>21) aceChanger();
        return value;
    }

    public int getValue(){
        return value;
    }
    private void aceChanger(){
        for(int i=0; i<cards.size();++i){
            if(cards.get(i).getValue()==11){
                cards.get(i).setAce();
                value-=10;
                break;
            }
        }
    }
    public void clearHand(){
        cards.clear();
        value = 0;
    }
}
