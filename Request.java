
/* *
 * 
 * the <code>Request</code> class creates objects serving as requests in an elevator queue.
 * 
 * @author Sabrina Johnson
 *    email: sabrina.a.johnson@stonybrook.edu
 *    Stony Brook ID: 114416302
 *    Recitation: 30
 * 
 * 
 * */
public class Request {
	
	public int sourceFloor; // source/"pick up" floor for request
	public int destinationFloor; // destination/"drop off" floor for request
	public int timeEntered; // time request was entered
	public int numFloors; // max floors in building
	
	// mutators methods
	
	/**
	 * sets source floor for Request object
	 * @param sourceFloor is the source floor being set for the request
	 */
	public void setSrc(int sourceFloor) {
		this.sourceFloor = sourceFloor;
	}
	
	/**
	 * sets destination floor for Request object
	 * @param destinationFloor is the destination floor being set for the request
	 */
	public void setDst(int destinationFloor) {
		this.destinationFloor = destinationFloor;
	}
	
	/**
	 * sets time request was entered
	 * @param timeEntered is the time the request was entered
	 */
	public void setTime(int timeEntered) {
		this.timeEntered = timeEntered;
	}
	
	/**
	 * sets the max/total number of floors in a building
	 * @param numFloors is the max/total number of floors in a building
	 */
	public void setMax(int numFloors) {
		this.numFloors = numFloors;
	}
	
	// accessor methods
	
	/**
	 * returns the source floor for a request
	 * @return the source floor for a request
	 */
	public int getSrc() {
		return sourceFloor;
	}
	
	/**
	 * returns the destination floor for a request
	 * @return the destination floor for a request
	 */
	public int getDst() {
		return destinationFloor;
	}
	
	/**
	 * returns the time a request was entered
	 * @return the time a request was entered
	 */
	public int getTime() {
		return timeEntered;
	}
	
	/**
	 * returns the max/total number of floors in a building
	 * @return the max/total number of floors in a building
	 */
	public int getMax() {
		return numFloors;
	}
	
	// request objects
	
	/**
	 * creates a Request object with specified values (i.e. src floor, dst floor, max floors, etc.)
	 * @param numFloors is the max/total number of floors in a building
	 */
	public Request(int numFloors) {
		this.sourceFloor = (int) (1 + Math.random()*numFloors);
		this.destinationFloor = (int) (1 + Math.random()*numFloors);
		setMax(numFloors);
	}
	
	/**
	 * creates/returns a string of the values in a Request object
	 * @return a string of the values in a Request object
	 */
	public String toString() {
		
		return "(" + sourceFloor + "," + destinationFloor + "," + timeEntered + ")";
		//return String.format("%-15s%25s%25s", "source floor: " + sourceFloor, "destination Floor: " + destinationFloor, "time entered: " + timeEntered);
	}


}
