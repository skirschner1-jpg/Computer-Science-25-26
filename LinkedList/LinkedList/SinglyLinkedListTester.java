public class SinglyLinkedListTester {

    public static void main(String[] args) {
        // String[] list = {"dog", "cat", "lizard"};
        SinglyLinkedList sample = new SinglyLinkedList();
        sample.add("cat");
        sample.add("dog");
        sample.add("lizard");
        sample.add("hamster");
        System.out.println(sample.get(2));
    }

}
