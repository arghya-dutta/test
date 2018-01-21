import java.util.Arrays;

public class Permutations {
	// private static Set<char> permutations = new HashSet<>();
	private static char[] record = { 'g', 'a', 'a', 'a', 'a', 'a', 'a', 't' };

	public static void main(String[] args) {

//		char[] input2 = { 'g', 'a', 'a', '-', '-', '-', '-', 't' };

		 char[] input = { 'g', 'a', 'a', 't', ' ', ' ', ' ', ' ' };
		 mix('-', 1, input, 3);
//		calculateScore(input2);
	}

	private static void mix(char ch, int start, char[] input, int offset) {
		if (offset < 0)
			return;
		char[] input2 = new char[input.length];
		int size = input.length;
		for (int i = start; i < size - 1; i++) {
			System.arraycopy(input, 0, input2, 0, input.length);
			shift(i, ch, input2, input.length - offset);
			mix('-', i + 1, input2, offset - 1);
			// System.out.println(Arrays.toString(input2));
			calculateScore(input2);
			// mix('+', i + 2, input2);
			// may need this for another problem
		}
	}

	private static void calculateScore(char[] input2) {
		int score = 0;
		boolean indel = false;
		for (int i = 0; i < record.length; i++) {
			if (record[i] == input2[i]) {
				score = score + 3;
				indel = false;
			} else if (input2[i] == '-') {
				if (indel) {
					score = score - 1;
				} else if (!indel) {
					score = score - 8;
					indel = true;
				}
			} else {
				score = score - 3;
				indel = false;
			}
		}

		System.out.println(Arrays.toString(input2) + " -- " + score);

	}

	private static char[] shift(int start, char ch, char[] inp, int end) {
		char s = inp[start];
		inp[start] = ch;
		char s1;
		for (int i = start + 1; i < end; i++) {
			s1 = inp[i];
			if (Character.isLetter(s1)) {
				inp[i] = s;
				s = s1;
			} else if (Character.isLetter(s)) {
				inp[i] = s;
			} else {
				continue;
			}

		}
		return inp;
	}

}
