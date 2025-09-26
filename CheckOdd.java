import java.util.Scanner;

public class CheckOdd {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter int: ");
		
		int inp = sc.nextInt();
		
		System.out.println(inp % 2 != 0 ? "Odd" : "Even");
		
	
	}


}