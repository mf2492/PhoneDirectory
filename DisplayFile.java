import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.*;
/** 
 * Demonstrates the use of a file chooser and a text area.
 * @author Author: Lewis/Loftus  Modified by: Michelle Fernandez (mf2492)
 * 
**/
public class DisplayFile extends JPanel
{
	private JButton selectA, selectD, insertA, insertD, searchButton;
	private JLabel sort, search, resultLabel;
	private JPanel primary;
	private JComboBox searchSelect;
	String target;
	Boolean linear;
	Contact[] info = {};
	Contact test, found;
	JTextArea ta = new JTextArea (20, 30);
	JScrollPane scroll = new JScrollPane(ta);
	JTextField input = new JTextField(15);
	String[] searchMethods = {"Make A Selection...", "Binary Search",
	"Linear Search"};


/**
 * Opens a file chooser dialog, reads the selected file and
 * loads it into a text area. Constructs the GUI for the program
 * @throws FileNotFoundException
 */
	public DisplayFile() throws FileNotFoundException 
	{
		JFileChooser chooser = new JFileChooser();
		int status = chooser.showOpenDialog (null);
		if (status != JFileChooser.APPROVE_OPTION)
			ta.setText ("No File Chosen");
		else
		{
			File file = chooser.getSelectedFile();
			info = PhoneList.list(file);

			selectA = new JButton("Selection Sort Ascending");
			selectA.setVerticalTextPosition(AbstractButton.CENTER);
			selectA.setHorizontalTextPosition(AbstractButton.LEADING);
			selectA.setMnemonic(KeyEvent.VK_A);
			selectA.setActionCommand("selectA");
			selectA.addActionListener(new SortListener());

			selectD = new JButton("Selection Sort Descending");
			selectD.setVerticalTextPosition(AbstractButton.CENTER);
			selectD.setHorizontalTextPosition(AbstractButton.LEADING);
			selectD.setMnemonic(KeyEvent.VK_D);
			selectD.setActionCommand("selectD");
			selectD.addActionListener(new SortListener());

			insertA = new JButton("Insertion Sort Ascending");
			insertA.setVerticalTextPosition(AbstractButton.CENTER);
			insertA.setHorizontalTextPosition(AbstractButton.LEADING);
			insertA.setMnemonic(KeyEvent.VK_I);
			insertA.setActionCommand("insertA");
			insertA.addActionListener(new SortListener());

			insertD = new JButton("Insertion Sort Descending");
			insertD.setVerticalTextPosition(AbstractButton.CENTER);
			insertD.setHorizontalTextPosition(AbstractButton.LEADING);
			insertD.setMnemonic(KeyEvent.VK_I);
			insertD.setActionCommand("insertD");
			insertD.addActionListener(new SortListener());			

			searchSelect = new JComboBox(searchMethods);
			searchSelect.setPreferredSize (new Dimension(150, 50));
			searchButton = new JButton("Search");
			searchButton.addActionListener (new InputListener());
			searchButton.setVerticalTextPosition(AbstractButton.CENTER);
			searchButton.setHorizontalTextPosition(AbstractButton.LEADING);
			searchSelect.addActionListener(new ComboListener());

			input.addActionListener (new InputListener());
			JLabel direction = new JLabel();
			direction.setText("Enter first and last name: ");

			JPanel searchPanel = new JPanel();
			searchPanel.setPreferredSize (new Dimension(200, 400));
			searchPanel.setBackground (Color.white);
			search = new JLabel();
			search.setText("Search Listing");

			searchPanel.add(search);
			searchPanel.add(searchSelect);
			searchPanel.add(direction);
			searchPanel.add(input);
			searchPanel.add(searchButton);

			JPanel b1 = new JPanel();
			b1.setPreferredSize (new Dimension(200, 400));
			b1.setBackground (Color.white);
			sort = new JLabel();
			sort.setText("Sorting Options");
			b1.add(sort);
			b1.add(selectA);
			b1.add(selectD);
			b1.add(insertA);
			b1.add(insertD);
			b1.add(searchPanel);

			JPanel results = new JPanel();
			results.setPreferredSize (new Dimension(400, 100));
			results.setBackground (Color.white);
			resultLabel = new JLabel();
			resultLabel.setPreferredSize(new Dimension(300,50));
			resultLabel.setText("Matches: ");
			results.add(resultLabel);

			JPanel list = new JPanel();
			list.setPreferredSize (new Dimension(400, 400));
			list.setBackground (Color.white);
			list.add(scroll);
			list.add(results);

			primary = new JPanel();
			primary.setBackground (Color.gray);
			primary.add(b1);
			primary.add (list);
			add (primary);
		}
	}

