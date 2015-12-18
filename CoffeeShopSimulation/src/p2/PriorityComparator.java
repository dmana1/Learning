package p2;

import java.util.Comparator;
/**
 * @author Deepthi
 *
 */

public class PriorityComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2) {
		// TODO Auto-generated method stub
		if (o1.getPriority() > o2.getPriority()) {
			return -1;
		} else if (o1.getPriority() < o2.getPriority()) {
			return 1;
		}
		return 0;
	}

}
