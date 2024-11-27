package lab5;

public class EBookCreator implements BookFactory {
	public Book createBook(String name){
		return new EBook(name);
	}
}
