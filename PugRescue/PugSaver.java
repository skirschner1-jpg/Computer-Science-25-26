import java.util.ArrayList;
import java.util.Objects;

public class PugSaver {

	//Moves every dog whose breed is "Golden Something" in the list to the back of the list
	public static void rescuePugs(ArrayList<Dog> list) {
		int end = list.size - 1;
		for (int i = 0; i < list.size(); i++){
			if (list.indexOf(i).contains("golden")) {
				for(int j = list.size-1; j >0; j--){
					if (!list(j).contains("golden")){
						end = j;
						j = 0;
					}
				}
				Dog temp = list.get(end);
				list.set(end, list.get(i));
				list.set(i, temp);
			}
		}
	}
}
