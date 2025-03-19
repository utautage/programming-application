package fukushima;
import java.util.Scanner;
public class Input {
	static Scanner sc = new Scanner(System.in);
	public static String getLine(String prom) {
		System.out.print(prom);
		return sc.next();
	}
	public static char getGCP() {
		String str;
		for(;;) {
			str = getLine("G / C / P => ").toUpperCase();
			if(str.equals("G") || str.equals("C") || str.equals("P")) break;
		}
		return str.charAt(0);
	}
}
