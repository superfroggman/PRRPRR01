package v40;

import java.util.ArrayList;
import java.util.List;

public class Primes {

	public static void main(String[] args) {

		List<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		primes.add(3);

		for (int prime : primes) {
			System.out.println(prime);
		}

		int number = 3;
		while (true) {
			number++;

			boolean isPrime = true;
			
			ooo:
			for (int prime : primes) {
				if(prime>Math.sqrt(number)) break ooo;
				if (number % prime == 0) {
					isPrime = false;
				}
			}

			if (isPrime) {
				primes.add(number);

				System.out.println(number);
			}
		}
	}
}
