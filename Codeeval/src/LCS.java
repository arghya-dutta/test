import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class LCS {
	public static void main(String[] args) {
		try (BufferedReader buffer = new BufferedReader(new FileReader(new File(args[0])));) {
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				if(0<line.length() )
				checkLCS(line);
			}
		} catch (Exception e) {

		}
	}

	private static void checkLCS(String line) {
		String[] inputs = line.split(";");
		String[] s1 = inputs[0].split("");
		String[] s2 = inputs[1].split("");
		compare(s1, s2);
	}

	private static void compare(String[] s1, String[] s2) {
		int l1 = s1.length;
		int l2 = s2.length;
		boolean ismatch = false;
		ArrayList<ArrayList<String>> all = new ArrayList<ArrayList<String>>();

		for (int k = 0; k < s1.length; k++) {
			ArrayList<String> list = new ArrayList<String>();
			int ll = 0;
			for (int i = k; i < l1; i++) {
				String source = s1[i];
				ismatch = false;
				for (int j = ll; j < l2; j++) {
					if (source.equals(s2[j])) {
						ll = j;
						ismatch = true;
						list.add(source);
					}
					if (ismatch)
						break;
				}
				all.add(list);
			}

		}
		consolidate(all);

	}

	private static void consolidate(ArrayList<ArrayList<String>> all) {
		int length = 0;
		ArrayList<String> max = null;
		for (ArrayList<String> sqnc : all) {
			if (length < sqnc.size()) {
				max = sqnc;
				length = sqnc.size();
			}
		}

		StringBuilder sb = new StringBuilder();
		for (String s : max) {
			sb.append(s);
		}
		System.out.println(sb.toString().trim());
	}

}
