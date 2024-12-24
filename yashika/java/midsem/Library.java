import java.util.Scanner;

class Book
{
	private String title;
	private String author;
	private String isbn;

	public Book(String title, String author, String isbn)
	{
		this.title=title;
		this.author=author;
		this.isbn=isbn;
	}

	public String getTitle()
	{
		return title;
	}

	public String getAuthor()
	{
		return author;
	}

	public String getIsbn()
	{
		return isbn;
	}

	public void displayBookDetails()
	{
		System,out.println("Title "+title+", Author "+author+", ISBN "+isbn);
	}

}


public class LibrarySystem
{
	private Book books[];
	private int count;

	public LibrarySystem(int size)
	{
		books=new Book[size];
		count=0;
	}

	public void addBook(String title, String author, String isbn)
	{
		if (count<books.length)
		{
			books[count++]=new Book(title,author,isbn);
		}
		else{
			System.out.println("Library is full. Cannot add more books");
		}
	}

	public void displayAllBooks()
	{
		for (int i=0;i<count;i++)
		{
			books[i].displayBookDetails();
		}
	}

	public void searchByPartialTitle(String partialTitle)
	{
		boolean found=false;
		for (int i=0; i<count; i++)
		{
			if (books[i].getTitle().toLowerCase().contains(partialTitle.toLowerCase()))
			{
				books[i].displayBookDetails();
				found=true;
			}
		}

		if(!found)
		{
			System.out.println("No book found with the given partial title");
		}
	}
}

public class Library
{
	Scanner in=new Scanner(System.in);
	LibrarySystem lib=new LibrarySystem(5);

	for(int i=-;i<5;i++)
	{
		System.out.println("Enter details for book "+(i+1));
		System.out.println("title ");
		String title=in.nextLine();
		System.out.println("author ");
		String author=in.nextLine();
		System.out.println("ISBN ");
		String isbn=in.nextLine();
		lib.addBook(title,author,isbn);

		System.out.println("\nDisplaying all book details:");
		lib.displayAllBooks();
		System.out.print("\nEnter a partial title to search: ");
		String partialTitle = in.nextLine();
		lib.searchByPartialTitle(partialTitle);
		in.close();
	}
}
















































