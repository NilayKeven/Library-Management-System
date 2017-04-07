/** 
 * Abstract Person class. Library staff and the users are inherit this class.
 * It has four private datas and their methods. This class has nı information 
 * about the person who use the library because it is written for just 
 * representation.
 *
 * @author Nilay Keven
 */
import java.util.*;
public abstract class Person implements SystemUsers
{
	// Data Field

	/**
	 * ID of the person as Integer
	 */ 
	private int personID;
	/**
	 * Name of the person as String
	 */
	private String firstName;
	/**
	 * Surname of the person as string
	 */
	private String secondName;
	/**
	 * Password of the person to login the system as String
	 */
	private String password;
	
	// Methods

	/**
	 * Constructor
	 *
	 * Initialized a Person object with all properties specified.
	 * @param pName The person first name as String
	 * @param pSurname The person second name as String
	 * @param pID The person ID as Integer
	 * @param pword The person password as String
	 */
	public Person(String pName, String pSurname, int pID, String pword)
	{
		firstName = pName;
		secondName = pSurname;
		personID = pID;
		password = pword;
	}
	/**
	 * Getter of the person ID
	 *
	 * @return person ID as Integer
	 */
	public int getPersonID(){return personID;}
	/**
	 * Getter of the person firstname
	 *
	 * @return person firstname as String
	 */
	public String getFirstName(){return firstName;}
	/**
	 * Getter of the person secondname
	 *
	 * @return person secondname as String
	 */
	public String getSecondName(){return secondName;}
	/**
	 * Getter of the person password to login the library system.
	 *
	 * @return person password as String
	 */
	public String getPassword(){return password;}
	/**
	 * Abstract Method
	 * Search the book in the library system.
	 * @param targetBook, book name which you want to search as String
	 *
	 * @return book ID if the library system includes it.
	 */
	public abstract int searchBook(ArrayList<Book> bookList, String targetBook);
	
}