
/* *
 * 
 * the <code>Elevator</code> class handles the probability of a new request's arrival.
 * 
 * @author Sabrina Johnson
 *    email: sabrina.a.johnson@stonybrook.edu
 *    Stony Brook ID: 114416302
 *    Recitation: 30
 * 
 * 
 * */
public class Elevator {
	
	public int currentFloor; // the current floor the elevator is on
	int elevatorState; // the elevator state (idle, to source, to destination) is what the elevator is doing
	final int TO_SOURCE = -1; // elevatorState type: elevator is traveling to source
	final int IDLE = 0; // theStae type: the elevator is not moving (no requests to handle)
	final int TO_DESTINATION = 1; // elevatorState type: elevator is traveling to destination
	Request request; // Request object being handled by an elevator
	
	/**
	 * creates Elevator object with default values (i.e. request, elevator state and current floor)
	 */
	public Elevator() {
		this.request = null;
		this.elevatorState = IDLE;
		this.currentFloor = 1;
	}
	
	/**
	 * creates Elevator object with specified values (i.e. request, elevator state and current floor).
	 * @param request is a Request object the elevator will handle
	 * @param elevatorState is the current state the elevator is in (idle, to source or to destination)
	 * @param currentFloor is the current floor the elevator is on
	 */
	public Elevator(Request request, int elevatorState, int currentFloor) {
		this.request = request;
		this.elevatorState = elevatorState;
		this.currentFloor = currentFloor;
	}
	
	/**
	 * sets the current floor of the Elevator object
	 * @param currentFloor is the desired current floor for the elevator to be on
	 */
	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
	
	/**
	 * returns the current floor of an Elevator object
	 * @return the current floor of an Elevator object
	 */
	public int getCurrentFloor() {
		return this.currentFloor;
	}
	
	/**
	 * sets the desired state of an Elevator object
	 * @param elevatorState is the desired state to set an Elevator object to (i.e. idle, to source, to destination, etc.)
	 */
	public void setElevatorState(int elevatorState) {
		this.elevatorState = elevatorState;
	}
	
	/**
	 * returns the current state of an Elevator object
	 * @return the current state of an Elevator object
	 */
	public int getElevatorState() {
		return this.elevatorState;
	}
	
	/**
	 * sets the current request being handled by an elevator
	 * @param request is the request that will be handled by an elevator
	 */
	public void setRequest(Request request) {
		this.request = request;
	}
	
	/**
	 * returns the request being handled by an Elevator object
	 * @return the request being handled by an Elevator object
	 */
	public Request getRequest() {
		return this.request;
	}
	
	/**
	 * returns the string value of an elevator and its currents values (current floor, elevator state and request being handled)
	 * @param e is the Elevator object which will be evaluated to make string
	 * @return the string value of an elevator and its currents values (current floor, elevator state and request being handled)
	 */
	public String printStatus(Elevator e) {
		String str = String.format("%-3s%-3s%3s", "Floor " + this.currentFloor, ", " + this.elevatorState, ", " + this.getRequest().toString());
		return "[ " + str + " ]";
		
	}
	
	/**
	 * returns the boolean value of if an elevator is currently on the source floor of its given request
	 * @return the boolean value of if an elevator is currently on the source floor of its given request
	 */
	public boolean onSrcFloor() {
		if (this.getCurrentFloor() == this.getRequest().getSrc()) {
			return true;
		} else return false;
	}
	
	/**
	 * returns the boolean value of if an elevator is currently on the destination floor of its given request
	 * @return the boolean value of if an elevator is currently on the destination floor of its given request
	 */
	public boolean onDstFloor() {
		if (this.getCurrentFloor() == this.getRequest().getDst()) {
			return true;
		} else return false;
	}
	
	/**
	 * moves the current floor of an elevator object one floor closer to the source floor of its given request
	 */
	public void moveToSrc() {
		if (this.getCurrentFloor() < this.getRequest().getSrc()) {
			this.setCurrentFloor(this.getCurrentFloor() + 1);
		}
		if (this.getCurrentFloor() > this.getRequest().getSrc()) {
			this.setCurrentFloor(this.getCurrentFloor() - 1);
		}
	}
	
	/**
	 *  moves the current floor of an elevator object one floor closer to the source floor of its given request
	 */
	public void moveToDst () {
		if (this.getCurrentFloor() < this.getRequest().getDst()) {
			this.setCurrentFloor(this.getCurrentFloor() + 1);
		}
		if (this.getCurrentFloor() > this.getRequest().getDst()) {
			this.setCurrentFloor(this.getCurrentFloor() - 1);
		}
	}
	
}
