public class SinglyLinkedListTester {

    public static void main(String[] args) {
        String[] list = {"dog", "cat", "lizard"};
        SinglyLinkedList sample = new SinglyLinkedList(list);
        sample.add("cat");
        System.out.println(sample.toString());
        sample.add("dog");
        System.out.println(sample.toString());
        sample.add("lizard");
        System.out.println(sample.toString());
        sample.add("hamster");
        System.out.println(sample.toString());
        System.out.println(sample.size());
        System.out.println(sample.toString());
        System.out.println(sample.get(2));
        // sample.remove(3);
        // System.out.println(sample.toString());
        // sample.remove("lizard");
        // System.out.println(sample.toString());
        // System.out.println(sample.size());
        System.out.println(sample.toString());
        sample.add(2, "gerbil");
        System.out.println(sample.toString());
    }

}
