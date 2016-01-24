package p2;

import java.util.LinkedList;
import java.util.List;


/**
 * Cooks are simulation actors that have at least one field, a name.
 * When running, a cook attempts to retrieve outstanding orders placed
 * by Eaters and process them.
 */
public class Cook implements Runnable {
	private final String name;
	private Customer currCustomer;
	public List<Food> finishedFood = new LinkedList<Food>();

	/**
	 * You can feel free modify this constructor.  It must
	 * take at least the name, but may take other parameters
	 * if you would find adding them useful. 
	 *
	 * @param: the name of the cook
	 */
	public Cook(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

	/**
	 * This method executes as follows.  The cook tries to retrieve
	 * orders placed by Customers.  For each order, a List<Food>, the
	 * cook submits each Food item in the List to an appropriate
	 * Machine, by calling makeFood().  Once all machines have
	 * produced the desired Food, the order is complete, and the Customer
	 * is notified.  The cook can then go to process the next order.
	 * If during its execution the cook is interrupted (i.e., some
	 * other thread calls the interrupt() method on it, which could
	 * raise InterruptedException if the cook is blocking), then it
	 * terminates.
	 */
	public void run() {

		Simulation.logEvent(SimulationEvent.cookStarting(this));
		try {
			while(true) {

				//YOUR CODE GOES HERE...

				//get the customer currently up next
			

				
					currCustomer = Simulation.customerOrderQueue.take();
					Simulation.logEvent(SimulationEvent.cookReceivedOrder(this, currCustomer.getOrder(), currCustomer.getOrderNum()));
			
				//sends food to specific machine
				for(int index = 0; index < currCustomer.getOrder().size(); index++){
					Food currFood = currCustomer.getOrder().get(index);
					if(currFood.equals(FoodType.burger)){
						synchronized(Simulation.grill.foodList){
							while(!(Simulation.grill.foodList.size() < Simulation.grill.capacity)){
								Simulation.grill.foodList.wait();
							}
							Simulation.logEvent(SimulationEvent.cookStartedFood(this, FoodType.burger , currCustomer.getOrderNum()));
							Simulation.grill.makeFood(this, currCustomer.getOrderNum(),currCustomer);
							Simulation.grill.foodList.notifyAll();

						}
						
					}else if(currFood.equals(FoodType.fries)){
						synchronized(Simulation.fryer.foodList){
							while(!(Simulation.fryer.foodList.size() < Simulation.fryer.capacity)){
								Simulation.fryer.foodList.wait();
							}
							Simulation.logEvent(SimulationEvent.cookStartedFood(this, FoodType.fries , currCustomer.getOrderNum()));
							Simulation.fryer.makeFood(this,currCustomer.getOrderNum(),currCustomer);
							Simulation.fryer.foodList.notifyAll();
							
						}
						
					}else{
						synchronized(Simulation.coffeeMaker2000.foodList){
							while(!(Simulation.coffeeMaker2000.foodList.size() < Simulation.coffeeMaker2000.capacity)){
								Simulation.coffeeMaker2000.foodList.wait();
							}
							Simulation.logEvent(SimulationEvent.cookStartedFood(this, FoodType.coffee , currCustomer.getOrderNum()));
							Simulation.coffeeMaker2000.makeFood(this,currCustomer.getOrderNum(),currCustomer);
							Simulation.coffeeMaker2000.foodList.notifyAll();
							
						}
					}
				}
				synchronized(finishedFood){
					while(!(finishedFood.size() == currCustomer.getOrder().size())){
						finishedFood.wait();
						finishedFood.notifyAll();
					}
				}
				Simulation.logEvent(SimulationEvent.cookCompletedOrder(this, currCustomer.getOrderNum()));
				
//				synchronized(Simulation.completedOrder){
//					Simulation.completedOrder.put(currCustomer, true);
//					Simulation.completedOrder.notifyAll();
//				}
				finishedFood = new LinkedList<Food>();
			
			
				
			}
		}
		catch(InterruptedException e) {
			// This code assumes the provided code in the Simulation class
			// that interrupts each cook thread when all customers are done.
			// You might need to change this if you change how things are
			// done in the Simulation class.
			Simulation.logEvent(SimulationEvent.cookEnding(this));
		}
	}
}