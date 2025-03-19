package fukushima;
import java.util.HashMap;
import java.util.Map;
public class Lesson02 {
	Node root;
	public static void main(String[] args) {
		var lesson02=new Lesson02();
		lesson02.setup();
		lesson02.test();
	}
	private void setup() {
		//データ作成
		Node ball=new Node("0:野外 1:屋内");
		ball.childs=new HashMap<String,Entry>() {
			{
				put("0",new Leaf("野球部"));
				put("1",new Leaf("バレー"));
			}
		};
		Node noball=new Node("0:野外 1:屋内");
		noball.childs=new HashMap<String,Entry>() {
			{
				put("0",new Leaf("陸上"));
				put("1",new Leaf("剣道"));
			}
		};
		Node taiiku=new Node("0:球技 1:非球技");
		taiiku.childs=new HashMap<String,Entry>() {
			{
				put("0",ball);
				put("1",noball);
			}
		};
		Node contests=new Node("0:コンピュータ系 1:ロボット系 2:デザイン系");
		contests.childs=new HashMap<String,Entry>(){
			{
				put("0",new Leaf("プログラミング同好会"));
				put("1",new Leaf("ロボット部"));
				put("2",new Leaf("建築創造デザイン部"));
			}
		};
		Node bunka=new Node("0:音楽 1:コンテスト系 2:その他");
		bunka.childs=new HashMap<String,Entry>() {
			{
				put("0",new Leaf("MMC"));
				put("1",contests);
				put("2",new Leaf("英語部"));
			}
		};
		root=new Node("0:体育会系 1:文化系");
		root.childs=new HashMap<String,Entry>(){
			{
				put("0",taiiku);
				put("1",bunka);
			}
		};
	}
	private void test() {
		Entry entry=root;//アップキャスト
		for(;;) {
			if(entry instanceof Leaf) {//entryはLeafであるか検査する
				System.out.printf("お勧めは %s です\n",entry.getName());
				break;
			}
			while(true) {//正しく次Entryが得られるまでループする
				String str=Input.getLine(entry.getName()+ " ですか？");
				Node node=(Node)entry; //ダウンキャスト
				entry = node.childs.get(str);//次エントリ
				if(entry!=null) {
					break;
				}
			}
		}
	}
}
abstract class Entry{
	protected String name;
	public String getName() {
		return name;
	};
	public Entry(String name) {
		this.name=name;
	}
}
class Leaf extends Entry{
	public Leaf(String name) {
		super(name);
	}
}
class Node extends Entry{
	Map<String,Entry> childs=new HashMap<String,Entry>();
	public Node(String name) {
		super(name);
	}
}
//class Input{
//	static Scanner sc = new Scanner(System.in);
//	public static String getLine(String prom) {
//		System.out.print(prom);
//        String str = sc.next();
//        return str;
//	}
//}
