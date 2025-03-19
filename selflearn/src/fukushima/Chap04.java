package fukushima;
import java.util.Arrays;
import java.util.Collections;
class Chap04 {
    public static void main(String[] args) {
        ch04_7();
    }
    public static void ch04_1() {
        int x = 10;
        if (x <= 10) {
            System.out.println("A");
        } else if (x <= 20) {
            System.out.println("B");
        } else {
            System.out.println("C");
        }
    }
    public static void ch04_2() {
        int i = 1;
        int j = 0;

        if (i == 1) {
            System.out.println("A");
            if (j == 0) {
                System.out.println("B");
            } else {
                System.out.println("C");
            }
        } else {
            System.out.println("D");
        }
    }
    public static void ch04_3() {
        String s = "Hello";
        switch (s) {
            case "Test":
                System.out.println("A");
                break;
            case "Hello":
                System.out.println("B");
            case "Thank you":
                System.out.println("C");
                break;
            default:
                System.out.println("D");
        }
    }
    public static void ch04_4() {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                continue;
            }
            System.out.println(i);
        }
        // System.out.println(i);
    }
    public static void ch04_5() {
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=9;j++) {
				System.out.print(String.format("%3d",i*j));
			}
			System.out.print("\n");
		}
	}
    public static void ch04_6() {
		String[] animals = new String[] { "パンダ", "キリン", "熊", "犬" };
		for (int i = 0; i < animals.length; i++) {
			System.out.println(animals[i]);
		}
		for (String animal:animals) {
			System.out.println(animal);
		}
	}
    public static void ch04_7() {
        final int MAX = 100;
        boolean[] prime = new boolean[MAX];
        for (int i = 0; i < MAX; i++) {
            prime[i] = true;
        }
        prime[0] = prime[1] = false;
        for (int i = 0; i < MAX; i++) {
            if (prime[i]) {
                for (int k = 2; k < MAX/2; k++) {
                    if (i*k < MAX) {
                        prime[i*k] = false;
                    } else {
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < MAX; i++) {
            if (prime[i]) {
                System.out.print(String.format(" %d", i));
            }
        }
    }
    public static void ch04_8() {
    	System.out.println(11*(0+10)/2);
    }
    public static void ch04_9() {
        int[] data = new int[] { 30, 70, 55, 37, 84 };
        int sum=0;
        for(int value:data) {
        	sum+=value;
        }
        System.out.println(sum/data.length);
    }
    public static void ch04_10() {
        Integer[] data = new Integer[] { 30, 70, 55, 37, 84 };
        Arrays.sort(data, Collections.reverseOrder());
        System.out.println(Arrays.toString(data)); 
    }
}
