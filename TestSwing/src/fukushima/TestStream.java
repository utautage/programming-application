package fukushima;

import java.util.List;
import java.util.stream.IntStream;

public class TestStream {
	List<Student> students = List.of(
			new Student("田中", "一郎", 75, 65),
			new Student("山田", "花子", 23, 45),
			new Student("千代田", "次郎", 64, 75),
			new Student("神田", "美奈", 90, 80),
			new Student("大手", "サンタ", 50, 60),
			new Student("内田", "幸", 77, 85),
			new Student("霞", "次郎", 95, 55));

	public static void main(String[] args) {
		var t = new TestStream();
		t.test();
	}

	private void test() {
		// 課題1 全員の情報を表示せよ（解答付き）
		students.stream().forEach(System.out::println);
		System.out.println("--");

		// 課題2 数学が60点未満の者を抽出せよ（解答付き）
		students.stream().filter(p -> p.math < 60).forEach(System.out::println);
		System.out.println("--");

		// 以下の課題から自力で下線部を埋めてください
		// 課題3 数学が10点未満の者がいればtrueいなければfalseを出力せよ
		System.out.println(students.stream().anyMatch(p -> p.math < 10));
		System.out.println("--");

		// 課題4 数学の得点順に並び替えよ
		students.stream().sorted((y, x) -> x.math - y.math).forEach(System.out::println);
		System.out.println("--");

		// 課題5 英語の得点順に並び替えよ、ただし英語の得点が赤点の者を除く
		students.stream().filter(p -> p.eng >= 60).sorted((p, q) -> q.eng - p.eng).forEach(System.out::println);
		System.out.println("--");

		// 課題6 合計点でトップの者を選び出せ
		System.out.println(students.stream().max((x, y) -> x.math + x.eng - y.math - y.eng).get());
		System.out.println("--");

		// 課題7 合計点で2位と3位の者を選び出せ
		students.stream().sorted((p, q) -> q.eng + q.math - p.eng - p.math).skip(1).limit(2).forEach(System.out::println);
		System.out.println("--");

		// 課題8 英語の得点数の平均点を求めよ
		int total = students.stream().map(p -> p.eng).reduce((p, q)-> p + q).get();
		long count = students.stream().count();
		double average = (double)total / count;
		System.out.println("total=" + total);
		System.out.println("count=" + count);
		System.out.println("average=" + average);
		System.out.println("--");

		// 課題9 100以下の素数を表示してください(For文は使わない）
		IntStream.rangeClosed(2, 100).filter(p -> !IntStream.rangeClosed(2, p / 2).anyMatch(q -> p % q == 0)).forEach(System.out::println);
	}

}

class Student {
	String fname;
	String gname;
	int math;
	int eng;

	public Student(String fname, String gname, int math, int eng) {
		this.fname = fname;
		this.gname = gname;
		this.math = math;
		this.eng = eng;
	}

	@Override
	public String toString() {
		return fname + " " + gname + " Math=" + math + " E=" + eng;
	}
}