package lab5.store;

/**
 * This class represents a customer with ID.
 *
 * @author Pontus Eriksson Jirbratt,
 * @author Lucas Pettersson,
 * @author Jesper Johansson Oskarsson,
 * @author Markus Blomqvist
 */
public class Customer {
	private final int ID;

	/**
	 * This constructor creates a customer with an ID.
	 */
	public Customer(int number) {
		this.ID = number;
	}

	/**
	 * @return a string of the ID of the customer.
	 */
	public String toString() {
		return String.valueOf(ID);
	}
}