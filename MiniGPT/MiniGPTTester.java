import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MiniGPTTester {
    public static void main(String[] args) {
        MiniGPT test = new MiniGPT("thegreatgatsby.txt", 7);
        HashMap<String,ArrayList<Character>> list = test.readData();
        for (Map.Entry<String, ArrayList<Character>> entry : list.entrySet()) {
            System.out.print(entry.getKey() + " ");
            for (int j = 0; j < entry.getValue().size(); j++) {
                System.out.print(entry.getValue().get(j) + ", ");
            }
            System.out.println();
        }
        test.generateText("gatsby2.txt");
    }
}
