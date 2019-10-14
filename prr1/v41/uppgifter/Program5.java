package uppgifter;

public class Program5 {

	public static void main(String[] args) {

		int sum = 0;

		for (int i = 0; i < 10000; i++) {
			if (i % 7 == 0)
				sum += i;
		}

		System.out.println(sum);
	}
}
