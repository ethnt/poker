import java.util.*;
public class Deck
{
    private ArrayList<Card> deck;
    public Deck()
    {
        deck = new ArrayList<Card>();
        String s = "spades";
        String d = "diamonds";
        String c = "clubs";
        String h = "hearts";
        for (int i = 2; i<15; i++)
        {
            deck.add(new Card(""+i,s));
            deck.add(new Card(""+i,d));
            deck.add(new Card(""+i,c));
            deck.add(new Card(""+i,h));
        }
    }
    
    public void shuffle()
    {
        Collections.shuffle(deck);
    }
    
    public boolean equals(Deck other)
    {
        return this == other;
    }
    
    public Card draw()
    {
        return deck.remove(0);
    }
    public String toString()
    {
        String result = "";
        for (int i = 0; i<52 ; i++)
        {
            result += deck.get(i).value() + " " + deck.get(i).suit() +" ";
        }
        return result;
    }
}