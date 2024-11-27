package lab5;

public class BorrowingService implements BorrowingServiceAPI{

	private static BorrowingService instance;
	private int borrowingLimit;
	private BorrowingService() {
		borrowingLimit = 3;
	}
	
	@Override
	public boolean borrowBook(Member member, Book book) {
		if (book != null && book.getIsAvailable() == true) {		
			book.setIsAvailable(false);
			member.getBorrowedBooks().add(book);
			System.out.println(member.getName() + " is borrowing book: " + book.getTitle());
			return true;
		}
		System.out.println(member.getName() + " could not borrow book: " + book.getTitle());
		return false;
	}

	@Override
	public boolean returnBook(Member member, Book book) {
		if (book != null && member.getBorrowedBooks().contains(book)) {
			member.getBorrowedBooks().remove(book);
			book.setIsAvailable(true);
			System.out.println(member.getName() + " is returning book: " + book);
			return true;
		}
		System.out.println(member.getName() + " could not return book: " + book.getTitle());
		return false;
	}
}
 