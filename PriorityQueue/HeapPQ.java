
public class HeapPQ<E extends Comparable<E>> implements MyPriorityQueue<E> {

	private E[] heap;
	private int objectCount;

	public HeapPQ()
	{
		this.heap = (E[])new Comparable[3];
		this.objectCount = 0;
	}

	//Returns the number of elements in the priority queue
	public int size(){
		return heap.length;
	}

	//DO NOT CHANGE MY JANKY TOSTRING!!!!!
	public String toString()
	{
		StringBuffer stringbuf = new StringBuffer("[");
		for (int i = 0; i < objectCount; i++)
		{
			stringbuf.append(heap[i]);
			if (i < objectCount - 1)
				stringbuf.append(", ");
		}
		stringbuf.append("]\nor alternatively,\n");

		for(int rowLength = 1, j = 0; j < objectCount; rowLength *= 2)
		{
			for (int i = 0; i < rowLength && j < objectCount; i++, j++)
			{
				stringbuf.append(heap[j] + " ");
			}
			stringbuf.append("\n");
			if (j < objectCount)
			{
				for (int i = 0; i < Math.min(objectCount - j, rowLength*2); i++)
				{
					if (i%2 == 0)
						stringbuf.append("/");
					else
						stringbuf.append("\\ ");
				}
				stringbuf.append("\n");
			}
		}
		return stringbuf.toString();
	}

	//Doubles the size of the heap array
	private void increaseCapacity(){
		Object[] newHeap = new Object[heap.length * 2];
		for (int i = 0; i < heap.length; i++) {
			newHeap[i] = (E) heap[i];
		}
		heap = (E[]) newHeap;
	}

	//Returns the index of the "parent" of index i
	private int parent(int i) {
		if (i % 2 == 0) {
			return (i / 2) - 1;
		} else {
			return i / 2;
		}
	}
	
	//Returns the index of the *smaller child* of index i
	private int smallerChild(int i){
		E child1 = heap[(i * 2) + 1];
		E child2 = heap[(i * 2) + 2];
		if (child1.compareTo(child2) < 0) {
			return (i * 2) + 1;
		}
		return (i * 2) + 2;
	}

	//Swaps the contents of indices i and j
	private void swap(int i, int j){
		E first = heap[i];
		E second = heap[j];
		heap[j] = first;
		heap[i] = second;
	}

	// Bubbles the element at index i upwards until the heap properties hold again.
	private void bubbleUp(int i){
		while (heap[i].compareTo(heap[parent(i)]) < 0) {
			swap(i, parent(i));
			i = parent(i);
		}
	}

	// Bubbles the element at index i downwards until the heap properties hold again.
	private void bubbleDown(int i) {
		while (heap[i].compareTo(heap[smallerChild(i)]) > 0) {
			swap(i, smallerChild(i));
			i = smallerChild(i);
		}
	}
	
	public boolean isEmpty() {
		if (peek() == null) {
			return true;
		}
		return false;
	}
	
	public E peek() {
		return heap[0];
	}
	
	public E removeMin() {
		E toReturn = heap[0];
		heap[0] = heap[size() - 1];
		heap[size() - 1] = null;
		bubbleDown(0);
		return toReturn;
	}
	
	public void add(E obj) {
		int index = size();
		increaseCapacity();
		heap[index] = obj;
		bubbleUp(size() -1);
    }

}
