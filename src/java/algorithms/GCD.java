public class GCD {

	// Find greatest common divisor/denominator by
	// Brute Force
	public static int gcdByBruteForce(int n1, int n2) {
		int gcd = 1;
		for(int i = 1; i <= n1 && i <= n2; i++) {
			if (n1 % i == 0 && n2 % i == 0) {
				gcd = i;
			}
		}
		return gcd;
	}

	// Driver code
	public static void main(String args[]) {
		int n1 = 10, n2 = 60;
		int gcd = gcdByBruteForce(n1, n2);
		System.out.println("n1: " + n1 + ", n2:" + n2);
		System.out.println("gcd: " + gcd);
	}
}
