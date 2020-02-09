package harvard.cscie57a.part1.books.controller;

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

import harvard.cscie57a.part1.books.exception.ResourceNotFoundException;
import harvard.cscie57a.part1.books.model.Book;
import harvard.cscie57a.part1.books.service.BookService;


/**
 * API interface
 * 
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
		logger.info("Getting all books");
		return new ResponseEntity<>(bookService.findAllBooks(), HttpStatus.OK);
	}

	/**
	 * Using @PathVariable
	 * @throws ResourceNotFoundException 
	 */
	@GetMapping(value = "/books/{bookId}")
	public ResponseEntity<?> getBookById(@PathVariable("bookId") Long bookId) throws ResourceNotFoundException {
		logger.info("Getting book with: {}", bookId);
		return new ResponseEntity<>(bookService.findBookById(bookId), HttpStatus.OK);
	}

	/**
	 * Example POST
	 */
	@PostMapping(value = "/books")
	public ResponseEntity<?> addNewBook(@RequestBody Book book) {
		logger.info("Adding book with: {}", book);
		return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
	}

	/**
	 * Example PUT
	 */
	@PutMapping(value = "/books/{bookId}")
	public ResponseEntity<?> updateBook(@RequestBody Book book) {
		logger.info("Updating book with: {}", book);
		return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.OK);
	}

	/**
	 * DELETE
	 */
	@DeleteMapping(value = "/books/{bookId}")
	public ResponseEntity<?> deleteBook(@PathVariable("bookId") Long bookId) {
		logger.info("Deleting book with: {}", bookId);
		bookService.deleteBook(bookId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
