package fukushima;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public class TestMain {
	public static void main(String args[]) {
		var t = new TestMain();
		t.test();
	}

	void test() {
		String[] array= {
				"A","B","a"
		};
//		Arrays.sort(array, new Comparator<String>() {
//			@Override
//			public int compare(String a,String b) {
//				return a.compareToIgnoreCase(b);
//			}
//		});
//		Arrays.sort(array, (String a,String b)-> {
//			return a.compareToIgnoreCase(b);
//		});
		Arrays.sort(array, (a,b)-> a.compareToIgnoreCase(b));
		for(String s : array) {
			System.out.println(s);
		}
		print(5, 3, (x, y) -> x * y);
	}

//	void print(int a, int b, MyFunction f) {
//		int c = f.calc(a, b);
//		System.out.println(c);
//	}
	void print(int a,int b, BinaryOperator<Integer> f) {
		int c=f.apply(a,b);
		System.out.println(c);
	}
}

interface MyFunction {
	abstract public int calc(int x, int y);
}
