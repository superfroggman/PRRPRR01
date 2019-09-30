package v40;

public class Primes {

	public static void main(String[] args) {
		int[] primes = {1,2};
		primes[3] = 3;
		for(int prime : primes) {
			System.out.println(prime);
		}
	}
}
