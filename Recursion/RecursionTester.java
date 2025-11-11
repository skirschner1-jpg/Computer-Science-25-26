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

        // INFECT

        // COUNT NONCONSEC
        System.out.println("COUNT NONCONSEC");
        System.out.println(Recursion.countNonConsecutiveSubsets(4));
        System.out.println();

        // PRINTSUBSETS
        System.out.println("PRINT SUBSETS");
        Recursion.printSubsets("abcd");
        System.out.println();

        //COUNT WAYS TO JUMP UP STAIRS
        System.out.println("COUNT WAYS TO JUMP UP STAIRS");
        System.out.println(Recursion.countWaysToJumpUpStairs(5));
        System.out.println();

        //SCAV HUNT
        System.out.println("SCAV HUNT");
        int[] times = { 1, 5, 6, 8, 20, 24, 27 };
        int[] points = { 1000, 5, 26, 89, 1, 29, 70 };
        System.out.println(Recursion.scavHunt(times, points));
    }


}
