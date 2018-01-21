import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FB {
	public static void main(String[] args) throws IOException {
		File file = new File("a.txt");
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			process(line);
		}
		buffer.close();
	}

	private static void process(String line) {
		String[] nos = line.split(" ");
		int x = new Integer(nos[0]), y = new Integer(nos[1]), z = new Integer(
				nos[2]);
		for (int i = 1; i <= z; i++) {
			if (i >= x && i >= y && i % x == 0 && i % y == 0) {
				System.out.print("FB");
			} else if (i >= x && i % x == 0) {
				System.out.print("F");
			} else if (i >= y && i % y == 0) {
				System.out.print("B");
			} else {
				System.out.print(i);
			}
			System.out.print(" ");
		}
		System.out.println();

	}
}
