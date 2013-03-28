/**
 *  Demonstrates the linear search and binary search algorithms.
 * @author Lewis/Loftus Modified by: Michelle Fernandez (mf2492)
 *
 */
public class Searching 
{

	/**
	 * Searches the specified array of objects for the target using
	 * a linear search. Returns a reference to the target object from
	 * the array if found, and null otherwise.
	 * @param list
	 * @param target
	 * @return listing or null
	 */
	public static Comparable linearSearch (Comparable[] list,
			Comparable target)
	{
		int index = 0;
		boolean found = false;
		while (!found && index < list.length)
		{
			if (list[index].compareTo(target) == 0)
				found = true;
			else
				index++;
		}
		if (found)
			return list[index];
		else
			return null;
	}

	/**
	 * Searches the specified array of objects for the target using
	 * a binary search. Assumes the array is already sorted in
	 * ascending order when it is passed in. Returns a reference to
	 * the target object from the array if found, and null otherwise.
	 * @param list
	 * @param target
	 * @return listing or null
	 */
	public static Comparable binarySearch (Comparable[] list,
			Comparable target)
	{
		int min=0, max=list.length-1, mid=0;
		boolean found = false;

		while (!found && min <= max)
		{
			mid = (min+max) / 2;
			if (list[mid].compareTo(target) == 0)
				found = true;
			else
				if (target.compareTo(list[mid]) < 0)
					max = mid-1;
				else
					min = mid+1;
		}
		if (found)
			return list[mid];
		else
			return null;
	}
	
	
	/**
	 * Interpolation. Algorithm from wikipedia. Does not work with this program
	 * @param list
	 * @param target
	 * @return list or null
	 */
	public static Comparable interpolationSearch (Comparable[] list,
			Comparable target)
	{
		int min=0, max=list.length-1, mid=0;
		boolean found = false;

		while (!found && min <= max)
		{
	        mid = min + (max - min)/2; // low + ((toFind - sortedArray[low]) * (high - low + 1)) / (sortedArray[high] - sortedArray[low])
			
			if (list[mid].compareTo(target) == 0)
				found = true;
			else
				if (target.compareTo(list[mid]) < 0)
					max = mid-1;
				else
					min = mid+1;
		}
		if (found)
			return list[mid];
		else
			return null;
	}
}