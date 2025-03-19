package fukushima;
import java.time.LocalDateTime;
public class Chap3 {
	public static void main(String[] args) {
		Ch3_1();
		Ch3_2_3();
		Ch03_3_6();
		Ch03_9();
		Ch03_10A();
		Ch03_13();
		Ch03_19();
		Ch03_Bit1();
		Ch03_Bit2();
		Ch03_Bit3();
	}
	private static void mark() {
		System.out.println("========");
	}
	public static void Ch3_1() {
		mark();
		System.out.println(1 + 2);
		System.out.println("a" + 5);
		System.out.println(5 + "b");
		System.out.println("1" + "2");
		System.out.println(LocalDateTime.now());
//		System.out.println(1+LocalDateTime.now());
	}
	public static void Ch3_2_3() {
		mark();
		@SuppressWarnings("unused")
		var result = "";
		for (var i = 0; i < 100000; i++) {
//			 result+="いろは";
		}
		var builder = new StringBuilder();
		for (var i = 0; i < 100000; i++) {
			builder.append("いろは");
		}
		return;
	}
	public static void Ch03_3_6() {
		mark();
		var i = 3;
		var j = ++i;
		System.out.println(i);
		System.out.println(j);
		i = 3;
		j = i++;
		System.out.println(i);
		System.out.println(j);
		i = 3;
		j = --i;
		System.out.println(i);
		System.out.println(j);
		i = 3;
		j = i--;
		System.out.println(i);
		System.out.println(j);
		// System.out.println(5/0);
		// System.out.println(5%0);
		System.out.println(5.0 / 0);
		System.out.println(5d % 0);
	}
	public static void Ch03_9() {
		mark();
		var x = 1;
		var y = x;
		x += 10;
		System.out.println(x);
		System.out.println(y);
		StringBuilder builder1 = new StringBuilder("あいう");
		StringBuilder builder2 = builder1;
		builder1.append("えお");
		System.out.println(builder1);
		System.out.println(builder2);
	}
	public static void Ch03_10A() {
		mark();
		StringBuilder builder1 = new StringBuilder("あいう");
		StringBuilder builder2 = new StringBuilder("あいう");
		System.out.println(builder1 == builder2);
		System.out.println(builder1.compareTo(builder2));
		String str1 = "あいう";
		String str2 = "あいう";
		System.out.println(str1 == str2);
		System.out.println(str1 == "あ" + "いう");
		str1 += "!";
		str2 += "!";
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));

	}
	public static void Ch03_13() {
		mark();
		final double EPSILON = 0.00001;
		var x = 0.2 * 3;
		var y = 0.6;
		System.out.println(x == y);
		System.out.println(x - y);
		System.out.println(Math.abs(x - y) < EPSILON);
		x = 0.125 * 3;
		y = 0.375;
		System.out.println(x == y);
		System.out.println(x - y);
	}
	public static void Ch03_19() {
		mark();
		String url = "http://www.fukui-nct.ac.jp";
		System.out.println(url.startsWith("http://") && url.endsWith("ac.jp") || url.contains("fukui"));
	}
	public static void disp(int i) {
		mark();
		System.out.println("---------------------");
		System.out.println(i);
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toOctalString(i));
		System.out.println(Integer.toHexString(i));
	}
	public static void Ch03_Bit1() {
		mark();
		int i = 10;
		int j = ~i;
		disp(i);
		disp(j);
		j++;
		disp(j);
	}
	public static void Ch03_Bit2() {
		mark();
		int i = 0xA5;
		int j = ~i;
		disp(i);
		disp(j);
		i <<= 2;
		j >>= 1;
		disp(i);
		disp(j);
	}
	public static void Ch03_Bit3() {
		mark();
		int i = 0xAA;
		disp(i);
		disp(i & 0xF8);
		disp(i | 0x07);
	}
}
