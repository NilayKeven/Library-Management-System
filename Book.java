/** 
 * Class that represents a     book in the library. Data field contains five informations
 * about the book. The class include methods that related to data field.
 *
 * @author Nilay Keven
 */
import java.util.*;

public class Book
{

	// Data Field

	/**
	 * Name of the book as String
	 */ 
	private String bookName;
	/**
	 * Name of the author as String
	 */ 
	private String authorName;
	/**
	 * ID of the book as Integer
	 */ 
	private int bookID;
	/**
	 * Status of the book like 'Avaible' or 'Busy' as Boolean
	 */ 
	private boolean status;
	/**
	 * ID of the person who borrow the book as Integer
	 */ 
	private int whoBorrows;
	/**
	 * Count the books as Integer
	 */ 
	public static int counter = 0;


	// Methods

	/**
	 * Constructor(Two parameters)
	 *
	 * Initialized a Book object with all properties specified.
	 * @param bName The book name as String
	 * @param aName The author name as String
	 */
	public Book(String bName, String aName)
	{
		bookName = bName;
		authorName = aName;
		status = true;
		whoBorrows = 0;
		counter++;
		bookID = counter;
	}
	/**
	 * Constructor(Five parameters)
	 *
	 * Initialized a Book object with all properties specified.
	 * @param bID, The book ID as Integer
	 * @param bName, The book name as String
	 * @param aName, The author name as String
	 * @param bStatus, The status of the book like 'Avaible' or 'Busy' as Boolean
	 * @param whoBorrows_, ID of the person which borrows the book as Integer
	 */
	public Book(int bID, String bName, String aName, boolean bStatus, int whoBorrows_)
	{
		bookName = bName;
		authorName = aName;
		status = bStatus;
		whoBorrows = whoBorrows_;
		counter++;
		bookID = counter;
	}
	/**
	 * Getter of the book name
	 *
	 * @return book name as String
	 */
	public String getBookName(){return bookName;}
	/**
	 * Getter of the author name
	 *
	 * @return author name as String
	 */
	public String getAuthorName(){return authorName;}
	/**
	 * Getter of the book ID
	 *
	 * @return book ID as Integer
	 */
	public int getBookID(){return bookID;}
	/**
	 * Getter of the book's status like 'Avaible' or 'Busy'
	 *
	 * @return Status of the book as Boolean
	 */
	public boolean getStatus(){return status;}
	/**
	 * Getter of the person ID who borrows the book
	 *
	 * @return ID of the person s Integer
	 */
	public int getWhoBorrows(){return whoBorrows;}
	/**
	 * Setter of the book's status
	 *
	 */
	public void setStatus()
	{
		if(status == true)
			status = false;
		else
			status = true;
	}
	/**
	 * Setter of the person ID who borrows the book
	 *
	 */
	public void setWhoBorrows(int uID)
	{
		whoBorrows = uID;
	}
	/**
	 * Print the file status of the book
	 *
	 * @return the book's status as String
	 */
	public String printStatus(){
		if(this.getStatus())
			return "AVAIBLE";
		return "BUSY";
	}

}