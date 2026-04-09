import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MiniGPT {

    private String fileName;
    private Random random = new Random();
    private int numChars;
    private HashMap<String, ArrayList<Character>> lists = new HashMap<String, ArrayList<Character>>();

	public MiniGPT(String fileName, int chainOrder) {
        this.fileName = fileName;
        this.numChars = chainOrder;
        this.lists = readData();
	}

	
	public void generateText(String outputFileName) {
        // ArrayList<ArrayList<String>> lists = readData();
        Object[] keys = lists.keySet().toArray();
        // String toReturn = (String) keys[(randomNum(keys.length))];
        String toReturn = "In my y";
        String currContext = toReturn;
        for (int i = 0; i < 240000; i++) {
            char toAdd = predictNextState(currContext);
            toReturn += toAdd;
            currContext = currContext.substring(1) + toAdd;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {
            bw.write(toReturn);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
	}

    public String getFile() {
        return fileName;
    }

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


    // Method to predict the next state given a current state
    public char predictNextState(String currentState) {
        if (lists.containsKey(currentState)) {
            return lists.get(currentState).get(randomNum(lists.get(currentState).size()));
        }
        return '$';
    }
    
    public int randomNum(int max) {
        return random.nextInt(max-1) + 1;
    }
}
