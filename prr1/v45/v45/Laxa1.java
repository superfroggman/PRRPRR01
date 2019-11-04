package v45;

public class Laxa1 {

	public static void main(String[] args) {
		lol();
		System.out.println(max(13,2));
		count(12);
		System.out.println(kelvinToCelsius(420.69));
		System.out.println(fahrenheitToCelsius(200));
		ageControl(-1);
		stair(10);
	}
	
	static void lol() {
		System.out.println("HAHAHAHAHA");
	}
	
	static int max(int a, int b) {
		if(a>b) {
			return a;
		}
		
		return b;
	}
	
	static void count(int n) {
		for(int i=1;i<=n;i++) {
			System.out.println(i);
		}
	}
	
	static double kelvinToCelsius(double kelvin) {
		double celsius = kelvin-273.15;
		return celsius;
	}
	
	static double fahrenheitToCelsius(double fahrenheit) {
		double celsius = (fahrenheit-32)*5/9;
		return celsius;
	}
	
	static void ageControl(int age) {
		if(age<0) {
			System.out.println("Du lever inte än");
		} else if(age<=5) {
			System.out.println("Småbarn får inte göra något");
		} else if(age<=12) {
			System.out.println("Du får spela Fortnite");
		} else if(age<=14) {
			System.out.println("Du är tonåring");
		} else if(age<=17) {
			System.out.println("Du får köra moppe");
		} else {
			System.out.println("Du förstår poängen. Jag orkar inte skriva mer sådana här...");
		}
	}
	
	static void stair(int steps) {
		for(int i = 1; i<=steps;i++) {
			for(int j=0;j<steps-i;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<i;j++) {
				System.out.print("X");
			}
			System.out.println();
		}
	}
}
