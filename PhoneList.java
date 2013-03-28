import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Driver for testing a sorting algorithm.
 * @author Lewis/Loftus Modified by: Michelle Fernandez (mf2492)
 *
 */
public class PhoneList
{

	/**
	 * Creates an array of Contact objects, sorts them, then prints
	 * them.
	 */
	static int i = 0;

	public static Contact[] list (File file) throws FileNotFoundException
	{
		Scanner scan = new Scanner(file);
		Scanner scan2 = new Scanner(file);
		int size = 0;
		
		while (scan.hasNextLine()){
			scan.nextLine();
			size++;
		}

		Contact[] friends = new Contact[size];

		while (scan2.hasNextLine()){
			String line = scan2.nextLine();
			Scanner readLine = new Scanner(line); 
			String first = readLine.next();
			String last = readLine.next();
			String number = readLine.nextLine();
			friends[i] = new Contact (first, last, number);
			i++;
		}
		return friends;
	}
}
