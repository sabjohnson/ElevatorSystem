
/* *
 * 
 * the <code>BooleanSource</code> class handles the probability of a new request's arrival.
 * 
 * @author Sabrina Johnson
 *    email: sabrina.a.johnson@stonybrook.edu
 *    Stony Brook ID: 114416302
 *    Recitation: 30
 * 
 * 
 * */
public class BooleanSource {
	public double probability; // the probability of a new request being entered into the queue
	
	/**
	 * sets the probability of a new request occurring
	 * @param probability is the probability of a new request occurring
	 */
	public BooleanSource(double probability) {
		this.probability = probability;
	}
	
	/**
	 * returns the boolean value of if a new request has arrived
	 * @return the boolean value of if a new request has arrived
	 */
	public boolean requestArrived() {
		if (Math.random() <= this.probability) {
			return true;
		} else {
			return false;
		}
	}

}
