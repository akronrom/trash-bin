import java.util.Scanner;

public class ToDecimal {
	
	public static int toDecimal(String input) {
		
		int result = 0;
		
		for (int i = 0; i < input.length(); i++) {
			
			int bit = input.charAt(i) - '0';
			
			if (bit != 0 && bit != 1) {
				
				return 0;
				
			}
			
			result = result * 2 + bit;
			
		}
		
		return result;
		
	};
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter binary: ");
		String binaryInput = sc.nextLine();
		
		System.out.println(toDecimal(binaryInput));
		
	}

	
	
};