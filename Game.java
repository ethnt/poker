import java.util.*;

/**
 * A game of some sort.
 * 
 * @author ()
 * @version (0.1.0)
 */
public class Game {
    ArrayList<Player> player;
    /**
     * A default Game.
     */
    public Game() {
       player = new ArrayList<Player>();
    }
    
    /**
     * A game with specific players.
     */
    public Game(ArrayList<Player> players) { }
    
    public void addPlayer()
    {
        player.add(new Player());
    }
    
    public void addPlayer(String name){
        player.add(new Player(name));
    }
    
    public void addPlayer(Player play)
    {
        player.add(play);
    }
}
