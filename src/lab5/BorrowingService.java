package lab5;

public class BorrowingService implements BorrowingServiceAPI{

	@Override
	public boolean borrowBook(Member member, Book book) {
		if (book != null && book.getIsAvailable() == true) {		
			book.setIsAvailable(false);
			member.getBorrowedBooks().add(book);
			return true;
		}
		return false;
	}

	@Override
	public boolean returnBook(Member member, Book book) {
		if (book != null && member.getBorrowedBooks().contains(book)) {
			member.getBorrowedBooks().remove(book);
			book.setIsAvailable(true);
			return true;
		}
		return false;
	}
}
