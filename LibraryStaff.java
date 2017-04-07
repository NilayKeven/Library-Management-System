import java.util.*;

/** 
 * Class that represents a library staff. It has methods like searching, adding and removing books
 * also adding a new user. Otherwise another method check the staff's password to login the 
 * system.
 *
 * @author Nilay Keven
 */

public class LibraryStaff extends Person
{
	/**
	 * Constructor
	 *
	 * Initialized a library staff object with all properties specified.
	 * @param sFirstName, The staff's first name as String
	 * @param sSecondName, The staff's second name as String
	 * @param sID, The staff's ID as Integer
	 * @param sPassword, The staff password as String
	 */
	public LibraryStaff(String sFirstName, String sSecondName, int sID, String sPassword)
	{
		super(sFirstName,sSecondName,sID,sPassword);
	}
	/**
	 * Search a book which is given the name in the list which includes all the books.
	 * @param bookList, The list includes all book in the library.
	 * @param targetBook, Name of the book was searched.
	 * 
	 * @return Book ID or Person ID or -1(its depends on the book's status)
	 */
	public int searchBook(ArrayList<Book> bookList, String targetBook)
	{
		for (Book target : bookList) 
		{
			if(target.getBookName().equals(targetBook) && target.getStatus() == true){
				System.out.println("BOOK ID WHICH YOU WANT IS: " + target.getBookID());
				return target.getBookID();
			}
			else if(target.getBookName().equals(targetBook) && target.getStatus() == false){
				System.out.println("BOOK WHICH YOU WANT WAS BORROWED BY : " + target.getWhoBorrows());
				return target.getWhoBorrows();
			}
		}
		return -1;
	}
	/**
	 * Add a new book in the list which includes all the books. It want the book's information
	 * from the staff.
	 * @param bookList, The list includes all book in the library.
	 */
	public void addBook(ArrayList<Book> bookList)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("PLEASE ENTER BOOK AND AUTHOR NAME TO ADD.");

		System.out.print("BOOK NAME: ");
		String bName = input.next();
		System.out.print("AUTHOR NAME: ");
		String aName = input.next();

		Book newBook = new Book(bName, aName);
		bookList.add(newBook);
		System.out.println("BOOK WAS ADDED IN LIBRARY SUCCESSFULLY.");
	}
	/**
	 * Remove a book in the list which includes all the books if the books is in the library.
	 * @param bookList, The list includes all book in the library.
	 */
	public void removeBook(ArrayList<Book> bookList)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("PLEASE ENTER BOOK AND AUTHOR NAME TO REMOVE.");
		System.out.print("BOOK NAME: ");
		String bName = input.next();
		System.out.print("AUTHOR NAME: ");
		String aName = input.next();
		
		int targetbookID = searchBook(bookList, bName);
		int index = -1;

		if (targetbookID != -1) 
		{
			for (int i = 0; i < bookList.size(); ++i) 
			{
				if(bookList.get(i).getBookID() == targetbookID)
					index = i;
			}
		}
		if(index != -1){
			bookList.remove(index);
			System.out.println("REMOVED.");
		}
		else
			System.out.println("THIS BOOK IS NOT EXIST IN THE LIBRARY.");
	}
	/**
	 * Add a new user in the list which includes all the users.
	 * Check the all IDs in the list because ID is unique. If any match-up, the staff can enrol the new user.
	 * @param userList, The list includes all user in the library.
	 */
	public void addUser(ArrayList<LibraryUsers> userList)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("ENTER THE INFORMATIONS ABOUT PERSON WHO DO YOU WANT TO ADD.");

		System.out.print("FIRST NAME: ");
		String fName = input.next();

		System.out.print("SECOND NAME: ");
		String sName = input.next();

		System.out.print("ID: ");
		int id = input.nextInt();

		System.out.print("PASSWORD: ");
		String password = input.next();

		boolean flag = true;
		for(int i = 0; i < userList.size() && flag == true; ++i)
		{
			if(userList.get(i).getPersonID() == id){
				System.err.println("SYSTEM INCLUDE A USER WHO HAS SAME ID.");
				flag = false;
			}
		}
		if(flag == true){
			LibraryUsers newMember = new LibraryUsers(fName, sName, id, password);
			userList.add(newMember);
			System.err.println("ADDITION IS SUCCESSFUL.");
		}
	} 
	/**
	 * When the staff want to login the system, this method want a password from the staff.
	 * If password is true, he/she can login the system.
	 */
	public void checkinStaff()
	{
		Scanner input = new Scanner(System.in);
		boolean control = false;
		int i = 0;

		System.out.println("PLEASE ENTER PASSWORD.");
		while(control == false && i < 3)
		{
			System.out.print("PASSWORD: ");
			String staffID = input.next();
			if(staffID.equals(this.getPassword()))
			{
				control = true;
				System.out.println("LOGIN SUCCESSFUL!");
			}
			else
				System.err.println("INVALID PERSON ID AND PASSWORD COMBINATION !");
			i++;
		}
		if(control == false)
		{
			System.err.println("WRONG COMBINATIONS WERE ENTERED MANY TIMES!");
			System.exit(0);
		}
	}

}
