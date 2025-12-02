import java.util.ArrayList;

public class RecursionTester {
    public static void main(String[] args) {

        // PRINTLISTINREVERSE
        System.out.println("PRINT IN REVERSE");
        ListNode node2 = new ListNode("cat");
        ListNode node1 = new ListNode("dog", node2);
        ListNode head = new ListNode("lizard", node1);
        Recursion.printListInReverse(head);
        System.out.println();

        // PRINTSUBSETS
        System.out.println("PRINT SUBSETS");
        Recursion.printSubsets("abc");
        System.out.println();

        //COUNT WAYS TO JUMP UP STAIRS
        System.out.println("COUNT WAYS TO JUMP UP STAIRS");
        System.out.println(Recursion.countWaysToJumpUpStairs(5));
        System.out.println(Recursion.countWaysToJumpUpStairs(7));
        System.out.println(Recursion.countWaysToJumpUpStairs(10));
        System.out.println();

        // COUNT NONCONSEC
        System.out.println("COUNT NONCONSEC");
        System.out.println(Recursion.countNonConsecutiveSubsets(5));
        System.out.println(Recursion.countNonConsecutiveSubsets(7));
        System.out.println(Recursion.countNonConsecutiveSubsets(12));
        System.out.println();

        // SCAV HUNT
        System.out.println("SCAV HUNT");
        int[] times = { 6, 7, 12, 14, 16, 18, 20, 22, 23, 25 };
		int[] points = { 5, 6, 5, 1, 3, 4, 7, 4, 5, 3 };
        System.out.println(Recursion.scavHunt(times, points));
        System.out.println();

        // MERGE SORT
        System.out.println("MERGE SORT");
        int[] list = { 12, 3, 4, 9, 2, 1, 0, 29, 12 };
        Recursion.mergeSort(list);
        System.out.print("Sorted Array: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + ", ");
        }
        System.out.println("\n");
        // int[] mainList = new int[6];
        // int[] split1 = { 1, 3, 5 };
        // int[] split2 = { 2, 4, 6 };
        // Recursion.combineSortedArrays(split1, split2, mainList);
        // for (int i = 0; i < 6; i++) {
        //     System.out.println(mainList[i]);
        // }


        // QUICK SORT
        System.out.println("QUICK SORT");
        int[] list2 = { 3, 7, 18, 2, 1, 20, 5, 8, 16, 0 };
        // int[] list2 = { 12, 3 };
        Recursion.quickSort(list2);
        System.out.print("Sorted Array: ");
        for (int i = 0; i < list2.length; i++) {
            System.out.print(list2[i] + ", ");
        }
        System.out.println("\n");
        int[] arrLess = { 1, 4, 9, 7 };
        int mid = 10;
        int[] arrGreater = { };
        Recursion.combine(arrLess, arrGreater, mid);

        // int[] list3 = { 1, 2, 5, 7 };
        // int[] list4 = { 3, 4, 6 };
        // int[] listsCombined = Recursion.combine(list3, list4, 0);
        // System.out.print("Combined Arrays: ");
        // for (int i = 0; i < listsCombined.length; i++) {
        //     System.out.print(listsCombined[i] + ", ");
        // }

        // // PRINT PERMUTATIONS
        // System.out.println("PRINT PERMUTATIONS");
        // Recursion.printPermutations("abc");
        // System.out.println();

        // // INFECT
        // System.out.println("INFECT");
        // String[][] grid = { { "----------", "vaccinated", "----------", "----------", "----------" },
		// 		{ "vaccinated", "----------", "----------", "----------", "----------" },
		// 		{ "----------", "----------", "vaccinated", "vaccinated", "vaccinated" },
		// 		{ "----------", "----------", "----------", "vaccinated", "----------" } };
		// Recursion.infect(grid, 1, 2);

        // for (int i = 0; i < grid.length; i++) {
        //     for (int j = 0; j < grid[i].length; j++) {
        //         System.out.print(grid[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // // SOLVE HANOI
        // System.out.println("SOLVE HANOI");
        // Recursion.solveHanoi(3);
    }


}
