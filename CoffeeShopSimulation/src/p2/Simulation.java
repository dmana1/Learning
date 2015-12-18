package p2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
/**
 * @author Deepthi
 *
 */
/**
 * Simulation is the main class used to run the simulation.  You may
 * add any fields (static or instance) or any methods you wish.
 */ 

public class Simulation {
 
	// List to track simulation events during simulation
	public static List<SimulationEvent> events;  
	//Queue to hold the customers who entered the coffeeshop
	public static BlockingQueue<Customer> customersEntered;
	//Queue to hold orders(As orders are encapsulated in customer.java, using the customer object only)
	public static BlockingQueue<Customer> customerOrderQueue;
	// Comparator used to compare the orders based on priority of customers
	public static PriorityComparator priorityComparator;
	//Map that hold machines
	public static HashMap<String,Machine> machinesMap;
	public static Map<Customer, Boolean> completedOrder = new HashMap<Customer,Boolean>();

	
	public static Machine grill;
	public static Machine fryer;
	public static Machine coffeeMaker2000;


	/**
	 * Used by other classes in the simulation to log events
	 * @param event
	 */
	public static void logEvent(SimulationEvent event) {
		events.add(event);
		System.out.println(event);
	}

	/**
	 * 	Function responsible for performing the simulation. Returns a List of 
	 *  SimulationEvent objects, constructed any way you see fit. This List will
	 *  be validated by a call to Validate.validateSimulation. This method is
	 *  called from Simulation.main(). We should be able to test your code by 
	 *  only calling runSimulation.
	 *  
	 *  Parameters:
	 *	@param numCustomers the number of customers wanting to enter the coffee shop
	 *	@param numCooks the number of cooks in the simulation
	 *	@param numTables the number of tables in the coffe shop (i.e. coffee shop capacity)
	 *	@param machineCapacity the capacity of all machines in the coffee shop
	 *  @param randomOrders a flag say whether or not to give each customer a random order
	 *
	 */
	public static List<SimulationEvent> runSimulation(
			int numCustomers, int numCooks,
			int numTables, 
			int machineCapacity,
			boolean randomOrders
			) {

		//This method's signature MUST NOT CHANGE.  
		//Preconditions verification
		if(numCustomers < 0 || numCooks < 0 || numTables < 0 || machineCapacity < 0){
			System.out.println("Invalid Simulation Parameters, Ending the Simulation.");
			logEvent(SimulationEvent.endSimulation());
			return events;
		}


		//We are providing this events list object for you.  
		//  It is the ONLY PLACE where a concurrent collection object is 
		//  allowed to be used.
		events = Collections.synchronizedList(new ArrayList<SimulationEvent>());
		priorityComparator = new PriorityComparator();
		customersEntered =  new LinkedBlockingQueue<Customer>(numTables);
		customerOrderQueue = new PriorityBlockingQueue<Customer>(numTables,priorityComparator);


		// Start the simulation
		logEvent(SimulationEvent.startSimulation(numCustomers,
				numCooks,
				numTables,
				machineCapacity));


		// Set things up you might need
       machinesMap = new HashMap<String, Machine>();
      

		// Start up machines
		machinesMap.put(FoodType.burger.toString(), new Machine("Grill", FoodType.burger, machineCapacity));
		machinesMap.put(FoodType.fries.toString(), new Machine("Fryer", FoodType.fries, machineCapacity));
		machinesMap.put(FoodType.coffee.toString(), new Machine("CoffeeMaker2000", FoodType.coffee, machineCapacity));
		
		grill = new Machine("Grill", FoodType.burger, machineCapacity);
		fryer = new Machine("Fryer", FoodType.fries, machineCapacity);
		coffeeMaker2000 = new Machine("CoffeeMaker2000", FoodType.coffee, machineCapacity);
		
		for(Machine machine : machinesMap.values()){
			logEvent(SimulationEvent.machineStarting(machine, machine.machineFoodType, machineCapacity));
		}
		
		// Let cooks in
		  Thread[] cooks = new Thread[numCooks];
		  Cook[] cookArray = new Cook[numCooks];
		for(int i = 0; i < numCooks ; i++){
			Cook cook = new Cook("Cook" + i);
			cookArray[i] = cook;
			cooks[i] = new Thread(cook);
    		cooks[i].start();
		}


		// Build the customers.
		Thread[] customers = new Thread[numCustomers];
		LinkedList<Food> order;
		Random priRandom = new Random();
		if (!randomOrders) {
			order = new LinkedList<Food>();
			order.add(FoodType.burger);
			order.add(FoodType.fries);
			order.add(FoodType.fries);
			order.add(FoodType.coffee);
			for(int i = 0; i < customers.length; i++) {
				customers[i] = new Thread(
						new Customer("Customer " + (i), order,priRandom.nextInt(3) + 1)
				);
			}
		}
		else {
			for(int i = 0; i < customers.length; i++) {
				Random rnd = new Random(27);
				int burgerCount = rnd.nextInt(3);
				int friesCount = rnd.nextInt(3);
				int coffeeCount = rnd.nextInt(3);
				order = new LinkedList<Food>();
				for (int b = 0; b < burgerCount; b++) {
					order.add(FoodType.burger);
				}
				for (int f = 0; f < friesCount; f++) {
					order.add(FoodType.fries);
				}
				for (int c = 0; c < coffeeCount; c++) {
					order.add(FoodType.coffee);
				}
				customers[i] = new Thread(
						new Customer("Customer " + (i), order, priRandom.nextInt(3) + 1)
				);
			}
		}


		// Now "let the customers know the shop is open" by
		//    starting them running in their own thread.
		for(int i = 0; i < customers.length; i++) {
			customers[i].start();
			//NOTE: Starting the customer does NOT mean they get to go
			//      right into the shop.  There has to be a table for
			//      them.  The Customer class' run method has many jobs
			//      to do - one of these is waiting for an available
			//      table...
		}


		
			// Wait for customers to finish
			//   -- you need to add some code here...
			for(int i = 0 ; i < numCustomers ; ++i){
				try{
				customers[i].join();
				}catch(InterruptedException e){
				}
			}		
			
			// Then send cooks home...
			// The easiest way to do this might be the following, where
			// we interrupt their threads.  There are other approaches
			// though, so you can change this if you want to.
			for(int i = 0; i < cooks.length; i++){
				cooks[i].interrupt();
			}				
			for(int i = 0; i < cooks.length; i++){
				try{
				cooks[i].join();
				}catch(InterruptedException e){
				}
			}
		
		

		// Shut down machines
		
		for (Machine m : machinesMap.values()) {
             logEvent(SimulationEvent.machineEnding(m));
        }
		machinesMap = null;
		// Done with simulation		
		logEvent(SimulationEvent.endSimulation());

		return events;
	}

