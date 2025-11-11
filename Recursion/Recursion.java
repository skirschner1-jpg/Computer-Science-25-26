public class Recursion {

	// Prints the value of every node in the singly linked list with the given head,
	// but in reverse
	public static void printListInReverse(ListNode head) {
		if (head.getNext() != null) {
			printListInReverse(head.getNext());
		}
		System.out.println(head.getValue()); // print maybe no new line
	}
	// BASE CASE: length of 1

	// For the given 2D array of Strings, replaces the String at index[r][c]
	// with "infected" unless the String is "vaccinated";
	// also, any Strings they are orthogonally adjacent to
	// that are not "vaccinated" will also be infected, and any adjacent to
	// them as well etc.
	// Infecting someone who is already infected has no effect
	// Trying to infect outside the confines of the grid also has no effect
	// Precondition: grid has no null entries
	public static void infect(String[][] grid, int r, int c) {
		if (grid[r][c].equals("infected") || grid[r][c].equals("vaccinated")) {
			
		} else {
			if (0 < c - 1) {
				infect(grid, r, c - 1);
			}
			if (0 < r - 1) {
				infect(grid, r - 1, c);
			}
			if (c + 1 < grid.length) {
				infect(grid, r, c + 1);
			}
			if (r + 1 < grid.length) { // have to fix length vs. width!!
				infect(grid, r + 1, c);
			}
		}

		// if (r == 0) {

		// }
		// if (c == 0) {

		// }
		// if (r == grid.length) {

		// }
		// if (c == grid.length) { //not length the other way??

		// }
		// infect(grid, r, c - 1);
		// infect(grid, r, c + 1);
		// infect(grid, r - 1, c);
		// infect(grid, r + 1, c);
		// running all these infects will eventually sort of "overlap"
	}
	// basically want to hop to all the ones around it and then run infect() on those
	// BASE CASE: everything around it is either vaccinated, infected, or out of bounds

	// How many subsets are there of the numbers 1...n
	// that don't contain any consecutive integers?
	// e.g. for n = 4, the subsets are {}, {1}, {2}, {3}, {4},
	// {1, 3}, {1, 4}, {2, 4}
	// The other subsets of 1,2,3,4 that DO contain consecutive integers are
	// {1,2}, {2,3}, {3,4}, {1,2,3}, {1,2,4}, {1,3,4}, {1,2,3,4}
	// Precondition: n > 0
	public static long countNonConsecutiveSubsets(int n) {
		// start w/ n options of numbers to put
		// next we have n-2 options to put b/c we can't put the next consecutive # or the same #
		if (n > 0) {
			// System.out.println("here");
			// System.out.println(n);
			return countNonConsecutiveSubsets(n - 2) * n;
		}
		return 1;
	}

	// A kid at the bottom of the stairs can jump up 1, 2, or 3 stairs at a time.
	// How many different ways can they jump up n stairs?
	// Jumping 1-1-2 is considered different than jumping 1-2-1
	// Precondition: n > 0
	public static long countWaysToJumpUpStairs(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 3;
		} else {
			return countWaysToJumpUpStairs(n - 1) + countWaysToJumpUpStairs(n-2);
		}
	}

	// Everything above this line does NOT require a recursive helper method
	// ----------------------------------
	// Everything below this line requires a recursive helper method
	// Any recursive helper method you write MUST have a comment describing:
	// 1) what the helper method does/returns
	// 2) your description must include role of each parameter in the helper method

	// Prints all the subsets of str on separate lines
	// You may assume that str has no repeated characters
	// For example, subsets("abc") would print out "", "a", "b", "c", "ab", "ac",
	// "bc", "abc"
	// Order is your choice
	public static void printSubsets(String str) {
		if (str.length() != 0) {
			System.out.println(str);
			// print subsets for str w/o the first value & w/o the last value
			// if (str.length() > 2) {
			// 	printSubsets(str.substring(0, str.length() - 2));
			// 	printSubsets(str.substring(1, str.length() - 1));
			// }
			// if (str.length() > 1) {
			// 	printSubsets(str.substring(0, str.length() - 1));
			// 	// printSubsets(str.substring(1, str.length()));	
			// }
			// if (str.length() > 1) {
			// 	for (int i = 0; i < str.length(); i++) {
			// 		printSubsets(str.substring(0, str.length() - i));
			// 	}
			// }
		}
		// System.out.println("");
	}

	// List contains a single String to start.
	// Prints all the permutations of str on separate lines
	// You may assume that str has no repeated characters
	// For example, permute("abc") could print out "abc", "acb", "bac", "bca",
	// "cab", "cba"
	// Order is your choice
	public static void printPermutations(String str) {

	}

	// Performs a mergeSort on the given array of ints
	// Precondition: you may assume there are NO duplicates!!!
	public static void mergeSort(int[] ints) {
		if (ints.length > 1) {
			int[] split1 = ints;
		}
	}

	// Performs a quickSort on the given array of ints
	// Use the middle element (index n/2) as the pivot
	// Precondition: you may assume there are NO duplicates!!!
	public static void quickSort(int[] ints) {

	}

	// Prints a sequence of moves (one on each line)
	// to complete a Towers of Hanoi problem:
	// disks start on tower 0 and must end on tower 2.
	// The towers are number 0, 1, 2, and each move should be of
	// the form "1 -> 2", meaning "take the top disk of tower 1 and
	// put it on tower 2" etc.
	public static void solveHanoi(int startingDisks) {

	}

	// You are partaking in a scavenger hunt!
	// You've gotten a secret map to find many of the more difficult
	// items, but they are only available at VERY specific times at
	// specific places. You have an array, times[], that lists at which
	// MINUTE an item is available. Times is sorted in ascending order.
	// Items in the ScavHunt are worth varying numbers of points.
	// You also have an array, points[], same length as times[],
	// that lists how many points each of the corresponding items is worth.
	// Problem is: to get from one location to the other takes 5 minutes,
	// so if there is an item, for example, available at time 23 and another
	// at time 27, it's just not possible for you to make it to both: you'll
	// have to choose!
	// (but you COULD make it from a place at time 23 to another at time 28)
	// Write a method that returns the maximum POINTS you can get.
	// For example, if times = [3, 7, 9]
	// and points = [10, 15, 10]
	// Then the best possible result is getting the item at time 3 and the one at
	// time 9
	// for a total of 20 points, so it would return 20.
	public static int scavHunt(int[] times, int[] points) {

	}

	// HELPER METHODS
	public static int[] combineSortedArrays(int[] list1, int[] list2) {
		int i = 0;
		int j = 0;
		int index = 0;
		int[] result = new int[list1.length + list2.length];
		while (i < list1.length && j < list2.length) {
			if (list1[i] <= list2[j]) {
				result[index] = list1[i];
				i++;
			}
			if (list1[j] > list2[i]) {
				result[index] = list1[j];
				j++;
			}
			index++;
		}
		return result;
	}
	
	public static void scoot(int startingDisks, int onTower) {
		if (startingDisks == 1) {
			System.out.println(onTower+"->2");
		}
		else {
			scoot(startingDisks - 1, onTower);
		}
	}

}
