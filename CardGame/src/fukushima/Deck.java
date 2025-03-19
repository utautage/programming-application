package fukushima;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
public class Deck {
	private List<Card> list=new LinkedList<Card>();
	List<Card> getList() {
		return list;
	}
	void setList(List<Card> list) {
		this.list = list;
	}
	public Deck() {
		for(Suit suit : Suit.values()) {
			for(int num=1; num<=13; num++) {
				if(num>=11) {
					list.add(new RoyalCard(suit,num));
				}else{
					list.add(new Card(suit,num));
				}
			}
		}
	}
	public Deck(int dummy) {}
	public String toString() {
		String str="";
		for(Card card:getList()) {
			str+=card.toString()+" ";
		}
		return str;
	}
	public Card draw() {
		return getList().remove(0);
	}
	public void add(Card card) {
		getList().add(card);
	}
	private void swap(int x,int y) {
		Card tmp=getList().get(x);
		getList().set(x,getList().get(y));
		getList().set(y,tmp);
	}
	public void shuffle() {
		int numCard=getList().size();
		Random random=new Random();
		for(int i=0;i<numCard;i++) {
			int n=random.nextInt(numCard);
			swap(i,n);
		}
	}
	public static void main(String[] args) {
		Deck deck=new Deck();
		deck.swap(3, 5);
		System.out.println(deck);
	}
}
