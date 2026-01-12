public class BSTTester {
    public static void main(String[] args) {
        // MyBST test = new MyBST();
        // test.add(20);
        // test.add(15);
        // test.add(25);
        // test.add(10);
        // test.add(18);
        // test.add(8);
        // test.add(12);
        // test.add(11);
        // test.add(30);
        // // 9 things
        // // test.remove(15);
        // // test.add(2);
        // // System.out.println(test.add(11));
        // System.out.println("root (20): " + test.getRoot());
        // System.out.println("root height (0): " + test.getRoot().getHeight());
        // System.out.println("left of root(15): " + test.getRoot().getLeft());
        // System.out.println("left of root height (1): " + test.getRoot().getLeft().getHeight());
        // System.out.println("left of left (10): " + test.getRoot().getLeft().getLeft());
        // System.out.println("left of left height (2): " + test.getRoot().getLeft().getLeft().getHeight());
        // System.out.println("left of left of left (8): " + test.getRoot().getLeft().getLeft().getLeft());
        // System.out.println(
        //         "left of left of left height (3): " + test.getRoot().getLeft().getLeft().getLeft().getHeight());
        // System.out.println("right of left of left (12): " + test.getRoot().getLeft().getLeft().getRight());
        // System.out.println(
        //         "right of left of left height (3): " + test.getRoot().getLeft().getLeft().getRight().getHeight());
        // System.out.println(
        //         "left of right of left of left (12): " + test.getRoot().getLeft().getLeft().getRight().getLeft());
        // System.out.println(
        //         "left of right of left of left height (4): "
        //                 + test.getRoot().getLeft().getLeft().getRight().getLeft().getHeight());
        // System.out.println("right of left (18): " + test.getRoot().getLeft().getRight());
        // System.out.println("right of left height (2): " + test.getRoot().getLeft().getRight().getHeight());
        // System.out.println("right of root (25): " + test.getRoot().getRight());
        // System.out.println("right of root height (1): " + test.getRoot().getRight().getHeight());
        // System.out.println("right of right (30): " + test.getRoot().getRight().getRight());
        // System.out.println("right of right height (2): " + test.getRoot().getRight().getRight().getHeight());
        // // System.out.println(test.toString());
        
        
        // test.remove(15);
        // System.out.println("\nAFTER REMOVE\n");
        // System.out.println(test);
        // System.out.println();
        // // System.out.println(test.toString());
        // System.out.println("root (20): " + test.getRoot());
        // System.out.println("root height (0): " + test.getRoot().getHeight());
        // System.out.println("left of root (12): " + test.getRoot().getLeft());
        // System.out.println("left of root height (1): " + test.getRoot().getLeft().getHeight());
        // System.out.println("left of left (10): " + test.getRoot().getLeft().getLeft());
        // System.out.println("left of left height (2): " + test.getRoot().getLeft().getLeft().getHeight());
        // System.out.println("left of left of left (8): " + test.getRoot().getLeft().getLeft().getLeft());
        // System.out.println(
        //         "left of left of left height (3): " + test.getRoot().getLeft().getLeft().getLeft().getHeight());
        // System.out.println("right of left of left (11): " + test.getRoot().getLeft().getLeft().getRight());
        // System.out.println(
        //         "right of left of left height (3): " + test.getRoot().getLeft().getLeft().getRight().getHeight());
        // System.out.println("right of left (18): " + test.getRoot().getLeft().getRight());
        // System.out.println("right of left height (2): " + test.getRoot().getLeft().getRight().getHeight());
        // System.out.println("right of root (25): " + test.getRoot().getRight());
        // System.out.println("right of root height (1): " + test.getRoot().getRight().getHeight());
        // System.out.println("right of right (30): " + test.getRoot().getRight().getRight());
        // System.out.println("right of right height (2): " + test.getRoot().getRight().getRight().getHeight());

        // System.out.println("\nORDERING\n");
        // System.out.println(test);
        // System.out.println("min: " + test.min());
        // System.out.println("max: " + test.max());

        testRemove();
    }
    
    public static void testRemove() {
        MyBST test = new MyBST();
        test.add(20);
        test.add(15);
        test.add(25);
        test.add(10); // remove doesn't work
        test.add(18);
        test.add(8);
        test.add(12);
        test.add(11);
        test.add(30);
        // System.out.println(test.remove(3));
        // test.add(5);
        // System.out.println(test.remove(3));
        // test.add(3);
        // test.add(2);
        // System.out.println(test.remove(5));
        System.out.println(test);
        test.remove(10);
        System.out.println(test);
    }

    public static void testRebalance(){
        
    }
}
