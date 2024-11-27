package lab5;

import java.util.ArrayList;
import java.util.Iterator;

public class Member {

	private String name;
	private ArrayList<Book> borrowedBooks; // Book class dependency
	private BorrowingService borrowingService;
	
	public Member(String name) {
		this.name = name;
		this.borrowedBooks = new ArrayList<>();
		this.borrowingService = BorrowingService.getInstance();
	}
	public String getName() {
		return name;
	}
	public ArrayList<Book> getBorrowedBooks() { 
		return borrowedBooks;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "Member: " + name;
	}		
	
	public void borrowBook(Book book) {		
		boolean success = borrowingService.borrowBook(this, book); 
		if(success) {
			System.out.println(name + "has borrowed" + book.getTitle());
		} else {
			System.out.println("The book" + book.getTitle() + "is unavailable.");
		}
	}
	
	public void returnBook(Book book) {
		BorrowingService borrowingService = new BorrowingService();
		boolean success = borrowingService.returnBook(this, book);
		if (success) {
			System.out.println(name + " has returned " + book.getTitle());
		}
		else {
			System.out.println(name + " could not return " + book.getTitle());
		}
	}
	public void listBorrowedBooks() {
		for (Book book : borrowedBooks)
			System.out.println(book); // book.toString()
	}
	public int borrowedBooksCount() {
		return borrowedBooks.size();
	}
	public void returnAllBooks() {
		Iterator<Book> bookIterator = borrowedBooks.iterator();
	    while(bookIterator.hasNext()) {
		   	 Book book = bookIterator.next();
		   	 book.setIsAvailable(true);
	    }
	    borrowedBooks.clear(); // clear array of borrowed books
	}
}
