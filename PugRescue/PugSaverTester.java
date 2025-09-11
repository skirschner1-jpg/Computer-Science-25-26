import java.util.ArrayList;

public class PugSaverTester {
    
    public static void main(String[] args){

        ArrayList<Dog> doglist = new ArrayList(1000000);
        Dog doodle = new Dog("Pip", "Golden Doodle");
        Dog pug = new Dog("Emily", "Pug");
        Dog retriever = new Dog("Mochi", "Golden Retriever");

        for (int i = 0; i < 1000000; i++) {
            doglist.add(doodle);
            doglist.add(pug);
            doglist.add(retriever);
        }

        PugSaver.rescuePugs(doglist);

        for (int i = 0; i < doglist.size(); i++) {
            System.out.println(doglist.get(i).getBreed() +  ", ");
        }
       
    }
}
