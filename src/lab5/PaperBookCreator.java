package lab5;

public class PaperBookCreator implements BookFactory {
	public Book createBook(String name){
		return new PaperBook(name);
	}
}
