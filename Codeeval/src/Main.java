import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader buffer = new BufferedReader(new FileReader(new File(args[0])));) {
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				if (0 < line.length())
					process(line);
			}
		} catch (Exception e) {

		}
	}

	static ArrayList<String> al = new ArrayList<String>();

	public static void process(String s) {
		getPermutations(s.length(), s.split(""));
		StringBuffer sb = new StringBuffer();
		al.sort(null);
		al.forEach(word -> sb.append(word).append(","));
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
		al.clear();
	}

	private static void formString(String[] letters) {
		StringBuffer sb = new StringBuffer();
		for (String s : letters) {
			sb.append(s);
		}
		al.add(sb.toString());
	}

	private static void getPermutations(int n, String[] letters) {
		if (n == 1) {
			formString(letters);
		} else {
			for (int i = 0; i < n - 1; i++) {
				getPermutations(n - 1, letters);
				if (n % 2 == 0) {
					String s = letters[i];
					letters[i] = letters[n - 1];
					letters[n - 1] = s;
				} else {
					String s = letters[0];
					letters[0] = letters[n - 1];
					letters[n - 1] = s;
				}
			}
			getPermutations(n - 1, letters);
		}
	}

}
