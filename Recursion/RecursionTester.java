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
        Recursion.printSubsets("abc");
        System.out.println();

        //COUNT WAYS TO JUMP UP STAIRS
        System.out.println("COUNT WAYS TO JUMP UP STAIRS");
        System.out.println(Recursion.countWaysToJumpUpStairs(5));
    }


}
