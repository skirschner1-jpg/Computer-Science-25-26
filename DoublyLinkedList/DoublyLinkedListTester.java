public class DoublyLinkedListTester {
    public static void main(String[] args) {
        // EARLY TESTS

        // DoublyLinkedList sample = new DoublyLinkedList();
        // // Nucleotide A = new Nucleotide();
        // sample.add(Nucleotide.A);
        // System.out.println(sample.toString());
        // System.out.println("size: " + sample.size());
        // sample.add(Nucleotide.C);
        // System.out.println(sample.toString());
        // System.out.println("size: " + sample.size());
        // // sample.add(2, Nucleotide.G);
        // // System.out.println(sample.toString());
        // // System.out.println("size: " + sample.size());
        // sample.add(Nucleotide.T);
        // System.out.println(sample.toString());
        // System.out.println("size: " + sample.size());
        // // sample.remove(3);
        // // System.out.println(sample.toString());
        // // System.out.println("size: " + sample.size());
        // sample.add(1, Nucleotide.T);
        // System.out.println(sample.toString());
        // System.out.println("size: " + sample.size());
        // sample.add(Nucleotide.G);
        // System.out.println(sample.toString());
        // sample.add(Nucleotide.T);
        // System.out.println(sample.toString());
        // sample.add(Nucleotide.A);
        // System.out.println(sample.toString());
        // sample.add(2, Nucleotide.G);
        // System.out.println(sample.toString());
        // sample.add(Nucleotide.C);
        // System.out.println(sample.toString());
        // sample.add(Nucleotide.T);
        // System.out.println(sample.toString());
        // sample.add(2, Nucleotide.G);
        // System.out.println(sample.toString());
        // sample.add(Nucleotide.A);
        // System.out.println(sample.toString());
        // sample.add(Nucleotide.A);
        // System.out.println(sample.toString());
        // // System.out.println(sample.toString());
        // // System.out.println(sample.getNode(2)== sample.getNode(2));
        // sample.removeCCCCCCCCGGGGGGGG(sample.getNode(2));
        // System.out.println(sample.toString());

        // CODEGRADE TESTS
        // DoublyLinkedList list = new DoublyLinkedList();
        // // BASIC CONSTRUCTOR
        // System.out.println("BASIC CONSTRUCTOR");
        // list = new DoublyLinkedList();
        // System.out.println(list.size());

        // // ADDING THINGS
        // System.out.println("ADDING THINGS");
        // list.add(Nucleotide.A);
		// list.add(Nucleotide.G);
        // list.add(Nucleotide.C);
        // System.out.println(list.toString());
        // System.out.println("head: " + list.getHead().getValue());
        // System.out.println("tail: " + list.getTail().getValue());

        // // CONSTRUCTOR FROM ARRAY
        // System.out.println("CONSTRUCTOR FROM ARRAY");
        // Nucleotide[] arr = {Nucleotide.A, Nucleotide.G, Nucleotide.C};
        // DoublyLinkedList list = new DoublyLinkedList(arr);
        // // System.out.println("here");
        // // System.out.println(list.toString());
        // // System.out.println(list.size());
        // // System.out.println("head: " + list.getHead().getValue());
        // // System.out.println("tail: " + list.getTail().getValue());
        // int i = 0;
        // // System.out.println(list.getSentinel().getNext().getValue()); //Sentinel.getNext() and getPrevious() work!!
        // for (ListNode2 node = list.getHead(); node != list.getSentinel(); node = node.getNext()) { // always goes one further than mine can handle??? node != list.getSentinel should handle it? // FIXED!!
        //     System.out.println("LOOP ONE");
        //     System.out.println("arr[i]: " + arr[i]);
        //     System.out.println("node.getValue(): " + node.getValue());
        //     i++;
        // }
        // System.out.println("LENGTH VS. I");
        // System.out.println("arr.length: " + arr.length);
		// System.out.println("i: " + i);
		// i--;
        // for (ListNode2 node = list.getTail(); node != list.getSentinel(); node = node.getPrevious()) {
        //     System.out.println("LOOP 2");
        //     System.out.println("arr[i]: " + arr[i]);
        //     System.out.println("node.getValue(): " + node.getValue());
        //     System.out.println("Previous: " + node.getPrevious().getValue());
        //     i--;
        // }
        // System.out.println(list.toString());
        // System.out.println(i);


        // // EXPERIMENTING
        // DoublyLinkedList list = new DoublyLinkedList();
        // list.add(Nucleotide.A);
        // // System.out.println(list.getTail().getNext().getValue());
        // System.out.println("here");
        // list.add(Nucleotide.G);
        // System.out.println("here");
        // list.add(Nucleotide.T);
        // System.out.println("here");
        // list.add(Nucleotide.C);
        // System.out.println("here");
        // System.out.println(list.size());
        // ListNode2 node = list.getHead();
        // // System.out.println(list.getTail().getNext().getValue()); // null meaning the NODE is null -> BAD; how do we make it point to the sentinel node??? what's even going wrong exactly when it tries to??
        // for (int k = 0; k <= list.size(); k++) { // a FIFTH FALSE WHEN WE DO <= size()
        //     System.out.println("here");
        //     node = node.getNext();
        // }

        // // GET
        // System.out.println("GET");
        // System.out.println(list.get(0));
        // System.out.println(list.get(1));
        // System.out.println(list.get(2));

        // // SIZE
        // System.out.println("SIZE");
        // System.out.println(list.size());

        // // ISEMPTY
        // System.out.println("IS EMPTY");
        // System.out.println(list.isEmpty()); // also temp tested for when true in basic constructor

        // // SET
        // System.out.println("SET");
        // list.set(1, Nucleotide.T);
        // System.out.println(list.toString()); // go back and check for tail, head, etc.
        // System.out.println("head: " + list.getHead().getValue());
        // System.out.println("tail: " + list.getTail().getValue());

        // // ADD AT INDEX
        // System.out.println("ADD AT INDEX");
        // System.out.println("add nucleotide");
        // list.add(3, Nucleotide.G);
        // System.out.println(list.size());
        // System.out.println(list.toString());
        // System.out.println("head: " + list.getHead().getValue());
        // System.out.println("tail: " + list.getTail().getValue());

        // // System.out.println("remove index");
        // // list.remove(3);
        // // System.out.println(list.toString());
        // // System.out.println("head: " + list.getHead().getValue());
        // // System.out.println("tail: " + list.getTail().getValue());

        // System.out.println(list.toString());
        // list.add(1, Nucleotide.T);
        // System.out.println(list.toString());
        // System.out.println("head: " + list.getHead().getValue());
        // System.out.println("tail: " + list.getTail().getValue());
        // System.out.println(list.get(0));
        // System.out.println(list.get(1));
        // System.out.println(list.get(2));
        // System.out.println(list.get(3));
        // System.out.println(list.size());

        // int i = 0;
        // System.out.println(list.getHead().getValue());
        // System.out.println("TAIL: " + list.getTail().getValue());
        // System.out.println("Sentinel Last: " + list.getSentinel().getPrevious().getValue());
        // System.out.println(list.size());
        // for (ListNode2 node = list.getHead(); node != list.getSentinel(); node = node.getNext()) {
        //     System.out.println(node.equals(list.getSentinel()));
        //     System.out.println(node.getValue());
        //     i++;
        // }
        // System.out.println(i);
		// i--;
        // for (ListNode2 node = list.getTail(); node != list.getSentinel(); node = node.getPrevious()) {
        //     System.out.println("here #2");
        //     i--;
        // }
        // System.out.println(i);


        // // REMOVE AT INDEX
        // DoublyLinkedList list = new DoublyLinkedList();
        // list.add(Nucleotide.G);
        // System.out.println("HEAD: " + list.getHead().getValue() + "\nTAIL: " + list.getTail().getValue());
        // list.add(Nucleotide.C);
        // System.out.println("HEAD: " + list.getHead().getValue() + "\nTAIL: " + list.getTail().getValue());
        // list.add(Nucleotide.T);
        // System.out.println("HEAD: " + list.getHead().getValue() + "\nTAIL: " + list.getTail().getValue());
        // list.add(Nucleotide.C); // REMOVED
        // System.out.println("HEAD: " + list.getHead().getValue() + "\nTAIL: " + list.getTail().getValue());
        // list.add(Nucleotide.A);
        // System.out.println("HEAD: " + list.getHead().getValue() + "\nTAIL: " + list.getTail().getValue());
        // list.add(Nucleotide.T);
        // System.out.println("HEAD: " + list.getHead().getValue() + "\nTAIL: " + list.getTail().getValue());
        // System.out.println(list.getNode(5).getPrevious().getValue());
        // list.remove(3);
        // System.out.println(list.getNode(4).getPrevious().getValue());
        // System.out.println(list.toString());
        // System.out.println(list.size());
        // int i = 0;
        // // for (ListNode2 node = list.getTail(); node != list.getSentinel(); node = node.getPrevious()) {
        // //     System.out.println("LOOP PRE");
        // //     System.out.println(list.get(i));
        // //     System.out.println(node.getValue());
        // //     i--;
        // // }
        // // // issue w/ tail from add??
        // for (ListNode2 node = list.getHead(); node != list.getSentinel(); node = node.getNext()) {
        //     System.out.println("LOOP 1");
        //     System.out.println(list.get(i));
        //     System.out.println(node.getValue());
		// 	i++;
		// }
		// System.out.println(list.size());
		// i--;
        // for (ListNode2 node = list.getTail(); node != list.getSentinel(); node = node.getPrevious()) {
        //     System.out.println("LOOP 2");
		// 	System.out.println(list.get(i));
        //     System.out.println(node.getValue()); // for the one that isn't working, the node is C (T.getprevious()), even though in the list, we have A as we should... hm
		// 	i--;
		// }
		// System.out.println(i);


        // REMOVE OBJECT
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(Nucleotide.G);
        list.add(Nucleotide.C);
        list.add(Nucleotide.T);
        list.add(Nucleotide.C);
        list.add(Nucleotide.A);
        list.add(Nucleotide.T);
        list.remove(Nucleotide.A);
        int i = 0;
        for (ListNode2 node = list.getHead(); node != list.
        getSentinel(); node = node.getNext()) {
            System.out.println("LOOP 1");
            System.out.println(list.get(i));
            System.out.println(node.getValue());
			i++;
		}
		System.out.println(list.size());
		i--;
        for (ListNode2 node = list.getTail(); node != list.getSentinel(); node = node.getPrevious()) {
            System.out.println("LOOP 2");
            System.out.println(list.get(i));
            System.out.println(node.getValue()); // for the one that isn't working, the node is C (T.getprevious()), even though in the list, we have A as we should... hm
            i--;
        }
        System.out.println(i);
        System.out.println(list.toString());
        DoublyLinkedList list2 = new DoublyLinkedList();
        list2.add(Nucleotide.A);
        list2.add(Nucleotide.G);
        list2.add(Nucleotide.C);
        list.addSegmentToEnd(list2);
        System.out.println(list.toString());
        // list.removeCCCCCCCCGGGGGGGG(list.getNode(1));
        DoublyLinkedList list3 = new DoublyLinkedList();
        list3.add(Nucleotide.T);
        list3.add(Nucleotide.C);
        list3.add(Nucleotide.T);
        list.deleteLastThree();
        System.out.println(list.toString());

    }
}
