import java.util.*;

/**
 * A Player in a Game.
 * 
 * @author (Brett Morris & Ethan Turkeltaub) 
 * @version (0.1.0)
 */
public class Player implements Comparable<Player> {
    private String name;
    private Hand hand;
    
    /**
     * The default Player, Joe Shmoe.
     */
    public Player() {
        name = "Joe Shmoe";
    }

    /**
     * A Player with a name you choose.
     */
    public Player(String player) {
        name = player;
    }
    
    public String getName(){
        return name;
    }
    
    public int compareTo(Player other){
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
    
    public String toString(){
        return name + " has " + hand;
    }
    //public void addCardToHand(Card card){
        //placeholder for extension
    //}
}
