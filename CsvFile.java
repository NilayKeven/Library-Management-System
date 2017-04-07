import java.io.*;
import java.util.*;
/** 
 * Class that represents a CSV files which one of them includes all users' informations (user list)  
 * and the other includes all the books' infomation in the library. It has some methods like 
 * reading from the file or writing to file.
 *
 * @author Nilay Keven
 */

public class CsvFile
{
	// Data Field

	/**
	 * Name of the user list as String
	 */ 
	private static String userListFN;
	/**
	 * Name of the book list as String
	 */
	private static String bookListFN;
	/**
	 * Delimit the interrelated informations
	 */
	private static String delimiter;
	/**
	 * Separate the same type object
	 */
	private static String separator;

	/**
	 * Constructor
	 *
	 * Initialized a CSV File object with all properties specified.
	 */
	public CsvFile()
	{
		userListFN = "userList.csv";
		bookListFN = "bookList.csv";
		delimiter = ",";
		separator = "\n";
	}
	/**
	 * Getter of the file name which includes users' informations
	 *
	 * @return user file name as String
	 */
	public String getUserListFN(){return userListFN;}
	/**
	 * Getter of the file name which includes books' informations
	 *
	 * @return book file name as String
	 */
	public String getBookListFN(){return bookListFN;}
	/**
	 * It takes a array list which is related to users and then write a CSV file all 
	 * informations about the users.
	 * @param userList, A list includes users and them informations.
	 */
	public void writeUserList(ArrayList<LibraryUsers> userList)
	{
		String fileHeader = "ID, FIRSTNAME, LASTNAME, PASSWORD";
		FileWriter fileWriter = null;
		try{
			fileWriter = new FileWriter(userListFN);
			fileWriter.append(fileHeader);
			fileWriter.append(separator);

			for (LibraryUsers user : userList) 
			{
				fileWriter.append(String.valueOf(user.getPersonID()));
				fileWriter.append(delimiter);
				fileWriter.append(user.getFirstName());
				fileWriter.append(delimiter);
				fileWriter.append(user.getSecondName());
				fileWriter.append(delimiter);
				fileWriter.append(user.getPassword());
				fileWriter.append(separator);
			}
		}
		catch(Exception e){
			System.err.println("EROR: USER LIST WAS NOT WRITTEN IN FILE !");
			e.printStackTrace();
		}
		finally{
			try{
				fileWriter.close();
			}
			catch(IOException e){
				System.err.println("EROR: USERLIST FILE COULD NOT CLOSE !");
				e.printStackTrace();
			}
		}
	}
	/**
	 * It takes a array list which is related to books. Then it writes a CSV file all 
	 * informations about the books in the list.
	 * @param bookList, A list includes books and them informations.
	 */
	public void writeBookList(ArrayList<Book> bookList)
	{
		String fileHeader = "BOOK ID, BOOK NAME, AUTHOR NAME, STATUS, WHO BARROWS";
		FileWriter fileWriter = null;
		try{
			fileWriter = new FileWriter(bookListFN);
			fileWriter.append(fileHeader);
			fileWriter.append(separator);

			for (Book books : bookList) 
			{
				fileWriter.append(String.valueOf(books.getBookID()));
				fileWriter.append(delimiter);
				fileWriter.append(books.getBookName());
				fileWriter.append(delimiter);
				fileWriter.append(books.getAuthorName());
				fileWriter.append(delimiter);
				fileWriter.append(books.printStatus());
				fileWriter.append(delimiter);
				fileWriter.append(String.valueOf(books.getWhoBorrows()));
				fileWriter.append(separator);
				
			}
		}
		catch(Exception e){
			System.err.println("EROR: BOOK LIST WAS NOT WRITTEN IN FILE !");
			e.printStackTrace();
		}
		finally{
			try{
				fileWriter.flush();
				fileWriter.close();
			}
			catch(IOException e){
				System.err.println("EROR: BOOKLIST FILE COULD NOT CLOSE !");
				e.printStackTrace();
			}
		}
	}
	/**
	 * Read a CSV file which includes all the informations about the users. Then it takes a array list
	 * which is related to users. Then it fills the array list with the informations.
	 * @param userList, A list includes users and them informations.
	 */
	public void readUserList(ArrayList<LibraryUsers> userList)
	{
		int idIndex = 0, fNameIndex = 1, lNameIndex = 2, paswordIndex = 3;
		BufferedReader fileReader = null;

		try{
			fileReader = new BufferedReader(new FileReader(userListFN));
			String line;
			fileReader.readLine();
		
			while((line=fileReader.readLine()) != null)
			{
				String[] tokens = line.split(delimiter);
				LibraryUsers user = new LibraryUsers(tokens[fNameIndex], tokens[lNameIndex], Integer.parseInt(tokens[idIndex]), tokens[paswordIndex]);
				userList.add(user);
			}

		}
		catch(Exception e){
			System.err.println("EROR: USERLIST WAS NOT READ IN FILE !");
			e.printStackTrace();
		}
		finally{
			try{
				fileReader.close();
			}
			catch(IOException e){
				System.err.println("EROR: USERLIST FILE COULD NOT CLOSE !");
				e.printStackTrace();
			}
		}
	}
	/**
	 * Read a CSV file which includes all the informations about the books. Then it takes a array list
	 * which is related to books. Then it fills the array list with the informations.
	 * @param bookList, A list includes books and them informations.
	 */
	public void readBookList(ArrayList<Book> bookList)
	{
		int idIndex = 0, bNameIndex = 1, aNameIndex = 2, statusIndex = 3, whoBorrowsIndex = 4;
		BufferedReader fileReader = null;
		boolean status = true;

		try{
			fileReader = new BufferedReader(new FileReader(bookListFN));
			String line;
			fileReader.readLine();
		
			while((line=fileReader.readLine()) != null)
			{
				String[] tokens = line.split(delimiter);

				if(tokens[statusIndex] != "AVAIBLE")
					status = false;

				Book book_ = new Book(Integer.parseInt(tokens[idIndex]), tokens[bNameIndex], tokens[aNameIndex], status, Integer.parseInt(tokens[whoBorrowsIndex]));
				bookList.add(book_);
			}

		}
		catch(Exception e){
			System.err.println("EROR: BOOKLIST WAS NOT READ IN FILE !");
			e.printStackTrace();
		}
		finally{
			try{
				fileReader.close();
			}
			catch(IOException e){
				System.err.println("EROR: BOOKLIST FILE COULD NOT CLOSE !");
				e.printStackTrace();
			}
		}
	}
}