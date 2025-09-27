import java.util.Arrays;
import java.util.Scanner;

class ConwayGameOfLife {

    static int[][] findNextGen(int[][] mat) {

        int length_y = mat.length, length_x = mat[0].length;

        int[][] nextGen = new int[length_y][length_x];

        int[][] directions = { 

            {0,   1}, {1,   0},
            {0,  -1}, {-1,  0},
            {1,   1}, {-1, -1},
            {1,  -1}, {-1,  1} 

        };

        for (int i = 0; i < length_y; i++) {
            for (int j = 0; j < length_x; j++) {
                int live = 0;

                for (int[] dir : directions) {
                    int x = i + dir[0], y = j + dir[1];

                    if (x >= 0 && x < length_y && y >= 0 && y < length_x
                        && (mat[x][y] == 1)) {
                        live++;
                    }
                }

                if (mat[i][j] == 1
                    && (live < 2 || live > 3)) {
                    nextGen[i][j] = 0;
                }

                else if (mat[i][j] == 0 && live == 3) {
                    nextGen[i][j] = 1;
                }

                else {
                    nextGen[i][j] = mat[i][j];
                }
            }
        }

        return nextGen;
    }

    static void printMatrice(int[][] mat) {

        int length_y = mat.length, length_x = mat[0].length;

        for (int i = 0; i < length_x; i++) {
			
            for (int j = 0; j < length_y; j++) {
				
                System.out.print(mat[i][j] + " ");
				
            }
			
            System.out.println();
        }

        System.out.println();
    }
	
    public static void main(String[] args) throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		int DURATION; 
		
		int[][] nextMat = {
			{1,0,1,0,0,0,0,0,0,0,0,0,0,0,0}, //1
            {0,1,1,0,0,0,0,0,0,0,0,0,0,0,0}, //2
            {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0}, //3
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //4
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //5
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //6
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //7
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //8
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //9
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //10
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //11
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //12
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //13
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //14
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //15
		};
		
		int[][] prevMat = nextMat;
		
		System.out.print("How far should we look? Enter an integer: ");
		
		while (true)

            try {

                DURATION = Integer.parseInt(sc.nextLine());

                break;
                
            } catch (NumberFormatException nfe) {

                System.out.print("Enter an integer: ");

            }


		for (int i = 1; i <= DURATION; i++) {
			
			Thread.sleep(100);
			
			nextMat = findNextGen(nextMat);
		
			printMatrice(nextMat);
		
		}
		
    }
}