package fukushima;
import java.util.Scanner;
public class Input {
	static Scanner sc = new Scanner(System.in);
	public static String getLine(String prom) {
		System.out.print(prom);
		return sc.next();
	}
	public static String getHS() {
		String str;
		do {
			str=getLine("H(it) or S(tay)").toUpperCase();
		} while(!(str.equals("H") || str.equals("S")));
		return str;
	}
	public static String getCNQ() {
		String str;
		do {
			str=getLine("C(ontinue), N(ew Game) or Q(uit)").toUpperCase();
		} while(!(str.equals("C") || str.equals("N") || str.equals("Q")));
		return str;
	}
	public static void main(String[] args) {
		String line=getHS();
		System.out.println(line);
	}
}
