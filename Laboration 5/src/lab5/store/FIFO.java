package lab5.store;
import java.util.NoSuchElementException;
import java.util.ArrayList;

public class FIFO{

	private ArrayList<Customer> FIFOQueue = new ArrayList<Customer>();
	private int max = 0;
	
	public void add(Customer customer) {
		FIFOQueue.add(customer);
		
		if(FIFOQueue.size() > max) {
			max = FIFOQueue.size();
		}
	}

	public Object first() throws NoSuchElementException {
		if(FIFOQueue.size() == 0) {
			throw new NoSuchElementException();
		}
		
		return FIFOQueue.get(0);
	}

	public boolean isEmpty() {
		if(FIFOQueue.size() == 0) {
			return true;
		}
		return false;
	}

	public int maxSize() {
		return max;
	}

	public void removeFirst() throws NoSuchElementException {
		if(FIFOQueue.size() == 0) {
			throw new NoSuchElementException();
		}
		FIFOQueue.remove(0);
	}

	public int size() {
		return FIFOQueue.size();
	}
	
	public String toString() {
		String s = "Queue: ";
		
		for(Object elem: FIFOQueue) {
			s = s + "(" + String.valueOf(elem) + ") ";
		}
		
		return s;
	}
	
}
