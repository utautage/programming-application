package fukushima;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class RoyalCard extends Card {
	static private HashMap<Suit, int[]> eyes=new HashMap<Suit,int[]>();
	static {
		eyes.put(Suit.Heart, new int[]{1,2,2});
		eyes.put(Suit.Diamond, new int[]{2,2,1});
		eyes.put(Suit.Spade, new int[]{1,2,2});
		eyes.put(Suit.Club, new int[]{2,2,2});
	}
	public RoyalCard(Suit suit,int num) {
		super(suit,num);
		if(num<=10 || num>13) {
			throw new IllegalArgumentException("範囲外");
		}
	}
	public int getEyes() {
		return eyes.get(getSuit())[getNum()-11];
	}
	@Override
	public String toString() {
		return super.toString()+getEyes();
	}
	public static void main(String[] args) {
		List<Card> cardList=new ArrayList<Card>();
		List<RoyalCard> royalList=new ArrayList<RoyalCard>();
		RoyalCard royalCard=new RoyalCard(Suit.Spade,13);
		Card numCard=new Card(Suit.Heart,1);
		cardList.add(numCard);
		cardList.add(royalCard);
//		royalList.add(numCard);
		royalList.add(royalCard);
		for(Card card : cardList) {
			System.out.println(card.toString());
		}
	}
}
