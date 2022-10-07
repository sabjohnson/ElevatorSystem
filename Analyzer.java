
/* *
 * 
 * the <code>Analyzer</code> allows users to enter input for a simulation (with valid parameters).
 * <Note> simulation of length 10^8 and above take a longer runtime to produce output. You would just need to wait for a minute or two.
 * 
 * @author Sabrina Johnson
 *    email: sabrina.a.johnson@stonybrook.edu
 *    Stony Brook ID: 114416302
 *    Recitation: 30
 * 
 * 
 * */
import java.util.Scanner;
public class Analyzer {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the elevator simulator");
		
		//check first value
		System.out.println("Please enter the probability of arrival for Requests: ");
		double prob = scan.nextDouble();
		while (prob < 0 | prob >1) {
			System.out.println("probability must be between (or equal to) 0 and 1, try again. ");
			prob = scan.nextDouble();
		}
		System.out.println("prob: " + prob);
		System.out.println();
		
		//check second value
		System.out.println("Please enter the number of floors: ");
		int num = scan.nextInt();
		while (num <= 1) {
			System.out.println("number of floors must be greater than 1, try again. ");
			num = scan.nextInt();
		}
		System.out.println("number of floors: " + num);
		System.out.println();
			
		// check third value
		System.out.println("Please enter the number of elevators: ");
		int elev = scan.nextInt();
		while(elev <= 0) {
			System.out.println("number of elevators must be greater tha  0, try again. ");
			elev = scan.nextInt();
		}
		System.out.println("number of elevators: " + elev);
		System.out.println();
		
		//check fourth value
		System.out.println("Please enter the length of the simulation (in time units)");
		int length = scan.nextInt();
		while(length <= 0) {
			System.out.println("Simulation length must be grater than 0, try again. ");
			length = scan.nextInt();
		}
		System.out.println("length of simulation: " + length);
		System.out.println();
		
		// create Simulator object and run simulation
		Simulator s = new Simulator();
		s.simulate(prob, num, elev, length);

	}

}
