package fukushima;
public class Lesson04 {
	public static void main(String[] args) {
		var game = new GCPMatch(new Human(), new Losing());
		game.start();
	}
}
class GCPMatch {
	private final int round = 10;
	private IPlayer p1;
	private IPlayer p2;
	public GCPMatch(IPlayer p1,IPlayer p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	private int judge(char p1, char p2) {
		if (p1 == p2) return 0;
		else if (p1 == 'G' && p2 == 'C' || p1 == 'C' && p2 == 'P' || p1 == 'P' && p2 == 'G') return 1;
		return -1;
	}
	void start() {
		System.out.println("=========Start Match=======");
		int p1_win = 0;
		int p1_lose = 0;
		for(int i = 0; i < round; i++) {
			char p1Hand = p1.getNext();
			char p2Hand = p2.getNext();
			int result = judge(p1Hand, p2Hand);
			System.out.printf("%d p1=%c p2=%c ", i, p1Hand, p2Hand);
			switch (result) {
			case 1:
				p1.setResult(1);
				p2.setResult(-1);
				p1_win++;
				System.out.println("p1 won");
				break;
			case -1:
				p1.setResult(-1);
				p2.setResult(1);
				p1_lose++;
				System.out.println("p1 lost");
				break;
			default:
				p1.setResult(0);
				p2.setResult(0);
				System.out.println("Even");
				break;
			}
		}
		System.out.printf("Overall %d to %d (%d)\n", p1_win, p1_lose, round - p1_win - p1_lose);
	}
}
interface IPlayer {
	public char getNext();
	public void setResult(int result);
}
class Human implements IPlayer {
	@Override
	public char getNext() {
		return Input.getGCP();
	}
	@Override
	public void setResult(int result) {}
}
class RandomStrategy implements IPlayer {
	@Override
	public char getNext() {
		return "GCP".charAt((int)(Math.random() * 3.0));
	}
	@Override
	public void setResult(int result) {}
}
class Chasing implements IPlayer {
	char hand = 'P';
	@Override
	public char getNext() {
		return hand;
	}
	@Override
	public void setResult(int result) {
		switch (result) {
		case 1:
			switch (hand) {
			case 'P':
				hand = 'G';
				break;
			case 'G':
				hand = 'C';
				break;
			case 'C':
				hand = 'P';
				break;
			}
			break;
		case -1:
			switch (hand) {
			case 'P':
				hand = 'C';
				break;
			case 'G':
				hand = 'P';
				break;
			case 'C':
				hand = 'G';
				break;
			}
			break;
		}
	}
}
class Losing extends Chasing {
	@Override
	public void setResult(int result) {
		super.setResult(result);
		switch (hand) {
		case 'G':
			hand = 'C';
			break;
		case 'C':
			hand = 'P';
			break;
		case 'P':
			hand = 'G';
			break;
		}		
	}
}
