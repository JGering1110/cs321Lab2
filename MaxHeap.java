import java.util.ArrayList;
//import java.util.Collections;

/**
 * ArrayList based implementation of MaxHeap
 * @author Jayden Gering
 *
 */

public class MaxHeap {
	
	//not too sure on here
	//private static final int MIN_VALUE = -1000000;
	private ArrayList<Process> maxHeap;
	//private int nextOpenIndex;
	private int maxHeapSize;
	
	//constructor
	public MaxHeap() {
		maxHeap = new ArrayList<Process>();
		maxHeapSize = 0;
	}

	/**
	 * Gets parent index
	 * @param index - index of process
	 * @return - parent index
	 */
	public int parentNodeIndex(int index) {
		
		if(index % 2 == 0 && index != 0) {
			return (index/2) -1;
		}
		return index/2;
	}
	
	/**
	 * Gets left child index
	 * @param index - index of process
	 * @return - left child index
	 */
	public int rightChildNodeIndex(int index) {
		if(index == 0 && (maxHeapSize -1) < 2) {
			return 10000;
		}
		if(index == 0) {
			return 1;
		}
		if(index * 2 >= maxHeapSize -1) {
			return 10000;
		}
		return (index*2) +2;
	}
	
	/**
	 * Gets right child index
	 * @param index - index of process
	 * @return - right child index
	 */
	public int leftChildNodeIndex(int index) {
		//need to do boundary checks
		if(index == 0 && (maxHeapSize -1) < 3) {
			return 10000;
		}
		if(index == 0) {
			return 2;
		}
		if((index * 2) +1 >= maxHeapSize -1) {
			return 10000;
		} 
		return (index*2) +1;
	}
	
	/**
	 * Exchanges indexes
	 * @param firstIndex - first index to switch
	 * @param secondIndex - second index to switch
	 * @return - array with given indexes switched
	 */
	//private ArrayList<Process> exchange(int firstIndex, int secondIndex) {
		//Collections.swap(maxHeap, firstIndex, secondIndex);
		//return maxHeap;
	//}
	
	private ArrayList<Process> exchange(int first, int second) {
		Process temp = maxHeap.get(first);
		maxHeap.set(first, maxHeap.get(second));
		maxHeap.set(second, temp);
		return maxHeap;
	}
	

	/**
	 * maxHeapifys array list downwards from given index
	 * @param index - index of process in array
	 */
	public void maxHeapify(int index) {
		
		int left = leftChildNodeIndex(index);
		int right = rightChildNodeIndex(index);
		int largest = index;
		
		if(left <= (maxHeapSize) -1 && maxHeap.get(left).compareTo(maxHeap.get(index)) > 0) {
			largest = left;
		}
		if(right <= (maxHeapSize)-1 && maxHeap.get(right).compareTo(maxHeap.get(index)) > 0) {
			largest = right;
		}
		if(largest != index) {
			maxHeap = exchange(index,largest);
			maxHeapify(largest);
		}
	}
	
	/**
	 * builds max heap
	 */
	public void buildMaxHeap() {
		for(int i = (maxHeapSize/2) -1; i >= 1; i++) {
			maxHeapify(i);
		}
	}
	
	/**
	 * performs heapsort to recursively sort array
	 * 
	 */
	public void heapSort() {
		buildMaxHeap();
		for(int i = maxHeapSize -1; i >= 2; i--) { //changed from 1 to 2
			exchange(1,i);
			maxHeapSize--;
			maxHeapify(1);
		}
	}
	
	/**
	 * extracts maximum value of heap
	 */
	public Process extractMax() {
		if(maxHeapSize < 0) {
			throw new RuntimeException("Heap underflow error");
		}
		Process maxProcess = maxHeap.get(0);
		maxHeap.set(0, maxHeap.get(maxHeapSize-1));
		maxHeap.remove(maxHeapSize-1);
		maxHeapSize--;
		maxHeapify(0);

		return maxProcess;
	}
	
	/**
	 * performs maxHeapify upwards
	 */
	public void increaseKey(int index, Process key) {
		
		int parent = parentNodeIndex(index);
		//if(maxHeap.get(parentNodeIndex(index)) != null) 
		
		if(parent <= maxHeapSize -1 && parent >= 0) {
			
			//maxHeap.add(index, key);
			while(index >= 1 && maxHeap.get(parentNodeIndex(index)).compareTo(maxHeap.get(index)) < 0) {
				exchange(index, parentNodeIndex(index));
				index = parentNodeIndex(index);
			}
		}

		
	}
	//check logic above
	
	/**
	 * inserts into heap
	 */
	public void maxHeapInsert(Process key) {
		maxHeap.add(maxHeapSize, key);
		increaseKey(maxHeapSize, key);
		maxHeapSize++;
	}
	
	/**
	 * boolean to determine if list is empty
	 * @return - true if empty else false
	 */
	public boolean isEmpty() {
		if(maxHeapSize == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * gets maxheap arrayList (for use in PQueue)
	 * @return maxHeap - maxHeaped arrayList
	 */
	public ArrayList<Process> getArrayList() {
		return maxHeap;
	}
		

}
