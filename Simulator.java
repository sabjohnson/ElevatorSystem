
/* *
 * 
 * the <code>Simulator</code> creates a simulation of an elevator system with a queue and multiple elevators.
 * 
 * @author Sabrina Johnson
 *    email: sabrina.a.johnson@stonybrook.edu
 *    Stony Brook ID: 114416302
 *    Recitation: 30
 * 
 * 
 * */
import java.util.ArrayList;
public class Simulator {
	static boolean debug = false; // boolean value, set to true to see the elevators path step by step
	
	
	/**
	 * creates a Simulator object for use outside of this class
	 */
	public Simulator() {}
	
	/**
	 * creates simulation of elevator system
	 * @param probability is the probability of of a requests arrival
	 * @param numFloors is the max/total number of floors in the building
	 * @param numElevators is the max/total number of elevators in the building
	 * @param simTime is the length of the simulation in units
	 */
	public static void simulate(double probability, int numFloors, int numElevators, int simTime) {
		if (!(probability >= 0 && probability <= 1) || numFloors <= 1 || numElevators <= 0 || simTime <= 0) {
			System.out.println("no simulation");
		} else {
			
			RequestQueue q = new RequestQueue(); // create queue for elevator system
			Elevator[] boxes = new Elevator[numElevators]; // creates array of Elevator objects to handle the queue
			for (int i = 0; i < numElevators; i++) {
				boxes[i] = new Elevator();
			}
			int totalWaitTime = 0; // the wait time for elevator to get to source floor of its request
			int totalRequests = 0; // number of requests given that reached their source floor
			
			
			for (int i = 0; i < simTime; i++) {

				BooleanSource arrival = new BooleanSource(probability);
				ArrayList<String> arr = new ArrayList<String>();
				
				//EVENT 1: has request arrived?
				if (arrival.requestArrived() == true) {
					//add request to queue
					Request r = new Request(numFloors);
					q.enqueue(r, i + 1);
					if (debug == true)
						System.out.println(r.toString());
				}
				
				// EVENT 2: all idle elevators are given a request if queue isn't empty
				if (!q.isEmpty()) {
					for (Elevator h : boxes) {
						if (!q.isEmpty()) {
							if (h.getElevatorState() == 0) {
								h.setRequest(q.q.get(0));
							    h.setElevatorState(-1);
								q.dequeue();
							}
						} else
							break;
					}
				}
				
				// EVENT 3: we can simply move all elevators that are not IDLE
				// move all TO_SOURCE elevators 1 floor
				
				for (Elevator y : boxes) {
					
					switch(y.getElevatorState()) {
					
					case -1:
						if (!y.onSrcFloor()) {
							y.moveToSrc();
							if (y.onSrcFloor() && !y.onDstFloor()) {
								totalWaitTime += ((i + 1) - y.getRequest().getTime());
								totalRequests++;
								y.setElevatorState(1);
								break;
							}
							if (y.onSrcFloor() && y.onDstFloor()) {
								totalWaitTime += ((i + 1) - y.getRequest().getTime());
								totalRequests++;
								y.setElevatorState(0);
								y.setRequest(null);
								break;
							}
						} else {
							totalRequests++;
							if (!y.onDstFloor()) {
								y.setElevatorState(1);
								y.moveToDst();
								// check if on destination
								if (y.onDstFloor()) {
									y.setElevatorState(0);
									y.setRequest(null);
								}
							} else {
								y.setElevatorState(0);
								y.setRequest(null);
							}
						}
						break;
					
					case 1:
						if (!y.onDstFloor()) {
							y.moveToDst();
							if (y.onDstFloor()) {
								y.setElevatorState(0);
								y.setRequest(null);
								break;
							}
						} else {
							y.setElevatorState(0);
							y.setRequest(null);
						}
						break;
						
					case 0:
						y.setRequest(null);
						break;
					}
					
					
					if (y.getRequest() != null && y.getElevatorState() != 0) {
						arr.add(y.printStatus(y));
					}
					
				}
			
				if (debug == true)
					System.out.println("Elevators: " + arr.toString());
				
			} // for loops finished
			
			// print values
			System.out.println();
			System.out.println("Total wait time: " + totalWaitTime);
			System.out.println("Total requests: " + totalRequests);
			
			double avgWaitTime = (double)totalWaitTime / totalRequests;
			System.out.println("Average wait time: " + String.format("%.2f", avgWaitTime));
			
		} // end of valid simulation case
		
	} //simulation function closes
	public static void main(String[] args) {}

}
