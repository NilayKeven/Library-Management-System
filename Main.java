import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		System.out.println("*******************************************************************************");
		System.out.println("*                       WELCOME TO THE GTU's LIBRARY                          *");
		System.out.println("*******************************************************************************");

		System.out.println("PRES 'U' TO LOGIN AS A LIBRARY USER or PRESS 'S' TO LOGIN AS A LIBRARY STAFF." );
		

		ArrayList<Book> bookList = new ArrayList<Book>();
		ArrayList<LibraryUsers> userList = new ArrayList<LibraryUsers>();
		CsvFile file = new CsvFile();
		file.readUserList(userList);
		file.readBookList(bookList);

		LibraryStaff staff = new LibraryStaff("Nilay","Keven", 1, "boss");
		LibraryUsers user = new LibraryUsers("N","K", 1, "1");
		userList.add(user);

		Scanner input = new Scanner(System.in);
		
		char choice;
		choice = input.next().charAt(0);

		if(choice == 'U' || choice == 'u')
		{
			boolean flag = false;
			user.checkinUsers(userList);
			
			do
			{
				System.out.println("CHOICE ONE OPTION ACCORDING TO WISHES");
				System.out.println("1- SEARCH BOOK");
				System.out.println("2- BORROW BOOK");
				System.out.println("3- RETURN BOOK");

				int choice2 = input.nextInt();

				if(choice2 == 1)
				{
					System.out.print("ENTER A BOOK NAME WHICH YOU WANT: ");
					String targetBook = input.next();

					int result = user.searchBook(bookList, targetBook);

					if(result != -1)
						System.out.println("BOOK ID WHICH YOU WANT IS: " + result);
					else
						System.out.println(targetBook + " IS NOT EXIST IN LIBRARY.");

					flag = continueOrNot(userList, bookList);
				}
				else if(choice2 == 2)
				{
					user.borrowBook(bookList);
					flag = continueOrNot(userList, bookList);
				}
				else if(choice2 == 3)
				{
					user.returnBook(bookList);
					flag = continueOrNot(userList, bookList);
				}
				else
				{
					System.err.println("WRONG INPUT. TRY AGAIN OR EXIT !");
					flag = continueOrNot(userList, bookList);
				}
			}while(flag == true);

		}
		else if(choice == 'S' || choice == 's')
		{
			staff.checkinStaff();
			boolean flag = false;
			do
			{
				System.out.println("CHOICE ONE OPTION ACCORDING TO WISHES");
				System.out.println("1- SEARCH BOOK");
				System.out.println("2- ADD BOOK");
				System.out.println("3- REMOVE BOOK");
				System.out.println("4- ADD USER");

				int choice3 = input.nextInt();
				if(choice3 == 1)
				{
					System.out.print("ENTER A BOOK NAME WHICH YOU WANT: ");
					String targetBook = input.next();

					int result = staff.searchBook(bookList, targetBook);
					if (result == -1)
						System.out.println(targetBook + " IS NOT EXIST IN LIBRARY.");
					flag = continueOrNot(userList, bookList);
				}
				else if(choice3 == 2)
				{
					staff.addBook(bookList);
					flag = continueOrNot(userList, bookList);
				}
				else if(choice3 == 3)
				{
					staff.removeBook(bookList);
					flag = continueOrNot(userList, bookList);
				}
				else if(choice3 == 4)
				{
					staff.addUser(userList);
					flag = continueOrNot(userList, bookList);
				}
				else
				{
					System.err.println("WRONG INPUT. TRY AGAIN OR EXIT !");
					flag = continueOrNot(userList, bookList);
				}
			}
			while(flag == true);
		}
		else
		{
			System.out.println("INVALID INPUT!");
			continueOrNot(userList, bookList);
		}
	}
	public static boolean continueOrNot(ArrayList<LibraryUsers> userList, ArrayList<Book> booklist)
	{
		CsvFile csvFile = new CsvFile();
		System.out.println("DO YOU WANT CONTINUE OR NOT? Y / N");

		Scanner input = new Scanner(System.in);
		char choice = input.next().charAt(0);

		if(choice == 'Y' || choice == 'y')
			return true;
		else if(choice == 'N' || choice == 'n'){
			csvFile.writeUserList(userList);
			csvFile.writeBookList(booklist);
			System.exit(0);
		}
		else{
			System.out.println("WRONG INPUT!");
		}
		return false;
	}
}