package fukushima;
public class Practice04 {
	private static int[] score = new int[] {45,82,92,23,62,95,20,77,55,82};
	public static void main(String[] args) {
		var p=new Practice04();
		p.test01();
		p.test02();
		p.test03();
		p.test04(score.length-1);
		p.test03();
	}
	/**
	 * 列挙<br>
	 * 59以下の要素数を表示
	 */
	private void test01() {
		int count=0;
		for(int i=0;i<score.length;i++) {
			if(score[i]<=59) {
				count++;
			}
		}
		System.out.println("count="+count);
	}
	/**
	 * 入れ替え<br>
	 * index1番と3番の位置を入れ替える
	 */
	private void test02(){
		swap(1,3);
		disp();
	}
	/** 
	 * 配列の内容を表示する
	 */
	private void disp() {
		for(int i=0;i<score.length;i++) {
			System.out.print(" "+score[i]);
		}
		System.out.print("\n");
	}
	/**
	 * 入れ替え
	 * @param x 一方のインデックス
	 * @param y 他方のインデックス
	 */
	private void swap(int x,int y) {
		int temp;
		temp=score[x];
		score[x]=score[y];
		score[y]=temp;
	}
	/**
	 * 入れ替え応用<br>
	 * scoreを逆順に並び替え
	 */
	private void test03() {
		int n=score.length;
		for(int i=0;i<=n/2;i++ ) {
			swap(i,n-i-1);
		}
		disp();
	}
	/**
	 * 0からrightの範囲での最大値をright位置に移動する
	 * @param right右端
	 */
	private void test04(int right) {
		int n=score.length;
		if(right<=0||right>=n) {
			return;
		}
		for(int i=0;i<right;i++) {
			if(score[i]>score[i+1]) {
				swap(i,i+1);
			}
		}
		disp();
		test04(right-1);
	}
}
