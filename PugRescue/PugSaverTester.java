import java.util.ArrayList;

public class PugSaverTester {
    
    public static void main(String[] args) {

        // ArrayList<Dog> doglist = new ArrayList(90);
        // Dog doodle = new Dog("Pip", "Golden Doodle");
        // Dog pug = new Dog("Emily", "Pug");
        // Dog retriever = new Dog("Mochi", "Golden Retriever");

        // for (int i = 0; i < 30; i++) {
        //     doglist.add(doodle);
        //     doglist.add(pug);
        //     doglist.add(retriever);
        // }

        // PugSaver.rescuePugs(doglist);

        // for (int i = 0; i < doglist.size(); i++) {
        //     System.out.println(doglist.get(i).getBreed() +  ", ");
        // }
        MyArrayList<String> sample = new MyArrayList<>(2);
        sample.add("A");
        sample.add("B");
        sample.add("C");
        sample.add("D");
        sample.add("E");
        sample.add("F");
        sample.add("G");
        sample.add("H");
        sample.add("I");
        sample.remove("A");
        sample.toString();
        sample.remove("I");
        sample.toString();
        sample.remove("F");
        sample.toString();
        // sample.toString();
        // sample.add(1, "D");
        // sample.toString();
        // System.out.println(sample.size());
        // System.out.println(sample.remove("D"));
        // sample.toString();
        // System.out.println(sample.size());
        // System.out.println(sample.get(2));
    }

}
