package p2;

import java.util.LinkedList;
import java.util.Queue;
/**
 * @author Deepthi
 *
 */
/**
 * A Machine is used to make a particular Food.  Each Machine makes
 * just one kind of Food.  Each machine has a capacity: it can make
 * that many food items in parallel; if the machine is asked to
 * produce a food item beyond its capacity, the requester blocks.
 * Each food item takes at least item.cookTimeMS milliseconds to
 * produce.
 */

public class Machine {
	public final String machineName;
	public final Food machineFoodType;
	int capacity;
	Queue<Food> foodList;

	//YOUR CODE GOES HERE...


	/**
	 * The constructor takes at least the name of the machine,
	 * the Food item it makes, and its capacity.  You may extend
	 * it with other arguments, if you wish.  Notice that the
	 * constructor currently does nothing with the capacity; you
	 * must add code to make use of this field (and do whatever
	 * initialization etc. you need).
	 */
	public Machine(String nameIn, Food foodIn, int capacityIn) {
		this.machineName = nameIn;
		this.machineFoodType = foodIn;
		this.capacity = capacityIn;
		
		//YOUR CODE GOES HERE...
		this.foodList = new LinkedList<Food>();


	}
	

	

	/**
	 * This method is called by a Cook in order to make the Machine's
	 * food item.  You can extend this method however you like, e.g.,
	 * you can have it take extra parameters or return something other
	 * than Object.  It should block if the machine is currently at full
	 * capacity.  If not, the method should return, so the Cook making
	 * the call can proceed.  You will need to implement some means to
	 * notify the calling Cook when the food item is finished.
	 */
	public void makeFood(Cook name, int orderNum, Customer customer) throws InterruptedException {
		//YOUR CODE GOES HERE...

		foodList.add(machineFoodType);
		Thread curr = new Thread(new CookAnItem(name, orderNum,customer));
		curr.start();
	}

	//THIS MIGHT BE A USEFUL METHOD TO HAVE AND USE BUT IS JUST ONE IDEA
	private class CookAnItem implements Runnable {
		Cook currCook;
		int orderNum;
		Customer customer;
		public CookAnItem(Cook currCook, int orderNum, Customer customer){
			this.currCook = currCook;
			this.orderNum = orderNum;
			this.customer = customer;
		}
	
		public void run() {
			try {
				//YOUR CODE GOES HERE...	
					Simulation.logEvent(SimulationEvent.machineCookingFood(Machine.this, machineFoodType));
					Thread.sleep(machineFoodType.cookTimeMS);
					Simulation.logEvent(SimulationEvent.machineDoneFood(Machine.this, machineFoodType));
					Simulation.logEvent(SimulationEvent.cookFinishedFood(currCook, machineFoodType,orderNum));
					synchronized(foodList){
						foodList.remove();
						foodList.notifyAll();	
					}
					synchronized(currCook.finishedFood){
						currCook.finishedFood.add(machineFoodType);
						currCook.finishedFood.notifyAll();	
						//customer.orderReadylatch.countDown();
					}
				
				
			} catch(InterruptedException e) { }
		}
	}
 

	@Override
	public int hashCode() {
		int result = 0; 

		result = 31*result + (machineName !=null ? machineName.hashCode() : 0); 
 
		return result;

	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true; 
		if(obj == null || (this.getClass() != obj.getClass())){ return false; } 
		Machine machine = (Machine) obj; 
		return  (this.machineName != null && (machine.machineName).equals(this.machineName));

	}




	public String toString() {
		return machineName;
	}
}