import java.util.ArrayList;
import java.util.Objects;

public class PugSaver {

	//Moves every dog whose breed is "Golden Something" in the list to the back of the list
	public static void rescuePugs(ArrayList<Dog> list) {
		// int end = list.size() - 1;
		// boolean done = false;
		// for (int i = 0; i < list.size(); i++){
		// 	if (list.get(i).getBreed().contains("Golden") == true) {
		// 		for (int j = list.size() - 1; j > 0; j--) {
		// 			if (!list.get(j).getBreed().contains("Golden")) {
		// 				end = j;
		// 				j = 0;
		// 			}
		// 			else if (j == 1) {
		// 				done = true;
		// 			}
		// 		}
		// 		if (!done) {
		// 			Dog temp = list.get(end);
		// 			list.set(end, list.get(i));
		// 			list.set(i, temp);
		// 		} else {
		// 			i = list.size();
		// 		}
		// 	}
		// }
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getBreed().contains("Golden") == true) {
				for (int j = list.size()-1; j > i; j--) {
					if (!list.get(j).getBreed().contains("Golden")) {
						Dog temp = list.get(j);
						list.set(j, list.get(i));
						list.set(i, temp);
						j = i;
					}
					else if(list.get(j).getBreed().contains("Golden") && j == i-1){
						i = list.size();
					}
				}
			}
		}
	}
}
