import java.util.Scanner;

class EasterGauss {
	
	static String[] MONTHS = {
		"NO_MONTH", // 0
		"JANUARY", 	// 1
		"FEBRUARY", // 2
		"MARCH", 	// 3
		"APRIL", 	// 4
		"MAY", 		// 5
		"JUNE",		// 6
		"JULY",		// 7
		"AUGUST",	// 8
		"SEPTEMBER",// 9
		"OCTOBER",	// 10
		"NOVEMBER",	// 11
		"DECEMBER"	// 12
		
	};
	
	static void whenEaster(int y) {
		
		// int y = sc.nextInt(); 						// 1. Declaration moved to main.
		
		int a = y % 19; 								// 2.
		
		int b = y / 100;								// 3.
		int c = y % 100;
		
		int d = b / 4;									// 4.
		int e = b % 4;
		
		int g = (8 * b + 13) / 25; 						// 5.
		
		int h = (19 * a + b - d - g + 15) % 30; 		// 6.
		
		int j = c / 4;									// 7.
		int k = c % 4;
		
		int m = (a + 11 * h) / 319;						// 8.
		
		int r = (2 * e + 2 * j - k - h + m + 32) % 7;	// 9.
		
		int n = (h - m + r + 90) / 25;					// 10.
		
		int p = (h - m + r + n + 19) % 32;				// 11.
		
		System.out.println("In the year " + y + ", the Easter Sunday is on " + MONTHS[n] + " " + p + ".");
		
	};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("(WHEN'S-EASTER-SUNDAY?) Enter a year: ");
		
		int y = sc.nextInt(); 					
		
		whenEaster(y);
		
		
	}
	
}