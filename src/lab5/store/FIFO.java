package lab5.store;
import java.util.NoSuchElementException;
import java.util.ArrayList;

/**
 * This is a first-in first-out class and is used for the queue of customers.
 * @author Markus Blomqvist
 */
public class FIFO{

	private ArrayList<Customer> FIFOQueue = new ArrayList<Customer>();
	private int max = 0;
	
       /**
 	* This method adds a customer to the queue.
 	*/
	public void add(Customer customer) {
		FIFOQueue.add(customer);
		
		if(FIFOQueue.size() > max) {
			max = FIFOQueue.size();
		}
	}

       /**
 	* This method returns the first customer in the queue.
 	*/
	public Customer first() throws NoSuchElementException {
		if(FIFOQueue.size() == 0) {
			throw new NoSuchElementException();
		}
		
		return FIFOQueue.get(0);
	}
	
       /**
 	* This method removes the first customer in the queue.
 	*/
	public void removeFirst() throws NoSuchElementException {
		if(FIFOQueue.size() == 0) {
			throw new NoSuchElementException();
		}
		
		FIFOQueue.remove(0);
	}
	
       /**
 	* This method returns true or false depending on
	* if the queue is empty.
 	*/
	public boolean isEmpty() {
		if(FIFOQueue.size() == 0) {
			return true;
		}
		
		return false;
	}

       /**
 	* This method returns the maximal size of the queue.
 	*/
	public int maxSize() {
		return max;
	}

       /**
 	* This method returns the current size of the queue.
 	*/
	public int size() {
		return FIFOQueue.size();
	}
	
       /**
 	* This method returns the queue as a String with
	* the Customer objects in it.
 	*/
	public String toString() {
		String s = "";
		
		for(Customer customer: FIFOQueue) {
			if(FIFOQueue.size() == 0){
				return "[" + s + "]";
			}
			
			if(FIFOQueue.size() == 1){
				return "[" + String.valueOf(customer.getID()) + "]";
			}
			
			s = s + ", " + String.valueOf(customer.getID());
		}
		
		return "[" + s + "]";
	}
	
}
