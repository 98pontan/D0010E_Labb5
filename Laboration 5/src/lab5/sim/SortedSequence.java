package lab5.sim;

import java.util.ArrayList;

/**
 * Sorts the eventQueue with lowest time first.
 * 
 * @author Pontus Eriksson Jirbratt,
 * @author Lucas Pettersson,
 * @author Jesper Johansson Oskarsson,
 * @author Markus Blomqvist
 */
public class SortedSequence {
	/**
	 * sorts the ArrayList with bubblesort and returns the sorted list. ATTN!
	 * Doesn't sort the last element in list (Because it's the stop event).
	 * 
	 * @param list
	 * @return a sorted list in order of time.
	 */
	ArrayList<Event> sortList(ArrayList<Event> list) {
		int length = list.size();

		for (int i = 0; i < length - 2; i++) {
			for (int j = 0; j < length - i - 2; j++) {
				if (list.get(j).getTime() > list.get(j + 1).getTime()) {
					Event temp;
					temp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, temp);

				} // end if
			} // end for j
		} // end for i

		return list;
	}
}
