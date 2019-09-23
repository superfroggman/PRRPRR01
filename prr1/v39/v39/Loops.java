package v39;

public class Loops {

	public static int sumFromTo(int a, int b) {
		int sum = 0;
		for (int i = a; i <= b; i++) {
			sum += i;
		}
		
		return sum;
	}

	public static void printFromTo(int a, int b) {
		for (int i = a; i <= b; i++) {
			System.out.println(i);
		}
	}
}
