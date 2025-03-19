package fukushima;
import java.util.Random;
public class Lesson01 {
	public static void main(String[] args) {
		var lesson01=new Lesson01();
		lesson01.test01();
	}
	private void test01() {
		int N=1000;
		int total=0;
		int[] count=new int[13];
		Dice dice1=new Dice();
		Dice dice2=new Dice();
		for(int i=0;i<N;i++) {
			dice1.roll();
			dice2.roll();
			total=dice1.getSpots()+dice2.getSpots();
			count[total]++;
		}
		int scale=N/100;
		if(scale==0)scale=1;
		for(int i=2;i<=12;i++) {
			int starts=count[i]/scale;
			System.out.printf("%02d:%6d:",i,count[i]);
			for(int j=0;j<starts;j++) {
				System.out.print("*");
			}
			System.out.printf("\n");
		}
	}
}
class Dice {
	private Random random=new Random();
	private int spots=1;
	void roll() {
		spots=random.nextInt(6)+1;
//		long current= System.nanoTime();
//		System.out.println(current/10000);
//		spots=(int)((current/10000)%6)+1;
	}
	public int getSpots() {
		return spots;
	}
}
