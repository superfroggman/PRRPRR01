package v40;

public class Primes {

	public static void main(String[] args) {

		int[] primes = { 2, 3 };

		for (int prime : primes) {
			System.out.println(prime);
		}

		int number = 3;
		while (true) {
			number++;
			
			
			boolean isPrime = true;
			for(int prime:primes) {
				if(number%prime==0) {
					isPrime = false;
				}
			}
			
			if(isPrime) {
				int[] newPrimes = new int[primes.length + 1];
				int j = 0;
				for (; j < primes.length; j++) {
					newPrimes[j] = primes[j];
				}

				newPrimes[j] = number;
				primes = newPrimes;
				System.out.println(number);
			}
		}
	}
}
