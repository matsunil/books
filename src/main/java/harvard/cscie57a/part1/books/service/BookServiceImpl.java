package harvard.cscie57a.part1.books.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import harvard.cscie57a.part1.books.exception.BookDeletionException;
import harvard.cscie57a.part1.books.exception.ResourceNotFoundException;
import harvard.cscie57a.part1.books.model.Book;
import harvard.cscie57a.part1.books.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book findBookById(Long bookId) throws ResourceNotFoundException {
		Optional<Book> book = bookRepository.findById(bookId);
		if (book.isPresent()) {
			logger.info("Found book with id: {}", bookId);
			return book.get();
		}

		throw new ResourceNotFoundException("No book found with id="+bookId);
	}

	@Override
	public Book saveBook(Book book) {
		book.setId(null); //book id set by sequence
		return bookRepository.save(book);
	}

	@Override
	public Book updateBook(Long bookId, Book bookRequest) throws ResourceNotFoundException {
		Optional<Book> optionalBook = bookRepository.findById(bookId);
		if (optionalBook.isPresent()) {
			logger.info("Found book with id: {}", bookId);

			Book book = optionalBook.get();
			book.setTitle(bookRequest.getTitle());
			book.setAuthor(bookRequest.getAuthor());
			book.setPublisher(bookRequest.getPublisher());

			return bookRepository.save(book);
		}

		throw new ResourceNotFoundException("No book found with id="+bookId);
	}

	@Override
	public void deleteBook(Long bookId) throws BookDeletionException {
		if (bookRepository.existsById(bookId)) {
			logger.info("Found book with id: {}", bookId);
			bookRepository.deleteById(bookId);
		} else {
			throw new BookDeletionException("No book found with id="+bookId);
		}
	}

}
