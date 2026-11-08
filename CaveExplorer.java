import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CaveExplorer {
	private char[][] cave;
    private String path;
    private boolean explored;
    private boolean found;

	// Step 1: Zero parameter constructor to create the specified cave
	public CaveExplorer() {
        cave = new char[][] {
            {'R', 'R', 'R', 'R', 'R', 'R'},
            {'R', '.', '.', 'S', 'R', 'R'},
            {'R', '.', 'R', 'R', 'R', 'R'},
            {'R', '.', 'M', 'R', 'R', 'R'},
            {'R', 'R', 'R', 'R', 'R', 'R'}
        };

        path = "";
        explored = false;
        found = false;
    }
	// Step 2: toString method
	    public String toString() {
        String result = "";

        for (int row = 0; row < cave.length; row++) {
            for (int col = 0; col < cave[row].length; col++) {
                result += cave[row][col];
            }
            result += "\n";
        }

        return result;
    }
	
	// Step 3: solve method
	public boolean solve() {
        if (explored) {
            return found;
        }

        explored = true;
        path = "";

        boolean[][] visited = new boolean[cave.length][cave[0].length];
        int currentRow = -1;
        int currentCol = -1;

        for (int row = 0; row < cave.length; row++) {
            for (int col = 0; col < cave[row].length; col++) {
                if (cave[row][col] == 'S') {
                    currentRow = row;
                    currentCol = col;
                }
            }
        }

        if (currentRow == -1) {
            return false;
        }

        visited[currentRow][currentCol] = true;

        while (!found) {
            int nextRow = currentRow;
            int nextCol = currentCol;
            char direction = ' ';

            if (currentRow > 0
                    && !visited[currentRow - 1][currentCol]
                    && (cave[currentRow - 1][currentCol] == '.'
                    || cave[currentRow - 1][currentCol] == 'M')) {
                nextRow = currentRow - 1;
                direction = 'n';
            }
            else if (currentRow < cave.length - 1
                    && !visited[currentRow + 1][currentCol]
                    && (cave[currentRow + 1][currentCol] == '.'
                    || cave[currentRow + 1][currentCol] == 'M')) {
                nextRow = currentRow + 1;
                direction = 's';
            }
            else if (currentCol < cave[currentRow].length - 1
                    && !visited[currentRow][currentCol + 1]
                    && (cave[currentRow][currentCol + 1] == '.'
                    || cave[currentRow][currentCol + 1] == 'M')) {
                nextCol = currentCol + 1;
                direction = 'e';
            }
            else if (currentCol > 0
                    && !visited[currentRow][currentCol - 1]
                    && (cave[currentRow][currentCol - 1] == '.'
                    || cave[currentRow][currentCol - 1] == 'M')) {
                nextCol = currentCol - 1;
                direction = 'w';
            }
            else {
                path = "";
                return false;
            }

            found = cave[nextRow][nextCol] == 'M';

            cave[currentRow][currentCol] = '.';
            currentRow = nextRow;
            currentCol = nextCol;
            cave[currentRow][currentCol] = 'S';

            visited[currentRow][currentCol] = true;
            path += direction;
        }

        return true;
    }
	// Step 4: getPath method
	public String getPath() {
        return path;
    }
	// Step 5: One parameter constructor to read from a file
	/*
	public CaveExplorer (String fname) throws Exception {
	      Scanner in = new Scanner(new File(fname));

	      int rows = in.nextInt();
	      int cols = in.nextInt();  
    	  String s = in.nextLine(); // Skip newline character
    	   	  
    	  // Construct cave and populate with rest of data in the file
    	  
	}
	*/

	
	public static void main(String[] args) {
		System.out.println("Starting CaveExplorer");
		
		// Create a CaveExplorer object and print the starting layout
		
		// Call solve
		
		// Print the final layout, whether there is a path, and if so, what it is.
		
		// Step 5/6: Repeat for a different CaveExplorer object read from a file
		// Uncomment code below to start testing your 1-parameter constructor

		/*
		String fileName = "testdat.txt"; 
		try { 
			CaveExplorer ce2 = new CaveExplorer(fileName); 
		} 
		catch (FileNotFoundException e ) {
			System.out.println("Can't find file " + fileName); 
		}
		catch (Exception e) {
			System.out.println("Other error: " + e.getMessage());
		}
		*/
		 

		
		System.out.println("Finished CaveExplorer");
	}

}
