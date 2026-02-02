import java.io.*;
import java.util.*;

// You are allowed (and expected!) to use either Java's ArrayDeque or LinkedList class to make stacks and queues


public class CookieMonster {

    private int [][] cookieGrid;
    private int numRows;
	private int numCols;
	
    //Constructs a CookieMonster from a file with format:
    //numRows numCols
    //<<rest of the grid, with spaces in between the numbers>>
    public CookieMonster(String fileName) {
		int row = 0;
		int col = 0;
		try
		{
			Scanner input = new Scanner(new File(fileName));

			numRows    = input.nextInt();  
			numCols    = input.nextInt();
			cookieGrid = new int[numRows][numCols];

			for (row = 0; row < numRows; row++) 
				for (col = 0; col < numCols; col++)
					cookieGrid[row][col] = input.nextInt();
			
			input.close();
		}
		catch (Exception e)
		{
			System.out.print("Error creating maze: " + e.toString());
			System.out.println("Error occurred at row: " + row + ", col: " + col);
		}

    }

    public CookieMonster(int [][] cookieGrid) {
        this.cookieGrid = cookieGrid;
        this.numRows    = cookieGrid.length;
        this.numCols    = cookieGrid[0].length;
    }

    //You may find it VERY helpful to write this helper method.  Or not!
	private boolean validPoint(int row, int col) {
		//Write this if you want
		if(row >= cookieGrid.length || col >=cookieGrid[1].length)
		if (cookieGrid[row][col] == -1) {
			return false;
		}
		return true;
		// done i think??
	}
	
	/* RECURSIVELY calculates the route which grants the most cookies.
	 * Returns the maximum number of cookies attainable. */
	public int recursiveCookies() {
		return recursiveCookies(0,0,0);	
	}	
	
	// Returns the maximum number of cookies edible starting from (and including) cookieGrid[row][col]
	public int recursiveCookies(int row, int col, int cookiesFound) {
		//CODE THIS
		OrphanScout test = new OrphanScout(row, col, cookiesFound + cookieGrid[row][col]);
		if (test.getCookiesDiscovered() >= cookiesFound && row < cookieGrid.length -1 && col < cookieGrid[1].length-1) {
			return returnGreater(recursiveCookies(row + 1, col, test.getCookiesDiscovered()),
					recursiveCookies(row, col + 1, test.getCookiesDiscovered()));
		}
		else if (test.getCookiesDiscovered() >= cookiesFound && row < cookieGrid.length-1) {
			return recursiveCookies(row + 1, col, test.getCookiesDiscovered());
		}
		else if (test.getCookiesDiscovered() >= cookiesFound && col < cookieGrid[1].length -1) {
			return recursiveCookies(row, col + 1, test.getCookiesDiscovered());
		}
		return cookiesFound;
		// DONE
	}
	

	/* Calculate which route grants the most cookies using a QUEUE.
	 * Returns the maximum number of cookies attainable. */
    /* From any given position, always add the path right before adding the path down */
    public int queueCookies() {
		//CODE THIS
		Queue<OrphanScout> orphans = new LinkedList<>();
		int row = 0;
		int col = 0;
		int adder = 0;
		OrphanScout test = new OrphanScout(row, col, cookieGrid[0][0]);
		orphans.add(test);
		int cookiesFound = test.getCookiesDiscovered();
		int maxCookies = test.getCookiesDiscovered();
		while (maxCookies <= maxCookies + orphans.peek().getCookiesDiscovered() && row + adder < cookieGrid.length - 1
				&& col + adder < cookieGrid[1].length - 1) {
			adder++;
			maxCookies = maxCookies + orphans.remove().getCookiesDiscovered();
			orphans.add(new OrphanScout(row + adder, col, cookiesFound + cookieGrid[row + adder][col]));
			orphans.add(new OrphanScout(row, col + adder, cookiesFound + cookieGrid[row][col + adder]));
		}
		while (orphans.peek() != null) {
			if (maxCookies <= maxCookies + orphans.peek().getCookiesDiscovered()) {
				maxCookies = maxCookies + orphans.remove().getCookiesDiscovered();
			}
		}
		return maxCookies;
		// queue of orphans, each time you see a square is viable, you send one to either square next to that and the greater one to the queue
    }

    
    /* Calculate which route grants the most cookies using a stack.
 	 * Returns the maximum number of cookies attainable. */
    /* From any given position, always add the path right before adding the path down */
	public int stackCookies() {
		//CODE THIS
		return 0;
	}
	
	public static int returnGreater(int int1, int int2){
		if (int1 > int2) {
			return int1;
		}
		return int2;
	}

}
