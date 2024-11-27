package lab5.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.AudioBook;
import lab5.Book;
import lab5.EBook;
import lab5.Library;
import lab5.Member;
import lab5.PaperBook;


class TestAddRemoveMembers {
	
	private Library library;
	
	@BeforeEach
	void setUp() throws Exception {
		 this.library = new Library(); // empty library for each test
	}
	
	Member member1 = new Member("Dude");
	Member member2 = new Member("Gal");
	Book book1 = new PaperBook("Dune");
	Book book2 = new AudioBook("1984");
	Book book3 = new EBook("Moby Dick");
	
	@Test
	void AddMember() {
		
		assertEquals(library.membersCount(), 0, "Should be no members after initialization");	
		library.addMember(member1);	
		assertEquals(library.membersCount(), 1, "One member should have been added");	
		library.addMember(member2);
		assertEquals(library.membersCount(), 2, "Two members should have been added");	
		
	}
	
	@Test
	void RemoveMembersMember() {
		
		AddMember();
		assertEquals(library.membersCount(), 2, "Two members should have been in the library");
		library.removeMember(member2);
		assertEquals(library.membersCount(), 1, "Only one member should remain");
	}
	@Test
	void RemoveMemberString() {
		
		AddMember();
		assertEquals(library.membersCount(), 2, "Two members should have been in the library");
		library.removeMember("Dude");
		assertEquals(library.membersCount(), 1, "Only one member should remain");
	}

	@Test
	void RemoveMemberWithBooks() {
		
		AddMember();
		assertEquals(library.membersCount(), 2, "Two members should be in the library");
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		assertEquals(library.booksCount(), 3, "Three books should be in the library");
		
		member1.borrowBook(book1);
		member1.borrowBook(book2);
		member1.borrowBook(book3);
		assertEquals(member1.borrowedBooksCount(), 3, "Should be three borrowed books");
		assertFalse(book1.getIsAvailable(), "Book should be not available");
		assertFalse(book2.getIsAvailable(), "Book should be not available");
		assertFalse(book3.getIsAvailable(), "Book should be not available");
		
		library.removeMember(member1);
		assertEquals(library.membersCount(), 1, "Only one member should remain");
		assertEquals(library.booksCount(), 3, "Three books should be in the library");
		assertTrue(book1.getIsAvailable(), "Book should be available");
		assertTrue(book2.getIsAvailable(), "Book should be available");
		assertTrue(book3.getIsAvailable(), "Book should be available");
				
	}
}
