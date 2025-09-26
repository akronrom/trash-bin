// Made by Gabriel.
// August 18, 2025.

import java.util.Scanner;

public class OutputPyramids {

    public static boolean checkOdd(int val) {return (val%2 != 0);}

    public static void generatePyramid(final char pCHAR) {

        Scanner inputObj = new Scanner(System.in);
        int pSIZE;

        String[] MESSAGES = {

			"(BUILD-A-PYRAMID) How tall should it be? Enter an integer: ",
			"Invalid, try again: ",
			"\nDone printing, enjoy your pyramid."

        };

        System.out.print(MESSAGES[0]);

        while (true)

            try {

                pSIZE = Integer.parseInt(inputObj.nextLine());

                break;
                
            } catch (NumberFormatException nfe) {

                System.out.print(MESSAGES[1]);

            }

        System.out.println("\nPrinting pyramid that's " + String.valueOf(pSIZE) + " rows tall.\n");

        for (int a = 1; a <= pSIZE*2; a++) {

            if (!checkOdd(a)) { // Ignore even-numbered lines.

                continue;

            }

            for (int b = 0; b <= pSIZE - a/2; b++) { // Align.

                System.out.print(" ");

            }

            for (int b = 1; b <= a; b++) { // Print the chars.

                System.out.print(pCHAR);

            }

            System.out.println(); // Print new line when done.

        }

        System.out.println(MESSAGES[2]);
    }

    public static void main(String[] args) {

        generatePyramid(';'); 

        //System.out.println("  *  " + "\n" + " *** " + "\n" + "*****");    // V2

        //System.out.println("  *  ");                                      // V1
        //System.out.println(" *** ");
        //System.out.println("*****");

    }
}