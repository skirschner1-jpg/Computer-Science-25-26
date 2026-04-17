import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Huffman {

    private String fileName;
    private Random random = new Random();
    private int numChars;
    private HashMap<String, ArrayList<Character>> lists = new HashMap<String, ArrayList<Character>>();
    
    public HashMap<String, ArrayList<Character>> readData() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            String totalText = "";
            while ((line = br.readLine()) != null) {
                totalText += line;
            }
            int startingIndex = 0;
            String currContext = totalText.substring(startingIndex, numChars);
            for (int i = numChars; i < totalText.length(); i++) {
                boolean sorted = false;
                if (lists.containsKey(currContext)) {
                    lists.get(currContext).add(totalText.charAt(i));
                }
                else {
                    ArrayList<Character> addition = new ArrayList<Character>();
                    addition.add(totalText.charAt(i));
                    lists.put(currContext, addition);
                }
                startingIndex++;
                currContext = totalText.substring(startingIndex, numChars + startingIndex);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }
}
