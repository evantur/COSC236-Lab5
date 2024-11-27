package lab5;

public class BorrowingBookResult {
	boolean isSuccess;
	String borrowingMessage;
	
	public BorrowingBookResult(boolean isSuccess, String borrowingMessage) {
		this.isSuccess = isSuccess;
		this.borrowingMessage = borrowingMessage;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getBorrowingMessage() {
		return borrowingMessage;
	}
	public void setBorrowingMessage(String borrowingMessage) {
		this.borrowingMessage = borrowingMessage;
	}
	
}
