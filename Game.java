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
        Player player1 = new Player();
        Player player2 = new Player("A Challenger");
        System.out.println(player1.getName()+" and " + player2.getName() + " are now playing a game of poker.");
        deck.shuffle();
        deck.shuffle();
        ArrayList<Card> temp1 = new ArrayList<Card>();
        ArrayList<Card> temp2 = new ArrayList<Card>();
        for (int i=0;i<5;i++){
            temp1.add(deck.draw());
            temp2.add(deck.draw());
        }
        player1.giveHand(temp1);
        player2.giveHand(temp2);
        Hand hand1 = player1.getHand();
        Hand hand2 = player2.getHand();
        int winner = hand1.compareTo(hand2);
        if(winner == 1){
            System.out.println(player1.getName() + " is the winner!");
        }
        else if(winner ==-1){
            System.out.println(player2.getName() + " is the winner!");
        }
        else{
            System.out.println("We have a tie!");
        }
        System.out.println(player1);
        System.out.println(player2);
    }
}
