package lab5.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import lab5.AudioBook;
import lab5.AudioBookCreator;
import lab5.Book;
import lab5.BookFactory;
import lab5.EBook;
import lab5.EBookCreator;
import lab5.PaperBook;
import lab5.PaperBookCreator;

public class TestBookFactory {
	
	
	
	
	@Test
	public void TestPaperBook() {
		BookFactory paperBook = new PaperBookCreator();
		Book book = paperBook.createBook("The Order Of the Pheonix");
		
		assertTrue(book instanceof PaperBook);
	}
	@Test
	public void TestEBook() {
		BookFactory EBook = new EBookCreator();
		Book book = EBook.createBook("The Order Of the Pheonix");
		
		assertTrue(book instanceof EBook);
	}
	@Test
	public void TestAudioBook() {
		BookFactory AudioBook = new AudioBookCreator();
		Book book = AudioBook.createBook("The Order Of the Pheonix");
		
		assertTrue(book instanceof AudioBook);
	}
}
