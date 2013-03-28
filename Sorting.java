/**
 * Demonstrates the selection sort and insertion sort algorithms.
 * @author Lewis/Loftus Modified by: Michelle Fernandez (mf2492)
 *
 */
public class Sorting
{
	/**
	 * Sorts the specified array of objects using the selection
	 * sort algorithm.
	 * @param list
	 * @param ascend
	 */
	public static void selectionSort (Comparable[] list, Boolean ascend)
	{
		int min;
		Comparable temp;
		for (int index = 0; index < list.length-1; index++)
		{
			min = index;
			for (int scan = index+1; scan < list.length; scan++)
				if (ascend) {
					if (list[scan].compareTo(list[min]) < 0)
						min = scan;
				} else {
					if (list[scan].compareTo(list[min]) > 0)
						min = scan;
				}
			// Swap the values
			temp = list[min];
			list[min] = list[index];
			list[index] = temp;
		}
	}
	

	/**
	 *  Sorts the specified array of objects using the insertion
	 *  sort algorithm.
	 * @param list
	 * @param ascend
	 */
	public static void insertionSort (Comparable[] list, Boolean ascend)
	{
		for (int index = 1; index < list.length; index++)
		{
			Comparable key = list[index];
			int position = index;
			//Shift larger values to the right
			if (ascend) {
				while (position > 0 && key.compareTo(list[position-1]) < 0)
				{
					list[position] = list[position-1];
					position--;
				}
			} else {
				while (position > 0 && key.compareTo(list[position-1]) > 0)
				{
					list[position] = list[position-1];
					position--;
				}
			}
			list[position] = key;
		}
	}
}