import java.io.FileNotFoundException;
import javax.swing.*;
/**
 * This program accesses a text file containing a list of names and 
 * phone numbers. The user can sort the list alphabetically and 
 * search through the directory for a listing.  
 * @author Author: Michelle Fernandez (mf2492)
 */
public class Tester extends JFrame
{
	public static void main(String[] args) throws FileNotFoundException {
		
		JFrame frame = new JFrame ("Contact List");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new DisplayFile());	
		frame.pack();
		frame.setVisible(true);
	}
}
		




	