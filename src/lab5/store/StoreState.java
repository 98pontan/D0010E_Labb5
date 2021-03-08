package lab5.store;

import lab5.sim.Event;
import lab5.sim.SimState;

import java.util.ArrayList;

public class StoreState extends SimState {
	int checkOuts;
	int maxCheckouts;
	int maxCustomersToday;
	int missedCustomers;
	int purchases;
	int turnedAwayCustomers;
	int availableCheckouts;
	int totQueueTime;
	int emptyCheckoutTime;
	int occupideCheckouts;
	final int MAXCUSTOMERS;
	boolean isOpen = false;

	private Time timeFactory;
	private CreateCustomer customerFactory = new CreateCustomer();
	private ArrayList<Customer> customerList;
	private FIFO checkoutQueue;

	public StoreState(
		long SEED,
		int CHECKOUTS,
		int MAX_CUSTOMERS,
		double ARRIVAL_SPEED,
		double lowerGather, double upperGather,
		double lowerCheckout, double upperCheckout
	) {
		super();
		MAXCUSTOMERS = MAX_CUSTOMERS;
		checkOuts = CHECKOUTS;
		availableCheckouts = CHECKOUTS;
		timeFactory = new Time(this, SEED, lowerCheckout, upperCheckout, lowerGather, upperGather, ARRIVAL_SPEED);
		customerList = new ArrayList<>();
		checkoutQueue = new FIFO();
	}
	
	
	/**
	 * checks if a checkout is available 
	 * @return true if available false if occupied
	 */
	public boolean checkAvailableCheckout()
	{
		if(availableCheckouts > 0) 
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * If a checkout is being occupide by a customer
	 */
	void occupideCheckout() 
	{
		if(availableCheckouts > 0) 
		{
			availableCheckouts--;
			occupideCheckouts++;
			//time
		}
	
	}
	
	/**
	 * Makes a checkout available after a customer has used it. 
	 */
	public void emptyCheckout()
	{
		if(availableCheckouts + 1 <= checkOuts)
		{
			availableCheckouts++;
			
			if(occupideCheckouts - 1 >= 0)
				occupideCheckouts--;
			//time
		}
	}
	
	
	/**
	 * Opens checkouts
	 * @param n, number of checkouts to open
	 */
	void openCheckout(int n) 
	{
		checkOuts += n;
		
		if(checkOuts > maxCheckouts)
			maxCheckouts = checkOuts;
			
	}
	
	/**
	 * Closes checkouts so long its positive
	 * @param n, number of checkout to close
	 */
	public void closeCheckouts(int n)
	{
		if(n - checkOuts >= 0) 
			checkOuts -= n;
	}
	
	/**
	 * Increases the number of missed customers if the number of customers is over the max number of customers. 
	 * @param
	 */
	public void missedCustomers ()
	{
		if(isFull())
			missedCustomers++;
	}
	
	
	/**
	 * @return number of customers in the store
	 */
	int getCustomers() 
	{
		return customerList.size();
	}
	
	/**
	 * @return number of open checkouts
	 */
	int getcheckOuts() 
	{
		return checkOuts;
	}
	
	
	/**
	 * @return number of available checkouts
	 */
	int getAvailableCheckouts() 
	{
		return availableCheckouts;
	}
	
	/**
	 * @return number of occupied checkouts
	 */
	int getOccupideCheckouts() 
	{
		return occupideCheckouts;
	}
	
	/**
	 * @return number of customers visiting the store 
	 */
	int getMaxCustomersToday()
	{
		return maxCustomersToday;
	}
	
	/**
	 * @return number of customers missed due to a full store
	 */
	int getMissedCustomers() 
	{
		return missedCustomers;
	}
	
	/**
	 * @return the total time of queuing
	 */
	double gettotQueueTime()
	{
		return totQueueTime;
	}

	public boolean isFull() {
		return MAXCUSTOMERS == customerList.size();
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void toggleIsOpen() {
		isOpen = !isOpen;
	}

	// Kanske borde flyttas in i customerFactory?
	public void addCustomer(Customer c) {
		customerList.add(c);
	};

	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public Customer createCustomer(CustomerState cState) {
		Customer c = customerFactory.createCustomer();
		c.setState(cState);
		addCustomer(c);
		return c;
	}

	public Time getTimeFactory() {
		return timeFactory;
	}

	public void turnedAwayCustomer() {
		turnedAwayCustomers++;
	}

	public int getTurnedAwayCustomer() {
		return turnedAwayCustomers;
	}

	public FIFO getCheckoutQueue() {
		return checkoutQueue;
	}

	public void updatePurchaseCount() {
		purchases++;
	}
}
