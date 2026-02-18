public class HeapPQTester {
    public static void main(String[] args) {
        HeapPQ test = new HeapPQ();
        test.add(5);
        System.out.println(test);
        test.add(0);
        System.out.println(test);
        test.add(6);
        System.out.println(test);
        test.add(8);
        System.out.println(test);
        test.add(10);
        System.out.println(test);
        test.add(9);
        System.out.println(test);
        System.out.println(test.removeMin());
        System.out.println(test);
        System.out.println(test.peek());
    }
}
