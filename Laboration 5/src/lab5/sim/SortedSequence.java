package lab5.sim;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Sorts the eventQueue with lowest time first. 
 * @author Pontus Eriksson Jirbratt
 *
 */
public class SortedSequence 
{
	/*
	public static void main(String[] args)
	{
		ArrayList<Event> a = new ArrayList<>(Arrays.asList());
		ArrayList<Event> list;
		for(int i = 0;i < 4; i ++) {
			a.add(i, new Event());
		}
		SortedSequence ss = new SortedSequence();
		
		ss.printArray(a);
		
	}
	*/
	
	/**
	 * sorts the ArrayList with bubblesort and returns the sorted list
	 * @param list
	 * @return a sorted list in order of time. 
	 */
	ArrayList<Event> sortList(ArrayList<Event> list)
	{
		int length = list.size();
		
		for(int i = 0; i < length - 2; i++)
		{
			for(int j = 0; j < length - i - 2; j++)
			{
				if(list.get(j).getTime() > list.get(j + 1).getTime()) {
					Event temp;
					temp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, temp);
					
				}//end if
			}//end for j
		}//end for i
		
		/*for(int i = 0; i < list.size(); i++) {
			System.out.println("list: " + list.get(i).time);
			System.out.println("a: " + list.get(i).time);
		}
		*/
		
		return list;
	}
/*	
	void printArray(ArrayList<Event> unsorted) 
	{
		ArrayList<Event> list = sortList(unsorted);
		
		for(int i = 0; i < list.size(); i++) 
		{
			System.out.println("list: " + list.get(i).time);
		}
	}
	*/

}