public class DoublyLinkedListTester {
    public static void main(String[] args) {
        DoublyLinkedList sample = new DoublyLinkedList();
        // Nucleotide A = new Nucleotide();
        sample.add(Nucleotide.A);
        System.out.println(sample.toString());
        sample.add(Nucleotide.C);
        System.out.println(sample.toString());
    }
}
