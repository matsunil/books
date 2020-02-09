package harvard.cscie57a.part1.books.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BookDeletionException extends RuntimeException {

	private static final long serialVersionUID = 8338223623037375144L;

	public BookDeletionException() {
		super();
	}

	public BookDeletionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BookDeletionException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookDeletionException(String message) {
		super(message);
	}

	public BookDeletionException(Throwable cause) {
		super(cause);
	}

}
