package fukushima;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Lesson11 {
	public static void main(String[] args) {
		var lsn = new Lesson11();
		// studentは自分のユーザー名
		String file = "/Users/student/sample.txt";
		String ser = "/Users/student/magazine.ser";
		lsn.test(file, ser);
	}
	private void test(String file, String ser) {
		fileRead(file);
//		serialize1(ser);
//		deserialize1(ser);
//		serialize2(ser);
		deserialize2(ser);
	}
	private void fileRead(String file) {
		try {
			Path path = Paths.get(file);
			BufferedReader reader = Files.newBufferedReader(path);
			for (int c = 1; ; c++) {
				String line = reader.readLine();
				if (line == null) break;
				System.out.printf("%02d行目:%s\n", c, line);
			}
			reader.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	void serialize1(String ser) {
		var mag1 = new Magazine("独習Java", 2980);
		try (var oos = new ObjectOutputStream(new FileOutputStream(ser))) {
			oos.writeObject(mag1);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	void deserialize1(String ser) {
		Magazine mag;
		try (var ois = new ObjectInputStream(new FileInputStream(ser))) {
			mag = (Magazine)ois.readObject();
		} catch(ClassNotFoundException | IOException e) {
			e.printStackTrace();
			return;
		}
		System.out.printf("%s : %d\n", mag.getTitle(), mag.getPrice());
	}
	void serialize2(String ser) {
		List<Magazine> list = new LinkedList<Magazine>();
		list.add(new Magazine("金魚の飼い方", 800));
		list.add(new Magazine("カレーの作り方", 500));
		try (var oos = new ObjectOutputStream(new FileOutputStream(ser))) {
			oos.writeObject(list);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	void deserialize2(String ser) {
		List<Magazine> list;
		try(var ois = new ObjectInputStream(new FileInputStream(ser))){
			list = (List<Magazine>)ois.readObject();
		} catch(ClassNotFoundException | IOException e) {
			e.printStackTrace();
			return;
		}
		for (Magazine mag : list) {
			System.out.printf("%s : %d\n", mag.getTitle(), mag.getPrice());
		}
	}
}

class Magazine implements Serializable {
	private static final long serialVersionUID = 1L;
	private String title;
	private int price;
	public Magazine(String title, int price) {
		this.title = title;
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public int getPrice() {
		return price;
	}
}
