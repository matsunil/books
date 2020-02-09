package harvard.cscie57a.part1.books.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import harvard.cscie57a.part1.books.exception.BookDeletionException;
import harvard.cscie57a.part1.books.exception.ResourceNotFoundException;
import harvard.cscie57a.part1.books.model.Book;
import harvard.cscie57a.part1.books.service.BookService;


/**
 * API interface
 * 
 * TODO: Replace entities being returned with DTOs
 */
@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	/**
	 * Using @PathVariable
	 */
	@GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getBooks() {

		List<Book> books= bookService.findAllBooks();
		return new ResponseEntity<>(books, HttpStatus.OK);
	}

	/**
	 * Using @PathVariable
	 */
	@GetMapping(value = "/books/{bookId}")
	public ResponseEntity<?> getBookById(@PathVariable("bookId") Long bookId) {

		Book book;
		try {
			book = bookService.findBookById(bookId);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	/**
	 * Example PUT
	 */
	@PutMapping(value = "/books")
	public ResponseEntity<?> updateBook(@RequestBody Book book) {
		logger.info("Updating book with: {}", book);
		// STUB service method to update book
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	/**
	 * Example POST
	 */
	@PostMapping(value = "/books")
	public ResponseEntity<?> addNewBook(@RequestBody Book book) {
		return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
	}

	/**
	 * Example DELETE
	 */
	@DeleteMapping(value = "/books/{bookId}")
	public ResponseEntity<?> deleteBook(@PathVariable("bookId") Long bookId) {
		try {
			bookService.deleteBook(bookId);
		} catch (BookDeletionException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
