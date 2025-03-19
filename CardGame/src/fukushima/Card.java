package fukushima;
public class Card {
	private final int num;
	private final Suit suit;
	private boolean face;
	protected int getNum() {
		return num;
	}
	protected Suit getSuit() {
		return suit;
	}
	public boolean isFace() {
		return face;
	}
	public void setFace(boolean face) {
		this.face = face;
	}
	public Card(Suit suit,int num) {
		this.suit=suit;
		this.num=num;
		setFace(true);
	}	
	public String toString() {
		String str="";
		if(isFace()==false) return "*:*";
		switch(getSuit()) {
		case Heart:
			str="♥︎";
			break;
		case Diamond:
			str="︎♦";
			break;
		case Spade:
			str="︎♠";
			break;
		case Club:
			str="︎♣";
			break;
		}
		str+=":";
		switch(getNum()) {
		case 1:
			str+="A";
			break;
		case 10:
			str+="T";
			break;
		case 11:
			str+="J";
			break;
		case 12:
			str+="Q";
			break;
		case 13:
			str+="K";
			break;
		default:
			str+=getNum();
		}
		return str;
	}
}
