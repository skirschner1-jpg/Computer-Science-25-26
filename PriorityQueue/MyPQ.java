public class MyPQ<E extends Comparable<E>> implements MyPriorityQueue<E>{
	//Adds obj to the Priority Queue
    public void add(E obj) {
        
    }
	
	//Removes and returns the MINIMUM element from the Priority Queue
    public E removeMin() {
        
    }
	
	//Returns the MINIMUM element from the Priority Queue without removing it
    public E peek() {
        
    }
	
	// Returns true if the priority queue is empty
    public boolean isEmpty() {
        if (peek() == null) {
            return true;
        }
        return false;
    }
    
    public int parentIndex(int index) {
        if (index % 2 == 0) {
            return (index / 2) - 1;
        } else {
            return index / 2;
        }
    }
	
}
