// import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;

// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;

class TestMyPQ {
	MyPQ<Integer> pq = new MyPQ<Integer>();
	ArrayList<Integer> sortedList = new ArrayList<Integer>();

	void fillListWithData() {

		pq.add(10);
		pq.add( 6);
		pq.add(11);
		pq.add( 8);
		pq.add( 9);
		pq.add( 5);
		pq.add( 7);
		sortedList.add(5);
		sortedList.add(6);
		sortedList.add(7);
		sortedList.add(8);
		sortedList.add(9);
		sortedList.add(10);
		sortedList.add(11);
	}


	// @Test
	// @DisplayName("[15] Test if removeMin works")
	public void testRemoveMin() {

		fillListWithData();
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.println("should be: " + sortedList.get(i));
            System.out.println("is: " + pq.removeMin());
		}
		
	}
	
	// @Test
	// @DisplayName("[5] Test if peek works")
	public void testPeek() {

		fillListWithData();
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.println("should be: " + sortedList.get(i));
            System.out.println("is: " + pq.peek());
			pq.removeMin();
			
		}
		
	}
	
	// @Test
	// @DisplayName("[5] Test if isEmpty works")
    public void testIsEmpty() {
        System.out.println("true: " + pq.isEmpty());
        fillListWithData();
        System.out.println("false: " + pq.isEmpty());

    }
    
    public static void main(String[] args) {
        TestMyPQ test = new TestMyPQ();
        test.testRemoveMin();
    }
}