import java.util.*;

/**
 * A game of some sort.
 * 
 * @author ()
 * @version (0.1.0)
 */
public class Game {
    private ArrayList<Player> players;
    private Deck deck;
    /**
     * A default Game.
     */
    public Game() {
       players = new ArrayList<Player>();
       deck = new Deck();
    }
    
    /**
     * A game with specific players.
     */
    public Game(ArrayList<Player> players) { }
    
    public void addPlayer()
    {
        players.add(new Player());
    }
    
    public void addPlayer(String name){
        players.add(new Player(name));
    }
    
    public void addPlayer(Player player){
        players.add(player);
    }
    
    public void play(){
        deck.shuffle();
        deck.shuffle();
        ArrayList<Card> temp1 = new ArrayList<Card>();
        ArrayList<Card> temp2 = new ArrayList<Card>();
        for (int i=0;i<5;i++){
            temp1.add(deck.draw());
            temp2.add(deck.draw());
        }
    }
}
