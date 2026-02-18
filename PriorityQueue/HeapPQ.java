import java.lang.reflect.Array;
import java.util.NoSuchElementException;

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
		// int toReturn = 1;
		// int index = 0;
		// while (heap[index] != null) {
		// 	// System.out.println("here");
		// 	index++;
		// 	toReturn++;
		// }
		// if (index == 0) {
		// 	return 0;
		// }
		// return toReturn;
		return objectCount;
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
	private void increaseCapacity() {
		// Object[] newHeap = new Object[heap.length * 2];
		// for (int i = 0; i < heap.length; i++) {
		// 	newHeap[i] = (E) heap[i];
		// }
		// heap = (E[]) newHeap;
		Class<?> componentType = heap.getClass().getComponentType();
		int newLength = heap.length * 2;
		@SuppressWarnings("unchecked")
		E[] newArray = (E[]) Array.newInstance(componentType, newLength);
		System.arraycopy(heap, 0, newArray, 0, heap.length);
		heap = newArray;
	}
	
	// private void increaseCapacity(E obj){
	// 	// Object[] newHeap = new Object[heap.length * 2];
	// 	// for (int i = 0; i < heap.length; i++) {
	// 	// 	newHeap[i] = (E) heap[i];
	// 	// }
	// 	// heap = (E[]) newHeap;
	// 	Class<?> componentType = heap.getClass().getComponentType();
    //     int newLength = heap.length * 2;
    //     @SuppressWarnings("unchecked")
	// 	E[] newArray = (E[]) Array.newInstance(componentType, newLength);
    //     System.arraycopy(heap, 0, newArray, 0, heap.length);
    //     heap = newArray;
	// }

	//Returns the index of the "parent" of index i
	private int parent(int i) {
		if (i % 2 == 0) {
			return (i / 2) - 1;
		} else {
			return i / 2;
		}
	}
	
	//Returns the index of the *smaller child* of index i
	private int smallerChild(int i) {
		if ((i * 2) + 1 >= size() && i * 2 + 2 >= size()) {
			return -1;
		}
		if ((i * 2) + 1 < size() && i * 2 + 2 >= size()) {
			if (heap[(i * 2) + 1] != null) {
				return (i * 2) + 1;
			}
		}
		E child1 = heap[(i * 2) + 1];
		E child2 = heap[(i * 2) + 2];
		if ((i * 2) + 1 < size() && (i * 2) + 2 < size() && child1 != null && child2 != null) {
			if (child1.compareTo(child2) < 0) {
				return (i * 2) + 1;
			}
			return (i * 2) + 2;
		}
		if ((i * 2) + 1 < size() && child1 != null) {
			return (i * 2) + 1;
		}
		return -1;
	}

	//Swaps the contents of indices i and j
	private void swap(int i, int j){
		E first = heap[i];
		E second = heap[j];
		heap[j] = first;
		heap[i] = second;
	}

	// Bubbles the element at index i upwards until the heap properties hold again.
	private void bubbleUp(int i) {
		// System.out.println(i);
		while (i > 0 && heap[i] != null && heap[i].compareTo(heap[parent(i)]) < 0) {
			swap(i, parent(i));
			i = parent(i);
			// System.out.println("here");
		}
	}

	// Bubbles the element at index i downwards until the heap properties hold again.
	private void bubbleDown(int i) {
		while (smallerChild(i) >= 0 && heap[i].compareTo(heap[smallerChild(i)]) > 0) {
			swap(i, smallerChild(i));
			i = smallerChild(i);
		}
	}
	
	public boolean isEmpty() {
		if (objectCount == 0) {
			return true;
		}
		return false;
	}
	
	public E peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Heap is Empty");
		}
		return heap[0];
	}
	
	public E removeMin() {
		if (isEmpty()) {
			throw new NoSuchElementException("Heap is Empty");
		}
		E toReturn = heap[0];
		heap[0] = heap[size() - 1];
		heap[size() - 1] = null;
		bubbleDown(0);
		objectCount--;
		return toReturn;
	}
	
	public void add(E obj) {
		// System.out.println(obj);
		int index = size();
		increaseCapacity();
		heap[index] = obj;
		// System.out.println("here");
		if (size() > 0) {
			bubbleUp(size() - 1);
			// System.out.println("here");
		}
		objectCount++;
    }

}
