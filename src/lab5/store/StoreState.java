package lab5.store;



public class StoreState {
	int customers;
	int checkOuts;
	int maxCheckouts;
	int maxCustomersToday;
	int missedCustomers;
	int availableCheckouts;
	int totQueueTime;
	int emptyCheckoutTime;
	int occupideCheckouts;
	final int MAXCUSTOMERS;
	
	
	public StoreState(int openCheckout, int maxCustomers)
	{
		MAXCUSTOMERS = maxCustomers;
		checkOuts = openCheckout;
		availableCheckouts = openCheckout;
	}
	
	
	/**
	 * checks if a checkout is available 
	 * @return true if available false if occupied
	 */
	boolean checkAvailbleCheckout() 
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
	void emptyCheckout()
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
	void closeCheckouts(int n) 
	{
		if(n - checkOuts >= 0) 
			checkOuts -= n;
	}
	
	/**
	 * Increases the number of missed customers if the number of customers is over the max number of customers. 
	 * @param
	 */
	void missedCustomers () 
	{
		if(customers + 1 > MAXCUSTOMERS)
			missedCustomers++;
	}
	
	
	/**
	 * @return number of customers in the store
	 */
	int getCustomers() 
	{
		return customers;
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

}