	/**
	 * Entry point for the simulation.
	 *
	 * @param args the command-line arguments for the simulation.  There
	 * should be exactly four arguments: the first is the number of customers,
	 * the second is the number of cooks, the third is the number of tables
	 * in the coffee shop, and the fourth is the number of items each cooking
	 * machine can make at the same time.  
	 */
	public static void main(String args[]) throws InterruptedException {
		// Parameters to the simulation
		/*
		if (args.length != 4) {
			System.err.println("usage: java Simulation <#customers> <#cooks> <#tables> <capacity> <randomorders");
			System.exit(1);
		}
		int numCustomers = new Integer(args[0]).intValue();
		int numCooks = new Integer(args[1]).intValue();
		int numTables = new Integer(args[2]).intValue();
		int machineCapacity = new Integer(args[3]).intValue();
		boolean randomOrders = new Boolean(args[4]);
		 */
		int numCustomers = 10;
		int numCooks =1;
		int numTables = 5;
		int machineCapacity = 4;
		boolean randomOrders = false;
		
//		int numCustomers = 5000;
//		int numCooks =100;
//		int numTables = 500;
//		int machineCapacity = 500;
//		boolean randomOrders = false;
		


		// Run the simulation and then 
		//   feed the result into the method to validate simulation.
		System.out.println("Did it work? " + 
				Validate.validateSimulation(
						runSimulation(
								numCustomers, numCooks, 
								numTables, machineCapacity,
								randomOrders
								)
						)
				);
	}
}



