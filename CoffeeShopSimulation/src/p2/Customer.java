package p2;

import java.util.List;
import java.util.concurrent.CountDownLatch;
/**
 * @author Deepthi
 *
 */
/**
 * Customers are simulation actors that have two fields: a name, and a list
 * of Food items that constitute the Customer's order.  When running, an
 * customer attempts to enter the coffee shop (only successful if the
 * coffee shop has a free table), place its order, and then leave the 
 * coffee shop when the order is complete.
 */
public class Customer implements Runnable {
	//JUST ONE SET OF IDEAS ON HOW TO SET THINGS UP...
	private final String name;
	private final List<Food> order;
	private final int orderNum;    
	private final int priority;
	public CountDownLatch orderReadylatch;//latch to check when all the items in the order is done.
	
	private static int runningCounter = 0;

	/**
	 * You can feel free modify this constructor.  It must take at
	 * least the name and order but may take other parameters if you
	 * would find adding them useful.
	 */
	public Customer(String name, List<Food> order, int priority) {
		this.name = name;
		this.order = order;
		this.priority = priority;
		this.orderNum = runningCounter++;
		orderReadylatch = new CountDownLatch(order.size());
	}

	public String toString() {
		return name;
	}

	/** 
	 * This method defines what an Customer does: The customer attempts to
	 * enter the coffee shop (only successful when the coffee shop has a
	 * free table), place its order, and then leave the coffee shop
	 * when the order is complete.
	 */
	public void run() {
		//YOUR CODE GOES HERE...
		//****Before entering coffeeshoop
        Simulation.logEvent(SimulationEvent.customerStarting(this));
		try {
			Simulation.customersEntered.put(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Customer thread interrupted while waiting for free table");
		}
		//*****After entering the coffee shop
        Simulation.logEvent(SimulationEvent.customerEnteredCoffeeShop(this));
        //Place the Order
        try {
			Simulation.customerOrderQueue.put(this);
		} catch (InterruptedException e1) {
			System.out.println("Customer thread interrupted while placing the order");
		}
        //******After placing order
        Simulation.logEvent(SimulationEvent.customerPlacedOrder(this, this.order, this.orderNum));

        //Check whether order is complete.
        try{
        this.orderReadylatch.await();
        //****After receiving order
        Simulation.logEvent(SimulationEvent.customerReceivedOrder(this, this.order, this.orderNum));
        }catch (InterruptedException e) {
			System.out.println("Customer thread interrupted while waiting for order completion");
		}

		//*****Just before about to leave the coffeshop.
        Simulation.logEvent(SimulationEvent.customerLeavingCoffeeShop(this));
        Simulation.customersEntered.remove(this);
		
	}

	public String getName() {
		return name;
	}

	public List<Food> getOrder() {
		return order;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public int getPriority() {
		return priority;
	}

	public static int getRunningCounter() {
		return runningCounter;
	}

	public CountDownLatch getOrderReadylatch() {
		return orderReadylatch;
	}

	
}