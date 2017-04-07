import java.util.*;
/** 
 * Class that represents a library user. It has methods like searching, borrowing and returning books
 * Otherwise another method check the user's ID and password to login the system.
 *
 * @author Nilay Keven
 */
public class LibraryUsers extends Person
{
	/**
	 * Constructor
	 *
	 * Initialized a library user object with all properties specified.
	 * @param sFirstName, The staff's first name as String
	 * @param sSecondName, The staff's second name as String
	 * @param sID, The staff's ID as Integer
	 * @param sPassword, The staff password as String
	 */
	public LibraryUsers(String sFirstName, String sSecondName, int sID, String sPassword)
	{
		super(sFirstName,sSecondName,sID,sPassword);
	}
	/**
	 * Borrow the book. The methods want a book ID from the user. If the book status 
	 * is 'Avaible', the user can borrow it.
	 * @param bookList, The staff's first name as String
	 */
	public void borrowBook(ArrayList<Book> bookList)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("ENTER BOOK ID WHICH YOU WANT TO BORROW: ");
		int targetID = input.nextInt();

		for (Book target : bookList) 
		{
			if(target.getBookID() == targetID)
			{
				if(target.getStatus() == true)
				{
					System.out.println("OPERATION OF BORROWING IS SUCCESSFUL.");
					target.setStatus();
					target.setWhoBorrows(this.getPersonID());
				}
				else{
					System.err.println("OPERATION IS UNSUCCESSFUL.");
					System.err.println("THIS BOOK WAS BORROWED BY ANOTHER USER.");
				} 
			}
		}
	}
	/**
	 * Borrow the book. The methods want a book ID from the user. If the book status 
	 * is 'Avaible', the user can borrow it.
	 * @param bookList, The staff's first name as String
	 */
	public void returnBook(ArrayList<Book> bookList)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("ENTER BOOK ID WHICH YOU WANT TO RETURN: ");
		int bID = input.nextInt();
		
		for (Book target : bookList) 
		{
			if(target.getBookID() == bID)
			{
				if(target.getStatus() == false && target.getWhoBorrows() == this.getPersonID())
				{
					System.out.println("OPERATION OF RETURNING BOOK SUCCESSFUL.");
					target.setStatus();
				}
				else if(target.getStatus() == false && target.getWhoBorrows() != this.getPersonID())
				{
					System.err.println("OPERATION IS UNSUCCESSFUL.");
					System.err.println("YOU ARE NOT BORROWER FOR THIS BOOK!");
				}
				else
					System.err.println("THIS BOOK IS NOT BORROWED BY SOMEONE.");
			}
		}
	}
	/**
	 * Search a book which is given the name in the list which includes all the books.
	 * @param bookList, The list includes all book in the library.
	 * @param targetBook, Name of the book was searched.
	 * 
	 * @return Book ID or -1(If the book was not exist in the library return -1)
	 */
	public int searchBook(ArrayList<Book> bookList, String targetBook)
	{
		for (int i = 0; i < bookList.size(); ++i) 
		{
			if(bookList.get(i).getBookName().equals(targetBook))
				return bookList.get(i).getBookID();
		}
		return -1;
	}
	/**
	 * When the user want to login the system, this method wants a password and ID from the user.
	 * Firstly user ID is searched in the user if it is exist. Then the password is controled.
	 * If ID and password combination is true, he/she can login the system.
	 */
	public void checkinUsers(ArrayList<LibraryUsers> userList)
	{
		Scanner input = new Scanner(System.in);
		boolean control = false, flag = false;
		int j = 0;

		System.out.println("PLEASE ENTER YOUR ID AND PASSWORD.");
		while(control == false && j < 3)
		{
			System.out.print("ID: ");
			int targetID = input.nextInt();

			System.out.print("PASSWORD: ");
			String targetPword = input.next();

			for (int i = 0; i < userList.size(); ++i) 
			{
				if(userList.get(i).getPersonID() == targetID && userList.get(i).getPassword().equals(targetPword)){
						System.out.println("LOGIN SUCCESSFUL!");
						control = true;
						flag = true;
				}
			}
			if(flag != true)
				System.err.println("INVALID PERSON ID AND PASSWORD COMBINATION !");
			++j;
		}
		if(control == false)
		{
			System.err.println("WRONG COMBINATIONS WERE ENTERED MANY TIMES!");
			System.exit(0);
		}
	}
}
