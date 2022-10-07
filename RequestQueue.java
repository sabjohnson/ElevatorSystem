
/* *
 * 
 * the <code>RequestQueue</code> class creates object serving as queue for requests in an elevator(s).
 * 
 * @author Sabrina Johnson
 *    email: sabrina.a.johnson@stonybrook.edu
 *    Stony Brook ID: 114416302
 *    Recitation: 30
 * 
 * 
 * */
import java.util.ArrayList;
public class RequestQueue extends ArrayList {
	
	ArrayList<Request> q = new ArrayList<Request>(); // empty ArrayList which serves as queue (will be manipulated by following functions in this class) 
	
	/**
	 * creates RequestQueue object with null value for ArrayList
	 */
	public RequestQueue() {
		//q = null;	
	}
	
	/**
	 * checks if the queue ArrayList is empty (has no stored values)
	 * @return the boolean value of if the queue is empty
	 */
	public boolean isEmpty() {
		return q.isEmpty();
	}
	
	/**
	 * returns an integer value of the size of the queue (how many elements are in the ArrayList)
	 * @return the integer value of the ArrayList size
	 */
	public int size() {
		return q.size();
	}
	
	/**
	 * Adds a Request object to the end of the queue and sets the time a request was entered
	 * @param r is the Request object being added to queue
	 * @param timeEntered is the time the request was entered into the queue
	 */
	public void enqueue(Request r, int timeEntered) {
		r.setTime(timeEntered);
		q.add(r);
		
	}
	
	/**
	 * Removes the Request object at the front of the queue
	 */
	public void dequeue() {
		if (q.isEmpty()) {
			System.out.println("Queue is empty");
		} else {
			q.remove(0);
		}
		
	}
	
	/**
	 * prints all requests currently in the queue
	 */
	public void printQ() {
		for (Request i : q) {
			System.out.println(i.toString());
		}
	}


}
