/**
 * @author Author: Lewis/Loftus
 *Represents a phone contact.
 */
public class Contact implements Comparable
{
	private String firstName, lastName, phone;
	/**
	 * Constructor: Sets up this contact with the specified data.
	 * @param first
	 * @param last
	 * @param telephone
	 */
	public Contact (String first, String last, String telephone)
	{
		firstName = first;
		lastName = last;
		phone = telephone;
	}

	/**
	 * Returns a description of this contact as a string.
	 */
	public String toString ()
	{
		return lastName + ", " + firstName + "\t" + phone;
	}

	/**
	 * Returns true if the first and last names of this contact match
	 * those of the parameter.
	 */
	public boolean equals (Object other)
	{
		return (lastName.equals(((Contact)other).getLastName()) &&
				firstName.equals(((Contact)other).getFirstName()));
	}

	/**
	 * Uses both last and first names to determine ordering.
	 */
	public int compareTo (Object other)
	{
		int result;
		String otherFirst = ((Contact)other).getFirstName();
		String otherLast = ((Contact)other).getLastName();
		if (lastName.equals(otherLast))
			result = firstName.compareTo(otherFirst);
		else
			result = lastName.compareTo(otherLast);
		return result;
	}

	/**
	 * First name accessor.
	 * @return firstName
	 */
	public String getFirstName ()
	{
		return firstName;
	}

	/**
	 * Last name accessor
	 * @return lastName
	 */
	public String getLastName ()
	{
		return lastName;
	}
}