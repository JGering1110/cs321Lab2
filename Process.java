
/**
 * Class to make process objects to insert into queue.
 * Each process has a priority level, time remaining to finish, 
 * and arrival time.
 * @author Jayden Gering
 *
 */

public class Process implements Comparable<Process> {
	
	private int priorityLevel, requiredProcessingTime, timeNotProcessed, arrivalTime;
	
	/**
	 * Constructor
	 * @param int currentTime - current time of process
	 * @param int maxProcessTime - maximum process time of process
	 * @param int maxLevel - maximum priority level of process
	 */
	public Process(int currentTime, int maxProcessTime, int maxLevel) {
		arrivalTime = currentTime;
		requiredProcessingTime = maxProcessTime;
		priorityLevel = maxLevel;
		timeNotProcessed = 0;
	}
	
	/**
	 * Resets the time not processed to 0
	 */
	public void resetTimeNotProcessed() {
		timeNotProcessed = 0;
	}
	
	/**
	 * increases the time not processed
	 */
	public void increaseTimeNotProcessed() {
		timeNotProcessed++;
	}
	
	/**
	 * Gets arrival time
	 */
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	//dont know if I need this
	/**
	 * Gets maxProcess time
	 */
	public int getMaxProcessTime() {
		return requiredProcessingTime;
	}
	
	/**
	 * determines if process time remaining is finished or not
	 * @return - true if finished else false
	 */
	public boolean finish() {
		if(requiredProcessingTime <= 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * reduces time remaining for a process
	 */
	public void reduceTimeRemaining() {
		requiredProcessingTime--;
	}
	
	/**
	 * Gets priority level
	 * @return priorityLevel - level priority is at
	 */
	public int getPriority() {
		return priorityLevel;
	}
	
	/**
	 * increases priority level
	 */
	public void increasePriority() {
		priorityLevel++;
	}
	
	
	//dont know if I need this 
	/**
	 * Gets time remaining
	 * @return timeRemaining - time remaining for job
	 */
	public int getTimeRemaining() {
		//int timeRemaining = requiredProcessingTime - timeNotProcessed;
		return requiredProcessingTime;
	}
	
	/**
	 * Gets time not processed
	 * @return timeNotProcessed - amount of time not processed
	 */
	public int getTimeNotProcessed() {
		return timeNotProcessed;
	}
	
	//question here
	@Override
	public int compareTo(Process proc) {
		if(this.getPriority() > proc.getPriority()) {
			return 1;
		} else if (this.getPriority() < proc.getPriority()) {
			return -1;
		} else {
			if(this.getArrivalTime() < proc.getArrivalTime()) {
				return 1;
			} else {
				return -1;
			}
		}
		
	}



}
