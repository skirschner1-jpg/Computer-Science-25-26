public class TestMyHash {
    public static void main(String[] args) {
        String[] names = {
            "Mateo Atluri",
            "Asher Butan",
            "Xander Cheuk",
            "Taj Clement",
            "Camille Condren",
            "Evan Daneshrad",
            "Felicia Duan",
            "Jake Effress",
            "Zachary Figlin",
            "James Graczyk",
            "David Hadi",
            "Quinn Harris",
            "Jackson Hubbard",
            "Siona Kirschner",
            "Dylan Martin",
            "Morgan Maynard",
            "Yari Milakin",
            "Waller Morton",
            "Andrew Stout",
            "Mattin Tasbihgoo",
            "Andrew Theiss",
            "Carter Tsao"
        };
          
        String[] names2 = {
            "Rose Ananda",
            "Autrin Anousheh",
            "Joshua Bie",
            "Elsa Cheng",
            "Isabel Erlic",
            "Jojo Gott",
            "Connor Jun",
            "Jordan Kay",
            "James Klarin",
            "Judy Law",
            "Grayden Lichtman",
            "Runshi Liu",
            "Juan Lopez",
            "Henry Margolis",
            "Garret Morberg-Nguyen",
            "Kai Nantamanasikarn",
            "Remi O'Dell",
            "Emil Palmer",
            "Jaden Park",
            "Ryder Rufi",
            "Alice Shao",
            "Marco Silvera",
            "Samuel Tabib",
            "Andrew Theiss",
            "Shriya Vishwas",
            "Nick Waller",
            "Vikram Wright",
            "Alex Yang",
            "Ethan You",
            "Lucas Yu",
            "Jack Yuan",
            "Jayden Zepeda",
            "Lawrence Zhao",
            "Michael Zhao",
            "Olivia Zhu"
        };
          
        MyHash test = new MyHash();
        // for (int i = 0; i < names.length; i++) {
        //     System.out.println(test.hashFunction(names[i]));
        // }
        String[] output = new String[500];
        for (int i = 0; i < names2.length; i++) {
            // System.out.println("here");
            int nextIndex = test.hashFunction(names2[i]);
            if (output[nextIndex] != null) {
                System.out.println("duplicateFound for name: " + names2[i] + " at index:" + nextIndex);
            }
            output[nextIndex] = names2[i];
        }
        // System.out.println(test.getIndex("Apple"));
        // System.out.println(test.getIndex("Banana"));
        // System.out.println(test.getIndex("Guava"));
        // System.out.println(test.getIndex("Mango"));
        // System.out.println(test.getIndex("Papaya"));
        // System.out.println(test.getIndex("Passionfruit"));
        // System.out.println(test.getIndex("Pineapple"));
        // System.out.println(test.getArray());
    }

}
