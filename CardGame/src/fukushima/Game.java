package fukushima;
import java.util.List;
public class Game {
	private Deck deck;
	private Player player;
	private Player dealer;
	private int coins=5;
	public static void main(String[] args) {
		do {} while(new Game().start()!=0);
	}
 	public int start() {
		String name=Input.getLine("Enter your Name: ");
		player=new Player(name);
		dealer= new Player("Dealer");
		deck=new Deck();
		int retcode=0;
		for(;;) {
			int result=oneGame();
			if(result==1) {
				coins++;
				System.out.println("*You WIN coins="+coins);
			}else {
				coins--;
				System.out.println("*Lost coins="+coins);
			}
			if(coins==0) {
				System.out.println("Game over");
				return 0;
			}
			String cnq=Input.getCNQ();
			if(cnq.equals("C")==true) continue;
			if(cnq.equals("N")==true) retcode=1;
			break;
		}
		return retcode;	
	}
	private void clean(Player p) {
		for(;;) {
			Card card=p.draw();
			if(card==null) {
				break;
			}
			deck.add(card);
		}
	}
	private int playerturn() {
		int score=player.score();
		for(;;) {
			String hs=Input.getHS();
			if(hs.equals("S")==true) {
				break;
			}
			player.add(deck.draw());
			System.out.println(player);
			score=player.score();
			if(score>21) {
				break;
			}
		}
		return score;
	}
	private int dealerturn(int players) {
		int score;
		List<Card> list=dealer.getList();
		Card card=list.get(1);//2枚目のカード
		card.setFace(true);//表に向ける
		for(;;) {
			System.out.println(dealer);
			score=dealer.score();
			if(score>21) {
				break;
			}
			if(players<=score) {
				break;
			}
			dealer.add(deck.draw());
		}
		return score;
	}
	public int oneGame() {
		clean(player);
		clean(dealer);
		deck.shuffle();
		dealer.add(deck.draw());
		Card card=deck.draw();
		card.setFace(false);
		dealer.add(card);
		System.out.println(dealer);
		player.add(deck.draw());
		player.add(deck.draw());
		System.out.println(player);
		int players=playerturn();
		if(players>21) {
			return -1;
		}
		int dealers=dealerturn(players);
		if(dealers >21) {
			return 1;
		}
		if(dealers>players) {
			return -1;
		}
		if(dealers == players) {
			if(dealer.eyes() >= player.eyes()) {
				return -1;
			}
		}
		return 1;
	}
}
