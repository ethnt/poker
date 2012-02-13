import java.util.*;

/**
 * A Player in a Game.
 * 
 * @author () 
 * @version (0.1.0)
 */
public class Player implements Comparable{
    private String n;
    private Hand hand;
    /**
     * The default Player, Joe Shmoe.
     */
    public Player() {
       n = "Joe Shmoe";
       }

    /**
     * A Player with a name you choose.
     */
    public Player(String name) {
       n = name;
       }
       
    public String getName(){
        return n;
    }
    
    public int compareTo(Object other){
        if(this==other)
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }
    
    public Hand getHand(){
        return hand;
    }
    
    public void giveHand(ArrayList<Card> cards){
        hand = new Hand(cards);
    }
    
    //public void addCardToHand(Card card){
        //placeholder for extension
    //}
}
