package harvard.cscie57a.part1.books.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ReviewDeletionException extends RuntimeException {

	private static final long serialVersionUID = -2063995694856891780L;

	public ReviewDeletionException() {
		super();
	}

	public ReviewDeletionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ReviewDeletionException(String message, Throwable cause) {
		super(message, cause);
	}

	public ReviewDeletionException(String message) {
		super(message);
	}

	public ReviewDeletionException(Throwable cause) {
		super(cause);
	}

}
