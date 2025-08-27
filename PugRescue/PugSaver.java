import java.util.ArrayList;
import java.util.Objects;

public class PugSaver {

	//Moves every dog whose breed is "Golden Something" in the list to the back of the list
	public static void rescuePugs(ArrayList<Dog> list) {
		for (int i = 0; i < list.size(); i++){
			if (list.indexOf(i) == "Golden Retriever" || list.indexOf(i) == "Goldendoodle") {
				list.add(list.get(i));
				list.remove(i);
			}
		}
	}
}
