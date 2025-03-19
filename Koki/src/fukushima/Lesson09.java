package fukushima;
public class Lesson09 {
	public static void main(String[] args) {
		var lsn = new Lesson09();
		lsn.test();
	}
	void test() {
		int a = -1;
		int b = 0;
		String result = convert(5);
		if (result == null) {
			System.out.println("エラーが発生しました");
			return;
		}
		System.out.println(result);
		double answer = 0;
		try {
			answer = div(a, b);
		} catch(Exception e) {
			System.out.println("割り算エラーが発生しました");
		}
		System.out.printf("%d / %d = %f\n", a, b, answer);
		Card card;
		try {
			card = new Card('X', 14);
		} catch(SuitErrorException e) {
			System.out.println(e.getMessage());
		} catch(NumberErrorException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("処理を終了します");
	}
	String convert(int a) {
		if (a == 0) return null;
		return a + "メートルは" + (a * 100) + "センチ";
	}
	double div(int x, int y) throws Exception {
		if (y == 0) throw new Exception();
		return (double)x / y;
	}
}
class Card {
	final char suit;
	final int number;
	public Card(char suit, int number) throws SuitErrorException, NumberErrorException {
		if (suit != '♥' && suit != '♠' && suit != '♦' && suit != '♣')
			throw new SuitErrorException("与えられた" + suit + "は非許容です");
		if (number <= 0 || number >= 14)
			throw new NumberErrorException("与えられた数値" + number + "は範囲外です");
		this.suit = suit;
		this.number = number;
	}
}
class SuitErrorException extends Exception {
	public SuitErrorException(String string) {
		super(string);
	}
}
class NumberErrorException extends Exception {
	public NumberErrorException(String string) {
		super(string);
	}
}
