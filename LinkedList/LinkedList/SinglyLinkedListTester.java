public class SinglyLinkedListTester {

    public static void main(String[] args) {
        String[] list = {"dog", "cat", "lizard"};
        SinglyLinkedList sample = new SinglyLinkedList();
        System.out.println(sample.size());
        sample.add("cat");
        System.out.println(sample.toString());
        System.out.println("Tail: " + sample.getTail().getValue());
        System.out.println("Head: " + sample.getHead().getValue());
        // System.out.println(sample.getHead().getValue());
        // System.out.println(sample.getTail().getValue());
        // sample.remove("cat");
        // System.out.println(sample.toString());
        // System.out.println(sample.getHead());
        // System.out.println(sample.getTail());
        sample.add("dog");
        System.out.println(sample.toString());
        System.out.println("Tail: " + sample.getTail().getValue());
        System.out.println("Head: " + sample.getHead().getValue());
        sample.add("lizard");
        System.out.println(sample.toString());
        System.out.println("Tail: " + sample.getTail().getValue());
        System.out.println("Head: " + sample.getHead().getValue());
        sample.add("hamster");
        System.out.println(sample.toString());
        System.out.println("Tail: " + sample.getTail().getValue());
        System.out.println("Head: " + sample.getHead().getValue());
        // System.out.println(sample.size());
        // System.out.println(sample.toString());
        // System.out.println(sample.get(2));
        // sample.remove(3);
        // System.out.println(sample.toString());
        // sample.remove("lizard");
        // System.out.println(sample.toString());
        // System.out.println(sample.size());
        // System.out.println(sample.toString());
        // sample.set(1, "gerbil");
        // System.out.println(sample.toString());
        sample.add(4, "gerbil");
        System.out.println(sample.toString());
        System.out.println("Tail: " + sample.getTail().getValue());
        System.out.println("Head: " + sample.getHead().getValue());
        // // sample.remove("gerbil");
        // System.out.println(sample.toString());
        // System.out.println(sample.getTail().getValue());
        // // sample.remove("cat");
        // // sample.remove("dog");
        // // sample.remove("lizard");
        // // sample.remove("hamster");
        // sample.remove(2);
        // System.out.println(sample.toString());
        // // sample.add("cat");
        // // System.out.println(sample.toString());
        // // sample.remove("cat");
        // System.out.println(sample.contains("cat"));
        // sample.remove("cat");
        // System.out.println(sample.toString());
        // // sample.remove("gerbil");
        // // System.out.println(sample.toString());
        // System.out.println(sample.contains("dog"));
        // System.out.println(sample.indexOf("cat"));
        // sample.add(3, "cat");
        // System.out.println(sample.toString());
        // System.out.println("Tail: " + sample.getTail().getValue());
        // sample.set(3, "mouse");
        // System.out.println(sample.toString());
        // System.out.println("Tail: "+ sample.getTail().getValue()); //TAIL IS HAMSTER??
        // // System.out.println(sample.toString());


        // GENERALLY NOT RESETTING TAIL
    }

}
