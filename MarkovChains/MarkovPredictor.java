import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;;

public class MarkovPredictor {

    private ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
    private Random random = new Random();

    public ArrayList<ArrayList<String>> getLists() {
        return lists;
    }

    // Please define your own variables and data structures
    // 
    public ArrayList<ArrayList<String>> readData(String filePath) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                boolean sorted = false;
                for (int i = 0; i < lists.size(); i++) {
                    if (lists.get(i).get(0).equals(beforeComma(line))) {
                        lists.get(i).add(afterComma(line));
                        sorted = true;
                    }
                }
                if (!sorted) {
                    ArrayList<String> addition = new ArrayList<String>();
                    addition.add(beforeComma(line));
                    addition.add(afterComma(line));
                    lists.add(addition);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }


    // Method to predict the next state given a current state
    public String predictNextState(String currentState) {
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).get(0).equals(beforeComma(currentState))) {
                return lists.get(i).get(randomNum(lists.get(i).size()));
            }
        }
        return null;
    }
    
    // HELPERS
    public String beforeComma(String pair) {
        String toReturn = "";
        boolean done = false;
        for (int i = 0; i < pair.length(); i++) {
            if (pair.charAt(i) != ',' && !done) {
                toReturn += pair.charAt(i);
            } else {
                done = true;
            }
        }
        return toReturn;
    }
    
    public String afterComma(String pair) {
        String toReturn = "";
        boolean afterComma = false;
        for (int i = 0; i < pair.length(); i++) {
            if (afterComma) {
                toReturn += pair.charAt(i);
            }
            if (pair.charAt(i) == ',') {
                afterComma = true;
            }
        }
        return toReturn;
    }
    
    public int randomNum(int max) {
        return random.nextInt(max-1) + 1;
    }


}