package lab5;

public class AudioBook implements Book{

	private String title;
	private Boolean isAvailable;

	public AudioBook(String title) {
		this.title = title;
		this.isAvailable = true;
	}
	@Override
	public String getTitle() {
		return title;
	}
	@Override
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "AudioBook: " + title;
	}
	@Override
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	@Override
	public boolean getIsAvailable() {
		return isAvailable;
	}

}
