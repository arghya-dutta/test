
public class SumOfPrimes {
	// private static int[] primes= new int[500];
	private static int count = 0;

	public static void main(String[] args) {
		int sum = 2;

		int i = 3;
		while (count < 998) {
			sum += findPrime(i);
			i++;
		}
		System.out.println(sum);
	}

	private static int findPrime(int test) {

		if (test == 3) {
			return 3;
		}
		if (test % 2 == 0) {
			return 0;
		}
		double sqrt = Math.sqrt((double) test);
		for (int i = 3; i <= sqrt; i = i + 2) {
			if (test % i == 0) {
				return 0;
			}
		}
		count++;
		// System.out.println(test);
		return test;
	}
}
