package fukushima;
class Chap3A {
	static final int SIZE = 5;
	public static void main(String[] args) {
		Ch03A_1();
		Ch03A_2();
		Ch03A_3();
		Ch03A_4();
		Ch03A_5();
		Ch03A_6();
	}
	public static void Ch03A_1() {
		int[] arr = new int[SIZE];
		arr[0] = 0;
		arr[1] = 10;
		arr[2] = 20;
		arr[3] = 30;
		arr[4] = 40;
//		arr[5]=50;
		for (int x : arr) {
			System.out.println(x);
		}
//		for( int i=0;i<SIZE;i++) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	public static void Ch03A_2() {
		class A {
			public A(int p) {
				x = p;
			}

			int x;
		}
		A[] arr = new A[SIZE];
		arr[0] = new A(1);
		arr[1] = new A(11);
		arr[2] = new A(21);
		arr[3] = new A(31);
		arr[4] = new A(41);
		for (A a : arr) {
			System.out.println(a.x);
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].x);
		}
	}
	public static void Ch03A_3() {
		int[] arr = new int[] { 0, 1, 2, 3, 4 };
		System.out.println(arr.length);
		System.out.println(arr[3]);
	}
	public static void Ch03A_4() {
		int[][] arr = new int[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				arr[i][j] = i * j;
			}
		}
		System.out.println("7*8=" + arr[7][8]);
	}
	public static void Ch03A_5() {
		int[][] arr = new int[][] {
				{ 0, 1, 2 },
				{ 3, 4, 5 }
		};
		System.out.println(arr.length);
		System.out.println(arr[0].length);
		System.out.println(arr[1][1]);
		for (int[] x_line : arr) {
			for (int value : x_line) {
				System.out.println(value);
			}
		}
	}
	public static void Ch03A_6() {
		int[][] arr;
		arr = new int[3][];
		arr[0] = new int[2];
		arr[1] = new int[3];
		arr[2] = new int[4];
		for (int x = 0; x < arr.length; x++) {
			for (int y = 0; y < arr[x].length; y++) {
				arr[x][y] = x + y;
			}
		}
		for (int[] x_line : arr) {
			for (int value : x_line) {
				System.out.println(value);
			}
		}
	}
}
