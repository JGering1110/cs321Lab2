

/**
 * MaxHeap implementation of priority queue
 * @author Jayden Gering
 *
 */
public class PQueue {
	
	private MaxHeap maxHeapQ;
	
	//constructor
	public PQueue() {
		maxHeapQ = new MaxHeap();
	}

	/**
	 * puts new process into queue
	 * @param next - process to be inserted
	 */
	public void enPQueue(Process next) {
		//callmaxHeapInsert and maxHeapify
		//should I call maxHeapify in maxHeapInsert method
		maxHeapQ.maxHeapInsert(next);
	}

	/**
	 * removes a process from queue
	 * @return - max process to be removed
	 */
	public Process dePQueue() {
		return maxHeapQ.extractMax();
	}
	
	/**
	 * updates queue with updated processes
	 * @param int timeToIncrementPriority - time to increment the priority
	 * @param int maxLevel - max priority level in queue
	 */
	public void update(int timeToIncrementPriority, int maxLevel) {
		for(int i = 0; i < (maxHeapQ.getArrayList().size()); i++) {//took out .size()-1
			Process proc = maxHeapQ.getArrayList().get(i);
			//if(proc != null) {
				
				proc.increaseTimeNotProcessed();
			
			if(proc.getTimeNotProcessed() >= timeToIncrementPriority) {
				proc.resetTimeNotProcessed();
				if(proc.getPriority() < maxLevel) {
					proc.increasePriority();
					maxHeapQ.increaseKey(i, proc);
				}
			}
			//}
		}
	}
	
	/**
	 * boolean to determine if list is empty
	 * @return - true if empty else false
	 */
	public boolean isEmpty() {
		return maxHeapQ.isEmpty();
	}

}
