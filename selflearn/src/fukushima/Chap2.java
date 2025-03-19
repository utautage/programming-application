package fukushima;
public class Chap2 {
	public static void main(String[] args) {
		Test02_1();
		Test02_2();
	}
	@SuppressWarnings("unused")
	public static void Test02_1(){
		int a;
//		a="Hello";
		var b=1;
//		v="Hello";
		Object c=0;
		c="Hello";
//		var d;
//		d=1;
	}
	public static void Test02_2(){
		int a0=1;
		double b0=1.1;
//		a0=b0;
		b0=a0;
		var c0=a0+b0;
		System.out.println("c0="+c0);
	}
}
