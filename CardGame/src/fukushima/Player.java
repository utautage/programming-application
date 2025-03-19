package fukushima;

import java.util.List;

public class Player extends Deck {
	private final String name;
	protected String getName() {
		return name;
	}
	public Player(String name) {
		super(0);
		this.name=name;
	}
	@Override
	public Card draw() {
		List<Card> list=super.getList();
		if(list.size()==0) return null;
		return super.draw();
	}
	public int score() {
	      int score = 0;
	      int ace = 0;
	      for (Card card :super.getList()) {
	        if(card.isFace()==false) {
	             return 0;
	        }
	        if (card.getNum() > 10) {
	          score += 10;
	        } else if (card.getNum() == 1) {
	          ace++;
	          score++;
	        } else {
	          score += card.getNum();
	        }
	      }
	      if (ace != 0 && score < 12) {
	        score += 10;
	      }
	      return score;
	}
	public int eyes() {
		int eyes=0;
		for(Card card: getList()) {
			if(card.isFace()==false) {
				return 0;
			}
		}
		for (Card card :getList()) {
			if(card instanceof RoyalCard) {
				RoyalCard royalCard=(RoyalCard)card;
				eyes+=royalCard.getEyes();
			}
		/* ここは自分で考えてください。
		*カードが絵札かどうかチェック
*絵札ならRoyalCardにダウンキャストして目の数をeyesに加算
		*/
		}
		return eyes;
	}
	@Override
	public String toString() {
		String st=name;
		int score=score();
		int eyes=eyes();
		return st+":"+super.toString()+(score==0?"":"("+score+"+"+eyes+")");
	}
}
