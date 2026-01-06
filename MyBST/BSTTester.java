public class BSTTester {
    public static void main(String[] args) {
        MyBST test = new MyBST();
        test.add(20);
        test.add(12);
        test.add(30);
        test.add(11);
        System.out.println(test.add(11));
        System.out.println(test.getRoot());
        System.out.println(test.getRoot().getLeft());
        System.out.println(test.getRoot().getLeft().getLeft());
        System.out.println(test.getRoot().getRight());
        // System.out.println(test.toString());
    }
}
