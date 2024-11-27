package lab5.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.Book;
import lab5.BorrowingService;
import lab5.Member;
import lab5.PaperBook;

class TestBorrowingService {

	BorrowingService service;
	Member george;
	Book book1;
	
	@BeforeEach
	void setUp() {
		service = BorrowingService.getInstance();
		george = new Member("George");
		book1 = new PaperBook("The Two Towers");
	}
	
	@Test
	void BorrowingServiceSuccessfulBorrow() {
		// test successful borrow
		assertTrue(service.borrowBook(george, book1).isSuccess());					
	}
	
	@Test
	void BorrowingServiceBorrowFailure() {
		service.borrowBook(george, book1);
		assertFalse(service.borrowBook(george, book1).isSuccess());
	}
	
	@Test
	void BorrowingServiceSuccessfulReturn() {
		service.borrowBook(george, book1);
		assertTrue(george.getBorrowedBooks().contains(book1));
		service.returnBook(george, book1);
		assertFalse(george.getBorrowedBooks().contains(book1));
	}
	
	@Test
	void BorrowingServiceReturnFailure() {
		assertFalse(george.getBorrowedBooks().contains(book1));
	}

}
