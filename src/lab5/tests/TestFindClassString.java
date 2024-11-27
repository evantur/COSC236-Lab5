package lab5.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.Book;
import lab5.EBook;
import lab5.Library;
import lab5.Member;
import lab5.PaperBook;
import lab5.AudioBook;


class TestFindClassString {

	
private Library library;
	
	@BeforeEach
	void setUp() throws Exception {
		 this.library = new Library(); // empty library for each test
	}
	
	Member member1 = new Member("Dude");
	Member member2 = new Member("Gal");
	Book book1 = new EBook("Dune");
	Book book2 = new PaperBook("1984");
	Book book3 = new AudioBook("Moby Dick");

	@Test
	void FindMember() {
		library.addMember(member1);
		library.addMember(member2);
		Member member = library.findMemberByName(member1.getName());
		assertEquals(member, member1, "Found member doesn't match");
		assertEquals(library.membersCount(), 2, "There should be two members");
		library.removeMember(member2);
		assertEquals(library.membersCount(), 1, "There should be only one member remain");
		member = library.findMemberByName(member2.getName());
		assertNull(member, "The member should not have been found after removal from the library");
		library.removeMember(member2);
		assertEquals(library.membersCount(),  1, "Removal of a non-existent member should not affect library");
		library.removeMember(member1);
		assertEquals(library.membersCount(), 0, "All members should have been removed");
	}

	@Test
	void FindBook() {
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		
		Book book = library.findBookByTitle(book1.getTitle());//book 1 by title
		assert(book == book1);
		assert(library.booksCount() == 3);// 3  where populated
		library.removeBook(book2);// remove book 2
		assert(library.booksCount() == 2);//we should have 2
		book = library.findBookByTitle(book2.getTitle());//book 2 by title, but its not there
		assert(book == null);//Didn't find it
		library.removeBook(book2);//remove non existent book
		assert(library.booksCount() == 2);//we should have 2
		library.removeBook(book1);// remove book 1
		assert(library.booksCount() == 1);
		library.removeBook(book3);// remove book 3
		assert(library.booksCount() == 0);
	}
}
