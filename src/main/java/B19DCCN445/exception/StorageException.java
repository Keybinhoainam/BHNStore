package B19DCCN445.exception;

public class StorageException extends Exception{

	public StorageException(String message) {
		super(message);
	}

	public StorageException(String message, Exception e) {
		super(message);
	}

}
