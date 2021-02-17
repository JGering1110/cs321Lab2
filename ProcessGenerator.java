import java.util.Random;

/**
 * Randomly generates processes with a given probability. At beginning
 * of each time unit, whether a process will arrive is decided by the given probability.
 * Both priority and required time units to finish the
 * process are randomly generated within given ranges
 * @author Jayden Gering
 *
 */

public class ProcessGenerator {
	
	private double prob;
	private Random randomValue;

	/**
	 * Constructor
	 * @param double probability - given probability
	 */
	public ProcessGenerator(double probability) {
		randomValue = new Random();
		this.prob = probability;
	}
	
	/**
	 * Generates a new process
	 * @param int currentTime - current time of process
	 * @param int maxProcessTime - maximum process time of process
	 * @param int maxLevel - maximum priority level of process
	 */
	public Process getNewProcess(int currentTime, int maxProcessTime, int maxLevel) {
		int current = currentTime;
		int maxTime = randomValue.nextInt(maxProcessTime) +1;
		int maxLev = randomValue.nextInt(maxLevel) +1;
		return new Process(current, maxTime, maxLev);
		
	}

	/**
	 * boolean to see if new process should be made or not
	 * @return - true if we want new process else false
	 */
	public boolean query() {
		
		double randomVal = randomValue.nextDouble();
		if(randomVal <= prob) {
			return true;
		}
		return false;
	}

}