	private class ComboListener implements ActionListener {
		/**
		 * Listener for the JComboBox
		 */
		public void actionPerformed (ActionEvent event)
		{
			if (searchSelect.getSelectedIndex() == 1) {
				linear = true;
			} else if (searchSelect.getSelectedIndex() == 2) {
				linear = false;
			}
		}
	}


	private class InputListener implements ActionListener {
		/**
		 * Listener for the search text field.
		 */
		public void actionPerformed (ActionEvent event)
		{
			target = input.getText().toString();
			String first = target.substring(0, target.indexOf(' '));
			first = first.substring(0,1).toUpperCase()+first.substring(1).toLowerCase();
			String last = target.substring(first.length()+ 1);
			last = last.substring(0,1).toUpperCase()+last.substring(1).toLowerCase();

			test = new Contact (first, last, "");
			if (linear) {
				found = (Contact)Searching.linearSearch(info, test);
				if (found != null)
					resultLabel.setText("Found: " + found);
				else 
					resultLabel.setText("The contact was not found.");
			} else {
				found = (Contact)Searching.binarySearch(info, test);
				if (found != null)
					resultLabel.setText("Found: " + found);
				else 
					resultLabel.setText("The contact was not found.");
			}
		}
	}

	public class SortListener  implements ActionListener{
		/**
		 * Listener for  the JButtons used for sorting options.
		 */
		public void actionPerformed(ActionEvent e) {
			if ("selectA".equals(e.getActionCommand())) {
				selectD.setEnabled(false);
				insertA.setEnabled(false);
				insertD.setEnabled(false);
				long startTime = System.nanoTime();
				Sorting.selectionSort(info, true);
				long estimatedTime = System.nanoTime() - startTime;
				System.out.println("Time: " + estimatedTime + " nanoseconds");
				DisplayFile.this.toString(info);
				
			} else if ("selectD".equals(e.getActionCommand())) {
				selectA.setEnabled(false);
				insertA.setEnabled(false);
				insertD.setEnabled(false);
				long startTime = System.nanoTime();
				Sorting.selectionSort(info, false);
				long estimatedTime = System.nanoTime() - startTime;
				System.out.println("Time: " + estimatedTime + " nanoseconds");
				DisplayFile.this.toString(info);
				
			} else if ("insertA".equals(e.getActionCommand())) {
				selectA.setEnabled(false);
				selectD.setEnabled(false);
				insertD.setEnabled(false);
				long startTime = System.nanoTime();
				Sorting.insertionSort(info, true);
				long estimatedTime = System.nanoTime() - startTime;
				System.out.println("Time: " + estimatedTime + " nanoseconds");
				DisplayFile.this.toString(info);
				
			} else {
				selectA.setEnabled(false);
				selectD.setEnabled(false);
				insertA.setEnabled(false);
				long startTime = System.nanoTime();
				Sorting.insertionSort(info, false);
				long estimatedTime = System.nanoTime() - startTime;
				System.out.println("Time: " + estimatedTime + " nanoseconds");
				DisplayFile.this.toString(info);
			}
		} 
	}

	/**
	 * Takes the String text from the read-in file and implements
	 * it into a format that can be used by the JTextArea.
	 * @param info
	 */
	public void toString(Contact[] info) {
		StringBuilder builder = new StringBuilder();
		for (int i=0; i<info.length; i++) {
			builder.append(info[i]);
			builder.append("\n");
		}
		ta.setText(builder.toString());	
	}

}