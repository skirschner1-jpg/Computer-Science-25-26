import java.util.Arrays;

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
	// DONE

	// For the given 2D array of Strings, replaces the String at index[r][c]
	// with "infected" unless the String is "vaccinated";
	// also, any Strings they are orthogonally adjacent to
	// that are not "vaccinated" will also be infected, and any adjacent to
	// them as well etc.
	// Infecting someone who is already infected has no effect
	// Trying to infect outside the confines of the grid also has no effect
	// Precondition: grid has no null entries
	public static void infect(String[][] grid, int r, int c) {
		if (grid[r][c].equals("infected") || grid[r][c].equals("vaccinated") || r >= grid.length || c >= grid[r].length) {
			return;
		}
		// else if(r>=grid.length -1 || c>= grid[r].length -1){
		// }
		else {
			grid[r][c] = "infected";
			if (0 <= c - 1) {
				infect(grid, r, c - 1);
			}
			if (0 <= r - 1) {
				infect(grid, r - 1, c);
			}
			if (c + 1 < grid[r].length) {
				infect(grid, r, c + 1);
			}
			if (r + 1 < grid.length) {
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
	// DONE
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
			return countNonConsecutiveSubsets(n - 2) + countNonConsecutiveSubsets(n-1);
		}
		return 1;
	}
	// DONE

	// A kid at the bottom of the stairs can jump up 1, 2, or 3 stairs at a time.
	// How many different ways can they jump up n stairs?
	// Jumping 1-1-2 is considered different than jumping 1-2-1
	// Precondition: n > 0
	public static long countWaysToJumpUpStairs(int n) {
		if (n < 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (n == 3) {
			return 4;
		} else {
			return countWaysToJumpUpStairs(n - 1) + countWaysToJumpUpStairs(n - 2) + countWaysToJumpUpStairs(n - 3);
		}
	}
	// DONE

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
		printSubsetsWithCurr(str, "", 0);
	}
	// DONE

	// List contains a single String to start.
	// Prints all the permutations of str on separate lines
	// You may assume that str has no repeated characters
	// For example, permute("abc") could print out "abc", "acb", "bac", "bca",
	// "cab", "cba"
	// Order is your choice
	public static void printPermutations(String str) {
		System.out.println(str);
		printPermutationsWithCurr(str, 0);
		// printPermutationsWithCurr(str, 1);
		// printPermutationsWithCurr(str, 2);
	}

	// Performs a mergeSort on the given array of ints
	// Precondition: you may assume there are NO duplicates!!!
	public static void mergeSort(int[] ints) {
		// // System.out.println("here");
		// if (ints == null || ints.length == 0) {
		// 	return;
		// }
		// int half = ints.length/2;
		// int[] split1 = new int[half];
		// int[] split2 = new int[ints.length - half];
		// for (int i = 0; i < half; i++) {
		// 	split1[i] = ints[i];
		// 	split2[i] = ints[ints.length - i - 1];
		// }
		// if (split1.length > 1) {
		// 	// System.out.println("here1");
		// 	mergeSort(split1);
		// } 
		// if (split2.length > 1) {
		// 	// System.out.println("here2");
		// 	mergeSort(split2);	
		// } 
		// combineSortedArrays(split1, split2, ints);
		// if (ints.length >= 2) {
		// 	int half = ints.length / 2;
		// 	int[] split1 = new int[half];
		// 	int[] split2 = new int[ints.length - half];
		// 	for (int i = 0; i < half; i++) {
		// 		split1[i] = ints[i];
		// 	}
		// 	for (int i = half; i < ints.length; i++) {
		// 		split2[i - half] = ints[i];
		// 	}

		// 	mergeSort(split1);
		// 	mergeSort(split2);

		// 	combineSortedArrays(ints, split1, split2);
		// }
		mergeSortHelper(ints, ints.length);
	}
	// DONE
	

	// Performs a quickSort on the given array of ints
	// Use the middle element (index n/2) as the pivot
	// Precondition: you may assume there are NO duplicates!!!
	public static void quickSort(int[] ints) {
		quickSortHelper(ints);

	}

	// Prints a sequence of moves (one on each line)
	// to complete a Towers of Hanoi problem:
	// disks start on tower 0 and must end on tower 2.
	// The towers are number 0, 1, 2, and each move should be of
	// the form "1 -> 2", meaning "take the top disk of tower 1 and
	// put it on tower 2" etc.
	public static void solveHanoi(int startingDisks) {
		solveHanoiHelper(startingDisks, 0, 2, 1);
	}
	// DONE

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
		return (maxReward(times, points)) +1;
		
	}

	// HELPER METHODS
	public static void printSubsetsWithCurr(String str, String currentSubset, int index) {
		if (index == str.length()) {
			System.out.println(currentSubset);
			return;
		}
		printSubsetsWithCurr(str, currentSubset + str.charAt(index), index + 1);
		printSubsetsWithCurr(str, currentSubset, index + 1);

	}

	public static void printPermutationsWithCurr(String str, int index) {
		if(index < str.length()) {
			char[] charList = stringToCharList(str);
			for (int i = index + 1; i < str.length(); i++) {
				// System.out.println("here");
				swapChar(charList, i, index);
				System.out.println(charListToString(charList));
				if (index < str.length()) {
					printPermutationsWithCurr(charListToString(charList), index+1);
				}
				swapChar(charList, i, index);
			}
			if (index < str.length() - 1) {
				printPermutationsWithCurr(str, index+1);
			}
			// if (index < str.length() - 3) {
			// 	printPermutationsWithCurr(str, index++);	
			// }
		}
		// char curr = charList[index];
		

		// if (str.length() == 0) {
		// 	System.out.println();
		// }

		// if (index < str.length() - 1) {
		// 	printPermutationsWithCurr(str, index+1);
		// }

	}

	public static char[] stringToCharList(String str) {
		char[] charList = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			charList[i] = str.charAt(i);
		}
		return charList;
	}

	public static void combineSortedArrays(int[] list1, int[] list2, int[] mainList) {
		// System.out.println("combining");
		int i = 0;
		int j = 0;
		int index = 0;
		while (i < list1.length && j < list2.length) {
			// System.out.println("here");
			if (list1[i] <= list2[j]) {
				mainList[index] = list1[i];
				i++;
			} else if (list1[i] > list2[j]) {
				mainList[index] = list2[j];
				j++;
			}
			index++;
		}
		if (list1.length - 1 > i) {
			mainList[index] = list1[i];
		}
		if (list2.length - 1 > j) {
			mainList[index] = list2[j];
		}
	}

	public static void combineSortedArrays(int[] a, int[] l, int[] r, int left, int right) {

		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			if (l[i] <= r[j]) {
				a[k++] = l[i++];
			} else {
				a[k++] = r[j++];
			}
		}
		while (i < left) {
			a[k++] = l[i++];
		}
		while (j < right) {
			a[k++] = r[j++];
		}
	}

	public static void mergeSortHelper(int[] ints, int length) {
		if (length < 2) {
			return;
		}
		int mid = length / 2;
		int[] l = new int[mid];
		int[] r = new int[length - mid];
	
		for (int i = 0; i < mid; i++) {
			l[i] = ints[i];
		}
		for (int i = mid; i < length; i++) {
			r[i - mid] = ints[i];
		}
		mergeSortHelper(l, mid);
		mergeSortHelper(r, length - mid);
	
		combineSortedArrays(ints, l, r, mid, length - mid);
	}

	public static int maxReward(int[] times, int[] points) {
		// int toReturn = 0;
		if (times.length <= 0) {
			return 0;
		}
		int i = 1;
		int index2 = times.length - 1;
		while (i < times.length) {
			if (times[i] >= times[0] + 5) {
				index2 = i;
				i += times.length;
			}
			i++;
		}
		if (index2 == times.length - 1) {
			return points[0];
		}
		int option1 = maxReward(subArray(times, index2, times.length), subArray(points, index2, points.length))
				+ points[0];
		// System.out.println("option1: " + option1);
		int option2 = maxReward(subArray(times, 1, times.length), subArray(points, 1, points.length));
		// System.out.println("option2: " + option2);
		if (option1 > option2) {
			System.out.println("claimed " + times[0]);
			return option1;
		} else {
			System.out.println("passed");
			return option2;
		}
		// return toReturn;
	}

	public static void solveHanoiHelper(int n, int start, int dest, int helper) {
		if (n == 1) {
			System.out.println(start + " -> " + dest);
			return;
		}
		solveHanoiHelper(n - 1, start, helper, dest);
		System.out.println(start + " -> " + dest);
		solveHanoiHelper(n - 1, helper, dest, start);
	}
	
	public static int[] quickSortHelper(int[] arr) {
		// System.out.println("here");
		int mid = arr.length / 2;
		int i = 0;
		int j = 0;
		int index = 0;
		while (index < arr.length) {
			if (arr[index] < arr[mid]) {
				i++;
			}
			if (arr[index] > arr[mid]) {
				j++;
			}
			index++;
		}
		int[] arrLess = new int[i];
		int[] arrGreater = new int[j];
		int index1 = 0;
		int index2 = 0;
		int k = 0;
		while (k < arr.length) {
			// System.out.println(arr[k]);
			// System.out.println("here1");
			if (arr[k] < arr[mid]) {
				System.out.println("less");
				// System.out.println("here1");
				arrLess[index1] = arr[k];
				index1++;
			}
			// System.out.println("here3");
			// System.out.println(arr[k]);
			// System.out.println(arr[mid]);
			if (arr[k] > arr[mid]) {
				System.out.println("more");
				// System.out.println("here4");
				arrGreater[index2] = arr[k];
				// System.out.println("here5");
				index2++;
				// System.out.println("here6");
				// System.out.println("here7");
			}
			k++;
		}
		int midIndex = arrLess.length;
		System.out.print("array less: ");
		for (int l = 0; l < arrLess.length; l++) {
			System.out.print(arrLess[l] + ", ");
		}
		System.out.println();
		System.out.println("mid: " + arr[mid]);
		System.out.print("array greater: ");
		for (int g = 0; g < arrGreater.length; g++) {
			System.out.print(arrGreater[g] + ", ");
		}
		System.out.println();
		// System.out.println("here8");
		System.out.println(arrGreater.length);
		if (arrGreater.length > 1) {
			System.out.println("in greater");
			arrGreater = quickSortHelper(arrGreater);
		}
		if (arrLess.length > 1) {
			System.out.println("in less");
			arrLess = quickSortHelper(arrLess);
		}
		arr = combine(arrLess, arrGreater, arr[mid]);
		return arr;
	}

	public static int midIndex(int[] arr) {
		int mid = arr.length / 2;
		int midIndex = 0;
		int index = 0;
		while (index < arr.length) {
			if (arr[index] < arr[mid]) {
				midIndex++;
			}
			index++;
		}
		return midIndex;
	}

	public static int[] arrLess(int[] arr) {
		int mid = arr.length / 2;
		int i = 0;
		int j = 0;
		int index = 0;
		while (index < arr.length) {
			if (arr[index] < arr[mid]) {
				i++;
			}
			if (arr[index] > arr[mid]) {
				j++;
			}
			index++;
		}
		int[] arrLess = new int[i];
		int[] arrGreater = new int[j];
		int index1 = 0;
		int index2 = 0;
		int k = 0;
		while (k < arr.length) {
			if (arr[k] < arr[mid]) {
				System.out.println("less");
				arrLess[index1] = arr[k];
				index1++;
			}
			if (arr[k] > arr[mid]) {
				System.out.println("more");
				arrGreater[index2] = arr[k];
				index2++;
			}
			k++;
		}
		return arrLess;
	}

	public static int[] arrGreater(int[] arr) {
		int mid = arr.length / 2;
		int i = 0;
		int j = 0;
		int index = 0;
		while (index < arr.length) {
			if (arr[index] < arr[mid]) {
				i++;
			}
			if (arr[index] > arr[mid]) {
				j++;
			}
			index++;
		}
		int[] arrLess = new int[i];
		int[] arrGreater = new int[j];
		int index1 = 0;
		int index2 = 0;
		int k = 0;
		while (k < arr.length) {
			if (arr[k] < arr[mid]) {
				System.out.println("less");
				arrLess[index1] = arr[k];
				index1++;
			}
			if (arr[k] > arr[mid]) {
				System.out.println("more");
				arrGreater[index2] = arr[k];
				index2++;
			}
			k++;
		}
		return arrGreater;
	}

	public static void quickSortHelperWithStuff(int[] arr) {
		if (arr.length == 0) {
			return;
		}
		int mid = midIndex(arr);
		int save = arr[mid];
		arr[mid] = arr[arr.length / 2];
		arr[arr.length / 2] = save;
		quickSortHelperWithStuff(arrLess(arr));
		quickSortHelperWithStuff(arrGreater(arr));
	}


	public static void mainQuickSortHelper(int[] arr, int begin, int end){
		if(begin < end){
			int index = quickSortHelper(arr, begin, end);
			mainQuickSortHelper(arr, begin, index-1);
			mainQuickSortHelper(arr, index+1, end);
		}
	}

	public static int quickSortHelper(int[] arr, int begin, int end) {
		int pivot = arr[arr.length/2];
		int i = begin;
		int k = end;
		while (i <= arr.length) {
			if (arr[i] < pivot) {
				i++;
			}
			if (arr[k] < pivot) {
				k--;
			}

			if (i <= k) {
				int save = arr[i];
				arr[i] = arr[k];
				arr[k] = save;
				i++;
				k--;
			}
			return i;
		}
		// for (int j = begin; j < end; j++) {
		// 	if (arr[j] <= pivot) {
		// 		i++;
		// 		int save = arr[i];
		// 		arr[i] = arr[j];
		// 		arr[j] = save;
		// 	}
		// 	if (arr[j] > pivot) {
		// 		k--;
		// 		int save = arr[k];
		// 		arr[k] = arr[j];
		// 		arr[j] = save;
		// 	}
		// }
		// int save1 = arr[i + 1];
		// arr[i+1] = arr[end];
		// arr[end] = save1;
		// int save2 = arr[k - 1];
		// arr[k-1] = arr[begin];
		// arr[begin] = save2;
		return i+1;
	}
	
	// public static int[] quickSortHelper(int[] arr, int[] less, int[] greater) {
	// 	int mid = arr.length / 2;
	// 	if (less.length == 1 && greater.length == 1) {
	// 		return combine(less, greater, arr[mid]);
	// 	}
	// 	int i = 0;
	// 	int j = 0;
	// 	int index = 0;
	// 	while (index < arr.length) {
	// 		if (arr[index] < arr[mid]) {
	// 			i++;
	// 		}
	// 		if (arr[index] > arr[mid]) {
	// 			j++;
	// 		}
	// 		index++;
	// 	}
	// 	int[] arrLess = new int[i];
	// 	int[] arrGreater = new int[j];
	// 	int index1 = 0;
	// 	int index2 = 0;
	// 	int k = 0;
	// 	while (k < arr.length) {
	// 		// System.out.println(arr[k]);
	// 		// System.out.println("here1");
	// 		if (arr[k] < arr[mid]) {
	// 			System.out.println("less");
	// 			// System.out.println("here1");
	// 			arrLess[index1] = arr[k];
	// 			index1++;
	// 		}
	// 		// System.out.println("here3");
	// 		// System.out.println(arr[k]);
	// 		// System.out.println(arr[mid]);
	// 		if (arr[k] > arr[mid]) {
	// 			System.out.println("more");
	// 			// System.out.println("here4");
	// 			arrGreater[index2] = arr[k];
	// 			// System.out.println("here5");
	// 			index2++;
	// 			// System.out.println("here6");
	// 			// System.out.println("here7");
	// 		}
	// 		k++;
	// 	}
	// 	System.out.print("array less: ");
	// 	for (int l = 0; l < arrLess.length; l++) {
	// 		System.out.print(arrLess[l] + ", ");
	// 	}
	// 	System.out.println();
	// 	System.out.println("mid: " + arr[mid]);
	// 	System.out.print("array greater: ");
	// 	for (int g = 0; g < arrGreater.length; g++) {
	// 		System.out.print(arrGreater[g] + ", ");
	// 	}
	// 	System.out.println();
	// 	// System.out.println("here8");
	// 	System.out.println(arrGreater.length);
	// 	if (arrGreater.length >=1) {
	// 		System.out.println("in greater");
	// 		quickSortHelper(arrGreater);
	// 	} 
	// 	if (arrLess.length >= 1) {
	// 		System.out.println("in less");
	// 		quickSortHelper(arrLess);
	// 	}
 	// }


	// HELPER HELPER METHODS
	public static int[] combine(int[] arr1, int[] arr2, int mid) {
		int[] toReturn = new int[arr1.length + arr2.length + 1];
		int i = 0;
		// while (i < toReturn.length) {
		// System.out.println("stuck");
		for (int j = 0; j < arr1.length; j++) {
			// System.out.println("here4");
			toReturn[i] = arr1[j];
			i++;
			// System.out.println(i);
		}
		toReturn[i] = mid;
		i++;
		for (int k = 0; k < arr2.length; k++) {
			// System.out.println("here4");
			toReturn[i] = arr2[k];
			i++;
		}
		System.out.print("combined arrays: ");
		for (int g = 0; g < toReturn.length; g++) {
			System.out.print(toReturn[g] + ", ");
		}
		System.out.println();
		// i = toReturn.length;
		// }
		return toReturn;
	}
	
	public static int[] combine(int[] arr1, int[] arr2) {
		int[] toReturn = new int[arr1.length + arr2.length+1];
		int i =0;
		// while (i < toReturn.length) {
			// System.out.println("stuck");
			for (int j = 0; j < arr1.length; j++) {
				// System.out.println("here4");
				toReturn[i] = arr1[j];
				i++;
				// System.out.println(i);
			}
			for (int k = 0; k < arr2.length; k++) {
				// System.out.println("here4");
				toReturn[i] = arr2[k];
				i++;
			}
		System.out.print("combined arrays: ");
		for (int g = 0; g < toReturn.length; g++) {
			System.out.print(toReturn[g] + ", ");
		}
		System.out.println();
			// i = toReturn.length;
		// }
		return toReturn;
	}

	public static int[] subArray(int[] list, int start, int end) {
		if (end <= start) {
			return new int[0];
		}
		int[] toReturn = new int[end - start];
		for (int i = 0; i < toReturn.length; i++) {
			toReturn[i] = list[i + start];
		}
		return toReturn;
	}

	public static String charListToString(char[] chars) {
		String toReturn = "";
		for (int i = 0; i < chars.length; i++) {
			toReturn = toReturn + chars[i];
		}
		return toReturn;
	}

	public static void swapChar(char[] arr, int i, int j) {
		char save = arr[i];
		arr[i] = arr[j];
		arr[j] = save;
	}

	public static void swapInt(int[] arr, int i, int j) {
		int save = arr[i];
		arr[i] = arr[j];
		arr[j] = save;
	}


}
