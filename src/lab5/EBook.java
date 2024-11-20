package lab5;

public class EBook implements Book{

	private String title;
	private Boolean isAvailable;

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		this.title = title;
	}

	@Override
	public void setIsAvailable(boolean isAvailable) {
		// TODO Auto-generated method stub
		this.isAvailable = isAvailable;
	}

	@Override
	public boolean getIsAvailable() {
		// TODO Auto-generated method stub
		return false;
	}

}
