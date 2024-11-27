package lab5.tests;

import org.junit.jupiter.api.Test;

import lab5.Book;
import lab5.BorrowingService;
import lab5.Member;
import lab5.PaperBook;

class TestBorrowingService {

	BorrowingService service = new BorrowingService();
	Member george = new Member("George");
	Book book1 = new PaperBook("The Two Towers");
	
	@Test
	void BorrowingService() {
		// test creation
		
		
		// test return
		
	}

}
