package lab5;

public class BorrowingService implements BorrowingServiceAPI{

	@Override
	public BorrowingBookResult borrowBook(Member member, Book book) {
		BorrowingBookResult result = new BorrowingBookResult(true, "Borrowing book: " + book);
		if (book != null && book.getIsAvailable() == true) {		
			book.setIsAvailable(false);
			member.getBorrowedBooks().add(book);
			return result;
		} else {
			result.setSuccess(false);
			result.setBorrowingMessage("Could not borrow book: " + book);
			return result;
		}
	}

	@Override
	public BorrowingBookResult returnBook(Member member, Book book) {
		BorrowingBookResult result = new BorrowingBookResult(true, "Borrowed book: " + book + "is returned.");
		if (book != null && member.getBorrowedBooks().contains(book)) {
			member.getBorrowedBooks().remove(book);
			book.setIsAvailable(true);
			System.out.println("Returning book: " + book);
			return result;
		} else {
			result.setBorrowingMessage("Cannot return book: " + book);
			result.setSuccess(false);
			return result;
			
		}
	}
}
 