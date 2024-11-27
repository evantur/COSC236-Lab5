package lab5;

public interface BorrowingServiceAPI {
	
	// 2 methods to manage Member's books
	public boolean borrowBook(Member member, Book book);
	
	public boolean returnBook(Member member, Book book);
	
}
