// TODO Lesson10のファイルを貸出PCから復元する
package fukushima;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class Lesson10 {
	public static void main(String[] args) throws IOException {
		var lsn = new Lesson10();
		String file = "/Users/hata/sample.txt";
		lsn.test(file);
	}
	private void test(String file) throws IOException {
//		if(!fileAccess(file)) return;
		fileWrite(file);
	}
	private boolean fileAccess(String file) {
		Path path = Paths.get(file);
		boolean flag = Files.exists(path);
		System.out.println("exists:" + flag);
		if (!flag) return false;
		flag = Files.isReadable(path);
		System.out.println("readable:" + flag);
		if (!flag) return false;
		flag = Files.isWritable(path);
		System.out.println("writable:" + flag);
		if (!flag) return false;
		flag = Files.isExecutable(path);
		System.out.println("executable:" + flag);
		return true;
	}
	private void fileWrite(String file) throws IOException {
		Path path = Paths.get(file);
		BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND);
		writer.write("現在時刻は\n");
		writer.write(LocalDateTime.now().toString() + "\n");
		writer.close();
	}
}
