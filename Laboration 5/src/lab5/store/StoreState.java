package lab5.store;
import java.util.ArrayList;

import lab5.sim.SimState;

public class StoreState extends SimState {
	private ArrayList<Customer> customers;
	private CreateCustomer customerFactory;
	private Time timeFactory;
	
	int checkOuts;
	int maxCheckouts;
	int maxCustomersToday;
	int missedCustomers;
	int availableCheckouts;
	int totQueueTime;
	int emptyCheckoutTime;
	int occupiedCheckouts;
	final int MAXCUSTOMERS;
    int registers;
    int max_customers;
	
	public StoreState(long seed,
          int registers,
          int max_customers,
          double arrival_speed,
          double lowerGather, double upperGather,
          double lowerRegister, double upperRegister)
	{
		MAXCUSTOMERS = max_customers;
		checkOuts = registers;
//		availableCheckouts = openCheckout;
        timeFactory = new Time(this, seed, lowerRegister, upperRegister, lowerGather, upperGather, arrival_speed);
	}
	
	
	/**
	 * checks if a checkout is available 
	 * @return true if available false if occupied
	 */
	public boolean checkAvailbleCheckout() 
	{
		if(availableCheckouts > 0) 
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * Makes a checkout to be occupied by a customer
	 */
	public void occupiedCheckout() 
	{
		if(availableCheckouts > 0) 
		{
			availableCheckouts--;
			occupiedCheckouts++;
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
			
			if(occupiedCheckouts - 1 >= 0)
				occupiedCheckouts--;
			//time
		}
	}
	
	/**
	 * Opens checkouts
	 * @param n, number of checkouts to open
	 */
	public void openCheckout(int n) 
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
		if(customers.size() + 1 > MAXCUSTOMERS)
			missedCustomers++;
	}
	
	/**
	 * @return number of customers in the store
	 */
	public int getCustomersInStore() 
	{
		int customersInStore = 0;
		for(int index = 0; index < customers.size(); index++)
		{
			if(customers.get(index).getState() == CustomerState.IN_STORE)
			{
				customersInStore += 1;
			}
		}
		return customersInStore;
	}
	
	/**
	 * @return number of open checkouts
	 */
	public int getcheckOuts() 
	{
		return checkOuts;
	}
	
	
	/**
	 * @return number of available checkouts
	 */
	public int getAvailableCheckouts() 
	{
		return availableCheckouts;
	}
	
	/**
	 * @return number of occupied checkouts
	 */
	public int getOccupiedCheckouts() 
	{
		return occupiedCheckouts;
	}
	
	/**
	 * @return number of customers visiting the store 
	 */
	public int getMaxCustomersToday()
	{
		return maxCustomersToday;
	}
	
	/**
	 * @return number of customers missed due to a full store
	 */
	public int getMissedCustomers() 
	{
		return missedCustomers;
	}
	
	/**
	 * @return the total time of queuing
	 */
	public double gettotQueueTime()
	{
		return totQueueTime;
	}
	
	public void addCustomer(Customer customer)
	{
		if(!runFlag)
		{
			customer.setState(CustomerState.LATE_CUSTOMER);
		}
		else if(getCustomersInStore() < MAXCUSTOMERS)
		{
			customer.setState(CustomerState.IN_STORE);
		}else
		{
			customer.setState(CustomerState.TURNED_AWAY);
		}
		customers.add(customer);
	}
	
	/**
	 * Creates an new customer.
	 * @return new customer.
	 */
	public Customer createCustomer()
	{
		Customer customer = customerFactory.createCustomer();
		return customer;
	}
	
	public Time getTimeFactory()
	{
		return timeFactory;
	}

}
