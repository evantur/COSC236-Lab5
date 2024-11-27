package lab5;

public class AudioBookCreator implements BookFactory {
	public Book createBook(String name){
		return new AudioBook(name);
	}
}
